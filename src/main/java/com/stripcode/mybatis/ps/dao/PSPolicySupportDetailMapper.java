package com.stripcode.mybatis.ps.dao;

import com.stripcode.mybatis.ps.model.PSPolicySupportDetail;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by Metro on 2016/9/27.
 */
public interface PSPolicySupportDetailMapper {
    /*
    * 查询支持项
    * */
    List<PSPolicySupportDetail> selectSupportDetailList(@Param("policyId") String [] policyId);

    /*
        * 查询表格的policyId
        * */
    List<PSPolicySupportDetail> selectLoadTable(String policyId);

    /*
    查询表格的rowId
     */
    List<PSPolicySupportDetail> selectload(String rowId);
    /**
     * 新增政策支持详细信息
     * @param model
     * @return
     */
    int insertPolicySupportDetail(PSPolicySupportDetail model);

    /**
     * 编辑政策支持详细信息
     * @param model
     * @return
     */
    int updatepolicySupportDetail(PSPolicySupportDetail model);
    /**
     *
     * 删除数据
     */
    int deletByPolicyDetail(@Param("rowId") String[] rowId,@Param("policyId") String policyId,@Param("isRowNull") Integer isRowNull);

    /**
     * 查询政策支持详细表的rowId,policyId是否存在
     * @param rowId
     * @param policyId
     * @return
     */
    Integer IsExistPolicyDetail(@Param("rowId") String rowId ,@Param("policyId") String policyId);
}
