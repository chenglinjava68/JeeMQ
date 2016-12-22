package com.stripcode.mybatis.email.dao;

import com.stripcode.mybatis.email.model.TSysMailAttachMapping;
import java.util.List;

public interface TSysMailAttachMappingMapper {
    int deleteByPrimaryKey(Integer attoNo);

    int insert(TSysMailAttachMapping record);

    TSysMailAttachMapping selectByPrimaryKey(Integer attoNo);

    List<TSysMailAttachMapping> selectAll();

    int updateByPrimaryKey(TSysMailAttachMapping record);
}