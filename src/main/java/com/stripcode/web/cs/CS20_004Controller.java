package com.stripcode.web.cs;

import com.github.pagehelper.StringUtil;
import com.stripcode.mybatis.cp.model.CpMarketInfo;
import com.stripcode.mybatis.cs.model.CSMarketContract;
import com.stripcode.mybatis.cs.model.CSCustomerErpInfo;
import com.stripcode.service.cs.CS20_004Service;
import com.stripcode.web.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Metro on 2016/8/19.
 */
@Controller
@RequestMapping("/csErpID")
public class CS20_004Controller extends BaseController{
    @Autowired
    private CS20_004Service cs20004Service;
    //获取客户市场授权页面 简单搜索下拉框的值
    @ResponseBody
    @RequestMapping(value = "read/details",method = RequestMethod.POST)
    public Map<String,Object> details(String erpCode,String rowId,HttpServletRequest request,HttpServletResponse response){
        Map<String,Object> map=new HashMap<String, Object>();
        if(!StringUtil.isEmpty(erpCode)){
            CSCustomerErpInfo CSCustomerErpInfo = cs20004Service.selectByPrimaryKey(erpCode,rowId);
            map.put("main", CSCustomerErpInfo);
        }
        return  map;
    }

    //查询新增基本信息 市场列表
    @ResponseBody
    @RequestMapping(value = "/read/listMInfoById",method = RequestMethod.POST)
    public List<CpMarketInfo> listMInfoById(String customerId,HttpServletRequest request,HttpServletResponse response){
        return cs20004Service.selectCpMInfoForID(customerId);
    }
    //客户附件列表
    @ResponseBody
    @RequestMapping(value = "read/selectAll",method = RequestMethod.POST)
    public List<CSMarketContract> selectAll(String customerId,String erpCode,HttpServletResponse response){
        return cs20004Service.selectList(customerId,erpCode);
    }
}
