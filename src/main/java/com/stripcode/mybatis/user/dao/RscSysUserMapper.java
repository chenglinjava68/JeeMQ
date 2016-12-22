package com.stripcode.mybatis.user.dao;

import com.github.pagehelper.Page;
import com.stripcode.mybatis.user.model.RscSysUser;

import java.util.List;
import java.util.Map;

public interface RscSysUserMapper {
    int deleteByPrimaryKey(String userId);

    int insert(RscSysUser record);

    RscSysUser selectByPrimaryKey(String userId);

    List<RscSysUser> selectAll();
    List<RscSysUser> selectForExport();
    int updateByPrimaryKey(RscSysUser record);

    int updateByConditions(RscSysUser record);

    int selectForExists(RscSysUser record);

    RscSysUser getUserByid(String id);

    List<RscSysUser> query(Map<String,Object> object);

    Page<RscSysUser> queryForPage(Map<String,Object> object);

    List<RscSysUser> queryByConditions(Map<String,Object> object);

    int selectForExistsByLoginName(String loginName);

    RscSysUser loadUser(String userId);

    List<RscSysUser> queryForPosition(Map<String,Object> params);
}