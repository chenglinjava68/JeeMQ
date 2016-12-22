package com.stripcode.mybatis.cs.model;


import com.stripcode.core.util.excelUtil.annotation.ExcelField;
import com.stripcode.mybatis.common.BaseModel;

import java.io.Serializable;

/**
 * Created by Metro on 2016/8/22.
 */
public class CSMarketOptimauth extends BaseModel implements Serializable {
    private String rowId;
    private String customerId;
    private String erpCode;
    private String erpName;
    private String optimizedType;
    private String currentNode;
    private String proStatus;
    private String corporation;
    private String customerProperty;
    private String superiorCompany;
    private String director;
    private String isNewErpId;
    private String brand;

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getIsNewErpId() {
        return isNewErpId;
    }

    public void setIsNewErpId(String isNewErpId) {
        this.isNewErpId = isNewErpId;
    }

    @ExcelField(title="当前所在任务节点", align=1, sort=4)
    public String getCurrentNode() {
        return currentNode;
    }

    public void setCurrentNode(String currentNode) {
        this.currentNode = currentNode;
    }

    public String getRowId() {
        return rowId;
    }

    public void setRowId(String rowId) {
        this.rowId = rowId;
    }

    @ExcelField(title="负责人", align=1, sort=5)
    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    @ExcelField(title="客户名称", align=1, sort=1)
    public String getCorporation() {
        return corporation;
    }

    public void setCorporation(String corporation) {
        this.corporation = corporation;
    }

    @ExcelField(title="客户性质", align=1, sort=2)
    public String getCustomerProperty() {
        return customerProperty;
    }

    public void setCustomerProperty(String customerProperty) {
        this.customerProperty = customerProperty;
    }

    @ExcelField(title="上级公司", align=1, sort=3)
    public String getSuperiorCompany() {
        return superiorCompany;
    }

    public void setSuperiorCompany(String superiorCompany) {
        this.superiorCompany = superiorCompany;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getErpCode() {
        return erpCode;
    }

    public void setErpCode(String erpCode) {
        this.erpCode = erpCode;
    }

    public String getErpName() {
        return erpName;
    }

    public void setErpName(String erpName) {
        this.erpName = erpName;
    }

    public String getOptimizedType() {
        return optimizedType;
    }

    public void setOptimizedType(String optimizedType) {
        this.optimizedType = optimizedType;
    }

    public String getProStatus() {
        return proStatus;
    }

    public void setProStatus(String proStatus) {
        this.proStatus = proStatus;
    }

}
