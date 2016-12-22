package com.stripcode.mybatis.sf.model;

import com.stripcode.core.annotation.Divide;
import com.stripcode.core.annotation.Multiply;
import com.stripcode.core.util.DateUtil;
import com.stripcode.mybatis.common.BaseModel;
import org.apache.commons.lang3.StringUtils;

import java.util.Date;

public class TSfEstInvestmentNonLaborCost extends BaseModel {
    private String rowId;
    private String investmentId;
    private Double storeIncomeFir;
    private Double storeIncomeSec;
    private String rentTypeName;

    public String getRentType() {
        return rentType;
    }

    public void setRentType(String rentType) {
        this.rentType = rentType;
    }

    private String rentType;
    public String getRentTypeName() {
        return rentTypeName;
    }

    public void setRentTypeName(String rentTypeName) {
        this.rentTypeName = rentTypeName;
    }

    private Double storeIncomeThi;

    private Double storeIncomeFour;

    private Double storeIncomeFive;

    private Double rentMonthPerSquare;

    private Double rentFirstYear;

    private Double rentIncRate;

    private Double deductionPointFirYear;

    private Double rentContractTerm;

    private Double deductionPointContractTerm;

    private Double propertyFeeMonth;

    private Double propertyFeeYear;

    private String bothTakeHight;

    public String getBothTakeHightName() {
        return bothTakeHightName;
    }

    public void setBothTakeHightName(String bothTakeHightName) {
        this.bothTakeHightName = bothTakeHightName;
    }

    private String bothTakeHightName;

    private String rentStartDate;

    private String rentEndDate;

    private Double rentYears;

    private String openDate;

    private Double rentHalfYear;

    private Double leaseBond;

    private Double goodsBond;

    private Double renovationOtherFee;

    private Double joinInvestmentTotal;

    private Double propSuportFee;

    private Double logisticsSuportFee;

    private Double renovationSuportFee;

    private Double manageSalaryYear;

    private Double otherSuportFee;

    private Double companyInvestmentTotal;
    private Double estStoreDailyCost;
    @Multiply(10000)
    public Double getEstStoreDailyCost() {
        return estStoreDailyCost;
    }
    @Divide(10000)
    public void setEstStoreDailyCost(Double estStoreDailyCost) {
        this.estStoreDailyCost = estStoreDailyCost;
    }

    private Double mgrAnnualSalary;
    @Multiply(10000)
    public Double getMgrAnnualSalary() {
        return mgrAnnualSalary;
    }
    @Divide(10000)
    public void setMgrAnnualSalary(Double mgrAnnualSalary) {
        this.mgrAnnualSalary = mgrAnnualSalary;
    }
    @Multiply(10000)
    public Double getShoppingGuideSalary() {
        return shoppingGuideSalary;
    }
    @Divide(10000)
    public void setShoppingGuideSalary(Double shoppingGuideSalary) {
        this.shoppingGuideSalary = shoppingGuideSalary;
    }
    @Multiply(10000)
    public Double getSpecialPositionSalary() {
        return specialPositionSalary;
    }
    @Divide(10000)
    public void setSpecialPositionSalary(Double specialPositionSalary) {
        this.specialPositionSalary = specialPositionSalary;
    }

    private Double shoppingGuideSalary;
    private Double specialPositionSalary;
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
    @Multiply(10000)
    public Double getStoreIncomeFive() {
        return storeIncomeFive;
    }
    @Divide(10000)
    public void setStoreIncomeFive(Double storeIncomeFive) {
        this.storeIncomeFive = storeIncomeFive;
    }

    public Double getRentMonthPerSquare() {
        return rentMonthPerSquare;
    }

    public void setRentMonthPerSquare(Double rentMonthPerSquare) {
        this.rentMonthPerSquare = rentMonthPerSquare;
    }
    @Multiply(10000)
    public Double getRentFirstYear() {
        return rentFirstYear;
    }
    @Divide(10000)
    public void setRentFirstYear(Double rentFirstYear) {
        this.rentFirstYear = rentFirstYear;
    }
    
    
    public Double getRentIncRate() {
        return rentIncRate;
    }

    public void setRentIncRate(Double rentIncRate) {
        this.rentIncRate = rentIncRate;
    }
    
    
    public Double getDeductionPointFirYear() {
        return deductionPointFirYear;
    }

    public void setDeductionPointFirYear(Double deductionPointFirYear) {
        this.deductionPointFirYear = deductionPointFirYear;
    }
    @Multiply(10000)
    public Double getRentContractTerm() {
        return rentContractTerm;
    }
    @Divide(10000)
    public void setRentContractTerm(Double rentContractTerm) {
        this.rentContractTerm = rentContractTerm;
    }
    
    
    public Double getDeductionPointContractTerm() {
        return deductionPointContractTerm;
    }

    public void setDeductionPointContractTerm(Double deductionPointContractTerm) {
        this.deductionPointContractTerm = deductionPointContractTerm;
    }
    public Double getPropertyFeeMonth() {
        return propertyFeeMonth;
    }
    public void setPropertyFeeMonth(Double propertyFeeMonth) {
        this.propertyFeeMonth = propertyFeeMonth;
    }
    @Multiply(10000)
    public Double getPropertyFeeYear() {
        return propertyFeeYear;
    }
    @Divide(10000)
    public void setPropertyFeeYear(Double propertyFeeYear) {
        this.propertyFeeYear = propertyFeeYear;
    }

    public String getBothTakeHight() {
        return bothTakeHight;
    }

    public void setBothTakeHight(String bothTakeHight) {
        this.bothTakeHight = bothTakeHight;
    }

    public String getRentStartDate() {
        return rentStartDate;
    }

    public void setRentStartDate(String rentStartDate) {
        this.rentStartDate = rentStartDate;
    }

    public String getRentEndDate() {
        return rentEndDate;
    }

    public void setRentEndDate(String rentEndDate) {
        this.rentEndDate = rentEndDate;
    }

    public Double getRentYears() {
        if(StringUtils.isBlank(rentStartDate) || StringUtils.isBlank(rentEndDate)){
            return rentYears;
        }
        String rentYear = DateUtil.getYearBetween(new Date(rentStartDate.replaceAll("-","/")),new Date(rentEndDate.replaceAll("-","/")));
        if(StringUtils.isBlank(rentYear)){
            return rentYears;
        }
        return Double.parseDouble(rentYear);
    }

    public void setRentYears(Double rentYears) {
        this.rentYears = rentYears;
    }

    public String getOpenDate() {
        return openDate;
    }

    public void setOpenDate(String openDate) {
        this.openDate = openDate;
    }
    @Multiply(10000)
    public Double getRentHalfYear() {
        return rentHalfYear;
    }
    @Divide(10000)
    public void setRentHalfYear(Double rentHalfYear) {
        this.rentHalfYear = rentHalfYear;
    }
    @Multiply(10000)
    public Double getLeaseBond() {
        return leaseBond;
    }
    @Divide(10000)
    public void setLeaseBond(Double leaseBond) {
        this.leaseBond = leaseBond;
    }
    @Multiply(10000)
    public Double getGoodsBond() {
        return goodsBond;
    }
    @Divide(10000)
    public void setGoodsBond(Double goodsBond) {
        this.goodsBond = goodsBond;
    }
    @Multiply(10000)
    public Double getRenovationOtherFee() {
        return renovationOtherFee;
    }
    @Divide(10000)
    public void setRenovationOtherFee(Double renovationOtherFee) {
        this.renovationOtherFee = renovationOtherFee;
    }
    @Multiply(10000)
    public Double getJoinInvestmentTotal() {
        return joinInvestmentTotal;
    }
    @Divide(10000)
    public void setJoinInvestmentTotal(Double joinInvestmentTotal) {
        this.joinInvestmentTotal = joinInvestmentTotal;
    }

    public Double getPropSuportFee() {
        return propSuportFee;
    }

    public void setPropSuportFee(Double propSuportFee) {
        this.propSuportFee = propSuportFee;
    }
    @Multiply(10000)
    public Double getLogisticsSuportFee() {
        return logisticsSuportFee;
    }
    @Divide(10000)
    public void setLogisticsSuportFee(Double logisticsSuportFee) {
        this.logisticsSuportFee = logisticsSuportFee;
    }
    @Multiply(10000)
    public Double getRenovationSuportFee() {
        return renovationSuportFee;
    }
    @Divide(10000)
    public void setRenovationSuportFee(Double renovationSuportFee) {
        this.renovationSuportFee = renovationSuportFee;
    }
    @Multiply(10000)
    public Double getManageSalaryYear() {
        return manageSalaryYear;
    }
    @Divide(10000)
    public void setManageSalaryYear(Double manageSalaryYear) {
        this.manageSalaryYear = manageSalaryYear;
    }
    @Multiply(10000)
    public Double getOtherSuportFee() {
        return otherSuportFee;
    }
    @Divide(10000)
    public void setOtherSuportFee(Double otherSuportFee) {
        this.otherSuportFee = otherSuportFee;
    }
    @Multiply(10000)
    public Double getCompanyInvestmentTotal() {
        return companyInvestmentTotal;
    }
    @Divide(10000)
    public void setCompanyInvestmentTotal(Double companyInvestmentTotal) {
        this.companyInvestmentTotal = companyInvestmentTotal;
    }
}