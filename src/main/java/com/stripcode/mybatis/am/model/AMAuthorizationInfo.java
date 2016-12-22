package com.stripcode.mybatis.am.model;

import com.stripcode.mybatis.common.BaseModel;

/**店铺授权书附件实体类
 * Created by Metro on 2016/10/20.
 */
public class AMAuthorizationInfo extends BaseModel {
    private String rowId;
    private String storeId;
    private String attachId;
    private String accreditStartDate;
    private String accreditEndDate;
    private String uploadDate;


    private String title;
    private String fileName;
    private String  fieldId;


    public String getUploadDate() {
        return uploadDate;
    }

    public void setUploadDate(String uploadDate) {
        this.uploadDate = uploadDate;
    }

    @Override
    public String getRowId() {
        return rowId;
    }

    @Override
    public void setRowId(String rowId) {
        this.rowId = rowId;
    }

    public String getStoreId() {
        return storeId;
    }

    public void setStoreId(String storeId) {
        this.storeId = storeId;
    }

    public String getAttachId() {
        return attachId;
    }

    public void setAttachId(String attachId) {
        this.attachId = attachId;
    }

    public String getAccreditStartDate() {
        return accreditStartDate;
    }

    public void setAccreditStartDate(String accreditStartDate) {
        this.accreditStartDate = accreditStartDate;
    }

    public String getAccreditEndDate() {
        return accreditEndDate;
    }

    public void setAccreditEndDate(String accreditEndDate) {
        this.accreditEndDate = accreditEndDate;
    }

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

    public String getFieldId() {
        return fieldId;
    }

    public void setFieldId(String fieldId) {
        this.fieldId = fieldId;
    }
}
