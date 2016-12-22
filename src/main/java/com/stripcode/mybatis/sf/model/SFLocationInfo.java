package com.stripcode.mybatis.sf.model;

import com.stripcode.core.annotation.Divide;
import com.stripcode.core.annotation.Multiply;
import com.stripcode.mybatis.common.BaseModel;

import java.util.List;

/**
 * @author Metro
 */
public class SFLocationInfo extends BaseModel {
    private String rowId;
    private String ppId;
    private String locationType;
    private String taName;
    private String city;
    private String taType;
    private String taPriority;
    private String taMaturity;
    private String incomeLevel;
    private String taDesirability;
    private String communityName;
    private String otherBrand;
    private Integer storeNum500;
    private Integer storeNum1000;
    private Integer storeNum3000;
    private Integer householes;
    private Integer population;
    private Double taAvgIncome;
    private Double cityAvgIncome;
    private Double taArea;
    private Double popDensity;
    private Integer householesNum;
    private Integer housing500;
    private String housingMaturity;
    private Double years;
    private String hypermarket;
    private Double passengerFlowYear;
    private Double salesYear;
    private String hypermarketPlan;
    private Double hypermarketArea;
    private String businessType;
    private String isSignboard;
    private Double signboardLen;
    private Double signboardHeight;
    private String overallVisibility;
    private String isOtherAd;
    private String isPoloSign;
    private Integer poloSignNum;
    private String shopfrontEffictivity;
    private String isDirectionalSign;
    private Integer directionalSignNum;
    private Double distanceAntLine;
    private Double roadWidth;
    private Double distanceCrossroads;
    private String isSteps;
    private String isIsolationBelt;
    private String isOcclusion;
    private String occlusion;
    private String isRoadReforming;
    private String isRoadOverhaul;
    private String isHousingConcentrated;
    private String isNearHousing;
    private Double occupancyRate;
    private String housingLivingStandard;
    private String isHypermarketStore;
    private String businessAnalysis;
    private String advantageInferiority;
    private Double surfaceLen;
    private String remark;
    private String orientation;

    private List<SFHypermarketFloor> hypermarketFloorList;
    private List<SFPipeinePhotoAttachment> photoAttachmentList;

    public List<SFHypermarketFloor> getHypermarketFloorList() {
        return hypermarketFloorList;
    }

    public void setHypermarketFloorList(List<SFHypermarketFloor> hypermarketFloorList) {
        this.hypermarketFloorList = hypermarketFloorList;
    }

    public List<SFPipeinePhotoAttachment> getPhotoAttachmentList() {
        return photoAttachmentList;
    }

    public void setPhotoAttachmentList(List<SFPipeinePhotoAttachment> photoAttachmentList) {
        this.photoAttachmentList = photoAttachmentList;
    }


    public String getOrientation() {
        return orientation;
    }

    public void setOrientation(String orientation) {
        this.orientation = orientation;
    }

    public Double getSurfaceLen() {
        return surfaceLen;
    }

    public void setSurfaceLen(Double surfaceLen) {
        this.surfaceLen = surfaceLen;
    }

    public Double getSignboardHeight() {
        return signboardHeight;
    }

    public void setSignboardHeight(Double signboardHeight) {
        this.signboardHeight = signboardHeight;
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

    public String getLocationType() {
        return locationType;
    }

    public void setLocationType(String locationType) {
        this.locationType = locationType;
    }

    public String getTaName() {
        return taName;
    }

    public void setTaName(String taName) {
        this.taName = taName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getTaType() {
        return taType;
    }

    public void setTaType(String taType) {
        this.taType = taType;
    }

    public String getTaPriority() {
        return taPriority;
    }

    public void setTaPriority(String taPriority) {
        this.taPriority = taPriority;
    }

    public String getTaMaturity() {
        return taMaturity;
    }

    public void setTaMaturity(String taMaturity) {
        this.taMaturity = taMaturity;
    }

    public String getIncomeLevel() {
        return incomeLevel;
    }

    public void setIncomeLevel(String incomeLevel) {
        this.incomeLevel = incomeLevel;
    }

    public String getTaDesirability() {
        return taDesirability;
    }

    public void setTaDesirability(String taDesirability) {
        this.taDesirability = taDesirability;
    }

    public String getCommunityName() {
        return communityName;
    }

    public void setCommunityName(String communityName) {
        this.communityName = communityName;
    }

    public String getOtherBrand() {
        return otherBrand;
    }

    public void setOtherBrand(String otherBrand) {
        this.otherBrand = otherBrand;
    }

    public Integer getStoreNum500() {
        return storeNum500;
    }

    public void setStoreNum500(Integer storeNum500) {
        this.storeNum500 = storeNum500;
    }

    public Integer getStoreNum1000() {
        return storeNum1000;
    }

    public void setStoreNum1000(Integer storeNum1000) {
        this.storeNum1000 = storeNum1000;
    }

    public Integer getStoreNum3000() {
        return storeNum3000;
    }

    public void setStoreNum3000(Integer storeNum3000) {
        this.storeNum3000 = storeNum3000;
    }

    public Integer getHouseholes() {
        return householes;
    }

    public void setHouseholes(Integer householes) {
        this.householes = householes;
    }

    public Integer getPopulation() {
        return population;
    }

    public void setPopulation(Integer population) {
        this.population = population;
    }

    public Double getTaAvgIncome() {
        return taAvgIncome;
    }

    public void setTaAvgIncome(Double taAvgIncome) {
        this.taAvgIncome = taAvgIncome;
    }

    public Double getCityAvgIncome() {
        return cityAvgIncome;
    }

    public void setCityAvgIncome(Double cityAvgIncome) {
        this.cityAvgIncome = cityAvgIncome;
    }

    public Double getTaArea() {
        return taArea;
    }

    public void setTaArea(Double taArea) {
        this.taArea = taArea;
    }

    public Double getPopDensity() {
        return popDensity;
    }

    public void setPopDensity(Double popDensity) {
        this.popDensity = popDensity;
    }

    public Integer getHouseholesNum() {
        return householesNum;
    }

    public void setHouseholesNum(Integer householesNum) {
        this.householesNum = householesNum;
    }

    public Integer getHousing500() {
        return housing500;
    }

    public void setHousing500(Integer housing500) {
        this.housing500 = housing500;
    }

    public String getHousingMaturity() {
        return housingMaturity;
    }

    public void setHousingMaturity(String housingMaturity) {
        this.housingMaturity = housingMaturity;
    }

    public Double getYears() {
        return years;
    }

    public void setYears(Double years) {
        this.years = years;
    }

    public String getHypermarket() {
        return hypermarket;
    }

    public void setHypermarket(String hypermarket) {
        this.hypermarket = hypermarket;
    }
    @Multiply(10000)
    public Double getPassengerFlowYear() {
        return passengerFlowYear;
    }
    @Divide(10000)
    public void setPassengerFlowYear(Double passengerFlowYear) {
        this.passengerFlowYear = passengerFlowYear;
    }
    @Multiply(10000)
    public Double getSalesYear() {
        return salesYear;
    }
    @Divide(10000)
    public void setSalesYear(Double salesYear) {
        this.salesYear = salesYear;
    }

    public String getHypermarketPlan() {
        return hypermarketPlan;
    }

    public void setHypermarketPlan(String hypermarketPlan) {
        this.hypermarketPlan = hypermarketPlan;
    }

    public Double getHypermarketArea() {
        return hypermarketArea;
    }

    public void setHypermarketArea(Double hypermarketArea) {
        this.hypermarketArea = hypermarketArea;
    }

    public String getBusinessType() {
        return businessType;
    }

    public void setBusinessType(String businessType) {
        this.businessType = businessType;
    }

    public String getIsSignboard() {
        return isSignboard;
    }

    public void setIsSignboard(String isSignboard) {
        this.isSignboard = isSignboard;
    }

    public Double getSignboardLen() {
        return signboardLen;
    }

    public void setSignboardLen(Double signboardLen) {
        this.signboardLen = signboardLen;
    }

    public String getOverallVisibility() {
        return overallVisibility;
    }

    public void setOverallVisibility(String overallVisibility) {
        this.overallVisibility = overallVisibility;
    }

    public String getIsOtherAd() {
        return isOtherAd;
    }

    public void setIsOtherAd(String isOtherAd) {
        this.isOtherAd = isOtherAd;
    }

    public String getIsPoloSign() {
        return isPoloSign;
    }

    public void setIsPoloSign(String isPoloSign) {
        this.isPoloSign = isPoloSign;
    }

    public Integer getPoloSignNum() {
        return poloSignNum;
    }

    public void setPoloSignNum(Integer poloSignNum) {
        this.poloSignNum = poloSignNum;
    }

    public String getShopfrontEffictivity() {
        return shopfrontEffictivity;
    }

    public void setShopfrontEffictivity(String shopfrontEffictivity) {
        this.shopfrontEffictivity = shopfrontEffictivity;
    }

    public String getIsDirectionalSign() {
        return isDirectionalSign;
    }

    public void setIsDirectionalSign(String isDirectionalSign) {
        this.isDirectionalSign = isDirectionalSign;
    }

    public Integer getDirectionalSignNum() {
        return directionalSignNum;
    }

    public void setDirectionalSignNum(Integer directionalSignNum) {
        this.directionalSignNum = directionalSignNum;
    }

    public Double getDistanceAntLine() {
        return distanceAntLine;
    }

    public void setDistanceAntLine(Double distanceAntLine) {
        this.distanceAntLine = distanceAntLine;
    }

    public Double getRoadWidth() {
        return roadWidth;
    }

    public void setRoadWidth(Double roadWidth) {
        this.roadWidth = roadWidth;
    }

    public Double getDistanceCrossroads() {
        return distanceCrossroads;
    }

    public void setDistanceCrossroads(Double distanceCrossroads) {
        this.distanceCrossroads = distanceCrossroads;
    }

    public String getIsSteps() {
        return isSteps;
    }

    public void setIsSteps(String isSteps) {
        this.isSteps = isSteps;
    }

    public String getIsIsolationBelt() {
        return isIsolationBelt;
    }

    public void setIsIsolationBelt(String isIsolationBelt) {
        this.isIsolationBelt = isIsolationBelt;
    }

    public String getIsOcclusion() {
        return isOcclusion;
    }

    public void setIsOcclusion(String isOcclusion) {
        this.isOcclusion = isOcclusion;
    }

    public String getOcclusion() {
        return occlusion;
    }

    public void setOcclusion(String occlusion) {
        this.occlusion = occlusion;
    }

    public String getIsRoadReforming() {
        return isRoadReforming;
    }

    public void setIsRoadReforming(String isRoadReforming) {
        this.isRoadReforming = isRoadReforming;
    }

    public String getIsRoadOverhaul() {
        return isRoadOverhaul;
    }

    public void setIsRoadOverhaul(String isRoadOverhaul) {
        this.isRoadOverhaul = isRoadOverhaul;
    }

    public String getIsHousingConcentrated() {
        return isHousingConcentrated;
    }

    public void setIsHousingConcentrated(String isHousingConcentrated) {
        this.isHousingConcentrated = isHousingConcentrated;
    }

    public String getIsNearHousing() {
        return isNearHousing;
    }

    public void setIsNearHousing(String isNearHousing) {
        this.isNearHousing = isNearHousing;
    }

    public Double getOccupancyRate() {
        return occupancyRate;
    }

    public void setOccupancyRate(Double occupancyRate) {
        this.occupancyRate = occupancyRate;
    }

    public String getHousingLivingStandard() {
        return housingLivingStandard;
    }

    public void setHousingLivingStandard(String housingLivingStandard) {
        this.housingLivingStandard = housingLivingStandard;
    }

    public String getIsHypermarketStore() {
        return isHypermarketStore;
    }

    public void setIsHypermarketStore(String isHypermarketStore) {
        this.isHypermarketStore = isHypermarketStore;
    }

    public String getBusinessAnalysis() {
        return businessAnalysis;
    }

    public void setBusinessAnalysis(String businessAnalysis) {
        this.businessAnalysis = businessAnalysis;
    }

    public String getAdvantageInferiority() {
        return advantageInferiority;
    }

    public void setAdvantageInferiority(String advantageInferiority) {
        this.advantageInferiority = advantageInferiority;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
