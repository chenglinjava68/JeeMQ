package com.stripcode.mybatis.sf.dao;

import com.stripcode.mybatis.sf.model.SFReport;

import java.util.List;

/**
 * Created by Metro on 2016/11/21.
 */
public interface SFReportMapper {
    //添加报批申请
    Integer insert(SFReport sfReport);
    //更新报批申请
    Integer update(SFReport sfReport);
    //查询是否存在
    Integer selectIsExist(String ppId);
    //查询市场报告报批
    List<SFReport> selectSFReport(String ppId);
    //查询同一个意向店报批报告的rowId
    List<SFReport> selectSFReportRowId(String ppId);
}
