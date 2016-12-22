package com.stripcode.mybatis.cs.dao;


import com.stripcode.mybatis.cs.model.CSCustomerPP;
import com.stripcode.mybatis.cs.model.CSErpInfo;
import com.stripcode.mybatis.cs.model.CSMarketOptimauth;
import com.stripcode.mybatis.cs.model.CSNewMarketAuz;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by Metro on 2016/8/24.
 */
public interface CSErpInfoMapper {
    //添加ErpId
    Integer insert(CSNewMarketAuz model);
    //修改ErpId
    Integer update(CSNewMarketAuz model);
    //添加店铺ID
    Integer insertStore(CSCustomerPP csCustomerPP);
    //修改店铺ID
    Integer updateStore(CSCustomerPP csCustomerPP);
    //查询ERPID是否存在
    Integer IsExistErpCode(@Param("erpCode")String erpCode,@Param("rowId")String rowId);

    //查询T_Am_Store 表中是否有记录
    Integer StoreCount(@Param("customerId")String customerId,@Param("optimauthId")String rowId);
    //查询ErpInfo是否有记录
    Integer ErpCount(@Param("customerId")String customerId,@Param("optimauthId")String rowId);
    //查询erpId
   CSMarketOptimauth  selectErp(@Param("optimauthId")String rowId);
    // 查询店铺名称
    List<CSErpInfo> selectStore(@Param("customerId")String customerId,@Param("rowId")String rowId);

}
