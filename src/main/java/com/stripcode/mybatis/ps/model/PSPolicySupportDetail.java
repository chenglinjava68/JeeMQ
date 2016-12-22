package com.stripcode.mybatis.ps.model;

import com.stripcode.mybatis.common.BaseModel;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Metro on 2016/9/27.
 */
public class PSPolicySupportDetail extends BaseModel implements Serializable {
    private String rowId;//21位码
    private String policyId;//对应T_PS_POLICY_SUPPORT表的ROW_ID
    private String itemCode;//支持方式编号
    private String conditionCode;//支持条件编号
    private String amountLimit;//支持金额上限
    private String modeCode;//支持方式
    private String remark;//备注
    private String creator;//创建者
    private Date createTime;//创建时间
    private String updater;//更新者
    private Date updateTime;//更新时间

    @Override
    public Date getCreateTime() {
        return createTime;
    }

    @Override
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public Date getUpdateTime() {
        return updateTime;
    }

    @Override
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String getCreator() {
        return creator;
    }

    @Override
    public void setCreator(String creator) {
        this.creator = creator;
    }



    @Override
    public String getUpdater() {
        return updater;
    }

    @Override
    public void setUpdater(String updater) {
        this.updater = updater;
    }




    public String getRowId() {
        return rowId;
    }


    public void setRowId(String rowId) {
        this.rowId = rowId;
    }

    public String getPolicyId() {
        return policyId;
    }

    public void setPolicyId(String policyId) {
        this.policyId = policyId;
    }

    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    public String getConditionCode() {
        return conditionCode;
    }

    public void setConditionCode(String conditionCode) {
        this.conditionCode = conditionCode;
    }

    public String getAmountLimit() {
        return amountLimit;
    }

    public void setAmountLimit(String amountLimit) {
        this.amountLimit = amountLimit;
    }

    public String getModeCode() {
        return modeCode;
    }

    public void setModeCode(String modeCode) {
        this.modeCode = modeCode;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
