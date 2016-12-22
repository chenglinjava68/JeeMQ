package com.stripcode.web.cs;

import com.stripcode.core.dto.cs.CreateOrModifyCsTaskCompletionDto;
import com.stripcode.mybatis.cs.model.CSContractSigning;
import com.stripcode.service.cs.CS20_031Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Metro
 */
@Controller
@RequestMapping("/CS20_031")
public class CS20_031Controller {
    @Autowired
    private CS20_031Service cs20_031Service;

    @ResponseBody
    @RequestMapping(value = "/querySignInfo",method = RequestMethod.POST)
    public Map<String,Object> querySignInfo(String customerId,String optimauthId){
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("main",cs20_031Service.querySignInfo(customerId,optimauthId));
        return map;
    }

    @ResponseBody
    @RequestMapping(value = "/save",method = RequestMethod.POST)
    public Map<String,Object> save(CSContractSigning model, CreateOrModifyCsTaskCompletionDto dto){
        return cs20_031Service.save(model,dto.toModel());
    }
}
