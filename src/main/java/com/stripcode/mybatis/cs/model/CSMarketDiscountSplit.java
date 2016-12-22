package com.stripcode.mybatis.cs.model;

import com.stripcode.mybatis.common.BaseModel;

/**
 * Created by Metro on 2016/11/17.
 */
public class CSMarketDiscountSplit extends BaseModel{
    private String rowId;
    private String authorizationId;//对应T_CS_NEW_MARKETAUZ表的ROW_ID
    private String style;//风格
    private Double splitRate;//分成比例
    private Double discountRate;//基准折率
    private String macroCode;//
    private String macroName;//

    public Double getSplitRate() {
        return splitRate;
    }

    public void setSplitRate(Double splitRate) {
        this.splitRate = splitRate;
    }

    public Double getDiscountRate() {
        return discountRate;
    }

    public void setDiscountRate(Double discountRate) {
        this.discountRate = discountRate;
    }

    public String getMacroCode() {
        return macroCode;
    }

    public void setMacroCode(String macroCode) {
        this.macroCode = macroCode;
    }

    public String getMacroName() {
        return macroName;
    }

    public void setMacroName(String macroName) {
        this.macroName = macroName;
    }

    @Override
    public String getRowId() {
        return rowId;
    }

    @Override
    public void setRowId(String rowId) {
        this.rowId = rowId;
    }

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }

    public String getAuthorizationId() {
        return authorizationId;
    }

    public void setAuthorizationId(String authorizationId) {
        this.authorizationId = authorizationId;
    }
}
