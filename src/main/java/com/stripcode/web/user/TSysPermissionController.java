package com.stripcode.web.user;

import com.stripcode.core.util.RedisBUtil;
import com.stripcode.core.util.WebUtil;
import com.stripcode.mybatis.user.model.TSysAction;
import com.stripcode.mybatis.user.model.TSysPermission;
import com.stripcode.service.user.TSysPermissionService;
import com.stripcode.web.BaseController;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/permission")
public class TSysPermissionController extends BaseController {
    private final static Logger LOGGER = Logger.getLogger(TSysPermissionController.class);

    @Autowired
    private TSysPermissionService tSysPermissionService;
    @ResponseBody
    @RequestMapping("/save")
    public Map<String,Object> save(TSysPermission tSysPermission,String[] permissionIds,HttpServletResponse response){
        return setSuccessModelMap(tSysPermissionService.save(tSysPermission,permissionIds));
    }

    @ResponseBody
    @RequestMapping("/read/permissionList")
    public List<TSysPermission> permissionList(String roleId,HttpServletResponse response){
        return tSysPermissionService.selectByRoleId(roleId);
    }
    @ResponseBody
    @RequestMapping("/read/queryActionPermission")
    public List<TSysAction> queryActionPermission(String functionId, HttpServletResponse response){
        Map<String,Object> params = new HashMap<String,Object>();
        params.put("functionId",functionId);
        WebUtil webUtil = new WebUtil();
        String key = webUtil.getCacheRoleKey(WebUtil.getCurrentUser());
        params.put("roles", RedisBUtil.get(key));
        return tSysPermissionService.queryActionPermission(params);
    }
}
