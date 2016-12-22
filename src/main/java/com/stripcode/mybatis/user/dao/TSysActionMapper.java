package com.stripcode.mybatis.user.dao;

import com.stripcode.mybatis.user.model.TSysAction;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TSysActionMapper {
    int deleteByPrimaryKey(Integer autoNo);

    int insert(TSysAction record);

    TSysAction selectByPrimaryKey(Integer autoNo);

    List<TSysAction> selectAll();

    List<TSysAction> selectByFunctionId(@Param("functionId") String functionId);

    int updateByPrimaryKey(TSysAction record);
}