package com.stripcode.mybatis.sf.model;

import com.stripcode.mybatis.common.BaseModel;

/**
 * Created by Metro on 2016/11/14.
 */
public class SFBudGetCost extends BaseModel{
    private String rowId;
    private String budgetId;//对应T_SF_BUDGET表的ROW_ID
    private String itemCode;//项目编码
    private Double estCost;//工程概算
    private Double budgetCost;//工程预算
    private String costCls;//分类成本
    private String itemName;//项目
    private String isEdit;
    private String otherName;

    public String getOtherName() {
        return otherName;
    }

    public void setOtherName(String otherName) {
        this.otherName = otherName;
    }

    public String getIsEdit() {
        return isEdit;
    }

    public void setIsEdit(String isEdit) {
        this.isEdit = isEdit;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getCostCls() {
        return costCls;
    }

    public void setCostCls(String costCls) {
        this.costCls = costCls;
    }

    @Override
    public String getRowId() {
        return rowId;
    }

    @Override
    public void setRowId(String rowId) {
        this.rowId = rowId;
    }

    public Double getEstCost() {
        return estCost;
    }

    public void setEstCost(Double estCost) {
        this.estCost = estCost;
    }

    public Double getBudgetCost() {
        return budgetCost;
    }

    public void setBudgetCost(Double budgetCost) {
        this.budgetCost = budgetCost;
    }

    public String getBudgetId() {
        return budgetId;
    }

    public void setBudgetId(String budgetId) {
        this.budgetId = budgetId;
    }

    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }
}
