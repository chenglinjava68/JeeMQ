package com.stripcode.mybatis.cs.dao;
import com.stripcode.mybatis.cs.model.CSAlterDiscountRate;
import com.stripcode.mybatis.cs.model.CSCustomerErpInfo;
import org.apache.ibatis.annotations.Param;

/**
 * Created by Metro on 2016/8/31.
 */
public interface CSAlterDiscountRateMapper {
   /*
    基准折率变更基本信息
    @Param(value="optimizedType"
     */
    CSCustomerErpInfo selectBaseById(@Param(value = "customerId") String customerId);
   /*
    添加基本折率
     */
    int insert(CSAlterDiscountRate model);
    /*
    修改
     */
    int update(CSAlterDiscountRate model);

}
