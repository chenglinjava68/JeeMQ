package com.stripcode.mybatis.cs.dao;

import com.stripcode.mybatis.cs.model.CSMarketSurvey;
import com.stripcode.mybatis.cs.model.CSSysAttachedTemplate;

import java.util.List;

/**
 * Created by Metro on 2016/9/11.
 */
public interface CSMarketSurveyMapper {
    //市场考察报告列表
    List<CSSysAttachedTemplate> MarketSurveyList(String optimauthId);

    //添加报告
    Integer insertSurvey(CSMarketSurvey csMarketSurvey);
    //修改
    Integer updateSurvey(CSMarketSurvey csMarketSurvey);

    Integer SurveyCount(String optimauthId);
}
