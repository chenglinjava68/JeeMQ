package com.stripcode.web.cs;

import com.stripcode.core.dto.cs.CreateOrModifyCsTaskCompletionDto;
import com.stripcode.mybatis.cs.model.CSContractAttachment;
import com.stripcode.service.cs.CS20_015Service;
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
@RequestMapping(value = "CS20_015")
public class CS20_015Controller {
    @Autowired
    private CS20_015Service cs20_015Service;

    @ResponseBody
    @RequestMapping(value = "queryErpAndCustomerInfo",method = RequestMethod.POST)
    public Map<String,Object> queryErpAndCustomerInfo(String optimauthId){
        Map<String,Object> map = new HashMap<String, Object>();
        map.put("main",cs20_015Service.queryErpAndCustomerInfo(optimauthId));
        return map;
    }

    @ResponseBody
    @RequestMapping(value = "query",method = RequestMethod.POST)
    public List<CSContractAttachment> query(String optimauthId){
        return cs20_015Service.query(optimauthId);
    }

    @ResponseBody
    @RequestMapping(value = "insertContractInfo",method = RequestMethod.POST)
    public Map insertContractInfo(String optimauthId,String taskId){
        CreateOrModifyCsTaskCompletionDto csTaskCompletionDto = new CreateOrModifyCsTaskCompletionDto();
        csTaskCompletionDto.setOptimauthId(optimauthId);
        csTaskCompletionDto.setTaskId(taskId);
        return cs20_015Service.insertContractInfo(optimauthId,csTaskCompletionDto.toModel());
    }

}
