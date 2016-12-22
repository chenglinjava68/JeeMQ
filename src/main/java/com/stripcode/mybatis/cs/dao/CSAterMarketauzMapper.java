package com.stripcode.mybatis.cs.dao;

import com.stripcode.mybatis.cs.model.CSAterMarketauz;
import com.stripcode.mybatis.cs.model.CSCustomerErpInfo;
import com.stripcode.mybatis.cs.model.CSMarketOptimauth;

import java.util.List;

/**
 * Created by Metro on 2016/12/15.
 */
public interface CSAterMarketauzMapper {

    CSAterMarketauz selectMarketauz(String rowId);
    /**
     * 添加主体变更
     * @param csAterMarketauz
     * @return
     */
    Integer insertAterMarketauz(CSAterMarketauz csAterMarketauz);

    /**
     * 修改主体
     * @param csAterMarketauz
     * @return
     */
    Integer updateAterMarketauz(CSAterMarketauz csAterMarketauz);

    /**
     * 是否存在
     * @param rowId
     * @return
     */
    Integer isExistAterMarketauz(String rowId);

    /**
     * 添加优化主体变更
     * @param csMarketOptimauth
     * @return
     */
    Integer insertAterOptimauth(CSMarketOptimauth csMarketOptimauth);

    /**
     * 优化是否存在
     * @param rowId
     * @return
     */
    Integer isExistsAterOptimauth(String rowId);

    /**
     * 查询ERPId
     * @param rowId
     * @return
     */
    List<CSCustomerErpInfo> selectErpList(String rowId);
    Integer updateAterOptimauth(CSAterMarketauz csAterMarketauz);
}
