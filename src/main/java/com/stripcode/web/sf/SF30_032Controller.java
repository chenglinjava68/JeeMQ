package com.stripcode.web.sf;

import com.stripcode.mybatis.cs.model.TCsTaskCompletion;
import com.stripcode.mybatis.sf.model.SFProgressEst;
import com.stripcode.service.sf.SF30_032Service;
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
@RequestMapping(value = "/SF30_032")
public class SF30_032Controller {
    @Autowired
    private SF30_032Service sf30_032Service;

    @ResponseBody
    @RequestMapping(value = "/querySignInfo",method = RequestMethod.POST)
    public Map querySignInfo(String ppId){
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("main",sf30_032Service.queryInfo(ppId));
        return map;
    }

    @ResponseBody
    @RequestMapping(value = "/update",method = RequestMethod.POST)
    public Map update(SFProgressEst sfProgressEst, TCsTaskCompletion tCsTaskCompletion){
        return sf30_032Service.update(sfProgressEst,tCsTaskCompletion);
    }
}
