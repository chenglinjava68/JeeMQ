package com.stripcode.service.sf;

import com.stripcode.core.util.UUIDUtils;
import com.stripcode.mybatis.cs.model.TCsTaskCompletion;
import com.stripcode.mybatis.sf.dao.SFAcceptanceMapper;
import com.stripcode.mybatis.sf.model.SFAcceptance;
import com.stripcode.mybatis.sf.model.SFAcceptanceAttachment;
import com.stripcode.service.cs.TCsTaskCompletionService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;

import java.util.List;

/**
 * @author Metro
 */
@Service
@CacheConfig(cacheNames = "SF30_071Service")
public class SF30_071Service {
    @Autowired
    private SFAcceptanceMapper sfAcceptanceMapper;

    @Autowired
    private TCsTaskCompletionService tCsTaskCompletionService;

    public SFAcceptance queryAcceptance(String ppId){
        SFAcceptance model =  sfAcceptanceMapper.queryAcceptance(ppId);
        if(model!=null){
            model.setSfAcceptanceAttachments(sfAcceptanceMapper.queryAcceptanceAttachment(model.getRowId()));
            return model;
        }else {
            SFAcceptance sfAcceptance = new SFAcceptance();
            sfAcceptance.setSfAcceptanceAttachments(sfAcceptanceMapper.queryAcceptanceAttachment(null));
            return sfAcceptance;
        }
    }

    @Transactional
    public ModelMap update(SFAcceptance model, TCsTaskCompletion csTaskCompletion){
        ModelMap modelMap = new ModelMap();
        Integer count = -1;
        Boolean result = true;
        String message= "保存成功!";
        //保存竣工验收信息
        if(StringUtils.isBlank(model.getRowId())){
            model.setRowId(UUIDUtils.generateKey());
            count = sfAcceptanceMapper.insertAcceptance(model);
        }else {
            count = sfAcceptanceMapper.updateAcceptance(model);
        }
        //保存竣工验收附件
        count = this.saveAcceptanceAttachment(model.getSfAcceptanceAttachments(),model.getRowId());
        if(count==0){
            result = false;
            message = "保存失败!";
        }

        csTaskCompletion.setRowId(UUIDUtils.generateKey());
        csTaskCompletion.setCreateTime(null);
        csTaskCompletion.setOptimauthId(model.getPpId());
        tCsTaskCompletionService.upateStatusToFinished(csTaskCompletion);
        tCsTaskCompletionService.updatePipelineType(csTaskCompletion.getTaskId(),csTaskCompletion.getOptimauthId());
        modelMap.put("rowId",model.getRowId());
        modelMap.put("result",result);
        modelMap.put("message",message);
        return modelMap;
    }

    public Integer saveAcceptanceAttachment(List<SFAcceptanceAttachment> sfAcceptanceAttachments,String rowId){
        Integer count = -1;
        for (SFAcceptanceAttachment item: sfAcceptanceAttachments) {
            if(StringUtils.isBlank(item.getRowId())){
                item.setRowId(UUIDUtils.generateKey());
                item.setAcceptanceId(rowId);
                count = sfAcceptanceMapper.insertAcceptanceAttachment(item);
            }else {
                count = sfAcceptanceMapper.updateAcceptanceAttachment(item);
            }
        }
        return count;
    }
}
