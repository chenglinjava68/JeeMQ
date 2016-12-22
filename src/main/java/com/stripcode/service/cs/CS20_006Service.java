package com.stripcode.service.cs;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.github.pagehelper.StringUtil;
import com.stripcode.core.util.PageSortUtil;
import com.stripcode.core.util.UUIDUtils;
import com.stripcode.core.util.WebUtil;
import com.stripcode.core.util.excel.ExcelDocument;
import com.stripcode.core.util.excel.ExcelExporter;
import com.stripcode.core.util.excel.ExcelHeader;
import com.stripcode.mybatis.cp.dao.CpMarketInfoMapper;
import com.stripcode.mybatis.cp.model.CpMarketInfo;
import com.stripcode.mybatis.cs.dao.CSCustomerInfoMapper;
import com.stripcode.mybatis.cs.dao.CSMarketAOaddMapper;
import com.stripcode.mybatis.cs.dao.TCsTaskCompletionMapper;
import com.stripcode.mybatis.cs.model.*;
import com.stripcode.mybatis.sf.dao.SFSfPipelineMapper;
import com.stripcode.mybatis.user.model.RscSysUser;
import com.stripcode.service.BaseService;
import com.stripcode.service.user.RscSysUserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;

/**
 * Created by Metro on 2016/8/19.
 */
@Service
@CacheConfig(cacheNames = "csAddErpInfo")
public class CS20_006Service extends BaseService {
        @Autowired
        private CSCustomerInfoMapper csCustomerInfoMapper;
        @Autowired
        private RscSysUserService rscSysUserService;
        @Autowired
        private CSMarketAOaddMapper csMarketAOaddMapper;
        @Autowired
        private TCsTaskCompletionService tCsTaskCompletionService;
    @Autowired
    private SFSfPipelineMapper sfSfPipelineMapper;
        @Autowired
        private CpMarketInfoMapper cpMarketInfoMapper;
        @Autowired
        private TCsTaskCompletionMapper tCsTaskCompletionMapper;
        //查询列表市场
        public PageInfo<CpMarketInfo> queryForPage(Map<String, Object> params) {
            PageSortUtil.unoinSortBySord(params);
            PageHelper.startPage(params);
            String MarketId=params.get("marketIds").toString();
            String[] marketIds = MarketId.split(",");
            params.put("marketIds",marketIds);
            return new PageInfo<CpMarketInfo>( csMarketAOaddMapper.queryForPage(params));
        }
        //市场下拉框搜索
        public List<CpMarketInfo> selectCpMarket(String marketId){
            if("".equals(marketId)||marketId==null){
                marketId = "86";
            }
            return cpMarketInfoMapper.selectCpMarket(marketId);
        }
        //获取下拉框客户
       public List<CSCustomerInfo> selectCustomerName (){
           return csMarketAOaddMapper.selectCustomerName();
       }
    //下拉客户带出erpCode
       public List<CSCustomerErpInfo> selectErpCodeList (String customerId){
           return csMarketAOaddMapper.selectErpCodeList(customerId);
       }

        //添加 查询市场
       public List<CpMarketInfo> selectMarketList(String marketIds,String rowId){
           CSErpMarketIds csErpMarketIds = new CSErpMarketIds();
           String [] marketId = marketIds.split(",");
           csErpMarketIds.setMarketIds(marketId);
           csErpMarketIds.setRowId(rowId);
           return csMarketAOaddMapper.selectMarketList(csErpMarketIds);
       }
    //查询分成比例列表
     public List<CSMarketDiscountSplit> selectDiscountSplit(String rowId){
        return  csMarketAOaddMapper.selectDiscountSplit(rowId);
     }
       public List<CSErpMarketMap> selectMarketIds(String rowId){
            return  csMarketAOaddMapper.selectMarketIds(rowId);
       }
        public CSNewMarketAuz selectAllBaseInfoById(String customerId,String rowId) {
                CSCustomerInfo csCustomerInfo= csCustomerInfoMapper.selectById(customerId);
                Integer isExist =csMarketAOaddMapper.AutoCount(customerId,rowId);
                if(isExist ==0){
                    CSNewMarketAuz csNewMarketAuz1 = new CSNewMarketAuz();
                    csNewMarketAuz1.setCsCustomerInfo(csCustomerInfo);
                    csNewMarketAuz1.setDiscountSplitListtSplit(this.selectDiscountSplit(rowId));
                    return csNewMarketAuz1;
                }else{
                    CSNewMarketAuz csNewMarketAuz= csMarketAOaddMapper.selectAuthorInfoById(customerId,rowId);
                    csNewMarketAuz.setCsCustomerInfo(csCustomerInfo);
                    csNewMarketAuz.setDiscountSplitListtSplit(this.selectDiscountSplit(rowId));
                    return  csNewMarketAuz;
                }
            }
        public List<CSCustomerErpInfo> erpCodeList(String customerId){
            return csMarketAOaddMapper.erpCodeList(customerId);
        }
        //选中erpCode 查询具体信息
        public CSNewMarketAuz selectErpCode(String customerId,String erpCode){
            return csMarketAOaddMapper.selectErpCode(customerId,erpCode);
        }
        //保存
        @Transactional
        /**
         *
         */
        public Map update(Map<String,Object> map,CSNewMarketAuz csNewMarketAuz,String userId,TCsTaskCompletion tCsTaskCompletion)throws Exception {
            Map modelMap = new HashMap();
            //定义是否成功 用于判断
            boolean result = true;
            //定义后台返回数据
            String message = "保存成功";
            Integer IsErpIdExist = 0;
            Date date = new Date();
            int count = -1;
           // String [] marketId =(String []) map.get("marketId");
            String [] marketId =null;
            try{
                marketId =  (String []) map.get("marketId");
            }catch(Exception e){
                marketId = new String[1];
                marketId[0] = (String)map.get("marketId");
            }
            //获取市场授权优化ID
            String  optimauthId = map.get("rowId").toString();
            // 市场授权优化基本信息ID
            String authorizationId =map.get("authorizationId").toString();
            csNewMarketAuz.setUpdater(userId);
            csNewMarketAuz.setCreator(userId);
            csNewMarketAuz.setUpdateTime(date);
            csNewMarketAuz.setCreateTime(date);
            //查询客户是否有信息
            // String rowId = csNewMarketAuz.getRowId();
            String taskId = csNewMarketAuz.getTaskId();
            String customerId = csNewMarketAuz.getCustomerId();
            if(customerId.equals("")){
                customerId=csNewMarketAuz.getCsCustomerInfo().getCustomerId();
            }
            if(authorizationId.equals("")){
                authorizationId = UUIDUtils.generateKey();
            }
            csNewMarketAuz.setRowId(authorizationId);
            csNewMarketAuz.setCustomerId(customerId);
            //判断是否为空
            if("".equals(optimauthId)){
                optimauthId = UUIDUtils.generateKey();
            }
            csNewMarketAuz.setOptimauthId(optimauthId);
            IsErpIdExist = csMarketAOaddMapper.AutoCount(customerId,optimauthId);
            if(IsErpIdExist == 0){
                count = csMarketAOaddMapper.insertAuto(csNewMarketAuz);
                count = csMarketAOaddMapper.insert(csNewMarketAuz);
            }else{
                count = csMarketAOaddMapper.update(csNewMarketAuz);
            }
            List<CSErpMarketMap> list = new ArrayList<CSErpMarketMap>();
            if(marketId==null||marketId.length==0){
                marketId = new String[0];
            }
            for(int i=0;i<marketId.length;i++){
                CSErpMarketMap csErpMarketMap = new CSErpMarketMap();
                csErpMarketMap.setAuthorizationId(authorizationId);
                csErpMarketMap.setRowId(UUIDUtils.generateKey());
                csErpMarketMap.setCreator(userId);
                csErpMarketMap.setUpdater(userId);
                csErpMarketMap.setUpdateTime(date);
                csErpMarketMap.setCreateTime(date);
                csErpMarketMap.setMarketId(marketId[i]);
                list.add(csErpMarketMap);
            }
            for (CSErpMarketMap csErpMarketMap :list){
                IsErpIdExist = csMarketAOaddMapper.MarketCount(csErpMarketMap.getAuthorizationId(),csErpMarketMap.getMarketId());
                if(IsErpIdExist==0){
                    count=csMarketAOaddMapper.insertBatchMarket(csErpMarketMap);
                }else {
                    count=csMarketAOaddMapper.updateBatchMarket(csErpMarketMap);
                }
            }
            //分成
            for(CSMarketDiscountSplit csMarketDiscountSplit : csNewMarketAuz.getDiscountSplitListtSplit()){
                IsErpIdExist = csMarketAOaddMapper.isExistsDiscountSplit(authorizationId,csMarketDiscountSplit.getMacroCode());
                if(IsErpIdExist==0){
                    if(StringUtils.isBlank(csMarketDiscountSplit.getRowId())){
                        csMarketDiscountSplit.setRowId(UUIDUtils.generateKey());
                        csMarketDiscountSplit.setAuthorizationId(authorizationId);
                        count = csMarketAOaddMapper.insertDiscountSplit(csMarketDiscountSplit);
                    }
                }else{
                    csMarketDiscountSplit.setAuthorizationId(authorizationId);
                    count = csMarketAOaddMapper.updateDiscountSplit(csMarketDiscountSplit);
                }
            }
            //执行删除操作
            csMarketAOaddMapper.updateMarketDelFlag(marketId,authorizationId);
            // 入口为非流程图中进入
            if(StringUtil.isEmpty(taskId)){
                tCsTaskCompletion.setTaskId("new001");
            }
            tCsTaskCompletion.setOptimauthId(optimauthId);
            tCsTaskCompletionService.upateStatusToFinished(tCsTaskCompletion);
            if(count!=1 ){
                result = false;
                message = "保存失败!";
            }
            modelMap.put("optimauthId", optimauthId);
            modelMap.put("authorizationId", authorizationId);
            modelMap.put("result", result);
            modelMap.put("customerId",customerId);
            //modelMap.put("rowId",optimauthId);
            modelMap.put("message", message);
            return modelMap;
        }
    /**
     * 市场导出
     */
    public void exportMarketInfo(Map<String,Object> params, HttpServletRequest request, HttpServletResponse response) {
        List<ExcelHeader<CpMarketInfo>> headers = new ArrayList<ExcelHeader<CpMarketInfo>>();
        headers.add(new ExcelHeader<CpMarketInfo>("编码", "marketId"));
        headers.add(new ExcelHeader<CpMarketInfo>("名称", "marketName"));
        headers.add(new ExcelHeader<CpMarketInfo>("国家", "country"));
        headers.add(new ExcelHeader<CpMarketInfo>("省份", "province"));
        headers.add(new ExcelHeader<CpMarketInfo>("城市", "city"));
        headers.add(new ExcelHeader<CpMarketInfo>("区县", "district"));
        headers.add(new ExcelHeader<CpMarketInfo>("街道", "street"));
        headers.add(new ExcelHeader<CpMarketInfo>("授权客户", "customerNumber"));
        RscSysUser creator  = rscSysUserService.queryById(WebUtil.getCurrentUser());
        List<CpMarketInfo> data = csMarketAOaddMapper.selectForExportMarketInfo();
        new ExcelExporter(request,response).export(new ExcelDocument<CpMarketInfo>(5000,"客户市场信息",creator == null ? "" : creator.getUserName(),headers,data));
    }
 }
