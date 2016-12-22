package com.stripcode.mybatis.sf.model;

import com.stripcode.core.annotation.Divide;
import com.stripcode.core.annotation.Multiply;
import com.stripcode.mybatis.common.BaseModel;

public class TSfEstInvestmentResultDateCopartner extends BaseModel {
    private String rowId;

    private String investmentId;

    private Double storeIncomeFir;

    private Double storeIncomeSec;

    private Double storeIncomeThi;

    private Double storeIncomeFour;

    private Double storeIncomeFive;

    private Double companyIncomeFir;

    private Double companyIncomeSec;

    private Double companyIncomeThi;

    private Double companyIncomeFour;

    private Double companyIncomeFive;

    private Double copartnerUcFir;

    private Double copartnerUcSec;

    private Double copartnerUcThi;

    private Double copartnerUcFour;

    private Double copartnerUcFive;

    private Double companyUcFir;

    private Double companyUcSec;

    private Double companyUcThi;

    private Double companyUcFour;

    private Double companyUcFive;

    private String remark;

    private Double storeIncomeTotal;

    private Double companyIncomeTotal;

    private Double copartnerUcTotal;

    private Double companyUcTotal;

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
    @Multiply(10000)
    public Double getStoreIncomeFir() {
        return storeIncomeFir;
    }
    @Divide(10000)
    public void setStoreIncomeFir(Double storeIncomeFir) {
        this.storeIncomeFir = storeIncomeFir;
    }
    @Multiply(10000)
    public Double getStoreIncomeSec() {
        return storeIncomeSec;
    }
    @Divide(10000)
    public void setStoreIncomeSec(Double storeIncomeSec) {
        this.storeIncomeSec = storeIncomeSec;
    }
    @Multiply(10000)
    public Double getStoreIncomeThi() {
        return storeIncomeThi;
    }
    @Divide(10000)
    public void setStoreIncomeThi(Double storeIncomeThi) {
        this.storeIncomeThi = storeIncomeThi;
    }
    @Multiply(10000)
    public Double getStoreIncomeFour() {
        return storeIncomeFour;
    }
    @Divide(10000)
    public void setStoreIncomeFour(Double storeIncomeFour) {
        this.storeIncomeFour = storeIncomeFour;
    }
    @Divide(10000)
    @Multiply(10000)
    public Double getStoreIncomeFive() {
        return storeIncomeFive;
    }

    public void setStoreIncomeFive(Double storeIncomeFive) {
        this.storeIncomeFive = storeIncomeFive;
    }
    @Multiply(10000)
    public Double getCompanyIncomeFir() {
        return companyIncomeFir;
    }
    @Divide(10000)
    public void setCompanyIncomeFir(Double companyIncomeFir) {
        this.companyIncomeFir = companyIncomeFir;
    }
    @Multiply(10000)
    public Double getCompanyIncomeSec() {
        return companyIncomeSec;
    }
    @Divide(10000)
    public void setCompanyIncomeSec(Double companyIncomeSec) {
        this.companyIncomeSec = companyIncomeSec;
    }
    @Multiply(10000)
    public Double getCompanyIncomeThi() {
        return companyIncomeThi;
    }
    @Divide(10000)
    public void setCompanyIncomeThi(Double companyIncomeThi) {
        this.companyIncomeThi = companyIncomeThi;
    }
    @Multiply(10000)
    public Double getCompanyIncomeFour() {
        return companyIncomeFour;
    }
    @Divide(10000)
    public void setCompanyIncomeFour(Double companyIncomeFour) {
        this.companyIncomeFour = companyIncomeFour;
    }
    @Multiply(10000)
    public Double getCompanyIncomeFive() {
        return companyIncomeFive;
    }
    @Divide(10000)
    public void setCompanyIncomeFive(Double companyIncomeFive) {
        this.companyIncomeFive = companyIncomeFive;
    }
    @Multiply(10000)
    public Double getCopartnerUcFir() {
        return copartnerUcFir;
    }
    @Divide(10000)
    public void setCopartnerUcFir(Double copartnerUcFir) {
        this.copartnerUcFir = copartnerUcFir;
    }
    @Multiply(10000)
    public Double getCopartnerUcSec() {
        return copartnerUcSec;
    }
    @Divide(10000)
    public void setCopartnerUcSec(Double copartnerUcSec) {
        this.copartnerUcSec = copartnerUcSec;
    }
    @Multiply(10000)
    public Double getCopartnerUcThi() {
        return copartnerUcThi;
    }
    @Divide(10000)
    public void setCopartnerUcThi(Double copartnerUcThi) {
        this.copartnerUcThi = copartnerUcThi;
    }
    @Multiply(10000)
    public Double getCopartnerUcFour() {
        return copartnerUcFour;
    }
    @Divide(10000)
    public void setCopartnerUcFour(Double copartnerUcFour) {
        this.copartnerUcFour = copartnerUcFour;
    }
    @Multiply(10000)
    public Double getCopartnerUcFive() {
        return copartnerUcFive;
    }
    @Divide(10000)
    public void setCopartnerUcFive(Double copartnerUcFive) {
        this.copartnerUcFive = copartnerUcFive;
    }
    @Multiply(10000)
    public Double getCompanyUcFir() {
        return companyUcFir;
    }
    @Divide(10000)
    public void setCompanyUcFir(Double companyUcFir) {
        this.companyUcFir = companyUcFir;
    }
    @Multiply(10000)
    public Double getCompanyUcSec() {
        return companyUcSec;
    }
    @Divide(10000)
    public void setCompanyUcSec(Double companyUcSec) {
        this.companyUcSec = companyUcSec;
    }
    @Multiply(10000)
    public Double getCompanyUcThi() {
        return companyUcThi;
    }
    @Divide(10000)
    public void setCompanyUcThi(Double companyUcThi) {
        this.companyUcThi = companyUcThi;
    }
    @Multiply(10000)
    public Double getCompanyUcFour() {
        return companyUcFour;
    }
    @Divide(10000)
    public void setCompanyUcFour(Double companyUcFour) {
        this.companyUcFour = companyUcFour;
    }
    @Multiply(10000)
    public Double getCompanyUcFive() {
        return companyUcFive;
    }
    @Divide(10000)
    public void setCompanyUcFive(Double companyUcFive) {
        this.companyUcFive = companyUcFive;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
    @Multiply(10000)
    public Double getStoreIncomeTotal() {
        return storeIncomeTotal;
    }
    @Divide(10000)
    public void setStoreIncomeTotal(Double storeIncomeTotal) {
        this.storeIncomeTotal = storeIncomeTotal;
    }
    @Multiply(10000)
    public Double getCompanyIncomeTotal() {
        return companyIncomeTotal;
    }
    @Divide(10000)
    public void setCompanyIncomeTotal(Double companyIncomeTotal) {
        this.companyIncomeTotal = companyIncomeTotal;
    }
    @Multiply(10000)
    public Double getCopartnerUcTotal() {
        return copartnerUcTotal;
    }
    @Divide(10000)
    public void setCopartnerUcTotal(Double copartnerUcTotal) {
        this.copartnerUcTotal = copartnerUcTotal;
    }
    @Multiply(10000)
    public Double getCompanyUcTotal() {
        return companyUcTotal;
    }
    @Divide(10000)
    public void setCompanyUcTotal(Double companyUcTotal) {
        this.companyUcTotal = companyUcTotal;
    }
}