package com.stripcode.mybatis.sf.model;

import com.stripcode.mybatis.common.BaseModel;

/**
 * @author Metro
 */
public class SFEstInvestmentCost extends BaseModel {
    private String rowId;
    private String investmentId;
    private String item;
    private String costTotal;

    public String getCostTotal() {
        return costTotal;
    }

    public void setCostTotal(String costTotal) {
        this.costTotal = costTotal;
    }

    public SFEstInvestmentCost(String rowId) {
        this.rowId = rowId;
    }
    public SFEstInvestmentCost() {
        this.rowId = rowId;
    }

    private Double cost;
    private String itemCode;
    private String itemName;

//    public SFEstInvestmentCost(String investmentId, String item, Double cost) {
//        this.investmentId = investmentId;
//        this.item = item;
//        this.cost = cost;
//    }

    @Override
    public String getRowId() {
        return rowId;
    }

    @Override
    public void setRowId(String rowId) {
        this.rowId = rowId;
    }

    public String getInvestmentId() {
        return investmentId;
    }

    public void setInvestmentId(String investmentId) {
        this.investmentId = investmentId;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }
}
