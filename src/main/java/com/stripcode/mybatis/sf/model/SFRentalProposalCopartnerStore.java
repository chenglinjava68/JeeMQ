package com.stripcode.mybatis.sf.model;

import com.stripcode.core.annotation.Divide;
import com.stripcode.core.annotation.Multiply;
import com.stripcode.mybatis.common.BaseModel;

/**
 * Created by Metro on 2016/11/15.
 */
public class SFRentalProposalCopartnerStore extends BaseModel{
    private String rowId;
    private String ppId;
    private String rentMode;//物业性质
    private String rentType;//租金类型
    private String rentPayType;//租金结算方式
    private Double rentPerSquare;//月租金
    private Double rentFirstYear;//第一年租金
    private Double rentIncRate;//租金递增比例
    private Double rentContractTerm;//合同期租金情况
    private Double deductionPointFirstYear;//第一年扣点
    private Double deductionPointContractTerm;//合同期扣点情况
    private Double propertyFeePerSquare;//月物管费
    private Double propertyFeeYear;//年物业管理费
    private String bothTakeHight;//租金/扣点是否二者取其高
    private String relation;//承租方与客户的关系
    private String rentStartDate;//租赁起始日
    private String rentEndDate;//租赁起始日
    private Double leaseBond;//店铺租赁保证金

    @Multiply(10000)
    public Double getLeaseBond() {
        return leaseBond;
    }
    @Divide(10000)
    public void setLeaseBond(Double leaseBond) {
        this.leaseBond = leaseBond;
    }

    public String getPpId() {
        return ppId;
    }

    public void setPpId(String ppId) {
        this.ppId = ppId;
    }

    public String getRelation() {
        return relation;
    }

    public void setRelation(String relation) {
        this.relation = relation;
    }

    public String getRentEndDate() {
        return rentEndDate;
    }

    public void setRentEndDate(String rentEndDate) {
        this.rentEndDate = rentEndDate;
    }

    public String getRentStartDate() {
        return rentStartDate;
    }

    public void setRentStartDate(String rentStartDate) {
        this.rentStartDate = rentStartDate;
    }

    @Override
    public String getRowId() {
        return rowId;
    }

    @Override
    public void setRowId(String rowId) {
        this.rowId = rowId;
    }

    public String getBothTakeHight() {
        return bothTakeHight;
    }

    public void setBothTakeHight(String bothTakeHight) {
        this.bothTakeHight = bothTakeHight;
    }

    public String getRentMode() {
        return rentMode;
    }

    public void setRentMode(String rentMode) {
        this.rentMode = rentMode;
    }

    public String getRentType() {
        return rentType;
    }

    public void setRentType(String rentType) {
        this.rentType = rentType;
    }

    public String getRentPayType() {
        return rentPayType;
    }

    public void setRentPayType(String rentPayType) {
        this.rentPayType = rentPayType;
    }

    public Double getRentPerSquare() {
        return rentPerSquare;
    }

    public void setRentPerSquare(Double rentPerSquare) {
        this.rentPerSquare = rentPerSquare;
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
    @Multiply(10000)
    public Double getRentContractTerm() {
        return rentContractTerm;
    }
    @Divide(10000)
    public void setRentContractTerm(Double rentContractTerm) {
        this.rentContractTerm = rentContractTerm;
    }

    public Double getDeductionPointFirstYear() {
        return deductionPointFirstYear;
    }

    public void setDeductionPointFirstYear(Double deductionPointFirstYear) {
        this.deductionPointFirstYear = deductionPointFirstYear;
    }

    public Double getDeductionPointContractTerm() {
        return deductionPointContractTerm;
    }

    public void setDeductionPointContractTerm(Double deductionPointContractTerm) {
        this.deductionPointContractTerm = deductionPointContractTerm;
    }

    public Double getPropertyFeePerSquare() {
        return propertyFeePerSquare;
    }

    public void setPropertyFeePerSquare(Double propertyFeePerSquare) {
        this.propertyFeePerSquare = propertyFeePerSquare;
    }
    @Multiply(10000)
    public Double getPropertyFeeYear() {
        return propertyFeeYear;
    }
    @Divide(10000)
    public void setPropertyFeeYear(Double propertyFeeYear) {
        this.propertyFeeYear = propertyFeeYear;
    }
}
