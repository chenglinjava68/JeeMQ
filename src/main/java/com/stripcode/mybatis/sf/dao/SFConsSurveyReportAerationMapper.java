package com.stripcode.mybatis.sf.dao;

import com.stripcode.mybatis.sf.model.TSfConsSurveyReportAeration;

/**
 * @author Metro
 */
public interface SFConsSurveyReportAerationMapper {

    /**
     * 查询营建调查报告-通风、空调信息
     * @param ppId
     * @return SFConsSurveyReportAeration
     */
    TSfConsSurveyReportAeration queryAeration(String ppId);

    /**
     * 新增营建调查报告-通风、空调信息表
     * @param aeration
     * @return Integer
     */
    Integer insertAeration(TSfConsSurveyReportAeration aeration);

    /**
     * 修改营建调查报告-通风、空调信息表
     * @param aeration
     * @return Integer
     */
    Integer updateAeration(TSfConsSurveyReportAeration aeration);
}
