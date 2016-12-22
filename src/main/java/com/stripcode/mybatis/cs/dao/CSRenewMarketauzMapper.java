package com.stripcode.mybatis.cs.dao;

import com.stripcode.mybatis.cs.model.CSCustomerErpInfo;
import com.stripcode.mybatis.cs.model.CSMarketCustomerDiscountSplit;
import com.stripcode.mybatis.cs.model.CSMarketOptimauth;
import com.stripcode.mybatis.cs.model.RenewMarketauz;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author Metro
 */
public interface CSRenewMarketauzMapper {
    CSCustomerErpInfo selectByReNewInfo(@Param("customerId") String customerId,@Param("erpCode")String erpCode);
    CSCustomerErpInfo selectReNewInfo(@Param("customerId") String customerId,@Param("rowId")String rowId);

    RenewMarketauz selectRenewMarketauzByCustomerId(@Param("optimauthId") String optimauthId,@Param("rowId") String rowId);
    RenewMarketauz selectRenewMarketauzById(String optimauthId);

    Integer updateByReNewInfo(RenewMarketauz renewMarketauz);

    Integer insertByReNewInfo(RenewMarketauz renewMarketauz);
    //查询是否存在
    Integer isExistsRenewMarketauz(String rowId);
    //添加优化续约信息
    Integer insertMarketOptimauth(CSMarketOptimauth csMarketOptimauthz);

    //查询分成比例
    List<CSMarketCustomerDiscountSplit> selectDiscountSplit(String rowId);
    //查询续约确认信息
    RenewMarketauz selectCommitAll(String rowId);
    //查询优化
    Integer isExistsOption(String rowId);
    //续约确认修改续约时间
    Integer updateRenewErpCustomer(CSCustomerErpInfo csCustomerErpInfo);
    /**
     * 修改优化负责人
     * @param renewMarketauz
     * @return
     */
    Integer updateMarketOptimauth(RenewMarketauz renewMarketauz);
}
