package com.stripcode.mybatis.am.model;

import com.stripcode.mybatis.common.BaseModel;

/**店铺政策支持信息表
 * Created by Metro on 2016/12/14.
 */
public class AMPolicySupport extends BaseModel {
    private String storeId;//店铺ID
    private String supportItem;//支持项
    private String supportMode;//支持方式
    private Double price;//单价
    private String checkTarget;//考核指标
    private int operationTerm;//经营年限
    private Double checkValue;//考核值
    private Double money;//金额

    public String getStoreId() {
        return storeId;
    }

    public void setStoreId(String storeId) {
        this.storeId = storeId;
    }

    public String getSupportItem() {
        return supportItem;
    }

    public void setSupportItem(String supportItem) {
        this.supportItem = supportItem;
    }

    public String getSupportMode() {
        return supportMode;
    }

    public void setSupportMode(String supportMode) {
        this.supportMode = supportMode;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getCheckTarget() {
        return checkTarget;
    }

    public void setCheckTarget(String checkTarget) {
        this.checkTarget = checkTarget;
    }

    public int getOperationTerm() {
        return operationTerm;
    }

    public void setOperationTerm(int operationTerm) {
        this.operationTerm = operationTerm;
    }

    public Double getCheckValue() {
        return checkValue;
    }

    public void setCheckValue(Double checkValue) {
        this.checkValue = checkValue;
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }
}
