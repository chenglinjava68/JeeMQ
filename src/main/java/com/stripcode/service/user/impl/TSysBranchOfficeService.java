package com.stripcode.service.user.impl;

import com.stripcode.mybatis.user.model.TSysBranchOffice;

import java.util.List;

/**
 * Created by Metro
 */

public interface TSysBranchOfficeService {

    public List<TSysBranchOffice> selectAll();

    public List<TSysBranchOffice> selectForTree();

    public List<TSysBranchOffice> selectByBrand(TSysBranchOffice record);
}
