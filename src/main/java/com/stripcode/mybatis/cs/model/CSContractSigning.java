package com.stripcode.mybatis.cs.model;

import com.stripcode.mybatis.common.BaseModel;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @author Metro
 */
public class CSContractSigning extends BaseModel implements Serializable {
    private String rowId;
    private String optimauthId;
    private String actualSignDate;
    private String actualAccreditStartDate;
    private String actualAccreditEndDate;
    private String templateId;
    private String signingId;
    private String contractName;
    private String attachId;
    private String creater;
    private Date createrTime;
    private List<CSCertificateOfPayment> csCertificateOfPaymentList;

    //任务完成需要的任务ID
    private String taskId;

    public List<CSCertificateOfPayment> getCsCertificateOfPaymentList() {
        return csCertificateOfPaymentList;
    }

    public void setCsCertificateOfPaymentList(List<CSCertificateOfPayment> csCertificateOfPaymentList) {
        this.csCertificateOfPaymentList = csCertificateOfPaymentList;
    }

    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }

    public String getSigningId() {
        return signingId;
    }

    public void setSigningId(String signingId) {
        this.signingId = signingId;
    }

    public String getTemplateId() {
        return templateId;
    }

    public void setTemplateId(String templateId) {
        this.templateId = templateId;
    }

    public String getContractName() {
        return contractName;
    }

    public void setContractName(String contractName) {
        this.contractName = contractName;
    }

    public String getAttachId() {
        return attachId;
    }

    public void setAttachId(String attachId) {
        this.attachId = attachId;
    }

    public String getCreater() {
        return creater;
    }

    public void setCreater(String creater) {
        this.creater = creater;
    }

    public Date getCreaterTime() {
        return createrTime;
    }

    public void setCreaterTime(Date createrTime) {
        this.createrTime = createrTime;
    }

    public String getRowId() {
        return rowId;
    }

    public void setRowId(String rowId) {
        this.rowId = rowId;
    }

    public String getOptimauthId() {
        return optimauthId;
    }

    public void setOptimauthId(String optimauthId) {
        this.optimauthId = optimauthId;
    }

    public String getActualSignDate() {
        return actualSignDate;
    }

    public void setActualSignDate(String actualSignDate) {
        this.actualSignDate = actualSignDate;
    }

    public String getActualAccreditStartDate() {
        return actualAccreditStartDate;
    }

    public void setActualAccreditStartDate(String actualAccreditStartDate) {
        this.actualAccreditStartDate = actualAccreditStartDate;
    }

    public String getActualAccreditEndDate() {
        return actualAccreditEndDate;
    }

    public void setActualAccreditEndDate(String actualAccreditEndDate) {
        this.actualAccreditEndDate = actualAccreditEndDate;
    }
}
