package com.stripcode.mybatis.am.dao;

import com.stripcode.mybatis.am.model.AMLandLordInfo;
import com.stripcode.mybatis.am.model.AMLandLordInfoDetail;

import java.util.List;

/**
 * Created by Metro on 2016/12/14.
 */
public interface AMLandLordInfoMapper {
    //查询店铺业主信息房产来源
    AMLandLordInfo selectAMLandLordInfo(String storeId);
    //添加店铺业主信息房产来源
    Integer insertAMLandLordInfo(AMLandLordInfo model);



    //查询店铺业主信息集合
    List<AMLandLordInfoDetail> selectAMLandLordInfoDetail(String storeId);
    //添加店铺业主信息集合
    Integer insertAMLandLordInfoDetail(AMLandLordInfoDetail model);
}
