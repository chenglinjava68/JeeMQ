package com.stripcode.web.cs;

import com.stripcode.mybatis.cs.model.CSCustomerErpInfo;
import com.stripcode.service.cs.CS20_029Service;
import com.stripcode.web.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Metro on 2016/12/8.
 */
@Controller
@RequestMapping(value = "CS20_029")
public class CS20_029Controller extends BaseController {
    @Autowired
    private CS20_029Service cs20_029Service;
    @ResponseBody
    @RequestMapping(value = "/queryByReNewInfo",method = RequestMethod.POST)
    public Map<String,Object> queryByReNewInfo(String customerId,String rowId,HttpServletResponse response){
        Map<String,Object> map = new HashMap<String,Object>();
        CSCustomerErpInfo csCustomerErpInfo = cs20_029Service.queryByReNewInfo(customerId,rowId);
            map.put("main",csCustomerErpInfo);
        return map;
    }

}
