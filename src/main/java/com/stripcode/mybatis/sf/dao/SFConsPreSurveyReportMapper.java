package com.stripcode.mybatis.sf.dao;

import com.stripcode.mybatis.sf.model.SFConsPreSurveyReport;

/**
 * @author Metro
 */
public interface SFConsPreSurveyReportMapper {
    /**
     * 新增营建初步调查报告
     * @param model
     * @return Integer
     */
    Integer insertReport(SFConsPreSurveyReport  model);

    /**
     * 更新营建初步调查报告
     * @param model
     * @return Integer
     */
    Integer updateReport(SFConsPreSurveyReport  model);

    SFConsPreSurveyReport queryReport(String ppId);
}
