package com.stripcode.mybatis.cs.model;

import com.stripcode.mybatis.common.BaseModel;

import java.io.Serializable;

/**
 * @author Metro
 */
public class CSSigningAttachment extends BaseModel implements Serializable{
    private String rowId;
    private String signingId;
    private String templateId;
    private String contractName;
    private String attachId;
    private String fileName;
    private String filePath;
    private String creater;
    private String title;

    public String getRowId() {
        return rowId;
    }

    public void setRowId(String rowId) {
        this.rowId = rowId;
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
}
