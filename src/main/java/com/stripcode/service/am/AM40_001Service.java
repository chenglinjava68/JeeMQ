package com.stripcode.service.am;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.stripcode.core.util.DataUtil;
import com.stripcode.core.util.PageSortUtil;
import com.stripcode.core.util.UUIDUtils;
import com.stripcode.core.util.excelUtil.ExportExcel;
import com.stripcode.mybatis.am.dao.AMAttachMentInfoMapper;
import com.stripcode.mybatis.am.dao.AMAuthorizationInfoMapper;
import com.stripcode.mybatis.am.dao.AMStoreInfoMapper;
import com.stripcode.mybatis.am.model.AMAttachMentInfo;
import com.stripcode.mybatis.am.model.AMAuthorizationInfo;
import com.stripcode.mybatis.am.model.AMStoreInfo;
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
 * Created by Metro on 2016/10/17.
 */
@Service
@CacheConfig(cacheNames = "AM40_001")
public class AM40_001Service {
    @Autowired
    private AMStoreInfoMapper amStoreInfoMapper;
    @Autowired
    private RscSysUserService rscSysUserService;
    @Autowired
    private AMAttachMentInfoMapper amAttachMentInfoMapper;
    @Autowired
    private AMAuthorizationInfoMapper amAuthorizationInfoMapper;

    /**
     * 分页模糊查询
     * @param param
     * @return
     */
    public PageInfo<AMStoreInfo> query(Map<String,Object> param){
        PageSortUtil.unoinSortBySord(param);
        PageHelper.startPage(param);
        return new PageInfo<AMStoreInfo>(amStoreInfoMapper.selectForPage(param));
    }

    /**
     * 查询店铺信息
     * @param storeId
     * @return
     */
    public AMStoreInfo queryById(String storeId){
        AMStoreInfo model = amStoreInfoMapper.selectByStoreId(storeId);
        if (model!=null){
            model.setContractList(this.selectForAuthorization(storeId));
            return model;
        }else{
            AMStoreInfo amStoreInfo = new AMStoreInfo();
            amStoreInfo.setContractList(this.selectForAuthorization(storeId));
            return amStoreInfo;
        }
    }

    /**
     * 保存
     * @param model
     * @return
     */
    @Transactional
    public Map update(AMStoreInfo model){
        Map modelMap = new HashMap();
        Map<String,Object> contractMap = new HashMap<String,Object>();
        Integer count = -1;
        Boolean result = true;
        String message = "保存成功!";
        //用于删除附件
        ArrayList contractRowId = new ArrayList();
        if (model.getContractList() != null){
            for (AMAuthorizationInfo item:model.getContractList()) {
                item.setStoreId(model.getStoreId());
                if (StringUtils.isBlank(item.getRowId())){
                    item.setRowId(UUIDUtils.generateKey());
                    count = amAuthorizationInfoMapper.insertAuthorizationInfo(item);
                }else{
                    count = amAuthorizationInfoMapper.updateAuthorizationInfo(item);
                }
                contractRowId.add(item.getRowId());
            }
        }
        if (contractRowId.size() == 0){
            contractMap.put("isContractNull",0);
        }
        //执行删除操作
        contractMap.put("rowId",contractRowId);
        amAuthorizationInfoMapper.deleteAuthorizationInfo(contractMap);
        if(count!=1){
            result = false;
            message = "保存失败!";
        }
        modelMap.put("rowId",model.getRowId());
        modelMap.put("result",result);
        modelMap.put("message",message);
        return modelMap;
    }

    /**
     * excel导出
     * @param params
     * @param request
     * @param response
     */
    public void exportStores(Map<String,Object> params, HttpServletRequest request, HttpServletResponse response){
        /*List<ExcelHeader<AMStoreInfo>> header = new ArrayList<ExcelHeader<AMStoreInfo>>();
        header.add(new ExcelHeader<AMStoreInfo>("状态","def1"));
        header.add(new ExcelHeader<AMStoreInfo>("店铺编码","storeCode"));
        header.add(new ExcelHeader<AMStoreInfo>("店铺名称","cnsiteName"));
        header.add(new ExcelHeader<AMStoreInfo>("经营方式","operationMode"));
        header.add(new ExcelHeader<AMStoreInfo>("渠道类型","channelType"));
        header.add(new ExcelHeader<AMStoreInfo>("店铺性质","def2"));
        header.add(new ExcelHeader<AMStoreInfo>("品牌","brand"));
        header.add(new ExcelHeader<AMStoreInfo>("区域","def3"));
        header.add(new ExcelHeader<AMStoreInfo>("省份","province"));
        header.add(new ExcelHeader<AMStoreInfo>("城市","city"));
        header.add(new ExcelHeader<AMStoreInfo>("市场名称","def4"));
        RscSysUser creator = rscSysUserService.queryById(WebUtil.getCurrentUser());
        List<AMStoreInfo> data = amStoreInfoMapper.selectForExport(params);
        new ExcelExporter(request,response).export(new ExcelDocument<AMStoreInfo>(5000,"全部店铺信息",creator == null ? "" : creator.getUserName(),header,data));*/

        try{
            String fileName = "店铺管理"+ DataUtil.getDate("yyyyMMddHHmmss")+".xlsx";
            List<AMStoreInfo> data = amStoreInfoMapper.selectForExport(params);
            new ExportExcel("店铺管理",AMStoreInfo.class).setDataList(data).write(response,fileName).dispose();
        }catch (Exception e){}
    }


    /**
     * 查询店铺附件
     * @param storeId
     * @return
     */
    public List<AMAttachMentInfo> selectForAttachMent(String storeId){
        return amAttachMentInfoMapper.selectForAttachMentInfo(storeId);
    }

    /**
     * 查询店铺授权书附件
     * @param storeId
     * @return
     */
    public List<AMAuthorizationInfo> selectForAuthorization(String storeId){
        return amAuthorizationInfoMapper.selectForAuthorizationInfo(storeId);
    }
}
