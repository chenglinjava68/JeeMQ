package com.stripcode.mybatis.sf.dao;

import com.stripcode.mybatis.sf.model.TSfEstInvestmentDetailCopartnerStore;

public interface TSfEstInvestmentDetailCopartnerStoreMapper {
    int deleteByPrimaryKey(Integer autoNo);

    int insertInvestmentDetailCopartnerStore(TSfEstInvestmentDetailCopartnerStore record);

    TSfEstInvestmentDetailCopartnerStore selectInvestmentDetailCopartnerStore(String investmentId);

    TSfEstInvestmentDetailCopartnerStore selectByPPId(String ppId);

    int updateInvestmentDetailCopartnerStore(TSfEstInvestmentDetailCopartnerStore record);

    int deleteByInvestmentId(String investmentId);
}