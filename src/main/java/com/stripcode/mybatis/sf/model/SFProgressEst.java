package com.stripcode.mybatis.sf.model;

import com.stripcode.mybatis.common.BaseModel;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Metro on 2016/9/27.
 */
public class SFProgressEst extends BaseModel implements Serializable{
    private String rowId;
    private String ppId;//意向店ID
    private String taskCode;//项目名称
    private String estDate;//预估日期
    private String actualDate;//实际日期
    private Integer delay;//延误天数
    private String remark;//备注
    private String macroName;
    private String type; //判断类型

    private String region;
    private String market;
    private String province;
    private String city;
    private String ppCode;
    private String cnSitename;
    private String enSitename;
    private String addressCn;
    private String addressDetail;
    private String signDate;
    private String ownerDate;
    private String consSurveyReportDate;
    private String openDate;
    private String floor;
    private String rep;

    private List<SFSigningAttachment> signingAttachmentList;

    public List<SFSigningAttachment> getSigningAttachmentList() {
        return signingAttachmentList;
    }

    public void setSigningAttachmentList(List<SFSigningAttachment> signingAttachmentList) {
        this.signingAttachmentList = signingAttachmentList;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getMarket() {
        return market;
    }

    public void setMarket(String market) {
        this.market = market;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPpCode() {
        return ppCode;
    }

    public void setPpCode(String ppCode) {
        this.ppCode = ppCode;
    }

    public String getCnSitename() {
        return cnSitename;
    }

    public void setCnSitename(String cnSitename) {
        this.cnSitename = cnSitename;
    }

    public String getEnSitename() {
        return enSitename;
    }

    public void setEnSitename(String enSitename) {
        this.enSitename = enSitename;
    }

    public String getAddressCn() {
        return addressCn;
    }

    public void setAddressCn(String addressCn) {
        this.addressCn = addressCn;
    }

    public String getAddressDetail() {
        return addressDetail;
    }

    public void setAddressDetail(String addressDetail) {
        this.addressDetail = addressDetail;
    }

    public String getSignDate() {
        return signDate;
    }

    public void setSignDate(String signDate) {
        this.signDate = signDate;
    }

    public String getOwnerDate() {
        return ownerDate;
    }

    public void setOwnerDate(String ownerDate) {
        this.ownerDate = ownerDate;
    }

    public String getConsSurveyReportDate() {
        return consSurveyReportDate;
    }

    public void setConsSurveyReportDate(String consSurveyReportDate) {
        this.consSurveyReportDate = consSurveyReportDate;
    }

    public String getOpenDate() {
        return openDate;
    }

    public void setOpenDate(String openDate) {
        this.openDate = openDate;
    }

    public String getFloor() {
        return floor;
    }

    public void setFloor(String floor) {
        this.floor = floor;
    }

    public String getRep() {
        return rep;
    }

    public void setRep(String rep) {
        this.rep = rep;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getMacroName() {
        return macroName;
    }

    public void setMacroName(String macroName) {
        this.macroName = macroName;
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

    public Integer getDelay() {
        return delay;
    }

    public void setDelay(Integer delay) {
        this.delay = delay;
    }

    public String getActualDate() {
        return actualDate;
    }

    public void setActualDate(String actualDate) {
        this.actualDate = actualDate;
    }

    public String getEstDate() {
        return estDate;
    }

    public void setEstDate(String estDate) {
        this.estDate = estDate;
    }

    public String getTaskCode() {
        return taskCode;
    }

    public void setTaskCode(String taskCode) {
        this.taskCode = taskCode;
    }

    public String getPpId() {
        return ppId;
    }

    public void setPpId(String ppId) {
        this.ppId = ppId;
    }
}
