package com.stripcode.mybatis.ps.model;

import com.stripcode.core.util.excelUtil.annotation.ExcelField;
import com.stripcode.mybatis.common.BaseModel;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Metro on 2016/12/19.
 */
public class PSPolicySupportImplementationModel extends BaseModel implements Serializable {
    private List<PSPolicySupportImplementation> psPolicySupportImplementationList;

    public List<PSPolicySupportImplementation> getPsPolicySupportImplementationList() {
        return psPolicySupportImplementationList;
    }

    public void setPsPolicySupportImplementationList(List<PSPolicySupportImplementation> psPolicySupportImplementationList) {
        this.psPolicySupportImplementationList = psPolicySupportImplementationList;
    }
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
    private String superiorCompany;
    private String erpCode;
    private String erpName;
    private String ppCode;
    private String cnSiteName;
    private String storeProperty;

    public String getOriginator() {
        return originator;
    }

    public void setOriginator(String originator) {
        this.originator = originator;
    }

    public String getRowId() {
        return rowId;
    }

    public void setRowId(String rowId) {
        this.rowId = rowId;
    }

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
    @ExcelField(title="支持项", align=1, sort=7)
    public String getSupportItem() {
        return supportItem;
    }

    public void setSupportItem(String supportItem) {
        this.supportItem = supportItem;
    }
    @ExcelField(title="支持方式", align=1, sort=8)
    public String getSupportMode() {
        return supportMode;
    }

    public void setSupportMode(String supportMode) {
        this.supportMode = supportMode;
    }
    @ExcelField(title="支持金额(元)", align=1, sort=9)
    public Double getSales() {
        return sales;
    }

    public void setSales(Double sales) {
        this.sales = sales;
    }
    @ExcelField(title="考核开始时间", align=1, sort=10)
    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }
    @ExcelField(title="考核结束时间", align=1, sort=11)
    public String getEndDate2() {
        return endDate2;
    }

    public void setEndDate2(String endDate2) {
        this.endDate2 = endDate2;
    }
    @ExcelField(title="考核指标", align=1, sort=12)
    public String getAssessmentItem() {
        return assessmentItem;
    }

    public void setAssessmentItem(String assessmentItem) {
        this.assessmentItem = assessmentItem;
    }
    @ExcelField(title="考核值", align=1, sort=13)
    public Double getTarget() {
        return target;
    }

    public void setTarget(Double target) {
        this.target = target;
    }
    @ExcelField(title="返款比例", align=1, sort=14)
    public String getReturnRatio() {
        return returnRatio;
    }

    public void setReturnRatio(String returnRatio) {
        this.returnRatio = returnRatio;
    }
    @ExcelField(title="返款金额", align=1, sort=15)
    public Double getReturnSales() {
        return returnSales;
    }

    public void setReturnSales(Double returnSales) {
        this.returnSales = returnSales;
    }
    @ExcelField(title="实际返款比例", align=1, sort=16)
    public Double getActualReturnSales() {
        return actualReturnSales;
    }

    public void setActualReturnSales(Double actualReturnSales) {
        this.actualReturnSales = actualReturnSales;
    }
    @ExcelField(title="实际返款金额", align=1, sort=17)
    public String getProcessingScheme() {
        return processingScheme;
    }

    public void setProcessingScheme(String processingScheme) {
        this.processingScheme = processingScheme;
    }
    @ExcelField(title="管辖单位", align=1, sort=1)
    public String getSuperiorCompany() {
        return superiorCompany;
    }

    public void setSuperiorCompany(String superiorCompany) {
        this.superiorCompany = superiorCompany;
    }
    @ExcelField(title="市场ID", align=1, sort=2)
    public String getErpCode() {
        return erpCode;
    }

    public void setErpCode(String erpCode) {
        this.erpCode = erpCode;
    }
    @ExcelField(title="市场名称", align=1, sort=3)
    public String getErpName() {
        return erpName;
    }

    public void setErpName(String erpName) {
        this.erpName = erpName;
    }
    @ExcelField(title="店铺ID", align=1, sort=4)
    public String getPpCode() {
        return ppCode;
    }

    public void setPpCode(String ppCode) {
        this.ppCode = ppCode;
    }
    @ExcelField(title="店铺名称", align=1, sort=5)
    public String getCnSiteName() {
        return cnSiteName;
    }

    public void setCnSiteName(String cnSiteName) {
        this.cnSiteName = cnSiteName;
    }
    @ExcelField(title="开店性质", align=1, sort=6)
    public String getStoreProperty() {
        return storeProperty;
    }

    public void setStoreProperty(String storeProperty) {
        this.storeProperty = storeProperty;
    }
}
