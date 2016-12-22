package com.stripcode.mybatis.sf.dao;


import com.stripcode.mybatis.sf.model.SFEstInvestmentPayrollForecast;

import java.util.List;

/**
 * Created by Metro on 2016/11/08.
 */
public interface SFEstInvestmentPayrollForecastMapper {
    /**
     * 添加薪资预测信息
     */
    Integer insertEstInvestmentPayrollForecast(SFEstInvestmentPayrollForecast model);


    /**
     * 修改薪资预测信息
     */
    Integer updateEstInvestmentPayrollForecast(SFEstInvestmentPayrollForecast model);


    /**
     * 查询薪资预测信息
     */
    List<SFEstInvestmentPayrollForecast> selectEstInvestmentPayrollForecast(String investmentId);

    int deleteByInvestmentId(String investmentId);
}
