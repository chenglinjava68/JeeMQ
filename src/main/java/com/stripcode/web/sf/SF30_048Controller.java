package com.stripcode.web.sf;

import com.stripcode.mybatis.cs.model.TCsTaskCompletion;
import com.stripcode.mybatis.sf.model.SFStoreHandover;
import com.stripcode.service.sf.SF30_048Service;
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
@RequestMapping(value = "SF30_048")
public class SF30_048Controller {
    @Autowired
    private SF30_048Service sf30_048Service;

    @Autowired
    private TCodeMacroDefineService tCodeMacroDefineService;

    @ResponseBody
    @RequestMapping(value = "/queryHandoverInfo",method = RequestMethod.POST)
    public Map queryHandoverInfo(String ppId){
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("main",sf30_048Service.queryHandoverInfo(ppId));
        map.put("codeList",tCodeMacroDefineService.queryForContractApply());
        return map;
    }

    @ResponseBody
    @RequestMapping(value = "/update",method = RequestMethod.POST)
    public Map update(SFStoreHandover model, TCsTaskCompletion tCsTaskCompletion){
        return sf30_048Service.update(model,tCsTaskCompletion);
    }
}
