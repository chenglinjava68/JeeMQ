package com.stripcode.mybatis.sf.model;

import com.stripcode.mybatis.common.BaseModel;
import com.stripcode.mybatis.cs.model.CSNewMarketAuz;

/**
 * @author Metro
 */
public class SFContactInfo extends BaseModel {
    private String rowId;
    private String ppId;
    private String manager;
    private String managerPhone;
    private String decorationDate;
    private String deliveryDate;
    private String commodityMg;
    private String leagueMg;
    private String promotionMg;
    private String infoMg;
    private String accountingMg;
    private String engineeringMg;
    private String developmentMg;
    private String consignee;
    private String consigneePhone;
    private String post;
    private String address;
    private String warehouse;
    private String transportCycle;
    private String erpReception;
    private String remark;

    private CSNewMarketAuz csNewMarketAuz;

    public CSNewMarketAuz getCsNewMarketAuz() {
        return csNewMarketAuz;
    }

    public void setCsNewMarketAuz(CSNewMarketAuz csNewMarketAuz) {
        this.csNewMarketAuz = csNewMarketAuz;
    }

    @Override
    public String getRowId() {
        return rowId;
    }

    @Override
    public void setRowId(String rowId) {
        this.rowId = rowId;
    }

    public String getPpId() {
        return ppId;
    }

    public void setPpId(String ppId) {
        this.ppId = ppId;
    }

    public String getManager() {
        return manager;
    }

    public void setManager(String manager) {
        this.manager = manager;
    }

    public String getManagerPhone() {
        return managerPhone;
    }

    public void setManagerPhone(String managerPhone) {
        this.managerPhone = managerPhone;
    }

    public String getDecorationDate() {
        return decorationDate;
    }

    public void setDecorationDate(String decorationDate) {
        this.decorationDate = decorationDate;
    }

    public String getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(String deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public String getCommodityMg() {
        return commodityMg;
    }

    public void setCommodityMg(String commodityMg) {
        this.commodityMg = commodityMg;
    }

    public String getLeagueMg() {
        return leagueMg;
    }

    public void setLeagueMg(String leagueMg) {
        this.leagueMg = leagueMg;
    }

    public String getPromotionMg() {
        return promotionMg;
    }

    public void setPromotionMg(String promotionMg) {
        this.promotionMg = promotionMg;
    }

    public String getInfoMg() {
        return infoMg;
    }

    public void setInfoMg(String infoMg) {
        this.infoMg = infoMg;
    }

    public String getAccountingMg() {
        return accountingMg;
    }

    public void setAccountingMg(String accountingMg) {
        this.accountingMg = accountingMg;
    }

    public String getEngineeringMg() {
        return engineeringMg;
    }

    public void setEngineeringMg(String engineeringMg) {
        this.engineeringMg = engineeringMg;
    }

    public String getDevelopmentMg() {
        return developmentMg;
    }

    public void setDevelopmentMg(String developmentMg) {
        this.developmentMg = developmentMg;
    }

    public String getConsignee() {
        return consignee;
    }

    public void setConsignee(String consignee) {
        this.consignee = consignee;
    }

    public String getConsigneePhone() {
        return consigneePhone;
    }

    public void setConsigneePhone(String consigneePhone) {
        this.consigneePhone = consigneePhone;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getWarehouse() {
        return warehouse;
    }

    public void setWarehouse(String warehouse) {
        this.warehouse = warehouse;
    }

    public String getTransportCycle() {
        return transportCycle;
    }

    public void setTransportCycle(String transportCycle) {
        this.transportCycle = transportCycle;
    }

    public String getErpReception() {
        return erpReception;
    }

    public void setErpReception(String erpReception) {
        this.erpReception = erpReception;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
