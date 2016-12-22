package com.stripcode.mybatis.sf.model;

import com.stripcode.core.annotation.Divide;
import com.stripcode.core.annotation.Multiply;
import com.stripcode.mybatis.common.BaseModel;

import java.util.List;

/**
 * @author Metro
 */
public class SFTradezoneInfo extends BaseModel {
    private String rowId;
    private String ppId;
    private String city;
    private String taId;
    private String taName;
    private String taType;
    private Double taSize;
    private String incomeLevel;
    private String taPriority;
    private String taDesirability;
    private String taMaturity;
    private String otherBrand;
    private String communityName;
    private Integer storeNum500;
    private Integer storeNum1000;
    private Integer storeNum3000;
    private String storeType;
    private String reRating;
    private String isNearAntLine;
    private String overallVisibility;
    private String overallAccessibility;
    private String keyWord1;
    private String keyWord2;
    private String keyWord3;
    private String investmentType;
    private String isStreet;
    private String natZone;
    private String isAlliance;
    private String allianceCode;
    private String isBroker;
    private String broker;
    private Double homePop3500;
    private Double homePop500;
    private String homeIncome;
    private Double homeSalesPct;
    private Double workPop3500;
    private Double workPop500;
    private String workProfile;
    private Double workSalesPct;
    private Double studentNo1000;
    private String studentProfile;
    private Double schoolSalesPct;
    private String shoppingLevel;
    private Integer shoppingmallNo;
    private Double totalCommercialSize;
    private Double streetLength;
    private String buildingNature;
    private String buildingOpenDate;
    private Double buildingCommercialSize;
    private String buildingRetailStrength;
    private String buildingAnchor1Name;
    private Double buildingAnchor1Size;
    private String buildingAnchor2Name;
    private Double buildingAnchor2Size;
    private Double shopSalesPct;
    private String trafficHubType;
    private String thStoreLocation;
    private String storeFloor;
    private Double throughputYear;
    private String thCmpLocation;
    private Double thSalesPct;
    private String leisureNature;
    private Double leisureSalesPct;
    private String otherFactor;
    private Double otherSalesPct;
    private String homeRemark;
    private String workRemark;
    private String shopRemark;
    private String schoolRemark;
    private String thRemark;
    private String leisureRemark;
    private String otherRemark;
    private Integer subwayLines;
    private Double distFromClosestSubway;
    private String visibilityFromSubway;
    private Integer busStopNo100;
    private Integer busLineNo100;
    private Double distFromClosestBusStop;
    private Integer competitorNo;
    private String competitorNameTop3;
    private Integer mbStoreNo;
    private Integer mbOpenInY1;
    private Double mbAvgSalesYear;
    private Double nearestMbAvgSalesYear;
    private String attachId;
    private Double distinceFromAntLine;

    private String fileName;
    private String docName;
    private String filePath;

    public Double getDistinceFromAntLine() {
        return distinceFromAntLine;
    }

    public void setDistinceFromAntLine(Double distinceFromAntLine) {
        this.distinceFromAntLine = distinceFromAntLine;
    }

    public String getAttachId() {
        return attachId;
    }

    public void setAttachId(String attachId) {
        this.attachId = attachId;
    }

    private List<SFTradezoneStoreInfo> tradezoneStoreInfoList;

    private List<SFTradezoneCiuInfo> tradezoneCiuInfoList;

    public List<SFTradezoneStoreInfo> getTradezoneStoreInfoList() {
        return tradezoneStoreInfoList;
    }

    public void setTradezoneStoreInfoList(List<SFTradezoneStoreInfo> tradezoneStoreInfoList) {
        this.tradezoneStoreInfoList = tradezoneStoreInfoList;
    }

    public List<SFTradezoneCiuInfo> getTradezoneCiuInfoList() {
        return tradezoneCiuInfoList;
    }

    public void setTradezoneCiuInfoList(List<SFTradezoneCiuInfo> tradezoneCiuInfoList) {
        this.tradezoneCiuInfoList = tradezoneCiuInfoList;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getDocName() {
        return docName;
    }

    public void setDocName(String docName) {
        this.docName = docName;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
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

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getTaId() {
        return taId;
    }

    public void setTaId(String taId) {
        this.taId = taId;
    }

    public String getTaName() {
        return taName;
    }

    public void setTaName(String taName) {
        this.taName = taName;
    }

    public String getTaType() {
        return taType;
    }

    public void setTaType(String taType) {
        this.taType = taType;
    }

    public Double getTaSize() {
        return taSize;
    }

    public void setTaSize(Double taSize) {
        this.taSize = taSize;
    }

    public String getIncomeLevel() {
        return incomeLevel;
    }

    public void setIncomeLevel(String incomeLevel) {
        this.incomeLevel = incomeLevel;
    }

    public String getTaPriority() {
        return taPriority;
    }

    public void setTaPriority(String taPriority) {
        this.taPriority = taPriority;
    }

    public String getTaDesirability() {
        return taDesirability;
    }

    public void setTaDesirability(String taDesirability) {
        this.taDesirability = taDesirability;
    }

    public String getTaMaturity() {
        return taMaturity;
    }

    public void setTaMaturity(String taMaturity) {
        this.taMaturity = taMaturity;
    }

    public String getOtherBrand() {
        return otherBrand;
    }

    public void setOtherBrand(String otherBrand) {
        this.otherBrand = otherBrand;
    }

    public String getCommunityName() {
        return communityName;
    }

    public void setCommunityName(String communityName) {
        this.communityName = communityName;
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

    public String getStoreType() {
        return storeType;
    }

    public void setStoreType(String storeType) {
        this.storeType = storeType;
    }

    public String getReRating() {
        return reRating;
    }

    public void setReRating(String reRating) {
        this.reRating = reRating;
    }

    public String getIsNearAntLine() {
        return isNearAntLine;
    }

    public void setIsNearAntLine(String isNearAntLine) {
        this.isNearAntLine = isNearAntLine;
    }

    public String getOverallVisibility() {
        return overallVisibility;
    }

    public void setOverallVisibility(String overallVisibility) {
        this.overallVisibility = overallVisibility;
    }

    public String getOverallAccessibility() {
        return overallAccessibility;
    }

    public void setOverallAccessibility(String overallAccessibility) {
        this.overallAccessibility = overallAccessibility;
    }

    public String getKeyWord1() {
        return keyWord1;
    }

    public void setKeyWord1(String keyWord1) {
        this.keyWord1 = keyWord1;
    }

    public String getKeyWord2() {
        return keyWord2;
    }

    public void setKeyWord2(String keyWord2) {
        this.keyWord2 = keyWord2;
    }

    public String getKeyWord3() {
        return keyWord3;
    }

    public void setKeyWord3(String keyWord3) {
        this.keyWord3 = keyWord3;
    }

    public String getInvestmentType() {
        return investmentType;
    }

    public void setInvestmentType(String investmentType) {
        this.investmentType = investmentType;
    }

    public String getIsStreet() {
        return isStreet;
    }

    public void setIsStreet(String isStreet) {
        this.isStreet = isStreet;
    }

    public String getNatZone() {
        return natZone;
    }

    public void setNatZone(String natZone) {
        this.natZone = natZone;
    }

    public String getIsAlliance() {
        return isAlliance;
    }

    public void setIsAlliance(String isAlliance) {
        this.isAlliance = isAlliance;
    }

    public String getAllianceCode() {
        return allianceCode;
    }

    public void setAllianceCode(String allianceCode) {
        this.allianceCode = allianceCode;
    }

    public String getIsBroker() {
        return isBroker;
    }

    public void setIsBroker(String isBroker) {
        this.isBroker = isBroker;
    }

    public String getBroker() {
        return broker;
    }

    public void setBroker(String broker) {
        this.broker = broker;
    }

    public Double getHomePop3500() {
        return homePop3500;
    }

    public void setHomePop3500(Double homePop3500) {
        this.homePop3500 = homePop3500;
    }

    public Double getHomePop500() {
        return homePop500;
    }

    public void setHomePop500(Double homePop500) {
        this.homePop500 = homePop500;
    }

    public String getHomeIncome() {
        return homeIncome;
    }

    public void setHomeIncome(String homeIncome) {
        this.homeIncome = homeIncome;
    }

    public Double getHomeSalesPct() {
        return homeSalesPct;
    }

    public void setHomeSalesPct(Double homeSalesPct) {
        this.homeSalesPct = homeSalesPct;
    }

    public Double getWorkPop3500() {
        return workPop3500;
    }

    public void setWorkPop3500(Double workPop3500) {
        this.workPop3500 = workPop3500;
    }

    public Double getWorkPop500() {
        return workPop500;
    }

    public void setWorkPop500(Double workPop500) {
        this.workPop500 = workPop500;
    }

    public String getWorkProfile() {
        return workProfile;
    }

    public void setWorkProfile(String workProfile) {
        this.workProfile = workProfile;
    }

    public Double getWorkSalesPct() {
        return workSalesPct;
    }

    public void setWorkSalesPct(Double workSalesPct) {
        this.workSalesPct = workSalesPct;
    }

    public Double getStudentNo1000() {
        return studentNo1000;
    }

    public void setStudentNo1000(Double studentNo1000) {
        this.studentNo1000 = studentNo1000;
    }

    public String getStudentProfile() {
        return studentProfile;
    }

    public void setStudentProfile(String studentProfile) {
        this.studentProfile = studentProfile;
    }

    public Double getSchoolSalesPct() {
        return schoolSalesPct;
    }

    public void setSchoolSalesPct(Double schoolSalesPct) {
        this.schoolSalesPct = schoolSalesPct;
    }

    public String getShoppingLevel() {
        return shoppingLevel;
    }

    public void setShoppingLevel(String shoppingLevel) {
        this.shoppingLevel = shoppingLevel;
    }

    public Integer getShoppingmallNo() {
        return shoppingmallNo;
    }

    public void setShoppingmallNo(Integer shoppingmallNo) {
        this.shoppingmallNo = shoppingmallNo;
    }

    public Double getTotalCommercialSize() {
        return totalCommercialSize;
    }

    public void setTotalCommercialSize(Double totalCommercialSize) {
        this.totalCommercialSize = totalCommercialSize;
    }

    public Double getStreetLength() {
        return streetLength;
    }

    public void setStreetLength(Double streetLength) {
        this.streetLength = streetLength;
    }

    public String getBuildingNature() {
        return buildingNature;
    }

    public void setBuildingNature(String buildingNature) {
        this.buildingNature = buildingNature;
    }

    public String getBuildingOpenDate() {
        return buildingOpenDate;
    }

    public void setBuildingOpenDate(String buildingOpenDate) {
        this.buildingOpenDate = buildingOpenDate;
    }

    public Double getBuildingCommercialSize() {
        return buildingCommercialSize;
    }

    public void setBuildingCommercialSize(Double buildingCommercialSize) {
        this.buildingCommercialSize = buildingCommercialSize;
    }

    public String getBuildingRetailStrength() {
        return buildingRetailStrength;
    }

    public void setBuildingRetailStrength(String buildingRetailStrength) {
        this.buildingRetailStrength = buildingRetailStrength;
    }

    public String getBuildingAnchor1Name() {
        return buildingAnchor1Name;
    }

    public void setBuildingAnchor1Name(String buildingAnchor1Name) {
        this.buildingAnchor1Name = buildingAnchor1Name;
    }

    public Double getBuildingAnchor1Size() {
        return buildingAnchor1Size;
    }

    public void setBuildingAnchor1Size(Double buildingAnchor1Size) {
        this.buildingAnchor1Size = buildingAnchor1Size;
    }

    public String getBuildingAnchor2Name() {
        return buildingAnchor2Name;
    }

    public void setBuildingAnchor2Name(String buildingAnchor2Name) {
        this.buildingAnchor2Name = buildingAnchor2Name;
    }

    public Double getBuildingAnchor2Size() {
        return buildingAnchor2Size;
    }

    public void setBuildingAnchor2Size(Double buildingAnchor2Size) {
        this.buildingAnchor2Size = buildingAnchor2Size;
    }

    public Double getShopSalesPct() {
        return shopSalesPct;
    }

    public void setShopSalesPct(Double shopSalesPct) {
        this.shopSalesPct = shopSalesPct;
    }

    public String getTrafficHubType() {
        return trafficHubType;
    }

    public void setTrafficHubType(String trafficHubType) {
        this.trafficHubType = trafficHubType;
    }

    public String getThStoreLocation() {
        return thStoreLocation;
    }

    public void setThStoreLocation(String thStoreLocation) {
        this.thStoreLocation = thStoreLocation;
    }

    public String getStoreFloor() {
        return storeFloor;
    }

    public void setStoreFloor(String storeFloor) {
        this.storeFloor = storeFloor;
    }
    @Multiply(10000)
    public Double getThroughputYear() {
        return throughputYear;
    }
    @Divide(10000)
    public void setThroughputYear(Double throughputYear) {
        this.throughputYear = throughputYear;
    }

    public String getThCmpLocation() {
        return thCmpLocation;
    }

    public void setThCmpLocation(String thCmpLocation) {
        this.thCmpLocation = thCmpLocation;
    }

    public Double getThSalesPct() {
        return thSalesPct;
    }

    public void setThSalesPct(Double thSalesPct) {
        this.thSalesPct = thSalesPct;
    }

    public String getLeisureNature() {
        return leisureNature;
    }

    public void setLeisureNature(String leisureNature) {
        this.leisureNature = leisureNature;
    }

    public Double getLeisureSalesPct() {
        return leisureSalesPct;
    }

    public void setLeisureSalesPct(Double leisureSalesPct) {
        this.leisureSalesPct = leisureSalesPct;
    }

    public String getOtherFactor() {
        return otherFactor;
    }

    public void setOtherFactor(String otherFactor) {
        this.otherFactor = otherFactor;
    }

    public Double getOtherSalesPct() {
        return otherSalesPct;
    }

    public void setOtherSalesPct(Double otherSalesPct) {
        this.otherSalesPct = otherSalesPct;
    }

    public String getHomeRemark() {
        return homeRemark;
    }

    public void setHomeRemark(String homeRemark) {
        this.homeRemark = homeRemark;
    }

    public String getWorkRemark() {
        return workRemark;
    }

    public void setWorkRemark(String workRemark) {
        this.workRemark = workRemark;
    }

    public String getShopRemark() {
        return shopRemark;
    }

    public void setShopRemark(String shopRemark) {
        this.shopRemark = shopRemark;
    }

    public String getSchoolRemark() {
        return schoolRemark;
    }

    public void setSchoolRemark(String schoolRemark) {
        this.schoolRemark = schoolRemark;
    }

    public String getThRemark() {
        return thRemark;
    }

    public void setThRemark(String thRemark) {
        this.thRemark = thRemark;
    }

    public String getLeisureRemark() {
        return leisureRemark;
    }

    public void setLeisureRemark(String leisureRemark) {
        this.leisureRemark = leisureRemark;
    }

    public String getOtherRemark() {
        return otherRemark;
    }

    public void setOtherRemark(String otherRemark) {
        this.otherRemark = otherRemark;
    }

    public Integer getSubwayLines() {
        return subwayLines;
    }

    public void setSubwayLines(Integer subwayLines) {
        this.subwayLines = subwayLines;
    }

    public Double getDistFromClosestSubway() {
        return distFromClosestSubway;
    }

    public void setDistFromClosestSubway(Double distFromClosestSubway) {
        this.distFromClosestSubway = distFromClosestSubway;
    }

    public String getVisibilityFromSubway() {
        return visibilityFromSubway;
    }

    public void setVisibilityFromSubway(String visibilityFromSubway) {
        this.visibilityFromSubway = visibilityFromSubway;
    }

    public Integer getBusStopNo100() {
        return busStopNo100;
    }

    public void setBusStopNo100(Integer busStopNo100) {
        this.busStopNo100 = busStopNo100;
    }

    public Integer getBusLineNo100() {
        return busLineNo100;
    }

    public void setBusLineNo100(Integer busLineNo100) {
        this.busLineNo100 = busLineNo100;
    }

    public Double getDistFromClosestBusStop() {
        return distFromClosestBusStop;
    }

    public void setDistFromClosestBusStop(Double distFromClosestBusStop) {
        this.distFromClosestBusStop = distFromClosestBusStop;
    }

    public Integer getCompetitorNo() {
        return competitorNo;
    }

    public void setCompetitorNo(Integer competitorNo) {
        this.competitorNo = competitorNo;
    }

    public String getCompetitorNameTop3() {
        return competitorNameTop3;
    }

    public void setCompetitorNameTop3(String competitorNameTop3) {
        this.competitorNameTop3 = competitorNameTop3;
    }

    public Integer getMbStoreNo() {
        return mbStoreNo;
    }

    public void setMbStoreNo(Integer mbStoreNo) {
        this.mbStoreNo = mbStoreNo;
    }

    public Integer getMbOpenInY1() {
        return mbOpenInY1;
    }

    public void setMbOpenInY1(Integer mbOpenInY1) {
        this.mbOpenInY1 = mbOpenInY1;
    }
    @Multiply(10000)
    public Double getMbAvgSalesYear() {
        return mbAvgSalesYear;
    }
    @Divide(10000)
    public void setMbAvgSalesYear(Double mbAvgSalesYear) {
        this.mbAvgSalesYear = mbAvgSalesYear;
    }
    @Multiply(10000)
    public Double getNearestMbAvgSalesYear() {
        return nearestMbAvgSalesYear;
    }
    @Divide(10000)
    public void setNearestMbAvgSalesYear(Double nearestMbAvgSalesYear) {
        this.nearestMbAvgSalesYear = nearestMbAvgSalesYear;
    }
}
