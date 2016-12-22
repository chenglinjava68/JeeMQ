package com.stripcode.mybatis.sf.model;

import com.stripcode.mybatis.common.BaseModel;

import java.io.Serializable;
import java.lang.Double;

public class TSfConsSurveyReportProperty extends BaseModel implements Serializable {
    private String rowId;

    private String ppId;

    private String propertyForm;

    private String structureType;

    private Double planArea;

    private Double planAreaF1;

    private Double planAreaF2;

    private Double storeyHighF1;

    private Double storeyHighF2;

    private Integer ugLayer;

    private Integer glayer;

    private Double buildingHight;

    private Double structureBearing;

    private Double bearingF1;

    private Double bearingF2;

    private String isBasement;

    private String location;

    private String baseReinforce;

    private String mouldReinforce;

    private String beamReinforce;

    private String floorPunch;

    private String structureRemoval;

    private String addStairs;

    private String addElevator;

    private String sandwichLayer;

    private String other;

    private String isReform;

    private String isReinforce;

    private String description;

    private Integer buildingPlan;

    private String buildingDrawing;

    private Integer elecPlan;

    private String elecDrawing;

    private String siteMeasure;

    private Integer sitePlan;

    private String siteDrawing;

    private Double widthF1;

    private Double depthF1;

    private Double widthF2;

    private Double depthF2;

    private Double beamHeightF1;

    private Double beamHeightF2;

    private Double floorslabHeightF1;

    private Double floorslabHeightF2;

    private String isBlueprintCopy;

    private String isUtilityDrawing;

    private String outerWall;

    private String interiorWall;

    private String ground;

    private String ceiling;

    private String equipmentDeal;

    private String buildingDescription;

    private String isExternalLighting;

    private String material;


    private static final long serialVersionUID = 1L;

    public Integer getGlayer() {
        return glayer;
    }

    public void setGlayer(Integer glayer) {
        this.glayer = glayer;
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

    public String getPropertyForm() {
        return propertyForm;
    }

    public void setPropertyForm(String propertyForm) {
        this.propertyForm = propertyForm == null ? null : propertyForm.trim();
    }

    public String getStructureType() {
        return structureType;
    }

    public void setStructureType(String structureType) {
        this.structureType = structureType == null ? null : structureType.trim();
    }

    public Double getPlanArea() {
        return planArea;
    }

    public void setPlanArea(Double planArea) {
        this.planArea = planArea;
    }

    public Double getPlanAreaF1() {
        return planAreaF1;
    }

    public void setPlanAreaF1(Double planAreaF1) {
        this.planAreaF1 = planAreaF1;
    }

    public Double getPlanAreaF2() {
        return planAreaF2;
    }

    public void setPlanAreaF2(Double planAreaF2) {
        this.planAreaF2 = planAreaF2;
    }

    public Double getStoreyHighF1() {
        return storeyHighF1;
    }

    public void setStoreyHighF1(Double storeyHighF1) {
        this.storeyHighF1 = storeyHighF1;
    }

    public Double getStoreyHighF2() {
        return storeyHighF2;
    }

    public void setStoreyHighF2(Double storeyHighF2) {
        this.storeyHighF2 = storeyHighF2;
    }

    public Integer getUgLayer() {
        return ugLayer;
    }

    public void setUgLayer(Integer ugLayer) {
        this.ugLayer = ugLayer;
    }

    public Double getBuildingHight() {
        return buildingHight;
    }

    public void setBuildingHight(Double buildingHight) {
        this.buildingHight = buildingHight;
    }

    public Double getStructureBearing() {
        return structureBearing;
    }

    public void setStructureBearing(Double structureBearing) {
        this.structureBearing = structureBearing;
    }

    public Double getBearingF1() {
        return bearingF1;
    }

    public void setBearingF1(Double bearingF1) {
        this.bearingF1 = bearingF1;
    }

    public Double getBearingF2() {
        return bearingF2;
    }

    public void setBearingF2(Double bearingF2) {
        this.bearingF2 = bearingF2;
    }

    public String getIsBasement() {
        return isBasement;
    }

    public void setIsBasement(String isBasement) {
        this.isBasement = isBasement == null ? null : isBasement.trim();
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location == null ? null : location.trim();
    }

    public String getBaseReinforce() {
        return baseReinforce;
    }

    public void setBaseReinforce(String baseReinforce) {
        this.baseReinforce = baseReinforce == null ? null : baseReinforce.trim();
    }

    public String getMouldReinforce() {
        return mouldReinforce;
    }

    public void setMouldReinforce(String mouldReinforce) {
        this.mouldReinforce = mouldReinforce == null ? null : mouldReinforce.trim();
    }

    public String getBeamReinforce() {
        return beamReinforce;
    }

    public void setBeamReinforce(String beamReinforce) {
        this.beamReinforce = beamReinforce == null ? null : beamReinforce.trim();
    }

    public String getFloorPunch() {
        return floorPunch;
    }

    public void setFloorPunch(String floorPunch) {
        this.floorPunch = floorPunch == null ? null : floorPunch.trim();
    }

    public String getStructureRemoval() {
        return structureRemoval;
    }

    public void setStructureRemoval(String structureRemoval) {
        this.structureRemoval = structureRemoval == null ? null : structureRemoval.trim();
    }

    public String getAddStairs() {
        return addStairs;
    }

    public void setAddStairs(String addStairs) {
        this.addStairs = addStairs == null ? null : addStairs.trim();
    }

    public String getAddElevator() {
        return addElevator;
    }

    public void setAddElevator(String addElevator) {
        this.addElevator = addElevator == null ? null : addElevator.trim();
    }

    public String getSandwichLayer() {
        return sandwichLayer;
    }

    public void setSandwichLayer(String sandwichLayer) {
        this.sandwichLayer = sandwichLayer == null ? null : sandwichLayer.trim();
    }

    public String getOther() {
        return other;
    }

    public void setOther(String other) {
        this.other = other == null ? null : other.trim();
    }

    public String getIsReform() {
        return isReform;
    }

    public void setIsReform(String isReform) {
        this.isReform = isReform == null ? null : isReform.trim();
    }

    public String getIsReinforce() {
        return isReinforce;
    }

    public void setIsReinforce(String isReinforce) {
        this.isReinforce = isReinforce == null ? null : isReinforce.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public Integer getBuildingPlan() {
        return buildingPlan;
    }

    public void setBuildingPlan(Integer buildingPlan) {
        this.buildingPlan = buildingPlan;
    }

    public String getBuildingDrawing() {
        return buildingDrawing;
    }

    public void setBuildingDrawing(String buildingDrawing) {
        this.buildingDrawing = buildingDrawing == null ? null : buildingDrawing.trim();
    }

    public Integer getElecPlan() {
        return elecPlan;
    }

    public void setElecPlan(Integer elecPlan) {
        this.elecPlan = elecPlan;
    }

    public String getElecDrawing() {
        return elecDrawing;
    }

    public void setElecDrawing(String elecDrawing) {
        this.elecDrawing = elecDrawing == null ? null : elecDrawing.trim();
    }

    public String getSiteMeasure() {
        return siteMeasure;
    }

    public void setSiteMeasure(String siteMeasure) {
        this.siteMeasure = siteMeasure == null ? null : siteMeasure.trim();
    }

    public Integer getSitePlan() {
        return sitePlan;
    }

    public void setSitePlan(Integer sitePlan) {
        this.sitePlan = sitePlan;
    }

    public String getSiteDrawing() {
        return siteDrawing;
    }

    public void setSiteDrawing(String siteDrawing) {
        this.siteDrawing = siteDrawing == null ? null : siteDrawing.trim();
    }

    public Double getWidthF1() {
        return widthF1;
    }

    public void setWidthF1(Double widthF1) {
        this.widthF1 = widthF1;
    }

    public Double getDepthF1() {
        return depthF1;
    }

    public void setDepthF1(Double depthF1) {
        this.depthF1 = depthF1;
    }

    public Double getWidthF2() {
        return widthF2;
    }

    public void setWidthF2(Double widthF2) {
        this.widthF2 = widthF2;
    }

    public Double getDepthF2() {
        return depthF2;
    }

    public void setDepthF2(Double depthF2) {
        this.depthF2 = depthF2;
    }

    public Double getBeamHeightF1() {
        return beamHeightF1;
    }

    public void setBeamHeightF1(Double beamHeightF1) {
        this.beamHeightF1 = beamHeightF1;
    }

    public Double getBeamHeightF2() {
        return beamHeightF2;
    }

    public void setBeamHeightF2(Double beamHeightF2) {
        this.beamHeightF2 = beamHeightF2;
    }

    public Double getFloorslabHeightF1() {
        return floorslabHeightF1;
    }

    public void setFloorslabHeightF1(Double floorslabHeightF1) {
        this.floorslabHeightF1 = floorslabHeightF1;
    }

    public Double getFloorslabHeightF2() {
        return floorslabHeightF2;
    }

    public void setFloorslabHeightF2(Double floorslabHeightF2) {
        this.floorslabHeightF2 = floorslabHeightF2;
    }

    public String getIsBlueprintCopy() {
        return isBlueprintCopy;
    }

    public void setIsBlueprintCopy(String isBlueprintCopy) {
        this.isBlueprintCopy = isBlueprintCopy == null ? null : isBlueprintCopy.trim();
    }

    public String getIsUtilityDrawing() {
        return isUtilityDrawing;
    }

    public void setIsUtilityDrawing(String isUtilityDrawing) {
        this.isUtilityDrawing = isUtilityDrawing == null ? null : isUtilityDrawing.trim();
    }

    public String getOuterWall() {
        return outerWall;
    }

    public void setOuterWall(String outerWall) {
        this.outerWall = outerWall == null ? null : outerWall.trim();
    }

    public String getInteriorWall() {
        return interiorWall;
    }

    public void setInteriorWall(String interiorWall) {
        this.interiorWall = interiorWall == null ? null : interiorWall.trim();
    }

    public String getGround() {
        return ground;
    }

    public void setGround(String ground) {
        this.ground = ground == null ? null : ground.trim();
    }

    public String getCeiling() {
        return ceiling;
    }

    public void setCeiling(String ceiling) {
        this.ceiling = ceiling == null ? null : ceiling.trim();
    }

    public String getEquipmentDeal() {
        return equipmentDeal;
    }

    public void setEquipmentDeal(String equipmentDeal) {
        this.equipmentDeal = equipmentDeal == null ? null : equipmentDeal.trim();
    }

    public String getBuildingDescription() {
        return buildingDescription;
    }

    public void setBuildingDescription(String buildingDescription) {
        this.buildingDescription = buildingDescription == null ? null : buildingDescription.trim();
    }

    public String getIsExternalLighting() {
        return isExternalLighting;
    }

    public void setIsExternalLighting(String isExternalLighting) {
        this.isExternalLighting = isExternalLighting == null ? null : isExternalLighting.trim();
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material == null ? null : material.trim();
    }
}