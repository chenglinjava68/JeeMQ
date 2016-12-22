package com.stripcode.service.am;

import com.stripcode.mybatis.am.dao.AMRentalDetailMapper;
import com.stripcode.mybatis.am.model.AMRentalDetail;
import com.stripcode.mybatis.am.model.AMRentalProposalDirectStore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Metro on 2016/12/16.
 */
@Service
@CacheConfig(cacheNames = "AM40_008")
public class AM40_008Service {
    @Autowired
    private AMRentalDetailMapper amRentalDetailMapper;

    /**
     * 查询店铺租金提案信息表
     * @param storeId
     * @return
     */
    public AMRentalProposalDirectStore selectAMRentalProposalDirectStore(String storeId){
        return amRentalDetailMapper.selectAMRentalProposalDirectStore(storeId);
    }

    /**
     * 查询店铺租期详细信息集合
     * @param storeId
     * @return
     */
    public List<AMRentalDetail> selectAMRentalDetail(String storeId){
        return amRentalDetailMapper.selectAMRentalDetail(storeId);
    }

 }
