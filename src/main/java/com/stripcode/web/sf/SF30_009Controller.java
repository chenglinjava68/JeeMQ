package com.stripcode.web.sf;

import com.stripcode.mybatis.cs.model.TCsTaskCompletion;
import com.stripcode.mybatis.sf.model.SFLandlordNegotiation;
import com.stripcode.service.sf.SF30_009Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Metro
 */
@Controller
@RequestMapping("/SF30_009")
public class SF30_009Controller {
    @Autowired
    private SF30_009Service sf30_009Service;

    @ResponseBody
    @RequestMapping(value = "/queryNegotiation",method = RequestMethod.POST)
    public List<SFLandlordNegotiation> queryNegotiation(String ppId){
        return sf30_009Service.queryNegotiation(ppId);
    }

    @ResponseBody
    @RequestMapping(value = "/update",method = RequestMethod.POST)
    public Map<String,Object> update(SFLandlordNegotiation model, TCsTaskCompletion taskCompletion){
        return sf30_009Service.update(model,taskCompletion);
    }

    @ResponseBody
    @RequestMapping(value = "queryNegotiationInfo",method = RequestMethod.POST)
    public Map<String,Object> queryNegotiationInfo(String ppId,String rowId){
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("main",sf30_009Service.queryNegotiationInfo(ppId,rowId));
        return map;
    }

    @ResponseBody
    @RequestMapping(value = "export",method = RequestMethod.GET)
    public String export(@RequestParam String ppId, HttpServletRequest request, HttpServletResponse response){
        sf30_009Service.export(ppId,request,response);
        return null;
    }
}
