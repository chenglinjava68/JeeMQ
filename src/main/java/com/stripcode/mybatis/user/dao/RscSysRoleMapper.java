package com.stripcode.mybatis.user.dao;

import com.github.pagehelper.Page;
import com.stripcode.mybatis.user.model.RscSysRole;

import java.util.List;
import java.util.Map;

public interface RscSysRoleMapper {

    int deleteByPrimaryKey(String roleId);

    int insert(RscSysRole record);

    RscSysRole selectByPrimaryKey(String roleId);

    List<RscSysRole> selectAll();

    List<RscSysRole> selectForExport();
    List<RscSysRole> queryByPostionId(String postionid);

    int updateByPrimaryKey(RscSysRole record);

    int selectForExists(RscSysRole record);

    Page<RscSysRole> queryForPage(Map<String, Object> object);

    List<RscSysRole> query(Map<String, Object> object);

    RscSysRole getRolebyid(String roleid);
}