package com.stripcode.mybatis.user.model;

import com.stripcode.mybatis.common.BaseModel;

import java.io.Serializable;

public class RscSysRoleusermap extends BaseModel implements Serializable {

    private String roleId;
    public  RscSysRole role;
    public  RscSysPosition rscSysPosition;



    public RscSysRoleusermap() {
    }

    private String positionid;
    private static final long serialVersionUID = 1L;

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public String getPositionid() {
        return positionid;
    }

    public void setPositionid(String positionid) {
        this.positionid = positionid;
    }
    public RscSysRole getRole(){
        return role;
    }
    public void setRole(RscSysRole role){
        this.role = role;
    }
    public RscSysPosition getRscSysPosition(){
        return rscSysPosition;
    }
    public  void setRscSysPosition(RscSysPosition rscSysPosition ){
        this.rscSysPosition = rscSysPosition;
    }

}