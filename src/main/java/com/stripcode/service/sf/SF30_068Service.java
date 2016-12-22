package com.stripcode.service.sf;

import com.stripcode.core.util.UUIDUtils;
import com.stripcode.mybatis.cs.model.TCsTaskCompletion;
import com.stripcode.mybatis.sf.dao.SFPolicySupportAgreeAttachmentMapper;
import com.stripcode.mybatis.sf.dao.SFPolicySupportAgreeMapper;
import com.stripcode.mybatis.sf.dao.SFPolicySupportMapper;
import com.stripcode.mybatis.sf.dao.SFProgressEstMapper;
import com.stripcode.mybatis.sf.model.SFPolicySupport;
import com.stripcode.mybatis.sf.model.SFPolicySupportAgreeAttachment;
import com.stripcode.mybatis.sf.model.SFProgressEst;
import com.stripcode.service.cs.TCsTaskCompletionService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import java.util.List;

/**
 * Created by Metro on 2016/10/24.
 */
@Service
@CacheConfig(cacheNames = "psPolicySupportAgree")
public class SF30_068Service {
    @Autowired
    private SFPolicySupportAgreeMapper sfPolicySupportAgreeMapper;
    @Autowired
    private SFPolicySupportAgreeAttachmentMapper sfPolicySupportAgreeAttachmentMapper;
    @Autowired
    private SFPolicySupportMapper sfPolicySupportMapper;
    @Autowired
    private SFProgressEstMapper sfProgressEstMapper;
    @Autowired
    private TCsTaskCompletionService tCsTaskCompletionService;
    public List<SFPolicySupportAgreeAttachment> selectSFPolicySupportAttachment(String ppId){
        return  sfPolicySupportAgreeAttachmentMapper.selectSFPolicySupportAttachment(ppId);
    }
    /*public ModelMap update(SFPolicySupportAgreeAttachment model, TCsTaskCompletion csTaskCompletion)throws Exception{
        ModelMap modelMap = new ModelMap();
        int count = -1;
        //保存或修改是否成功
        boolean result = true;
        Integer isRowNull =0;
        //返回到前台的提示信息
        String message = "保存成功!";
        String rowId = model.getRowId();
        // 保存政策协议表
        if(StringUtils.isBlank(rowId)){
            rowId = UUIDUtils.generateKey();
            model.setRowId(rowId);
            count = sfPolicySupportAgreeAttachmentMapper.insert(model);
        }else{
            count = sfPolicySupportAgreeAttachmentMapper.update(model);
        }
        if (count!=1){
            result = false;
            message = "保存失败!";
        }
        csTaskCompletion.setRowId(UUIDUtils.generateKey());
        csTaskCompletion.setCreateTime(null);
        csTaskCompletion.setOptimauthId(model.getPpId());
        tCsTaskCompletionService.upateStatusToFinished(csTaskCompletion);
        modelMap.put("result", result);
        modelMap.put("message", message);
        return modelMap;
    }*/
    public ModelMap update(String ppId, SFPolicySupport sfPolicySupport, TCsTaskCompletion csTaskCompletion)throws Exception{
        ModelMap modelMap = new ModelMap();
        int count = -1;
        //保存或修改是否成功
        boolean result = true;
        Integer IsExist = 0;
        //返回到前台的提示信息
        String message = "保存成功!";

       // IsExist =sfPolicySupportMapper.isExistsSFPolicySupport2(sfPolicySupport.getRowId(),sfPolicySupport.getPpId());
        for(SFPolicySupportAgreeAttachment sfPolicySupportAttachment: sfPolicySupport.getListAttachment()){
          /*IsExist = sfPolicySupportMapper.isExistsSFPolicySupport2(sfPolicySupport.getRowId(),sfPolicySupportAttachment.getTemplateId());*/
            if(StringUtils.isNotBlank(sfPolicySupportAttachment.getAttachId())){
                /*if(IsExist==0){*/
                    sfPolicySupportAttachment.setPpId(ppId);
                    if(StringUtils.isBlank(sfPolicySupportAttachment.getRowId())) {
                        sfPolicySupportAttachment.setRowId(UUIDUtils.generateKey());
                        count = sfPolicySupportMapper.insertAttachment2(sfPolicySupportAttachment);
                    }else{
                        count = sfPolicySupportMapper.updateAttachment2(sfPolicySupportAttachment);
                    }
                /*}*/
            }
        }
        if (count!=1){
            result = false;
            message = "保存失败!";
        }
        csTaskCompletion.setRowId(UUIDUtils.generateKey());
        csTaskCompletion.setCreateTime(null);
        csTaskCompletion.setOptimauthId(sfPolicySupport.getPpId());
        tCsTaskCompletionService.upateStatusToFinished(csTaskCompletion);
        tCsTaskCompletionService.updatePipelineType(csTaskCompletion.getTaskId(),sfPolicySupport.getPpId());
        modelMap.put("result", result);
        modelMap.put("message", message);
        return modelMap;
    }
    //政策支持协议签字上传查询实际签约日期
    public List<SFProgressEst> selectProgressAll(String ppId){
        return sfProgressEstMapper.selectProgressAll(ppId);
    }
}
