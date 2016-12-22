package com.stripcode.mybatis.am.dao;

import com.stripcode.mybatis.am.model.AMPolicySupport;
import com.stripcode.mybatis.sf.model.SFPolicySupportDetail;

import java.util.List;

/**店铺政策支持
 * Created by Metro on 2016/12/19.
 */
public interface AMPolicySupportMapper {
    //查询新店模块店铺政策支持集合
    List<SFPolicySupportDetail> selectSFPolicySupportDetail(String ppId);


    //查询店铺政策支持集合
    List<AMPolicySupport> selectAMPolicySupport(String storeId);
    //添加店铺政策支持集合
    Integer insertAMPolicySupport(AMPolicySupport model);
}
