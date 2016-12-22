package com.stripcode.core.dto.cs;

import com.stripcode.mybatis.common.BaseModel;
import com.stripcode.mybatis.cs.model.CSCustomerInfo;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.beans.BeanUtils;

import java.io.Serializable;

/**
 * Created by Metro on 2016/8/19.
 */
public class CreateOrModifyCustomerDto extends BaseModel implements Serializable{
    private String customerId;  //客户ID
    private String customerType; //客户类型编码
    @NotEmpty(message = "客户性质不能为空")
    private String customerProperty;   //客户性质编码
//    @NotEmpty(message = "上级公司不能为空")
    private String superiorCompany;     //上级公司
    @NotEmpty(message = "负责人/法人不能为空")
    private String corporation;         //负责人/法人
    @NotEmpty(message = "联系电话不能为空")
    private String tel;                 //联系电话
    private String idNumber;            //身份证号码
    private String sex;                 //性别
    private String nativePlace;         //籍贯
    private String age;                    //年龄
    private String education;           //文化程度
    private String origCareer;          //原职业
    private String partSole;            //合伙/投资
    @NotEmpty(message = "经商年限不能为空")
    private String businessLife;         //经商年限
    private String experoence;            //几年行业经验
    private String depositBank;         //开户行
    private String depositaccount;      //开户账号
    private String companyName;         //公司名称
    private String businessLicense;     //营业执照
    private String taxId;               //税务登记号
    private String address;             //家庭住址
    private String email;               //邮箱
    private String fax;                 //传真
    private String postCode;            //邮编
    private String postAddress;         //邮寄地址
    private String del_Flag;            //删除标记

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getCustomerType() {
        return customerType;
    }

    public void setCustomerType(String customerType) {
        this.customerType = customerType;
    }

    public String getCustomerProperty() {
        return customerProperty;
    }

    public void setCustomerProperty(String customerProperty) {
        this.customerProperty = customerProperty;
    }

    public String getSuperiorCompany() {
        return superiorCompany;
    }

    public void setSuperiorCompany(String superiorCompany) {
        this.superiorCompany = superiorCompany;
    }

    public String getCorporation() {
        return corporation;
    }

    public void setCorporation(String corporation) {
        this.corporation = corporation;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getNativePlace() {
        return nativePlace;
    }

    public void setNativePlace(String nativePlace) {
        this.nativePlace = nativePlace;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getBusinessLife() {
        return businessLife;
    }

    public void setBusinessLife(String businessLife) {
        this.businessLife = businessLife;
    }

    public String getExperoence() {
        return experoence;
    }

    public void setExperoence(String experoence) {
        this.experoence = experoence;
    }

    public String getDepositBank() {
        return depositBank;
    }

    public void setDepositBank(String depositBank) {
        this.depositBank = depositBank;
    }

    public String getDepositaccount() {
        return depositaccount;
    }

    public void setDepositaccount(String depositaccount) {
        this.depositaccount = depositaccount;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getBusinessLicense() {
        return businessLicense;
    }

    public void setBusinessLicense(String businessLicense) {
        this.businessLicense = businessLicense;
    }

    public String getTaxId() {
        return taxId;
    }

    public void setTaxId(String taxId) {
        this.taxId = taxId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    public String getPostAddress() {
        return postAddress;
    }

    public void setPostAddress(String postAddress) {
        this.postAddress = postAddress;
    }

    public String getDel_Flag() {
        return del_Flag;
    }

    public void setDel_Flag(String del_Flag) {
        this.del_Flag = del_Flag;
    }

    public String getOrigCareer() {
        return origCareer;
    }

    public void setOrigCareer(String origCareer) {
        this.origCareer = origCareer;
    }

    public String getPartSole() {
        return partSole;
    }

    public void setPartSole(String partSole) {
        this.partSole = partSole;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public CSCustomerInfo toModel(){
        CSCustomerInfo csCustomerInfo = new CSCustomerInfo();
        BeanUtils.copyProperties(this, csCustomerInfo);
//        csCustomerInfo.setAge(Integer.parseInt(this.getAge()));
        return csCustomerInfo;
    }
}
