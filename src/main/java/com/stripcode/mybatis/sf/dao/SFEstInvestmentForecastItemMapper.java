package com.stripcode.mybatis.sf.dao;

import com.stripcode.mybatis.sf.model.SFEstInvestmentForecastItem;

import java.util.List;

/**
 * @author Metro
 */
public interface SFEstInvestmentForecastItemMapper {

    Integer insertEstInvestmentForecastItem(SFEstInvestmentForecastItem model);

    List<SFEstInvestmentForecastItem> selectEstInvestmentForecastItem(String investmentId);

    Integer updateEstInvestmentForecastItem(SFEstInvestmentForecastItem model);

}
