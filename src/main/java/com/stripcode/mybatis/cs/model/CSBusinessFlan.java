package com.stripcode.mybatis.cs.model;

import com.stripcode.core.annotation.Divide;
import com.stripcode.core.annotation.Multiply;
import com.stripcode.mybatis.common.BaseModel;

import java.io.Serializable;

/**
 * @author Metro
 */
public class CSBusinessFlan extends BaseModel implements Serializable {
    private String rowId;
    private String optimauthId;
    private String planClass;
    private String ppId;
    private String storeCode;
    private String channelType;
    private String openDate;
    private String storeAddres;
    private Double operatingArea;
    private String cnSiteName;
    private Double salesY1;
    private Double salesY1Incrate;
    private Double salesY2;
    private Double salesY2Incrate;
    private Double salesY3;
    private Double salesY3Incrate;
    private String channelName;

    public String getChannelName() {
        return channelName;
    }

    public void setChannelName(String channelName) {
        this.channelName = channelName;
    }

    public String getChannelType() {
        return channelType;
    }

    public void setChannelType(String channelType) {
        this.channelType = channelType;
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

    public String getPlanClass() {
        return planClass;
    }

    public void setPlanClass(String planClass) {
        this.planClass = planClass;
    }

    public String getPpId() {
        return ppId;
    }

    public void setPpId(String ppId) {
        this.ppId = ppId;
    }

    public String getStoreCode() {
        return storeCode;
    }

    public void setStoreCode(String storeCode) {
        this.storeCode = storeCode;
    }

    public String getOpenDate() {
        return openDate;
    }

    public void setOpenDate(String openDate) {
        this.openDate = openDate;
    }

    public String getStoreAddres() {
        return storeAddres;
    }

    public void setStoreAddres(String storeAddres) {
        this.storeAddres = storeAddres;
    }

    public Double getOperatingArea() {
        return operatingArea;
    }

    public void setOperatingArea(Double operatingArea) {
        this.operatingArea = operatingArea;
    }

    public String getCnSiteName() {
        return cnSiteName;
    }

    public void setCnSiteName(String cnSiteName) {
        this.cnSiteName = cnSiteName;
    }
    @Multiply(10000)
    public Double getSalesY1() {
        return salesY1;
    }
    @Divide(10000)
    public void setSalesY1(Double salesY1) {
        this.salesY1 = salesY1;
    }

    public Double getSalesY1Incrate() {
        return salesY1Incrate;
    }

    public void setSalesY1Incrate(Double salesY1Incrate) {
        this.salesY1Incrate = salesY1Incrate;
    }
    @Multiply(10000)
    public Double getSalesY2() {
        return salesY2;
    }
    @Divide(10000)
    public void setSalesY2(Double salesY2) {
        this.salesY2 = salesY2;
    }

    public Double getSalesY2Incrate() {
        return salesY2Incrate;
    }

    public void setSalesY2Incrate(Double salesY2Incrate) {
        this.salesY2Incrate = salesY2Incrate;
    }
    @Multiply(10000)
    public Double getSalesY3() {
        return salesY3;
    }
    @Divide(10000)
    public void setSalesY3(Double salesY3) {
        this.salesY3 = salesY3;
    }

    public Double getSalesY3Incrate() {
        return salesY3Incrate;
    }
    public void setSalesY3Incrate(Double salesY3Incrate) {
        this.salesY3Incrate = salesY3Incrate;
    }
}
