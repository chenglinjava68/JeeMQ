package com.stripcode.mybatis.ps.model;

import com.stripcode.core.util.excelUtil.annotation.ExcelField;
import com.stripcode.mybatis.common.BaseModel;

import java.io.Serializable;

/**
 * Created by Metro on 2016/12/9.
 */
public class PSPolicySupportImplementation extends BaseModel implements Serializable{
    private String originator;
    private String rowId;//32位码
    private String checkId;//考核单号
    private String storeId;//店铺ID
    private String executiveTime;//执行时间
    private String supportItem;//支持项
    private String supportMode;//支持方式
    private Double sales;//支持金额
    private String startDate;//考核开始时间
    private String endDate2;//考核结束时间
    private String assessmentItem;//考核指标
    private Double target;//考核值
    private String returnRatio;//返款比例
    private Double returnSales;//返款金额
    private Double actualReturnSales;//实际返款金额
    private String processingScheme;//处理方案
    private String createrTime;
    private String updaterTime;
    private String superiorCompany;
    private String erpCode;
    private String erpName;
    private String ppCode;
    private String cnSiteName;
    private String storeProperty;

    public String getSuperiorCompany() {
        return superiorCompany;
    }

    public void setSuperiorCompany(String superiorCompany) {
        this.superiorCompany = superiorCompany;
    }

    public String getStoreProperty() {
        return storeProperty;
    }

    public void setStoreProperty(String storeProperty) {
        this.storeProperty = storeProperty;
    }

    public String getCnSiteName() {
        return cnSiteName;
    }

    public void setCnSiteName(String cnSiteName) {
        this.cnSiteName = cnSiteName;
    }

    public String getPpCode() {
        return ppCode;
    }

    public void setPpCode(String ppCode) {
        this.ppCode = ppCode;
    }

    public String getErpName() {
        return erpName;
    }

    public void setErpName(String erpName) {
        this.erpName = erpName;
    }

    public String getErpCode() {
        return erpCode;
    }

    public void setErpCode(String erpCode) {
        this.erpCode = erpCode;
    }

    @ExcelField(title="发起人", align=1, sort=3)
    public String getOriginator() {
        return originator;
    }

    public void setOriginator(String originator) {
        this.originator = originator;
    }

    @Override
    public String getRowId() {
        return rowId;
    }

    @Override
    public void setRowId(String rowId) {
        this.rowId = rowId;
    }
    @ExcelField(title="考核单号", align=1, sort=1)
    public String getCheckId() {
        return checkId;
    }

    public void setCheckId(String checkId) {
        this.checkId = checkId;
    }

    public String getStoreId() {
        return storeId;
    }

    public void setStoreId(String storeId) {
        this.storeId = storeId;
    }

    public String getExecutiveTime() {
        return executiveTime;
    }

    public void setExecutiveTime(String executiveTime) {
        this.executiveTime = executiveTime;
    }

    public String getSupportItem() {
        return supportItem;
    }

    public void setSupportItem(String supportItem) {
        this.supportItem = supportItem;
    }
    @ExcelField(title="政策支持方式", align=1, sort=2)
    public String getSupportMode() {
        return supportMode;
    }

    public void setSupportMode(String supportMode) {
        this.supportMode = supportMode;
    }

    public Double getSales() {
        return sales;
    }

    public void setSales(Double sales) {
        this.sales = sales;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate2() {
        return endDate2;
    }

    public void setEndDate2(String endDate2) {
        this.endDate2 = endDate2;
    }

    public String getAssessmentItem() {
        return assessmentItem;
    }

    public void setAssessmentItem(String assessmentItem) {
        this.assessmentItem = assessmentItem;
    }

    public Double getTarget() {
        return target;
    }

    public void setTarget(Double target) {
        this.target = target;
    }

    public String getReturnRatio() {
        return returnRatio;
    }

    public void setReturnRatio(String returnRatio) {
        this.returnRatio = returnRatio;
    }

    public Double getReturnSales() {
        return returnSales;
    }

    public void setReturnSales(Double returnSales) {
        this.returnSales = returnSales;
    }

    public Double getActualReturnSales() {
        return actualReturnSales;
    }

    public void setActualReturnSales(Double actualReturnSales) {
        this.actualReturnSales = actualReturnSales;
    }

    public String getProcessingScheme() {
        return processingScheme;
    }

    public void setProcessingScheme(String processingScheme) {
        this.processingScheme = processingScheme;
    }

    public String getCreaterTime() {
        return createrTime;
    }

    public void setCreaterTime(String createrTime) {
        this.createrTime = createrTime;
    }

    public String getUpdaterTime() {
        return updaterTime;
    }

    public void setUpdaterTime(String updaterTime) {
        this.updaterTime = updaterTime;
    }
}
