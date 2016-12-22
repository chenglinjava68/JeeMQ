package com.stripcode.mybatis.am.dao;

import com.stripcode.mybatis.am.model.AMAttachMentInfo;

import java.util.List;

/**店铺附件数据访问层接口
 * Created by Metro on 2016/10/20.
 */
public interface AMAttachMentInfoMapper {
    //查询店铺附件集合
    List<AMAttachMentInfo> selectForAttachMentInfo(String storeId);
    //添加店铺附件集合
    Integer insertAMAttachMentInfo(AMAttachMentInfo model);
}
