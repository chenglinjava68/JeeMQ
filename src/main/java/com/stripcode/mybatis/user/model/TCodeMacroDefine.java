package com.stripcode.mybatis.user.model;

import com.stripcode.mybatis.common.BaseModel;

import java.io.Serializable;

/**
 * Created by wangyudong on 2016/9/18.
 */
public class TCodeMacroDefine extends BaseModel implements Serializable{
    private String rowId;
    private String macroNo;//排序号
    private String macroCode;//编码
    private String macroName;//名称
    private String macroNameEn;//英文名称
    private String comments;//备注
    private String macroType;//类型
    private String macroTypeName;//类型名称
    private String parentCode;//上级编号
    private String mnemoniCcode;//助记码
    private String status;//状态
    private String delFlag;//删除标示

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getRowId() {
        return rowId;
    }

    public void setRowId(String rowId) {
        this.rowId = rowId;
    }

    public String getMnemoniCcode() {
        return mnemoniCcode;
    }

    public void setMnemoniCcode(String mnemoniCcode) {
        this.mnemoniCcode = mnemoniCcode;
    }

    @Override
    public String getDelFlag() {
        return delFlag;
    }

    @Override
    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag;
    }

    public String getParentCode() {
        return parentCode;
    }

    public void setParentCode(String parentCode) {
        this.parentCode = parentCode;
    }

    public String getMacroTypeName() {
        return macroTypeName;
    }

    public void setMacroTypeName(String macroTypeName) {
        this.macroTypeName = macroTypeName;
    }

    public String getMacroType() {
        return macroType;
    }

    public void setMacroType(String macroType) {
        this.macroType = macroType;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public String getMacroNameEn() {
        return macroNameEn;
    }

    public void setMacroNameEn(String macroNameEn) {
        this.macroNameEn = macroNameEn;
    }

    public String getMacroName() {
        return macroName;
    }

    public void setMacroName(String macroName) {
        this.macroName = macroName;
    }

    public String getMacroCode() {
        return macroCode;
    }

    public void setMacroCode(String macroCode) {
        this.macroCode = macroCode;
    }

    public String getMacroNo() {
        return macroNo;
    }

    public void setMacroNo(String macroNo) {
        this.macroNo = macroNo;
    }
}
