/**
 *
 */
package com.stripcode.service.user.impl;

import com.github.pagehelper.PageInfo;
import com.stripcode.mybatis.user.model.RscSysUser;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

/**
 * @author Metro
 */

public interface RscSysUserService {


    public Map update(RscSysUser record);

    public boolean isExists(RscSysUser record);

    public boolean isExistsByLoginName(RscSysUser record);
    public RscSysUser getUserByid(String id);


    public Map delete(String id);

    public RscSysUser queryById(String id);

    public List<RscSysUser> query(Map<String, Object> params);
    public PageInfo<RscSysUser> queryForPage(Map<String, Object> params);

    public List<RscSysUser> queryByConditions(Map<String, Object> params);
    public List<RscSysUser> query();

    /**
     * 用户登录
     */
    public Boolean login(String account, String password);
    public void exportUser(Map<String,Object> params,HttpServletRequest request, HttpServletResponse response);
    public RscSysUser loadUser(String userId);
}
