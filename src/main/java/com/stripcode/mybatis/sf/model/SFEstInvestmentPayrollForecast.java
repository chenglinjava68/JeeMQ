package com.stripcode.mybatis.sf.model;

import com.stripcode.mybatis.common.BaseModel;

/**
 * @author Metro
 */
public class SFEstInvestmentPayrollForecast extends BaseModel {
    private String rowId;
    private String investmentId;
    private String posName;
    private int number;
    private Double fixSalaryStd;
    private Double mealSubStd;
    private Double rentSubStd;
    private Double fullAttndStd;
    private Double avgOvertime;
    private Double performCoef;

//    public SFEstInvestmentPayrollForecast(String investmentId, String posName, int number, Double fixSalaryStd, Double mealSubStd, Double rentsubstd, Double fullAttndStd, Double avgOvertime, Double performCoef) {
//        this.investmentId = investmentId;
//        this.posName = posName;
//        this.number = number;
//        this.fixSalaryStd = fixSalaryStd;
//        this.mealSubStd = mealSubStd;
//        this.rentsubstd = rentsubstd;
//        this.fullAttndStd = fullAttndStd;
//        this.avgOvertime = avgOvertime;
//        this.performCoef = performCoef;
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

    public String getPosName() {
        return posName;
    }

    public void setPosName(String posName) {
        this.posName = posName;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public Double getFixSalaryStd() {
        return fixSalaryStd;
    }

    public void setFixSalaryStd(Double fixSalaryStd) {
        this.fixSalaryStd = fixSalaryStd;
    }

    public Double getMealSubStd() {
        return mealSubStd;
    }

    public void setMealSubStd(Double mealSubStd) {
        this.mealSubStd = mealSubStd;
    }

    public Double getRentSubStd() {
        return rentSubStd;
    }

    public void setRentSubStd(Double rentSubStd) {
        this.rentSubStd = rentSubStd;
    }

    public Double getFullAttndStd() {
        return fullAttndStd;
    }

    public void setFullAttndStd(Double fullAttndStd) {
        this.fullAttndStd = fullAttndStd;
    }

    public Double getAvgOvertime() {
        return avgOvertime;
    }

    public void setAvgOvertime(Double avgOvertime) {
        this.avgOvertime = avgOvertime;
    }
    
    
    public Double getPerformCoef() {
        return performCoef;
    }

    public void setPerformCoef(Double performCoef) {
        this.performCoef = performCoef;
    }
}
