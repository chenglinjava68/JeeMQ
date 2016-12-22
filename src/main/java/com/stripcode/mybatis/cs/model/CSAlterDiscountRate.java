package com.stripcode.mybatis.cs.model;


import com.stripcode.mybatis.common.BaseModel;

import java.io.Serializable;

/**
 * Created by Metro on 2016/8/25.
 */
public class CSAlterDiscountRate extends BaseModel implements Serializable {

    private String customerId; // 客户id

    private Double oldDiscountRate; //原基本折率

    private Double newDiscountRate; //新基本折率

    private String remark;  //备注

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public Double getOldDiscountRate() {
        return oldDiscountRate;
    }

    public void setOldDiscountRate(Double oldDiscountRate) {
        this.oldDiscountRate = oldDiscountRate;
    }

    public Double getNewDiscountRate() {
        return newDiscountRate;
    }

    public void setNewDiscountRate(Double newDiscountRate) {
        this.newDiscountRate = newDiscountRate;
    }

}
