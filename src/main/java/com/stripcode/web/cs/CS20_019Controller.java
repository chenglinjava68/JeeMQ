package com.stripcode.web.cs;

import com.stripcode.core.dto.cs.CreateOrModifyCsTaskCompletionDto;
import com.stripcode.core.dto.sf.CreateMarketSurvey;
import com.stripcode.core.util.WebUtil;
import com.stripcode.mybatis.cs.model.CSCustomerInfo;
import com.stripcode.mybatis.cs.model.CSSysAttachedTemplate;
import com.stripcode.service.cs.CS20_019Service;
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
 * Created by Metro on 2016/9/11.
 */
@Controller
@RequestMapping("/Cs20_019")
public class CS20_019Controller extends BaseController {
    @Autowired
    private CS20_019Service cs20_019Service;
    @ResponseBody
    @RequestMapping(value = "/read/selectCustomer",method = RequestMethod.POST)
    public Map<String,Object> selectCustomer(String optimauthId,String customerId,HttpServletResponse response){
        Map<String,Object> map = new HashMap<String,Object>();
        if(!StringUtils.isEmpty(customerId)) {
            CSCustomerInfo csCustomerInfo = cs20_019Service.selectCustomer(customerId);
            map.put("main", csCustomerInfo);
        }
        List<CSSysAttachedTemplate> csSysAttachedTemplateList =  cs20_019Service.MarketSurveyList(optimauthId);
        map.put("AttachedList",csSysAttachedTemplateList);
        return map;
    }
   /* @ResponseBody
    @RequestMapping(value = "/read/marketReport",method = RequestMethod.POST)
    public Map<String,Object> MarketSurveyList(String optimauthId,HttpServletResponse response){
        Map<String,Object> map = new HashMap<String, Object>();
       return map;
    }*/
    @ResponseBody
    @RequestMapping(value = "update",method = RequestMethod.POST)
    public Map update(String optimauthId,CreateMarketSurvey dtoSurvey,HttpServletRequest request,CreateOrModifyCsTaskCompletionDto dto,HttpServletResponse response){
        Map<String,Object> map = WebUtil.getParameterMap(request);
        String userId = getCurrUser();
        return cs20_019Service.update(optimauthId,dtoSurvey.getSurveyList(),userId,dto.toModel());
    }
}
