package com.stripcode.mybatis.sf.dao;

import com.stripcode.mybatis.sf.model.TSfEstInvestmentOtherCostRate;

public interface TSfEstInvestmentOtherCostRateMapper {
    int deleteByPrimaryKey(Integer autoNo);

    int insertInvestmentOtherCostRate(TSfEstInvestmentOtherCostRate record);

    TSfEstInvestmentOtherCostRate selectInvestmentOtherCostRate(String investmentId);

    int updateInvestmentOtherCostRate(TSfEstInvestmentOtherCostRate record);

    int deleteByInvestmentId(String investmentId);
}