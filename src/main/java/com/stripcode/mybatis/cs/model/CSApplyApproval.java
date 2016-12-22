package com.stripcode.mybatis.cs.model;

import com.stripcode.mybatis.common.BaseModel;

import java.io.Serializable;

/**
 * Created by Metro on 2016/9/14.
 */
public class CSApplyApproval extends BaseModel implements Serializable{
    private String rowId;
    private String optimauthId;
    private String investFunds; //首期投入资金
    private String costBack;//希望回收成本年数
    private String otherBrand;//是否经营其他休闲品牌
    private String remark;//备注
    private String delFlag;//删除标记
    private String taskId;//任务ID
    private String isFinished;//状态是否完成

    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }

    public String getIsFinished() {
        return isFinished;
    }

    public void setIsFinished(String isFinished) {
        this.isFinished = isFinished;
    }

    public String getRowId() {
        return rowId;
    }

    public void setRowId(String rowId) {
        this.rowId = rowId;
    }

    @Override
    public String getDelFlag() {
        return delFlag;
    }

    @Override
    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getOtherBrand() {
        return otherBrand;
    }

    public void setOtherBrand(String otherBrand) {
        this.otherBrand = otherBrand;
    }

    public String getCostBack() {
        return costBack;
    }

    public void setCostBack(String costBack) {
        this.costBack = costBack;
    }

    public String getInvestFunds() {
        return investFunds;
    }

    public void setInvestFunds(String investFunds) {
        this.investFunds = investFunds;
    }

    public String getOptimauthId() {
        return optimauthId;
    }

    public void setOptimauthId(String optimauthId) {
        this.optimauthId = optimauthId;
    }
}
