package com.stripcode.mybatis.sf.model;

import com.stripcode.mybatis.common.BaseModel;

/**
 * Created by Metro on 2016/10/18.
 */
public class SFDesignApplyDetail extends BaseModel{
    private String rowId;
    private String designId;//对应T_SF_DESIGN_APPLY表的ROW_ID
    private String item;//项目
    private String demand1;//需求1
    private String demand2;//需求2
    private String demand3;//需求3
    private String description;//说明

    public String getDemand1() {
        return demand1;
    }

    public void setDemand1(String demand1) {
        this.demand1 = demand1;
    }

    public String getDemand3() {
        return demand3;
    }

    public void setDemand3(String demand3) {
        this.demand3 = demand3;
    }

    public String getDemand2() {
        return demand2;
    }

    public void setDemand2(String demand2) {
        this.demand2 = demand2;
    }

    @Override
    public String getRowId() {
        return rowId;
    }

    @Override
    public void setRowId(String rowId) {
        this.rowId = rowId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public String getDesignId() {
        return designId;
    }

    public void setDesignId(String designId) {
        this.designId = designId;
    }
}
