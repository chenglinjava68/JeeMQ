package com.stripcode.mybatis.user.dao;

import com.stripcode.mybatis.user.model.TSysAction;
import com.stripcode.mybatis.user.model.TSysPermission;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface TSysPermissionMapper {
    int deleteByPrimaryKey(Integer autoNo);

    int insert(TSysPermission record);

    TSysPermission selectByPrimaryKey(Integer autoNo);

    List<TSysPermission> selectAll();

    int updateByPrimaryKey(TSysPermission record);

    int deleteByRoleId(String roleId);

    List<TSysPermission> selectByRoleId(String roleId);

    int batchInsert(@Param("tSysPermissions") List<TSysPermission> tSysPermissions);

    List<TSysAction> queryActionPermission(Map<String, Object> params);
}