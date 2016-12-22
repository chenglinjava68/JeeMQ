package com.stripcode.service.sf;

import com.stripcode.core.util.UUIDUtils;
import com.stripcode.mybatis.cs.model.TCsTaskCompletion;
import com.stripcode.mybatis.sf.dao.SFLicenceAttachmentMapper;
import com.stripcode.mybatis.sf.model.SFLicenceAttachment;
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
@CacheConfig(cacheNames = "SF30_072Service")
public class SF30_072Service {
    @Autowired
    private SFLicenceAttachmentMapper sfLicenceAttachmentMapper;

    @Autowired
    private TCsTaskCompletionService tCsTaskCompletionService;

    public List<SFLicenceAttachment> queryAll(String ppId){
        return sfLicenceAttachmentMapper.queryAll(ppId);
    }

    @Transactional
    public ModelMap update(List<SFLicenceAttachment> list,TCsTaskCompletion csTaskCompletion){
        ModelMap modelMap = new ModelMap();
        Integer count = -1;
        String message = "保存成功!";
        Boolean result = true;
        String ppId = "";

        for (SFLicenceAttachment model:list){
            if(StringUtils.isBlank(model.getAttachId())){
                model.setStatus("0");
            }else {
                model.setStatus("1");
            }
                if(StringUtils.isBlank(model.getRowId())){
                    model.setRowId(UUIDUtils.generateKey());
                    count = sfLicenceAttachmentMapper.insertLicenceAttachment(model);
                }else {
                    count = sfLicenceAttachmentMapper.updateLicenceAttachment(model);
                }
                ppId = model.getPpId();
        }

        if(count==0){
            result = false;
            message = "保存失败!";
        }

        csTaskCompletion.setRowId(UUIDUtils.generateKey());
        csTaskCompletion.setCreateTime(null);
        csTaskCompletion.setOptimauthId(ppId);
        tCsTaskCompletionService.upateStatusToFinished(csTaskCompletion);
        tCsTaskCompletionService.updatePipelineType(csTaskCompletion.getTaskId(),csTaskCompletion.getOptimauthId());
        modelMap.put("result",result);
        modelMap.put("message",message);
        return modelMap;
    }
}
