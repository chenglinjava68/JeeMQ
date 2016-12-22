package com.stripcode.mybatis.cs.model;

import com.stripcode.mybatis.common.BaseModel;

/**
 * Created by Metro on 2016/11/17.
 */
public class CSMarketCustomerDiscountSplit extends BaseModel{
    private String rowId;
    private String authorizationId;
    private String style;
    private Double splitRate;
    private Double discountRate;

    @Override
    public String getRowId() {
        return rowId;
    }

    @Override
    public void setRowId(String rowId) {
        this.rowId = rowId;
    }

    public Double getDiscountRate() {
        return discountRate;
    }

    public void setDiscountRate(Double discountRate) {
        this.discountRate = discountRate;
    }

    public Double getSplitRate() {
        return splitRate;
    }

    public void setSplitRate(Double splitRate) {
        this.splitRate = splitRate;
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
