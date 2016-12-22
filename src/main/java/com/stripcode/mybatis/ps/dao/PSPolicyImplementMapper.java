package com.stripcode.mybatis.ps.dao;

import com.github.pagehelper.Page;
import com.stripcode.mybatis.sf.model.SFPolicySupportAssessment;

import java.util.Map;

/**
 * Created by Metro on 2016/12/6.
 */
public interface PSPolicyImplementMapper {
    //带分页的查询数据
    Page<SFPolicySupportAssessment> queryForPage(Map<String,Object> object);

}
