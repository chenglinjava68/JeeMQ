package com.stripcode.service.sys;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

import com.github.pagehelper.PageInfo;
import com.stripcode.core.util.DataUtil;
import com.stripcode.core.util.PageSortUtil;
import com.stripcode.core.util.UUIDUtils;
import com.stripcode.core.util.excelUtil.ExportExcel;
import com.stripcode.mybatis.sf.dao.SFSfApprovalMapper;
import com.stripcode.mybatis.sys.dao.SYSEstInvestmentModelMapper;
import com.stripcode.mybatis.sys.model.SYSEstInvestmentModel;
import com.stripcode.mybatis.user.dao.TCodeMacroDefineMapper;
import com.stripcode.service.BaseService;
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
 * Created by Metro on 2016/10/25.
 */
@Service
@CacheConfig(cacheNames = "sysEstInvestmentModel")
public class SYS80_001Service extends BaseService{
    @Autowired
    private SYSEstInvestmentModelMapper sysEstInvestmentModelMapper;
    @Autowired
    private SFSfApprovalMapper sFSfApprovalMapper;
    @Autowired
    private TCodeMacroDefineMapper tCodeMacroDefineMapper;
    /**
     * 列表带分页的查询数据
     * @param params
     * @return
     */
    public PageInfo<SYSEstInvestmentModel> queryForPage(Map<String,Object> params){
        //合并orderBy Sord
        PageSortUtil.unoinSortBySord(params);
        PageHelper.startPage(params);
        return new PageInfo<SYSEstInvestmentModel>(sysEstInvestmentModelMapper.queryForPage(params));
    }
    /*
        * 查询rowId
        * */
    public SYSEstInvestmentModel queryById(String id){
        SYSEstInvestmentModel sysEstInvestmentModel =sysEstInvestmentModelMapper.selectLoad(id);
        return sysEstInvestmentModel;
    }

    @Transactional
    public Map update(SYSEstInvestmentModel sysEstInvestmentModel)throws Exception{
        Map modelMap = new HashMap();
        int count = -1;
        //保存或修改是否成功
        boolean result = true;
        //返回到前台的提示信息
        String message ="";
        String attachId=sysEstInvestmentModel.getAttachId();
        if(StringUtils.isBlank(attachId)){
           message="请上传附件";
        }else {
        message = "保存成功!";
        String rowId = sysEstInvestmentModel.getRowId();

        if(StringUtils.isBlank(rowId)){
            String random = UUIDUtils.generateKey();
            sysEstInvestmentModel.setRowId(random);

            String status=sysEstInvestmentModel.getModelStatus();
            if(status.equals("M0043")){
                count = sysEstInvestmentModelMapper.insert(sysEstInvestmentModel);
                sysEstInvestmentModelMapper.updatesave(sysEstInvestmentModel);
            }else {
                count = sysEstInvestmentModelMapper.insert(sysEstInvestmentModel);
            }
            modelMap.put("rowId",random);
        }else{
            String status=sysEstInvestmentModel.getModelStatus();
            if(status.equals("M0043")){
                sysEstInvestmentModelMapper.updatesave(sysEstInvestmentModel);
                Thread.sleep(1000);
                count =sysEstInvestmentModelMapper.update(sysEstInvestmentModel);

            }else{
                count = sysEstInvestmentModelMapper.update(sysEstInvestmentModel);
            }

        }}
        if (count!=1){
            result = false;
            message = "保存失败!请上传附件";
        }
        modelMap.put("result", result);
        modelMap.put("message", message);
        return modelMap;
    }
    /**
     * 导出
     * @param params
     * @param request
     * @param response
     */
    public void exportUser(Map<String,Object> params, HttpServletRequest request, HttpServletResponse response) {
        /*List<ExcelHeader<SYSEstInvestmentModel>> headers = new ArrayList<ExcelHeader<SYSEstInvestmentModel>>();
        headers.add(new ExcelHeader<SYSEstInvestmentModel>("品牌", "brand"));
        headers.add(new ExcelHeader<SYSEstInvestmentModel>("年份", "year"));
        headers.add(new ExcelHeader<SYSEstInvestmentModel>("模板类型", "modelType"));
        headers.add(new ExcelHeader<SYSEstInvestmentModel>("版本", "modelVersion"));
        headers.add(new ExcelHeader<SYSEstInvestmentModel>("状态", "modelStatus"));
        SYSEstInvestmentModel creator  = queryById(WebUtil.getCurrentUser());
        List<SYSEstInvestmentModel> data = sysEstInvestmentModelMapper.selectForExport(params);
        new ExcelExporter(request,response).export(new ExcelDocument<SYSEstInvestmentModel>(5000,"测算模板基本信息",creator == null ? "" : creator.getRowId(),headers,data));
    */try {
            String fileName = "测算模板基本信息"+ DataUtil.getDate("yyyyMMddHHmmss")+".xlsx";
            Page<SYSEstInvestmentModel> page =  sysEstInvestmentModelMapper.queryForPage(params);
            List<SYSEstInvestmentModel> data = page.getResult();
            new ExportExcel("测算模板基本信息", SYSEstInvestmentModel.class).setDataList(data).write(response, fileName).dispose();
        } catch (Exception e) {

        }
    }
}
