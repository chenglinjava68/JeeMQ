package com.stripcode.mybatis.sf.model;

import com.stripcode.core.util.excelUtil.annotation.ExcelField;
import com.stripcode.mybatis.common.BaseModel;
import com.stripcode.mybatis.ps.model.PSPolicySupportImplementation;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Metro on 2016/10/24.
 */
public class SFPolicySupportAssessment extends BaseModel implements Serializable{
    private String [] ppIds;
    private String [] rowIds;
    private String rowId;//32位码
    private String ppId;//意向店ID
    private String psAssId;//对应T_SF_POLICY_SUPPORT_DETAIL表的ROW_ID
    private String supportItem;//支持项
    private String supportMode;//支持方式
    private Double sales;//支持金额
    private Integer operateYear;//经营年限
    private String startDate;//考核开始时间
    private String endDate;//考核结束时间
    private String assessmentItem;//考核指标
    private Double target;//考核值
    private String returnRatio;//返款比例
    private Double returnSales;//返款金额
    private String creator;//创建者
    private String createTime1;//创建时间
    private String updater;//更新者
    private String updateTime1;//更新时间
    private String superiorCompany;
    private String erpCode;
    private String erpName;
    private String ppCode;
    private String cnSiteName;
    private String storeProperty;
    private List<PSPolicySupportImplementation> psPolicySupportImplementationList;

    public List<PSPolicySupportImplementation> getPsPolicySupportImplementationList() {
        return psPolicySupportImplementationList;
    }

    public void setPsPolicySupportImplementationList(List<PSPolicySupportImplementation> psPolicySupportImplementationList) {
        this.psPolicySupportImplementationList = psPolicySupportImplementationList;
    }

    public String[] getRowIds() {
        return rowIds;
    }

    public void setRowIds(String[] rowIds) {
        this.rowIds = rowIds;
    }

    public String[] getPpIds() {
        return ppIds;
    }

    public void setPpIds(String[] ppIds) {
        this.ppIds = ppIds;
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

    private List<SFPolicySupportAssessment> sfPolicySupportAssessment;

    public List<SFPolicySupportAssessment> getSfPolicySupportAssessment() {
        return sfPolicySupportAssessment;
    }

    public void setSfPolicySupportAssessment(List<SFPolicySupportAssessment> sfPolicySupportAssessment) {
        this.sfPolicySupportAssessment = sfPolicySupportAssessment;
    }

    public String getPsAssId() {
        return psAssId;
    }

    public void setPsAssId(String psAssId) {
        this.psAssId = psAssId;
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

    public String getCreateTime1() {
        return createTime1;
    }

    public void setCreateTime1(String createTime1) {
        this.createTime1 = createTime1;
    }

    public String getUpdateTime1() {
        return updateTime1;
    }

    public void setUpdateTime1(String updateTime1) {
        this.updateTime1 = updateTime1;
    }

    @Override
    public String getRowId() {
        return rowId;
    }

    @Override
    public void setRowId(String rowId) {
        this.rowId = rowId;
    }

    public String getPpId() {
        return ppId;
    }

    public void setPpId(String ppId) {
        this.ppId = ppId;
    }


    @ExcelField(title="支持金额", align=3, sort=9)
    public Double getSales() {
        return sales;
    }

    public void setSales(Double sales) {
        this.sales = sales;
    }

    public Integer getOperateYear() {
        return operateYear;
    }

    public void setOperateYear(Integer operateYear) {
        this.operateYear = operateYear;
    }
    @ExcelField(title="考核开始时间", align=1, sort=10)
    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }
    @ExcelField(title="考核结束时间", align=1, sort=11)
    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
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

    @Override
    public String getCreator() {
        return creator;
    }

    @Override
    public void setCreator(String creator) {
        this.creator = creator;
    }



    @Override
    public String getUpdater() {
        return updater;
    }

    @Override
    public void setUpdater(String updater) {
        this.updater = updater;
    }


}
