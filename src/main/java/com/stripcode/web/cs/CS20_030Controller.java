package com.stripcode.web.cs;

import com.stripcode.core.dto.cs.CreateOrModifyCsTaskCompletionDto;
import com.stripcode.mybatis.cs.model.CSContractAttachment;
import com.stripcode.mybatis.cs.model.CSRenewalContractinfo;
import com.stripcode.service.cs.CS20_030Service;
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
@RequestMapping(value = "/CS20_030")
public class CS20_030Controller {
    @Autowired
    private CS20_030Service cs20_030Service;

    @ResponseBody
    @RequestMapping(value = "/queryContractInfo",method = RequestMethod.POST)
    public Map queryContractInfo(String customerId,String optimauthId){
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("main",cs20_030Service.queryContractInfo(customerId, optimauthId));
        return map;
    }
    @ResponseBody
    @RequestMapping(value = "/update",method = RequestMethod.POST)
    public Map update(CSRenewalContractinfo model, CreateOrModifyCsTaskCompletionDto dto){
        return cs20_030Service.update(model,dto.toModel());
    }

    @ResponseBody
    @RequestMapping(value = "/selectAttachment",method = RequestMethod.POST)
    public List<CSContractAttachment> selectAttachment(String optimauthId){
        return cs20_030Service.selectAttachment(optimauthId);
    }
}
