package com.stripcode.mybatis.sf.model;

import com.stripcode.core.annotation.Divide;
import com.stripcode.core.annotation.Multiply;
import com.stripcode.mybatis.common.BaseModel;
import com.stripcode.mybatis.cs.model.CSCustomerInfo;

/**
 * Created by Metro on 2016/9/28.
 */
public class SFRentalProposal extends BaseModel{
    private String rowId;
    private String ppId;
    private String rentStartDate;//租赁起始日
    private String rentEndDate;//租赁结束日
    private Double rental;//年租金(万)
    private Double points;//扣点
    private String rentMode;//物业性质
    private String relation;//承租房和客户的关系
    private CSCustomerInfo csCustomerInfo;

    public String getRelation() {
        return relation;
    }

    public void setRelation(String relation) {
        this.relation = relation;
    }

    public String getRentMode() {
        return rentMode;
    }

    public void setRentMode(String rentMode) {
        this.rentMode = rentMode;
    }

    public CSCustomerInfo getCsCustomerInfo() {
        return csCustomerInfo;
    }

    public void setCsCustomerInfo(CSCustomerInfo csCustomerInfo) {
        this.csCustomerInfo = csCustomerInfo;
    }

    @Override
    public String getRowId() {
        return rowId;
    }

    @Override
    public void setRowId(String rowId) {
        this.rowId = rowId;
    }

    public Double getPoints() {
        return points;
    }

    public void setPoints(Double points) {
        this.points = points;
    }
    @Multiply(10000)
    public Double getRental() {
        return rental;
    }
    @Divide(10000)
    public void setRental(Double rental) {
        this.rental = rental;
    }

    public String getRentEndDate() {
        return rentEndDate;
    }

    public void setRentEndDate(String rentEndDate) {
        this.rentEndDate = rentEndDate;
    }

    public String getPpId() {
        return ppId;
    }

    public void setPpId(String ppId) {
        this.ppId = ppId;
    }

    public String getRentStartDate() {
        return rentStartDate;
    }

    public void setRentStartDate(String rentStartDate) {
        this.rentStartDate = rentStartDate;
    }
}
