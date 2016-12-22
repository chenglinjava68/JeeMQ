package com.stripcode.mybatis.sf.model;

import com.stripcode.mybatis.common.BaseModel;

import java.util.List;

/**
 * Created by Metro on 2016/11/9.
 */
public class SFBudGetEstimation extends BaseModel{
    private String rowId;
    private String reason;//启动原因
    private String ppId;//意向店Id
    private List<SFBudGetEstimationCost> budGetEstimationCostList;

    public List<SFBudGetEstimationCost> getBudGetEstimationCostList() {
        return budGetEstimationCostList;
    }

    public void setBudGetEstimationCostList(List<SFBudGetEstimationCost> budGetEstimationCostList) {
        this.budGetEstimationCostList = budGetEstimationCostList;
    }

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

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }
}
