package com.stripcode.mybatis.cs.model;

import com.stripcode.mybatis.common.BaseModel;

import java.io.Serializable;

/**
 * Created by Metro on 2016/9/14.
 */
public class CSSysAttachedTemplate extends BaseModel implements Serializable{
    private String templateId; //模板ID
    private String pageId;//页面ID
    private String title;//附件标题
    private String synMethod;
    private String comments; //备注
    private String fileType;//文件类型
    private String joinId;
    private String sortNo;//排序号
    private String source;
    private String storeType;
    private String canPreview;//是否可以预览
    private String canUpload;//是否可以上传
    private String canDownload;//是否可以下载
    private String canDelete;//是否可以删除
    private String taskCheck;//是否可以打勾
    private String creater;//创建者
    private String  createrTime;//创建时间
    private String updatTime;
    private String  fileName;//
    private String  fieldId;//
    private String  attachId;

    public String getUpdatTime() {
        return updatTime;
    }

    public void setUpdatTime(String updatTime) {
        this.updatTime = updatTime;
    }

    public String getAttachId() {
        return attachId;
    }

    public void setAttachId(String attachId) {
        this.attachId = attachId;
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

    public String getTemplateId() {
        return templateId;
    }

    public void setTemplateId(String templateId) {
        this.templateId = templateId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPageId() {
        return pageId;
    }

    public void setPageId(String pageId) {
        this.pageId = pageId;
    }

    public String getSynMethod() {
        return synMethod;
    }

    public void setSynMethod(String synMethod) {
        this.synMethod = synMethod;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    public String getJoinId() {
        return joinId;
    }

    public void setJoinId(String joinId) {
        this.joinId = joinId;
    }

    public String getSortNo() {
        return sortNo;
    }

    public void setSortNo(String sortNo) {
        this.sortNo = sortNo;
    }

    public String getStoreType() {
        return storeType;
    }

    public void setStoreType(String storeType) {
        this.storeType = storeType;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getCanPreview() {
        return canPreview;
    }

    public void setCanPreview(String canPreview) {
        this.canPreview = canPreview;
    }

    public String getCanUpload() {
        return canUpload;
    }

    public void setCanUpload(String canUpload) {
        this.canUpload = canUpload;
    }

    public String getCanDelete() {
        return canDelete;
    }

    public void setCanDelete(String canDelete) {
        this.canDelete = canDelete;
    }

    public String getCanDownload() {
        return canDownload;
    }

    public void setCanDownload(String canDownload) {
        this.canDownload = canDownload;
    }

    public String getTaskCheck() {
        return taskCheck;
    }

    public void setTaskCheck(String taskCheck) {
        this.taskCheck = taskCheck;
    }
}
