package com.stripcode.mybatis.cs.dao;

import com.stripcode.mybatis.cp.model.CpMarketInfo;
import com.stripcode.mybatis.cs.model.*;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author Metro
 */
public interface CSAuthorizationMapper {
    Integer insertCustomerErpInfo(CSCustomerErpInfo model);
    Integer insertMarketInfo(CSMarketInfo model);
    Integer insetMarketContract(CSMarketContract model);

    List<CSMarketInfo> marketInfo(String authorizationId);

    List<CpMarketInfo> selectListMarket(String rowId);
    CSNewMarketAuz authorInfoById(@Param("customerId")String customerId, @Param("rowId")String rowId);

    /*
     修改授权开始和结束时间
     */
    Integer updateCustomerErpInfo(CSCustomerErpInfo csCustomerErpInfo);

    /*
    查询customerErpInfo是否已经存在数据
     */
    Integer isExistCustomerErpInfo(String rowId);

    String queryCustomerErpInfoExist(@Param("customerId") String customerId,@Param("erpCode") String erpCode);

    Integer insertCustomerDiscountSplit(CSMarketCustomerDiscountSplit model);

    List<CSMarketDiscountSplit> selectDiscountSplit(String authorizationId);
}
