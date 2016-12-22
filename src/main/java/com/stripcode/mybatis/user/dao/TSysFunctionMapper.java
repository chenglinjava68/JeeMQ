package com.stripcode.mybatis.user.dao;

import com.stripcode.core.util.tree.TreeModel;
import com.stripcode.mybatis.user.model.TSysFunction;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TSysFunctionMapper {
    int deleteByPrimaryKey(@Param("autoNo") Integer autoNo, @Param("functionId") String functionId);

    int insert(TSysFunction record);

    TSysFunction selectByPrimaryKey(@Param("autoNo") Integer autoNo, @Param("functionId") String functionId);

    List<TSysFunction> selectAll();

    int updateByPrimaryKey(TSysFunction record);

    List<TreeModel> selectForTree();

    List<TreeModel> selectForMenu(@Param("userId") String userId);
}