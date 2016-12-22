package com.stripcode.mybatis.cs.model;

import com.stripcode.core.util.excelUtil.annotation.ExcelField;
import com.stripcode.mybatis.common.BaseModel;

import java.io.Serializable;

/**
 * Created by Metro on 2016/8/19.
 */
public class CSCustomerInfo extends BaseModel implements Serializable {
    private String customerPropertyName;
    private String customerId;  //客户ID
    private String customerType; //客户类型编码
    private String customerProperty;   //客户性质编码
    private String superiorCompany;     //上级公司
    private String corporation;         //负责人/法人
    private String tel;                 //联系电话
    private String idNumber;            //身份证号码
    private String sex;                 //性别
    private String nativePlace;         //籍贯
    private Integer age;                    //年龄
    private String education;           //文化程度
    private Integer businessLife;         //经商年限
    private String origCareer;          //原职业
    private String homeStyle;            //合伙/独资
    private Integer experience;            //几年行业经验
    private String depositBank;         //开户行
    private String depositAccount;      //开户账号
    private String companyName;         //公司名称
    private String businessLicense;     //营业执照
    private String taxId;               //税务登记号
    private String address;             //家庭住址
    private String email;               //邮箱
    private String fax;                 //传真
    private String postCode;            //邮编
    private String userStatus;
    private String postAddress;         //邮寄地址
    private String idNumberAttachId;
    private String businessLicenseAttachId;
    private String delFlag;            //删除标记

    private String userStatusName;

    private String erpNumber;           //市场授权数量
    private String startDateNumber;     //未到期数量
    private String endDateNumber;       //已到期数量
    private String storeNumber;         //店铺数量

    private String planInvestId;
    private Double investFunds; //首期投入资金
    private Integer costBack;//希望回收成本年数
    private String otherBrand;//是否经营其他休闲品牌
    private Double mbMaxAchSales;
    private Double mktVolumeSales;
    private Double customerFunds;

    private String erpName;
    private String erpCode;

    public String getIdNumberAttachId() {
        return idNumberAttachId;
    }

    public void setIdNumberAttachId(String idNumberAttachId) {
        this.idNumberAttachId = idNumberAttachId;
    }

    public String getBusinessLicenseAttachId() {
        return businessLicenseAttachId;
    }

    public void setBusinessLicenseAttachId(String businessLicenseAttachId) {
        this.businessLicenseAttachId = businessLicenseAttachId;
    }

    public String getCustomerPropertyName() {
        return customerPropertyName;
    }

    public void setCustomerPropertyName(String customerPropertyName) {
        this.customerPropertyName = customerPropertyName;
    }

    public Double getCustomerFunds() {
        return customerFunds;
    }

    public void setCustomerFunds(Double customerFunds) {
        this.customerFunds = customerFunds;
    }

    public Double getMbMaxAchSales() {
        return mbMaxAchSales;
    }

    public void setMbMaxAchSales(Double mbMaxAchSales) {
        this.mbMaxAchSales = mbMaxAchSales;
    }

    public Double getMktVolumeSales() {
        return mktVolumeSales;
    }

    public void setMktVolumeSales(Double mktVolumeSales) {
        this.mktVolumeSales = mktVolumeSales;
    }

    @ExcelField(title="客户状态", align=1, sort=10)
    public String getUserStatusName() {
        return userStatusName;
    }

    public void setUserStatusName(String userStatusName) {
        this.userStatusName = userStatusName;
    }

    public String getErpName() {
        return erpName;
    }

    public void setErpName(String erpName) {
        this.erpName = erpName;
    }

    public String getErpCode() {
        return erpCode;
    }

    public void setErpCode(String erpCode) {
        this.erpCode = erpCode;
    }

    public String getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(String userStatus) {
        this.userStatus = userStatus;
    }

    public String getPlanInvestId() {
        return planInvestId;
    }

    public void setPlanInvestId(String planInvestId) {
        this.planInvestId = planInvestId;
    }

    public Double getInvestFunds() {
        return investFunds;
    }

    public void setInvestFunds(Double investFunds) {
        this.investFunds = investFunds;
    }

    public Integer getCostBack() {
        return costBack;
    }

    public void setCostBack(Integer costBack) {
        this.costBack = costBack;
    }

    public String getOtherBrand() {
        return otherBrand;
    }

    public void setOtherBrand(String otherBrand) {
        this.otherBrand = otherBrand;
    }

    public String getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    @ExcelField(title="客户类型", align=1, sort=3)
    public String getCustomerType() {
        return customerType;
    }

    public void setCustomerType(String customerType) {
        this.customerType = customerType;
    }

    @ExcelField(title="客户性质", align=1, sort=2)
    public String getCustomerProperty() {
        return customerProperty;
    }

    public void setCustomerProperty(String customerProperty) {
        this.customerProperty = customerProperty;
    }

    @ExcelField(title="上级公司", align=1, sort=5)
    public String getSuperiorCompany() {
        return superiorCompany;
    }

    public void setSuperiorCompany(String superiorCompany) {
        this.superiorCompany = superiorCompany;
    }

    @ExcelField(title="个体/法人代表", align=1, sort=1)
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

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getBusinessLife() {
        return businessLife;
    }

    public void setBusinessLife(Integer businessLife) {
        this.businessLife = businessLife;
    }

    public Integer getExperience() {
        return experience;
    }

    public void setExperience(Integer experience) {
        this.experience = experience;
    }

    public String getDepositBank() {
        return depositBank;
    }

    public void setDepositBank(String depositBank) {
        this.depositBank = depositBank;
    }

    public String getDepositAccount() {
        return depositAccount;
    }

    public void setDepositAccount(String depositAccount) {
        this.depositAccount = depositAccount;
    }

    @ExcelField(title="客户公司名称", align=1, sort=4)
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
    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getTaxId() {
        return taxId;
    }

    public void setTaxId(String taxId) {
        this.taxId = taxId;
    }

    public String getOrigCareer() {
        return origCareer;
    }

    public void setOrigCareer(String origCareer) {
        this.origCareer = origCareer;
    }

    public String getHomeStyle() {
        return homeStyle;
    }

    public void setHomeStyle(String homeStyle) {
        this.homeStyle = homeStyle;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @ExcelField(title="市场授权", align=3, sort=6)
    public String getErpNumber() {
        return erpNumber;
    }

    public void setErpNumber(String erpNumber) {
        this.erpNumber = erpNumber;
    }
    @ExcelField(title="未到期", align=3, sort=8)
    public String getStartDateNumber() {
        return startDateNumber;
    }

    public void setStartDateNumber(String startDateNumber) {
        this.startDateNumber = startDateNumber;
    }

    @ExcelField(title="已到期", align=3, sort=7)
    public String getEndDateNumber() {
        return endDateNumber;
    }

    public void setEndDateNumber(String endDateNumber) {
        this.endDateNumber = endDateNumber;
    }

    @ExcelField(title="店铺", align=3, sort=9)
    public String getStoreNumber() {
        return storeNumber;
    }

    public void setStoreNumber(String storeNumber) {
        this.storeNumber = storeNumber;
    }
}
