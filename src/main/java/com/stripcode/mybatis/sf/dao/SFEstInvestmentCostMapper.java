package com.stripcode.mybatis.sf.dao;

import com.stripcode.mybatis.sf.model.SFBudGetEstimationCost;
import com.stripcode.mybatis.sf.model.SFEstInvestmentCost;

import java.util.List;
import java.util.Map;

/**
 * @author Metro
 */
public interface SFEstInvestmentCostMapper {

    Integer insertEstInvestmentCost(SFEstInvestmentCost model);

    List<SFBudGetEstimationCost> selectEstInvestmentCost(Map<String,String> params);

    Integer updateEstInvestmentCost(SFEstInvestmentCost model);

    int deleteByInvestmentId(String investmentId);
}
