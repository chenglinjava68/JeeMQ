package com.stripcode.mybatis.sf.dao;

import com.stripcode.mybatis.sf.model.SFPolicySupportDetail;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * Created by Metro on 2016/10/17.
 */
public interface SFPolicySupportDetailMapper {
    /**
     * 新增政策支持详细信息
     * @param model
     * @return
     */
    int insertPolicySupportDetail(SFPolicySupportDetail model);

List<SFPolicySupportDetail> selectAll(String ppId);

    /**
     * 编辑政策支持详细信息
     * @param model
     * @return
     */
    int updatePolicySupportDetail(SFPolicySupportDetail model);
    Integer deleteByPolicy(Map<String,Object> map);

    /**
     *
     * 删除数据
     */
    int deletByPolicyDetail(@Param("rowId") String[] rowId, @Param("psId") String policyId, @Param("isRowNull") Integer isRowNull);

    /**
     * 查询政策考核里面的政策支持
     * @return
     */
    List<SFPolicySupportDetail> queryInfo(String ppId);
}
