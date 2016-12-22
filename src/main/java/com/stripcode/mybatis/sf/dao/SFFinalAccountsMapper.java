package com.stripcode.mybatis.sf.dao;

import com.stripcode.mybatis.sf.model.SFBudGetConsUnit;
import com.stripcode.mybatis.sf.model.SFFinalAccounts;
import com.stripcode.mybatis.sf.model.SFFinalAccountsCost;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by Metro on 2016/12/6.
 */
public interface SFFinalAccountsMapper {
    //查询决算信息
    SFFinalAccounts  selectFinalAccounts(String ppId);
    //添加决算信息
    Integer insertFinalAccounts(SFFinalAccounts sfFinalAccounts);
    //修改决算信息
    Integer updateFinalAccounts(SFFinalAccounts sfFinalAccounts);
    //查询是否存在
    Integer isExistsFinalAccounts(@Param("rowId") String rowId,@Param("ppId") String ppId);

    //查询决算列表
    List<SFFinalAccountsCost> selectAccountsCostList(String ppId);
    //添加
    Integer insertAccountsCost(SFFinalAccountsCost sfFinalAccountsCost);
    //修改
    Integer updateAccountsCost(SFFinalAccountsCost sfFinalAccountsCost);
    //查看是否存在
    Integer isExistsAccountsCost(@Param("budgetId")String budgetId,@Param("itemCode") String itemCode);
    //查询施工单位列表
    List<SFBudGetConsUnit> selectBudgetConsUnit(String ppId);
}
