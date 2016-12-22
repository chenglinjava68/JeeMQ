package com.stripcode.mybatis.cs.dao;

import com.github.pagehelper.Page;
import com.stripcode.mybatis.cp.model.CpMarketInfo;
import com.stripcode.mybatis.cs.model.*;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * Created by Metro on 2016/8/22.
 */
public interface CSMarketAOaddMapper {
    Page<CSMarketOptimauth>  selectForPage(Map<String, Object> map);

    Page<CpMarketInfo> queryForPage(Map<String, Object> object);

    CSNewMarketAuz selectAuthorInfoById(@Param("customerId")String customerId,@Param("rowId")String rowId);

    Integer insertAuto(CSNewMarketAuz csNewMarketAuz);
    Integer AutoCount(@Param("customerId")String customerId,@Param("rowId")String rowId);
    Integer insert(CSNewMarketAuz model);

    Integer update(CSNewMarketAuz model);
    //查询下拉框客户名
    List<CSCustomerInfo> selectCustomerName();
    //添加市场
    Integer insertBatchMarket(CSErpMarketMap csErpMarketMap);
    //修改
    Integer updateBatchMarket(CSErpMarketMap csErpMarketMap);
    //查询市场
    List<CpMarketInfo> selectMarketList(CSErpMarketIds csErpMarketIds);
    //查看是否有市场
    Integer MarketCount(@Param("authorizationId")String rowId,@Param("marketId")String marketId);
    //查询marketIds 用于返回到页面
    List<CSErpMarketMap> selectMarketIds(String rowId);
    //删除市场
    Integer updateMarketDelFlag(@Param("marketId") String[] marketId,@Param("authorizationId") String authorizationId);
    List<TCsTaskCompletion> selectAll();
    Integer insertCompletion(TCsTaskCompletion tCsTaskCompletion);
    //查询客户erpCode
    List<CSCustomerErpInfo> erpCodeList(String customerId);
    CSNewMarketAuz selectErpCode(@Param("customerId") String customerId,@Param("erpCode") String erpCode);
    //添加市场列表导出
    List<CpMarketInfo> selectForExportMarketInfo();
    //查询分成比例和基准折率列表
    List<CSMarketDiscountSplit> selectDiscountSplit(String rowId);
    //添加分成比例和基准折率
    Integer insertDiscountSplit(CSMarketDiscountSplit csMarketDiscountSplit);
    //修改
    Integer updateDiscountSplit(CSMarketDiscountSplit csMarketDiscountSplit);
    //查询是否存在
    Integer isExistsDiscountSplit(@Param("authorizationId")String authorizationId,@Param("style") String style);
    //查询erpCode
    List<CSCustomerErpInfo> selectErpCodeList(String customerId);
}
