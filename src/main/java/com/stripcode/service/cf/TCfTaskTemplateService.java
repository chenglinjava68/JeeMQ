package com.stripcode.service.cf;

import com.stripcode.mybatis.cf.dao.TCfTaskTemplateMapper;
import com.stripcode.mybatis.cf.model.TCfTaskTemplate;
import com.stripcode.mybatis.cs.dao.TCsTaskCompletionMapper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by Metro on 2016/9/8.
 */
@Service
public class TCfTaskTemplateService {
    @Autowired
    private TCfTaskTemplateMapper tCfTaskTemplateMapper;
    @Autowired
    private TCsTaskCompletionMapper tCsTaskCompletionMapper;
    private static final String FINISHED_FALSE = "2";
    private static final String FINISHED_TRUE = "1";

    public List<TCfTaskTemplate> selectByTaskType(Map<String,Object> params) {
        List<TCfTaskTemplate> tCfTaskTemplates = tCfTaskTemplateMapper.selectByTaskType(params);
        for (TCfTaskTemplate tCfTaskTemplate : tCfTaskTemplates) {
            if(StringUtils.isBlank(tCfTaskTemplate.getPreTaskId())){
                tCfTaskTemplate.setPrevIsFinished(FINISHED_TRUE);
            }else{
                params.put("taskIds",tCfTaskTemplate.getPreTaskId().split(","));
                int prevSuccessCount = tCsTaskCompletionMapper.selectSuccessCountByTaskIds(params);
                int prevIsMustCount = tCsTaskCompletionMapper.selectMustCountByTaskIds(params);
                if(prevSuccessCount == prevIsMustCount){
                    tCfTaskTemplate.setPrevIsFinished(FINISHED_TRUE);
                }else{
                    tCfTaskTemplate.setPrevIsFinished(FINISHED_FALSE);
                }
            }
        }
        return tCfTaskTemplates;
    }
}
