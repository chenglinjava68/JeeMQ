package com.stripcode.mybatis.ps.dao;

import com.github.pagehelper.Page;
import com.stripcode.mybatis.ps.model.PSPolicySupport;

import java.util.List;
import java.util.Map;

/**
 * Created by Metro on 2016/9/26.
 */
public interface PSPolicySupportMapper {
    /*
    * 带分页的查询数据
    * */
    Page<PSPolicySupport> queryForPage(Map<String,Object> object);

    Page<PSPolicySupport> psPolicyQueryForPage(Map<String,Object> object);
    /*
        * 查询rowId
        * */
    PSPolicySupport selectLoad(String rowId);

    /**
     * 新增政策支持
     * @param model
     * @return
     */
    int insert(PSPolicySupport model);

    /**
     * 编辑政策支持
     * @param model
     * @return
     */
    int update(PSPolicySupport model);

    /**
     * 删除一行数据
     * @param rowId
     * @return
     */
    int deleteByPrimaryKey(String rowId);
    /**
     *导出列表数据
     * @return
     */
    List<PSPolicySupport> selectForExport(Map<String,Object> map);

    /**
     * 禁用
     * @param psPolicySupport
     * @return
     */
    Integer updatePolicy(PSPolicySupport psPolicySupport);

    /**
     * 恢复
     * @param psPolicySupport
     * @return
     */
    Integer recoveryPolicy(PSPolicySupport psPolicySupport);
}
