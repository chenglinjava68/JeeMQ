package com.stripcode.mybatis.user.model;

import com.stripcode.core.util.excelUtil.annotation.ExcelField;
import com.stripcode.mybatis.common.BaseModel;

public class RscSysUser extends BaseModel  {
    private String userId;

    private String loginName;

    private String userName;

    private String password;

    private String statusName;

    public String getStatusName() {
        return statusName;
    }

    public void setStatusName(String statusName) {
        this.statusName = statusName;
    }

    private String mail;

    private String phone;

    private String mobile;

    private Integer leader;
    private String sex;

    private String birthday;

    private String title;

    private String office;

    private String address;

    private String joindate;

    private String fax;

    private String workstatus;

    private Integer isagent;

    private Integer agent;

    private String begindate;

    private String enddate;

    private Integer ipadstatus;
    private String deviceid;

    private String stationoffice;

    private String officeno;

    private String functionname;

    private String firstnameCn;

    private String secondnameCn;

    private String firstnameEn;

    private String secondnameEn;

    private String userCnname;
    private String idnumber;

    private String eid;

    private String major;

    private String education;
    private String university;

    private String photolink;

    private String workingexplink;

    private String joinfrom;

    private String department;

    private String fromdepartment;

    private String extension;

    private String directline;

    private String curpositiondate;

    private String companyentity;

    private String scopelevel;

    private String remark;

    private String def1;

    private String def2;

    private String def3;

    private String def4;

    private String def5;

    private String compcode;

    private String storecode;

    private String storename;

    private Integer usertype;

    private String logindate;

    RscSysPosition rscSysPositions;
    public  void  setRscSysPositions(RscSysPosition rscSysPositions){
        this.rscSysPositions = rscSysPositions;
    }
    public  RscSysPosition getRscSysPositions(){
        return rscSysPositions;
    }


    private static final long serialVersionUID = 1L;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @ExcelField(title = "登录名",align = 1,sort = 1)
    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    @ExcelField(title = "用户名",align = 1,sort = 2)
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

    @ExcelField(title="电子邮件", align=1, sort=5)
    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail == null ? null : mail.trim();
    }

    @ExcelField(title="电话号码", align=1, sort=7)
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    @ExcelField(title="手机号码", align=1, sort=6)
    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile == null ? null : mobile.trim();
    }

    public Integer getLeader() {
        return leader;
    }

    public void setLeader(Integer leader) {
        this.leader = leader;
    }

    @ExcelField(title="性别", align=1, sort=8)
    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday == null ? null : birthday.trim();
    }

    @ExcelField(title="角色", align=1, sort=4)
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
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

    public Integer getAgent() {
        return agent;
    }

    public void setAgent(Integer agent) {
        this.agent = agent;
    }

    public String getBegindate() {
        return begindate;
    }

    public void setBegindate(String begindate) {
        this.begindate = begindate == null ? null : begindate.trim();
    }

    public String getEnddate() {
        return enddate;
    }

    public void setEnddate(String enddate) {
        this.enddate = enddate == null ? null : enddate.trim();
    }

    public Integer getIpadstatus() {
        return ipadstatus;
    }

    public void setIpadstatus(Integer ipadstatus) {
        this.ipadstatus = ipadstatus;
    }

    public String getDeviceid() {
        return deviceid;
    }

    public void setDeviceid(String deviceid) {
        this.deviceid = deviceid == null ? null : deviceid.trim();
    }

    public String getStationoffice() {
        return stationoffice;
    }

    public void setStationoffice(String stationoffice) {
        this.stationoffice = stationoffice == null ? null : stationoffice.trim();
    }

    public String getOfficeno() {
        return officeno;
    }

    public void setOfficeno(String officeno) {
        this.officeno = officeno == null ? null : officeno.trim();
    }

    public String getFunctionname() {
        return functionname;
    }

    public void setFunctionname(String functionname) {
        this.functionname = functionname == null ? null : functionname.trim();
    }

    public String getFirstnameCn() {
        return firstnameCn;
    }

    public void setFirstnameCn(String firstnameCn) {
        this.firstnameCn = firstnameCn == null ? null : firstnameCn.trim();
    }

    public String getSecondnameCn() {
        return secondnameCn;
    }

    public void setSecondnameCn(String secondnameCn) {
        this.secondnameCn = secondnameCn == null ? null : secondnameCn.trim();
    }

    public String getFirstnameEn() {
        return firstnameEn;
    }

    public void setFirstnameEn(String firstnameEn) {
        this.firstnameEn = firstnameEn == null ? null : firstnameEn.trim();
    }

    public String getSecondnameEn() {
        return secondnameEn;
    }

    public void setSecondnameEn(String secondnameEn) {
        this.secondnameEn = secondnameEn == null ? null : secondnameEn.trim();
    }

    public String getUserCnname() {
        return userCnname;
    }

    public void setUserCnname(String userCnname) {
        this.userCnname = userCnname == null ? null : userCnname.trim();
    }

    public String getIdnumber() {
        return idnumber;
    }

    public void setIdnumber(String idnumber) {
        this.idnumber = idnumber == null ? null : idnumber.trim();
    }

    public String getEid() {
        return eid;
    }

    public void setEid(String eid) {
        this.eid = eid == null ? null : eid.trim();
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major == null ? null : major.trim();
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education == null ? null : education.trim();
    }

    public String getUniversity() {
        return university;
    }

    public void setUniversity(String university) {
        this.university = university == null ? null : university.trim();
    }

    public String getPhotolink() {
        return photolink;
    }

    public void setPhotolink(String photolink) {
        this.photolink = photolink == null ? null : photolink.trim();
    }

    public String getWorkingexplink() {
        return workingexplink;
    }

    public void setWorkingexplink(String workingexplink) {
        this.workingexplink = workingexplink == null ? null : workingexplink.trim();
    }

    public String getJoinfrom() {
        return joinfrom;
    }

    public void setJoinfrom(String joinfrom) {
        this.joinfrom = joinfrom == null ? null : joinfrom.trim();
    }

    @ExcelField(title="岗位", align=1, sort=3)
    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department == null ? null : department.trim();
    }

    public String getFromdepartment() {
        return fromdepartment;
    }

    public void setFromdepartment(String fromdepartment) {
        this.fromdepartment = fromdepartment == null ? null : fromdepartment.trim();
    }

    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension == null ? null : extension.trim();
    }

    public String getDirectline() {
        return directline;
    }

    public void setDirectline(String directline) {
        this.directline = directline == null ? null : directline.trim();
    }

    public String getCurpositiondate() {
        return curpositiondate;
    }

    public void setCurpositiondate(String curpositiondate) {
        this.curpositiondate = curpositiondate == null ? null : curpositiondate.trim();
    }

    public String getCompanyentity() {
        return companyentity;
    }

    public void setCompanyentity(String companyentity) {
        this.companyentity = companyentity == null ? null : companyentity.trim();
    }

    public String getScopelevel() {
        return scopelevel;
    }

    public void setScopelevel(String scopelevel) {
        this.scopelevel = scopelevel == null ? null : scopelevel.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public String getDef1() {
        return def1;
    }

    public void setDef1(String def1) {
        this.def1 = def1 == null ? null : def1.trim();
    }

    public String getDef2() {
        return def2;
    }

    public void setDef2(String def2) {
        this.def2 = def2 == null ? null : def2.trim();
    }

    public String getDef3() {
        return def3;
    }

    public void setDef3(String def3) {
        this.def3 = def3 == null ? null : def3.trim();
    }

    public String getDef4() {
        return def4;
    }

    public void setDef4(String def4) {
        this.def4 = def4 == null ? null : def4.trim();
    }

    public String getDef5() {
        return def5;
    }

    public void setDef5(String def5) {
        this.def5 = def5 == null ? null : def5.trim();
    }

    public String getCompcode() {
        return compcode;
    }

    public void setCompcode(String compcode) {
        this.compcode = compcode == null ? null : compcode.trim();
    }

    public String getStorecode() {
        return storecode;
    }

    public void setStorecode(String storecode) {
        this.storecode = storecode == null ? null : storecode.trim();
    }

    public String getStorename() {
        return storename;
    }

    public void setStorename(String storename) {
        this.storename = storename == null ? null : storename.trim();
    }

    public Integer getUsertype() {
        return usertype;
    }

    public void setUsertype(Integer usertype) {
        this.usertype = usertype;
    }

    public String getLogindate() {
        return logindate;
    }

    public void setLogindate(String logindate) {
        this.logindate = logindate == null ? null : logindate.trim();
    }

}