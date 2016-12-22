package com.stripcode.mybatis.sf.dao;

import com.stripcode.mybatis.sf.model.TSfConsSurveyReportCover;

/**
 * @author Metro
 */
public interface SFConsSurveyReportCoverMapper {
    /**
     * 查询营建调查报告-封面信息
     * @param ppId
     * @return SFConsSurveyReportCover
     */
    TSfConsSurveyReportCover queryCover(String ppId);

    /**
     * 新增营建调查报告-封面信息
     * @param cover
     * @return Integer
     */
    Integer insertCover(TSfConsSurveyReportCover cover);

    /**
     * 修改营建调查报告-封面信息
     * @param cover
     * @return Integer
     */
    Integer updateCover(TSfConsSurveyReportCover cover);
}
