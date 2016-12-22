package com.stripcode.mybatis.sf.model;

import com.stripcode.mybatis.common.BaseModel;

/**
 * Created by Metro on 2016/11/14.
 */
public class SFBudGetConsUnit extends BaseModel{
    private String rowId;
    private String budgetId;//对应T_SF_BUDGET表的ROW_ID
    private String consUnit;//施工单位名称
    private String isCooperation;//是否合作
    private String assessment;//评价
    private Double reportCost;//上报金额
    private String contacts;//联系人
    private String phone;//联系电话
    private String remark;//备注
    private String ppId;

    public String getPpId() {
        return ppId;
    }

    public void setPpId(String ppId) {
        this.ppId = ppId;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public String getRowId() {
        return rowId;
    }

    @Override
    public void setRowId(String rowId) {
        this.rowId = rowId;
    }

    public String getConsUnit() {
        return consUnit;
    }

    public void setConsUnit(String consUnit) {
        this.consUnit = consUnit;
    }

    public String getBudgetId() {
        return budgetId;
    }

    public void setBudgetId(String budgetId) {
        this.budgetId = budgetId;
    }

    public String getAssessment() {
        return assessment;
    }

    public void setAssessment(String assessment) {
        this.assessment = assessment;
    }

    public String getIsCooperation() {
        return isCooperation;
    }

    public void setIsCooperation(String isCooperation) {
        this.isCooperation = isCooperation;
    }

    public Double getReportCost() {
        return reportCost;
    }

    public void setReportCost(Double reportCost) {
        this.reportCost = reportCost;
    }

    public String getContacts() {
        return contacts;
    }

    public void setContacts(String contacts) {
        this.contacts = contacts;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
