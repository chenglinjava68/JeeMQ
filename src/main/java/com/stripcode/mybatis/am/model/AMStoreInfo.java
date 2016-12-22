package com.stripcode.mybatis.am.model;

import com.stripcode.core.util.excelUtil.annotation.ExcelField;
import com.stripcode.mybatis.common.BaseModel;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Metro on 2016/10/17.
 */
public class AMStoreInfo extends BaseModel implements Serializable {
    private String storeId; //32位码
    private String storeCode; //店铺编码
    private String ppId; //意向店ID
    private String cnsiteName; //店铺名称
    private String brand; //品牌
    private String operationMode; //经营方式
    private String channelType; //渠道类型
    private String storeImage; //店铺形象
    private String country;//国家
    private String province; //省份
    private String city; //城市
    private String district; //区县
    private String street; //街道
    private String address; //地址
    private String approvalDate; //报批日期
    private String signDate; //签约日期
    private String postCode; //邮编
    private String tel; //电话
    private String openDate; //开业日期
    private String reformDate; //改造后开业日期
    private String status ; //营运状态
    private String contractStartDate; //合同开始日期
    private String contractEndDate; //合同结束日期
    private Double applyArea; //适用面积
    private Double operateArea; //营业面积
    private Double reserveArea; //后备空间面积
    private String customerId; //加盟商
    private String custormerProperty; //加盟商性质
    private String coopMode;//合作模式
    private String joinedSignDate; //加盟签约日期
    private String repId; //店拓人员
    private String operationMgr; //店铺运营

    private String storeProperty; //店铺性质
    private String corporation; //法人代表
    private String area;//区域
    private String marketName;//市场名称

    @ExcelField(title="市场名称", align=1, sort=11)
    public String getMarketName() {
        return marketName;
    }

    public void setMarketName(String marketName) {
        this.marketName = marketName;
    }

    @ExcelField(title="区域", align=1, sort=8)
    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    private List<AMAuthorizationInfo> contractList;//店铺授权书附件集合

    public List<AMAuthorizationInfo> getContractList() {
        return contractList;
    }

    public void setContractList(List<AMAuthorizationInfo> contractList) {
        this.contractList = contractList;
    }

    public String getCorporation() {
        return corporation;
    }

    public void setCorporation(String corporation) {
        this.corporation = corporation;
    }

    @ExcelField(title="店铺性质", align=1, sort=6)
    public String getStoreProperty() {
        return storeProperty;
    }

    public void setStoreProperty(String storeProperty) {
        this.storeProperty = storeProperty;
    }

    public String getStoreId() {
        return storeId;
    }

    public void setStoreId(String storeId) {
        this.storeId = storeId;
    }

    @ExcelField(title="店铺编码", align=3, sort=2)
    public String getStoreCode() {
        return storeCode;
    }

    public void setStoreCode(String storeCode) {
        this.storeCode = storeCode;
    }

    public String getPpId() {
        return ppId;
    }

    public void setPpId(String ppId) {
        this.ppId = ppId;
    }

    @ExcelField(title="店铺名称", align=1, sort=3)
    public String getCnsiteName() {
        return cnsiteName;
    }

    public void setCnsiteName(String cnsiteName) {
        this.cnsiteName = cnsiteName;
    }

    @ExcelField(title="品牌", align=1, sort=7)
    public String getBrand() {return brand;}

    public void setBrand(String brand) {
        this.brand = brand;
    }

    @ExcelField(title="经营方式", align=1, sort=4)
    public String getOperationMode() {
        return operationMode;
    }

    public void setOperationMode(String operationMode) {
        this.operationMode = operationMode;
    }

    @ExcelField(title="渠道类型", align=1, sort=5)
    public String getChannelType() {
        return channelType;
    }

    public void setChannelType(String channelType) {
        this.channelType = channelType;
    }

    public String getStoreImage() {
        return storeImage;
    }

    public void setStoreImage(String storeImage) {
        this.storeImage = storeImage;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCoopMode() {
        return coopMode;
    }

    public void setCoopMode(String coopMode) {
        this.coopMode = coopMode;
    }

    @ExcelField(title="省份", align=1, sort=9)
    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    @ExcelField(title="城市", align=1, sort=10)
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCustormerProperty() {
        return custormerProperty;
    }

    public void setCustormerProperty(String custormerProperty) {
        this.custormerProperty = custormerProperty;
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    @Override
    @ExcelField(title="状态", align=2, sort=1)
    public String getStatus() {
        return status;
    }
    @Override
    public void setStatus(String status) {
        this.status = status;
    }

    public Double getApplyArea() {
        return applyArea;
    }

    public void setApplyArea(Double applyArea) {
        this.applyArea = applyArea;
    }

    public Double getOperateArea() {
        return operateArea;
    }

    public void setOperateArea(Double operateArea) {
        this.operateArea = operateArea;
    }

    public Double getReserveArea() {
        return reserveArea;
    }

    public void setReserveArea(Double reserveArea) {
        this.reserveArea = reserveArea;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }




    public String getRepId() {
        return repId;
    }

    public void setRepId(String repId) {
        this.repId = repId;
    }

    public String getOperationMgr() {
        return operationMgr;
    }

    public void setOperationMgr(String operationMgr) {
        this.operationMgr = operationMgr;
    }

    public String getApprovalDate() {
        return approvalDate;
    }

    public void setApprovalDate(String approvalDate) {
        this.approvalDate = approvalDate;
    }

    public String getSignDate() {
        return signDate;
    }

    public void setSignDate(String signDate) {this.signDate = signDate;}

    public String getOpenDate() {
        return openDate;
    }

    public void setOpenDate(String openDate) {
        this.openDate = openDate;
    }

    public String getReformDate() {
        return reformDate;
    }

    public void setReformDate(String reformDate) {
        this.reformDate = reformDate;
    }

    public String getContractStartDate() {
        return contractStartDate;
    }

    public void setContractStartDate(String contractStartDate) {
        this.contractStartDate = contractStartDate;
    }

    public String getContractEndDate() {
        return contractEndDate;
    }

    public void setContractEndDate(String contractEndDate) {
        this.contractEndDate = contractEndDate;
    }

    public String getJoinedSignDate() {
        return joinedSignDate;
    }

    public void setJoinedSignDate(String joinedSignDate) {
        this.joinedSignDate = joinedSignDate;
    }
}
