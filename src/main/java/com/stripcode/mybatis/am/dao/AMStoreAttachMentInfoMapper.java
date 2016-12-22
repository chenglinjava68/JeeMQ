package com.stripcode.mybatis.am.dao;

import com.stripcode.mybatis.am.model.AMStoreAttachMentInfo;

import java.util.List;

/**店铺合同附件数据访问层接口
 * Created by Metro on 2016/10/20.
 */
public interface AMStoreAttachMentInfoMapper {
    List<AMStoreAttachMentInfo> selectForAttachInfo(String storeId);
}
