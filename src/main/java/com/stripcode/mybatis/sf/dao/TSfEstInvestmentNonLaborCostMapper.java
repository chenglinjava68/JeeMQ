package com.stripcode.mybatis.sf.dao;

import com.stripcode.mybatis.sf.model.TSfEstInvestmentNonLaborCost;

public interface TSfEstInvestmentNonLaborCostMapper {
    int deleteByPrimaryKey(String rowId);

    int insertInvestmentNonLaborCost(TSfEstInvestmentNonLaborCost record);

    TSfEstInvestmentNonLaborCost selectInvestmentNonLaborCost(String investmentId);

    int updateInvestmentNonLaborCost(TSfEstInvestmentNonLaborCost record);

    int deleteByInvestmentId(String investmentId);
}