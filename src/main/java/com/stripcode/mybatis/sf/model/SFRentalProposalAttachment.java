package com.stripcode.mybatis.sf.model;

import com.stripcode.core.util.WebUtil;

/**
 * Created by Metro on 2016/9/28.
 */
public class SFRentalProposalAttachment{
    private String ArowId;
    private String rentId;//对应T_SF_RENTAL_PROPOSAL表的ROW_ID
    private String templateId;//对应T_SYS_ATTACHEDTEMPLATE表的TEMPLATE_ID
    private String attachmentName;//附件名称
    private String attachId;//对应T_SYS_COMMONATTACHED表的ATTACH_ID
    private String title;
    private String creator;
    private String updater;
    private String creater;
    private String createrTime;
    private String updateTime;
    private String docName;
    private String fileName;
    private String fieldId;

    public String getCreater() {
        return creater;
    }

    public void setCreater(String creater) {
        this.creater = creater;
    }

    public String getDocName() {
        return docName;
    }

    public void setDocName(String docName) {
        this.docName = docName;
    }

    public String getFieldId() {
        return fieldId;
    }

    public void setFieldId(String fieldId) {
        this.fieldId = fieldId;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getArowId() {
        return ArowId;
    }


    public void setArowId(String arowId) {
        ArowId = arowId;
    }
    public String getUpdater() {
        return WebUtil.getCurrentUser();
    }
    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    public String getCreaterTime() {
        return createrTime;
    }

    public void setCreaterTime(String createrTime) {
        this.createrTime = createrTime;
    }

    public String getCreator() {
        return WebUtil.getCurrentUser();
    }
    public void setUpdater(String updater) {
        this.updater = updater;
    }
    public void setCreator(String creator) {
        this.creator = creator;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAttachId() {
        return attachId;
    }

    public void setAttachId(String attachId) {
        this.attachId = attachId;
    }

    public String getAttachmentName() {
        return attachmentName;
    }

    public void setAttachmentName(String attachmentName) {
        this.attachmentName = attachmentName;
    }

    public String getTemplateId() {
        return templateId;
    }

    public void setTemplateId(String templateId) {
        this.templateId = templateId;
    }

    public String getRentId() {
        return rentId;
    }

    public void setRentId(String rentId) {
        this.rentId = rentId;
    }
}
