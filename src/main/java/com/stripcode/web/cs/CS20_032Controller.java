package com.stripcode.web.cs;

import com.stripcode.mybatis.cs.model.RenewMarketauz;
import com.stripcode.mybatis.cs.model.TCsTaskCompletion;
import com.stripcode.service.cs.CS20_032Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

/**
 * @author Metro
 */
@Controller
@RequestMapping(value = "/CS20_032")
public class CS20_032Controller {
    @Autowired
    private CS20_032Service cs20_032Service;
    @ResponseBody
    @RequestMapping(value = "/update",method = RequestMethod.POST)
    public Map update(RenewMarketauz model, TCsTaskCompletion tCsTaskCompletion){
        return cs20_032Service.update(model, tCsTaskCompletion);
    }
}
