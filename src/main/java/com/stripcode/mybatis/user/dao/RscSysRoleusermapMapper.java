package com.stripcode.mybatis.user.dao;

import com.stripcode.mybatis.user.model.RscSysRoleusermap;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public interface RscSysRoleusermapMapper {
    int insert(RscSysRoleusermap record);

    int deleteByPositionId(String positionid);

    List<RscSysRoleusermap> selectAll();

    List<RscSysRoleusermap> query(Map<String,Object> object);
    ArrayList<RscSysRoleusermap> queryRole(Map<String,Object> object);
}