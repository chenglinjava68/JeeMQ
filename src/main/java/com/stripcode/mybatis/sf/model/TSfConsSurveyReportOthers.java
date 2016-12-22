package com.stripcode.mybatis.sf.model;

import com.stripcode.mybatis.common.BaseModel;

import java.math.BigDecimal;

public class TSfConsSurveyReportOthers extends BaseModel {
    private String rowId;

    private String ppId;

    private String frozenStorage;

    private String iceMachine;

    private String storeAirCondition;

    private String otherEquipment;

    private BigDecimal distance;

    private BigDecimal dispersion;

    private String isOwnerConfirm;

    private String isRadiating;

    private String isFireAlarm;

    private String signFirm;

    private String signDrawing;

    private Integer signDrawingPages;

    private String elecFile;

    private String isDepartmentConfirm;

    private String signVisibilityLeft;

    private String signVisibilityRight;

    private String independentIndexSign;

    private String necessaryCondition;

    private String noNecessaryCondition;

    private String fileName;

    private String filePath;

    private static final long serialVersionUID = 1L;

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
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

    public String getFrozenStorage() {
        return frozenStorage;
    }

    public void setFrozenStorage(String frozenStorage) {
        this.frozenStorage = frozenStorage == null ? null : frozenStorage.trim();
    }

    public String getIceMachine() {
        return iceMachine;
    }

    public void setIceMachine(String iceMachine) {
        this.iceMachine = iceMachine == null ? null : iceMachine.trim();
    }

    public String getStoreAirCondition() {
        return storeAirCondition;
    }

    public void setStoreAirCondition(String storeAirCondition) {
        this.storeAirCondition = storeAirCondition == null ? null : storeAirCondition.trim();
    }

    public String getOtherEquipment() {
        return otherEquipment;
    }

    public void setOtherEquipment(String otherEquipment) {
        this.otherEquipment = otherEquipment == null ? null : otherEquipment.trim();
    }

    public BigDecimal getDistance() {
        return distance;
    }

    public void setDistance(BigDecimal distance) {
        this.distance = distance;
    }

    public BigDecimal getDispersion() {
        return dispersion;
    }

    public void setDispersion(BigDecimal dispersion) {
        this.dispersion = dispersion;
    }

    public String getIsOwnerConfirm() {
        return isOwnerConfirm;
    }

    public void setIsOwnerConfirm(String isOwnerConfirm) {
        this.isOwnerConfirm = isOwnerConfirm == null ? null : isOwnerConfirm.trim();
    }

    public String getIsRadiating() {
        return isRadiating;
    }

    public void setIsRadiating(String isRadiating) {
        this.isRadiating = isRadiating == null ? null : isRadiating.trim();
    }

    public String getIsFireAlarm() {
        return isFireAlarm;
    }

    public void setIsFireAlarm(String isFireAlarm) {
        this.isFireAlarm = isFireAlarm == null ? null : isFireAlarm.trim();
    }

    public String getSignFirm() {
        return signFirm;
    }

    public void setSignFirm(String signFirm) {
        this.signFirm = signFirm == null ? null : signFirm.trim();
    }

    public String getSignDrawing() {
        return signDrawing;
    }

    public void setSignDrawing(String signDrawing) {
        this.signDrawing = signDrawing == null ? null : signDrawing.trim();
    }

    public Integer getSignDrawingPages() {
        return signDrawingPages;
    }

    public void setSignDrawingPages(Integer signDrawingPages) {
        this.signDrawingPages = signDrawingPages;
    }

    public String getElecFile() {
        return elecFile;
    }

    public void setElecFile(String elecFile) {
        this.elecFile = elecFile == null ? null : elecFile.trim();
    }

    public String getIsDepartmentConfirm() {
        return isDepartmentConfirm;
    }

    public void setIsDepartmentConfirm(String isDepartmentConfirm) {
        this.isDepartmentConfirm = isDepartmentConfirm == null ? null : isDepartmentConfirm.trim();
    }

    public String getSignVisibilityLeft() {
        return signVisibilityLeft;
    }

    public void setSignVisibilityLeft(String signVisibilityLeft) {
        this.signVisibilityLeft = signVisibilityLeft == null ? null : signVisibilityLeft.trim();
    }

    public String getSignVisibilityRight() {
        return signVisibilityRight;
    }

    public void setSignVisibilityRight(String signVisibilityRight) {
        this.signVisibilityRight = signVisibilityRight == null ? null : signVisibilityRight.trim();
    }

    public String getIndependentIndexSign() {
        return independentIndexSign;
    }

    public void setIndependentIndexSign(String independentIndexSign) {
        this.independentIndexSign = independentIndexSign == null ? null : independentIndexSign.trim();
    }

    public String getNecessaryCondition() {
        return necessaryCondition;
    }

    public void setNecessaryCondition(String necessaryCondition) {
        this.necessaryCondition = necessaryCondition == null ? null : necessaryCondition.trim();
    }

    public String getNoNecessaryCondition() {
        return noNecessaryCondition;
    }

    public void setNoNecessaryCondition(String noNecessaryCondition) {
        this.noNecessaryCondition = noNecessaryCondition == null ? null : noNecessaryCondition.trim();
    }
}