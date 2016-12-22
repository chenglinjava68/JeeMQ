package com.stripcode.mybatis.cs.dao;

import com.stripcode.mybatis.cp.model.CpMarketInfo;
import com.stripcode.mybatis.cs.model.CSCustomerErpInfo;
import com.stripcode.mybatis.cs.model.CSMarketContract;
import com.stripcode.mybatis.cs.model.CSMarketCustomerDiscountSplit;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by Metro on 2016/9/1.
 */
public interface CSErpIDMapper {

    /*
   查询客户ERP 显示在页面
    */
    CSCustomerErpInfo selectByPrimaryKey(@Param("erpCode")String erpId,@Param("rowId")String rowId);
    //查询分成比例
    List<CSMarketCustomerDiscountSplit> selectCustomerSplit(@Param("erpCode")String erpId,@Param("rowId")String rowId);
    /*
    添加 Erp
     */
    List<CpMarketInfo> selectCpMInfoForID(String customerId);

    //附件列表
    List<CSMarketContract> selectList(@Param("customerId")String customerId,@Param("erpCode")String erpCode);
}
