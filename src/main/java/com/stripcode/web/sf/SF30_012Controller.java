package com.stripcode.web.sf;

import com.stripcode.mybatis.cs.model.TCsTaskCompletion;
import com.stripcode.mybatis.sf.model.SFTradezoneInfo;
import com.stripcode.service.sf.SF30_012Service;
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
@RequestMapping("/SF30_012")
public class SF30_012Controller {
    @Autowired
    private SF30_012Service sf30_012Service;

    @Autowired
    private TCodeMacroDefineService tCodeMacroDefineService;

    @ResponseBody
    @RequestMapping(value = "/queryTaInfo",method = RequestMethod.POST)
    public Map<String,Object> queryTaInfo(String ppId){
        Map<String,Object> map =  new HashMap<String,Object>();
        map.put("main",sf30_012Service.queryTaInfo(ppId));
        map.put("codeList",tCodeMacroDefineService.selectForTradezone());
        return map;
    }

    @ResponseBody
    @RequestMapping(value = "update",method = RequestMethod.POST)
    public Map<String,Object> update(SFTradezoneInfo model, TCsTaskCompletion tCsTaskCompletion){
        return sf30_012Service.update(model,tCsTaskCompletion);
    }
}
