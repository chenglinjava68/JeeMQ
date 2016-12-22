package com.stripcode.web.ps;

import com.stripcode.core.util.UUIDUtils;
import com.stripcode.core.util.WebUtil;
import com.stripcode.mybatis.ps.model.PSPolicySupportImplementation;
import com.stripcode.mybatis.sf.model.SFPolicySupportAssessment;
import com.stripcode.mybatis.user.model.RscSysUser;
import com.stripcode.service.ps.PS70_006Service;
import com.stripcode.service.sf.SF30_002Service;
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
 * Created by Metro on 2016/12/8.
 */
@Controller
@RequestMapping("/PS70_006")
public class PS70_006Controller extends BaseController{
    @Autowired
    private PS70_006Service ps70_006Service;
    @Autowired
    private SF30_002Service sf30002Service;
    @ResponseBody
    @RequestMapping(value = "read/selectCheckId",method = RequestMethod.POST)
    public Map<String,Object> selectCheckId(String CheckId,HttpServletRequest request,HttpServletResponse response){

        Map<String,Object> map=new HashMap<String, Object>();
        if(StringUtils.isBlank(CheckId)){
            CheckId= UUIDUtils.generateKey();
            PSPolicySupportImplementation psPolicySupportImplementation =new PSPolicySupportImplementation();
            /*PSPolicySupportApply psPolicySupportApply =new PSPolicySupportApply();
            psPolicySupportApply.setCheckId(CheckId);*/
            psPolicySupportImplementation.setCheckId(CheckId);
            map.put("main",psPolicySupportImplementation);
        }
       /* if(StringUtils.isBlank(CheckId)){
            CheckId= UUIDUtils.generateKey();
            PSPolicySupportApply psPolicySupportApply =new PSPolicySupportApply();
            psPolicySupportApply.setCheckId(CheckId);
            map.put("main",psPolicySupportApply);
        }*/
        map.put("developerList",sf30002Service.selectAllUser());//查询开发人员
        return map;
    }
    @ResponseBody
    @RequestMapping(value = "read/selectList",method = RequestMethod.POST)
    public List<SFPolicySupportAssessment> selectList(String pids,String rowId,HttpServletResponse response){
        return  ps70_006Service.selectList(pids, rowId);
    }
    @ResponseBody
    @RequestMapping(value = "/update",method = RequestMethod.POST)
    public Map update(PSPolicySupportImplementation psPolicySupportImplementation , HttpServletResponse
            response,HttpServletRequest request)throws Exception{
        Map<String,Object> map = WebUtil.getParameterMap(request);
        return setSuccessModelMap(ps70_006Service.update(psPolicySupportImplementation));
    }

    @ResponseBody
    @RequestMapping(value = "/loadUser",method = RequestMethod.POST)
    public RscSysUser loadUser(){
        return ps70_006Service.loadUser(getCurrUser());
    }
}
