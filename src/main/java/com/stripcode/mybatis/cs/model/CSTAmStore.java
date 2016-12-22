package com.stripcode.mybatis.cs.model;

import com.stripcode.mybatis.common.BaseModel;
import java.io.Serializable;

/**
 * Created by Metro on 2016/8/29.
 */
public class CSTAmStore extends BaseModel implements Serializable {
    private String storeCode; //店铺编码
    private String cnStoreName; //店铺中文名称
    private String storeType; //店铺类型
    private String marketId; //市场编码
    private String openDate; //开业日期
    private String closeDate; //关店日期
    private String city;      //市场城市
    private String region;    //市场地区
    private String province;  // 省份
    private String district;  //区域
    private String street;  //街道
    private String marketName; //市场名称
    private String brand;  //品牌
    private String delFlag;            //删除标记

    public String getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getMarketName() {
        return marketName;
    }

    public void setMarketName(String marketName) {
        this.marketName = marketName;
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

    public String getStoreType() {
        return storeType;
    }

    public void setStoreType(String storeType) {
        this.storeType = storeType;
    }

    public String getMarketId() {
        return marketId;
    }

    public void setMarketId(String marketId) {
        this.marketId = marketId;
    }

    public String getOpenDate() {
        return openDate;
    }

    public void setOpenDate(String openDate) {
        this.openDate = openDate;
    }

    public String getCloseDate() {
        return closeDate;
    }

    public void setCloseDate(String closeDate) {
        this.closeDate = closeDate;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
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
}
