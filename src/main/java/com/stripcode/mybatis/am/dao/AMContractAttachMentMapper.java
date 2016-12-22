package com.stripcode.mybatis.am.dao;

import com.stripcode.mybatis.am.model.AMContractAttachMent;

import java.util.List;

/**店铺合同附件数据访问层接口
 * Created by Metro on 2016/10/20.
 */
public interface AMContractAttachMentMapper {
    //添加店铺合同附件
    Integer insertAMContractAttachMent(AMContractAttachMent model);
    //查询店铺合同附件
    List<AMContractAttachMent> selectAMContractAttachMent(String storeId);
}
