package com.stripcode.service.sf;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.stripcode.core.util.PageSortUtil;
import com.stripcode.core.util.UUIDUtils;
import com.stripcode.mybatis.cs.dao.CSCustomerInfoMapper;
import com.stripcode.mybatis.cs.model.CSCustomerInfo;
import com.stripcode.mybatis.cs.model.TCsTaskCompletion;
import com.stripcode.mybatis.ps.model.PSPolicySupport;
import com.stripcode.mybatis.sf.dao.SFPolicySupportAgreeAttachmentMapper;
import com.stripcode.mybatis.sf.dao.SFPolicySupportAssessmentMapper;
import com.stripcode.mybatis.sf.dao.SFPolicySupportDetailMapper;
import com.stripcode.mybatis.sf.dao.SFPolicySupportMapper;
import com.stripcode.mybatis.sf.model.SFPolicySupport;
import com.stripcode.mybatis.sf.model.SFPolicySupportAgreeAttachment;
import com.stripcode.mybatis.sf.model.SFPolicySupportAssessment;
import com.stripcode.mybatis.sf.model.SFPolicySupportDetail;
import com.stripcode.service.BaseService;
import com.stripcode.service.cs.TCsTaskCompletionService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Metro on 2016/9/28.
 */
@Service
@CacheConfig(cacheNames = "psPolicyItem")
public class SF30_056Service extends BaseService{
    @Autowired
    private SFPolicySupportMapper sfPolicySupportMapper;
    @Autowired
    private SFPolicySupportDetailMapper sfPolicySupportDetailMapper;
    @Autowired
    private CSCustomerInfoMapper csCustomerInfoMapper;
    @Autowired
    private SFPolicySupportAssessmentMapper sfPolicySupportAssessmentMapper;
    @Autowired
    private TCsTaskCompletionService tCsTaskCompletionService;
    @Autowired
    private SFPolicySupportAgreeAttachmentMapper sfPolicySupportAgreeAttachmentMapper;
    public PageInfo<PSPolicySupport> psPolicyQueryForPage(Map<String ,Object> params){
        //合并orderBy Sord
        PageSortUtil.unoinSortBySord(params);
        PageHelper.startPage(params);
        return new PageInfo<PSPolicySupport>(sfPolicySupportMapper.psPolicyQueryForPage(params));
    }

    /*
        根据customerId查询客户意向店 客户信息
         */
    public CSCustomerInfo selectSFById(String customerId) {
        return csCustomerInfoMapper.selectById(customerId);
    }
    public List<SFPolicySupportAgreeAttachment> selectSFPolicyDetail(String ppId){
        return  sfPolicySupportAgreeAttachmentMapper.selectSFPolicyDetail(ppId);
    }
    public SFPolicySupport selectPolicyOne(String ppId,String customerId) {
        SFPolicySupport sfPolicySupport=sfPolicySupportMapper.selectPolicyOne(ppId);
        if(sfPolicySupport!=null){
            sfPolicySupport.setCsCustomerInfo(csCustomerInfoMapper.selectById(customerId));
            sfPolicySupport.setSfPolicySupportDetailList(selectAll(ppId));
            return sfPolicySupport;
        }else {
            SFPolicySupport model = new SFPolicySupport();
            model.setCsCustomerInfo(csCustomerInfoMapper.selectById(customerId));
            model.setSfPolicySupportDetailList(selectAll(ppId));
            return model;
        }
    }
    /*
    查询政策选择
     */
    public List<PSPolicySupport> selectPolicy(String policy){
        return sfPolicySupportMapper.selectPolicy(policy);
    }
    //政策支持里面保存后查询政策
    public List<SFPolicySupport> queryPolicy(String ppId){
        return sfPolicySupportMapper.queryPolicy(ppId);
    }
    public List<SFPolicySupportDetail> selectAll(String ppId){
        return sfPolicySupportDetailMapper.selectAll(ppId);
    }
    @Transactional
    public Map update(SFPolicySupport model,TCsTaskCompletion csTaskCompletion)throws Exception{
        Map<String,Object> map = new HashMap<String,Object>();
        Map<String,Object> policyMap = new HashMap<String,Object>();
        Map<String,Object> policyMap1 = new HashMap<String,Object>();
        ArrayList policyArray = new ArrayList();
        ArrayList policyArray1 = new ArrayList();
        int count = -1;
        //保存或修改是否成功
        boolean result = true;
        Integer isRowNull =0;
        //返回到前台的提示信息
        String message = "保存成功!";
        String rowId = model.getRowId();
        // 保存政策
        if(StringUtils.isBlank(rowId)){
            rowId = UUIDUtils.generateKey();
            model.setRowId(rowId);
            count = sfPolicySupportMapper.insert(model);
        }else{
            count = sfPolicySupportMapper.update(model);
        }
       if (model.getSfPolicySupportDetailList()!=null){
           for(SFPolicySupportDetail item:model.getSfPolicySupportDetailList()){
               SFPolicySupportAssessment assessment = new SFPolicySupportAssessment();
               assessment.setRowId(item.getRowId());
               assessment.setPpId(model.getPpId());
               assessment.setSupportItem(item.getSupportItem());
               assessment.setSupportMode(item.getSupportMode());
               assessment.setSales(item.getMoney());
               assessment.setOperateYear(item.getOperationTerm());
               assessment.setAssessmentItem(item.getCheckTarget());
               assessment.setTarget(item.getCheckValue());
                   assessment.setPsAssId(item.getRowId());
               if(StringUtils.isBlank(item.getRowId())){
                   item.setRowId(UUIDUtils.generateKey());
                   item.setPsId(model.getRowId());
                   assessment.setRowId(item.getRowId());
                   assessment.setPsAssId(item.getRowId());
                   count =  sfPolicySupportDetailMapper.insertPolicySupportDetail(item);
                   count =  sfPolicySupportAssessmentMapper.insertPolicySupportAssessment(assessment);
               }else{
                   count =  sfPolicySupportDetailMapper.updatePolicySupportDetail(item);
                   count =  sfPolicySupportAssessmentMapper.updatePolicySupportAssessment(assessment);
               }
               policyArray.add(item.getRowId());
           }
       }
        Integer isPolicyDelete = 1;
        Integer isPolicyDelete1 = 1;
        if(policyArray.size()==0){
            isPolicyDelete = 0;
        }

        policyMap.put("isDelete",isPolicyDelete);
        policyMap.put("rowId",policyArray);
        policyMap.put("psId",model.getRowId());
        policyMap1.put("isDelete",isPolicyDelete1);

        policyMap1.put("ppId",model.getPpId());
        policyMap1.put("rowId",policyArray);
        sfPolicySupportDetailMapper.deleteByPolicy(policyMap);
        sfPolicySupportAssessmentMapper.deleteByPolicy1(policyMap1);
       /* // 删除列表中多余的数据
        if(rowIds!=null&&rowIds.length!=0){
            isRowNull = 1;
        }
        sfPolicySupportDetailMapper.deletByPolicyDetail(rowIds,rowId,isRowNull);*/
        if (count!=1){
            result = true;
            message = "保存失败!";
        }
        csTaskCompletion.setRowId(UUIDUtils.generateKey());
        csTaskCompletion.setCreateTime(null);
        csTaskCompletion.setOptimauthId(model.getPpId());
        tCsTaskCompletionService.upateStatusToFinished(csTaskCompletion);
        tCsTaskCompletionService.updatePipelineType(csTaskCompletion.getTaskId(),model.getPpId());
        map.put("rowId",model.getRowId());
        map.put("result", result);
        map.put("message", message);
        return map;
    }
}
