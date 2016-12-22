package com.stripcode.mybatis.cs.model;

import com.stripcode.core.util.excelUtil.annotation.ExcelField;
import com.stripcode.mybatis.common.BaseModel;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Metro on 2016/8/19.
 */
public class CSCustomerErpInfo extends BaseModel implements Serializable{
    private String brandName;
    private String signDate;
    private String superiorCompany;     //上级公司
    private String tel;                 //联系电话
    private String idNumber;            //身份证号码
    private String sex;                 //性别
    private String education;           //文化程度
    private String companyName;         //公司名称
    private String address;             //家庭住址
    private String customerProperty;   //客户性质编码
    private String origCareer;          //原职业
    private String nativePlace;         //籍贯
    private Integer businessLife;         //经商年限
    private Integer age;                    //年龄
    private String accreditStartDate;
    private String brand;       //品牌
    private String erpCode;    //ErpId
    private String rowId;      //rowId 外键
    private String erpName;    //Erp名字
    private String accreditEndDate;
    private Double basicDiscountRate;
    private Double splitRate;
    private String cooperationMode;
    private String customerId;
    private Double deposit;
    private Double pledge;
    private Double goodsPledge;
    private Double initialFee;
    private String accreditStarDate;
    private String isBuyout;
    private String marketLev;
    private String userId;
    private String userName;
    private String isNewErpId;
    private String remark;
    private String delFlag;
    private String def1;
    private String def2;
    private String def3;
    private String def4;
    private String def5;
    private String def6;
    private String def7;
    private String def8;
    private String def9;
    private String def10;
    private String discountRateMode;//折率方式
    private String postAddress;//联系地址
    private List<CSMarketCustomerDiscountSplit> customerDiscountSplitList;
    private CSRenewalContractinfo contractinfo;
    private CSContractSigning sign;
    private String actualSigndate;
    private String marketLevName;

    public String getMarketLevName() {
        return marketLevName;
    }

    public void setMarketLevName(String marketLevName) {
        this.marketLevName = marketLevName;
    }

    public String getActualSigndate() {
        return actualSigndate;
    }

    public void setActualSigndate(String actualSigndate) {
        this.actualSigndate = actualSigndate;
    }

    public CSContractSigning getSign() {
        return sign;
    }

    public void setSign(CSContractSigning sign) {
        this.sign = sign;
    }

    public CSRenewalContractinfo getContractinfo() {
        return contractinfo;
    }

    public void setContractinfo(CSRenewalContractinfo contractinfo) {
        this.contractinfo = contractinfo;
    }

    public String getPostAddress() {
        return postAddress;
    }

    public void setPostAddress(String postAddress) {
        this.postAddress = postAddress;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    //续约开始日期
    private String startDate;
    //续约结束日期
    private String endDate;
    //市场编码
    private String marketId;

    private String actualSignDate;
    private String actualAccreditStartDate;
    private String actualAccreditEndDate;
    private String actualRowId;

    public List<CSMarketCustomerDiscountSplit> getCustomerDiscountSplitList() {
        return customerDiscountSplitList;
    }

    public void setCustomerDiscountSplitList(List<CSMarketCustomerDiscountSplit> customerDiscountSplitList) {
        this.customerDiscountSplitList = customerDiscountSplitList;
    }
    @ExcelField(title="折率方式", align=1, sort=6)
    public String getDiscountRateMode() {
        return discountRateMode;
    }
    public void setDiscountRateMode(String discountRateMode) {
        this.discountRateMode = discountRateMode;
    }

    public String getSignDate() {
        return signDate;
    }

    public void setSignDate(String signDate) {
        this.signDate = signDate;
    }

    public Double getSplitRate() {
        return splitRate;
    }

    public void setSplitRate(Double splitRate) {
        this.splitRate = splitRate;
    }

    public String getActualRowId() {
        return actualRowId;
    }

    public void setActualRowId(String actualRowId) {
        this.actualRowId = actualRowId;
    }

    public String getActualSignDate() {
        return actualSignDate;
    }

    public void setActualSignDate(String actualSignDate) {
        this.actualSignDate = actualSignDate;
    }

    public String getActualAccreditStartDate() {
        return actualAccreditStartDate;
    }

    public void setActualAccreditStartDate(String actualAccreditStartDate) {
        this.actualAccreditStartDate = actualAccreditStartDate;
    }

    public String getActualAccreditEndDate() {
        return actualAccreditEndDate;
    }

    public void setActualAccreditEndDate(String actualAccreditEndDate) {
        this.actualAccreditEndDate = actualAccreditEndDate;
    }

    public String getOrigCareer() {
        return origCareer;
    }

    public void setOrigCareer(String origCareer) {
        this.origCareer = origCareer;
    }

    public String getNativePlace() {
        return nativePlace;
    }

    public void setNativePlace(String nativePlace) {
        this.nativePlace = nativePlace;
    }

    public Integer getBusinessLife() {
        return businessLife;
    }

    public void setBusinessLife(Integer businessLife) {
        this.businessLife = businessLife;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @ExcelField(title="ERP市场ID", align=1, sort=3)
    public String getErpCode() {
        return erpCode;
    }

    public void setErpCode(String erpCode) {
        this.erpCode = erpCode;
    }

    public String getRowId() {
        return rowId;
    }

    public void setRowId(String rowId) {
        this.rowId = rowId;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getSuperiorCompany() {
        return superiorCompany;
    }

    public void setSuperiorCompany(String superiorCompany) {
        this.superiorCompany = superiorCompany;
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

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCustomerProperty() {
        return customerProperty;
    }

    public void setCustomerProperty(String customerProperty) {
        this.customerProperty = customerProperty;
    }

    public String getAccreditStartDate() {
        return accreditStartDate;
    }

    public void setAccreditStartDate(String accreditStartDate) {
        this.accreditStartDate = accreditStartDate;
    }

    public String getIsNewErpId() {
        return isNewErpId;
    }

    public void setIsNewErpId(String isNewErpId) {
        this.isNewErpId = isNewErpId;
    }

    private CSCustomerInfo csCustomerInfo;

    public String getIsBuyout() {
        return isBuyout;
    }

    public void setIsBuyout(String isBuyout) {
        this.isBuyout = isBuyout;
    }

    public CSCustomerInfo getCsCustomerInfo() {
        return csCustomerInfo;
    }

    public void setCsCustomerInfo(CSCustomerInfo csCustomerInfo) {
        this.csCustomerInfo = csCustomerInfo;
    }

    public Double getBasicDiscountRate() {
        return basicDiscountRate;
    }
    public void setBasicDiscountRate(Double basicDiscountRate) {
        this.basicDiscountRate = basicDiscountRate;
    }

    @ExcelField(title="客户名称", align=1, sort=1)
    public String getCorporation() {
        return corporation;
    }

    public void setCorporation(String corporation) {
        this.corporation = corporation;
    }

    @ExcelField(title="ERP市场名称", align=1, sort=4)
    public String getErpName() {
        return erpName;
    }

    public void setErpName(String erpName) {
        this.erpName = erpName;
    }

    @ExcelField(title="授权结束日期", align=1, sort=5)
    public String getAccreditEndDate() {
        return accreditEndDate;
    }

    public void setAccreditEndDate(String accreditEndDate) {
        this.accreditEndDate = accreditEndDate;
    }

    @ExcelField(title="合作模式", align=1, sort=7)
    public String getCooperationMode() {
        return cooperationMode;
    }

    public void setCooperationMode(String cooperationMode) {
        this.cooperationMode = cooperationMode;
    }

    private String corporation;

    @ExcelField(title="品牌", align=1, sort=2)
    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public Double getDeposit() {
        return deposit;
    }

    public void setDeposit(Double deposit) {
        this.deposit = deposit;
    }

    public Double getPledge() {
        return pledge;
    }

    public void setPledge(Double pledge) {
        this.pledge = pledge;
    }

    public Double getGoodsPledge() {
        return goodsPledge;
    }

    public void setGoodsPledge(Double goodsPledge) {
        this.goodsPledge = goodsPledge;
    }

    public Double getInitialFee() {
        return initialFee;
    }

    public void setInitialFee(Double initialFee) {
        this.initialFee = initialFee;
    }

    public String getAccreditStarDate() {
        return accreditStarDate;
    }

    public void setAccreditStarDate(String accreditStarDate) {
        this.accreditStarDate = accreditStarDate;
    }

    public String getMarketLev() {
        return marketLev;
    }

    public void setMarketLev(String marketLev) {
        this.marketLev = marketLev;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag;
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

    public String getDef6() {
        return def6;
    }

    public void setDef6(String def6) {
        this.def6 = def6;
    }

    public String getDef7() {
        return def7;
    }

    public void setDef7(String def7) {
        this.def7 = def7;
    }

    public String getDef8() {
        return def8;
    }

    public void setDef8(String def8) {
        this.def8 = def8;
    }

    public String getDef9() {
        return def9;
    }

    public void setDef9(String def9) {
        this.def9 = def9;
    }

    public String getDef10() {
        return def10;
    }

    public void setDef10(String def10) {
        this.def10 = def10;
    }

    public String getMarketId() {
        return marketId;
    }

    public void setMarketId(String marketId) {
        this.marketId = marketId;
    }
}
