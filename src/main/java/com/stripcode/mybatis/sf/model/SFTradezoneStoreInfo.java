package com.stripcode.mybatis.sf.model;

import com.stripcode.core.annotation.Divide;
import com.stripcode.core.annotation.Multiply;
import com.stripcode.mybatis.common.BaseModel;

/**
 * @author Metro
 */
public class SFTradezoneStoreInfo extends BaseModel {
    private String rowId;
    private String tradezoneId;
    private String storeName;
    private String openDate;
    private Double distance;
    private Double sales;

    @Override
    public String getRowId() {
        return rowId;
    }

    @Override
    public void setRowId(String rowId) {
        this.rowId = rowId;
    }

    public String getTradezoneId() {
        return tradezoneId;
    }

    public void setTradezoneId(String tradezoneId) {
        this.tradezoneId = tradezoneId;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public String getOpenDate() {
        return openDate;
    }

    public void setOpenDate(String openDate) {
        this.openDate = openDate;
    }

    public Double getDistance() {
        return distance;
    }

    public void setDistance(Double distance) {
        this.distance = distance;
    }
    @Multiply(10000)
    public Double getSales() {
        return sales;
    }
    @Divide(10000)
    public void setSales(Double sales) {
        this.sales = sales;
    }
}
