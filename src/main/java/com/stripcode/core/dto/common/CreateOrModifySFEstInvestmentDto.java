package com.stripcode.core.dto.common;

import com.stripcode.mybatis.common.BaseModel;
import com.stripcode.mybatis.cs.model.TCsTaskCompletion;
import com.stripcode.mybatis.sf.model.*;
import com.stripcode.mybatis.user.model.TCodeMacroDefine;

import java.util.List;
/**
 * Created by Metro on 2016/11/10.
 */
public class CreateOrModifySFEstInvestmentDto extends BaseModel {

    private SFEstInvestmentDetailDiretStore investmentDetailDiretStore;

    private List<TCodeMacroDefine> yesNoList;
    public List<TCodeMacroDefine> getRateList() {
        return rateList;
    }

    public void setRateList(List<TCodeMacroDefine> rateList) {
        this.rateList = rateList;
    }

    public List<TCodeMacroDefine> getYesNoList() {
        return yesNoList;
    }

    public void setYesNoList(List<TCodeMacroDefine> yesNoList) {
        this.yesNoList = yesNoList;
    }

    private List<TCodeMacroDefine> rateList;
    private List<SFEstInvestmentPayrollForecast> list;
    private List<SFBudGetEstimationCost> list0;
    private List<SFBudGetEstimationCost> list1;
    private List<SFBudGetEstimationCost> list2;
    private List<SFEstInvestmentSalesYear> salesYearsList;
    private SFEstInvestmentRoi investmentRoi;

    public List<SFEstInvestmentIncomeSharing> getInvestmentIncomeSharings() {
        return investmentIncomeSharings;
    }

    public void setInvestmentIncomeSharings(List<SFEstInvestmentIncomeSharing> investmentIncomeSharings) {
        this.investmentIncomeSharings = investmentIncomeSharings;
    }

    private List<SFEstInvestmentIncomeSharing> investmentIncomeSharings;
    private List<SFEstInvestmentCost> costList;

    public SfEstInvestmentOtherCostRateDiretStore getInvestmentOtherCostRateDiretStore() {
        return investmentOtherCostRateDiretStore;
    }

    public void setInvestmentOtherCostRateDiretStore(SfEstInvestmentOtherCostRateDiretStore investmentOtherCostRateDiretStore) {
        this.investmentOtherCostRateDiretStore = investmentOtherCostRateDiretStore;
    }

    private SfEstInvestmentOtherCostRateDiretStore investmentOtherCostRateDiretStore;
    public boolean isResult() {
        return result;
    }

    public void setResult(boolean result) {
        this.result = result;
    }

    private boolean result = true;
    private SFEstInvestment investment;
    private String filePath;
    private TCsTaskCompletion tCsTaskCompletion;
    public TCsTaskCompletion gettCsTaskCompletion() {
        return tCsTaskCompletion;
    }

    public void settCsTaskCompletion(TCsTaskCompletion tCsTaskCompletion) {
        this.tCsTaskCompletion = tCsTaskCompletion;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public SFEstInvestment getInvestment() {
        return investment;
    }

    public void setInvestment(SFEstInvestment investment) {
        this.investment = investment;
    }

    public List<SFEstInvestmentCost> getCostList() {
        return costList;
    }

    public void setCostList(List<SFEstInvestmentCost> costList) {
        this.costList = costList;
    }

    public List<SFBudGetEstimationCost> getList0() {
        return list0;
    }

    public void setList0(List<SFBudGetEstimationCost> list0) {
        this.list0 = list0;
    }

    public List<SFBudGetEstimationCost> getList1() {
        return list1;
    }

    public void setList1(List<SFBudGetEstimationCost> list1) {
        this.list1 = list1;
    }

    public List<SFBudGetEstimationCost> getList2() {
        return list2;
    }

    public void setList2(List<SFBudGetEstimationCost> list2) {
        this.list2 = list2;
    }

    public SFEstInvestmentDetailDiretStore getInvestmentDetailDiretStore() {
        return investmentDetailDiretStore;
    }

    public void setInvestmentDetailDiretStore(SFEstInvestmentDetailDiretStore investmentDetailDiretStore) {
        this.investmentDetailDiretStore = investmentDetailDiretStore;
    }

    public List<SFEstInvestmentPayrollForecast> getList() {
        return list;
    }

    public void setList(List<SFEstInvestmentPayrollForecast> list) {
        this.list = list;
    }

    public List<SFEstInvestmentSalesYear> getSalesYearsList() {
        return salesYearsList;
    }

    public void setSalesYearsList(List<SFEstInvestmentSalesYear> salesYearsList) {
        this.salesYearsList = salesYearsList;
    }

    public SFEstInvestmentRoi getInvestmentRoi() {
        return investmentRoi;
    }

    public void setInvestmentRoi(SFEstInvestmentRoi investmentRoi) {
        this.investmentRoi = investmentRoi;
    }

}
