/**
 *
 */
package com.stripcode.service.user.impl;

import com.stripcode.mybatis.user.model.TSysAction;
import com.stripcode.mybatis.user.model.TSysPermission;

import java.util.List;
import java.util.Map;

/**
 * @author Metro
 */

public interface TSysPermissionService {

    public int deleteByRoleId(String roleId);
    public void save(TSysPermission tSysPermission);
    public Map save(TSysPermission tSysPermission,String[] permissionIds);

    public void addListData(List<TSysPermission> tSysPermissions,TSysPermission tSysPermission, String[] permissionIds) ;

    public void batchSave(List<TSysPermission> tSysPermissions);
    public List<TSysPermission> selectByRoleId(String roleId);

    public List<TSysAction> queryActionPermission(Map<String, Object> params) ;
}
