package com.stripcode.mybatis.sys.dao;

import com.stripcode.mybatis.sys.model.TSysTask;
import java.util.List;
import java.util.Map;

public interface TSysTaskMapper {
    int deleteByPrimaryKey(Integer autoNo);

    int insert(TSysTask record);

    List<TSysTask> queryForPage(Map<String,Object> object);

    int updateByPrimaryKey(TSysTask record);
}