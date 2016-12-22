package com.stripcode.mybatis.sf.model;

import com.stripcode.mybatis.common.BaseModel;

import java.math.BigDecimal;

public class TSfConsSurveyReportHydropower extends BaseModel{
    private String rowId;

    private String ppId;

    private String isPowerSupply;

    private BigDecimal powerCapacity;

    private BigDecimal currentCapacity;

    private String roomStoreBack;

    private BigDecimal cableLength;

    private String isWaterSupply;

    private String waterQuantity;

    private String waterPressure;

    private String isFitHealth;

    private BigDecimal waterPipeLen;

    private String waterPipeDiameter;

    private String isDrainage;

    private String isLowerPipe;

    private String prePosition;

    private BigDecimal tolietArea;

    private String isImproveLocation;

    private String tolietMgr;

    private String tolietOpenHours;

    private String startTime;

    private String endTime;


    private static final long serialVersionUID = 1L;

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
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

    public String getIsPowerSupply() {
        return isPowerSupply;
    }

    public void setIsPowerSupply(String isPowerSupply) {
        this.isPowerSupply = isPowerSupply == null ? null : isPowerSupply.trim();
    }

    public BigDecimal getPowerCapacity() {
        return powerCapacity;
    }

    public void setPowerCapacity(BigDecimal powerCapacity) {
        this.powerCapacity = powerCapacity;
    }

    public BigDecimal getCurrentCapacity() {
        return currentCapacity;
    }

    public void setCurrentCapacity(BigDecimal currentCapacity) {
        this.currentCapacity = currentCapacity;
    }

    public String getRoomStoreBack() {
        return roomStoreBack;
    }

    public void setRoomStoreBack(String roomStoreBack) {
        this.roomStoreBack = roomStoreBack == null ? null : roomStoreBack.trim();
    }

    public BigDecimal getCableLength() {
        return cableLength;
    }

    public void setCableLength(BigDecimal cableLength) {
        this.cableLength = cableLength;
    }

    public String getIsWaterSupply() {
        return isWaterSupply;
    }

    public void setIsWaterSupply(String isWaterSupply) {
        this.isWaterSupply = isWaterSupply == null ? null : isWaterSupply.trim();
    }

    public String getWaterQuantity() {
        return waterQuantity;
    }

    public void setWaterQuantity(String waterQuantity) {
        this.waterQuantity = waterQuantity == null ? null : waterQuantity.trim();
    }

    public String getWaterPressure() {
        return waterPressure;
    }

    public void setWaterPressure(String waterPressure) {
        this.waterPressure = waterPressure == null ? null : waterPressure.trim();
    }

    public String getIsFitHealth() {
        return isFitHealth;
    }

    public void setIsFitHealth(String isFitHealth) {
        this.isFitHealth = isFitHealth == null ? null : isFitHealth.trim();
    }

    public BigDecimal getWaterPipeLen() {
        return waterPipeLen;
    }

    public void setWaterPipeLen(BigDecimal waterPipeLen) {
        this.waterPipeLen = waterPipeLen;
    }

    public String getWaterPipeDiameter() {
        return waterPipeDiameter;
    }

    public void setWaterPipeDiameter(String waterPipeDiameter) {
        this.waterPipeDiameter = waterPipeDiameter == null ? null : waterPipeDiameter.trim();
    }

    public String getIsDrainage() {
        return isDrainage;
    }

    public void setIsDrainage(String isDrainage) {
        this.isDrainage = isDrainage == null ? null : isDrainage.trim();
    }

    public String getIsLowerPipe() {
        return isLowerPipe;
    }

    public void setIsLowerPipe(String isLowerPipe) {
        this.isLowerPipe = isLowerPipe == null ? null : isLowerPipe.trim();
    }

    public String getPrePosition() {
        return prePosition;
    }

    public void setPrePosition(String prePosition) {
        this.prePosition = prePosition == null ? null : prePosition.trim();
    }

    public BigDecimal getTolietArea() {
        return tolietArea;
    }

    public void setTolietArea(BigDecimal tolietArea) {
        this.tolietArea = tolietArea;
    }

    public String getIsImproveLocation() {
        return isImproveLocation;
    }

    public void setIsImproveLocation(String isImproveLocation) {
        this.isImproveLocation = isImproveLocation == null ? null : isImproveLocation.trim();
    }

    public String getTolietMgr() {
        return tolietMgr;
    }

    public void setTolietMgr(String tolietMgr) {
        this.tolietMgr = tolietMgr == null ? null : tolietMgr.trim();
    }

    public String getTolietOpenHours() {
        return tolietOpenHours;
    }

    public void setTolietOpenHours(String tolietOpenHours) {
        this.tolietOpenHours = tolietOpenHours == null ? null : tolietOpenHours.trim();
    }
}