package com.stripcode.mybatis.sf.model;

import com.stripcode.mybatis.common.BaseModel;

import java.util.List;

/**
 * Created by Metro on 2016/10/17.
 */
public class SFPolicySupportDetail extends BaseModel {
    private String rowId;//32位码
    private String psId;//对应T_SF_POLICY_SUPPORT表的ROW_ID
    private String supportItem;//支持项
    private String supportMode;//支持方式
    private Double price;//单价
    private String checkTarget;//考核指标
    private Integer operationTerm;//经营年限
    private Double checkValue;//考核值
    private Double money;//金额
    private Double checkStd;//考核标准输入项
    private String remark;//政策支持说明
    private List<SFPolicySupportAgreeAttachment> listAttachment;

    private String ppId;//店铺ID

    public List<SFPolicySupportAgreeAttachment> getListAttachment() {
        return listAttachment;
    }

    public void setListAttachment(List<SFPolicySupportAgreeAttachment> listAttachment) {
        this.listAttachment = listAttachment;
    }

    public Double getCheckStd() {
        return checkStd;
    }

    public void setCheckStd(Double checkStd) {
        this.checkStd = checkStd;
    }

    List<SFPolicySupportAssessment> sfPolicySupportAssessmentList;

    public List<SFPolicySupportAssessment> getSfPolicySupportAssessmentList() {
        return sfPolicySupportAssessmentList;
    }

    public void setSfPolicySupportAssessmentList(List<SFPolicySupportAssessment> sfPolicySupportAssessmentList) {
        this.sfPolicySupportAssessmentList = sfPolicySupportAssessmentList;
    }

    @Override
    public String getRowId() {
        return rowId;
    }

    @Override
    public void setRowId(String rowId) {
        this.rowId = rowId;
    }

    public String getPsId() {
        return psId;
    }

    public void setPsId(String psId) {
        this.psId = psId;
    }

    public String getSupportItem() {
        return supportItem;
    }

    public void setSupportItem(String supportItem) {
        this.supportItem = supportItem;
    }

    public String getSupportMode() {
        return supportMode;
    }

    public void setSupportMode(String supportMode) {
        this.supportMode = supportMode;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getCheckTarget() {
        return checkTarget;
    }

    public void setCheckTarget(String checkTarget) {
        this.checkTarget = checkTarget;
    }

    public Integer getOperationTerm() {
        return operationTerm;
    }

    public void setOperationTerm(Integer operationTerm) {
        this.operationTerm = operationTerm;
    }

    public Double getCheckValue() {
        return checkValue;
    }

    public void setCheckValue(Double checkValue) {
        this.checkValue = checkValue;
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getPpId() {
        return ppId;
    }

    public void setPpId(String ppId) {
        this.ppId = ppId;
    }
}
