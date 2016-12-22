package com.stripcode.mybatis.sf.model;

import com.stripcode.mybatis.common.BaseModel;

public class TSfEstInvestmentDetailCopartnerStore extends BaseModel {
    private String rowId;

    private String investmentId;

    private Double minStd;

    private Double socSecPct;

    private Double contractArea;
    private String contractStartDate;
    private String contractEndDate;
    private String storeCode;
    private String cnSitename;

    public Double getContractArea() {
        return contractArea;
    }

    public void setContractArea(Double contractArea) {
        this.contractArea = contractArea;
    }

    public String getContractStartDate() {
        return contractStartDate;
    }

    public void setContractStartDate(String contractStartDate) {
        this.contractStartDate = contractStartDate;
    }

    public String getContractEndDate() {
        return contractEndDate;
    }

    public void setContractEndDate(String contractEndDate) {
        this.contractEndDate = contractEndDate;
    }

    public String getStoreCode() {
        return storeCode;
    }

    public void setStoreCode(String storeCode) {
        this.storeCode = storeCode;
    }

    public String getCnSitename() {
        return cnSitename;
    }

    public void setCnSitename(String cnSitename) {
        this.cnSitename = cnSitename;
    }

    private Double salesAvgMonth;

//    public TSfEstInvestmentDetailCopartnerStore(String investmentId, Double minStd, Double socSecPct, Double salesAvgMonth) {
//        this.investmentId = investmentId;
//        this.minStd = minStd;
//        this.socSecPct = socSecPct;
//        this.salesAvgMonth = salesAvgMonth;
//    }

    @Override
    public String getRowId() {
        return rowId;
    }

    @Override
    public void setRowId(String rowId) {
        this.rowId = rowId;
    }

    public String getInvestmentId() {
        return investmentId;
    }

    public void setInvestmentId(String investmentId) {
        this.investmentId = investmentId;
    }

    public Double getMinStd() {
        return minStd;
    }

    public void setMinStd(Double minStd) {
        this.minStd = minStd;
    }
    
    
    public Double getSocSecPct() {
        return socSecPct;
    }

    public void setSocSecPct(Double socSecPct) {
        this.socSecPct = socSecPct;
    }

    public Double getSalesAvgMonth() {
        return salesAvgMonth;
    }

    public void setSalesAvgMonth(Double salesAvgMonth) {
        this.salesAvgMonth = salesAvgMonth;
    }
}