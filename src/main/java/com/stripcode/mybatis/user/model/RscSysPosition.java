package com.stripcode.mybatis.user.model;

import com.stripcode.core.util.excelUtil.annotation.ExcelField;
import com.stripcode.mybatis.common.BaseModel;

import java.util.List;

public class RscSysPosition extends BaseModel {

    private String positionid;

    private String userid;

    private String cnname;

    private String enname;

    private String comments;

    private String joinid;

    private String mnemoniccode;

    private String sectioncode;

    private String departmentcode;

    private String namecode;

    private String statusName;
    private String def1;

    private String def2;

    private String def3;

    private String def4;

    private String def5;

    private String positiontype;

    private static final long serialVersionUID = 1L;
    private List<RscSysRole> roles;
    List<RscSysRoleusermap> rscSysRoleusermaps;
    public void setRscSysRoleusermaps( List<RscSysRoleusermap> rscSysRoleusermaps){
        this.rscSysRoleusermaps = rscSysRoleusermaps;
    }
    public  List<RscSysRoleusermap> getRscSysRoleusermaps(){
        return rscSysRoleusermaps;
    }
    public String getPositionid() {
        return positionid;
    }

    public void setPositionid(String positionid) {
        this.positionid = positionid;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    @ExcelField(title="岗位名称", align=1, sort=1)
    public String getCnname() {
        return cnname;
    }

    public void setCnname(String cnname) {
        this.cnname = cnname;
    }

    public String getEnname() {
        return enname;
    }

    public void setEnname(String enname) {
        this.enname = enname;
    }

    @ExcelField(title="岗位描述", align=1, sort=2)
    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public String getJoinid() {
        return joinid;
    }

    public void setJoinid(String joinid) {
        this.joinid = joinid;
    }

    public String getMnemoniccode() {
        return mnemoniccode;
    }

    public void setMnemoniccode(String mnemoniccode) {
        this.mnemoniccode = mnemoniccode;
    }

    public String getSectioncode() {
        return sectioncode;
    }

    public void setSectioncode(String sectioncode) {
        this.sectioncode = sectioncode;
    }

    public String getDepartmentcode() {
        return departmentcode;
    }

    public void setDepartmentcode(String departmentcode) {
        this.departmentcode = departmentcode;
    }

    public String getNamecode() {
        return namecode;
    }

    public void setNamecode(String namecode) {
        this.namecode = namecode;
    }

    @ExcelField(title="状态", align=1, sort=5)
    public String getStatusName() {
        return statusName;
    }

    public void setStatusName(String statusName) {
        this.statusName = statusName;
    }

    public String getDef1() {
        return def1;
    }

    public void setDef1(String def1) {
        this.def1 = def1;
    }

    public String getDef2() {
        return def2;
    }

    public void setDef2(String def2) {
        this.def2 = def2;
    }

    public String getDef3() {
        return def3;
    }

    public void setDef3(String def3) {
        this.def3 = def3;
    }

    public String getDef4() {
        return def4;
    }

    public void setDef4(String def4) {
        this.def4 = def4;
    }

    public String getDef5() {
        return def5;
    }

    public void setDef5(String def5) {
        this.def5 = def5;
    }

    public String getPositiontype() {
        return positiontype;
    }

    public void setPositiontype(String positiontype) {
        this.positiontype = positiontype;
    }

    @ExcelField(title="角色", align=1, sort=4)
    public List<RscSysRole> getRoles() {
        return roles;
    }

    public void setRoles(List<RscSysRole> roles) {
        this.roles = roles;
    }

    @ExcelField(title="用户名", align=1, sort=3)
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    private String userName;



}