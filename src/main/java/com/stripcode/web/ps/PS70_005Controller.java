package com.stripcode.web.ps;

import com.github.pagehelper.PageInfo;
import com.stripcode.core.util.WebUtil;
import com.stripcode.mybatis.common.JQGridObject;
import com.stripcode.mybatis.sf.model.SFPolicySupportAssessment;
import com.stripcode.service.ps.PS70_004Service;
import com.stripcode.service.ps.PS70_005Service;
import com.stripcode.service.user.TCodeMacroDefineService;
import com.stripcode.web.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Metro on 2016/12/6.
 */
@Controller
@RequestMapping("/PS70_005")
public class PS70_005Controller extends BaseController {
    @Autowired
    private PS70_005Service ps70_005Service;
    @Autowired
    private PS70_004Service ps70_004Service;
    @Autowired
    private TCodeMacroDefineService tCodeMacroDefineService;
    //列表带分页的查询数据
    @ResponseBody
    @RequestMapping(value="/read/list",method = RequestMethod.POST)
    public JQGridObject list(HttpServletRequest request, HttpServletResponse response){
        Map<String, Object> params = WebUtil.getParameterMap(request);
        PageInfo<SFPolicySupportAssessment> list =ps70_005Service.queryForPage(params);
        return  new JQGridObject(list);
    }

    /*
    * 加载搜索下拉框
    * */
    @ResponseBody
    @RequestMapping(value="/read/selectLoad",method = RequestMethod.POST)
    public Map<String,Object> selectLoad (HttpServletRequest request, HttpServletResponse response){
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("codeList", tCodeMacroDefineService.selectPSPolicySupportImplementation());//查询列表
        map.put("itemList",ps70_004Service.selectSupportDetailList("M0101"));
        map.put("itemList1",ps70_004Service.selectSupportDetailList("M0102"));
        return map;
    }
    /**
     * 导出列表数据
     * @param params
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value = "/exportUser")
    public String exportUser( @RequestParam Map<String,Object> params,HttpServletRequest request,HttpServletResponse response){
        ps70_005Service.exportUser(params,request,response);
        return null;
    }
}
