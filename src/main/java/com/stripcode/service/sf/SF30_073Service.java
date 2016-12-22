package com.stripcode.service.sf;

import com.stripcode.core.util.UUIDUtils;
import com.stripcode.mybatis.cs.model.TCsTaskCompletion;
import com.stripcode.mybatis.sf.dao.SFStorePhotoAttachementMapper;
import com.stripcode.mybatis.sf.model.SFStorePhotoAttachment;
import com.stripcode.service.BaseService;
import com.stripcode.service.cs.TCsTaskCompletionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.stereotype.Service;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Metro on 2016/10/20.
 */
@Service
@CacheConfig(cacheNames = "sfStorePhotoAttachement")
public class SF30_073Service extends BaseService{
    @Autowired
    private SFStorePhotoAttachementMapper sfStorePhotoAttachementMapper;
    @Autowired
    private TCsTaskCompletionService tCsTaskCompletionService;
    //查询
    public List<SFStorePhotoAttachment> selectPhotoAttachement(String ppId){
        List<SFStorePhotoAttachment> storePhotoAttachmentList =sfStorePhotoAttachementMapper.selectPhotoAttachement(ppId);
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;
        for (SFStorePhotoAttachment model:storePhotoAttachmentList){
            try {
            if(model.getCreaterTime()!=null){
                date = format.parse(model.getCreaterTime());
                model.setCreaterTime(format.format(date));
            }
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return storePhotoAttachmentList;
    }
    //保存修改
    public Map update(List<SFStorePhotoAttachment> StorePhotoList , TCsTaskCompletion csTaskCompletion,String ppId){
        Map modelMap = new HashMap();
        //定义是否成功 用于判断
        boolean result = true;
        //定义后台返回数据
        String message = "保存成功";
        Integer IsExist = 0;
        int count = -1;
        for(SFStorePhotoAttachment SFStorePhotoAttachment :StorePhotoList){
            IsExist = sfStorePhotoAttachementMapper.isExistsPhotoAttachement(SFStorePhotoAttachment.getPpId(), SFStorePhotoAttachment.getTemplateId());
            if(IsExist == 0){
                SFStorePhotoAttachment.setRowId(UUIDUtils.generateKey());
                count = sfStorePhotoAttachementMapper.insertPhotoAttachement(SFStorePhotoAttachment);
            }else {
                count = sfStorePhotoAttachementMapper.updatePhotoAttachement(SFStorePhotoAttachment);
            }
        }
        if(count!=1 ){
            result = false;
            message = "保存失败!";
        }
        csTaskCompletion.setRowId(UUIDUtils.generateKey());
        csTaskCompletion.setCreateTime(null);
        csTaskCompletion.setOptimauthId(ppId);
        tCsTaskCompletionService.upateStatusToFinished(csTaskCompletion);
        tCsTaskCompletionService.updatePipelineType(csTaskCompletion.getTaskId(),ppId);
        modelMap.put("result", result);
        modelMap.put("message", message);
        return modelMap;
    }

}
