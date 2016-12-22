package com.stripcode.mybatis.user.dao;

import com.stripcode.mybatis.user.model.TSysBranchOffice;

import java.util.List;

public interface TSysBranchOfficeMapper {
    int deleteByPrimaryKey(Integer autoNo);

    int insert(TSysBranchOffice record);

    TSysBranchOffice selectByPrimaryKey(Integer autoNo);

    List<TSysBranchOffice> selectAll();

    int updateByPrimaryKey(TSysBranchOffice record);

    List<TSysBranchOffice> selectForTree();

    List<TSysBranchOffice> selectByBrand(TSysBranchOffice record);
}