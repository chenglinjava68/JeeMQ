package com.stripcode.mybatis.am.dao;

import com.stripcode.mybatis.am.model.AMLeaseAttachMent;

import java.util.List;

/**
 * Created by Metro on 2016/12/16.
 */
public interface AMLeaseAttachMentMapper {
    //查询店铺租约附件信息表
    List<AMLeaseAttachMent> selectAMLeaseAttachMent(String storeId);

    //添加店铺租约附件信息集合
    Integer insertAMLeaseAttachMent(AMLeaseAttachMent model);
}
