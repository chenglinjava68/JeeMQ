package com.stripcode.service.cs;

import com.stripcode.mybatis.cs.dao.CSRenewMarketauzMapper;
import com.stripcode.mybatis.cs.model.CSCustomerErpInfo;
import com.stripcode.mybatis.cs.model.CSMarketCustomerDiscountSplit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Metro on 2016/12/8.
 */
@Service
@CacheConfig(cacheNames="CS20_029")
public class CS20_029Service {
    @Autowired
    private CSRenewMarketauzMapper csRenewMarketauzMapper;
    //查询收入分成比例
    public List<CSMarketCustomerDiscountSplit> selectDiscountSplit(String rowId){
        return  csRenewMarketauzMapper.selectDiscountSplit(rowId);
    }
    //查询客户信息和市场信息
    public CSCustomerErpInfo queryByReNewInfo(String customerId,String rowId){
        CSCustomerErpInfo csCustomerErpInfo = csRenewMarketauzMapper.selectReNewInfo(customerId,rowId);
        csCustomerErpInfo.setCustomerDiscountSplitList(this.selectDiscountSplit(rowId));
        return csCustomerErpInfo;
    }

}
