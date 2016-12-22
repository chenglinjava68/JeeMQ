/**
 *
 */
package com.stripcode.service.user;

import com.stripcode.mybatis.user.dao.TSysPermissionMapper;
import com.stripcode.mybatis.user.model.TSysAction;
import com.stripcode.mybatis.user.model.TSysPermission;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Metro
 */
@Service
@CacheConfig(cacheNames = "tSysPermission")
public class TSysPermissionService {
    @Autowired
    private TSysPermissionMapper tSysPermissionMapper;
    @Transactional
    public int deleteByRoleId(String roleId) {
        return tSysPermissionMapper.deleteByRoleId(roleId);
    }
    public void save(TSysPermission tSysPermission){
        tSysPermissionMapper.insert(tSysPermission);

    }
    @Transactional
    public Map save(TSysPermission tSysPermission,String[] permissionIds){
        Map modelMap = new HashMap();
        List<TSysPermission> tSysPermissions = new ArrayList<TSysPermission>();
        deleteByRoleId(tSysPermission.getRoleId());
        if(permissionIds == null){
            modelMap.put("result",true);
            modelMap.put("message","保存成功！");
            return  modelMap;
        }
        addListData(tSysPermissions,tSysPermission,permissionIds);
        batchSave(tSysPermissions);
        modelMap.put("result",true);
        modelMap.put("message","保存成功！");
        return modelMap;
    }

    private void addListData(List<TSysPermission> tSysPermissions,TSysPermission tSysPermission, String[] permissionIds) {
        for(String permissionId : permissionIds){
            TSysPermission tempTSysPermission = new TSysPermission();
            tempTSysPermission.setRoleId(tSysPermission.getRoleId());
            tempTSysPermission.setCreateTime(null);
            tempTSysPermission.setMapId(permissionId);
            tempTSysPermission.setRowId(null);
            tSysPermissions.add(tempTSysPermission);

        }
    }

    public void batchSave(List<TSysPermission> tSysPermissions){
            tSysPermissionMapper.batchInsert(tSysPermissions);

    }
    public List<TSysPermission> selectByRoleId(String roleId){
        return tSysPermissionMapper.selectByRoleId(roleId);
    }

    public List<TSysAction> queryActionPermission(Map<String, Object> params) {
        if(params.get("roles") == null){
            return new ArrayList<TSysAction>();
        }
        return tSysPermissionMapper.queryActionPermission(params);
    }
}
