package com.stripcode.web.am;

import com.stripcode.mybatis.am.model.AMAuthorizationInfo;
import com.stripcode.service.am.AM40_012Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

/**
 * Created by Metro on 2016/10/27.
 */
@Controller
@RequestMapping(value = "AM40_012")
public class AM40_012Controller {

    @Autowired
    private AM40_012Service am40_012Service;
    @ResponseBody
    @RequestMapping(value = "update",method = RequestMethod.POST)
    public Map update(AMAuthorizationInfo model){
        return am40_012Service.update(model);
    }
}
