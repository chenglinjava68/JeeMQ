package com.stripcode.core.dto.user;

import com.stripcode.mybatis.common.BaseModel;
import com.stripcode.mybatis.user.model.RscSysPosition;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.beans.BeanUtils;

import javax.validation.constraints.NotNull;
import java.util.Date;

public class CreateOrModifyPositionDto extends BaseModel  {

    private String positionid;
    @NotNull(message="用户不能为空!")
    private String userid;
    @NotBlank(message="岗位名不能为空！")
    private String cnname;

    @Override
    public void setUpdateTime(Date updateTime) {
        super.setUpdateTime(updateTime);
    }

    @Override
    public void setCreateTime(Date createTime) {
        super.setCreateTime(createTime);
    }

    private String comments;

    private String joinid;

    private String mnemoniccode;

    private String sectioncode;

    private String departmentcode;

    private String namecode;

    private static final long serialVersionUID = 1L;

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

    public String getCnname() {
        return cnname;
    }

    public void setCnname(String cnname) {
        this.cnname = cnname == null ? null : cnname.trim();
    }


    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments == null ? null : comments.trim();
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
        this.mnemoniccode = mnemoniccode == null ? null : mnemoniccode.trim();
    }

    public String getSectioncode() {
        return sectioncode;
    }

    public void setSectioncode(String sectioncode) {
        this.sectioncode = sectioncode == null ? null : sectioncode.trim();
    }

    public String getDepartmentcode() {
        return departmentcode;
    }

    public void setDepartmentcode(String departmentcode) {
        this.departmentcode = departmentcode == null ? null : departmentcode.trim();
    }

    public String getNamecode() {
        return namecode;
    }

    public void setNamecode(String namecode) {
        this.namecode = namecode == null ? null : namecode.trim();
    }

    public RscSysPosition toModel(){
        RscSysPosition rscSysPosition = new RscSysPosition();
        BeanUtils.copyProperties(this,rscSysPosition);
        return rscSysPosition;
    }

}