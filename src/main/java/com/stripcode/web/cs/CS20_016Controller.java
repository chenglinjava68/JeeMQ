package com.stripcode.web.cs;

import com.github.pagehelper.PageInfo;
import com.stripcode.core.util.WebUtil;
import com.stripcode.mybatis.common.JQGridObject;
import com.stripcode.mybatis.cs.model.CSSfPipeline;
import com.stripcode.service.cp.CP10_001Service;
import com.stripcode.service.cs.CS20_016Service;
import com.stripcode.service.sf.SF30_002Service;
import com.stripcode.web.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.stripcode.service.user.TCodeMacroDefineService;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Metro on 2016/8/31.
 */
@Controller
@RequestMapping("/csCustomerPP")
public class CS20_016Controller extends BaseController{
    @Autowired
    private CS20_016Service cs20_016Service;
    @Autowired
    private CP10_001Service cp10_001Service;
    @Autowired
    private TCodeMacroDefineService tCodeMacroDefineService;
    @Autowired
    private SF30_002Service sf30002Service;
    /*
 店铺查询列表 带分页
 */
    @ResponseBody
    @RequestMapping(value = "/read/list",method = RequestMethod.POST)
    public JQGridObject List(HttpServletRequest request,HttpServletResponse response){
        //定义接口可以被跨域访问
        Map<String, Object> params = WebUtil.getParameterMap(request);
        PageInfo<CSSfPipeline> list = cs20_016Service.queryForPage(params);
        return  new JQGridObject(list);
    }
    //获取店铺选择页面 简单搜索下拉框的值
    @ResponseBody
    @RequestMapping(value = "read/details",method = RequestMethod.POST)
    public Map<String,Object> details(String parentId,HttpServletRequest request,HttpServletResponse response){
        Map<String,Object> map=new HashMap<String, Object>();
        map.put("selectList", tCodeMacroDefineService.selectForStore());
        map.put("codeList",sf30002Service.selectCpMarket(parentId));//查询省份
        //map.put("codeList",cp10_001Service.selectCpMarket(marketId));
        return  map;
    }
}
