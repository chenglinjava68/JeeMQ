package com.stripcode.web.cs;

import com.stripcode.core.util.WebUtil;
import com.stripcode.mybatis.cs.model.*;
import com.stripcode.service.cs.CS20_012Service;
import com.stripcode.web.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * Created by Metro on 2016/8/22.
 */
@Controller
@RequestMapping(value = "CS20_012")
public class CS20_012Controller extends BaseController {
    @Autowired
    private CS20_012Service cs20_012Service;

    @ResponseBody
    @RequestMapping(value = "/queryBusinessFlanByOptimauthId",method = RequestMethod.POST)
    public List<CSBusinessFlan> queryBusinessFlanByOptimauthId(String optimauthId){
        return cs20_012Service.queryBusinessFlanByOptimauthId(optimauthId);
    }

    @ResponseBody
    @RequestMapping(value = "/queryStoreSalesLastYear",method = RequestMethod.POST)
    public List<CSStoreSalesLastYear> queryStoreSalesLastYear(String optimauthId){
        return cs20_012Service.queryStoreSalesLastYear(optimauthId);
    }

    @ResponseBody
    @RequestMapping(value = "/update",method = RequestMethod.POST)
    public Map update(RenewMarketauz model,HttpServletRequest request,TCsTaskCompletion tCsTaskCompletion){
        Map<String,Object> map = WebUtil.getParameterMap(request);
        return cs20_012Service.update(map,model,tCsTaskCompletion);
    }

}
