package com.stripcode.mybatis.sf.model;

import com.stripcode.mybatis.common.BaseModel;
import com.stripcode.mybatis.cs.model.CSSfPipeline;

import java.util.List;

/**
 * Created by Metro on 2016/11/14.
 */
public class SFBudGet extends BaseModel{
    private String rowId;
    private String ppId;
    private String rmdCompany;//推荐公司名称
    private String consUnit;//施工单位公司
    private Double authCost;//工程造价审定金额
    private String isExceeded;//是否超概算金额
    private Double excessCostPct;//超出概算金额
    private String proMgr;//工程负责人
    private String proMgrContact;//工程负责人联系方式
    private String beginDate;//计划开始时间
    private String endDate;//计划开始时间
    private List<SFBudGetCost> budGetCostList;//工程预算列表
    private List<SFBudGetConsUnit> budGetConsUnitList;//施工单位
    private CSSfPipeline csSfPipeline;

    public CSSfPipeline getCsSfPipeline() {
        return csSfPipeline;
    }

    public void setCsSfPipeline(CSSfPipeline csSfPipeline) {
        this.csSfPipeline = csSfPipeline;
    }

    public List<SFBudGetConsUnit> getBudGetConsUnitList() {
        return budGetConsUnitList;
    }

    public void setBudGetConsUnitList(List<SFBudGetConsUnit> budGetConsUnitList) {
        this.budGetConsUnitList = budGetConsUnitList;
    }

    public List<SFBudGetCost> getBudGetCostList() {
        return budGetCostList;
    }

    public void setBudGetCostList(List<SFBudGetCost> budGetCostList) {
        this.budGetCostList = budGetCostList;
    }

    @Override
    public String getRowId() {
        return rowId;
    }

    @Override
    public void setRowId(String rowId) {
        this.rowId = rowId;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(String beginDate) {
        this.beginDate = beginDate;
    }

    public String getProMgrContact() {
        return proMgrContact;
    }

    public void setProMgrContact(String proMgrContact) {
        this.proMgrContact = proMgrContact;
    }

    public String getProMgr() {
        return proMgr;
    }

    public void setProMgr(String proMgr) {
        this.proMgr = proMgr;
    }

    public String getIsExceeded() {
        return isExceeded;
    }

    public void setIsExceeded(String isExceeded) {
        this.isExceeded = isExceeded;
    }

    public Double getAuthCost() {
        return authCost;
    }

    public void setAuthCost(Double authCost) {
        this.authCost = authCost;
    }

    public Double getExcessCostPct() {
        return excessCostPct;
    }

    public void setExcessCostPct(Double excessCostPct) {
        this.excessCostPct = excessCostPct;
    }

    public String getConsUnit() {
        return consUnit;
    }

    public void setConsUnit(String consUnit) {
        this.consUnit = consUnit;
    }

    public String getRmdCompany() {
        return rmdCompany;
    }

    public void setRmdCompany(String rmdCompany) {
        this.rmdCompany = rmdCompany;
    }

    public String getPpId() {
        return ppId;
    }

    public void setPpId(String ppId) {
        this.ppId = ppId;
    }
}
