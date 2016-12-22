package com.stripcode.web.sf;

import com.stripcode.mybatis.cs.model.CSCustomerInfo;
import com.stripcode.mybatis.cs.model.CSSfPipeline;
import com.stripcode.mybatis.cs.model.TCsTaskCompletion;
import com.stripcode.mybatis.sf.model.SFPolicySupport;
import com.stripcode.mybatis.sf.model.SFPolicySupportAgree;
import com.stripcode.mybatis.sf.model.SFPolicySupportAgreeAttachment;
import com.stripcode.service.sf.SF30_056Service;
import com.stripcode.service.sf.SF30_058Service;
import com.stripcode.service.sf.SF30_067Service;
import com.stripcode.web.BaseController;
import org.apache.commons.lang3.StringUtils;
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
 * Created by Metro on 2016/10/20.
 */
@Controller
@RequestMapping("/SF30_067")
public class SF30_067Controller extends BaseController {
    @Autowired
    private SF30_056Service sf30_056Service;
    @Autowired
    private SF30_058Service sf30_058Service;
    @Autowired
    private SF30_067Service sf30_067Service;
    @ResponseBody
    @RequestMapping(value = "read/selectSFById",method = RequestMethod.POST)
    public Map<String,Object> selectSFById(String customerId, HttpServletRequest request, HttpServletRequest reponse){
        Map<String,Object> map=new HashMap<String, Object>();
        if(StringUtils.isNotBlank(customerId)){
            CSCustomerInfo csCustomerInfo = sf30_056Service.selectSFById(customerId);
            map.put("main",csCustomerInfo);
        }
        return map;
    }
    @ResponseBody
    @RequestMapping(value = "/selectApprovalAll",method = RequestMethod.POST)
    public Map<String,Object> selectSFById(String customerId,String ppId,String erpCode, HttpServletRequest request, HttpServletRequest response){
        Map<String,Object> map=new HashMap<String, Object>();
        CSSfPipeline csSfPipeline = sf30_058Service.selectApprovalAll(customerId, ppId, erpCode);
        map.put("main",csSfPipeline);
        return map;
    }
    @ResponseBody
    @RequestMapping(value = "/selectSFByIdAgree",method = RequestMethod.POST)
    public Map<String,Object> selectSFByIdAgree(String customerId, HttpServletRequest request, HttpServletRequest reponse){
        Map<String,Object> map=new HashMap<String, Object>();
        if(StringUtils.isNotBlank(customerId)){
            SFPolicySupportAgree sfPolicySupportAgree = sf30_067Service.selectSFById(customerId);
            map.put("main",sfPolicySupportAgree);
        }
        return map;
    }

    @ResponseBody
    @RequestMapping(value = "selectPpId",method = RequestMethod.POST)
    public List<SFPolicySupportAgreeAttachment> selectPpId(String ppId){
        return sf30_067Service.selectPpId(ppId);
    }
    /*@ResponseBody
    @RequestMapping(value="/read/selectSFPolicySupportAgreeAttachment",method = RequestMethod.POST)
    public Map<String,Object> selectSFPolicySupportAgreeAttachment(String ppId){
        Map<String,Object> map = new HashMap<String, Object>();
        List<SFPolicySupportAgreeAttachment> sfPolicySupportAgreeAttachmentList =sf30_067Service.selectSFPolicySupportAgreeAttachment(ppId);
        map.put("main",sfPolicySupportAgreeAttachmentList);
        return map ;
    }*/

    /*
        * 编辑
        * */
    @ResponseBody
    @RequestMapping(value = "/update",method = RequestMethod.POST)
    public Map update(SFPolicySupport sfPolicySupport , TCsTaskCompletion csTaskCompletion, HttpServletResponse
            response)throws Exception{

        return setSuccessModelMap(sf30_067Service.update(sfPolicySupport,csTaskCompletion));
    }
}
