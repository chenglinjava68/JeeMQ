package com.stripcode.web.sf;

import com.github.pagehelper.PageInfo;
import com.stripcode.core.util.WebUtil;
import com.stripcode.mybatis.common.JQGridObject;
import com.stripcode.mybatis.cs.model.TCsTaskCompletion;
import com.stripcode.mybatis.ps.model.PSPolicySupport;
import com.stripcode.mybatis.sf.model.SFPolicySupport;
import com.stripcode.mybatis.sf.model.SFPolicySupportAgreeAttachment;
import com.stripcode.service.ps.PS70_004Service;
import com.stripcode.service.sf.SF30_056Service;
import com.stripcode.service.user.TCodeMacroDefineService;
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
 * Created by Metro on 2016/9/28.
 */
@Controller
@RequestMapping("/SF30_056")
public class SF30_056Controller extends BaseController{
    @Autowired
    private SF30_056Service sf30_056Service;
    @Autowired
    private PS70_004Service ps70_004Service;
    @Autowired
    private TCodeMacroDefineService tCodeMacroDefineService;
    @ResponseBody
    @RequestMapping(value="/read/list",method = RequestMethod.POST)
    public JQGridObject list(HttpServletRequest request, HttpServletResponse response){
        Map<String, Object> params = WebUtil.getParameterMap(request);
        PageInfo<PSPolicySupport> list =sf30_056Service.psPolicyQueryForPage(params);
        return  new JQGridObject(list);
    }
    @ResponseBody
    @RequestMapping(value = "read/selectSFById",method = RequestMethod.POST)
    public Map<String,Object> selectSFById(String ppId,String customerId,String policy, HttpServletRequest request, HttpServletRequest reponse){
        Map<String,Object> map=new HashMap<String, Object>();
            SFPolicySupport sfPolicySupport = sf30_056Service.selectPolicyOne(ppId,customerId);
            map.put("main",sfPolicySupport);
        map.put("AllList",sf30_056Service.selectAll(ppId));
        map.put("policyList",sf30_056Service.selectPolicy(policy));
        map.put("queryPolicyList",sf30_056Service.queryPolicy(ppId));
        map.put("itemList",ps70_004Service.selectSupportDetailList("M0101"));
        map.put("codeList", tCodeMacroDefineService.selectPolicySupportDetail());//查询列表
        //map.put("codeList",tCodeMacroDefineService.selectSFSupport());
        return map;
    }

    @ResponseBody
    @RequestMapping(value="/read/selectSFPolicyDetail",method = RequestMethod.POST)
    public Map<String,Object> selectSFPolicyDetail(String ppId){
        Map<String,Object> map = new HashMap<String, Object>();
        List<SFPolicySupportAgreeAttachment> sfPolicySupportAgreeAttachmentList =sf30_056Service.selectSFPolicyDetail(ppId);
        map.put("main",sfPolicySupportAgreeAttachmentList);
        return map ;
    }
    /*
        * 编辑
        * */
    @ResponseBody
    @RequestMapping(value = "/update",method = RequestMethod.POST)
    public Map update(SFPolicySupport sfPolicySupport , TCsTaskCompletion csTaskCompletion, HttpServletResponse
            response,HttpServletRequest request)throws Exception{
        Map<String,Object> map = WebUtil.getParameterMap(request);
        return setSuccessModelMap(sf30_056Service.update(sfPolicySupport,csTaskCompletion));
    }

}
