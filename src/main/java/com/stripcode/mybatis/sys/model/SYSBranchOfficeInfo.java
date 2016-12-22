package com.stripcode.mybatis.sys.model;

import com.stripcode.core.util.excelUtil.annotation.ExcelField;
import com.stripcode.mybatis.common.BaseModel;

import java.io.Serializable;

/**
 * Created by Metro on 2016/9/27.
 */
public class SYSBranchOfficeInfo extends BaseModel implements Serializable {
    private String rowId;   // 32位码
    private String branchesCode; //分公司编码
    private String branchesNameCn; //中文名称
    private String branchesNameEn; //英文名称
    private String brand;  //品牌
    private String operationDirector; //运营负责人
    private String directorPhone; //负责人电话
    private String address; //地址

    private String storeFront; //门店
    private String ppStore; // 意向店


    @Override
    public String getRowId() {
        return rowId;
    }

    @Override
    public void setRowId(String rowId) {
        this.rowId = rowId;
    }

    @ExcelField(title="分公司编码", align=1, sort=1)
    public String getBranchesCode() {
        return branchesCode;
    }

    public void setBranchesCode(String branchesCode) {
        this.branchesCode = branchesCode;
    }

    @ExcelField(title="分公司名称(中文)", align=1, sort=2)
    public String getBranchesNameCn() {
        return branchesNameCn;
    }

    public void setBranchesNameCn(String branchesNameCn) {
        this.branchesNameCn = branchesNameCn;
    }

    @ExcelField(title="分公司名称(英文)", align=1, sort=3)
    public String getBranchesNameEn() {
        return branchesNameEn;
    }

    public void setBranchesNameEn(String branchesNameEn) {
        this.branchesNameEn = branchesNameEn;
    }

    @ExcelField(title="品牌", align=1, sort=4)
    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    @ExcelField(title="门店", align=1, sort=5)
    public String getStoreFront() {
        return storeFront;
    }

    public void setStoreFront(String storeFront) {
        this.storeFront = storeFront;
    }

    @ExcelField(title="意向店", align=1, sort=6)
    public String getPpStore() {
        return ppStore;
    }

    public void setPpStore(String ppStore) {
        this.ppStore = ppStore;
    }

    @ExcelField(title="运营负责人", align=1, sort=7)
    public String getOperationDirector() {
        return operationDirector;
    }

    public void setOperationDirector(String operationDirector) {
        this.operationDirector = operationDirector;
    }

    public String getDirectorPhone() {
        return directorPhone;
    }

    public void setDirectorPhone(String directorPhone) {
        this.directorPhone = directorPhone;
    }

    @ExcelField(title="办公地址", align=1, sort=8)
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
