package com.stripcode.mybatis.sf.dao;

import com.stripcode.mybatis.sf.model.TSfConsSurveyReportOthers;

/**
 * @author Metro
 */
public interface SFConsSurveyReportOthersMapper {

    /**
     * 查询营建调查报告-其他信息
     * @param ppId
     * @return SFConsSurveyReportOthers
     */
    TSfConsSurveyReportOthers queryOthers(String ppId);

    /**
     * 新增营建调查报告-其他信息
     * @param others
     * @return Integer
     */
    Integer insertOthers(TSfConsSurveyReportOthers others);

    /**
     * 修改营建调查报告-其他信息
     * @param others
     * @return
     */
    Integer updateOthers(TSfConsSurveyReportOthers others);
}
