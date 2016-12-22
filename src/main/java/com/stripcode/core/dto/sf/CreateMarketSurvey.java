package com.stripcode.core.dto.sf;

import com.stripcode.mybatis.cs.model.CSMarketSurvey;

import java.util.List;

/**
 * Created by Metro on 2016/10/25.
 */
public class CreateMarketSurvey {
    private List<CSMarketSurvey> surveyList;

    public List<CSMarketSurvey> getSurveyList() {
        return surveyList;
    }

    public void setSurveyList(List<CSMarketSurvey> surveyList) {
        this.surveyList = surveyList;
    }
}
