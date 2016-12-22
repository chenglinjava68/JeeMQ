package com.stripcode.mybatis.sf.model;

import com.stripcode.mybatis.common.BaseModel;

import java.util.List;

/**
 * @author Metro
 */
public class SFEstateSource extends BaseModel {
    private String rowId;
    private String ppId;                //意向店ID
    private String isFromRep;           //是否开发专员提供
    private String rep;                  //开发专员
    private String isFromBroker;        //是否中介提供
    private String broker;              //中介名称
    private String isFromAlliance;                      //是否策略联盟合作方提供
    private String alliance;            //策略联盟合作方提供

    private List<SFLandlordinfo> landlordinfoList;

    public List<SFLandlordinfo> getLandlordinfoList() {
        return landlordinfoList;
    }

    public void setLandlordinfoList(List<SFLandlordinfo> landlordinfoList) {
        this.landlordinfoList = landlordinfoList;
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
