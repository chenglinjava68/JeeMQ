package com.stripcode.mybatis.sf.model;

import com.stripcode.mybatis.common.BaseModel;

import java.text.SimpleDateFormat;

/**
 * @author Metro
 */
public class SFStoreHandoverAttachment extends BaseModel{
    private String rowId;
    private String handoverId;
    private String templateId;
    private String attachId;

    private String fileName;
    private String filePath;
    private String creatorTime;
    private String creatorName;
    private String updaterName;
    private String updaterTime;
    private String title;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public String getCreatorTime() {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        try {
            creatorTime = format.format(format.parse(creatorTime));
        }catch (Exception e){
            e.printStackTrace();
        }
        return creatorTime;
    }

    public void setCreatorTime(String creatorTime) {
        this.creatorTime = creatorTime;
    }

    public String getCreatorName() {
        return creatorName;
    }

    public void setCreatorName(String creatorName) {
        this.creatorName = creatorName;
    }

    public String getUpdaterName() {
        return updaterName;
    }

    public void setUpdaterName(String updaterName) {
        this.updaterName = updaterName;
    }

    public String getUpdaterTime() {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        try {
            updaterTime = format.format(format.parse(updaterTime));
        }catch (Exception e){
            e.printStackTrace();
        }
        return updaterTime;
    }

    public void setUpdaterTime(String updaterTime) {
        this.updaterTime = updaterTime;
    }

    @Override
    public String getRowId() {
        return rowId;
    }

    @Override
    public void setRowId(String rowId) {
        this.rowId = rowId;
    }

    public String getHandoverId() {
        return handoverId;
    }

    public void setHandoverId(String handoverId) {
        this.handoverId = handoverId;
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
