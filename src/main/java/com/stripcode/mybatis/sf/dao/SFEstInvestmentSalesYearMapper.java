package com.stripcode.mybatis.sf.dao;


import com.stripcode.mybatis.sf.model.SFEstInvestmentSalesYear;

import java.util.List;

/**
 * Created by Metro on 2016/11/08.
 */
public interface SFEstInvestmentSalesYearMapper {
    /**
     * 添加投资回报测算信息
     */
    Integer insertEstInvestmentSalesYearMapper(SFEstInvestmentSalesYear model);


    /**
     * 修改投资回报测算信息
     */
    Integer updateEstInvestmentSalesYearMapper(SFEstInvestmentSalesYear model);


    /**
     * 查询投资回报测算信息
     */
    List<SFEstInvestmentSalesYear> selectEstInvestmentSalesYearMapper(String investmentId);

    /**
     * 查询租期详细信息
     */
    List<SFEstInvestmentSalesYear> selectRentalDetailMapper(String ppId);
    int deleteByInvestmentId(String investmentId);
}
