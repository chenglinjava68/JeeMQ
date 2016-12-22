package com.stripcode.core.dto.common;

import com.stripcode.mybatis.common.BaseModel;
import com.stripcode.mybatis.cs.model.TCsTaskCompletion;
import com.stripcode.mybatis.sf.model.*;

import java.util.List;

/**
 * Created by Metro on 2016/11/17.
 */
public class CreateOrModifyInvestmentCopartnerDto extends BaseModel {

    private String filePath;

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    private TSfEstInvestmentDetailCopartnerStore investmentDetailCopartnerStore;
    private List<TSfEstInvestmentPayrollForecastCopartner> investmentPayrollForecastCopartnerList;
    private TSfEstInvestmentNonLaborCost investmentNonLaborCost;

    public List<SFEstInvestmentIncomeSharing> getInvestmentIncomeSharings() {
        return investmentIncomeSharings;
    }

    public void setInvestmentIncomeSharings(List<SFEstInvestmentIncomeSharing> investmentIncomeSharings) {
        this.investmentIncomeSharings = investmentIncomeSharings;
    }

    private List<SFEstInvestmentIncomeSharing> investmentIncomeSharings;
    private TSfEstInvestmentOtherCostRate investmentOtherCostRate;
    private TSfEstInvestmentResultDateCopartner investmentResultDateCopartner;
    private SFEstInvestment investment;
    private TCsTaskCompletion tCsTaskCompletion;

    public TCsTaskCompletion gettCsTaskCompletion() {
        return tCsTaskCompletion;
    }

    public void settCsTaskCompletion(TCsTaskCompletion tCsTaskCompletion) {
        this.tCsTaskCompletion = tCsTaskCompletion;
    }

    public SFEstInvestment getInvestment() {
        return investment;
    }

    public void setInvestment(SFEstInvestment investment) {
        this.investment = investment;
    }

    public TSfEstInvestmentDetailCopartnerStore getInvestmentDetailCopartnerStore() {
        return investmentDetailCopartnerStore;
    }

    public void setInvestmentDetailCopartnerStore(TSfEstInvestmentDetailCopartnerStore investmentDetailCopartnerStore) {
        this.investmentDetailCopartnerStore = investmentDetailCopartnerStore;
    }

    public List<TSfEstInvestmentPayrollForecastCopartner> getInvestmentPayrollForecastCopartnerList() {
        return investmentPayrollForecastCopartnerList;
    }

    public void setInvestmentPayrollForecastCopartnerList(List<TSfEstInvestmentPayrollForecastCopartner> investmentPayrollForecastCopartnerList) {
        this.investmentPayrollForecastCopartnerList = investmentPayrollForecastCopartnerList;
    }

    public TSfEstInvestmentNonLaborCost getInvestmentNonLaborCost() {
        return investmentNonLaborCost;
    }

    public void setInvestmentNonLaborCost(TSfEstInvestmentNonLaborCost investmentNonLaborCost) {
        this.investmentNonLaborCost = investmentNonLaborCost;
    }

    public TSfEstInvestmentOtherCostRate getInvestmentOtherCostRate() {
        return investmentOtherCostRate;
    }

    public void setInvestmentOtherCostRate(TSfEstInvestmentOtherCostRate investmentOtherCostRate) {
        this.investmentOtherCostRate = investmentOtherCostRate;
    }

    public TSfEstInvestmentResultDateCopartner getInvestmentResultDateCopartner() {
        return investmentResultDateCopartner;
    }

    public void setInvestmentResultDateCopartner(TSfEstInvestmentResultDateCopartner investmentResultDateCopartner) {
        this.investmentResultDateCopartner = investmentResultDateCopartner;
    }
}
