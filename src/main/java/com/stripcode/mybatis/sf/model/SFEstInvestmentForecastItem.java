package com.stripcode.mybatis.sf.model;

import com.stripcode.mybatis.common.BaseModel;

/**
 * @author Metro
 */
public class SFEstInvestmentForecastItem extends BaseModel {
    private String rowId;
    private String investmentId;
    private String item;
    private Double operationY1;
    private Double operationY3;
    private Double operationY5;

//    public SFEstInvestmentForecastItem(String investmentId, String item, Double operationY1, Double operationY3, Double operationY5) {
//        this.investmentId = investmentId;
//        this.item = item;
//        this.operationY1 = operationY1;
//        this.operationY3 = operationY3;
//        this.operationY5 = operationY5;
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

    public Double getOperationY1() {
        return operationY1;
    }

    public void setOperationY1(Double operationY1) {
        this.operationY1 = operationY1;
    }

    public Double getOperationY3() {
        return operationY3;
    }

    public void setOperationY3(Double operationY3) {
        this.operationY3 = operationY3;
    }

    public Double getOperationY5() {
        return operationY5;
    }

    public void setOperationY5(Double operationY5) {
        this.operationY5 = operationY5;
    }
}
