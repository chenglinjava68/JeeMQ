package com.stripcode.mybatis.ps.model;

import com.stripcode.core.util.excelUtil.annotation.ExcelField;
import com.stripcode.mybatis.common.BaseModel;
import com.stripcode.mybatis.cs.model.CSCustomerInfo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * Created by Metro on 2016/9/26.
 */
public class PSPolicySupport extends BaseModel implements Serializable {
    private String rowId;//32位码
    private String policyCode;//政策编号
    private String policyName;//政策名称
    private String policyStartDate;//政策开始日期
    private String policyEndDate;//政策结束日期
    private String brand;//品牌
    private String PolicyDate;//政策有效期
    private String status;//状态
    private String modeCode;//支持方式
    private String remark;//备注
    private String amountLimit;//支持金额上限
    private String itemCode;//支持方式编号
    private String conditionCode;//支持条件编号
    private String creator;//创建者
    private Date createTime;//创建时间
    private String updater;//更新者
    private Date updateTime;//更新时间

    private String[] rowIds;
    private String[] itemCodes;//支持方式编号
    private String[] conditionCodes;//支持条件编号
    private String[] amountLimits;//支持金额上限
    private String[] modeCodes;//支持方式
    private String[] remarks;//备注
    private CSCustomerInfo customerInfo;

    public CSCustomerInfo getCustomerInfo() {
        return customerInfo;
    }

    public void setCustomerInfo(CSCustomerInfo customerInfo) {
        this.customerInfo = customerInfo;
    }

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

    public String[] getRowIds() {
        return rowIds;
    }

    public void setRowIds(String[] rowIds) {
        this.rowIds = rowIds;
    }

    public String[] getItemCodes() {
        return itemCodes;
    }

    public void setItemCodes(String[] itemCodes) {
        this.itemCodes = itemCodes;
    }

    public String[] getConditionCodes() {
        return conditionCodes;
    }

    public void setConditionCodes(String[] conditionCodes) {
        this.conditionCodes = conditionCodes;
    }

    public String[] getAmountLimits() {
        return amountLimits;
    }

    public void setAmountLimits(String[] amountLimits) {
        this.amountLimits = amountLimits;
    }

    public String[] getModeCodes() {
        return modeCodes;
    }

    public void setModeCodes(String[] modeCodes) {
        this.modeCodes = modeCodes;
    }

    public String[] getRemarks() {
        return remarks;
    }

    public void setRemarks(String[] remarks) {
        this.remarks = remarks;
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

    public String getAmountLimit() {
        return amountLimit;
    }

    public void setAmountLimit(String amountLimit) {
        this.amountLimit = amountLimit;
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
    @ExcelField(title="状态", align=1, sort=6)
    public String getStatus() {
        return status;
    }

    @Override
    public void setStatus(String status) {
        this.status = status;
    }

    private List<PSPolicySupportDetail> policySupportDetailList;

    public List<PSPolicySupportDetail> getPolicySupportDetailList() {
        return policySupportDetailList;
    }

    public void setPolicySupportDetailList(List<PSPolicySupportDetail> policySupportDetailList) {
        this.policySupportDetailList = policySupportDetailList;
    }

    public String getPolicyDate() {
        return PolicyDate;
    }

    public void setPolicyDate(String policyDate) {
        PolicyDate = policyDate;
    }


    public String getRowId() {
        return rowId;
    }


    public void setRowId(String rowId) {
        this.rowId = rowId;
    }
    @ExcelField(title="政策编号", align=1, sort=1)
    public String getPolicyCode() {
        return policyCode;
    }

    public void setPolicyCode(String policyCode) {
        this.policyCode = policyCode;
    }
    @ExcelField(title="名称", align=1, sort=2)
    public String getPolicyName() {
        return policyName;
    }

    public void setPolicyName(String policyName) {
        this.policyName = policyName;
    }
    @ExcelField(title="政策开始日期", align=1, sort=4)
    public String getPolicyStartDate() {
        return policyStartDate;
    }

    public void setPolicyStartDate(String policyStartDate) {
        this.policyStartDate = policyStartDate;
    }
    @ExcelField(title="政策结束日期", align=1, sort=5)
    public String getPolicyEndDate() {
        return policyEndDate;
    }

    public void setPolicyEndDate(String policyEndDate) {
        this.policyEndDate = policyEndDate;
    }
    @ExcelField(title="品牌", align=1, sort=3)
    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }
}
