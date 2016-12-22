package com.stripcode.mybatis.sf.model;

import com.stripcode.mybatis.common.BaseModel;

import java.util.List;

/**
 * @author Metro
 */
public class SFSiteInfo extends BaseModel {
    private String rowId;
    private String ppId;
    private String isPoloSign;
    private Integer poloSignNum;
    private String shopfrontEffictivity;
    private String isDirectionalSign;
    private Integer directionalSignNum;
    private String surfaceLen;
    private Integer floor;
    private Double area;
    private Double totalSize;
    private Double operatingArea;
    private Double bathroomArea;
    private Double depotArea;
    private Double rentArea;
    private Double stairAeea;
    private Double staffRoom;
    private Double siteArea;
    private Double outsideArea;
    private Double otherArea;
    private Double doorWidth;
    private Double internalDoorWidth;
    private Double storeDeep;
    private Double storeyHigh;
    private String isBackDepot;
    private Double backDepotArea;
    private String bay;
    private Double midPropsHigh;
    private Double sidePropsHigh;
    private String curBrand;
    private String tel;
    private String contacts;
    private List<SFFloorInfo> floorInfoList;
    private List<SFRentInfo> rentInfoList;
    private List<SFStyleAreaPerInfo> styleAreaPerInfoList;
    private Double facadeArea;

    public Double getFacadeArea() {
        return facadeArea;
    }

    public void setFacadeArea(Double facadeArea) {
        this.facadeArea = facadeArea;
    }

    public List<SFStyleAreaPerInfo> getStyleAreaPerInfoList() {
        return styleAreaPerInfoList;
    }

    public void setStyleAreaPerInfoList(List<SFStyleAreaPerInfo> styleAreaPerInfoList) {
        this.styleAreaPerInfoList = styleAreaPerInfoList;
    }

    public Double getTotalSize() {
        return this.area;
    }

    public void setTotalSize(Double totalSize) {
        this.totalSize = totalSize;
    }
    public List<SFFloorInfo> getFloorInfoList() {
        return floorInfoList;
    }

    public void setFloorInfoList(List<SFFloorInfo> floorInfoList) {
        this.floorInfoList = floorInfoList;
    }

    public List<SFRentInfo> getRentInfoList() {
        return rentInfoList;
    }

    public void setRentInfoList(List<SFRentInfo> rentInfoList) {
        this.rentInfoList = rentInfoList;
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

    public String getSurfaceLen() {
        return surfaceLen;
    }

    public void setSurfaceLen(String surfaceLen) {
        this.surfaceLen = surfaceLen;
    }

    public Integer getFloor() {
        return floor;
    }

    public void setFloor(Integer floor) {
        this.floor = floor;
    }

    public Double getArea() {
        return area;
    }

    public void setArea(Double area) {
        this.area = area;
    }

    public Double getOperatingArea() {
        return operatingArea;
    }

    public void setOperatingArea(Double operatingArea) {
        this.operatingArea = operatingArea;
    }

    public Double getBathroomArea() {
        return bathroomArea;
    }

    public void setBathroomArea(Double bathroomArea) {
        this.bathroomArea = bathroomArea;
    }

    public Double getDepotArea() {
        return depotArea;
    }

    public void setDepotArea(Double depotArea) {
        this.depotArea = depotArea;
    }

    public Double getRentArea() {
        return rentArea;
    }

    public void setRentArea(Double rentArea) {
        this.rentArea = rentArea;
    }

    public Double getStairAeea() {
        return stairAeea;
    }

    public void setStairAeea(Double stairAeea) {
        this.stairAeea = stairAeea;
    }

    public Double getStaffRoom() {
        return staffRoom;
    }

    public void setStaffRoom(Double staffRoom) {
        this.staffRoom = staffRoom;
    }

    public Double getSiteArea() {
        return siteArea;
    }

    public void setSiteArea(Double siteArea) {
        this.siteArea = siteArea;
    }

    public Double getOutsideArea() {
        return outsideArea;
    }

    public void setOutsideArea(Double outsideArea) {
        this.outsideArea = outsideArea;
    }

    public Double getOtherArea() {
        return otherArea;
    }

    public void setOtherArea(Double otherArea) {
        this.otherArea = otherArea;
    }

    public Double getDoorWidth() {
        return doorWidth;
    }

    public void setDoorWidth(Double doorWidth) {
        this.doorWidth = doorWidth;
    }

    public Double getInternalDoorWidth() {
        return internalDoorWidth;
    }

    public void setInternalDoorWidth(Double internalDoorWidth) {
        this.internalDoorWidth = internalDoorWidth;
    }

    public Double getStoreDeep() {
        return storeDeep;
    }

    public void setStoreDeep(Double storeDeep) {
        this.storeDeep = storeDeep;
    }

    public Double getStoreyHigh() {
        return storeyHigh;
    }

    public void setStoreyHigh(Double storeyHigh) {
        this.storeyHigh = storeyHigh;
    }

    public String getIsBackDepot() {
        return isBackDepot;
    }

    public void setIsBackDepot(String isBackDepot) {
        this.isBackDepot = isBackDepot;
    }

    public Double getBackDepotArea() {
        return backDepotArea;
    }

    public void setBackDepotArea(Double backDepotArea) {
        this.backDepotArea = backDepotArea;
    }

    public String getBay() {
        return bay;
    }

    public void setBay(String bay) {
        this.bay = bay;
    }

    public Double getMidPropsHigh() {
        return midPropsHigh;
    }

    public void setMidPropsHigh(Double midPropsHigh) {
        this.midPropsHigh = midPropsHigh;
    }

    public Double getSidePropsHigh() {
        return sidePropsHigh;
    }

    public void setSidePropsHigh(Double sidePropsHigh) {
        this.sidePropsHigh = sidePropsHigh;
    }

    public String getCurBrand() {
        return curBrand;
    }

    public void setCurBrand(String curBrand) {
        this.curBrand = curBrand;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getContacts() {
        return contacts;
    }

    public void setContacts(String contacts) {
        this.contacts = contacts;
    }
}
