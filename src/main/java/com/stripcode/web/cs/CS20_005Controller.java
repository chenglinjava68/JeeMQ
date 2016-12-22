package com.stripcode.web.cs;

import com.stripcode.core.util.WebUtil;
import com.stripcode.mybatis.common.JQGridObject;
import com.stripcode.mybatis.cs.model.CSMarketOptimauth;
import com.stripcode.service.cs.CS20_005Service;
import com.stripcode.service.user.TCodeMacroDefineService;
import com.stripcode.web.BaseController;
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
 * Created by Metro on 2016/8/22.
 */
@Controller
@RequestMapping(value = "CS20_005")
public class CS20_005Controller extends BaseController {
    @Autowired
    private CS20_005Service cs20_005Service;

    @Autowired
    private TCodeMacroDefineService tCodeMacroDefineService;

    @ResponseBody
    @RequestMapping(value = "/read/list",method = RequestMethod.POST)
    public JQGridObject list(HttpServletResponse response,HttpServletRequest request){
        Map<String,Object> params = WebUtil.getParameterMap(request);
        return new JQGridObject(cs20_005Service.query(params));
    }

    @ResponseBody
    @RequestMapping(value = "/bindSelect",method = RequestMethod.POST)
    public Map<String,Object> bindSelect(HttpServletResponse response){
        Map<String ,Object> map = new HashMap<String ,Object>();
        map.put("codeList", tCodeMacroDefineService.selectForOptimauth());
        return map;
    }

    @ResponseBody
    @RequestMapping(value = "/queryOptimauth",method = RequestMethod.POST)
    public CSMarketOptimauth queryOptimauth(String optimauthId){
        return cs20_005Service.queryOptimauth(optimauthId);
    }

    @ResponseBody
    @RequestMapping(value = "/exportOptimauth")
    public String exportOptimauth(@RequestParam Map<String,Object> params, HttpServletRequest request, HttpServletResponse response){
        cs20_005Service.selectForExport(params,request,response);
        return null;
    }
}
