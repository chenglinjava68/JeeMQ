package com.stripcode.mybatis.cs.model;

import com.stripcode.mybatis.common.BaseModel;

import java.io.Serializable;

/**
 * Created by Metro on 2016/8/26.
 */
public class CSCustomerPP  extends BaseModel implements Serializable{

    private String  rowId;
    private String optimauthId;
    private String customerId;
    private String ppId;
    private String oldStoreCode;
    private String newStoreCode;
    private String cnSiteName;
    private Double salesY1;
    private Double salesY1InCrate;
    private Double salesY2;
    private Double salesY2InCrate;
    private Double salesY3;
    private Double salesY3InCrate;
    private CSCustomerInfo csCustomerInfo;
    private String delFlag;
    private String addressCn;
    private String actualOpendate;
    private String taskId;

    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }

    public String getOldStoreCode() {
        return oldStoreCode;
    }

    public void setOldStoreCode(String oldStoreCode) {
        this.oldStoreCode = oldStoreCode;
    }

    public String getNewStoreCode() {
        return newStoreCode;
    }

    public void setNewStoreCode(String newStoreCode) {
        this.newStoreCode = newStoreCode;
    }

    public String getAddressCn() {
        return addressCn;
    }

    public void setAddressCn(String addressCn) {
        this.addressCn = addressCn;
    }

    public String getActualOpendate() {
        return actualOpendate;
    }

    public void setActualOpendate(String actualOpendate) {
        this.actualOpendate = actualOpendate;
    }

    public String getOptimauthId() {
        return optimauthId;
    }

    public void setOptimauthId(String optimauthId) {
        this.optimauthId = optimauthId;
    }

    public String getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag;
    }

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

    public String getPpId() {
        return ppId;
    }

    public void setPpId(String ppId) {
        this.ppId = ppId;
    }

    public String getCnSiteName() {
        return cnSiteName;
    }

    public void setCnSiteName(String cnSiteName) {
        this.cnSiteName = cnSiteName;
    }

    public Double getSalesY1() {
        return salesY1;
    }

    public void setSalesY1(Double salesY1) {
        this.salesY1 = salesY1;
    }

    public Double getSalesY1InCrate() {
        return salesY1InCrate;
    }

    public void setSalesY1InCrate(Double salesY1InCrate) {
        this.salesY1InCrate = salesY1InCrate;
    }

    public Double getSalesY2() {
        return salesY2;
    }

    public void setSalesY2(Double salesY2) {
        this.salesY2 = salesY2;
    }

    public Double getSalesY2InCrate() {
        return salesY2InCrate;
    }

    public void setSalesY2InCrate(Double salesY2InCrate) {
        this.salesY2InCrate = salesY2InCrate;
    }

    public Double getSalesY3() {
        return salesY3;
    }

    public void setSalesY3(Double salesY3) {
        this.salesY3 = salesY3;
    }

    public Double getSalesY3InCrate() {
        return salesY3InCrate;
    }

    public void setSalesY3InCrate(Double salesY3InCrate) {
        this.salesY3InCrate = salesY3InCrate;
    }

    public CSCustomerInfo getCsCustomerInfo() {
        return csCustomerInfo;
    }

    public void setCsCustomerInfo(CSCustomerInfo csCustomerInfo) {
        this.csCustomerInfo = csCustomerInfo;
    }
}
