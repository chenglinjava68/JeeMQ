package com.stripcode.mybatis.sf.model;

import com.stripcode.core.annotation.Divide;
import com.stripcode.core.annotation.Multiply;
import com.stripcode.mybatis.common.BaseModel;

/**
 * @author Metro
 */
public class SFEstInvestmentResultData extends BaseModel {
    private String rowId;
    private String investmentId;
    private Double supplyDiscountRate; //供货折率
    private Double saleDiscountRate;//销售折让
    private Double yearCostSales;//年保本销售
    private Double dayDiscountRate;//日均保本点
    private Double firstSalesIncrRate;//第一年销售递增率
    private Double secondSalesIncrRate;//第二年销售递增率
    private Double thirdSalesIncrRate;//第三年销售递增率
    private Double firstSales;//第一年预计销售额
    private Double secondSales;//第二年预计销售额
    private Double thirdSales;//第三年预计销售额
    private Double firstFixCost;//第一年年固定费用
    private Double secondFixCost;//第二年年固定费用
    private Double thirdFixCost;//第三年年固定费用
    private Double firstOprCost;//第一年年经营费用
    private Double secondOprCost;//第二年年经营费用
    private Double thirdOprCost;//第三年年经营费用
    private Double firstUc;//第一年净利润
    private Double secondUc;//第二年净利润
    private Double thirdUc;//第三年净利润
    private Double firstUcPer;//第一年净利润率(%)
    private Double secondUcPer;//第二年净利润率(%)
    private Double thirdUcPer;//第三年净利润率(%)
    private Double firstCalbackYear;//第一年投资回收期
    private Double secondCalbackYear;//第二年投资回收期
    private Double thirdCalbackYear;//第三年投资回收期
    private Double totalSales;//合计预计年销售额
    private Double totalFixCost;//合计年固定费用
    private Double totalOprCost;//合计年经营费用
    private Double totalUc;//合计净利润
    private Double totalUcPer;//合计净利润(%)
    private String remark;//备注
    @Divide(10000)
    @Multiply(10000)
    public Double getTotalSales() {
        return totalSales;
    }

    public void setTotalSales(Double totalSales) {
        this.totalSales = totalSales;
    }
    @Multiply(10000)
    public Double getTotalFixCost() {
        return totalFixCost;
    }
    @Divide(10000)
    public void setTotalFixCost(Double totalFixCost) {
        this.totalFixCost = totalFixCost;
    }
    @Multiply(10000)
    public Double getTotalOprCost() {
        return totalOprCost;
    }
    @Divide(10000)
    public void setTotalOprCost(Double totalOprCost) {
        this.totalOprCost = totalOprCost;
    }
    @Multiply(10000)
    public Double getTotalUc() {
        return totalUc;
    }
    @Divide(10000)
    public void setTotalUc(Double totalUc) {
        this.totalUc = totalUc;
    }
    public Double getTotalUcPer() {
        return totalUcPer;
    }

    public void setTotalUcPer(Double totalUcPer) {
        this.totalUcPer = totalUcPer;
    }

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
    public Double getSupplyDiscountRate() {
        return supplyDiscountRate;
    }

    public void setSupplyDiscountRate(Double supplyDiscountRate) {
        this.supplyDiscountRate = supplyDiscountRate;
    }
    public Double getSaleDiscountRate() {
        return saleDiscountRate;
    }

    public void setSaleDiscountRate(Double saleDiscountRate) {
        this.saleDiscountRate = saleDiscountRate;
    }
    @Multiply(10000)
    public Double getYearCostSales() {
        return yearCostSales;
    }
    @Divide(10000)
    public void setYearCostSales(Double yearCostSales) {
        this.yearCostSales = yearCostSales;
    }
    @Multiply(10000)
    public Double getDayDiscountRate() {
        return dayDiscountRate;
    }
    @Divide(10000)
    public void setDayDiscountRate(Double dayDiscountRate) {
        this.dayDiscountRate = dayDiscountRate;
    }
    public Double getFirstSalesIncrRate() {
        return firstSalesIncrRate;
    }

    public void setFirstSalesIncrRate(Double firstSalesIncrRate) {
        this.firstSalesIncrRate = firstSalesIncrRate;
    }
    public Double getSecondSalesIncrRate() {
        return secondSalesIncrRate;
    }

    public void setSecondSalesIncrRate(Double secondSalesIncrRate) {
        this.secondSalesIncrRate = secondSalesIncrRate;
    }
    public Double getThirdSalesIncrRate() {
        return thirdSalesIncrRate;
    }

    public void setThirdSalesIncrRate(Double thirdSalesIncrRate) {
        this.thirdSalesIncrRate = thirdSalesIncrRate;
    }
    @Multiply(10000)
    public Double getFirstSales() {
        return firstSales;
    }
    @Divide(10000)
    public void setFirstSales(Double firstSales) {
        this.firstSales = firstSales;
    }
    @Multiply(10000)
    public Double getSecondSales() {
        return secondSales;
    }
    @Divide(10000)
    public void setSecondSales(Double secondSales) {
        this.secondSales = secondSales;
    }
    @Multiply(10000)
    public Double getThirdSales() {
        return thirdSales;
    }
    @Divide(10000)
    public void setThirdSales(Double thirdSales) {
        this.thirdSales = thirdSales;
    }
    @Multiply(10000)
    public Double getFirstFixCost() {
        return firstFixCost;
    }
    @Divide(10000)
    public void setFirstFixCost(Double firstFixCost) {
        this.firstFixCost = firstFixCost;
    }
    @Multiply(10000)
    public Double getSecondFixCost() {
        return secondFixCost;
    }
    @Divide(10000)
    public void setSecondFixCost(Double secondFixCost) {
        this.secondFixCost = secondFixCost;
    }
    @Multiply(10000)
    public Double getThirdFixCost() {
        return thirdFixCost;
    }
    @Divide(10000)
    public void setThirdFixCost(Double thirdFixCost) {
        this.thirdFixCost = thirdFixCost;
    }
    @Multiply(10000)
    public Double getFirstOprCost() {
        return firstOprCost;
    }
    @Divide(10000)
    public void setFirstOprCost(Double firstOprCost) {
        this.firstOprCost = firstOprCost;
    }
    @Multiply(10000)
    public Double getSecondOprCost() {
        return secondOprCost;
    }
    @Divide(10000)
    public void setSecondOprCost(Double secondOprCost) {
        this.secondOprCost = secondOprCost;
    }
    @Multiply(10000)
    public Double getThirdOprCost() {
        return thirdOprCost;
    }
    @Divide(10000)
    public void setThirdOprCost(Double thirdOprCost) {
        this.thirdOprCost = thirdOprCost;
    }
    @Multiply(10000)
    public Double getFirstUc() {
        return firstUc;
    }
    @Divide(10000)
    public void setFirstUc(Double firstUc) {
        this.firstUc = firstUc;
    }
    @Multiply(10000)
    public Double getSecondUc() {
        return secondUc;
    }
    @Divide(10000)
    public void setSecondUc(Double secondUc) {
        this.secondUc = secondUc;
    }
    @Multiply(10000)
    public Double getThirdUc() {
        return thirdUc;
    }
    @Divide(10000)
    public void setThirdUc(Double thirdUc) {
        this.thirdUc = thirdUc;
    }


    public Double getFirstUcPer() {
        return firstUcPer;
    }

    public void setFirstUcPer(Double firstUcPer) {
        this.firstUcPer = firstUcPer;
    }


    public Double getSecondUcPer() {
        return secondUcPer;
    }

    public void setSecondUcPer(Double secondUcPer) {
        this.secondUcPer = secondUcPer;
    }
    public Double getThirdUcPer() {
        return thirdUcPer;
    }

    public void setThirdUcPer(Double thirdUcPer) {
        this.thirdUcPer = thirdUcPer;
    }


    public Double getFirstCalbackYear() {
        return firstCalbackYear;
    }

    public void setFirstCalbackYear(Double firstCalbackYear) {
        this.firstCalbackYear = firstCalbackYear;
    }
    public Double getSecondCalbackYear() {
        return secondCalbackYear;
    }

    public void setSecondCalbackYear(Double secondCalbackYear) {
        this.secondCalbackYear = secondCalbackYear;
    }
    public Double getThirdCalbackYear() {
        return thirdCalbackYear;
    }

    public void setThirdCalbackYear(Double thirdCalbackYear) {
        this.thirdCalbackYear = thirdCalbackYear;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
