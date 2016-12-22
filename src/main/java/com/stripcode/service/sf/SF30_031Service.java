package com.stripcode.service.sf;

import com.stripcode.core.util.UUIDUtils;
import com.stripcode.mybatis.cs.model.TCsTaskCompletion;
import com.stripcode.mybatis.sf.dao.SFContractApplyAttachmentMapper;
import com.stripcode.mybatis.sf.dao.SFContractApplyMapper;
import com.stripcode.mybatis.sf.model.SFContractApply;
import com.stripcode.mybatis.sf.model.SFContractApplyAttachment;
import com.stripcode.service.cs.TCsTaskCompletionService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Metro
 */
@Service
@CacheConfig(cacheNames = "SF30_031Service")
public class SF30_031Service {
    @Autowired
    private SFContractApplyMapper sfContractApplyMapper;

    @Autowired
    private SFContractApplyAttachmentMapper sfContractApplyAttachmentMapper;

    @Autowired
    private TCsTaskCompletionService tCsTaskCompletionService;

    public SFContractApply queryContractApplyAndAttachment(String ppId){
        SFContractApply sfContractApply = sfContractApplyMapper.queryContractApply(ppId);
        List<SFContractApplyAttachment> list = sfContractApplyAttachmentMapper.queryContractApplyAttachment(ppId);
        if(sfContractApply==null){
            SFContractApply model = new SFContractApply();
            model.setApplyAttachmentList(list);
            return model;
        }
        sfContractApply.setApplyAttachmentList(list);
        return sfContractApply;
    }

    public Map<String,Object> updateContractApply(SFContractApply model, TCsTaskCompletion tCsTaskCompletion){
        Map<String,Object> map = new HashMap<String,Object>();
        Boolean result = true;
        String message = "保存成功!";
        Integer count = -1;
        if(StringUtils.isBlank(model.getRowId())){
            model.setRowId(UUIDUtils.generateKey());
            count = sfContractApplyMapper.insertContractApply(model);
        }else {
            count = sfContractApplyMapper.updateContractApply(model);
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
        map.put("result",result);
        map.put("message",message);
        return map;
    }

    public Map<String,Object> updateAttachment(SFContractApply model){
        Map<String,Object> map = new HashMap<String,Object>();
        Boolean result = true;
        String message = "保存成功!";
        Integer count = -1;
        for (SFContractApplyAttachment obj: model.getApplyAttachmentList()){
            if(StringUtils.isBlank(obj.getRowId())){
                obj.setRowId(UUIDUtils.generateKey());
                count = sfContractApplyAttachmentMapper.insertContractApplyAttachment(obj);
            }else {
                count = sfContractApplyAttachmentMapper.updateContractApplyAttachment(obj);
            }
        }
        if(count==0){
            result = false;
            message = "保存失败!";
        }
        map.put("result",result);
        map.put("message",message);
        return map;
    }
}
