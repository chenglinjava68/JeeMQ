package com.stripcode.mybatis.cs.model;

import com.stripcode.core.annotation.Divide;
import com.stripcode.core.annotation.Multiply;
import com.stripcode.mybatis.common.BaseModel;

import java.io.Serializable;

/**
 * Created by wyd on 2016/9/14.
 */
public class CSPlanInvestment extends BaseModel implements Serializable{
    private String rowId;
    private String optimauthId;
    private Double investFunds; //首期投入资金
    private Integer costBack;//希望回收成本年数
    private String otherBrand;//是否经营其他休闲品牌
    private String remark;//备注
    private String delFlag;//删除标记
    private String taskId;//任务ID
    private String isFinished;//状态是否完成
    private Double mbMaxAchSales;
    private Double mktVolumeSales;
    private Double customerFunds;
    @Multiply(10000)
    public Double getCustomerFunds() {
        return customerFunds;
    }
    @Divide(10000)
    public void setCustomerFunds(Double customerFunds) {
        this.customerFunds = customerFunds;
    }
    @Multiply(10000)
    public Double getMbMaxAchSales() {
        return mbMaxAchSales;
    }
    @Divide(10000)
    public void setMbMaxAchSales(Double mbMaxAchSales) {
        this.mbMaxAchSales = mbMaxAchSales;
    }
    @Multiply(10000)
    public Double getMktVolumeSales() {
        return mktVolumeSales;
    }
    @Divide(10000)
    public void setMktVolumeSales(Double mktVolumeSales) {
        this.mktVolumeSales = mktVolumeSales;
    }

    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }

    public String getIsFinished() {
        return isFinished;
    }

    public void setIsFinished(String isFinished) {
        this.isFinished = isFinished;
    }

    public String getRowId() {
        return rowId;
    }

    public void setRowId(String rowId) {
        this.rowId = rowId;
    }

    @Override
    public String getDelFlag() {
        return delFlag;
    }

    @Override
    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getOtherBrand() {
        return otherBrand;
    }

    public void setOtherBrand(String otherBrand) {
        this.otherBrand = otherBrand;
    }
    public Integer getCostBack() {
        return costBack;
    }
    public void setCostBack(Integer costBack) {
        this.costBack = costBack;
    }
    @Multiply(10000)
    public Double getInvestFunds() {
        return investFunds;
    }
    @Divide(10000)
    public void setInvestFunds(Double investFunds) {
        this.investFunds = investFunds;
    }

    public String getOptimauthId() {
        return optimauthId;
    }

    public void setOptimauthId(String optimauthId) {
        this.optimauthId = optimauthId;
    }
}
