package com.stripcode.service.am;

import com.stripcode.mybatis.am.dao.AMContractAttachMentMapper;
import com.stripcode.mybatis.am.model.AMContractAttachMent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Metro on 2016/12/19.
 */
@Service
@CacheConfig(cacheNames = "AM40_009")
public class AM40_009Service {
    @Autowired
    private AMContractAttachMentMapper amContractAttachMentMapper;

    /**
     * 查询店铺合同附件
     * @param storeId
     * @return
     */
     public List<AMContractAttachMent> selectAMContractAttachMent(String storeId){
        return amContractAttachMentMapper.selectAMContractAttachMent(storeId);
    }
}
