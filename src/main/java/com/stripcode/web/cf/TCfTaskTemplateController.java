package com.stripcode.web.cf;

import com.stripcode.mybatis.cf.model.TCfTaskTemplate;
import com.stripcode.service.cf.TCfTaskTemplateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

/**
 * Created by Metro on 2016/9/12.
 */
@Controller
@RequestMapping("/taskTemplete")
public class TCfTaskTemplateController {
    @Autowired
    private TCfTaskTemplateService tCfTaskTemplateService;

    @RequestMapping("/read/selectByTaskType")
    @ResponseBody
    public List<TCfTaskTemplate> selectByTaskType(@RequestParam  Map<String,Object> params){
        return tCfTaskTemplateService.selectByTaskType(params);
    }
}
