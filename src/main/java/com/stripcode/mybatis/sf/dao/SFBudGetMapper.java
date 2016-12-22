package com.stripcode.mybatis.sf.dao;

import com.stripcode.mybatis.cs.model.CSSfPipeline;
import com.stripcode.mybatis.sf.model.SFBudGet;
import com.stripcode.mybatis.sf.model.SFBudGetConsUnit;
import com.stripcode.mybatis.sf.model.SFBudGetCost;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * Created by Metro on 2016/11/14.
 */
public interface SFBudGetMapper {
    //查询预算信息(标情况概述)
    SFBudGet selectBudget(String ppId);
    //修改预算信息(标情况概述)
    Integer updateBudget(SFBudGet sfBudGet);
    //添加预算信息(标情况概述)
    Integer insertBudget(SFBudGet sfBudGet);
    //查询是否存在
    Integer isExistsBudget(@Param("ppId")String ppId,@Param("rowId")String rowId);

    //查询施工单位
    List<SFBudGetConsUnit> selectBudgetConsUnit(String budgetId);
    //修改施工单位
    Integer updateBudgetConsUnit(SFBudGetConsUnit sfBudGetConsUnit);
    //添加施工单位
    Integer insertBudgetConsUnit(SFBudGetConsUnit sfBudGetConsUnit);
    //查询是否存在
    Integer isExistsBudgetConsUnit(@Param("rowId")String rowId,@Param("budgetId")String budgetId);

    //查询工程预算列表
    List<SFBudGetCost> selectBudgetCost(String ppId);
    //添加工程预算
    Integer insertBudgetCost(SFBudGetCost sfBudGetCost);
    //修改工程预算
    Integer updateBudgetCost(SFBudGetCost sfBudGetCost);
    //查询是否存在
    Integer isExistsBudgetCost(@Param("budgetId")String budgetId,@Param("itemCode") String itemCode);
    //查询店铺信息
    CSSfPipeline selectPipeline(String ppId);
    //删除施工单位
    Integer delBudgetConsUnit(Map<String,Object> map);
}
