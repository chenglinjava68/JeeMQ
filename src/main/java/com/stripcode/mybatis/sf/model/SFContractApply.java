package com.stripcode.mybatis.sf.model;

import com.stripcode.mybatis.common.BaseModel;

import java.util.List;

/**
 * @author Metro
 */
public class SFContractApply extends BaseModel{
    private String rowId;
    private String ppId;
    private String contractVersion;
    private String applicant;
    private String phone;
    private String department;
    private String otherCompanyName;
    private String contractName;
    private String contractType;
    private String isFrameContract;
    private String contractTemplate;
    private String contractSignCompanyName;
    private Double contractAmount;
    private String contractStartDate;
    private String contractEndDate;
    private String contractAttachment;
    private String description;
    private String remark;

    private List<SFContractApplyAttachment> applyAttachmentList;

    public List<SFContractApplyAttachment> getApplyAttachmentList() {
        return applyAttachmentList;
    }

    public void setApplyAttachmentList(List<SFContractApplyAttachment> applyAttachmentList) {
        this.applyAttachmentList = applyAttachmentList;
    }

    @Override
    public String getRowId() {
        return rowId;
    }

    @Override
    public void setRowId(String rowId) {
        this.rowId = rowId;
    }

    public String getPpId() {
        return ppId;
    }

    public void setPpId(String ppId) {
        this.ppId = ppId;
    }

    public String getContractVersion() {
        return contractVersion;
    }

    public void setContractVersion(String contractVersion) {
        this.contractVersion = contractVersion;
    }

    public String getApplicant() {
        return applicant;
    }

    public void setApplicant(String applicant) {
        this.applicant = applicant;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getOtherCompanyName() {
        return otherCompanyName;
    }

    public void setOtherCompanyName(String otherCompanyName) {
        this.otherCompanyName = otherCompanyName;
    }

    public String getContractName() {
        return contractName;
    }

    public void setContractName(String contractName) {
        this.contractName = contractName;
    }

    public String getContractType() {
        return contractType;
    }

    public void setContractType(String contractType) {
        this.contractType = contractType;
    }

    public String getIsFrameContract() {
        return isFrameContract;
    }

    public void setIsFrameContract(String isFrameContract) {
        this.isFrameContract = isFrameContract;
    }

    public String getContractTemplate() {
        return contractTemplate;
    }

    public void setContractTemplate(String contractTemplate) {
        this.contractTemplate = contractTemplate;
    }

    public String getContractSignCompanyName() {
        return contractSignCompanyName;
    }

    public void setContractSignCompanyName(String contractSignCompanyName) {
        this.contractSignCompanyName = contractSignCompanyName;
    }

    public Double getContractAmount() {
        return contractAmount;
    }

    public void setContractAmount(Double contractAmount) {
        this.contractAmount = contractAmount;
    }

    public String getContractStartDate() {
        return contractStartDate;
    }

    public void setContractStartDate(String contractStartDate) {
        this.contractStartDate = contractStartDate;
    }

    public String getContractEndDate() {
        return contractEndDate;
    }

    public void setContractEndDate(String contractEndDate) {
        this.contractEndDate = contractEndDate;
    }

    public String getContractAttachment() {
        return contractAttachment;
    }

    public void setContractAttachment(String contractAttachment) {
        this.contractAttachment = contractAttachment;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
