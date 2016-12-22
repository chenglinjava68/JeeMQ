package com.stripcode.mybatis.sf.dao;

import com.stripcode.mybatis.sf.model.SfEstInvestmentOtherCostRateDiretStore;
import java.util.List;

public interface SfEstInvestmentOtherCostRateDiretStoreMapper {
    int deleteByPrimaryKey(Integer autoNo);

    int insert(SfEstInvestmentOtherCostRateDiretStore record);

    SfEstInvestmentOtherCostRateDiretStore selectByPrimaryKey(Integer autoNo);

    List<SfEstInvestmentOtherCostRateDiretStore> selectAll();

    int updateByPrimaryKey(SfEstInvestmentOtherCostRateDiretStore record);


    SfEstInvestmentOtherCostRateDiretStore selectByInvestmentId(String investmentId);

    int deleteByInvestmentId(String investmentId);
}