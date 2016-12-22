package com.stripcode.web.cs;

import com.stripcode.mybatis.cs.model.CSNegotiation;
import com.stripcode.service.cs.CS20_022Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

/**
 * @author Metro
 */
@Controller
@RequestMapping("CS20_022")
public class CS20_022Controller {
    @Autowired
    private CS20_022Service cs20_022Service;

    @ResponseBody
    @RequestMapping(value = "query",method = RequestMethod.POST)
    public List<CSNegotiation>  query(String customerId){
        return cs20_022Service.query(customerId);
    }

    @ResponseBody
    @RequestMapping(value = "detailsByRecordId",method = RequestMethod.POST)
    public CSNegotiation detailsByRecordId(String recordId){
        return cs20_022Service.detailsByRecordId(recordId);
    }

    @ResponseBody
    @RequestMapping(value = "updateNegotiation",method = RequestMethod.POST)
    public Map updateNegotiation(CSNegotiation csNegotiation){
        return cs20_022Service.updateNegotiation(csNegotiation);
    }

    @ResponseBody
    @RequestMapping(value = "/exportNegotiation")
    public String exportNegotiation(Map<String,Object> params, HttpServletRequest request, HttpServletResponse response,String customerId){
        cs20_022Service.exportNegotiation(request,response,customerId);
        return null;
    }
}
