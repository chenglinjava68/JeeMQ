package com.stripcode.web.sf;

import com.stripcode.mybatis.cs.model.TCsTaskCompletion;
import com.stripcode.mybatis.sf.model.SFEstateSource;
import com.stripcode.service.sf.SF30_008Service;
import com.stripcode.service.user.TCodeMacroDefineService;
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
@RequestMapping("SF30_008")
public class SF30_008Controller {

    @Autowired
    private SF30_008Service sf30_008Service;

    @Autowired
    private TCodeMacroDefineService tCodeMacroDefineService;

    @ResponseBody
    @RequestMapping(value = "/queryEstateSource",method = RequestMethod.POST)
    public Map<String,Object> queryEstateSource(String ppId){
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("main",sf30_008Service.queryEstateSource(ppId));
        map.put("codeList",tCodeMacroDefineService.selectForLandlord());
        return map;
    }

    @ResponseBody
    @RequestMapping(value = "/update",method = RequestMethod.POST)
    public Map<String,Object> update(SFEstateSource sfEstateSource, TCsTaskCompletion tCsTaskCompletion){
        return sf30_008Service.update(sfEstateSource,tCsTaskCompletion);
    }
}
