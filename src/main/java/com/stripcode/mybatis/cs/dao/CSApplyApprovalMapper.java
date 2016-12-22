package com.stripcode.mybatis.cs.dao;

import com.stripcode.mybatis.cs.model.CSPlanInvestment;
import com.stripcode.mybatis.cs.model.CSNewMarketAuz;
import org.apache.ibatis.annotations.Param;

/**
 * Created by Metro on 2016/9/14.
 */
public interface CSApplyApprovalMapper {
    //添加报批申请
    Integer insert(CSPlanInvestment csPlanInvestment);
    //查询是否存在
    Integer approvalCount(String optimauthId);
    //修改
    Integer update(CSPlanInvestment csPlanInvestment);
    CSNewMarketAuz selectApplyInfoById(@Param("customerId")String customerId,@Param("rowId")String rowId);
}
