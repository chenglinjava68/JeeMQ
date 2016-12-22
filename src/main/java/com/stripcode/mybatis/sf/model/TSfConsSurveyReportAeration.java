package com.stripcode.mybatis.sf.model;

import com.stripcode.mybatis.common.BaseModel;

import java.math.BigDecimal;

public class TSfConsSurveyReportAeration extends BaseModel{

    private String rowId;

    private String ppId;

    private String summerOutdoorTemp;

    private String winterOutdoorTemp;

    private String airConditionSupply;

    private BigDecimal totalCold;

    private String airConditionMode;

    private String fanHeatEffect;

    private String noiseEffect;

    private String isEnvironmentalPermits;

    private String measures;

    private static final long serialVersionUID = 1L;


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

    public String getSummerOutdoorTemp() {
        return summerOutdoorTemp;
    }

    public void setSummerOutdoorTemp(String summerOutdoorTemp) {
        this.summerOutdoorTemp = summerOutdoorTemp == null ? null : summerOutdoorTemp.trim();
    }

    public String getWinterOutdoorTemp() {
        return winterOutdoorTemp;
    }

    public void setWinterOutdoorTemp(String winterOutdoorTemp) {
        this.winterOutdoorTemp = winterOutdoorTemp == null ? null : winterOutdoorTemp.trim();
    }

    public String getAirConditionSupply() {
        return airConditionSupply;
    }

    public void setAirConditionSupply(String airConditionSupply) {
        this.airConditionSupply = airConditionSupply == null ? null : airConditionSupply.trim();
    }

    public BigDecimal getTotalCold() {
        return totalCold;
    }

    public void setTotalCold(BigDecimal totalCold) {
        this.totalCold = totalCold;
    }

    public String getAirConditionMode() {
        return airConditionMode;
    }

    public void setAirConditionMode(String airConditionMode) {
        this.airConditionMode = airConditionMode == null ? null : airConditionMode.trim();
    }

    public String getFanHeatEffect() {
        return fanHeatEffect;
    }

    public void setFanHeatEffect(String fanHeatEffect) {
        this.fanHeatEffect = fanHeatEffect == null ? null : fanHeatEffect.trim();
    }

    public String getNoiseEffect() {
        return noiseEffect;
    }

    public void setNoiseEffect(String noiseEffect) {
        this.noiseEffect = noiseEffect == null ? null : noiseEffect.trim();
    }

    public String getIsEnvironmentalPermits() {
        return isEnvironmentalPermits;
    }

    public void setIsEnvironmentalPermits(String isEnvironmentalPermits) {
        this.isEnvironmentalPermits = isEnvironmentalPermits == null ? null : isEnvironmentalPermits.trim();
    }

    public String getMeasures() {
        return measures;
    }

    public void setMeasures(String measures) {
        this.measures = measures == null ? null : measures.trim();
    }


}