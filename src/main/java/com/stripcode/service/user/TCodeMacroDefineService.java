/**
 *
 */
package com.stripcode.service.user;

import com.stripcode.core.util.tree.TreeModel;
import com.stripcode.mybatis.user.dao.TCodeMacroDefineMapper;
import com.stripcode.mybatis.user.model.TCodeMacroDefine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author Metro
 */
@Service
@CacheConfig(cacheNames = "tSysDatatype")
public class TCodeMacroDefineService {
    @Autowired
    private TCodeMacroDefineMapper tCodeMacroDefineMapper;

    private static final String STATUS_YES = "M0043";

    @Transactional
    public int update(TCodeMacroDefine record) {
        if (record.getMacroNo() == null) {
            record.setStatus(STATUS_YES);
            return tCodeMacroDefineMapper.insert(record);
        } else {
            return tCodeMacroDefineMapper.updateByConditions(record);
        }
    }

    public List<TCodeMacroDefine> selectForUser() {
        return tCodeMacroDefineMapper.selectForUser();
    }

    //客户下拉框
    public List<TCodeMacroDefine> selectForCustomer() {
        return tCodeMacroDefineMapper.selectForCustomer();
    }

    //市场下拉框
    public List<TCodeMacroDefine> selectForMarket() {
        return tCodeMacroDefineMapper.selectForMarket();
    }

    //市场授权新增信息下拉框
    public List<TCodeMacroDefine> selectForMarketAOadd() {
        return tCodeMacroDefineMapper.selectForMarketAOadd();
    }
    //设计申请按钮
    public List<TCodeMacroDefine> selectForDesign() {
        return tCodeMacroDefineMapper.selectForDesign();
    }
    //市场授权优化下拉框
    public List<TCodeMacroDefine> selectForOptimauth() {
        return tCodeMacroDefineMapper.selectForOptimauth();
    }

    //意向店选择下拉框值
    public List<TCodeMacroDefine> selectForStore() {
        return tCodeMacroDefineMapper.selectForStore();
    }

    public List<TCodeMacroDefine> selectForHousePaper() {
        return tCodeMacroDefineMapper.selectForHousePaper();
    }

    public List<TCodeMacroDefine> selectForProgress() {
        return tCodeMacroDefineMapper.selectForProgress();
    }
    //租金提案下拉框
    public List<TCodeMacroDefine> selectForRenStore() {
        return tCodeMacroDefineMapper.selectForRenStore();
    }
    //意向书下拉框
    public List<TCodeMacroDefine> selectSFLandlordInterest(){
        return tCodeMacroDefineMapper.selectSFLandlordInterest();
    }
    //新店开发

    public List<TCodeMacroDefine> selectSFPipelineStore() {
        return tCodeMacroDefineMapper.selectSFPipeline();
    }
    //政策支持执行
    public List<TCodeMacroDefine> selectPSPolicySupportImplementation() {
        return tCodeMacroDefineMapper.selectPSPolicySupportImplementation();
    }
    //测算模板管理
    public List<TCodeMacroDefine> selectSYSEstInvestmentModelStore() {
        return tCodeMacroDefineMapper.selectSYSEstInvestmentModel();
    }
    //政策支持基本信息  查询考核项
    public List<TCodeMacroDefine> selectPolicySupportDetail(){
        return tCodeMacroDefineMapper.selectPolicySupportDetail();
    }

    public List<TCodeMacroDefine> selectFroCustomerErp() {
        return tCodeMacroDefineMapper.selectForCustomerErp();
    }

    public List<TreeModel> selectForRangeTree() {
        return tCodeMacroDefineMapper.selectForRangeTree();
    }

    public List<TCodeMacroDefine> queryForSiteArea() {
        return tCodeMacroDefineMapper.queryForSiteArea();
    }

    public List<TCodeMacroDefine> queryStatusList() {
        return tCodeMacroDefineMapper.queryStatusList();
    }

    public List<TCodeMacroDefine> queryForLocation() {
        return tCodeMacroDefineMapper.queryForLocation();
    }

    public List<TCodeMacroDefine> selectForEstInvestment(){
        return tCodeMacroDefineMapper.selectForEstInvestment();
    }
    public List<TCodeMacroDefine> selectForEstInvestmentDetails(String parentCode){
        return tCodeMacroDefineMapper.selectForEstInvestmentDetails(parentCode);
    }

    public List<TCodeMacroDefine> selectForUserRight() {
        return tCodeMacroDefineMapper.selectForUserRight();
    }

    public List<TCodeMacroDefine> selectForFlan(){
        return tCodeMacroDefineMapper.selectForFlan();
    }

    public List<TCodeMacroDefine> selectForRentalProposal(){
        return tCodeMacroDefineMapper.selectForRentalProposal();
    };
    public List<TCodeMacroDefine> selectForLandlord(){
        return tCodeMacroDefineMapper.selectForLandlord();
    };

    public List<TCodeMacroDefine> selectForTradezone(){
        return tCodeMacroDefineMapper.selectForTradezone();
    }

    public List<TCodeMacroDefine> selectForConsSurvey(){
        return tCodeMacroDefineMapper.selectForConsSurvey();
    }

    public List<TCodeMacroDefine> queryForContractApply(){
        return tCodeMacroDefineMapper.queryForContractApply();
    }
}
