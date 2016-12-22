package com.stripcode.mybatis.cs.model;

/**
 * Created by Metro on 2016/9/9.
 * 用于查询市场传递数组和一个字符串
 */
public class CSErpMarketIds {
    private String [] marketIds;
    private String rowId;

    public String[] getMarketIds() {
        return marketIds;
    }

    public void setMarketIds(String[] marketIds) {
        this.marketIds = marketIds;
    }

    public String getRowId() {
        return rowId;
    }

    public void setRowId(String rowId) {
        this.rowId = rowId;
    }
}
