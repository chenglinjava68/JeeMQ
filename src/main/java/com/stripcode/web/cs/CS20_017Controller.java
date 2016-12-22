package com.stripcode.web.cs;

import com.stripcode.core.dto.cs.CreateOrModifyCsTaskCompletionDto;
import com.stripcode.mybatis.cs.model.CSCertificateOfPayment;
import com.stripcode.mybatis.cs.model.CSContractSigning;
import com.stripcode.mybatis.cs.model.TSysAttachedTemplate;
import com.stripcode.service.cs.CS20_017Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Metro
 */
@Controller
@RequestMapping("CS20_017")
public class CS20_017Controller {
    @Autowired
    private CS20_017Service cs20_017Service;

    @ResponseBody
    @RequestMapping(value = "query",method = RequestMethod.POST)
    public Map<String,Object> query(String optimauthId,String customerId){
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("main",cs20_017Service.selectByOptimauthId(optimauthId,customerId));
        return map;
    }

    @ResponseBody
    @RequestMapping(value = "update",method = RequestMethod.POST)
    public Map update(CSContractSigning csContractSigning, CreateOrModifyCsTaskCompletionDto dto){
        return cs20_017Service.updateSigning(csContractSigning,dto.toModel());
    }

    @ResponseBody
    @RequestMapping(value = "queryAll",method = RequestMethod.POST)
    public List<CSContractSigning> queryAll(String optimauthId){
        return cs20_017Service.queryAll(optimauthId);
    }

    @ResponseBody
    @RequestMapping(value = "queryAttachedTemplate",method = RequestMethod.POST)
    public List<CSCertificateOfPayment> queryAttachedTemplate(String optimauthId){
        return cs20_017Service.queryAttachedTemplate(optimauthId);
    }
    @ResponseBody
    @RequestMapping(value = "updateTempleteJoinId",method = RequestMethod.POST)
    public Map updateTempleteJoinId(TSysAttachedTemplate tSysAttachedTemplate){
        return cs20_017Service.updateTempleteJoinId(tSysAttachedTemplate);
    }
}
