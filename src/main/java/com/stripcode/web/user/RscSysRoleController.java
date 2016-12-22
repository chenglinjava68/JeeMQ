package com.stripcode.web.user;

import com.github.pagehelper.PageHelper;
import com.stripcode.core.dto.user.CreateOrModifyRoleDto;
import com.stripcode.core.util.PageSortUtil;
import com.stripcode.core.util.WebUtil;
import com.stripcode.mybatis.common.JQGridObject;
import com.stripcode.mybatis.user.model.RscSysRole;
import com.stripcode.service.user.RscSysRoleService;
import com.stripcode.service.user.TCodeMacroDefineService;
import com.stripcode.web.BaseController;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/role")
public class RscSysRoleController extends BaseController {
    private final static Logger LOGGER = Logger.getLogger(RscSysRoleController.class);
    @Autowired
    private RscSysRoleService rscSysRoleService;
    @Autowired
    private TCodeMacroDefineService tCodeMacroDefineService;
    //查看角色列表
    @ResponseBody
    @RequestMapping(value = "/read/list",method = RequestMethod.POST)
    public JQGridObject list(Map modelMap, HttpServletRequest request,HttpServletResponse response) {
        //定义接口可以被跨域访问
        response.setContentType("application/json;charset=UTF-8");
        response.setHeader("Access-Control-Allow-Origin","*");
        Map<String, Object> params = WebUtil.getParameterMap(request);
        PageSortUtil.unoinSortBySord(params);
        PageHelper.startPage(params);
        return new JQGridObject(rscSysRoleService.queryForPage(params));
    }
    //查看全部角色列表
    @ResponseBody
    @RequestMapping(value = "/read/getAllList",method = RequestMethod.POST)
    public List<RscSysRole> getAllList(HttpServletResponse response) {
        //定义接口可以被跨域访问
        response.setContentType("application/json;charset=UTF-8");
        response.setHeader("Access-Control-Allow-Origin","*");
        return rscSysRoleService.query();
    }
    //查看角色详情
    @ResponseBody
    @RequestMapping(value = "/read/detail",method = RequestMethod.POST)
    public Map<String,Object> detail(String id, HttpServletRequest request,HttpServletResponse response) {
        //定义接口可以被跨域访问
        response.setContentType("application/json;charset=UTF-8");
        response.setHeader("Access-Control-Allow-Origin","*");
        RscSysRole rscSysRole = rscSysRoleService.queryById(id);
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("main",rscSysRole);
        map.put("statusList", tCodeMacroDefineService.queryStatusList());
        return map;
    }

    // 删除用户信息
    @ResponseBody
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public Map update(@Valid CreateOrModifyRoleDto dto,HttpServletResponse response) throws  Exception{
            //定义接口可以被跨域访问
            response.setContentType("application/json;charset=UTF-8");
            response.setHeader("Access-Control-Allow-Origin","*");
        return setSuccessModelMap(rscSysRoleService.update(dto.toModel()));
    }

    // 删除角色信息
    @ResponseBody
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public Map delete(@RequestParam(value = "roleId",required = true ) String id, HttpServletResponse response) {
            //定义接口可以被跨域访问
            response.setContentType("application/json;charset=UTF-8");
            response.setHeader("Access-Control-Allow-Origin","*");
            return setSuccessModelMap(rscSysRoleService.delete(id));

    }

    //导出岗位列表
    @RequestMapping(value = "/exportRole")
    public String exportRole(Map<String,Object> params,HttpServletRequest request,HttpServletResponse response){
        response.setContentType("application/json;charset=UTF-8");
        response.setHeader("Access-Control-Allow-Origin","*");
        rscSysRoleService.exportRole(params,request,response);
        return null;
    }
}
