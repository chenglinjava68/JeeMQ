/**
 *
 */
package com.stripcode.service.user.impl;

import com.github.pagehelper.PageInfo;
import com.stripcode.mybatis.user.model.RscSysRole;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

/**
 * @author Metro
 */

public interface RscSysRoleService {

    public Map update(RscSysRole record);
    public boolean isExists(RscSysRole record);

    public void exportRole(Map<String,Object> params, HttpServletRequest request, HttpServletResponse response);

    public RscSysRole getRolebyid(String roleid);
    public Map delete(String id);
    public RscSysRole queryById(String id);
    List<RscSysRole> queryByPostionId(String postionid);
    public PageInfo<RscSysRole> queryForPage(Map<String, Object> params);
    public List<RscSysRole> query(Map<String, Object> params);
    public List<RscSysRole> query();
}
