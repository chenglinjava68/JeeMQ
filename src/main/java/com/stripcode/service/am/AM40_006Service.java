package com.stripcode.service.am;

import com.stripcode.mybatis.am.dao.*;
import com.stripcode.mybatis.am.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by wusicong on 2016/12/09.
 */
@Service
@CacheConfig(cacheNames = "AM40_006")
public class AM40_006Service {
    @Autowired
    private AMLandLordInfoMapper amLandLordInfoMapper;

    /**
     * 查询店铺业主信息房产来源
     * @param storeId
     * @return
     */
    public AMLandLordInfo selectAMLandLordInfo(String storeId){
        return amLandLordInfoMapper.selectAMLandLordInfo(storeId);
    }

    /**
     * 查询店铺业主信息集合
     * @param storeId
     * @return
     */
    public List<AMLandLordInfoDetail> selectAMLandLordInfoDetail(String storeId){
        return amLandLordInfoMapper.selectAMLandLordInfoDetail(storeId);
    }
}
