package com.stripcode.mybatis.cs.dao;

import com.stripcode.mybatis.cs.model.CSCustomerErpInfo;
import com.stripcode.mybatis.cs.model.RenewalBusinessPlan;
import com.stripcode.mybatis.cs.model.RenewalCustomerStore;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author Metro
 */
public interface CSRenewalStoreMapper {
    List<RenewalCustomerStore> selectRenewStoreByCustomerId(@Param("customerId") String customerId,@Param("rowId")String rowId);

    Integer updateRenewalStore(RenewalCustomerStore model);

    Integer insertRenewalStore(RenewalCustomerStore model);

    Integer renewalStoreByStoreCode(@Param("storeCode") String storeCode, @Param("customerId") String customerId,@Param("rowId")String rowId);

    Integer renewalBusinePlan(@Param("customerId") String customerId,@Param("rowId")String rowId);

    CSCustomerErpInfo selectErpInfoAll(@Param("customerId")String customerId,@Param("rowId")String rowId);

    Integer updateRenewalBusinessPlan(RenewalBusinessPlan model);

    Integer insertRenewalBusinessPlan(RenewalBusinessPlan model);

}
