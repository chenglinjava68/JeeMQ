package com.stripcode.mybatis.am.dao;

import com.github.pagehelper.Page;
import com.stripcode.mybatis.am.model.AMPolicySupport;
import com.stripcode.mybatis.am.model.AMStoreInfo;

import java.util.List;
import java.util.Map;

/**
 * Created by Metro on 2016/10/17.
 */
public interface AMStoreInfoMapper {
    /**
     * 分页查询
     * @param param
     * @return
     */
    Page<AMStoreInfo> selectForPage(Map<String,Object> param);

    //店铺基本信息
    AMStoreInfo selectByStoreId(String storeId);

    //导出
    List<AMStoreInfo> selectForExport(Map<String,Object> param);

    List<AMStoreInfo> selectForTitle();

    //查询店铺政策支持集合
    List<AMPolicySupport> selectAMPolicySupportList(String storeId);
}
