package com.stripcode.service.sf;

import com.stripcode.core.util.UUIDUtils;
import com.stripcode.mybatis.cs.model.TCsTaskCompletion;
import com.stripcode.mybatis.sf.dao.SFImportantEventsMapper;
import com.stripcode.mybatis.sf.dao.SFStoreHandoverAttachmentMapper;
import com.stripcode.mybatis.sf.dao.SFStoreHandoverMapper;
import com.stripcode.mybatis.sf.model.*;
import com.stripcode.service.cs.TCsTaskCompletionService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Metro
 */
@Service
@CacheConfig
public class SF30_048Service {
    @Autowired
    private SFStoreHandoverMapper sfStoreHandoverMapper;

    @Autowired
    private TCsTaskCompletionService tCsTaskCompletionService;

    @Autowired
    private SFStoreHandoverAttachmentMapper sfStoreHandoverAttachmentMapper;

    @Autowired
    private SFImportantEventsMapper sfImportantEventsMapper;

    @Autowired
    private SF30_008Service sf30_008Service;

    public SFStoreHandover queryHandoverInfo(String ppId){
        SFStoreHandover sfStoreHandover = sfStoreHandoverMapper.queryStoreHandoverInfo(ppId);
        SFEstateSource sfEstateSource = sf30_008Service.queryEstateSource(ppId);
        if(sfStoreHandover==null){
            SFStoreHandover model = new SFStoreHandover();
            model.setHandoverAttachmentList(sfStoreHandoverAttachmentMapper.queryHandoverAttachment(null));
            model.setImportantEventsList(sfImportantEventsMapper.queryImportantEvents(null));
            model.setLandlordinfoList(sfEstateSource.getLandlordinfoList());
            return model;
        }
        sfStoreHandover.setHandoverAttachmentList(sfStoreHandoverAttachmentMapper.queryHandoverAttachment(sfStoreHandover.getRowId()));
        sfStoreHandover.setImportantEventsList(sfImportantEventsMapper.queryImportantEvents(sfStoreHandover.getRowId()));
        sfStoreHandover.setLandlordinfoList(sfEstateSource.getLandlordinfoList());
        return sfStoreHandover;
    }

    public Map update(SFStoreHandover model, TCsTaskCompletion tCsTaskCompletion){
        Map<String,Object> map =  new HashMap<String,Object>();
        Boolean result = true;
        String message = "保存成功!";
        Integer count = -1;

        //店铺交接进本信息操作
        if(StringUtils.isBlank(model.getRowId())){
            model.setRowId(UUIDUtils.generateKey());
            count = sfStoreHandoverMapper.insertStoreHandover(model);
        }else {
            count = sfStoreHandoverMapper.updateStoreHandover(model);
        }
        //文件交接操作
        if(model.getHandoverAttachmentList()!=null){
            for (SFStoreHandoverAttachment obj:model.getHandoverAttachmentList()){
                if(StringUtils.isNotBlank(obj.getAttachId())){
                    if(StringUtils.isBlank(obj.getRowId())){
                        obj.setHandoverId(model.getRowId());
                        obj.setRowId(UUIDUtils.generateKey());
                        count = sfStoreHandoverAttachmentMapper.insertStoreHandoverAttachment(obj);
                    }else {
                        count = sfStoreHandoverAttachmentMapper.updateStoreHandoverAttachment(obj);
                    }
                }
            }
        }

        //重大事件备忘录操作
        if(model.getImportantEventsList()!=null){
            for (SFImportantEvents obj:model.getImportantEventsList()){
                if(StringUtils.isBlank(obj.getRowId())){
                    obj.setRowId(UUIDUtils.generateKey());
                    obj.setHandoverId(model.getRowId());
                    count = sfImportantEventsMapper.insertImportantEvents(obj);
                }else {
                    count = sfImportantEventsMapper.updaterImportantEvents(obj);
                }
            }
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
}
