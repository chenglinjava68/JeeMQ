package com.stripcode.web.user;

import com.github.pagehelper.PageHelper;
import com.stripcode.core.dto.user.CreateOrModifyPositionDto;
import com.stripcode.core.util.PageSortUtil;
import com.stripcode.core.util.WebUtil;
import com.stripcode.core.util.tree.GenerateTreeDataUtil;
import com.stripcode.core.util.tree.TreeNode;
import com.stripcode.mybatis.common.JQGridObject;
import com.stripcode.mybatis.user.model.RscSysPosition;
import com.stripcode.service.user.*;
import com.stripcode.web.BaseController;
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
@RequestMapping("/position")
public class RscSysPositionController extends BaseController {
    @Autowired
    private RscSysPositionService rscSysPositionService;
    @Autowired
    private RscSysUserService rscSysUserService;
    @Autowired
    private RscSysRoleService rscSysRoleService;
    @Autowired
    private RscSysRoleusermapService rscSysRoleusermapService;
    @Autowired
    private TCodeMacroDefineService tCodeMacroDefineService;
    @ResponseBody
    @RequestMapping(value = "/read/list",method = RequestMethod.POST)
    public JQGridObject list(Map modelMap, HttpServletRequest request,HttpServletResponse response) {
        //定义接口可以被跨域访问
        response.setContentType("application/json;charset=UTF-8");
        response.setHeader("Access-Control-Allow-Origin","*");
        Map<String, Object> params = WebUtil.getParameterMap(request);
        PageSortUtil.unoinSortBySord(params);
        PageHelper.startPage(params);
        return new JQGridObject(rscSysPositionService.query(params));
    }

    //修改岗位信息
    @ResponseBody
    @RequestMapping(value = "/update",method = RequestMethod.POST)
    public Map update(@Valid CreateOrModifyPositionDto dto,String[] roleArray,HttpServletResponse response){
        response.setContentType("application/json;charset=UTF-8");
        response.setHeader("Access-Control-Allow-Origin","*");
        return rscSysPositionService.update(dto.toModel(),roleArray);
    }

    @ResponseBody
    @RequestMapping(value = "/delete",method = RequestMethod.POST)
    public Map delete(@RequestParam(value="positionid",required = true)String positionid,HttpServletResponse response){
        response.setContentType("application/json;charset=UTF-8");
        response.setHeader("Access-Control-Allow-Origin","*");
        return setSuccessModelMap(rscSysPositionService.delete(positionid));
    }

    @ResponseBody
    @RequestMapping(value = "/read/detail",method = RequestMethod.POST)
    public Map<String,Object> detail(String id,HttpServletResponse response) {
        Map<String,Object> map = new HashMap<String,Object>();
        //定义接口可以被跨域访问
        response.setContentType("application/json;charset=UTF-8");
        response.setHeader("Access-Control-Allow-Origin","*");
        if(id!=null&&!"".equals(id)){
            RscSysPosition rscSysPosition = rscSysPositionService.queryById(id);
            map.put("main",rscSysPosition);
            Map<String,Object> params = new HashMap<String,Object>();
            params.put("positionId",rscSysPosition.getPositionid());
            map.put("myRoleList",rscSysRoleusermapService.query(params));
        }
        map.put("userList",rscSysUserService.query());
        map.put("positionList",rscSysPositionService.selectForTree(id));
        map.put("roleList",rscSysRoleService.query());
        map.put("statusList", tCodeMacroDefineService.queryStatusList());
        return map;
    }

    @ResponseBody
    @RequestMapping(value = "/read/selectPosition",method = RequestMethod.POST)
    public List<RscSysPosition> selectPosition(HttpServletResponse response) {
        //定义接口可以被跨域访问
        response.setContentType("application/json;charset=UTF-8");
        response.setHeader("Access-Control-Allow-Origin","*");
        return rscSysPositionService.select();
    }
    @ResponseBody
    @RequestMapping(value = "/read/queryTree",method = RequestMethod.POST)
    public List<TreeNode> queryTree(String positionId, HttpServletResponse response) {
       //定义接口可以被跨域访问
        response.setContentType("application/json;charset=UTF-8");
        response.setHeader("Access-Control-Allow-Origin","*");
        return GenerateTreeDataUtil.recursionChildren("ROOT",rscSysPositionService.selectForTree(positionId));
    }
    //导出岗位列表
    @RequestMapping(value = "/exportPosition")
    public String exportPosition(Map<String,Object> params,HttpServletRequest request,HttpServletResponse response){
        response.setContentType("application/json;charset=UTF-8");
        response.setHeader("Access-Control-Allow-Origin","*");
        rscSysPositionService.exportPosition(params,request,response);
        return null;
    }


}
