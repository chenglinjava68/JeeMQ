package com.stripcode.mybatis.cs.model;

import com.stripcode.mybatis.common.BaseModel;

/**
 *@author Metro
 */
public class TSysAttachedTemplate extends BaseModel {
    private String templateId;
    private String pageId;
    private String title;
    private String synMethod;
    private String comments;
    private String fileType;

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    private String joinId;
    private String sortNo;
    private String fileName;
    private String source;
    private String canPreview;
    private String canUpload;
    private String canDownLoad;
    private String canDelete;
    private String taskCheck;
    private String canView;
    private String viewType;
    private String viewFunction;
    private String  fieldId;

    public String getFieldId() {
        return fieldId;
    }

    public void setFieldId(String fieldId) {
        this.fieldId = fieldId;
    }

    private String creater;

    public String getCreater() {
        return creater;
    }

    public void setCreater(String creater) {
        this.creater = creater;
    }

    public String getCanDownLoad() {
        return canDownLoad;
    }

    public void setCanDownLoad(String canDownLoad) {
        this.canDownLoad = canDownLoad;
    }

    public String getCanDelete() {
        return canDelete;
    }

    public void setCanDelete(String canDelete) {
        this.canDelete = canDelete;
    }

    public String getTemplateId() {
        return templateId;
    }

    public void setTemplateId(String templateId) {
        this.templateId = templateId;
    }

    public String getPageId() {
        return pageId;
    }

    public void setPageId(String pageId) {
        this.pageId = pageId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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

    public String getTaskCheck() {
        return taskCheck;
    }

    public void setTaskCheck(String taskCheck) {
        this.taskCheck = taskCheck;
    }

    public String getCanView() {
        return canView;
    }

    public void setCanView(String canView) {
        this.canView = canView;
    }

    public String getViewType() {
        return viewType;
    }

    public void setViewType(String viewType) {
        this.viewType = viewType;
    }

    public String getViewFunction() {
        return viewFunction;
    }

    public void setViewFunction(String viewFunction) {
        this.viewFunction = viewFunction;
    }
}
