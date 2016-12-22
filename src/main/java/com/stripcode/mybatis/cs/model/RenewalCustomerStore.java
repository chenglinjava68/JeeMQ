package com.stripcode.mybatis.cs.model;

import com.stripcode.mybatis.common.BaseModel;

import java.io.Serializable;

/**
 * Created by Metro on 2016/8/30.
 */
public class RenewalCustomerStore extends BaseModel implements Serializable {
    private String rowId;
    private String customerId;
    private String storeCode;
    private String cnStoreName;
    private String openDate;
    private String sales;
    private String incrate;
    private String salesYear1;
    private String salesYear1Incrate;
    private String salesYear2;
    private String salesYear2Incrate;
    private String salesYear3;
    private String salesYear3Incrate;

    public String getRowId() {
        return rowId;
    }

    public void setRowId(String rowId) {
        this.rowId = rowId;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getStoreCode() {
        return storeCode;
    }

    public void setStoreCode(String storeCode) {
        this.storeCode = storeCode;
    }

    public String getCnStoreName() {
        return cnStoreName;
    }

    public void setCnStoreName(String cnStoreName) {
        this.cnStoreName = cnStoreName;
    }

    public String getOpenDate() {
        return openDate;
    }

    public void setOpenDate(String openDate) {
        this.openDate = openDate;
    }

    public String getSales() {
        return sales;
    }

    public void setSales(String sales) {
        this.sales = sales;
    }

    public String getIncrate() {
        return incrate;
    }

    public void setIncrate(String incrate) {
        this.incrate = incrate;
    }

    public String getSalesYear1() {
        return salesYear1;
    }

    public void setSalesYear1(String salesYear1) {
        this.salesYear1 = salesYear1;
    }

    public String getSalesYear1Incrate() {
        return salesYear1Incrate;
    }

    public void setSalesYear1Incrate(String salesYear1Incrate) {
        this.salesYear1Incrate = salesYear1Incrate;
    }

    public String getSalesYear2() {
        return salesYear2;
    }

    public void setSalesYear2(String salesYear2) {
        this.salesYear2 = salesYear2;
    }

    public String getSalesYear2Incrate() {
        return salesYear2Incrate;
    }

    public void setSalesYear2Incrate(String salesYear2Incrate) {
        this.salesYear2Incrate = salesYear2Incrate;
    }

    public String getSalesYear3() {
        return salesYear3;
    }

    public void setSalesYear3(String salesYear3) {
        this.salesYear3 = salesYear3;
    }

    public String getSalesYear3Incrate() {
        return salesYear3Incrate;
    }

    public void setSalesYear3Incrate(String salesYear3Incrate) {
        this.salesYear3Incrate = salesYear3Incrate;
    }
}
