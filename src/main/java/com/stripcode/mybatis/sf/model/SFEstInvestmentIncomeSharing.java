package com.stripcode.mybatis.sf.model;

import com.stripcode.mybatis.common.BaseModel;

public class SFEstInvestmentIncomeSharing extends BaseModel {

    private String investmentId;

    private String series;

    private Double salesPct;

    private Double incomeSharingRadio;
    private Double salesPctTotal;
    private Double incomeSharingRadioTotal;
    public Double getSalesPctTotal() {
        return salesPctTotal;
    }

    public void setSalesPctTotal(Double salesPctTotal) {
        this.salesPctTotal = salesPctTotal;
    }
    public Double getIncomeSharingRadioTotal() {
        return incomeSharingRadioTotal;
    }

    public void setIncomeSharingRadioTotal(Double incomeSharingRadioTotal) {
        this.incomeSharingRadioTotal = incomeSharingRadioTotal;
    }

    public String getSeriesName() {
        return seriesName;
    }

    public void setSeriesName(String seriesName) {
        this.seriesName = seriesName;
    }

    private String seriesName;
    private static final long serialVersionUID = 1L;

    public String getInvestmentId() {
        return investmentId;
    }

    public void setInvestmentId(String investmentId) {
        this.investmentId = investmentId;
    }

    public String getSeries() {
        return series;
    }

    public void setSeries(String series) {
        this.series = series;
    }
    public Double getSalesPct() {
        return salesPct;
    }

    public void setSalesPct(Double salesPct) {
        this.salesPct = salesPct;
    }
    public Double getIncomeSharingRadio() {
        return incomeSharingRadio;
    }

    public void setIncomeSharingRadio(Double incomeSharingRadio) {
        this.incomeSharingRadio = incomeSharingRadio;
    }

}