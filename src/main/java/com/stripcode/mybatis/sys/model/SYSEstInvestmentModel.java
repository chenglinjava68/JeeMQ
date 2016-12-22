package com.stripcode.mybatis.sys.model;

import com.stripcode.core.util.excelUtil.annotation.ExcelField;
import com.stripcode.mybatis.common.BaseModel;

import java.io.Serializable;

/**
 * Created by Metro on 2016/10/25.
 */
public class SYSEstInvestmentModel extends BaseModel implements Serializable {
    private String rowId;//ROW_ID
    private String brand;//品牌
    private String year;//年份
    private String modelType;//模板类型
    private String modelVersion;//版本
    private String modelStatus;//状态
    private String attachId;//附件
    private String creator;//创建者
    private String createTime1;//创建时间
    private String updater;//更新者
    private String updateTime1;//更新时间
    private String fileName;
    private String fieldId;

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

    @Override
    public String getRowId() {
        return rowId;
    }

    @Override
    public void setRowId(String rowId) {
        this.rowId = rowId;
    }
    @ExcelField(title="品牌", align=1, sort=1)
    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }
    @ExcelField(title="年份", align=3, sort=2)
    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }
    @ExcelField(title="模板类型", align=1, sort=3)
    public String getModelType() {
        return modelType;
    }

    public void setModelType(String modelType) {
        this.modelType = modelType;
    }
    @ExcelField(title="版本", align=1, sort=4)
    public String getModelVersion() {
        return modelVersion;
    }

    public void setModelVersion(String modelVersion) {
        this.modelVersion = modelVersion;
    }
    @ExcelField(title="状态", align=1, sort=5)
    public String getModelStatus() {
        return modelStatus;
    }

    public void setModelStatus(String modelStatus) {
        this.modelStatus = modelStatus;
    }

    public String getAttachId() {
        return attachId;
    }

    public void setAttachId(String attachId) {
        this.attachId = attachId;
    }

    @Override
    public String getCreator() {
        return creator;
    }

    @Override
    public void setCreator(String creator) {
        this.creator = creator;
    }

    public String getCreateTime1() {
        return createTime1;
    }

    public void setCreateTime1(String createTime1) {
        this.createTime1 = createTime1;
    }

    @Override
    public String getUpdater() {
        return updater;
    }

    @Override
    public void setUpdater(String updater) {
        this.updater = updater;
    }

    public String getUpdateTime1() {
        return updateTime1;
    }

    public void setUpdateTime1(String updateTime1) {
        this.updateTime1 = updateTime1;
    }
}
