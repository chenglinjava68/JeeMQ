package com.stripcode.mybatis.sf.model;

import com.stripcode.mybatis.common.BaseModel;
import com.stripcode.mybatis.cs.model.CSCustomerInfo;

import java.util.List;

/**
 * Created by Metro on 2016/9/28.
 */
public class SFPolicySupport extends BaseModel {
    private String rowId;//32位码
    private String ppId;//意向店ID
    private String policy;//政策选择
    private String startDate;//政策开始日期
    private String endDate;//政策结束日期
    private String remark;//备注

    private CSCustomerInfo csCustomerInfo;
    private String fileName;
    private String fieldId;
    private String attachId;
    List<SFPolicySupportDetail> sfPolicySupportDetailList;
    private String[] rowIds;
    private String[] supportItems;
    private String[] supportModes;
    private Double[] prices;
    private String[] checkTargets;
    private String[] operationTerms;
    private String[] checkValues;
    private String[] moneys;
    private String[] checkStds;

    public String[] getCheckStds() {
        return checkStds;
    }

    public void setCheckStds(String[] checkStds) {
        this.checkStds = checkStds;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFieldId() {
        return fieldId;
    }

    public void setFieldId(String fieldId) {
        this.fieldId = fieldId;
    }

    public String getAttachId() {
        return attachId;
    }

    public void setAttachId(String attachId) {
        this.attachId = attachId;
    }

    public List<SFPolicySupportDetail> getSfPolicySupportDetailList() {
        return sfPolicySupportDetailList;
    }

    public void setSfPolicySupportDetailList(List<SFPolicySupportDetail> sfPolicySupportDetailList) {
        this.sfPolicySupportDetailList = sfPolicySupportDetailList;
    }

    public CSCustomerInfo getCsCustomerInfo() {
        return csCustomerInfo;
    }

    public void setCsCustomerInfo(CSCustomerInfo csCustomerInfo) {
        this.csCustomerInfo = csCustomerInfo;
    }

    private List<SFPolicySupportAgreeAttachment> listAttachment;

    public List<SFPolicySupportAgreeAttachment> getListAttachment() {
        return listAttachment;
    }

    public void setListAttachment(List<SFPolicySupportAgreeAttachment> listAttachment) {
        this.listAttachment = listAttachment;
    }



    public String[] getRowIds() {
        return rowIds;
    }

    public void setRowIds(String[] rowIds) {
        this.rowIds = rowIds;
    }

    public String[] getSupportItems() {
        return supportItems;
    }

    public void setSupportItems(String[] supportItems) {
        this.supportItems = supportItems;
    }

    public String[] getSupportModes() {
        return supportModes;
    }

    public void setSupportModes(String[] supportModes) {
        this.supportModes = supportModes;
    }

    public Double[] getPrices() {
        return prices;
    }

    public void setPrices(Double[] prices) {
        this.prices = prices;
    }

    public String[] getCheckTargets() {
        return checkTargets;
    }

    public void setCheckTargets(String[] checkTargets) {
        this.checkTargets = checkTargets;
    }

    public String[] getOperationTerms() {
        return operationTerms;
    }

    public void setOperationTerms(String[] operationTerms) {
        this.operationTerms = operationTerms;
    }

    public String[] getCheckValues() {
        return checkValues;
    }

    public void setCheckValues(String[] checkValues) {
        this.checkValues = checkValues;
    }

    public String[] getMoneys() {
        return moneys;
    }

    public void setMoneys(String[] moneys) {
        this.moneys = moneys;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getRowId() {
        return rowId;
    }

    public void setRowId(String rowId) {
        this.rowId = rowId;
    }

    public String getPpId() {
        return ppId;
    }

    public void setPpId(String ppId) {
        this.ppId = ppId;
    }

    public String getPolicy() {
        return policy;
    }

    public void setPolicy(String policy) {
        this.policy = policy;
    }


    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
