package com.stripcode.mybatis.sf.dao;


import com.stripcode.mybatis.sf.model.SFEstInvestmentDetailDiretStore;

/**
 * Created by Metro on 2016/11/08.
 */
public interface SFEstInvestmentDetailDiretStoreMapper {
    /**
     * 添加直营店信息
     */
    Integer insertEstInvestmentDetailDiretStore(SFEstInvestmentDetailDiretStore model);


    /**
     * 修改直营店信息
     */
    Integer updateEstInvestmentDetailDiretStore(SFEstInvestmentDetailDiretStore model);


    /**
     * 查询直营店信息
     */
    SFEstInvestmentDetailDiretStore selectEstInvestmentDetailDiretStore(String investmentId);

    int deleteByInvestmentId(String investmentId);
}
