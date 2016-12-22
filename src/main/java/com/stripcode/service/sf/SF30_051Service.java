package com.stripcode.service.sf;

import com.stripcode.core.util.UUIDUtils;
import com.stripcode.mybatis.cs.model.TCsTaskCompletion;
import com.stripcode.mybatis.sf.dao.SFLocationInfoMapper;
import com.stripcode.mybatis.sf.model.SFHypermarketFloor;
import com.stripcode.mybatis.sf.model.SFLocationInfo;
import com.stripcode.mybatis.sf.model.SFPipeinePhotoAttachment;
import com.stripcode.service.cs.TCsTaskCompletionService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author Metro
 */
@Service
@CacheConfig(cacheNames = "SF30_051Service")
public class SF30_051Service {
    @Autowired
    private SFLocationInfoMapper sfLocationInfoMapper;

    @Autowired
    private TCsTaskCompletionService tCsTaskCompletionService;

    /**
     * 保存
     * @param model
     * @return Map
     */
    @Transactional
    public Map update(SFLocationInfo model, TCsTaskCompletion csTaskCompletion){
        Map modelMap = new HashMap();
        Map<String,Object> floorMap = new HashMap<String,Object>();
        Map<String,Object> photoMap = new HashMap<String,Object>();
        Integer count = -1;
        Boolean result = true;
        //数组索引
//        int num = 0;
        String message = "保存成功!";
        //用于删除楼层
        ArrayList floorRowId = new ArrayList();
        //用于删除新址招牌
        ArrayList photoRowId = new ArrayList();
        //判断新增还是修改
        if(StringUtils.isBlank(model.getRowId())){
            //随机rowId
            model.setRowId(UUIDUtils.generateKey());
            //执行新增操作
            count =  sfLocationInfoMapper.insertLocationInfo(model);
        }else {
            //执行修改操作
            count = sfLocationInfoMapper.updateLocationInfo(model);
        }


        if (model.getHypermarketFloorList()!=null){
            //循环新增或修改
            for (SFHypermarketFloor item:model.getHypermarketFloorList()){
                item.setPpId(model.getPpId());
                if(StringUtils.isBlank(item.getRowId())){
                    item.setRowId(UUIDUtils.generateKey());
                    item.setPpId(model.getPpId());
                    count = sfLocationInfoMapper.insertHypermarketFloor(item);
                }else {
                    count = sfLocationInfoMapper.updateHypermarketFloor(item);
                }
                //添加rowId到arrayList
                floorRowId.add(item.getRowId());
//                num++;
//                if(num==model.getHypermarketFloorList().size()){
//                    num=0;
//                }
            }
        }

        if(model.getPhotoAttachmentList()!=null){
            //循环新增或修改
            for (SFPipeinePhotoAttachment item:model.getPhotoAttachmentList()){
                if(StringUtils.isNotBlank(item.getAttachId())){
                    item.setPpId(model.getPpId());
                    if(StringUtils.isBlank(item.getRowId())){
                        item.setRowId(UUIDUtils.generateKey());
                        count = sfLocationInfoMapper.insertPhotoAttachment(item);
                    }else {
                        count = sfLocationInfoMapper.updatePhotoAttachment(item);
                    }
                    //添加rowId到arrayList
                    photoRowId.add(item.getRowId());
                }
            }
        }

        if(floorRowId.size()==0){
            floorMap.put("isFloorNull",0);
        }
        if(photoRowId.size()==0){
            photoMap.put("isPhotoNull",0);
        }
        //执行删除操作
        floorMap.put("rowId",floorRowId);
        floorMap.put("ppId",model.getPpId());
        sfLocationInfoMapper.delHypermarketFloor(floorMap);
        //执行删除操作
        photoMap.put("rowId",photoRowId);
        photoMap.put("ppId",model.getPpId());
        sfLocationInfoMapper.delPhotoAttachment(photoMap);
        if(count!=1){
            result = false;
            message = "保存失败!";
        }
        csTaskCompletion.setRowId(UUIDUtils.generateKey());
        csTaskCompletion.setCreateTime(null);
        csTaskCompletion.setOptimauthId(model.getPpId());
        tCsTaskCompletionService.upateStatusToFinished(csTaskCompletion);
        tCsTaskCompletionService.updatePipelineType(csTaskCompletion.getTaskId(),model.getPpId());
        modelMap.put("rowId",model.getRowId());
        modelMap.put("result",result);
        modelMap.put("message",message);
        return modelMap;
    }

    /**
     * 查询新址照片
     * @param ppId
     * @return list
     */
    public List<SFPipeinePhotoAttachment> queryPhotoAttachment(String ppId){
        List<SFPipeinePhotoAttachment> attachmentList = sfLocationInfoMapper.queryPhotoAttachment(ppId);
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;
        for (SFPipeinePhotoAttachment model : attachmentList){
            try {
                date = format.parse(model.getTime());
                model.setTime(format.format(date));
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return attachmentList;
    }

    /**
     * 查询楼层
     * @param ppId
     * @return
     */
    public List<SFHypermarketFloor> queryHypermarketFloor(String ppId){
        return sfLocationInfoMapper.queryHypermarketFloor(ppId);
    }

    /**
     * 查询位置状况
     * @param ppId
     * @return
     */
    public SFLocationInfo queryLocationInfo(String ppId){
        SFLocationInfo model = sfLocationInfoMapper.queryLocationInfo(ppId);
        if(model!=null){
            model.setHypermarketFloorList(this.queryHypermarketFloor(ppId));
            model.setPhotoAttachmentList(this.queryPhotoAttachment(ppId));
            return model;
        }else{
            SFLocationInfo sfLocationInfo = new SFLocationInfo();
            sfLocationInfo.setHypermarketFloorList(this.queryHypermarketFloor(ppId));
            sfLocationInfo.setPhotoAttachmentList(this.queryPhotoAttachment(ppId));
            return sfLocationInfo;
        }
    }
}
