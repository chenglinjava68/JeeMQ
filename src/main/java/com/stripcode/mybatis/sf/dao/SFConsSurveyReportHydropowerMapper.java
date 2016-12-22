package com.stripcode.mybatis.sf.dao;

import com.stripcode.mybatis.sf.model.TSfConsSurveyReportHydropower;

/**
 * @author Metro
 */
public interface SFConsSurveyReportHydropowerMapper {

    /**
     * 查询营建调查报告-供电、供水、排水信息
     * @param ppId
     * @return
     */
    TSfConsSurveyReportHydropower queryHydropower(String ppId);

    /**
     * 新增营建调查报告-供电、供水、排水信息
     * @param hydropower
     * @return Integer
     */
    Integer insertHydropower(TSfConsSurveyReportHydropower hydropower);

    /**
     * 修改营建调查报告-供电、供水、排水信息
     * @param hydropower
     * @return
     */
    Integer updateHydropower(TSfConsSurveyReportHydropower hydropower);
}
