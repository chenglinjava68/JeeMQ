package com.stripcode.web.ps;

import com.github.pagehelper.PageInfo;
import com.stripcode.core.util.WebUtil;
import com.stripcode.mybatis.common.JQGridObject;
import com.stripcode.mybatis.ps.model.PSPolicySupport;
import com.stripcode.service.ps.PS70_008Service;
import com.stripcode.web.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * Created by Metro on 2016/10/11.
 */
@Controller
@RequestMapping("/PS70_008")
public class PS70_008Controller extends BaseController{
    @Autowired
    private PS70_008Service ps70_008Service;
    /*
    * 查询列表
    * */
    @ResponseBody
    @RequestMapping(value="/read/list",method = RequestMethod.POST)
    public JQGridObject list(HttpServletRequest request, HttpServletResponse response){
        Map<String, Object> params = WebUtil.getParameterMap(request);
        PageInfo<PSPolicySupport> list =ps70_008Service.psPolicyQueryForPage(params);
        return  new JQGridObject(list);
    }
}
