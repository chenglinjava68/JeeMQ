package com.stripcode.web.common;

import com.stripcode.core.dto.common.CreateOrModifyCommonAttachDto;
import com.stripcode.service.common.COMMON90_001Service;
import com.stripcode.web.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Metro on 2016/12/14.
 */
@Controller
@RequestMapping("/COMMON90_001")
public class COMMON90_001Controller extends BaseController {
    @Autowired
    private COMMON90_001Service common90_001Service;
    @RequestMapping("/queryAttachList")
    @ResponseBody
    public Map queryAttachList(String attachId){
        Map map = new HashMap<String,Object>();
        map.put("attachs",common90_001Service.queryAttachList(attachId));
        return map;
    }
    @RequestMapping("/update")
    @ResponseBody
    public Map update(@Valid  CreateOrModifyCommonAttachDto dto){
        return common90_001Service.update(dto.getAttachs());
    }
    @RequestMapping("/delete")
    @ResponseBody
    public Map update(String versionNo){
        return common90_001Service.delete(versionNo);
    }
}
