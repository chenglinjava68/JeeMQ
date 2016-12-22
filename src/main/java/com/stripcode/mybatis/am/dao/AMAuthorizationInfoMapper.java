package com.stripcode.mybatis.am.dao;

import com.stripcode.mybatis.am.model.AMAuthorizationInfo;

import java.util.List;
import java.util.Map;

/**店铺授权书附件数据访问层接口
 * Created by Metro on 2016/10/20.
 */
public interface AMAuthorizationInfoMapper {
    List<AMAuthorizationInfo> selectForAuthorizationInfo(String storeId);

    /**
     * 增加店铺授权书附件
     * @param model
     * @return
     */
    int insertAuthorizationInfo(AMAuthorizationInfo model);
    int updateAuthorizationInfo(AMAuthorizationInfo model);
    int deleteAuthorizationInfo(Map<String,Object> map);
}
