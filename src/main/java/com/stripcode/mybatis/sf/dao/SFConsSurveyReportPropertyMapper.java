package com.stripcode.mybatis.sf.dao;

import com.stripcode.mybatis.sf.model.TSfConsSurveyReportProperty;

/**
 * @author Metro
 */
public interface SFConsSurveyReportPropertyMapper {

    /**
     * 查询营建调查报告-新址物业简述信息
     * @param ppId
     * @return SFConsSurveyReportProperty
     */
    TSfConsSurveyReportProperty queryProperty(String ppId);

    /**
     * 新增营建调查报告-新址物业简述信息
     * @param property
     * @return Integer
     */
    Integer insertProperty(TSfConsSurveyReportProperty property);

    /**
     * 修改营建调查报告-新址物业简述信息
     * @param property
     * @return Integer
     */
    Integer updateProperty(TSfConsSurveyReportProperty property);


}
