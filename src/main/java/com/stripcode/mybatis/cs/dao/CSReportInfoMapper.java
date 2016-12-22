package com.stripcode.mybatis.cs.dao;

import com.stripcode.mybatis.cs.model.CSReportInfo;

/**
 * Created by Metro on 2016/11/18.
 */
public interface CSReportInfoMapper {
    //添加报批申请
    Integer insert(CSReportInfo csReportInfo);
    //更新报批申请
    Integer update(CSReportInfo csReportInfo);
    //查询是否存在
    Integer selectIsExist(String optimauthId);
    //查询市场报告报批
    CSReportInfo selectCSReportInfo(String optimauthId);
}
