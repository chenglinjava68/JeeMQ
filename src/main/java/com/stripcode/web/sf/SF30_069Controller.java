package com.stripcode.web.sf;

import com.stripcode.mybatis.cs.model.CSSfPipeline;
import com.stripcode.mybatis.cs.model.TCsTaskCompletion;
import com.stripcode.mybatis.sf.model.SFPolicySupportAgreeAttachment;
import com.stripcode.mybatis.sf.model.SFPolicySupportAssessment;
import com.stripcode.mybatis.sf.model.SFPolicySupportDetail;
import com.stripcode.service.ps.PS70_004Service;
import com.stripcode.service.sf.SF30_058Service;
import com.stripcode.service.sf.SF30_069Service;
import com.stripcode.web.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Metro on 2016/10/24.
 */
@Controller
@RequestMapping("/SF30_069")
public class SF30_069Controller extends BaseController {
    @Autowired
    private SF30_058Service sf30_058Service;
    @Autowired
    private SF30_069Service sf30_069Service;
    @Autowired
    private PS70_004Service ps70_004Service;
    @ResponseBody
    @RequestMapping(value = "/selectApprovalAll",method = RequestMethod.POST)
    public Map<String,Object> selectSFById(String customerId, String ppId, String erpCode, HttpServletRequest request, HttpServletRequest response){
        Map<String,Object> map=new HashMap<String, Object>();
        CSSfPipeline csSfPipeline = sf30_058Service.selectApprovalAll(customerId, ppId, erpCode);
        map.put("itemList",ps70_004Service.selectSupportDetailList("M0101"));
        map.put("main",csSfPipeline);
        return map;
    }
    @ResponseBody
    @RequestMapping(value = "/queryInfo",method = RequestMethod.POST)
    public Map<String,Object> queryInfo(String ppId){
        Map<String,Object> map = new HashMap<String, Object>();
        List<SFPolicySupportDetail> sfPolicySupportDetails =sf30_069Service.queryInfo(ppId);
            map.put("queryInfoList",sfPolicySupportDetails);
        return map ;
    }
    @ResponseBody
    @RequestMapping(value="/read/selectSFPolicyAttachment",method = RequestMethod.POST)
    public Map<String,Object> selectSFPolicyAttachment(String ppId){
        Map<String,Object> map = new HashMap<String, Object>();
        List<SFPolicySupportAgreeAttachment> sfPolicySupportAgreeAttachmentList =sf30_069Service.selectSFPolicyAttachment(ppId);
        map.put("selectAllList",sf30_069Service.selectAllList(ppId));
        map.put("mainList",sfPolicySupportAgreeAttachmentList);
        return map ;
    }
    @ResponseBody
    @RequestMapping(value="/selectInfo",method = RequestMethod.POST)
    public Map<String,Object> selectInfo(String ppId){
        Map<String,Object> map = new HashMap<String, Object>();
        List<SFPolicySupportAssessment> sfPolicySupportAssessments =sf30_069Service.selectAllList(ppId);
        map.put("sfPolicySupportAssessmentList",sfPolicySupportAssessments);
        return map ;
    }
    @ResponseBody
    @RequestMapping(value = "/update",method = RequestMethod.POST)
    public Map update(String ppId, SFPolicySupportDetail sfPolicySupportDetail , TCsTaskCompletion csTaskCompletion, HttpServletResponse
            response)throws Exception{

        return setSuccessModelMap(sf30_069Service.update(ppId,sfPolicySupportDetail,csTaskCompletion));
    }
}
