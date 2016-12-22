package com.stripcode.web.sf;

import com.stripcode.mybatis.cs.model.TCsTaskCompletion;
import com.stripcode.mybatis.sf.model.SFContractApply;
import com.stripcode.service.sf.SF30_031Service;
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
@RequestMapping(value = "/SF30_031")
public class SF30_031Controller {
    @Autowired
    private SF30_031Service sf30_031Service;

    @Autowired
    private TCodeMacroDefineService tCodeMacroDefineService;

    @ResponseBody
    @RequestMapping(value = "/queryContractApplyAndAttachment",method = RequestMethod.POST)
    public Map<String,Object> queryContractApplyAndAttachment(String ppId){
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("main",sf30_031Service.queryContractApplyAndAttachment(ppId));
        map.put("codeList",tCodeMacroDefineService.queryForContractApply());
        return map;
    }

    @ResponseBody
    @RequestMapping(value = "/updateContractApply",method = RequestMethod.POST)
    public Map<String,Object> update(SFContractApply model, TCsTaskCompletion tCsTaskCompletion){
        return sf30_031Service.updateContractApply(model,tCsTaskCompletion);
    }

    @ResponseBody
    @RequestMapping(value = "/updateAttachment",method = RequestMethod.POST)
    public Map<String,Object> updateAttachment(SFContractApply model){
        return sf30_031Service.updateAttachment(model);
    }
}
