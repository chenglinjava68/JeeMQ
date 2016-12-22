package com.stripcode.web.sf;

import com.stripcode.core.dto.cs.CreateOrModifyCsTaskCompletionDto;
import com.stripcode.mybatis.sf.model.SFLocationInfo;
import com.stripcode.service.sf.SF30_051Service;
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
@RequestMapping(value = "SF30_051")
public class SF30_051Controller {
    @Autowired
    private SF30_051Service sf30_051Service;
    @Autowired
    private TCodeMacroDefineService tCodeMacroDefineService;

    /**
     * 保存
     * @param model
     * @return Map
     */
    @ResponseBody
    @RequestMapping(value = "update",method = RequestMethod.POST)
    public Map update(SFLocationInfo model, CreateOrModifyCsTaskCompletionDto csTaskCompletionDto){
        return sf30_051Service.update(model,csTaskCompletionDto.toModel());
    }

    /**
     * 查询场地信息
     * @param ppId
     * @param taskId
     * @return map
     */
    @ResponseBody
    @RequestMapping(value = "queryLocationInfo",method = RequestMethod.POST)
    public Map<String,Object> queryLocationInfo(String ppId,String taskId){
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("main",sf30_051Service.queryLocationInfo(ppId));
        map.put("codeList",tCodeMacroDefineService.queryForLocation());
        return map;
    }
}
