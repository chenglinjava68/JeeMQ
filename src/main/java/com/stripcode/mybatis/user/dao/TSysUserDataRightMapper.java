package com.stripcode.mybatis.user.dao;

import com.stripcode.mybatis.user.model.TSysUserDataRight;
import java.util.List;

public interface TSysUserDataRightMapper {
    int deleteByPrimaryKey(Integer autoNo);

    int insert(TSysUserDataRight record);

    TSysUserDataRight selectByPrimaryKey(Integer autoNo);

    List<TSysUserDataRight> selectAll();

    List<TSysUserDataRight> selectByPositionId(TSysUserDataRight  tSysUserDataRight);

    int updateByPrimaryKey(TSysUserDataRight record);

    int deleteByPositionId(String positionId);
}