package com.stripcode.mybatis.sf.dao;

import com.stripcode.mybatis.sf.model.SFStoreHandover;

/**
 * @author Metro
 */
public interface SFStoreHandoverMapper {
    /**
     * 店铺交接
     * @param ppId
     * @return SFStoreHandover
     */
    SFStoreHandover queryStoreHandoverInfo(String ppId);

    /**
     * 新增店铺交接信息
     * @param model
     * @return Integer
     */
    Integer insertStoreHandover(SFStoreHandover model);

    /**
     * 修改店铺交接信息
     * @param model
     * @return Integer
     */
    Integer updateStoreHandover(SFStoreHandover model);
}
