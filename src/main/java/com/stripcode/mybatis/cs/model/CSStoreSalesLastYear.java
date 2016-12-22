package com.stripcode.mybatis.cs.model;

import com.stripcode.core.annotation.Divide;
import com.stripcode.core.annotation.Multiply;
import com.stripcode.mybatis.common.BaseModel;

/**
 * @author Metro
 */
public class CSStoreSalesLastYear extends BaseModel{
    private String rowId;
    private String optimauthId;
    private String ppId;
    private String planClass;
    private String storeCode;
    private String storeName;
    private String openDate;
    private Double sales;
    private Double incrate;

    public String getPpId() {
        return ppId;
    }

    public void setPpId(String ppId) {
        this.ppId = ppId;
    }

    @Override
    public String getRowId() {
        return rowId;
    }

    @Override
    public void setRowId(String rowId) {
        this.rowId = rowId;
    }

    public String getOptimauthId() {
        return optimauthId;
    }

    public void setOptimauthId(String optimauthId) {
        this.optimauthId = optimauthId;
    }

    public String getPlanClass() {
        return planClass;
    }

    public void setPlanClass(String planClass) {
        this.planClass = planClass;
    }

    public String getStoreCode() {
        return storeCode;
    }

    public void setStoreCode(String storeCode) {
        this.storeCode = storeCode;
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
    @Multiply(10000)
    public Double getSales() {
        return sales;
    }
    @Divide(10000)
    public void setSales(Double sales) {
        this.sales = sales;
    }

    public Double getIncrate() {
        return incrate;
    }

    public void setIncrate(Double incrate) {
        this.incrate = incrate;
    }
}
