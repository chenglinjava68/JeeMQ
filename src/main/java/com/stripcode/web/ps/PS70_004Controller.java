package com.stripcode.web.ps;


import com.github.pagehelper.PageInfo;
import com.stripcode.core.util.WebUtil;
import com.stripcode.mybatis.common.JQGridObject;

import com.stripcode.mybatis.ps.model.PSPolicySupport;
import com.stripcode.service.ps.PS70_004Service;
import com.stripcode.service.user.TCodeMacroDefineService;
import com.stripcode.web.BaseController;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Metro on 2016/9/26.
 */
@Controller
@RequestMapping("/PS70_004")
public class PS70_004Controller extends BaseController{
    @Autowired
    private PS70_004Service ps70_004Service;
    @Autowired
    private TCodeMacroDefineService tCodeMacroDefineService;
    /*
    * 查询列表
    * */
    @ResponseBody
    @RequestMapping(value="/read/list",method = RequestMethod.POST)
    public JQGridObject list(HttpServletRequest request, HttpServletResponse response){
        Map<String, Object> params = WebUtil.getParameterMap(request);
        PageInfo<PSPolicySupport> list =ps70_004Service.queryForPage(params);
        return  new JQGridObject(list);
    }

    @ResponseBody
    @RequestMapping(value="/read/selectLoad",method = RequestMethod.POST)
    public Map<String,Object> selectLoad (String rowId,HttpServletRequest request,
                                          HttpServletResponse response){
        Map<String,Object> map = new HashMap<String,Object>();
        if(StringUtils.isNotBlank(rowId)){
            PSPolicySupport psPolicySupport = ps70_004Service.queryById(rowId);
            psPolicySupport.setPolicySupportDetailList(ps70_004Service.queryByIdTable(rowId));
            map.put("main",psPolicySupport);
        }else{
            PSPolicySupport psPolicySupport = new PSPolicySupport();
            psPolicySupport.setPolicySupportDetailList(ps70_004Service.queryByIdTable(rowId));
            map.put("main",psPolicySupport);
        }
        map.put("itemList",ps70_004Service.selectSupportDetailList("M0101"));//查询支持项编号
        map.put("codeList", tCodeMacroDefineService.selectSFPipelineStore());//查询列表
        return  map;
    }




    /*
    * 编辑
    * */
    @ResponseBody
    @RequestMapping(value = "/update",method = RequestMethod.POST)
    public Map update( PSPolicySupport psPolicySupport , HttpServletResponse
            response,HttpServletRequest request)throws Exception{
        Map<String,Object> map = WebUtil.getParameterMap(request);
        return setSuccessModelMap(ps70_004Service.update(map,psPolicySupport));
    }
    /*
       * 查询支持项
       * */
    @ResponseBody
    @RequestMapping(value = "/read/selectSupportDetailsList",method = RequestMethod.POST)
    public Map selectSupportDetailList(String policyId){
        return ps70_004Service.selectSupportDetailList(policyId);
    }
    //删除信息
    @ResponseBody
    @RequestMapping(value = "/delete",method = RequestMethod.POST)
    public Map delete(@RequestParam(value = "rowId",required = true) String rowId, HttpServletResponse response){
        //定义接口可以被跨域访问
        response.setContentType("application/json;charset=UTF-8");
        response.setHeader("Access-Control-Allow-Origin","*");
        return setSuccessModelMap(ps70_004Service.delete(rowId));
    }
    @ResponseBody
    @RequestMapping(value = "/updatePolicy",method = RequestMethod.POST)
    public Map updatePolicy( String rowId,String status ,HttpServletResponse response)throws Exception{
        return setSuccessModelMap(ps70_004Service.updatePolicy(rowId,status));
    }
    @ResponseBody
    @RequestMapping(value = "/recoveryPolicy",method = RequestMethod.POST)
    public Map RecoveryPolicy( String rowId,String status ,HttpServletResponse response)throws Exception{
        return setSuccessModelMap(ps70_004Service.recoveryPolicy(rowId,status));
    }
    /**
     * 导出列表数据
     * @param params
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value = "/exportUser")
    public String exportUser( @RequestParam Map<String,Object> params,HttpServletRequest request,HttpServletResponse response){
        ps70_004Service.exportUser(params,request,response);
        return null;
    }
}
