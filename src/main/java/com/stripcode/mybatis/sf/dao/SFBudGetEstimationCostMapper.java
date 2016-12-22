package com.stripcode.mybatis.sf.dao;

import com.stripcode.mybatis.sf.model.SFBudGetEstimation;
import com.stripcode.mybatis.sf.model.SFBudGetEstimationCost;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * Created by Metro on 2016/11/9.
 */
public interface SFBudGetEstimationCostMapper {
    //查询新址概算
    List<SFBudGetEstimationCost> SelectBudGetCost(String ppId);
    //添加
    Integer insertBudGetCost(SFBudGetEstimationCost sfBudGetEstimationCost);
    //修改
    Integer updateBudGetCost(SFBudGetEstimationCost sfBudGetEstimationCost);
    //查询是否存在
    Integer isExistsBudGetCost(@Param("estId") String budgetId, @Param("itemCode") String itemCode);
    //查询启动原因
    SFBudGetEstimation SelectBudGetEstimation(String ppId);
    //添加启动原因
    Integer insertBudGetEstimation(SFBudGetEstimation sfBudGetEstimation);
    //修改启动原因
    Integer updateBudGetEstimation(SFBudGetEstimation sfBudGetEstimation);
    //查询是否存在
    Integer isExistsBudGetEstimation(String ppId);

    //从新址概算查询投资测算数据
    List<SFBudGetEstimationCost> SelectEstimationForInvest(Map<String, String> map);

}
