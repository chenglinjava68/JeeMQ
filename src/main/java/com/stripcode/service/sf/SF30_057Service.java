package com.stripcode.service.sf;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.stripcode.core.util.PageSortUtil;
import com.stripcode.core.util.UUIDUtils;
import com.stripcode.mybatis.cs.dao.TSysCommonattachedMapper;
import com.stripcode.mybatis.cs.model.TCsTaskCompletion;
import com.stripcode.mybatis.sf.dao.SFEstInvestmentMapper;
import com.stripcode.mybatis.sf.model.SFEstInvestment;
import com.stripcode.mybatis.sf.model.SFEstInvestmentDetail;
import com.stripcode.mybatis.sf.model.SFEstInvestmentResultData;
import com.stripcode.mybatis.sf.model.SFReport;
import com.stripcode.mybatis.sys.dao.SYSBrandMeasureTemplateTypeMapper;
import com.stripcode.mybatis.user.model.TCodeMacroDefine;
import com.stripcode.service.cs.TCsTaskCompletionService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.*;

/**
 * @author Metro
 */
@Service
@CacheConfig(cacheNames = "SF30_057Service")
public class SF30_057Service  {

    @Autowired
    private SFEstInvestmentMapper sfEstInvestmentMapper;
    @Autowired
    private TSysCommonattachedMapper tSysCommonattachedMapper;
    @Autowired
    private TCsTaskCompletionService tCsTaskCompletionService;

    @Autowired
    private SYSBrandMeasureTemplateTypeMapper sysBrandMeasureTemplateTypeMapper;

    public PageInfo<SFEstInvestment> selectForPage(Map<String, Object> map) {
        PageSortUtil.unoinSortBySord(map);
        PageHelper.startPage(map);
        return new PageInfo<SFEstInvestment>(sfEstInvestmentMapper.selectForPage(map));
    }

    public List<SFEstInvestmentDetail> queryInvestDetail(String modelType,String investmentId){
        return sfEstInvestmentMapper.queryInvestDetail(modelType,investmentId);
    }

    @Transactional
    public Map update(SFEstInvestment model){
        Map modelMap = new HashMap();
        Boolean result = true;
        Integer count = -1;
        String message = "保存成功!";
        model.setCalbackYear(new Random().nextDouble());
        model.setFirstUcPer(model.getResultData().getFirstUcPer());
        model.setSecondUcPer(model.getResultData().getSecondUcPer());
        model.setThirdUcPer(model.getResultData().getThirdUcPer());
        if(StringUtils.isBlank(model.getRowId())){
            model.setRowId(UUIDUtils.generateKey());
            count = sfEstInvestmentMapper.insertEstInvestment(model);
        }else {
            count = sfEstInvestmentMapper.updateEstInvestment(model);
        }

        for (SFEstInvestmentDetail item :model.getDetails()){
            item.setInvestmentId(model.getRowId());
            count = this.saveEstInvestmentDetail(item);
        }
        if(model.getResultData() !=null){
            model.getResultData().setInvestmentId(model.getRowId());
        }
        count = this.saveEstInvestmentResultData(model.getResultData());
        if(count!=1){
            result = false;
            message = "保存失败!";
        }
        modelMap.put("rowId",model.getRowId());
        modelMap.put("result",result);
        modelMap.put("message",message);
        return modelMap;
    }

    public Integer saveEstInvestmentDetail(SFEstInvestmentDetail model){
        Integer isExist = sfEstInvestmentMapper.isExistsEstInvestmentDetail(model.getRowId(),model.getInvestmentId(),model.getItem());
        if(isExist==0){
            model.setRowId(UUIDUtils.generateKey());
            return sfEstInvestmentMapper.insertEstInvestmentDetail(model);
        }else{
            return sfEstInvestmentMapper.updateEstInvestmentDetail(model);
        }
    }

    public Integer saveEstInvestmentResultData(SFEstInvestmentResultData model){
        Integer isExist = sfEstInvestmentMapper.isExistsEstInvestmentResultData(model.getInvestmentId(),model.getRowId());
        if(isExist==0){
            model.setRowId(UUIDUtils.generateKey());
            return sfEstInvestmentMapper.insertEstInvestmentResultData(model);
        }else {
            return sfEstInvestmentMapper.updateEstInvestmentResultData(model);
        }
    }

    /**
     * 删除投资预测信息
     */
    public Map delete(String ppId,String rowId){
        Map modelMap = new HashMap();
        Boolean result = true;
        String message = "删除成功!";
        sfEstInvestmentMapper.deleteInvestmentDetail(rowId);
        sfEstInvestmentMapper.deleteInvestmentResultDate(rowId);
        sfEstInvestmentMapper.deleteInvestment(rowId,ppId);
        modelMap.put("result",result);
        modelMap.put("message",message);
        return modelMap;
    }

    public SFEstInvestmentResultData queryResultData(String investmentId){
        return sfEstInvestmentMapper.queryResultData(investmentId);
    }

    public Map<String,String>  getFilePath(String modelType,String brand) {
        return sfEstInvestmentMapper.getFilePath(modelType,brand);
    }

    public Map<String,String> getTemlateFilePath(String attachId) {
        return tSysCommonattachedMapper.getTemlateFilePath(attachId);
    }

    public List<TCodeMacroDefine> loadListSelect(String operationMode, String brand){
        return sysBrandMeasureTemplateTypeMapper.queryByInvestment(operationMode,brand);
    }

    public Integer updateSubmitStatus(String rowId,String ppId,TCsTaskCompletion tCsTaskCompletion){
        List<SFReport> sfReports = sfEstInvestmentMapper.queryReport(ppId);
        ArrayList rowIds = new ArrayList();
        rowIds.add(rowId);
        if(sfReports!=null){
            for(SFReport sfReport:sfReports ){
                rowIds.add(sfReport.getRowId());
            }
        }
        sfEstInvestmentMapper.updateSubmitStatus(rowIds,ppId);
        tCsTaskCompletion.setRowId(UUIDUtils.generateKey());
        tCsTaskCompletion.setCreateTime(null);
        tCsTaskCompletion.setOptimauthId(ppId);
        tCsTaskCompletionService.upateStatusToFinished(tCsTaskCompletion);
        tCsTaskCompletionService.updatePipelineType(tCsTaskCompletion.getTaskId(),tCsTaskCompletion.getOptimauthId());
        return sfEstInvestmentMapper.updateSubmitStatusByRowId(rowIds);
    }
}
