package com.stripcode.service.user;

import com.stripcode.mybatis.user.dao.TSysBranchOfficeMapper;
import com.stripcode.mybatis.user.model.TSysBranchOffice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Metro on 2016/9/27.
 */
@Service
public class TSysBranchOfficeService {
    @Autowired
    private TSysBranchOfficeMapper tSysBranchOfficeMapper;
    public List<TSysBranchOffice> selectAll() {
        return tSysBranchOfficeMapper.selectAll();
    }

    public List<TSysBranchOffice> selectForTree() {
        return tSysBranchOfficeMapper.selectForTree();
    }

    public List<TSysBranchOffice> selectByBrand(TSysBranchOffice record){
        return  tSysBranchOfficeMapper.selectByBrand(record);
    }
}
