package com.stripcode.mybatis.sf.model;

import com.stripcode.mybatis.common.BaseModel;

/**
 * @author Metro
 */
public class SFStyleAreaPerInfo extends BaseModel {
    private String rowId;
    private String ppId;
    private String floor;
    private String style;
    private String seriesSex;
    private String series;
    private String areaPer;
    private String salesPer;
    private String seriesName;

    private String areaTotal;//面积占比
    private String salesPerTotal;//销售占比
    private String sex;


    public String getSalesPerTotal() {
        return salesPerTotal;
    }

    public void setSalesPerTotal(String salesPerTotal) {
        this.salesPerTotal = salesPerTotal;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getAreaTotal() {
        return areaTotal;
    }

    public void setAreaTotal(String areaTotal) {
        this.areaTotal = areaTotal;
    }

    public String getSeriesName() {
        return seriesName;
    }

    public void setSeriesName(String seriesName) {
        this.seriesName = seriesName;
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

    public String getFloor() {
        return floor;
    }

    public void setFloor(String floor) {
        this.floor = floor;
    }

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }

    public String getSeriesSex() {
        return seriesSex;
    }

    public void setSeriesSex(String seriesSex) {
        this.seriesSex = seriesSex;
    }

    public String getSeries() {
        return series;
    }

    public void setSeries(String series) {
        this.series = series;
    }

    public String getAreaPer() {
        return areaPer;
    }

    public void setAreaPer(String areaPer) {
        this.areaPer = areaPer;
    }

    public String getSalesPer() {
        return salesPer;
    }

    public void setSalesPer(String salesPer) {
        this.salesPer = salesPer;
    }
}
