package com.stripcode.mybatis.am.model;

import com.stripcode.mybatis.common.BaseModel;

/**店铺租金提案信息表
 * Created by Metro on 2016/12/14.
 */
public class AMRentalProposalDirectStore extends BaseModel {
    private String storeId;//店铺ID
    private String berthNo;//铺位号
    private Double roomRate;//得房率
    private String rentMode;//租赁方式
    private String signingMode;//签约方式
    private Double rentMth;//月租金(元/平)
    private Double propertyFeeMth;//月物管费(元/平)
    private String deliveryDate;//交场时间
    private String rentType;//租金类型
    private String rentPayType;//租金结算方式
    private String rentStartDate;//租赁起始日
    private String rentEndDate;//租赁结束日
    private String freeStartDate;//免租起始日
    private String freeEndDate;//免租结束日
    private String isSublet;//有无转租
    private String subletEndDate;//转租结束日
    private Double renovationPropertyFee;//装修期物业费
    private String operationFreeStartDae;//营运免租开始日期
    private String operationFreeEndDae;//营运免租结束日期
    private String deliveryConditions;//工程交付条件
    private Double leaseBond;//押金 （含结算预付金）
    private Double subletSale;//转租金额
    private String splitBrand;//分租品牌
    private Double splitArea;//分租面积
    private String splitStartDate;//分租起始日
    private Double endSales;//保底销售(万)
    private int leaseTerm;//合同年限(年数)
    private String rentalPropertyFee;//租金及物业管理费描述
    private String defaultClausePenalty;//合同约定违约条款/违约金说明
    private String specialTermsConditions;//特别条款申明
    private String otherFee;//其他费用描述

    public String getStoreId() {
        return storeId;
    }

    public void setStoreId(String storeId) {
        this.storeId = storeId;
    }

    public String getBerthNo() {
        return berthNo;
    }

    public void setBerthNo(String berthNo) {
        this.berthNo = berthNo;
    }

    public Double getRoomRate() {
        return roomRate;
    }

    public void setRoomRate(Double roomRate) {
        this.roomRate = roomRate;
    }

    public String getRentMode() {
        return rentMode;
    }

    public void setRentMode(String rentMode) {
        this.rentMode = rentMode;
    }

    public String getSigningMode() {
        return signingMode;
    }

    public void setSigningMode(String signingMode) {
        this.signingMode = signingMode;
    }

    public Double getRentMth() {
        return rentMth;
    }

    public void setRentMth(Double rentMth) {
        this.rentMth = rentMth;
    }

    public Double getPropertyFeeMth() {
        return propertyFeeMth;
    }

    public void setPropertyFeeMth(Double propertyFeeMth) {
        this.propertyFeeMth = propertyFeeMth;
    }

    public String getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(String deliveryDate) {
        this.deliveryDate = deliveryDate;
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

    public String getFreeStartDate() {
        return freeStartDate;
    }

    public void setFreeStartDate(String freeStartDate) {
        this.freeStartDate = freeStartDate;
    }

    public String getFreeEndDate() {
        return freeEndDate;
    }

    public void setFreeEndDate(String freeEndDate) {
        this.freeEndDate = freeEndDate;
    }

    public String getIsSublet() {
        return isSublet;
    }

    public void setIsSublet(String isSublet) {
        this.isSublet = isSublet;
    }

    public String getSubletEndDate() {
        return subletEndDate;
    }

    public void setSubletEndDate(String subletEndDate) {
        this.subletEndDate = subletEndDate;
    }

    public Double getRenovationPropertyFee() {
        return renovationPropertyFee;
    }

    public void setRenovationPropertyFee(Double renovationPropertyFee) {
        this.renovationPropertyFee = renovationPropertyFee;
    }

    public String getOperationFreeStartDae() {
        return operationFreeStartDae;
    }

    public void setOperationFreeStartDae(String operationFreeStartDae) {
        this.operationFreeStartDae = operationFreeStartDae;
    }

    public String getOperationFreeEndDae() {
        return operationFreeEndDae;
    }

    public void setOperationFreeEndDae(String operationFreeEndDae) {
        this.operationFreeEndDae = operationFreeEndDae;
    }

    public String getDeliveryConditions() {
        return deliveryConditions;
    }

    public void setDeliveryConditions(String deliveryConditions) {
        this.deliveryConditions = deliveryConditions;
    }

    public Double getLeaseBond() {
        return leaseBond;
    }

    public void setLeaseBond(Double leaseBond) {
        this.leaseBond = leaseBond;
    }

    public Double getSubletSale() {
        return subletSale;
    }

    public void setSubletSale(Double subletSale) {
        this.subletSale = subletSale;
    }

    public String getSplitBrand() {
        return splitBrand;
    }

    public void setSplitBrand(String splitBrand) {
        this.splitBrand = splitBrand;
    }

    public Double getSplitArea() {
        return splitArea;
    }

    public void setSplitArea(Double splitArea) {
        this.splitArea = splitArea;
    }

    public String getSplitStartDate() {
        return splitStartDate;
    }

    public void setSplitStartDate(String splitStartDate) {
        this.splitStartDate = splitStartDate;
    }

    public Double getEndSales() {
        return endSales;
    }

    public void setEndSales(Double endSales) {
        this.endSales = endSales;
    }

    public int getLeaseTerm() {
        return leaseTerm;
    }

    public void setLeaseTerm(int leaseTerm) {
        this.leaseTerm = leaseTerm;
    }

    public String getRentalPropertyFee() {
        return rentalPropertyFee;
    }

    public void setRentalPropertyFee(String rentalPropertyFee) {
        this.rentalPropertyFee = rentalPropertyFee;
    }

    public String getDefaultClausePenalty() {
        return defaultClausePenalty;
    }

    public void setDefaultClausePenalty(String defaultClausePenalty) {
        this.defaultClausePenalty = defaultClausePenalty;
    }

    public String getSpecialTermsConditions() {
        return specialTermsConditions;
    }

    public void setSpecialTermsConditions(String specialTermsConditions) {
        this.specialTermsConditions = specialTermsConditions;
    }

    public String getOtherFee() {
        return otherFee;
    }

    public void setOtherFee(String otherFee) {
        this.otherFee = otherFee;
    }
}
