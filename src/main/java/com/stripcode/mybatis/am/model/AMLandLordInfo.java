package com.stripcode.mybatis.am.model;

import com.stripcode.mybatis.common.BaseModel;

/**店铺业主信息表
 * Created by Metro on 2016/12/14.
 */
public class AMLandLordInfo extends BaseModel {
    private String storeId;//店铺ID
    private String property;//店铺所在物业
    private String isFromRep;//是否开发专员提供
    private String rep;//开发专员
    private String isFromBroker;//是否中介提供
    private String broker;//中介名称
    private String isFromAlliance;//是否策略联盟合作方提供
    private String alliance;//策略联盟合作方名称

    public String getStoreId() {
        return storeId;
    }

    public void setStoreId(String storeId) {
        this.storeId = storeId;
    }

    public String getProperty() {
        return property;
    }

    public void setProperty(String property) {
        this.property = property;
    }

    public String getIsFromRep() {
        return isFromRep;
    }

    public void setIsFromRep(String isFromRep) {
        this.isFromRep = isFromRep;
    }

    public String getRep() {
        return rep;
    }

    public void setRep(String rep) {
        this.rep = rep;
    }

    public String getIsFromBroker() {
        return isFromBroker;
    }

    public void setIsFromBroker(String isFromBroker) {
        this.isFromBroker = isFromBroker;
    }

    public String getBroker() {
        return broker;
    }

    public void setBroker(String broker) {
        this.broker = broker;
    }

    public String getIsFromAlliance() {
        return isFromAlliance;
    }

    public void setIsFromAlliance(String isFromAlliance) {
        this.isFromAlliance = isFromAlliance;
    }

    public String getAlliance() {
        return alliance;
    }

    public void setAlliance(String alliance) {
        this.alliance = alliance;
    }
}
