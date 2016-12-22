package com.stripcode.mybatis.sf.model;

import com.stripcode.core.annotation.Divide;
import com.stripcode.core.annotation.Multiply;
import com.stripcode.mybatis.common.BaseModel;

/**
 * @author Metro
 */
public class SFRentInfo extends BaseModel {
    private String rowId;
    private String ppId;
    private String proName;
    private String openDate;
    private Double rental;
    private Double salesMth;
    private Double salesYear;
    private Double lgEffect;
    private String area;
    private Double leaseMonth;
    private String remark;
    @Multiply(10000)
    public Double getLgEffect() {
        return lgEffect;
    }
    @Divide(10000)
    public void setLgEffect(Double lgEffect) {
        this.lgEffect = lgEffect;
    }
    @Multiply(10000)
    public Double getSalesYear() {
        return salesYear;
    }
    @Divide(10000)
    public void setSalesYear(Double salesYear) {
        this.salesYear = salesYear;
    }
    @Multiply(10000)
    public Double getSalesMth() {
        return salesMth;
    }
    @Divide(10000)
    public void setSalesMth(Double salesMth) {
        this.salesMth = salesMth;
    }

    public String getProName() {
        return proName;
    }

    public void setProName(String proName) {
        this.proName = proName;
    }

    @Override
    public String getRowId() {
        return rowId;
    }

    @Override
    public void setRowId(String rowId) {
        this.rowId = rowId;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getOpenDate() {
        return openDate;
    }

    public void setOpenDate(String openDate) {
        this.openDate = openDate;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public Double getRental() {
        return rental;
    }

    public void setRental(Double rental) {
        this.rental = rental;
    }

    public Double getLeaseMonth() {
        return leaseMonth;
    }

    public void setLeaseMonth(Double leaseMonth) {
        this.leaseMonth = leaseMonth;
    }

    public String getPpId() {
        return ppId;
    }

    public void setPpId(String ppId) {
        this.ppId = ppId;
    }
}
