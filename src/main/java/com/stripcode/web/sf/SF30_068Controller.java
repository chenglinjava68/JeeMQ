package com.stripcode.web.sf;

import com.stripcode.mybatis.cs.model.CSSfPipeline;
import com.stripcode.mybatis.cs.model.TCsTaskCompletion;
import com.stripcode.mybatis.sf.model.SFPolicySupport;
import com.stripcode.mybatis.sf.model.SFPolicySupportAgreeAttachment;
import com.stripcode.mybatis.sf.model.SFProgressEst;
import com.stripcode.service.sf.SF30_054Service;
import com.stripcode.service.sf.SF30_058Service;
import com.stripcode.service.sf.SF30_067Service;
import com.stripcode.service.sf.SF30_068Service;
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
 * Created by Metro on 2016/10/24.
 */
@Controller
@RequestMapping("/SF30_068")
public class SF30_068Controller extends BaseController {
    @Autowired
    private SF30_058Service sf30_058Service;
    @Autowired
    private SF30_068Service sf30_068Service;
    @Autowired
    private SF30_067Service sf30_067Service;
    @Autowired
    private SF30_054Service sf30_054Service;
    @Autowired
    private TCodeMacroDefineService tCodeMacroDefineService;
    @ResponseBody
    @RequestMapping(value = "/selectApprovalAll",method = RequestMethod.POST)
    public Map<String,Object> selectSFById(String customerId, String ppId, String erpCode, HttpServletRequest request, HttpServletRequest response){
        Map<String,Object> map=new HashMap<String, Object>();
        CSSfPipeline csSfPipeline = sf30_058Service.selectApprovalAll(customerId, ppId, erpCode);
        List<SFProgressEst> list = sf30_068Service.selectProgressAll(ppId);
        for (SFProgressEst model:list){
            if("M0328".equals(model.getTaskCode())){
                csSfPipeline.setActualDate(model.getActualDate());
            }
        }
        map.put("main",csSfPipeline);
        return map;
    }
    @ResponseBody
    @RequestMapping(value="/read/selectSFPolicySupportAttachment",method = RequestMethod.POST)
    public Map<String,Object> selectSFPolicySupportAttachment(String ppId){
        Map<String,Object> map = new HashMap<String, Object>();
        List<SFPolicySupportAgreeAttachment> sfPolicySupportAgreeAttachmentList =sf30_068Service.selectSFPolicySupportAttachment(ppId);
        map.put("mainList",sfPolicySupportAgreeAttachmentList);
        return map ;
    }
    /*
        * 编辑
        * */
    @ResponseBody
    @RequestMapping(value = "/update",method = RequestMethod.POST)
    public Map update(String ppId, SFPolicySupport sfPolicySupport , TCsTaskCompletion csTaskCompletion, HttpServletResponse
            response)throws Exception{

        return setSuccessModelMap(sf30_068Service.update(ppId,sfPolicySupport,csTaskCompletion));
    }


}
