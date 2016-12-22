package com.stripcode.mybatis.sf.model;

import com.stripcode.mybatis.common.BaseModel;

/**
 * @author Metro
 */
public class SFEstInvestmentSalesYear extends BaseModel {
    private String rowId;
    private String investmentId;
    private String rentTime;
    private Double sales;
    private Double rental;
    private Double rate;
    private Double baseRental;
    private Double transferFee;
    private Double propertyFee;
    private Double taxation;
    private Double subletFee;

    public Double getSales() {
        return sales;
    }

    public void setSales(Double sales) {
        this.sales = sales;
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

    public Double getPropertyFee() {
        return propertyFee;
    }

    public void setPropertyFee(Double propertyFee) {
        this.propertyFee = propertyFee;
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

    private String rentId;

    public String getRentId() {
        return rentId;
    }

    public void setRentId(String rentId) {
        this.rentId = rentId;
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

    public String getRentTime() {
        return rentTime;
    }

    public void setRentTime(String rentTime) {
        this.rentTime = rentTime;
    }















}
