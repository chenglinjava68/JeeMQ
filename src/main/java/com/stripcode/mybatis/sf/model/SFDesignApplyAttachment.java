package com.stripcode.mybatis.sf.model;

import com.stripcode.mybatis.common.BaseModel;

/**
 * Created by Metro on 2016/10/18.
 */
public class SFDesignApplyAttachment extends BaseModel{
    private String rowId;
    private String designId; //对应T_SF_DESIGN_APPLY表的ROW_ID
    private String templateId; //对应T_SYS_ATTACHEDTEMPLATE表的TEMPLATE_ID
    private String attachId; //对应T_SYS_COMMONATTACHED表的ATTACH_ID
    private String title;//附件名称
    private String remark;//备注
    private String creater;//创建者
    private String createrTime;//创建时间
    private String updatTime;//修改时间
    private String joinId;//附件Id
    private String fileName;//附件Id
    private String fieldId;//附件Id

    public String getUpdatTime() {
        return updatTime;
    }

    public void setUpdatTime(String updatTime) {
        this.updatTime = updatTime;
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

    public String getJoinId() {
        return joinId;
    }

    public void setJoinId(String joinId) {
        this.joinId = joinId;
    }

    public String getCreater() {
        return creater;
    }

    public void setCreater(String creater) {
        this.creater = creater;
    }

    public String getCreaterTime() {
        return createrTime;
    }

    public void setCreaterTime(String createrTime) {
        this.createrTime = createrTime;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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

    public String getDesignId() {
        return designId;
    }

    public void setDesignId(String designId) {
        this.designId = designId;
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
