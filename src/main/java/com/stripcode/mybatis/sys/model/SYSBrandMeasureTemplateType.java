package com.stripcode.mybatis.sys.model;

import com.stripcode.mybatis.common.BaseModel;

/**
 * @author Metro
 */
public class SYSBrandMeasureTemplateType extends BaseModel {
    private String rowId;
    private String optimizedType;
    private String brand;
    private String modelType;

    @Override
    public String getRowId() {
        return rowId;
    }

    @Override
    public void setRowId(String rowId) {
        this.rowId = rowId;
    }

    public String getOptimizedType() {
        return optimizedType;
    }

    public void setOptimizedType(String optimizedType) {
        this.optimizedType = optimizedType;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModelType() {
        return modelType;
    }

    public void setModelType(String modelType) {
        this.modelType = modelType;
    }
}
