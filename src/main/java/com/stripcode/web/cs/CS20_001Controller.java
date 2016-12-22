package com.stripcode.web.cs;

import com.stripcode.core.util.WebUtil;
import com.stripcode.mybatis.common.JQGridObject;
import com.stripcode.mybatis.cs.model.CSCustomerInfo;
import com.stripcode.service.cs.CS20_001Service;
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
 * Created by cyy on 2016/8/19.
 */
@Controller
@RequestMapping(value = "CS20_001")
public class CS20_001Controller extends BaseController {
    @Autowired
    private CS20_001Service CS20_001Service;

    @Autowired
    private TCodeMacroDefineService tCodeMacroDefineService;

    @ResponseBody
    @RequestMapping(value = "/read/list",method = RequestMethod.POST)
    public JQGridObject list(HttpServletRequest request,HttpServletResponse response){
        Map<String,Object> params = WebUtil.getParameterMap(request);
        return new JQGridObject(CS20_001Service.query(params));
    }

    @ResponseBody
    @RequestMapping(value = "/update",method = RequestMethod.POST)
    public Map update(CSCustomerInfo csCustomerInfo, HttpServletResponse response)throws Exception{
        //获取当前登录用户的ID
        Integer age = csCustomerInfo.getAge();
        if("NaN".equals(age)){
            age=null;
            csCustomerInfo.setAge(age);
        }

        return setSuccessModelMap(CS20_001Service.update(csCustomerInfo));
    }

    @ResponseBody
    @RequestMapping(value = "read/details",method = RequestMethod.POST)
    public Map<String,Object> details(String customerId,HttpServletRequest request,HttpServletResponse response){
        Map<String,Object> map = new HashMap<String, Object>();
        if(StringUtils.isNotBlank(customerId)){
            CSCustomerInfo csCustomerInfo = CS20_001Service.queryById(customerId);
            map.put("main",csCustomerInfo);
        }

        map.put("officeList",CS20_001Service.queryAllOffice());
        map.put("codeList", tCodeMacroDefineService.selectForCustomer());
        return map;
    }

    @ResponseBody
    @RequestMapping(value = "isExistsByIdNumber",method = RequestMethod.POST)
    public Map<String ,Object> isExistsByIdNumber(String idNumber,String customerId){
        return CS20_001Service.isExistsByIdNumber(idNumber,customerId);
    }

    @ResponseBody
    @RequestMapping(value = "isExistsByCompanyName",method = RequestMethod.POST)
    public Map<String ,Object> isExistsByCompanyName(String companyName,String customerId){
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("valid",CS20_001Service.isExistsByCompanyName(companyName,customerId));
        return map;
    }

    @ResponseBody
    @RequestMapping(value = "isExistsByBusinessLicense",method = RequestMethod.POST)
    public Map<String ,Object> isExistsByBusinessLicense(String businessLicense,String customerId){
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("valid",CS20_001Service.isExistsByBusinessLicense(businessLicense,customerId));
        return map;
    }

    @ResponseBody
    @RequestMapping(value = "/exportCustomer")
    public String exportCustomer(@RequestParam Map<String,Object> params, HttpServletRequest request, HttpServletResponse response){
        CS20_001Service.exportCustomer(params,request,response);
        return null;
    }
}
