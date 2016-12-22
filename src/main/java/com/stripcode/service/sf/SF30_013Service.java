package com.stripcode.service.sf;

import com.stripcode.core.util.UUIDUtils;
import com.stripcode.mybatis.cs.model.TCsTaskCompletion;
import com.stripcode.mybatis.sf.dao.SFConsPreSurveyReportMapper;
import com.stripcode.mybatis.sf.model.SFConsPreSurveyReport;
import com.stripcode.service.cs.TCsTaskCompletionService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Metro
 */
@Service
@CacheConfig(cacheNames = "SF30_013Service")
public class SF30_013Service {
    @Autowired
    private SFConsPreSurveyReportMapper sfConsPreSurveyReportMapper;

    @Autowired
    private TCsTaskCompletionService tCsTaskCompletionService;


    public SFConsPreSurveyReport queryReport(String ppId){
        return sfConsPreSurveyReportMapper.queryReport(ppId);
    }

    @Transactional
    public Map<String,Object> update(SFConsPreSurveyReport model, TCsTaskCompletion tCsTaskCompletion){
        Map<String,Object> map = new HashMap<String,Object>();
        Boolean result = true;
        String message = "保存成功!";
        Integer count=-1;

        if(StringUtils.isBlank(model.getRowId())){
            model.setRowId(UUIDUtils.generateKey());
            count = sfConsPreSurveyReportMapper.insertReport(model);
        }else {
            count = sfConsPreSurveyReportMapper.updateReport(model);
        }

        if(count==0){
            result = false;
            message = "保存失败!";
        }

        tCsTaskCompletion.setRowId(UUIDUtils.generateKey());
        tCsTaskCompletion.setCreateTime(null);
        tCsTaskCompletion.setOptimauthId(model.getPpId());
        tCsTaskCompletionService.upateStatusToFinished(tCsTaskCompletion);
        tCsTaskCompletionService.updatePipelineType(tCsTaskCompletion.getTaskId(),tCsTaskCompletion.getOptimauthId());
        map.put("rowId",model.getRowId());
        map.put("result",result);
        map.put("message",message);
        return map;
    }
}
