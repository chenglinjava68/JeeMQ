package com.stripcode.mybatis.cs.model;

import com.stripcode.mybatis.common.BaseModel;

/**
 * @author Metro
 */
public class CSRenewalContractinfo extends BaseModel{
    private String rowId;
    private String optimauthId;
    private String signDate;

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

    public String getSignDate() {
        return signDate;
    }

    public void setSignDate(String signDate) {
        this.signDate = signDate;
    }
}
