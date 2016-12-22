package com.stripcode.mybatis.am.dao;

import com.stripcode.mybatis.am.model.AMRentalDetail;
import com.stripcode.mybatis.am.model.AMRentalProposalDirectStore;

import java.util.List;

/**
 * Created by Metro on 2016/12/15.
 */
public interface AMRentalDetailMapper {
    //查询店铺租金提案信息表
    AMRentalProposalDirectStore selectAMRentalProposalDirectStore(String storeId);
    //添加店铺租金提案信息
    Integer insertAMRentalProposalDirectStore(AMRentalProposalDirectStore model);

    //查询店铺租期详细信息集合
    List<AMRentalDetail> selectAMRentalDetail(String storeId);
    //添加店铺租期详细信息
    Integer insertAMRentalDetail(AMRentalDetail model);
}
