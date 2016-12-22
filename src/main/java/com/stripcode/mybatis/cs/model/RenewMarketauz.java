package com.stripcode.mybatis.cs.model;

import com.stripcode.mybatis.common.BaseModel;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Metro on 2016/8/24.
 */
public class RenewMarketauz extends BaseModel implements Serializable{
    private String rowId;
    private String optimauthId;
    private String startDate;
    private String endDate;
    private String userId;
    private String erpCode;
    private String erpName;
    private String customerId;
    private String remark;
    private String brand;
    private CSCustomerErpInfo csCustomerErpInfo;

    private List<CSStoreSalesLastYear> storeSalesList;

    public List<CSStoreSalesLastYear> getStoreSalesList() {
        return storeSalesList;
    }

    public void setStoreSalesList(List<CSStoreSalesLastYear> storeSalesList) {
        this.storeSalesList = storeSalesList;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public CSCustomerErpInfo getCsCustomerErpInfo() {
        return csCustomerErpInfo;
    }

    public void setCsCustomerErpInfo(CSCustomerErpInfo csCustomerErpInfo) {
        this.csCustomerErpInfo = csCustomerErpInfo;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getErpCode() {
        return erpCode;
    }

    public void setErpCode(String erpCode) {
        this.erpCode = erpCode;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getErpName() {
        return erpName;
    }

    public void setErpName(String erpName) {
        this.erpName = erpName;
    }

    public String getRowId() {
        return rowId;
    }

    public void setRowId(String rowId) {
        this.rowId = rowId;
    }

    public String getOptimauthId() {
        return optimauthId;
    }

    public void setOptimauthId(String optimauthId) {
        this.optimauthId = optimauthId;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
