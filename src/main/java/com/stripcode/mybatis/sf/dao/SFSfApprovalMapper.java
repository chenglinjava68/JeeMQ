package com.stripcode.mybatis.sf.dao;

import com.stripcode.mybatis.cp.model.CpMarketInfo;
import com.stripcode.mybatis.cs.model.*;
import com.stripcode.mybatis.sf.model.SFPolicySupportDetail;
import com.stripcode.mybatis.sf.model.SFSfApproval;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by Metro on 2016/10/14.
 */
public interface SFSfApprovalMapper {
    /*
    *查询报批PPtt 信息
    * */
    CSSfPipeline selectApprovalAll(@Param("customerId")String customerId,@Param("ppId") String ppId);
    /*
    查询客户市场
     */
    List<CpMarketInfo> marketList(@Param("customerId") String customerId,@Param("erpCode") String erpCode,@Param("ppId") String ppId);
    /**
     * 查询支持项
     */
    List<SFPolicySupportDetail> selectSupportDetail(String ppId);
    /**
     * 上传附件
     */
    List<CSMarketSurvey> selectAccessoryList();
    /**
     * 查询市场店铺增长率
     */
    List<CSBusinessFlan> selectMarketById(String ppId);

    int insert(SFSfApproval approval);

    List<SFSfApproval> queryByTaskId(String taskId);

    int update(SFSfApproval sfSfApproval);
}
