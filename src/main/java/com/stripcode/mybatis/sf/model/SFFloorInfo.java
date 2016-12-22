package com.stripcode.mybatis.sf.model;

import com.stripcode.mybatis.common.BaseModel;

/**
 * @author Metro
 */
public class SFFloorInfo extends BaseModel {
    private String rowId;
    private String ppId;
    private String floor;
    private Double size;
    private Double floorslab;
    private Double floorHight;
    private Double bottomHight;
    private String goodsCategory;
    private String remark;

    @Override
    public String getRowId() {
        return rowId;
    }

    @Override
    public void setRowId(String rowId) {
        this.rowId = rowId;
    }

    public Double getBottomHight() {
        return bottomHight;
    }

    public void setBottomHight(Double bottomHight) {
        this.bottomHight = bottomHight;
    }

    public String getPpId() {
        return ppId;
    }

    public void setPpId(String ppId) {
        this.ppId = ppId;
    }

    public String getFloor() {
        return floor;
    }

    public void setFloor(String floor) {
        this.floor = floor;
    }

    public Double getSize() {
        return size;
    }

    public void setSize(Double size) {
        this.size = size;
    }

    public Double getFloorslab() {
        return floorslab;
    }

    public void setFloorslab(Double floorslab) {
        this.floorslab = floorslab;
    }

    public Double getFloorHight() {
        return floorHight;
    }

    public void setFloorHight(Double floorHight) {
        this.floorHight = floorHight;
    }

    public String getGoodsCategory() {
        return goodsCategory;
    }

    public void setGoodsCategory(String goodsCategory) {
        this.goodsCategory = goodsCategory;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
