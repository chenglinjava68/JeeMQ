package com.stripcode.service.am;

import com.stripcode.mybatis.am.dao.AMPolicySupportMapper;
import com.stripcode.mybatis.am.model.AMPolicySupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Metro on 2016/12/19.
 */
@Service
@CacheConfig(cacheNames = "AM40_011")
public class AM40_011Service {
    @Autowired
    private AMPolicySupportMapper amPolicySupportMapper;
    /**
     * 查询店铺政策支持集合
     * @param storeId
     * @return
     */
    public List<AMPolicySupport> selectAMPolicySupport(String storeId){
        return amPolicySupportMapper.selectAMPolicySupport(storeId);
    }
}
