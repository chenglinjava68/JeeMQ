package com.stripcode.mybatis.sf.dao;

import com.stripcode.mybatis.sf.model.TSfEstInvestmentResultDateCopartner;

public interface TSfEstInvestmentResultDateCopartnerMapper {
    int deleteByPrimaryKey(Integer autoNo);

    int insertInvestmentResultDateCopartner(TSfEstInvestmentResultDateCopartner record);

    TSfEstInvestmentResultDateCopartner selectInvestmentResultDateCopartner(String investmentId);

    int updateInvestmentResultDateCopartner(TSfEstInvestmentResultDateCopartner record);

    int deleteByInvestmentId(String investmentId);
}