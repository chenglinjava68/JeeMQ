package com.stripcode.mybatis.sf.model;

import com.stripcode.mybatis.common.BaseModel;

import java.util.List;

/**
 * @author Metro
 */
public class SFStoreHandover extends BaseModel{
    private String rowId;
    private String ppId;
    private String contacter;
    private String position;
    private String landline;
    private String phone;
    private String address;
    private String isRecommend;
    private String recdInstruction;
    private String planDate;
    private String actualDate;
    private String isSignInstalled;
    private String signInstruction;
    private String isCleanCost;
    private String cleanCostInstruction;
    private String isPayProCost;
    private String proCostInstruction;
    private String isWeCost;
    private String weCostInstruction;
    private String isSharingSite;
    private String sharingSiteInstruction;
    private String isStandardEscape;
    private String standardEscapeInstruction;
    private String isOther;
    private String otherInstruction;

    private List<SFLandlordinfo> landlordinfoList;

    private List<SFStoreHandoverAttachment> handoverAttachmentList;

    private List<SFImportantEvents> importantEventsList;

    public List<SFLandlordinfo> getLandlordinfoList() {
        return landlordinfoList;
    }

    public void setLandlordinfoList(List<SFLandlordinfo> landlordinfoList) {
        this.landlordinfoList = landlordinfoList;
    }

    public List<SFStoreHandoverAttachment> getHandoverAttachmentList() {
        return handoverAttachmentList;
    }

    public void setHandoverAttachmentList(List<SFStoreHandoverAttachment> handoverAttachmentList) {
        this.handoverAttachmentList = handoverAttachmentList;
    }

    public List<SFImportantEvents> getImportantEventsList() {
        return importantEventsList;
    }

    public void setImportantEventsList(List<SFImportantEvents> importantEventsList) {
        this.importantEventsList = importantEventsList;
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

    public String getContacter() {
        return contacter;
    }

    public void setContacter(String contacter) {
        this.contacter = contacter;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getLandline() {
        return landline;
    }

    public void setLandline(String landline) {
        this.landline = landline;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getIsRecommend() {
        return isRecommend;
    }

    public void setIsRecommend(String isRecommend) {
        this.isRecommend = isRecommend;
    }

    public String getRecdInstruction() {
        return recdInstruction;
    }

    public void setRecdInstruction(String recdInstruction) {
        this.recdInstruction = recdInstruction;
    }

    public String getPlanDate() {
        return planDate;
    }

    public void setPlanDate(String planDate) {
        this.planDate = planDate;
    }

    public String getActualDate() {
        return actualDate;
    }

    public void setActualDate(String actualDate) {
        this.actualDate = actualDate;
    }

    public String getIsSignInstalled() {
        return isSignInstalled;
    }

    public void setIsSignInstalled(String isSignInstalled) {
        this.isSignInstalled = isSignInstalled;
    }

    public String getSignInstruction() {
        return signInstruction;
    }

    public void setSignInstruction(String signInstruction) {
        this.signInstruction = signInstruction;
    }

    public String getIsCleanCost() {
        return isCleanCost;
    }

    public void setIsCleanCost(String isCleanCost) {
        this.isCleanCost = isCleanCost;
    }

    public String getCleanCostInstruction() {
        return cleanCostInstruction;
    }

    public void setCleanCostInstruction(String cleanCostInstruction) {
        this.cleanCostInstruction = cleanCostInstruction;
    }

    public String getIsPayProCost() {
        return isPayProCost;
    }

    public void setIsPayProCost(String isPayProCost) {
        this.isPayProCost = isPayProCost;
    }

    public String getProCostInstruction() {
        return proCostInstruction;
    }

    public void setProCostInstruction(String proCostInstruction) {
        this.proCostInstruction = proCostInstruction;
    }

    public String getIsWeCost() {
        return isWeCost;
    }

    public void setIsWeCost(String isWeCost) {
        this.isWeCost = isWeCost;
    }

    public String getWeCostInstruction() {
        return weCostInstruction;
    }

    public void setWeCostInstruction(String weCostInstruction) {
        this.weCostInstruction = weCostInstruction;
    }

    public String getIsSharingSite() {
        return isSharingSite;
    }

    public void setIsSharingSite(String isSharingSite) {
        this.isSharingSite = isSharingSite;
    }

    public String getSharingSiteInstruction() {
        return sharingSiteInstruction;
    }

    public void setSharingSiteInstruction(String sharingSiteInstruction) {
        this.sharingSiteInstruction = sharingSiteInstruction;
    }

    public String getIsStandardEscape() {
        return isStandardEscape;
    }

    public void setIsStandardEscape(String isStandardEscape) {
        this.isStandardEscape = isStandardEscape;
    }

    public String getStandardEscapeInstruction() {
        return standardEscapeInstruction;
    }

    public void setStandardEscapeInstruction(String standardEscapeInstruction) {
        this.standardEscapeInstruction = standardEscapeInstruction;
    }

    public String getIsOther() {
        return isOther;
    }

    public void setIsOther(String isOther) {
        this.isOther = isOther;
    }

    public String getOtherInstruction() {
        return otherInstruction;
    }

    public void setOtherInstruction(String otherInstruction) {
        this.otherInstruction = otherInstruction;
    }
}
