package com.stripcode.mybatis.cp.dao;
import com.github.pagehelper.Page;
import com.stripcode.mybatis.cp.model.CpMarketInfo;
import com.stripcode.mybatis.cs.model.CSCustomerInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface CpMarketInfoMapper {

    Page<CpMarketInfo> queryForPage(Map<String, Object> object);

    List<CpMarketInfo> selectCpMInfoForID(String customerId);

    List<CpMarketInfo> selectCpMarket(String marketId);

    Page<CSCustomerInfo> queryCustomerByMarketForPage(Map<String,Object> map);

    List<CpMarketInfo> selectForExport(Map<String, Object> map);

    List<CpMarketInfo> selectByParentId(@Param("parentId") String parentId,@Param("cityName") String cityName);
}