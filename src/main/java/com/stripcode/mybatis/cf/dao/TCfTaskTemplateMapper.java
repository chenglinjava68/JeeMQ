package com.stripcode.mybatis.cf.dao;

import com.stripcode.mybatis.cf.model.TCfTaskTemplate;

import java.util.List;
import java.util.Map;

public interface TCfTaskTemplateMapper {
    int deleteByPrimaryKey(Integer autoNo);

    int insert(TCfTaskTemplate record);

    TCfTaskTemplate selectByPrimaryKey(Integer autoNo);

    List<TCfTaskTemplate> selectAll();

    int updateByPrimaryKey(TCfTaskTemplate record);

    List<TCfTaskTemplate> selectByTaskType(Map<String,Object> params);
}