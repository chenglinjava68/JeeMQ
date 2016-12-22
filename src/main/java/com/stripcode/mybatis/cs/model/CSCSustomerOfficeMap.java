package com.stripcode.mybatis.cs.model;

import com.stripcode.mybatis.common.BaseModel;

/**
 * Created by Metro on 2016/10/11.
 */
public class CSCSustomerOfficeMap extends BaseModel {
    private String rowId;
    private String customerId;
    private String officeId;

    @Override
    public String getRowId() {
        return rowId;
    }

    @Override
    public void setRowId(String rowId) {
        this.rowId = rowId;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getOfficeId() {
        return officeId;
    }

    public void setOfficeId(String officeId) {
        this.officeId = officeId;
    }
}
