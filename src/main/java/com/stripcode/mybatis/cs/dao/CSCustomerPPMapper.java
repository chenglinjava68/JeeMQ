package com.stripcode.mybatis.cs.dao;
import com.github.pagehelper.Page;
import com.stripcode.mybatis.cs.model.CSCustomerInfo;
import com.stripcode.mybatis.cs.model.CSSfPipeline;

import java.util.Map;

/**
 * Created by Metro on 2016/8/26.
 */
public interface CSCustomerPPMapper {
    /*
    查询意向店
     */
    CSCustomerInfo selectCPById (String customerId);
    /*
   查询店铺信息
   带分页
    */
    Page<CSSfPipeline> queryForPage(Map<String,Object> object);
}
