package com.stripcode.mybatis.sf.dao;


import com.stripcode.mybatis.sf.model.SFEstInvestmentRoi;

/**
 * Created by Metro on 2016/11/08.
 */
public interface SFEstInvestmentRoiMapper {
    /**
     * 添加投资回报测算信息
     */
    Integer insertEstInvestmentRoiMapper(SFEstInvestmentRoi model);


    /**
     * 修改投资回报测算信息
     */
    Integer updateEstInvestmentRoiMapper(SFEstInvestmentRoi model);


    /**
     * 查询投资回报测算信息
     */
    SFEstInvestmentRoi selectEstInvestmentRoiMapper(String investmentId);

    int deleteByInvestmentId(String investmentId);
}
