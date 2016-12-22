package com.stripcode.service.cs;

import com.stripcode.mybatis.cp.model.CpMarketInfo;
import com.stripcode.mybatis.cs.dao.CSErpIDMapper;
import com.stripcode.mybatis.cs.model.CSMarketContract;
import com.stripcode.mybatis.cs.model.CSCustomerErpInfo;
import com.stripcode.mybatis.cs.model.CSMarketCustomerDiscountSplit;
import com.stripcode.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Metro on 2016/9/1.
 */
@Service
@CacheConfig(cacheNames = "csErpID")
public class CS20_004Service extends BaseService{
    @Autowired
    private CSErpIDMapper csErpIDMapper;
    //查询分成比例
    public List<CSMarketCustomerDiscountSplit> selectCustomerSplit(String erpId,String rowId){
        return  csErpIDMapper.selectCustomerSplit(erpId,rowId);
    }
    /*
     通过ErpId查询
     */
    public CSCustomerErpInfo selectByPrimaryKey(String erpId,String rowId){
        CSCustomerErpInfo csCustomerErpInfo =  csErpIDMapper.selectByPrimaryKey(erpId, rowId);
        csCustomerErpInfo.setCustomerDiscountSplitList(this.selectCustomerSplit(erpId,rowId));
        return csCustomerErpInfo;
    };
    /*
    授权列表
     */
    public List<CpMarketInfo> selectCpMInfoForID(String customerId) {
        return csErpIDMapper.selectCpMInfoForID(customerId);
    }
    /*
     客户附件查询
      */
    public List<CSMarketContract> selectList(String customerId,String erpCode){
        return csErpIDMapper.selectList(customerId,erpCode);
    }

}
