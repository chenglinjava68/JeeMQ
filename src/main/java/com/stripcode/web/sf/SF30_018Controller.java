package com.stripcode.web.sf;

import com.stripcode.mybatis.cs.model.TCsTaskCompletion;
import com.stripcode.mybatis.sf.model.TSfConsSurveyReportCover;
import com.stripcode.service.sf.SF30_018Service;
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
@RequestMapping(value = "SF30_018")
public class SF30_018Controller {
    @Autowired
    private SF30_018Service sf30_018Service;

    @Autowired
    private TCodeMacroDefineService tCodeMacroDefineService;

    @Autowired
    private RscSysUserService rscSysUserService;

    @ResponseBody
    @RequestMapping(value = "queryAll",method = RequestMethod.POST)
    public Map<String,Object> queryAll(String ppId){
        Map<String,Object> map = new HashMap<String,Object>();

        map.put("main",sf30_018Service.queryAll(ppId));
        map.put("codeList",tCodeMacroDefineService.selectForConsSurvey());
        map.put("directorList",rscSysUserService.query());
        return map;
    }

    @ResponseBody
    @RequestMapping(value = "update",method = RequestMethod.POST)
    public Map<String,Object> update(TSfConsSurveyReportCover model, TCsTaskCompletion tCsTaskCompletion){
        return sf30_018Service.update(model,tCsTaskCompletion);
    }
}
