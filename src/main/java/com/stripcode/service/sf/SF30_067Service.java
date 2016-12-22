package com.stripcode.service.sf;


import com.stripcode.core.util.UUIDUtils;

import com.stripcode.mybatis.cs.model.TCsTaskCompletion;
import com.stripcode.mybatis.sf.dao.SFPolicySupportAgreeAttachmentMapper;
import com.stripcode.mybatis.sf.dao.SFPolicySupportAgreeMapper;
import com.stripcode.mybatis.sf.dao.SFPolicySupportAssessmentMapper;
import com.stripcode.mybatis.sf.dao.SFPolicySupportMapper;
import com.stripcode.mybatis.sf.model.SFPolicySupport;
import com.stripcode.mybatis.sf.model.SFPolicySupportAgree;
import com.stripcode.mybatis.sf.model.SFPolicySupportAgreeAttachment;
import com.stripcode.service.cs.TCsTaskCompletionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Metro on 2016/10/20.
 */
@Service
@CacheConfig(cacheNames = "psPolicySupportAgree")
public class SF30_067Service {
    @Autowired
    private SFPolicySupportAgreeMapper sfPolicySupportAgreeMapper;
    @Autowired
    private SFPolicySupportAgreeAttachmentMapper sfPolicySupportAgreeAttachmentMapper;
    @Autowired
    private SFPolicySupportMapper sfPolicySupportMapper;
    @Autowired
    private TCsTaskCompletionService tCsTaskCompletionService;
    @Autowired
    private SFPolicySupportAssessmentMapper sfPolicySupportAssessmentMapper;

    @Autowired
    private SF30_056Service sf30_056Service;
    /*
      根据customerId查询客户意向店 客户信息
       */
    public SFPolicySupportAgree selectSFById(String customerId) {
        return sfPolicySupportAgreeMapper.selectById(customerId);
    }
    /**
     * 查询协议申请列表
     * @return
     */
    public List<SFPolicySupportAgreeAttachment> selectSFPolicySupportAgreeAttachment(String ppId){
        return  sfPolicySupportAgreeAttachmentMapper.selectSFPolicySupportAgreeAttachment(ppId);
    }

    public List<SFPolicySupportAgreeAttachment> selectPpId(String ppId){
        return sfPolicySupportAgreeAttachmentMapper.selectPpId(ppId);
    }
    public Map<String, Object> update(SFPolicySupport sfPolicySupport, TCsTaskCompletion csTaskCompletion)throws Exception{
        Map <String, Object> reMap =  new HashMap<String, Object>();
        int count = -1;
        //保存或修改是否成功
        boolean result = true;
        //返回到前台的提示信息
        String message = "生成成功!";
        String templateId = "6cd97736-974e-11e6-bced-480fcf39";
        sfPolicySupportMapper.deleteInser(templateId,sfPolicySupport.getPpId());

        String ppId=sfPolicySupport.getPpId();
        List list= sf30_056Service.selectAll(ppId);
        for(int i=0;i<list.size();i++){
            SFPolicySupportAgreeAttachment sfPolicySupportAgreeAttachment =new SFPolicySupportAgreeAttachment();
            sfPolicySupportAgreeAttachment.setRowId(UUIDUtils.generateKey());
            sfPolicySupportAgreeAttachment.setPpId(ppId);
            sfPolicySupportAgreeAttachment.setAttachId("1c928d80e30647c9a1e23d9f6b78e67e");
            sfPolicySupportAgreeAttachment.setTemplateId(templateId);
            count = sfPolicySupportMapper.insertAttachment(sfPolicySupportAgreeAttachment);
            if (count!=1){
                result = false;
                message = "保存失败!";
            }
        }

        //保存后鱼骨图打钩
        csTaskCompletion.setRowId(UUIDUtils.generateKey());
        csTaskCompletion.setOptimauthId(sfPolicySupport.getPpId());
        tCsTaskCompletionService.upateStatusToFinished(csTaskCompletion);
        tCsTaskCompletionService.updatePipelineType(csTaskCompletion.getTaskId(),sfPolicySupport.getPpId());
        reMap.put("result", result);
        reMap.put("message", message);
        return reMap;
     }
}
