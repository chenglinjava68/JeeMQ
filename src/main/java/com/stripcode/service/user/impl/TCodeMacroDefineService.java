/**
 *
 */
package com.stripcode.service.user.impl;

import com.stripcode.core.util.tree.TreeModel;
import com.stripcode.mybatis.user.model.TCodeMacroDefine;

import java.util.List;

/**
 * @author Metro
 */

public interface TCodeMacroDefineService {
    public int update(TCodeMacroDefine record);

    public List<TCodeMacroDefine> selectForUser();

    //客户下拉框
    public List<TCodeMacroDefine> selectForCustomer();

    //市场下拉框
    public List<TCodeMacroDefine> selectForMarket();

    //市场授权新增信息下拉框
    public List<TCodeMacroDefine> selectForMarketAOadd();
    //设计申请按钮
    public List<TCodeMacroDefine> selectForDesign();
    //市场授权优化下拉框
    public List<TCodeMacroDefine> selectForOptimauth();

    //意向店选择下拉框值
    public List<TCodeMacroDefine> selectForStore();

    public List<TCodeMacroDefine> selectForHousePaper();

    public List<TCodeMacroDefine> selectForProgress();
    //租金提案下拉框
    public List<TCodeMacroDefine> selectForRenStore();
    //意向书下拉框
    public List<TCodeMacroDefine> selectSFLandlordInterest();
    //新店开发

    public List<TCodeMacroDefine> selectSFPipelineStore();
    //政策支持执行
    public List<TCodeMacroDefine> selectPSPolicySupportImplementation();
    //测算模板管理
    public List<TCodeMacroDefine> selectSYSEstInvestmentModelStore();
    //政策支持基本信息  查询考核项
    public List<TCodeMacroDefine> selectPolicySupportDetail();

    public List<TCodeMacroDefine> selectFroCustomerErp();

    public List<TreeModel> selectForRangeTree();

    public List<TCodeMacroDefine> queryForSiteArea();

    public List<TCodeMacroDefine> queryStatusList();

    public List<TCodeMacroDefine> queryForLocation();

    public List<TCodeMacroDefine> selectForEstInvestment();

    public List<TCodeMacroDefine> selectForEstInvestmentDetails(String parentCode);

    public List<TCodeMacroDefine> selectForUserRight();
    public List<TCodeMacroDefine> selectForFlan();

    public List<TCodeMacroDefine> selectForRentalProposal();
    public List<TCodeMacroDefine> selectForLandlord();

    public List<TCodeMacroDefine> selectForTradezone();

    public List<TCodeMacroDefine> selectForConsSurvey();

    public List<TCodeMacroDefine> queryForContractApply();
}
