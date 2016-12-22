package com.stripcode.mybatis.cs.model;

import com.stripcode.mybatis.common.BaseModel;

import java.util.List;

/**
 * Created by Metro on 2016/12/15.
 */
public class CSAterMarketauz extends BaseModel{
    private String rowId;
    private String optimauthId;//优化Id
    private String newCustomerId;//新客户Id
    private String newErpCode;//新erpCode
    private String newErpName;//新erpName
    private String isNewErpId;//是否新增ERP市场ID
    private String erpCode;//ERP企业ID
    private String erpName;//ERP企业名称
    private String effictiveDate;//变更生效时间
    private String reason;//主体变更原因
    private String remark;//备注
    private String brand;//品牌
    private String userId;//负责人
    private String customerId;//客户ID
    private String userName;//客户名称
    private CSCustomerErpInfo csCustomerErpInfo;
    private List<CSMarketCustomerDiscountSplit> csMarketCustomerDiscountSplitList;

    public List<CSMarketCustomerDiscountSplit> getCsMarketCustomerDiscountSplitList() {
        return csMarketCustomerDiscountSplitList;
    }

    public void setCsMarketCustomerDiscountSplitList(List<CSMarketCustomerDiscountSplit> csMarketCustomerDiscountSplitList) {
        this.csMarketCustomerDiscountSplitList = csMarketCustomerDiscountSplitList;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    private String customerProperty;   //客户性质编码
    private String superiorCompany;     //上级公司
    private String corporation;         //负责人/法人
    private String idNumber;            //身份证号码
    private String companyName;         //公司名称
    private String businessLicense;     //营业执照
    private String postAddress;         //邮寄地址
    private String tel;         //电话

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getCustomerProperty() {
        return customerProperty;
    }

    public void setCustomerProperty(String customerProperty) {
        this.customerProperty = customerProperty;
    }

    public String getPostAddress() {
        return postAddress;
    }

    public void setPostAddress(String postAddress) {
        this.postAddress = postAddress;
    }

    public String getBusinessLicense() {
        return businessLicense;
    }

    public void setBusinessLicense(String businessLicense) {
        this.businessLicense = businessLicense;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    public String getCorporation() {
        return corporation;
    }

    public void setCorporation(String corporation) {
        this.corporation = corporation;
    }

    public String getSuperiorCompany() {
        return superiorCompany;
    }

    public void setSuperiorCompany(String superiorCompany) {
        this.superiorCompany = superiorCompany;
    }

    public CSCustomerErpInfo getCsCustomerErpInfo() {
        return csCustomerErpInfo;
    }

    public void setCsCustomerErpInfo(CSCustomerErpInfo csCustomerErpInfo) {
        this.csCustomerErpInfo = csCustomerErpInfo;
    }

    public String getNewErpCode() {
        return newErpCode;
    }

    public void setNewErpCode(String newErpCode) {
        this.newErpCode = newErpCode;
    }

    public String getNewErpName() {
        return newErpName;
    }

    public void setNewErpName(String newErpName) {
        this.newErpName = newErpName;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    @Override
    public String getRowId() {
        return rowId;
    }

    @Override
    public void setRowId(String rowId) {
        this.rowId = rowId;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getEffictiveDate() {
        return effictiveDate;
    }

    public void setEffictiveDate(String effictiveDate) {
        this.effictiveDate = effictiveDate;
    }

    public String getErpName() {
        return erpName;
    }

    public void setErpName(String erpName) {
        this.erpName = erpName;
    }

    public String getIsNewErpId() {
        return isNewErpId;
    }

    public void setIsNewErpId(String isNewErpId) {
        this.isNewErpId = isNewErpId;
    }

    public String getNewCustomerId() {
        return newCustomerId;
    }

    public void setNewCustomerId(String newCustomerId) {
        this.newCustomerId = newCustomerId;
    }

    public String getOptimauthId() {
        return optimauthId;
    }

    public void setOptimauthId(String optimauthId) {
        this.optimauthId = optimauthId;
    }

    public String getErpCode() {
        return erpCode;
    }

    public void setErpCode(String erpCode) {
        this.erpCode = erpCode;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }
}
