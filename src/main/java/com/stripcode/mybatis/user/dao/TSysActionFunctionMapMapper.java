package com.stripcode.mybatis.user.dao;

import com.stripcode.mybatis.user.model.TSysActionFunctionMap;

import java.util.List;

public interface TSysActionFunctionMapMapper {
    int deleteByPrimaryKey(Integer mapId);

    int insert(TSysActionFunctionMap record);

    TSysActionFunctionMap selectByPrimaryKey(Integer mapId);

    List<TSysActionFunctionMap> selectAll();

    int updateByPrimaryKey(TSysActionFunctionMap record);
}