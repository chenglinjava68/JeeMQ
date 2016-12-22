package com.stripcode.mybatis.sf.model;

import com.stripcode.mybatis.common.BaseModel;
import com.stripcode.mybatis.cs.model.CSSfPipeline;

import java.util.List;

/**
 * Created by Metro on 2016/12/6.
 */
public class SFFinalAccounts extends BaseModel {
    private String rowId;
    private String ppId;
    private Double finalCost;//本次决算审定金
    private String isContainUtilities;//是否包含施工水电费
    private String isContainExceededEstCost;//是否包含超概算金额
    private String isExceeded;//是否超概算金额
    private Double excessCostPct;//超概算金额
    private String costAuditDate;//造价审核人-审核日期
    private String auditPerson;//造价审核人-审核日期
    private String isAgree;//是否同意
    private String consAuditDate;//工程造价意见-审核日期
    private String reason;//理由
    private Double contractCost;//合同金额
    private List<SFBudGetConsUnit> budGetConsUnitList;//施工单位
    private List<SFFinalAccountsCost> finalAccountsCostList;//决算集合
    private CSSfPipeline csSfPipeline;

    public List<SFBudGetConsUnit> getBudGetConsUnitList() {
        return budGetConsUnitList;
    }

    public void setBudGetConsUnitList(List<SFBudGetConsUnit> budGetConsUnitList) {
        this.budGetConsUnitList = budGetConsUnitList;
    }

    public List<SFFinalAccountsCost> getFinalAccountsCostList() {
        return finalAccountsCostList;
    }

    public void setFinalAccountsCostList(List<SFFinalAccountsCost> finalAccountsCostList) {
        this.finalAccountsCostList = finalAccountsCostList;
    }

    public CSSfPipeline getCsSfPipeline() {
        return csSfPipeline;
    }

    public void setCsSfPipeline(CSSfPipeline csSfPipeline) {
        this.csSfPipeline = csSfPipeline;
    }

    @Override
    public String getRowId() {
        return rowId;
    }

    @Override
    public void setRowId(String rowId) {
        this.rowId = rowId;
    }

    public Double getExcessCostPct() {
        return excessCostPct;
    }

    public void setExcessCostPct(Double excessCostPct) {
        this.excessCostPct = excessCostPct;
    }

    public String getIsExceeded() {
        return isExceeded;
    }

    public void setIsExceeded(String isExceeded) {
        this.isExceeded = isExceeded;
    }

    public String getIsContainExceededEstCost() {
        return isContainExceededEstCost;
    }

    public void setIsContainExceededEstCost(String isContainExceededEstCost) {
        this.isContainExceededEstCost = isContainExceededEstCost;
    }

    public String getIsContainUtilities() {
        return isContainUtilities;
    }

    public void setIsContainUtilities(String isContainUtilities) {
        this.isContainUtilities = isContainUtilities;
    }

    public String getPpId() {
        return ppId;
    }

    public void setPpId(String ppId) {
        this.ppId = ppId;
    }

    public String getCostAuditDate() {
        return costAuditDate;
    }

    public void setCostAuditDate(String costAuditDate) {
        this.costAuditDate = costAuditDate;
    }

    public String getAuditPerson() {
        return auditPerson;
    }

    public void setAuditPerson(String auditPerson) {
        this.auditPerson = auditPerson;
    }

    public String getIsAgree() {
        return isAgree;
    }

    public void setIsAgree(String isAgree) {
        this.isAgree = isAgree;
    }

    public String getConsAuditDate() {
        return consAuditDate;
    }

    public void setConsAuditDate(String consAuditDate) {
        this.consAuditDate = consAuditDate;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public Double getFinalCost() {
        return finalCost;
    }

    public void setFinalCost(Double finalCost) {
        this.finalCost = finalCost;
    }

    public Double getContractCost() {
        return contractCost;
    }

    public void setContractCost(Double contractCost) {
        this.contractCost = contractCost;
    }
}
