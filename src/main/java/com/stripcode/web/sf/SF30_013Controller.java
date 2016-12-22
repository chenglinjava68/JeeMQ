package com.stripcode.web.sf;

import com.stripcode.mybatis.cs.model.TCsTaskCompletion;
import com.stripcode.mybatis.sf.model.SFConsPreSurveyReport;
import com.stripcode.service.sf.SF30_013Service;
import com.stripcode.service.user.RscSysUserService;
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
@RequestMapping(value = "/SF30_013")
public class SF30_013Controller {
    @Autowired
    private SF30_013Service sf30_013Service;

    @Autowired
    private TCodeMacroDefineService tCodeMacroDefineService;

    @Autowired
    private RscSysUserService rscSysUserService;

    @ResponseBody
    @RequestMapping(value = "/queryReport",method = RequestMethod.POST)
    public Map<String,Object> queryReport(String ppId){
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("main",sf30_013Service.queryReport(ppId));
        map.put("codeList",tCodeMacroDefineService.selectForConsSurvey());
        map.put("directorList",rscSysUserService.query());
        return map;
    }

    @ResponseBody
    @RequestMapping(value = "/update",method = RequestMethod.POST)
    public Map<String,Object> update(SFConsPreSurveyReport model, TCsTaskCompletion tCsTaskCompletion){
        return sf30_013Service.update(model,tCsTaskCompletion);
    }
}
