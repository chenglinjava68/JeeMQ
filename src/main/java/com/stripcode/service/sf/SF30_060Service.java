package com.stripcode.service.sf;

import com.stripcode.core.util.UUIDUtils;
import com.stripcode.mybatis.cs.model.TCsTaskCompletion;
import com.stripcode.mybatis.sf.dao.SFLandlordLayoutMapper;
import com.stripcode.service.cs.TCsTaskCompletionService;
import org.apache.commons.lang3.StringUtils;
import com.stripcode.mybatis.sf.dao.SFDesignApplyMapper;
import com.stripcode.mybatis.sf.model.*;
import com.stripcode.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by Metro on 2016/10/18.
 */
@Service
@CacheConfig(cacheNames = "SFDesignApply")
public class SF30_060Service extends BaseService {
    @Autowired
    private SFDesignApplyMapper sfDesignApplyMapper;
    @Autowired
    private TCsTaskCompletionService tCsTaskCompletionService;
    @Autowired
    private SFLandlordLayoutMapper sfLandlordLayoutMapper;
    //查询楼层
    public List<SFFloorInfo> selectFloor(String ppId){
        return sfDesignApplyMapper.selectFloor(ppId);
    }
    //查询图纸列表
    public List<SFDesignApplyAttachment> selectApplyAttachment(String ppId){
        List<SFDesignApplyAttachment> sfDesignApplyAttachmentList = sfDesignApplyMapper.selectApplyAttachment(ppId);
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;
        for (SFDesignApplyAttachment model : sfDesignApplyAttachmentList){
            try {
                if(model.getUpdatTime()!=null){
                    date = format.parse(model.getUpdatTime());
                    model.setUpdatTime(format.format(date));
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return sfDesignApplyAttachmentList;
    }
    //功能需求
    public List<SFDesignApplyDetail> selectApplyDetail(String ppId){
        return sfDesignApplyMapper.selectApplyDetail(ppId);
    }
    //设计其他需求
    public SFDesignApply selectDesignApply(String ppId){
        SFDesignApply sfDesignApply = sfDesignApplyMapper.selectDesignApply(ppId);
        if(sfDesignApply==null){
            sfDesignApply = new SFDesignApply();
            sfDesignApply.setListDesignApplyAttachment(this.selectApplyAttachment(ppId));
            sfDesignApply.setApplyDetailList(this.selectApplyDetail(ppId));
        }else{
            sfDesignApply.setListDesignApplyAttachment(this.selectApplyAttachment(ppId));
            sfDesignApply.setApplyDetailList(this.selectApplyDetail(ppId));
        }
        return  sfDesignApply;
    }
    //保存
    @Transactional
    public ModelMap update(List<SFLandlordLayout> sfLandLord ,SFDesignApply sfDesignApply,TCsTaskCompletion csTaskCompletion){
        ModelMap modelMap = new ModelMap();
        //定义是否成功 用于判断
        boolean result = true;
        //定义后台返回数据
        String message = "保存成功";
        Integer IsExist = 0;
        int count = -1;
        IsExist = sfDesignApplyMapper.isExistsDesignApply(sfDesignApply.getRowId(),sfDesignApply.getPpId());
        if(IsExist==0){
            if(StringUtils.isBlank(sfDesignApply.getRowId())) {
                sfDesignApply.setRowId(UUIDUtils.generateKey());
                count = sfDesignApplyMapper.insertDesignApply(sfDesignApply);
            }
        }else {
                count = sfDesignApplyMapper.updateDesignApply(sfDesignApply);
        }
        for(SFDesignApplyAttachment sfDesignApplyAttachment: sfDesignApply.getListDesignApplyAttachment()){
            IsExist = sfDesignApplyMapper.isExistsApplyAttachment(sfDesignApply.getRowId(),sfDesignApplyAttachment.getTemplateId());
            if(IsExist==0){
                if(StringUtils.isBlank(sfDesignApplyAttachment.getRowId())) {
                    sfDesignApplyAttachment.setRowId(UUIDUtils.generateKey());
                    sfDesignApplyAttachment.setDesignId(sfDesignApply.getRowId());
                    count = sfDesignApplyMapper.insertApplyAttachment(sfDesignApplyAttachment);
                }
            }else{
                sfDesignApplyAttachment.setDesignId(sfDesignApply.getRowId());
                count = sfDesignApplyMapper.updateApplyAttachment(sfDesignApplyAttachment);
            }
        }
        for(SFDesignApplyDetail sfDesignApplyDetail : sfDesignApply.getApplyDetailList()){
            IsExist = sfDesignApplyMapper.isExistsApplyDetail(sfDesignApply.getRowId(),sfDesignApplyDetail.getItem());
            if(IsExist == 0){
                if(StringUtils.isBlank(sfDesignApplyDetail.getRowId())){
                    sfDesignApplyDetail.setRowId(UUIDUtils.generateKey());
                    sfDesignApplyDetail.setDesignId(sfDesignApply.getRowId());
                    count = sfDesignApplyMapper.insertApplyDetail(sfDesignApplyDetail);
                }
            } else{
                    sfDesignApplyDetail.setDesignId(sfDesignApply.getRowId());
                    count = sfDesignApplyMapper.updateApplyDetail(sfDesignApplyDetail);
            }
        }
        for(SFLandlordLayout sfLandlordLayout :sfLandLord){
            IsExist = sfLandlordLayoutMapper.HousePaperCount(sfLandlordLayout.getPpId(),sfLandlordLayout.getTemplateId());
            if(IsExist == 0){
                count = sfLandlordLayoutMapper.insertHousePaper(sfLandlordLayout);
            }else {
                count = sfLandlordLayoutMapper.updateHousePaper(sfLandlordLayout);
            }
        }
        if(count!=1 ){
            result = false;
            message = "保存失败!";
        }
        csTaskCompletion.setRowId(UUIDUtils.generateKey());
        csTaskCompletion.setCreateTime(null);
        csTaskCompletion.setOptimauthId(sfDesignApply.getPpId());
        tCsTaskCompletionService.upateStatusToFinished(csTaskCompletion);
        tCsTaskCompletionService.updatePipelineType(csTaskCompletion.getTaskId(),sfDesignApply.getPpId());
        modelMap.put("rowId",sfDesignApply.getRowId());
        modelMap.put("result", result);
        modelMap.put("message", message);
        return modelMap;
    }
}
