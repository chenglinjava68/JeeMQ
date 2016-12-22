package com.stripcode.mybatis.sf.model;

import com.stripcode.mybatis.common.BaseModel;

import java.util.List;

/**
 * @author Metro
 */
public class SFAcceptance extends BaseModel {
    private String rowId;
    private String ppId;
    private String remark;
    private List<SFAcceptanceAttachment> sfAcceptanceAttachments;

    public List<SFAcceptanceAttachment> getSfAcceptanceAttachments() {
        return sfAcceptanceAttachments;
    }

    public void setSfAcceptanceAttachments(List<SFAcceptanceAttachment> sfAcceptanceAttachments) {
        this.sfAcceptanceAttachments = sfAcceptanceAttachments;
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

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
