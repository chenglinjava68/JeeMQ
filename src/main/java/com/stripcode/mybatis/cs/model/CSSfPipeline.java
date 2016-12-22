package com.stripcode.mybatis.cs.model;


import com.stripcode.core.util.excelUtil.annotation.ExcelField;
import com.stripcode.mybatis.common.BaseModel;
import com.stripcode.mybatis.cp.model.CpMarketInfo;
import com.stripcode.mybatis.sf.model.SFEstInvestmentRoi;
import com.stripcode.mybatis.sf.model.SFPolicySupportAgree;
import com.stripcode.mybatis.sf.model.SFPolicySupportDetail;
import com.stripcode.mybatis.sf.model.SFTrafficcount;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Metro on 2016/8/30.
 * 意向店实体
 */
public class CSSfPipeline extends BaseModel implements Serializable{
    private String customerPropertyName;
    private String brandName;
    private String ppId; //意向店Id
    private String ppCode;  //新址编码
    private String cnSiteName; //意向店中文名称
    private String enSiteName; //意向店英文名称
    private String delFlag;            //删除标记
    private String storeCode;   //意向店发展成实体店的编码
    private String operationMode; //经营方式
    private String brand;//品牌
    private String coopMode; //合作模式
    private String customerId; //客户id
    private String customerProperty; //客户性质
    private String province;//省份
    private String city; //城市
    private String district;//区县
    private String street;//街道
    private String addressCn; //中文地址
    private String addressDetail;//详细地址描述
    private String brandOperate;//营业品牌
    private String channelType;//渠道类型
    private String channelTypeName;//渠道类型名
    private String storeImage;//店铺形象
    private String ppStatus;//新址状态
    private String progress;//开发进度
    private String storeProperty; //店铺性质
    private String fieldId;
    private String region;
    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFieldId() {
        return fieldId;
    }

    public void setFieldId(String fieldId) {
        this.fieldId = fieldId;
    }

    private String fileName;
    public String getStorePropertyName() {
        return storePropertyName;
    }

    public void setStorePropertyName(String storePropertyName) {
        this.storePropertyName = storePropertyName;
    }

    public String getChannelTypeName() {
        return channelTypeName;
    }

    public void setChannelTypeName(String channelTypeName) {
        this.channelTypeName = channelTypeName;
    }

    private String storePropertyName; //店铺性质

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }
    public String getCustomerPropertyName() {
        return customerPropertyName;
    }

    public void setCustomerPropertyName(String customerPropertyName) {
        this.customerPropertyName = customerPropertyName;
    }
    @ExcelField(title="品牌", align=1, sort=6)
    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    private List<String> operationModes;

    public List<String> getOperationModes() {
        return operationModes;
    }

    public void setOperationModes(List<String> operationModes) {
        this.operationModes = operationModes;
    }

    private List<String> storeImages;

    public List<String> getStoreImages() {
        return storeImages;
    }

    public void setStoreImages(List<String> storeImages) {
        this.storeImages = storeImages;
    }

    private String isBroker;//是否中介
    private String isStrategy;//是否战略店铺
    private String developer;//开发人员
    private String broker;//中介名称
    private String remark;//备注
    private String marketId;//市场ID
    private String marketName;//市场名称
    private String erpCode;//erp市场选择
    private String mapGrid;//经纬度

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    private String cityName;
    public String getSearchName() {
        return searchName;
    }

    public void setSearchName(String searchName) {
        this.searchName = searchName;
    }

    private String searchName;
    private CSCustomerInfo csCustomerInfo;
    private SFPolicySupportAgree sfPolicySupportAgree;
    private List<CpMarketInfo> marketInfoList;
    private List<SFPolicySupportDetail> supportDetailList;
    private Double area;//总面积
    private Double rentArea; //合同建筑面积
    private Double operatingArea;//合同营业面积
    private Double siteArea;//合同使用面积
    private Double sidePropsHigh;//边厅道具限高
    private Double midPropHigh;//中岛道具限高;
    private Double backDepotArea;//后备空间面积
    private Double endSales;//保底销售
    private String landLoad;//签约方
    private String rentPayType;//租金结算方式
    private String rentType;//租金类型
    private String freeStartDate;//装修免租起始日期
    private String freeEndDate;//装修免租结束日期
    private String berthNo;//铺位号
    private Double roomRate;//得房率
    private Double renovationPropertyFee;//装修期物业费
    private String operationFreeStartDate;//营运免租开始日
    private String operationFreeEndDate;//营运免租结束日
    private String deliveryConditions;//工程交付条件
    private Double leaseBond;//押金
    private String rentalPropertyFee;//租金及物业管理费描述
    private String otherFee;//其他费用说明
    private String signingMode;
    private Double rentMth;//
    private Double propertyFeeMth;
    private String deliveryDate;
    private String defaultClausePenalty;
    private String specialTermsConditions;
    private String manager;//店铺经理
    private String managerPhone;//店铺经理电话
    private String currentNode;//当前所在任务节点

    private String postCode;//邮编

    private String styleSex;//款式性别
    private String taName;//商圈名称
    private String taType;//商圈类型
    private Double taSize;//商圈大小
    private String taPriority;//商圈优先级
    private String taDesirability;//商圈理想型
    private String taMaturity;//商圈成熟度

    private SFTrafficcount sfTrafficcount; //人流量对象
    private String investmentId;//投资测算id
    private String sales;//投资测算首年销售额
    private SFEstInvestmentRoi sfEstInvestmentRoi;//投资回报测算信息对象

    private String doorWidth; // 门宽
    private String floor; // 楼层数
    private String storeyHigh; // 层高
    private String corporation;
    private String erpName;
    private String rentStartDate; //租赁起始日
    private String rentEndDate;//租赁结束日
    private String rentalYear;
    private Double rental;//年租金
    private Double points;//扣点
    private String rentMode;//物业性质
    private String relation;//承租房和客户的关系
    private String estDate; //预计开业时间
    private Double roadWidth; //街道宽度
    private String isIsolationBelt; //是否有隔离带
    private String isSteps; //是否有台阶
    private String isOcclusion; //是否有遮挡
    private String orientation;//店铺朝向

    private String actualDate;//实际签约日期
    private String operationModeCode;
    private String brandCode;
    private String pipelineSatus;
    private String newStoreCode;//新店铺id
    private Double otherArea;//后备面积

    public Double getBackDepotArea() {
        return backDepotArea;
    }

    public void setBackDepotArea(Double backDepotArea) {
        this.backDepotArea = backDepotArea;
    }
    private String rentModeHH;//合伙人物业性质
    private String rentTypeHH;//合伙人租金类型
    private Double rentPerSquare;//合伙人月租金
    private Double rentFirstYear;//合伙人第一年租金
    private Double rentIncRate;//合伙人租金递增比例
    private Double rentContractTerm;//合同期租金情况
    private Double deductionPointFirstYear;//第一年扣点
    private Double deductionPointContractTerm;//合同期扣点情况
    private Double propertyFeePerSquare;//月物业管理费
    private Double propertyFeeYear;//年物业管理费
    private String rentStartDateHH;//租赁开始时间
    private String rentEndDateHH;//租赁结束时间
    private String estDateHH;//合伙人预计开业时间


    public String getEstDateHH() {
        return estDateHH;
    }

    public void setEstDateHH(String estDateHH) {
        this.estDateHH = estDateHH;
    }

    public String getRentModeHH() {
        return rentModeHH;
    }

    public void setRentModeHH(String rentModeHH) {
        this.rentModeHH = rentModeHH;
    }

    public String getRentTypeHH() {
        return rentTypeHH;
    }

    public void setRentTypeHH(String rentTypeHH) {
        this.rentTypeHH = rentTypeHH;
    }

    public Double getRentPerSquare() {
        return rentPerSquare;
    }

    public void setRentPerSquare(Double rentPerSquare) {
        this.rentPerSquare = rentPerSquare;
    }

    public Double getRentFirstYear() {
        return rentFirstYear;
    }

    public void setRentFirstYear(Double rentFirstYear) {
        this.rentFirstYear = rentFirstYear;
    }

    public Double getRentIncRate() {
        return rentIncRate;
    }

    public void setRentIncRate(Double rentIncRate) {
        this.rentIncRate = rentIncRate;
    }

    public Double getRentContractTerm() {
        return rentContractTerm;
    }

    public void setRentContractTerm(Double rentContractTerm) {
        this.rentContractTerm = rentContractTerm;
    }

    public Double getDeductionPointFirstYear() {
        return deductionPointFirstYear;
    }

    public void setDeductionPointFirstYear(Double deductionPointFirstYear) {
        this.deductionPointFirstYear = deductionPointFirstYear;
    }

    public Double getDeductionPointContractTerm() {
        return deductionPointContractTerm;
    }

    public void setDeductionPointContractTerm(Double deductionPointContractTerm) {
        this.deductionPointContractTerm = deductionPointContractTerm;
    }

    public Double getPropertyFeePerSquare() {
        return propertyFeePerSquare;
    }

    public void setPropertyFeePerSquare(Double propertyFeePerSquare) {
        this.propertyFeePerSquare = propertyFeePerSquare;
    }

    public Double getPropertyFeeYear() {
        return propertyFeeYear;
    }

    public void setPropertyFeeYear(Double propertyFeeYear) {
        this.propertyFeeYear = propertyFeeYear;
    }

    public String getRentStartDateHH() {
        return rentStartDateHH;
    }

    public void setRentStartDateHH(String rentStartDateHH) {
        this.rentStartDateHH = rentStartDateHH;
    }

    public String getRentEndDateHH() {
        return rentEndDateHH;
    }

    public void setRentEndDateHH(String rentEndDateHH) {
        this.rentEndDateHH = rentEndDateHH;
    }
    public SFEstInvestmentRoi getSfEstInvestmentRoi() {
        return sfEstInvestmentRoi;
    }

    public void setSfEstInvestmentRoi(SFEstInvestmentRoi sfEstInvestmentRoi) {
        this.sfEstInvestmentRoi = sfEstInvestmentRoi;
    }

    public String getPipelineSatus() {
        return pipelineSatus;
    }

    public void setPipelineSatus(String pipelineSatus) {
        this.pipelineSatus = pipelineSatus;
    }

    public Double getOtherArea() {
        return otherArea;
    }

    public void setOtherArea(Double otherArea) {
        this.otherArea = otherArea;
    }

    public String getNewStoreCode() {
        return newStoreCode;
    }

    public void setNewStoreCode(String newStoreCode) {
        this.newStoreCode = newStoreCode;
    }

    public String getMapGrid() {
        return mapGrid;
    }

    public Double getEndSales() {
        return endSales;
    }

    public void setEndSales(Double endSales) {
        this.endSales = endSales;
    }

    public String getSales() {
        return sales;
    }

    public void setSales(String sales) {
        this.sales = sales;
    }


    public void setMapGrid(String mapGrid) {
        this.mapGrid = mapGrid;
    }


    public String getSigningMode() {
        return signingMode;
    }

    public void setSigningMode(String signingMode) {
        this.signingMode = signingMode;
    }

    public Double getRentMth() {
        return rentMth;
    }

    public void setRentMth(Double rentMth) {
        this.rentMth = rentMth;
    }

    public Double getPropertyFeeMth() {
        return propertyFeeMth;
    }

    public void setPropertyFeeMth(Double propertyFeeMth) {
        this.propertyFeeMth = propertyFeeMth;
    }

    public String getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(String deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public String getDefaultClausePenalty() {
        return defaultClausePenalty;
    }

    public void setDefaultClausePenalty(String defaultClausePenalty) {
        this.defaultClausePenalty = defaultClausePenalty;
    }

    public String getSpecialTermsConditions() {
        return specialTermsConditions;
    }

    public void setSpecialTermsConditions(String specialTermsConditions) {
        this.specialTermsConditions = specialTermsConditions;
    }

    public String getRentType() {
        return rentType;
    }

    public void setRentType(String rentType) {
        this.rentType = rentType;
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

    public String getOperationModeCode() {
        return operationModeCode;
    }

    public void setOperationModeCode(String operationModeCode) {
        this.operationModeCode = operationModeCode;
    }

    public String getBrandCode() {
        return brandCode;
    }

    public void setBrandCode(String brandCode) {
        this.brandCode = brandCode;
    }
    @ExcelField(title="状态", align=2, sort=1)
    public String getCurrentNode() {
        return currentNode;
    }

    public void setCurrentNode(String currentNode) {
        this.currentNode = currentNode;
    }

    public String getDeveloper() {
        return developer;
    }

    public void setDeveloper(String developer) {
        this.developer = developer;
    }

    public String getStyleSex() {
        return styleSex;
    }

    public void setStyleSex(String styleSex) {
        this.styleSex = styleSex;
    }

    public String getManager() {
        return manager;
    }

    public void setManager(String manager) {
        this.manager = manager;
    }

    public String getManagerPhone() {
        return managerPhone;
    }

    public void setManagerPhone(String managerPhone) {
        this.managerPhone = managerPhone;
    }

    public String getRentalPropertyFee() {
        return rentalPropertyFee;
    }

    public void setRentalPropertyFee(String rentalPropertyFee) {
        this.rentalPropertyFee = rentalPropertyFee;
    }

    public String getOtherFee() {
        return otherFee;
    }

    public void setOtherFee(String otherFee) {
        this.otherFee = otherFee;
    }

    public String getBerthNo() {
        return berthNo;
    }

    public void setBerthNo(String berthNo) {
        this.berthNo = berthNo;
    }

    public Double getRoomRate() {
        return roomRate;
    }

    public void setRoomRate(Double roomRate) {
        this.roomRate = roomRate;
    }

    public Double getRenovationPropertyFee() {
        return renovationPropertyFee;
    }

    public void setRenovationPropertyFee(Double renovationPropertyFee) {
        this.renovationPropertyFee = renovationPropertyFee;
    }

    public String getOperationFreeStartDate() {
        return operationFreeStartDate;
    }

    public void setOperationFreeStartDate(String operationFreeStartDate) {
        this.operationFreeStartDate = operationFreeStartDate;
    }

    public String getOperationFreeEndDate() {
        return operationFreeEndDate;
    }

    public void setOperationFreeEndDate(String operationFreeEndDate) {
        this.operationFreeEndDate = operationFreeEndDate;
    }

    public String getDeliveryConditions() {
        return deliveryConditions;
    }

    public void setDeliveryConditions(String deliveryConditions) {
        this.deliveryConditions = deliveryConditions;
    }

    public Double getLeaseBond() {
        return leaseBond;
    }

    public void setLeaseBond(Double leaseBond) {
        this.leaseBond = leaseBond;
    }

    public String getInvestmentId() {
        return investmentId;
    }

    public void setInvestmentId(String investmentId) {
        this.investmentId = investmentId;
    }

    public SFTrafficcount getSfTrafficcount() {
        return sfTrafficcount;
    }

    public void setSfTrafficcount(SFTrafficcount sfTrafficcount) {
        this.sfTrafficcount = sfTrafficcount;
    }

    public String getTaName() {
        return taName;
    }

    public void setTaName(String taName) {
        this.taName = taName;
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    public String getFreeStartDate() {
        return freeStartDate;
    }

    public void setFreeStartDate(String freeStartDate) {
        this.freeStartDate = freeStartDate;
    }

    public String getFreeEndDate() {
        return freeEndDate;
    }

    public void setFreeEndDate(String freeEndDate) {
        this.freeEndDate = freeEndDate;
    }

    public Double getArea() {
        return area;
    }

    public void setArea(Double area) {
        this.area = area;
    }

    public Double getRentArea() {
        return rentArea;
    }

    public void setRentArea(Double rentArea) {
        this.rentArea = rentArea;
    }

    public Double getOperatingArea() {
        return operatingArea;
    }

    public void setOperatingArea(Double operatingArea) {
        this.operatingArea = operatingArea;
    }

    public Double getSiteArea() {
        return siteArea;
    }

    public void setSiteArea(Double siteArea) {
        this.siteArea = siteArea;
    }

    public Double getSidePropsHigh() {
        return sidePropsHigh;
    }

    public void setSidePropsHigh(Double sidePropsHigh) {
        this.sidePropsHigh = sidePropsHigh;
    }

    public Double getMidPropHigh() {
        return midPropHigh;
    }

    public void setMidPropHigh(Double midPropHigh) {
        this.midPropHigh = midPropHigh;
    }

    public String getLandLoad() {
        return landLoad;
    }

    public void setLandLoad(String landLoad) {
        this.landLoad = landLoad;
    }

    public String getRentPayType() {
        return rentPayType;
    }

    public void setRentPayType(String rentPayType) {
        this.rentPayType = rentPayType;
    }

    public String getActualDate() {
        return actualDate;
    }

    public void setActualDate(String actualDate) {
        this.actualDate = actualDate;
    }

    public String getRentMode() {
        return rentMode;
    }

    public void setRentMode(String rentMode) {
        this.rentMode = rentMode;
    }

    public String getRelation() {
        return relation;
    }

    public void setRelation(String relation) {
        this.relation = relation;
    }

    public String getOrientation() {
        return orientation;
    }

    public void setOrientation(String orientation) {
        this.orientation = orientation;
    }

    public Double getRoadWidth() {
        return roadWidth;
    }

    public void setRoadWidth(Double roadWidth) {
        this.roadWidth = roadWidth;
    }

    public String getIsIsolationBelt() {
        return isIsolationBelt;
    }

    public void setIsIsolationBelt(String isIsolationBelt) {
        this.isIsolationBelt = isIsolationBelt;
    }

    public String getIsSteps() {
        return isSteps;
    }

    public void setIsSteps(String isSteps) {
        this.isSteps = isSteps;
    }

    public String getIsOcclusion() {
        return isOcclusion;
    }

    public void setIsOcclusion(String isOcclusion) {
        this.isOcclusion = isOcclusion;
    }

    public String getRentStartDate() {
        return rentStartDate;
    }

    public void setRentStartDate(String rentStartDate) {
        this.rentStartDate = rentStartDate;
    }

    public String getRentEndDate() {
        return rentEndDate;
    }

    public void setRentEndDate(String rentEndDate) {
        this.rentEndDate = rentEndDate;
    }

    public String getRentalYear() {
        return rentalYear;
    }

    public void setRentalYear(String rentalYear) {
        this.rentalYear = rentalYear;
    }

    public Double getRental() {
        return rental;
    }

    public void setRental(Double rental) {
        this.rental = rental;
    }

    public Double getPoints() {
        return points;
    }

    public void setPoints(Double points) {
        this.points = points;
    }

    public String getEstDate() {
        return estDate;
    }

    public void setEstDate(String estDate) {
        this.estDate = estDate;
    }

    public SFPolicySupportAgree getSfPolicySupportAgree() {
        return sfPolicySupportAgree;
    }

    public void setSfPolicySupportAgree(SFPolicySupportAgree sfPolicySupportAgree) {
        this.sfPolicySupportAgree = sfPolicySupportAgree;
    }

    public String getFloor() {
        return floor;
    }

    public void setFloor(String floor) {
        this.floor = floor;
    }

    public String getStoreyHigh() {
        return storeyHigh;
    }

    public void setStoreyHigh(String storeyHigh) {
        this.storeyHigh = storeyHigh;
    }

    public String getPpStatus() {
        return ppStatus;
    }

    public void setPpStatus(String ppStatus) {
        this.ppStatus = ppStatus;
    }
    @ExcelField(title="市场名称", align=1, sort=9)
    public String getErpName() {
        return erpName;
    }

    public void setErpName(String erpName) {
        this.erpName = erpName;
    }

    public String getCorporation() {
        return corporation;
    }

    public void setCorporation(String corporation) {
        this.corporation = corporation;
    }

    public String getCoopMode() {
        return coopMode;
    }

    public void setCoopMode(String coopMode) {
        this.coopMode = coopMode;
    }

    public CSCustomerInfo getCsCustomerInfo() {
        return csCustomerInfo;
    }

    public void setCsCustomerInfo(CSCustomerInfo csCustomerInfo) {
        this.csCustomerInfo = csCustomerInfo;
    }

    public List<CpMarketInfo> getMarketInfoList() {
        return marketInfoList;
    }

    public void setMarketInfoList(List<CpMarketInfo> marketInfoList) {
        this.marketInfoList = marketInfoList;
    }

    public List<SFPolicySupportDetail> getSupportDetailList() {
        return supportDetailList;
    }

    public void setSupportDetailList(List<SFPolicySupportDetail> supportDetailList) {
        this.supportDetailList = supportDetailList;
    }


    public String getDoorWidth() {
        return doorWidth;
    }

    public void setDoorWidth(String doorWidth) {
        this.doorWidth = doorWidth;
    }

    public String getAddressDetail() {
        return addressDetail;
    }

    public void setAddressDetail(String addressDetail) {
        this.addressDetail = addressDetail;
    }

    public String getErpCode() {
        return erpCode;
    }

    public void setErpCode(String erpCode) {
        this.erpCode = erpCode;
    }



    public String getMarketName() {
        return marketName;
    }

    public void setMarketName(String marketName) {
        this.marketName = marketName;
    }

    public String getMarketId() {
        return marketId;
    }

    public void setMarketId(String marketId) {
        this.marketId = marketId;
    }

    public String getPpId() {
        return ppId;
    }

    public void setPpId(String ppId) {
        this.ppId = ppId;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }


    public String getEnSiteName() {
        return enSiteName;
    }

    public void setEnSiteName(String enSiteName) {
        this.enSiteName = enSiteName;
    }

    public String getStoreCode() {
        return storeCode;
    }

    public void setStoreCode(String storeCode) {
        this.storeCode = storeCode;
    }
    @ExcelField(title="经营方式", align=1, sort=3)
    public String getOperationMode() {
        return operationMode;
    }

    public void setOperationMode(String operationMode) {
        this.operationMode = operationMode;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getCustomerProperty() {
        return customerProperty;
    }

    public void setCustomerProperty(String customerProperty) {
        this.customerProperty = customerProperty;
    }
    @ExcelField(title="省份", align=1, sort=7)
    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }
    @ExcelField(title="城市", align=1, sort=8)
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getAddressCn() {
        return addressCn;
    }

    public void setAddressCn(String addressCn) {
        this.addressCn = addressCn;
    }

    public String getAddressEn() {
        return addressDetail;
    }

    public void setAddressEn(String addressEn) {
        this.addressDetail = addressEn;
    }

    public String getBrandOperate() {
        return brandOperate;
    }

    public void setBrandOperate(String brandOperate) {
        this.brandOperate = brandOperate;
    }
    @ExcelField(title="渠道类型", align=1, sort=4)
    public String getChannelType() {
        return channelType;
    }

    public void setChannelType(String channelType) {
        this.channelType = channelType;
    }

    public String getStoreImage() {
        return storeImage;
    }

    public void setStoreImage(String storeImage) {
        this.storeImage = storeImage;
    }



    public String getProgress() {
        return progress;
    }

    public void setProgress(String progress) {
        this.progress = progress;
    }
    @ExcelField(title="店铺性质", align=1, sort=5)
    public String getStoreProperty() {
        return storeProperty;
    }

    public void setStoreProperty(String property) {
        this.storeProperty = property;
    }

    public String getIsBroker() {
        return isBroker;
    }

    public void setIsBroker(String isBroker) {
        this.isBroker = isBroker;
    }

    public String getIsStrategy() {
        return isStrategy;
    }

    public void setIsStrategy(String isStrategy) {
        this.isStrategy = isStrategy;
    }

    public String getBroker() {
        return broker;
    }

    public void setBroker(String broker) {
        this.broker = broker;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag;
    }

    public String getPpCode() {
        return ppCode;
    }

    public void setPpCode(String ppCode) {
        this.ppCode = ppCode;
    }
    @ExcelField(title="店铺名称", align=1, sort=2)
    public String getCnSiteName() {
        return cnSiteName;
    }

    public void setCnSiteName(String cnSiteName) {
        this.cnSiteName = cnSiteName;
    }

    private class TSfEstInvestmentNonLaborCost {
    }
}
