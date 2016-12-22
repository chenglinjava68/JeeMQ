package com.stripcode.web.sf;

import com.stripcode.core.dto.cs.CreateOrModifyCsTaskCompletionDto;
import com.stripcode.mybatis.sf.model.SFAcceptance;
import com.stripcode.service.sf.SF30_071Service;
import com.stripcode.service.user.TCodeMacroDefineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Metro
 */
@Controller
@RequestMapping("SF30_071")
public class SF30_071Controller {
    @Autowired
    private SF30_071Service sf30_071Service;

    @Autowired
    private TCodeMacroDefineService tCodeMacroDefineService;

    @ResponseBody
    @RequestMapping(value = "queryAcceptance",method = RequestMethod.POST)
    public Map<String,Object> queryAcceptance(String ppId){
        Map<String,Object> map = new HashMap<String, Object>();
        map.put("main",sf30_071Service.queryAcceptance(ppId));
        map.put("codeList",tCodeMacroDefineService.queryForSiteArea());
        return map;
    }

    @ResponseBody
    @RequestMapping(value = "update",method = RequestMethod.POST)
    public ModelMap update(SFAcceptance sfAcceptance, CreateOrModifyCsTaskCompletionDto dto){
        return sf30_071Service.update(sfAcceptance,dto.toModel());
    }
}
