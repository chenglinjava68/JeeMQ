package com.stripcode.mybatis.sf.model;

import com.stripcode.mybatis.common.BaseModel;

/**
 * Created by Metro on 2016/11/17.
 */
public class SFLandlordInterest extends BaseModel {
    private String rowId;
    private String ppId;//意向店ID
    private String llInterest;//业主是否愿意合作
    private String recordDate;//记录日期
    private String remark;//备注


    public String getRowId() {
        return rowId;
    }


    public void setRowId(String rowId) {
        this.rowId = rowId;
    }

    public String getPpId() {
        return ppId;
    }

    public void setPpId(String ppId) {
        this.ppId = ppId;
    }

    public String getLlInterest() {
        return llInterest;
    }

    public void setLlInterest(String llInterest) {
        this.llInterest = llInterest;
    }

    public String getRecordDate() {
        return recordDate;
    }

    public void setRecordDate(String recordDate) {
        this.recordDate = recordDate;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
