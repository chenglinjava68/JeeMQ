package com.stripcode.mybatis.cs.dao;

import com.stripcode.mybatis.cs.model.CSBusinessFlan;
import com.stripcode.mybatis.cs.model.CSPlanInvestment;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author Metro
 */
public interface CSNewBusinessFlanMapper {
    List<CSBusinessFlan> selectBusinessFlanByOptimauthId(String optimauthId);

    Integer isExists(String rowId);

    Integer updateBusinessFlan(CSBusinessFlan model);

    Integer insertBusinessFlan(CSBusinessFlan model);

    Integer updateBusinessDelFlag(@Param("rowId") String[] rowId,@Param("optimauthId")String optimauthId);

    CSPlanInvestment selectPlanInvestByOptimauthId(String optimauthId);

    Integer insertPlanInvestment(CSPlanInvestment model);

    Integer updatePlanInvestment(CSPlanInvestment model);

    //查询市场规划信息
    List<CSBusinessFlan> selectBusinessFlanList(String optimauthId);

}
