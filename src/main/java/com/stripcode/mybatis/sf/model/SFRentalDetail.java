package com.stripcode.mybatis.sf.model;

import com.stripcode.mybatis.common.BaseModel;

/**
 * Created by Metro on 2016/11/10.
 */
public class SFRentalDetail extends BaseModel{
    private String rowId;
    private String rentId;//对应T_SF_RENTAL_PROPOSAL_DIRECT_STORE表的ROW_ID
    private String rentTime;//起始年月
    private Double rental;//租金
    private Double rate;//扣率
    private Double baseRental;//保底租金(如果给保底 销售请直接乘以扣点计算)
    private Double transferFee;//转让费
    private Double propertyFee;//物业管理费
    private Double taxation;//无租赁发票,承担税费
    private Double subletFee;//转租收入

    public Double getPropertyFee() {
        return propertyFee;
    }

    public void setPropertyFee(Double propertyFee) {
        this.propertyFee = propertyFee;
    }

    @Override
    public String getRowId() {
        return rowId;
    }

    @Override
    public void setRowId(String rowId) {
        this.rowId = rowId;
    }

    public String getRentId() {
        return rentId;
    }

    public void setRentId(String rentId) {
        this.rentId = rentId;
    }

    public String getRentTime() {
        return rentTime;
    }

    public void setRentTime(String rentTime) {
        this.rentTime = rentTime;
    }

    public Double getRental() {
        return rental;
    }

    public void setRental(Double rental) {
        this.rental = rental;
    }

    public Double getRate() {
        return rate;
    }

    public void setRate(Double rate) {
        this.rate = rate;
    }

    public Double getBaseRental() {
        return baseRental;
    }

    public void setBaseRental(Double baseRental) {
        this.baseRental = baseRental;
    }

    public Double getTransferFee() {
        return transferFee;
    }

    public void setTransferFee(Double transferFee) {
        this.transferFee = transferFee;
    }

    public Double getTaxation() {
        return taxation;
    }

    public void setTaxation(Double taxation) {
        this.taxation = taxation;
    }

    public Double getSubletFee() {
        return subletFee;
    }

    public void setSubletFee(Double subletFee) {
        this.subletFee = subletFee;
    }
}
