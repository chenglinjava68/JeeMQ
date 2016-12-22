package com.stripcode.mybatis.sf.model;

import com.stripcode.core.annotation.Divide;
import com.stripcode.core.annotation.Multiply;
import com.stripcode.mybatis.common.BaseModel;

import java.util.List;

/**
 * @author Metro
 */
public class SFEstInvestment extends BaseModel {
    private String rowId;
    private String ppId;
    private String modelType;
    private String modelName;
    private String modelVersion;
    private String reportFlag;
    private Double irr;
    private Double calbackYear;
    private Double uc;
    private Double firstUcPer;
    private Double secondUcPer;
    private Double thirdUcPer;
    private Double companyUc1;
    private Double companyUc2;
    private Double companyUc3;
    private Double companyUc4;
    private Double companyUc5;
    private String attachId;
    private String remark;

    private String fileName;
    private String filePath;

    private List<SFEstInvestmentDetail> details;
    private SFEstInvestmentResultData resultData;
    @Multiply(10000)
    public Double getCompanyUc1() {
        return companyUc1;
    }
    @Divide(10000)
    public void setCompanyUc1(Double companyUc1) {
        this.companyUc1 = companyUc1;
    }
    @Multiply(10000)
    public Double getCompanyUc2() {
        return companyUc2;
    }
    @Divide(10000)
    public void setCompanyUc2(Double companyUc2) {
        this.companyUc2 = companyUc2;
    }
    @Multiply(10000)
    public Double getCompanyUc3() {
        return companyUc3;
    }
    @Divide(10000)
    public void setCompanyUc3(Double companyUc3) {
        this.companyUc3 = companyUc3;
    }
    @Multiply(10000)
    public Double getCompanyUc4() {
        return companyUc4;
    }
    @Divide(10000)
    public void setCompanyUc4(Double companyUc4) {
        this.companyUc4 = companyUc4;
    }
    @Multiply(10000)
    public Double getCompanyUc5() {
        return companyUc5;
    }
    @Divide(10000)
    public void setCompanyUc5(Double companyUc5) {
        this.companyUc5 = companyUc5;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public List<SFEstInvestmentDetail> getDetails() {
        return details;
    }

    public void setDetails(List<SFEstInvestmentDetail> details) {
        this.details = details;
    }

    public SFEstInvestmentResultData getResultData() {
        return resultData;
    }

    public void setResultData(SFEstInvestmentResultData resultData) {
        this.resultData = resultData;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
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

    public String getModelType() {
        return modelType;
    }

    public void setModelType(String modelType) {
        this.modelType = modelType;
    }

    public String getModelVersion() {
        return modelVersion;
    }

    public void setModelVersion(String modelVersion) {
        this.modelVersion = modelVersion;
    }

    public String getReportFlag() {
        return reportFlag;
    }

    public void setReportFlag(String reportFlag) {
        this.reportFlag = reportFlag;
    }

    public Double getIrr() {
        return irr;
    }

    public void setIrr(Double irr) {
        this.irr = irr;
    }
    
    public Double getCalbackYear() {
        return calbackYear;
    }

    public void setCalbackYear(Double calbackYear) {
        this.calbackYear = calbackYear;
    }

    public Double getUc() {
        return uc;
    }

    public void setUc(Double uc) {
        this.uc = uc;
    }

    public Double getFirstUcPer() {
        return firstUcPer;
    }

    public void setFirstUcPer(Double firstUcPer) {
        this.firstUcPer = firstUcPer;
    }

    public Double getSecondUcPer() {
        return secondUcPer;
    }

    public void setSecondUcPer(Double secondUcPer) {
        this.secondUcPer = secondUcPer;
    }

    public Double getThirdUcPer() {
        return thirdUcPer;
    }

    public void setThirdUcPer(Double thirdUcPer) {
        this.thirdUcPer = thirdUcPer;
    }

    public String getAttachId() {
        return attachId;
    }

    public void setAttachId(String attachId) {
        this.attachId = attachId;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
