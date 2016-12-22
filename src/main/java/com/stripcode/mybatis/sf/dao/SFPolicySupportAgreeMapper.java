package com.stripcode.mybatis.sf.dao;

import com.stripcode.mybatis.sf.model.SFPolicySupportAgree;

/**
 * Created by Metro on 2016/10/20.
 */
public interface SFPolicySupportAgreeMapper {
    /*根据custmerId查询erp市场信息*/
    SFPolicySupportAgree selectById(String customerId);
}
