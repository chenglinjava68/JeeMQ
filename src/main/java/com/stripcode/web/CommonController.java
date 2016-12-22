package com.stripcode.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * Created by Metro on 2016/9/23.
 */
@Controller
@RequestMapping("/common")
public class CommonController extends  BaseController {
    @RequestMapping("/isExporting")
    @ResponseBody
    public Map<String,Object>  isExporting(Map<String,Object> params,HttpServletRequest request, HttpServletResponse response){
        //定义接口可以被跨域访问
        response.setContentType("application/json;charset=UTF-8");
        response.setHeader("Access-Control-Allow-Origin","*");
        params.put("isExporting",request.getSession().getAttribute("isExporting"));
        params.put("code",1);
        return params;
    }
}
