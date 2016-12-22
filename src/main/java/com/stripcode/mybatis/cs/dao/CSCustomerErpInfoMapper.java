package com.stripcode.mybatis.cs.dao;
import com.github.pagehelper.Page;
import com.stripcode.mybatis.cs.model.CSCustomerErpInfo;
import java.util.List;
import java.util.Map;

/**
 * Created by Metro on 2016/8/19.
 */
public interface CSCustomerErpInfoMapper {
    /*
    带分页的查询数据
     */
    Page<CSCustomerErpInfo> queryForPage(Map<String,Object> object);
    /*
    客户授权信息列表
     */
    Page<CSCustomerErpInfo> queryForMarket(Map<String,Object> object);
    Page<CSCustomerErpInfo> queryForMarketend(Map<String,Object> object);
    Page<CSCustomerErpInfo> queryForMarketCustomer(Map<String,Object> object);
    /**
     * 授权导出
     */
     List<CSCustomerErpInfo> selectForExportErpInfo(Map<String, Object> object);

}
