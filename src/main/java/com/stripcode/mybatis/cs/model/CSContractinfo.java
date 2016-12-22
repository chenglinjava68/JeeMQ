package com.stripcode.mybatis.cs.model;

import com.stripcode.mybatis.common.BaseModel;

import java.io.Serializable;

/**
 * @author Metro
 */
public class CSContractinfo extends BaseModel implements Serializable {
    private String rowId;
    private String optimauthId;
    private String templateId;
    private String attachId;
    private String contractName;
    private String creater;
    private String createrTime;

    public String getCreater() {
        return creater;
    }

    public void setCreater(String creater) {
        this.creater = creater;
    }

    public String  getCreaterTime() {
        return createrTime;
    }

    public void setCreaterTime(String createrTime) {
        this.createrTime = createrTime;
    }

    public String getContractName() {
        return contractName;
    }

    public void setContractName(String contractName) {
        this.contractName = contractName;
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

    public String getTemplateId() {
        return templateId;
    }

    public void setTemplateId(String templateId) {
        this.templateId = templateId;
    }

    public String getAttachId() {
        return attachId;
    }

    public void setAttachId(String attachId) {
        this.attachId = attachId;
    }
}
