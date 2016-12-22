package com.stripcode.service.sf;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.stripcode.core.util.DataUtil;
import com.stripcode.core.util.PageSortUtil;
import com.stripcode.core.util.UUIDUtils;
import com.stripcode.core.util.excelUtil.ExportExcel;
import com.stripcode.mybatis.cp.dao.CpMarketInfoMapper;
import com.stripcode.mybatis.cp.model.CpMarketInfo;
import com.stripcode.mybatis.cs.dao.CSCustomerInfoMapper;
import com.stripcode.mybatis.cs.model.CSCustomerErpInfo;
import com.stripcode.mybatis.cs.model.CSCustomerInfo;
import com.stripcode.mybatis.cs.model.CSNewMarketAuz;
import com.stripcode.mybatis.cs.model.CSSfPipeline;
import com.stripcode.mybatis.sf.dao.SFSfPipelineMapper;
import com.stripcode.mybatis.user.model.RscSysUser;
import com.stripcode.service.BaseService;
import com.stripcode.service.cs.TCsTaskCompletionService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Metro on 2016/9/12.
 */
@Service
@CacheConfig(cacheNames = "sfSfpipeline")
public class SF30_002Service extends BaseService {
    @Autowired
    private SFSfPipelineMapper sfSfPipelineMapper;
    @Autowired
    private CpMarketInfoMapper cpMarketInfoMapper;
    @Autowired
    private CSCustomerInfoMapper csCustomerInfoMapper;
    @Autowired
    private TCsTaskCompletionService csTaskCompletionService;
    /*
    * 列表带分页的查询数据
    * */
    public PageInfo<CSSfPipeline> queryForPage(Map<String ,Object> params){
        //合并orderBy Sord
        PageSortUtil.unoinSortBySord(params);
        PageHelper.startPage(params);
        return new PageInfo<CSSfPipeline>(sfSfPipelineMapper.queryForPage(params));
    };
    /*
    * 查询ppId
    * */
    public CSSfPipeline queryById(String id){
        CSSfPipeline csSfPipeline =sfSfPipelineMapper.selectLoad(id);
        return csSfPipeline;
    }
    /*
    * 查询customerId
    * */
    public CSCustomerInfo customerById(String customerId){
        CSCustomerInfo cSCustomerInfo =sfSfPipelineMapper.selectById(customerId);
        return cSCustomerInfo;
    }
    public List<CSCustomerInfo> selectErpCustomerAll(){
        return sfSfPipelineMapper.selectErpCustomerAll();
    }
    //查询开发人员
    public List<RscSysUser> selectAllUser(){
        return sfSfPipelineMapper.selectAllUser();
    }
    /*
    * 保存
    * */
    @Transactional
    public Map update(CSSfPipeline csSfPipeline)throws Exception{
        Map modelMap = new HashMap();
        int count = -1;
        //保存或修改是否成功
        boolean result = true;
        //返回到前台的提示信息
        String message = "保存成功!";
        String ppId = csSfPipeline.getPpId();;
        String random = UUIDUtils.generateKey();
        if("M0043".equals(csSfPipeline.getStatus())){
            csSfPipeline.setStatus("M0097");
            csSfPipeline.setPipelineSatus("M0043");
        }
        if(StringUtils.isBlank(ppId)){
            ppId=random;
            csSfPipeline.setPpId(random);
            count = sfSfPipelineMapper.insert(csSfPipeline);
            modelMap.put("ppId",random);
            if (count!=1){
                result = false;
                message = "保存失败!";
            }
            csTaskCompletionService.updatePipelineType("M0517",ppId);
        }else{
            count = sfSfPipelineMapper.update(csSfPipeline);
            if (count!=1){
                result = false;
                message = "保存失败!";
            }
        }
        modelMap.put("result", result);
        modelMap.put("message", message);
        return modelMap;
    }


    public List<CpMarketInfo> selectCpMarket(String marketId){
        /*System.out.print("".equals(marketId));
        if(StringUtils.isBlank(marketId)){
            marketId = "86";
        }*/
        if("".equals(marketId)||marketId==null){
            marketId = "86";
        }
        return sfSfPipelineMapper.selectMarketInfo(marketId);
    }
    /*
    * 新增页面查询下拉框ERP市场名称
    * */
    public  List<CSCustomerErpInfo> selectErpName(String customerId){
        return  sfSfPipelineMapper.selectErpName(customerId);
    }

    //查询品牌
    public CSNewMarketAuz selectBrand(String erpCode){
        return sfSfPipelineMapper.selectBrand(erpCode);
    }

    public void exportUser( Map<String,Object> params, HttpServletRequest request, HttpServletResponse response) {
        /*List<ExcelHeader<CSSfPipeline>> headers = new ArrayList<ExcelHeader<CSSfPipeline>>();
        headers.add(new ExcelHeader<CSSfPipeline>("状态", "status"));
        headers.add(new ExcelHeader<CSSfPipeline>("店铺名称", "cnSiteName"));
        headers.add(new ExcelHeader<CSSfPipeline>("经营方式", "operationMode"));
        headers.add(new ExcelHeader<CSSfPipeline>("渠道类型", "channelType"));
        headers.add(new ExcelHeader<CSSfPipeline>("店铺性质", "storeProperty"));
        headers.add(new ExcelHeader<CSSfPipeline>("品牌", "brand"));
        headers.add(new ExcelHeader<CSSfPipeline>("省份", "province"));
        headers.add(new ExcelHeader<CSSfPipeline>("城市", "city"));
        *//*headers.add(new ExcelHeader<CSSfPipeline>("市场名称", ""));*//*
        CSSfPipeline creator  = queryById(WebUtil.getCurrentUser());
        List<CSSfPipeline> data = sfSfPipelineMapper.selectForExport(params);
        new ExcelExporter(request,response).export(new ExcelDocument<CSSfPipeline>(5000,"新店基本信息",creator == null ? "" : creator.getRowId(),headers,data));
        */try {
            String fileName = "新店基本信息"+ DataUtil.getDate("yyyyMMddHHmmss")+".xlsx";
            List<CSSfPipeline> data = sfSfPipelineMapper.queryForPage(params);
            new ExportExcel("新店基本信息", CSSfPipeline.class).setDataList(data).write(response, fileName).dispose();
        } catch (Exception e) {

        }
    }
}
