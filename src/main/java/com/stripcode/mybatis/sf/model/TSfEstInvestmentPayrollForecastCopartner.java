package com.stripcode.mybatis.sf.model;

import com.stripcode.mybatis.common.BaseModel;

public class TSfEstInvestmentPayrollForecastCopartner extends BaseModel {
    private String rowId;

    private String investmentId;

    private String posName;

    private Integer number;

    private Integer fixSalaryStd;

    private Integer mealSubStd;

    private Integer rentSubStd;

    private Integer fullAttndStd;

    private Double avgOvertime;

    private Double performCoef;

    private String recruitmentModel;

    public String getFullAttndStdSpare() {
        return fullAttndStdSpare;
    }

    public void setFullAttndStdSpare(String fullAttndStdSpare) {
        this.fullAttndStdSpare = fullAttndStdSpare;
    }

    private String fullAttndStdSpare;

    private String salaryBear;

    public String getFixedCharges() {
        return fixedCharges;
    }

    public void setFixedCharges(String fixedCharges) {
        this.fixedCharges = fixedCharges;
    }

    private String fixedCharges;

    private Double otherWelfare;

//    public TSfEstInvestmentPayrollForecastCopartner(String investmentId, String posName, int number, int fixSalaryStd, int mealSubStd, int rentSubStd, int fullAttndStd, double avgOvertime, double performCoef, String recruitmentModel, String salaryBear, double otherWelfare) {
//        this.investmentId = investmentId;
//        this.posName = posName;
//        this.number = number;
//        this.fixSalaryStd = fixSalaryStd;
//        this.mealSubStd = mealSubStd;
//        this.rentSubStd = rentSubStd;
//        this.fullAttndStd = fullAttndStd;
//        this.avgOvertime = avgOvertime;
//        this.performCoef = performCoef;
//        this.recruitmentModel = recruitmentModel;
//        this.salaryBear = salaryBear;
//        this.otherWelfare = otherWelfare;
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

    public Integer getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public Integer getFixSalaryStd() {
        return fixSalaryStd;
    }

    public void setFixSalaryStd(Integer fixSalaryStd) {
        this.fixSalaryStd = fixSalaryStd;
    }

    public Integer getMealSubStd() {
        return mealSubStd;
    }

    public void setMealSubStd(Integer mealSubStd) {
        this.mealSubStd = mealSubStd;
    }

    public Integer getRentSubStd() {
        return rentSubStd;
    }

    public void setRentSubStd(Integer rentSubStd) {
        this.rentSubStd = rentSubStd;
    }

    public int getFullAttndStd() {
        return fullAttndStd;
    }

    public void setFullAttndStd(Integer fullAttndStd) {
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

    public String getRecruitmentModel() {
        return recruitmentModel;
    }

    public void setRecruitmentModel(String recruitmentModel) {
        this.recruitmentModel = recruitmentModel;
    }

    public String getSalaryBear() {
        return salaryBear;
    }

    public void setSalaryBear(String salaryBear) {
        this.salaryBear = salaryBear;
    }

    public double getOtherWelfare() {
        return otherWelfare;
    }

    public void setOtherWelfare(Double otherWelfare) {
        this.otherWelfare = otherWelfare;
    }
}