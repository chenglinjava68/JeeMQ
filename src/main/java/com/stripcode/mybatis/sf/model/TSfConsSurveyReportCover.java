package com.stripcode.mybatis.sf.model;

import com.stripcode.mybatis.common.BaseModel;

import java.math.BigDecimal;

public class TSfConsSurveyReportCover extends BaseModel {
    private String rowId;

    private String ppId;

    private String isSurvey;

    private String director;

    private String surveyDate;

    private String isCompetitor;

    private BigDecimal salesMonth;

    private String isAcceptance;

    private String storeImage;

    private String isHighrisk;

    private String highriskDetail;

    private String isEnvironment;

    private String environmentDetail;

    private String isToliet;

    private String incomeMode;

    private BigDecimal usedArea;

    private BigDecimal usedAreaFloor1;

    private BigDecimal usedAreaFloor2;

    private BigDecimal backArea;

    private BigDecimal backAreaFloor1;

    private BigDecimal backAreaFloor2;

    private BigDecimal frontArea;

    private BigDecimal frontAreaFloor1;

    private BigDecimal frontAreaFloor2;

    private String remark;

    private TSfConsSurveyReportHydropower hydropower;

    private TSfConsSurveyReportOthers others;

    private TSfConsSurveyReportProperty property;

    private TSfConsSurveyReportAeration aeration;

    private static final long serialVersionUID = 1L;


    public TSfConsSurveyReportHydropower getHydropower() {
        return hydropower;
    }

    public void setHydropower(TSfConsSurveyReportHydropower hydropower) {
        this.hydropower = hydropower;
    }

    public TSfConsSurveyReportOthers getOthers() {
        return others;
    }

    public void setOthers(TSfConsSurveyReportOthers others) {
        this.others = others;
    }

    public TSfConsSurveyReportProperty getProperty() {
        return property;
    }

    public void setProperty(TSfConsSurveyReportProperty property) {
        this.property = property;
    }

    public TSfConsSurveyReportAeration getAeration() {
        return aeration;
    }

    public void setAeration(TSfConsSurveyReportAeration aeration) {
        this.aeration = aeration;
    }

    public String getRowId() {
        return rowId;
    }

    public void setRowId(String rowId) {
        this.rowId = rowId == null ? null : rowId.trim();
    }

    public String getPpId() {
        return ppId;
    }

    public void setPpId(String ppId) {
        this.ppId = ppId == null ? null : ppId.trim();
    }

    public String getIsSurvey() {
        return isSurvey;
    }

    public void setIsSurvey(String isSurvey) {
        this.isSurvey = isSurvey == null ? null : isSurvey.trim();
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director == null ? null : director.trim();
    }

    public String getSurveyDate() {
        return surveyDate;
    }

    public void setSurveyDate(String surveyDate) {
        this.surveyDate = surveyDate == null ? null : surveyDate.trim();
    }

    public String getIsCompetitor() {
        return isCompetitor;
    }

    public void setIsCompetitor(String isCompetitor) {
        this.isCompetitor = isCompetitor == null ? null : isCompetitor.trim();
    }

    public BigDecimal getSalesMonth() {
        return salesMonth;
    }

    public void setSalesMonth(BigDecimal salesMonth) {
        this.salesMonth = salesMonth;
    }

    public String getIsAcceptance() {
        return isAcceptance;
    }

    public void setIsAcceptance(String isAcceptance) {
        this.isAcceptance = isAcceptance == null ? null : isAcceptance.trim();
    }

    public String getStoreImage() {
        return storeImage;
    }

    public void setStoreImage(String storeImage) {
        this.storeImage = storeImage == null ? null : storeImage.trim();
    }

    public String getIsHighrisk() {
        return isHighrisk;
    }

    public void setIsHighrisk(String isHighrisk) {
        this.isHighrisk = isHighrisk == null ? null : isHighrisk.trim();
    }

    public String getHighriskDetail() {
        return highriskDetail;
    }

    public void setHighriskDetail(String highriskDetail) {
        this.highriskDetail = highriskDetail == null ? null : highriskDetail.trim();
    }

    public String getIsEnvironment() {
        return isEnvironment;
    }

    public void setIsEnvironment(String isEnvironment) {
        this.isEnvironment = isEnvironment == null ? null : isEnvironment.trim();
    }

    public String getEnvironmentDetail() {
        return environmentDetail;
    }

    public void setEnvironmentDetail(String environmentDetail) {
        this.environmentDetail = environmentDetail == null ? null : environmentDetail.trim();
    }

    public String getIsToliet() {
        return isToliet;
    }

    public void setIsToliet(String isToliet) {
        this.isToliet = isToliet == null ? null : isToliet.trim();
    }

    public String getIncomeMode() {
        return incomeMode;
    }

    public void setIncomeMode(String incomeMode) {
        this.incomeMode = incomeMode == null ? null : incomeMode.trim();
    }

    public BigDecimal getUsedArea() {
        return usedArea;
    }

    public void setUsedArea(BigDecimal usedArea) {
        this.usedArea = usedArea;
    }

    public BigDecimal getUsedAreaFloor1() {
        return usedAreaFloor1;
    }

    public void setUsedAreaFloor1(BigDecimal usedAreaFloor1) {
        this.usedAreaFloor1 = usedAreaFloor1;
    }

    public BigDecimal getUsedAreaFloor2() {
        return usedAreaFloor2;
    }

    public void setUsedAreaFloor2(BigDecimal usedAreaFloor2) {
        this.usedAreaFloor2 = usedAreaFloor2;
    }

    public BigDecimal getBackArea() {
        return backArea;
    }

    public void setBackArea(BigDecimal backArea) {
        this.backArea = backArea;
    }

    public BigDecimal getBackAreaFloor1() {
        return backAreaFloor1;
    }

    public void setBackAreaFloor1(BigDecimal backAreaFloor1) {
        this.backAreaFloor1 = backAreaFloor1;
    }

    public BigDecimal getBackAreaFloor2() {
        return backAreaFloor2;
    }

    public void setBackAreaFloor2(BigDecimal backAreaFloor2) {
        this.backAreaFloor2 = backAreaFloor2;
    }

    public BigDecimal getFrontArea() {
        return frontArea;
    }

    public void setFrontArea(BigDecimal frontArea) {
        this.frontArea = frontArea;
    }

    public BigDecimal getFrontAreaFloor1() {
        return frontAreaFloor1;
    }

    public void setFrontAreaFloor1(BigDecimal frontAreaFloor1) {
        this.frontAreaFloor1 = frontAreaFloor1;
    }

    public BigDecimal getFrontAreaFloor2() {
        return frontAreaFloor2;
    }

    public void setFrontAreaFloor2(BigDecimal frontAreaFloor2) {
        this.frontAreaFloor2 = frontAreaFloor2;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }


}