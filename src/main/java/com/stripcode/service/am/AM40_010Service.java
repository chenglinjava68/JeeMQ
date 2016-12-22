package com.stripcode.service.am;

import com.stripcode.mybatis.am.dao.AMLeaseAttachMentMapper;
import com.stripcode.mybatis.am.model.AMLeaseAttachMent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Metro on 2016/12/16.
 */
@Service
@CacheConfig(cacheNames = "AM40_010")
public class AM40_010Service {
    @Autowired
    private AMLeaseAttachMentMapper amLeaseAttachMentMapper;
    /**
     * 查询店铺租约附件信息表
     * @param storeId
     * @return
     */
    public List<AMLeaseAttachMent> selectAMLeaseAttachMent(String storeId){
        return amLeaseAttachMentMapper.selectAMLeaseAttachMent(storeId);
    }
}
