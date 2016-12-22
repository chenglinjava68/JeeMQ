package com.stripcode.mybatis.cs.model;

import com.stripcode.mybatis.common.BaseModel;

/**
 * Created by Metro on 2016/8/24.
 */
public class CSErpInfo extends BaseModel {
    private String customerId; //客户ID
    private String erpCode;      //ErpID
    private String erpName;    //erp名称
    private String rowId;      //rowId
    private String delFlag;            //删除标记
    private String cnSiteName;      //店铺名称
    private String newStoreCode;  //新的店铺编码
    private String ppId;

    public String getErpCode() {
        return erpCode;
    }

    public void setErpCode(String erpCode) {
        this.erpCode = erpCode;
    }

    public String getPpId() {
        return ppId;
    }

    public void setPpId(String ppId) {
        this.ppId = ppId;
    }

    public String getNewStoreCode() {
        return newStoreCode;
    }

    public void setNewStoreCode(String newStoreCode) {
        this.newStoreCode = newStoreCode;
    }

    public String getCnSiteName() {
        return cnSiteName;
    }

    public void setCnSiteName(String cnSiteName) {
        this.cnSiteName = cnSiteName;
    }

    public String getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getErpId() {
        return erpCode;
    }

    public void setErpId(String erpId) {
        this.erpCode = erpCode;
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
}
