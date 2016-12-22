package com.stripcode.web.cs;

import com.stripcode.mybatis.cs.model.*;
import com.stripcode.service.cs.CS20_010Service;
import com.stripcode.service.user.TCodeMacroDefineService;
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
import java.util.Map;


/**
 * Created by Metro on 2016/8/26.
 */
@Controller
@RequestMapping("/CustomerPP")
public class CS20_010Controller extends BaseController{
    @Autowired
    private CS20_010Service cs20_010Service;
    @Autowired
    private TCodeMacroDefineService tCodeMacroDefineService;

    @ResponseBody
    @RequestMapping(value = "read/selectCPById",method = RequestMethod.POST)
    public Map<String,Object> selectCPById(String customerId,HttpServletRequest request,HttpServletResponse response){

        Map<String,Object> map=new HashMap<String, Object>();

        if(!StringUtils.isEmpty(customerId)){
           CSCustomerInfo csCustomerInfo =cs20_010Service.selectCPById(customerId);
            map.put("main",csCustomerInfo);
        }
        return map;
    }
    //意向店列表

   // public List<CSSfPipeline> selectList(HttpServletResponse response){
   //     return  cs20_010Service.selectList();
   // }


}
