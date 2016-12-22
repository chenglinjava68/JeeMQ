package com.stripcode.service.sf;

import com.stripcode.core.util.UUIDUtils;
import com.stripcode.mybatis.cs.model.TCsTaskCompletion;
import com.stripcode.mybatis.sf.dao.SFPolicySupportAgreeAttachmentMapper;
import com.stripcode.mybatis.sf.dao.SFPolicySupportAssessmentMapper;
import com.stripcode.mybatis.sf.dao.SFPolicySupportDetailMapper;
import com.stripcode.mybatis.sf.dao.SFPolicySupportMapper;
import com.stripcode.mybatis.sf.model.*;
import com.stripcode.service.cs.TCsTaskCompletionService;
import org.apache.commons.lang3.StringUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Metro on 2016/10/24.
 */
@Service
@CacheConfig(cacheNames = "sfPolicySupportDetail")
public class SF30_069Service {
    @Autowired
    private SFPolicySupportDetailMapper sfPolicySupportDetailMapper;
    @Autowired
    private SFPolicySupportAssessmentMapper sfPolicySupportAssessmentMapper;
    @Autowired
    private SFPolicySupportAgreeAttachmentMapper sfPolicySupportAgreeAttachmentMapper;
    @Autowired
    private SFPolicySupportMapper sfPolicySupportMapper;
    @Autowired
    private TCsTaskCompletionService tCsTaskCompletionService;
    public List<SFPolicySupportDetail> queryInfo(String ppId){
        return sfPolicySupportDetailMapper.queryInfo(ppId);
    }
    public List<SFPolicySupportAgreeAttachment> selectSFPolicyAttachment(String ppId){
        return  sfPolicySupportAgreeAttachmentMapper.selectSFPolicyAttachment(ppId);
    }
    public List<SFPolicySupportDetail> selectInfo(String ppId){
        return sfPolicySupportAssessmentMapper.selectInfo(ppId);
    }
    public List<SFPolicySupportDetail> selectAll(String ppId){
        return sfPolicySupportDetailMapper.selectAll(ppId);
    }
    public List<SFPolicySupportAssessment> selectAllList(String ppId){
        return sfPolicySupportAssessmentMapper.selectAllList(ppId);
    }

    public Map update(String ppId,SFPolicySupportDetail sfPolicySupportDetail, TCsTaskCompletion csTaskCompletion)throws Exception{
        Map<String,Object> map = new HashMap<String,Object>();
        Map<String,Object> policyMap = new HashMap<String,Object>();
        ArrayList policyArray = new ArrayList();
        int count = -1;
        //保存或修改是否成功
        boolean result = true;
        Integer IsExist = 0;
        //返回到前台的提示信息
        String message = "保存成功!";
        if (sfPolicySupportDetail.getSfPolicySupportAssessmentList()!=null){
            for(SFPolicySupportAssessment item:sfPolicySupportDetail.getSfPolicySupportAssessmentList()){
                if(StringUtils.isBlank(item.getRowId())){
                    item.setRowId(UUIDUtils.generateKey());
                    item.setPsAssId(sfPolicySupportDetail.getRowId());
                    count =  sfPolicySupportAssessmentMapper.insertPolicySupportAssessment(item);
                }else{
                    count =  sfPolicySupportAssessmentMapper.updatePolicySupportAssessment(item);
                }
                policyArray.add(item.getRowId());
            }
        }


        //IsExist =sfPolicySupportMapper.isExistsSFPolicySupport3(sfPolicySupportDetail.getRowId(),sfPolicySupportDetail.getPsId());

        for(SFPolicySupportAgreeAttachment sfPolicyAttachment: sfPolicySupportDetail.getListAttachment()){
            /*IsExist = sfPolicySupportMapper.isExistsSFPolicySupport3(sfPolicySupportDetail.getRowId(),sfPolicyAttachment.getTemplateId());*/
            if(StringUtils.isNotBlank(sfPolicyAttachment.getAttachId())){
                /*if(IsExist==0) {*/
                    sfPolicyAttachment.setPpId(ppId);
                    if(StringUtils.isBlank(sfPolicyAttachment.getRowId())) {
                        sfPolicyAttachment.setRowId(UUIDUtils.generateKey());
                        count = sfPolicySupportMapper.insertAttachment3(sfPolicyAttachment);
                    }else {
                        count = sfPolicySupportMapper.updateAttachment3(sfPolicyAttachment);
                    }
                /*}*/
            }
        }
        Integer isPolicyDelete = 1;
        if(policyArray.size()==0){
            isPolicyDelete = 0;
        }
        policyMap.put("isDelete",isPolicyDelete);
        policyMap.put("rowId",policyArray);
        policyMap.put("psAssId",sfPolicySupportDetail.getRowId());
        sfPolicySupportAssessmentMapper.deleteByPolicySupportAssessment(policyMap);
        if (count!=1){
            result = false;
            message = "保存失败!";
        }
        csTaskCompletion.setRowId(UUIDUtils.generateKey());
        csTaskCompletion.setCreateTime(null);
        csTaskCompletion.setOptimauthId(ppId);
        tCsTaskCompletionService.upateStatusToFinished(csTaskCompletion);
        tCsTaskCompletionService.updatePipelineType(csTaskCompletion.getTaskId(),ppId);
        map.put("result", result);
        map.put("message", message);
        return map;
    }
}
