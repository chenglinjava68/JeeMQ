package com.stripcode.service.cs;

import com.stripcode.mybatis.cs.dao.TCsTaskCompletionMapper;
import com.stripcode.mybatis.cs.model.TCsTaskCompletion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * Created by Metro on 2016/9/8.
 */
@Service
public class TCsTaskCompletionService {
    @Autowired
    private TCsTaskCompletionMapper tCsTaskCompletionMapper;
    private static final String IS_FINISHED = "1";
    public int selectCountByTaskIds(Map<String,Object> params){
        return tCsTaskCompletionMapper.selectSuccessCountByTaskIds(params);
    }
    public void upateStatusToFinished(TCsTaskCompletion tCsTaskCompletion){
        if(isExists(tCsTaskCompletion)){
            tCsTaskCompletion.setIsFinished(IS_FINISHED);
            tCsTaskCompletionMapper.updateCompletion(tCsTaskCompletion);
            return;
        }
        tCsTaskCompletion.setIsFinished(IS_FINISHED);
        tCsTaskCompletionMapper.insert(tCsTaskCompletion);
    }

    private boolean isExists(TCsTaskCompletion tCsTaskCompletion) {
        if(tCsTaskCompletionMapper.isExists(tCsTaskCompletion) ==1 ){
            return true;
        }
        return false;
    }

    public void updateOptimauthType(String macroCode,String rowId){
        Integer macroNo = tCsTaskCompletionMapper.selectMacroNoByMacroCode(macroCode,null);
        Integer optimauthNo = tCsTaskCompletionMapper.selectMacroNoByMacroCode(null,rowId);
        if(macroNo>optimauthNo){
            tCsTaskCompletionMapper.updateOptimauthType(macroCode,rowId);
        }
    }

    public void updatePipelineType(String macroCode,String ppId){
        Integer macroNo = tCsTaskCompletionMapper.selectMacroNoByMacroCodeToPipeline(macroCode,null);
        Integer optimauthNo = tCsTaskCompletionMapper.selectMacroNoByMacroCodeToPipeline(null,ppId);
        if(optimauthNo==null){
            tCsTaskCompletionMapper.updatePipelineType(macroCode,ppId);
            return;
        }
        if(macroNo>optimauthNo){
            tCsTaskCompletionMapper.updatePipelineType(macroCode,ppId);
        }
    }
}
