package com.stripcode.mybatis.user.dao;

import com.stripcode.core.util.tree.TreeModel;
import com.stripcode.mybatis.user.model.TCodeMacroDefine;

import java.util.List;

public interface TCodeMacroDefineMapper {

    List<TCodeMacroDefine> selectAll();

    List<TCodeMacroDefine>selectForMarket();
   //新店开发
    List<TCodeMacroDefine>  selectSFPipeline();
    //政策支持执行
    List<TCodeMacroDefine> selectPSPolicySupportImplementation();
    //测算模板管理
    List<TCodeMacroDefine> selectSYSEstInvestmentModel();
    //意向书
    List<TCodeMacroDefine> selectSFLandlordInterest();
     //政策支持详细
     List<TCodeMacroDefine> selectPolicySupportDetail();

    List<TCodeMacroDefine> selectForMarketAOadd();
    List<TCodeMacroDefine> selectForRenStore();
    List<TCodeMacroDefine> selectForDesign();
    List<TCodeMacroDefine> selectForHousePaper();
    List<TCodeMacroDefine> selectForProgress();

    List<TCodeMacroDefine> querySexList();

    List<TCodeMacroDefine> selectForOptimauth();

    List<TCodeMacroDefine> selectForStore();

    List<TCodeMacroDefine> selectForCustomerErp();

    List<TreeModel> selectForRangeTree();

    List<TCodeMacroDefine> queryForSiteArea();

    List<TCodeMacroDefine> queryYesNoList();

    int insert(TCodeMacroDefine record);

    int updateByConditions(TCodeMacroDefine record);

    List<TCodeMacroDefine> selectForUser();

    List<TCodeMacroDefine> selectForCustomer();

 List<TCodeMacroDefine> queryStatusList();

 List<TCodeMacroDefine> queryForLocation();

 List<TCodeMacroDefine> queryStoreTaxRateList();

 List<TCodeMacroDefine> selectForEstInvestment();
 List<TCodeMacroDefine> selectForEstInvestmentDetails(String parentCode);

 List<TCodeMacroDefine> selectByMacroType(String macroType);

 List<TCodeMacroDefine> selectForUserRight();
    List<TCodeMacroDefine> selectForFlan();

    List<TCodeMacroDefine> selectForRentalProposal();
    List<TCodeMacroDefine> selectForLandlord();

    List<TCodeMacroDefine> selectForTradezone();

    List<TCodeMacroDefine> selectForConsSurvey();

    List<TCodeMacroDefine> queryForContractApply();

    List<TCodeMacroDefine> selectAgreeRefuleList();
}