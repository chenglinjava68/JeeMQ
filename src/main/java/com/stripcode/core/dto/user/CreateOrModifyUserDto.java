package com.stripcode.core.dto.user;

import com.stripcode.mybatis.common.BaseModel;
import com.stripcode.mybatis.user.model.RscSysUser;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.beans.BeanUtils;

import javax.validation.constraints.NotNull;

/**
 * Created by Metro on 2016/8/12.
 */
public class CreateOrModifyUserDto extends BaseModel {
    private String userId;

    private static final long serialVersionUID = 1L;

    @NotEmpty(message = "登录名不能为空。")
    private String loginName;
    @NotEmpty(message = "用户名不能为空。")
    private String userName;
    private String password;
    private String userCnname;

    private String joinfrom;
    @NotEmpty(message = "部门不能为空!")
    private String department;
    private String mail;
    private String phone;
    private String mobile;
    @NotNull(message = "性别不能为空！")
    private String sex;
    @NotEmpty(message = "所属公司不能为空!")
    private String compcode;
    private String office;
    private String address;
    @NotEmpty(message = "加入日期不能为空！")
    private String joindate;
    private String fax;
    @NotEmpty(message = "工作状态不能为空！")
    private String workstatus;
    private Integer isagent;
    private String officeno;

    public String getOfficeno() {
        return officeno;
    }

    public void setOfficeno(String officeno) {
        this.officeno = officeno;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail == null ? null : mail.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile == null ? null : mobile.trim();
    }


    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }

    public String getOffice() {
        return office;
    }

    public void setOffice(String office) {
        this.office = office == null ? null : office.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getJoindate() {
        return joindate;
    }

    public void setJoindate(String joindate) {

        this.joindate = joindate == null ? null : joindate;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax == null ? null : fax.trim();
    }

    public String getWorkstatus() {
        return workstatus;
    }

    public void setWorkstatus(String workstatus) {
        this.workstatus = workstatus == null ? null : workstatus.trim();
    }

    public Integer getIsagent() {
        return isagent;
    }

    public void setIsagent(Integer isagent) {
        this.isagent = isagent;
    }

    public String getUserCnname() {
        return userCnname;
    }

    public void setUserCnname(String userCnname) {
        this.userCnname = userCnname == null ? null : userCnname.trim();
    }

    public String getJoinfrom() {
        return joinfrom;
    }

    public void setJoinfrom(String joinfrom) {
        this.joinfrom = joinfrom == null ? null : joinfrom.trim();
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department == null ? null : department.trim();
    }

    public String getCompcode() {
        return compcode;
    }

    public void setCompcode(String compcode) {
        this.compcode = compcode == null ? null : compcode.trim();
    }

    public RscSysUser toModel() {
        RscSysUser rscSysUser = new RscSysUser();
        BeanUtils.copyProperties(this, rscSysUser);
        return rscSysUser;
    }
}
