package com.stripcode.mybatis.cp.model;

import com.stripcode.core.util.excelUtil.annotation.ExcelField;
import com.stripcode.mybatis.common.BaseModel;

import java.io.Serializable;

/**
 * Created by Metro on 2016/8/19.
 */
public class CpMarketInfo extends BaseModel implements Serializable{

    private String rowId;

    private String marketId;  //编码

    private String marketName; //名称

    private String country;  //国家

    private String region;  //区域

    private String province;  //省份

    private String city;  //城市

    private String district;  //区县

    private String street;  //街道

    private String isCityComp;  //是否同城竞争

    private String parentId;  //上级编码

    private String customerNumber;//授权客户

    private String brandNumber;

    private String openStoreNumber;//已开店

    private String level;  //范围级别

    private String brand;  //品牌

    private String accreditStartDate;

    private String accreditEndDate;





    public String getRowId() {
        return rowId;
    }

    public void setRowId(String rowId) {
        this.rowId = rowId;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getAccreditStartDate() {
        return accreditStartDate;
    }

    public void setAccreditStartDate(String accreditStartDate) {
        this.accreditStartDate = accreditStartDate;
    }

    public String getAccreditEndDate() {
        return accreditEndDate;
    }

    public void setAccreditEndDate(String accreditEndDate) {
        this.accreditEndDate = accreditEndDate;
    }

    @ExcelField(title="编码", align=1, sort=7)
    public String getMarketId() {
        return marketId;
    }

    public void setMarketId(String marketId) {
        this.marketId = marketId;
    }
    @ExcelField(title="名称", align=1, sort=8)
    public String getMarketName() {
        return marketName;
    }

    public void setMarketName(String marketName) {
        this.marketName = marketName;
    }

    @ExcelField(title="国家", align=1, sort=9)
    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @ExcelField(title="区域", align=1, sort=10)
    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    @ExcelField(title="省份", align=1, sort=11)
    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    @ExcelField(title="城市", align=1, sort=12)
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @ExcelField(title="区县", align=1, sort=13)
    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    @ExcelField(title="街道", align=1, sort=14)
    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    @ExcelField(title="品牌", align=3, sort=15)
    public String getBrandNumber() {
        return brandNumber;
    }

    public void setBrandNumber(String brandNumber) {
        this.brandNumber = brandNumber;
    }

    @ExcelField(title="授权客户", align=3, sort=16)
    public String getCustomerNumber() {
        return customerNumber;
    }

    public void setCustomerNumber(String customerNumber) {
        this.customerNumber = customerNumber;
    }

    public String getIsCityComp() {
        return isCityComp;
    }

    public void setIsCityComp(String isCityComp) {
        this.isCityComp = isCityComp;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }
    @ExcelField(title="已开店", align=3, sort=17)
    public String getOpenStoreNumber() {
        return openStoreNumber;
    }

    public void setOpenStoreNumber(String openStoreNumber) {
        this.openStoreNumber = openStoreNumber;
    }
}
