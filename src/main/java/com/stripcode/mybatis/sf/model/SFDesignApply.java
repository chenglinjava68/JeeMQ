package com.stripcode.mybatis.sf.model;

import com.stripcode.mybatis.common.BaseModel;
import com.stripcode.mybatis.cs.model.CSCustomerInfo;
import com.stripcode.mybatis.user.model.RscSysUser;

import java.util.List;

/**
 * Created by Metro on 2016/10/18.
 */
public class SFDesignApply extends BaseModel{
    private String rowId;
    private String ppId;//意向店ID
    private String isSignBoard;//是否可以加入刀牌
    private String facade;//外立面/店头的限制要求
    private String other;//其他
    private String remark;//备注
    private String attachId;
    private String designAssign;//设计派案人员
    private Double area; //总面积
    private Double operatingArea;//营运面积
    private Double backDepotArea;//后仓面积
    private RscSysUser rscSysUser; //系统用户
    private CSCustomerInfo csCustomerInfo; //客户实体
    private List<SFDesignApplyDetail> applyDetailList; //功能需求实体
    private String fileName;
    private String fieldId;
    public List<SFDesignApplyDetail> getApplyDetailList() {
        return applyDetailList;
    }

    public void setApplyDetailList(List<SFDesignApplyDetail> applyDetailList) {
        this.applyDetailList = applyDetailList;
    }

    public RscSysUser getRscSysUser() {
        return rscSysUser;
    }

    public void setRscSysUser(RscSysUser rscSysUser) {
        this.rscSysUser = rscSysUser;
    }

    public CSCustomerInfo getCsCustomerInfo() {
        return csCustomerInfo;
    }

    public void setCsCustomerInfo(CSCustomerInfo csCustomerInfo) {
        this.csCustomerInfo = csCustomerInfo;
    }

    private List<SFDesignApplyAttachment> listDesignApplyAttachment;
    public List<SFDesignApplyAttachment> getListDesignApplyAttachment() {
        return listDesignApplyAttachment;
    }

    public void setListDesignApplyAttachment(List<SFDesignApplyAttachment> listDesignApplyAttachment) {
        this.listDesignApplyAttachment = listDesignApplyAttachment;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFieldId() {
        return fieldId;
    }

    public void setFieldId(String fieldId) {
        this.fieldId = fieldId;
    }

    public Double getArea() {
        return area;
    }

    public void setArea(Double area) {
        this.area = area;
    }

    public Double getBackDepotArea() {
        return backDepotArea;
    }

    public void setBackDepotArea(Double backDepotArea) {
        this.backDepotArea = backDepotArea;
    }

    public Double getOperatingArea() {
        return operatingArea;
    }

    public void setOperatingArea(Double operatingArea) {
        this.operatingArea = operatingArea;
    }

    public String getAttachId() {
        return attachId;
    }

    public void setAttachId(String attachId) {
        this.attachId = attachId;
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

    public String getOther() {
        return other;
    }

    public void setOther(String other) {
        this.other = other;
    }

    public String getIsSignBoard() {
        return isSignBoard;
    }

    public void setIsSignBoard(String isSignBoard) {
        this.isSignBoard = isSignBoard;
    }

    public String getPpId() {
        return ppId;
    }

    public void setPpId(String ppId) {
        this.ppId = ppId;
    }

    public String getFacade() {
        return facade;
    }

    public void setFacade(String facade) {
        this.facade = facade;
    }

    public String getDesignAssign() {
        return designAssign;
    }

    public void setDesignAssign(String designAssign) {
        this.designAssign = designAssign;
    }
}
