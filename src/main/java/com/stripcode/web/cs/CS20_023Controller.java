package com.stripcode.web.cs;

import com.stripcode.core.dto.cs.CreateOrModifyCsTaskCompletionDto;
import com.stripcode.core.util.WebUtil;
import com.stripcode.mybatis.cs.model.CSBusinessFlan;
import com.stripcode.service.cs.CS20_023Service;
import com.stripcode.service.user.TCodeMacroDefineService;
import com.stripcode.web.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Metro
 */
@Controller
@RequestMapping("/CS20_023")
public class CS20_023Controller extends BaseController {
    @Autowired
    private CS20_023Service cs20_023Service;

    @Autowired
    private TCodeMacroDefineService tCodeMacroDefineService;

    @ResponseBody
    @RequestMapping(value = "/queryBusinessFlanByOptimauthId",method = RequestMethod.POST)
    public List<CSBusinessFlan> queryBusinessFlanByOptimauthId(String optimauthId){
        return cs20_023Service.queryBusinessFlanByOptimauthId(optimauthId);
    }

    @ResponseBody
    @RequestMapping(value = "queryCustomerAndInvest",method = RequestMethod.POST)
    public Map<String,Object> queryCustomerAndInvest(String customerId,String optimauthId){
        Map<String,Object> map = new HashMap<String, Object>();
        map.put("main",cs20_023Service.queryById(customerId, optimauthId));
        map.put("ctList",tCodeMacroDefineService.selectForFlan());
        return map;
    }

    @ResponseBody
    @RequestMapping(value = "/updateBusinessFlan",method = RequestMethod.POST)
    public Map updateBusinessFlan(HttpServletRequest request,CreateOrModifyCsTaskCompletionDto csTaskCompletionDto){
        Map<String,Object> map = WebUtil.getParameterMap(request);
        return cs20_023Service.updateBusinessFlan(map,csTaskCompletionDto.toModel());
    }
}
