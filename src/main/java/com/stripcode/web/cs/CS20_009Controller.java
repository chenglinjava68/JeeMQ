package com.stripcode.web.cs;

import com.github.pagehelper.StringUtil;
import com.stripcode.mybatis.cs.model.CSAlterDiscountRate;
import com.stripcode.mybatis.cs.model.CSCustomerErpInfo;
import com.stripcode.service.cs.CS20_009Service;
import com.stripcode.web.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Metro on 2016/8/31.
 */
@Controller
@RequestMapping("/CSAlterDiscountRate")
public class CS20_009Controller extends BaseController{
    @Autowired
    private CS20_009Service cs20009Service;
    @ResponseBody
    @RequestMapping(value = "/update",method = RequestMethod.POST)
    public Map update(CSAlterDiscountRate model, HttpServletResponse response)throws Exception{
        //登录者ID
        String userId = getCurrUser();
        model.setUpdater(userId);
        return  setSuccessModelMap(cs20009Service.update(model));
    }
    /*
    基准折率 显示
     */
    @ResponseBody
    @RequestMapping(value = "read/selectLoad",method = RequestMethod.POST)
    public Map<String,Object> selectBaseById(String customerId,HttpServletRequest request,HttpServletResponse response){
        Map<String,Object> map=new HashMap<String, Object>();
        if(!StringUtil.isEmpty(customerId)) {
            CSCustomerErpInfo csCustomerErpInfo = cs20009Service.selectBaseById(customerId);
            map.put("main",csCustomerErpInfo);
        }
        return  map;
    }
}
