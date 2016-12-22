package com.stripcode.web.sf;

import com.stripcode.core.dto.cs.CreateOrModifyCsTaskCompletionDto;
import com.stripcode.mybatis.sf.model.SFContactInfo;
import com.stripcode.service.sf.SF30_070Service;
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
@RequestMapping("SF30_070")
public class SF30_070Controller {
    @Autowired
    private SF30_070Service sf30_070Service;

    @ResponseBody
    @RequestMapping(value = "/queryContactInfo",method = RequestMethod.POST)
    public Map<String,Object> queryContactInfo(String ppId){
        Map<String,Object> map = new HashMap<String, Object>();
        map.put("main",sf30_070Service.queryContactInfo(ppId));
        return map;
    }

    @ResponseBody
    @RequestMapping(value = "/update",method = RequestMethod.POST)
    public Map update(SFContactInfo model,CreateOrModifyCsTaskCompletionDto csTaskCompletionDto){
        return  sf30_070Service.update(model,csTaskCompletionDto.toModel());
    }
}
