package com.stripcode.mybatis.cs.model;

import com.stripcode.core.annotation.Divide;
import com.stripcode.core.annotation.Multiply;
import com.stripcode.mybatis.common.BaseModel;
import com.stripcode.mybatis.sf.model.SFEstInvestmentResultData;
import com.stripcode.mybatis.sf.model.SFTrafficcount;
import com.stripcode.mybatis.sf.model.TSfEstInvestmentNonLaborCost;
import com.stripcode.mybatis.sf.model.TSfEstInvestmentResultDateCopartner;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Metro on 2016/9/6.
 */
public class CSNewMarketAuz extends BaseModel implements Serializable {
    private String brandName;
    private String rowId;
    private String taskId;
    private String customerId;
    private String optimauthId;
    private String brand; //品牌编码
    private String cooperationMode; //合作模式
    private Double discountRate;//基本折率
    private Double deposit;//保证金
    private Double pledge; //押金
    private Double goodsPledge; //货品押金
    private Double initialFee;//加盟费
    private String accreditStartDate;//授权开始日期
    private String accreditEndDate;//授权结束日期
    private String isBuyout;//是否买断
    private String marketLev;//市场级别
    private String userId;//负责人
    private String isNewErpId;//是否新增ERPID
    private String erpCode;//erpId
    private String erpName;//erp名称
    private String remark;//备注
    private String delFlag;//删除标记
    private String erpId; //erpCode
    private Double investFunds; //首期投入资金
    private String costBack;//希望回收成本年数
    private Double customerFunds;//客户自有资金
    private Double mktVolumeSales;//市场总容量销售收入
    private Double mbMaxAchSales;//MB最高可实现销售收入
    private String otherBrand;//是否经营其他休闲品牌
    private String discountRateMode;//折率方式
    private Double splitRate;//收入分成模式
    private CSCustomerInfo csCustomerInfo; //客户实体
    private String director;
    private String marketId;
    private String actualSignDate;
    private String actualAccreditStartDate;
    private String actualAccreditEndDate;
    private String actualRowId;
    private String proStatus;
    private String currentNode;
    private String authorizationId;
    private String cooperationModeCode;
    private String brandCode;
    private String marketLevCode;
    private CSSfPipeline csSfPipeline;
    private SFEstInvestmentResultData sfEstInvestmentResultData;
    private List<CSMarketDiscountSplit> discountSplitListtSplit;
    private TSfEstInvestmentNonLaborCost tSfEstInvestmentNonLaborCost;//合伙人投资测算非人力成本对象
    private TSfEstInvestmentResultDateCopartner tSfEstInvestmentResultDateCopartner;//合伙人投资测算投资结果对象
    private SFTrafficcount sfTrafficcount;//合伙人人流量对象

    public SFTrafficcount getSfTrafficcount() {
        return sfTrafficcount;
    }

    public void setSfTrafficcount(SFTrafficcount sfTrafficcount) {
        this.sfTrafficcount = sfTrafficcount;
    }

    public TSfEstInvestmentResultDateCopartner gettSfEstInvestmentResultDateCopartner() {
        return tSfEstInvestmentResultDateCopartner;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public void settSfEstInvestmentResultDateCopartner(TSfEstInvestmentResultDateCopartner tSfEstInvestmentResultDateCopartner) {
        this.tSfEstInvestmentResultDateCopartner = tSfEstInvestmentResultDateCopartner;
    }

    public TSfEstInvestmentNonLaborCost gettSfEstInvestmentNonLaborCost() {
        return tSfEstInvestmentNonLaborCost;
    }

    public void settSfEstInvestmentNonLaborCost(TSfEstInvestmentNonLaborCost tSfEstInvestmentNonLaborCost) {
        this.tSfEstInvestmentNonLaborCost = tSfEstInvestmentNonLaborCost;
    }

    private String postAddress;

    public String getPostAddress() {
        return postAddress;
    }

    public void setPostAddress(String postAddress) {
        this.postAddress = postAddress;
    }

    public String getDiscountRateMode() {
        return discountRateMode;
    }

    public void setDiscountRateMode(String discountRateMode) {
        this.discountRateMode = discountRateMode;
    }

    public List<CSMarketDiscountSplit> getDiscountSplitListtSplit() {
        return discountSplitListtSplit;
    }

    public void setDiscountSplitListtSplit(List<CSMarketDiscountSplit> discountSplitListtSplit) {
        this.discountSplitListtSplit = discountSplitListtSplit;
    }

    public SFEstInvestmentResultData getSfEstInvestmentResultData() {
        return sfEstInvestmentResultData;
    }

    public void setSfEstInvestmentResultData(SFEstInvestmentResultData sfEstInvestmentResultData) {
        this.sfEstInvestmentResultData = sfEstInvestmentResultData;
    }

    public CSSfPipeline getCsSfPipeline() {
        return csSfPipeline;
    }

    public void setCsSfPipeline(CSSfPipeline csSfPipeline) {
        this.csSfPipeline = csSfPipeline;
    }

    public String getMarketLevCode() {
        return marketLevCode;
    }

    public void setMarketLevCode(String marketLevCode) {
        this.marketLevCode = marketLevCode;
    }

    public String getCooperationModeCode() {
        return cooperationModeCode;
    }

    public void setCooperationModeCode(String cooperationModeCode) {
        this.cooperationModeCode = cooperationModeCode;
    }

    public String getBrandCode() {
        return brandCode;
    }

    public void setBrandCode(String brandCode) {
        this.brandCode = brandCode;
    }

    public String getAuthorizationId() {
        return authorizationId;
    }

    public void setAuthorizationId(String authorizationId) {
        this.authorizationId = authorizationId;
    }

    public String getCurrentNode() {
        return currentNode;
    }

    public void setCurrentNode(String currentNode) {
        this.currentNode = currentNode;
    }

    public String getProStatus() {
        return proStatus;
    }

    public void setProStatus(String proStatus) {
        this.proStatus = proStatus;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getMarketId() {
        return marketId;
    }

    public void setMarketId(String marketId) {
        this.marketId = marketId;
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

    public String getActualRowId() {
        return actualRowId;
    }

    public void setActualRowId(String actualRowId) {
        this.actualRowId = actualRowId;
    }
    @Multiply(10000)
    public Double getInvestFunds() {
        return investFunds;
    }
    @Divide(10000)
    public void setInvestFunds(Double investFunds) {
        this.investFunds = investFunds;
    }

    public Double getCustomerFunds() {
        return customerFunds;
    }

    public void setCustomerFunds(Double customerFunds) {
        this.customerFunds = customerFunds;
    }

    public Double getMktVolumeSales() {
        return mktVolumeSales;
    }

    public void setMktVolumeSales(Double mktVolumeSales) {
        this.mktVolumeSales = mktVolumeSales;
    }

    public Double getMbMaxAchSales() {
        return mbMaxAchSales;
    }

    public void setMbMaxAchSales(Double mbMaxAchSales) {
        this.mbMaxAchSales = mbMaxAchSales;
    }

    public String getOtherBrand() {
        return otherBrand;
    }

    public void setOtherBrand(String otherBrand) {
        this.otherBrand = otherBrand;
    }
    public String getCostBack() {
        return costBack;
    }
    public void setCostBack(String costBack) {
        this.costBack = costBack;
    }

    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }

    public String getErpId() {
        return erpId;
    }

    public void setErpId(String erpId) {
        this.erpId = erpId;
    }

    public CSCustomerInfo getCsCustomerInfo() {
        return csCustomerInfo;
    }

    public void setCsCustomerInfo(CSCustomerInfo csCustomerInfo) {
        this.csCustomerInfo = csCustomerInfo;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getRowId() {
        return rowId;
    }

    public void setRowId(String rowId) {
        this.rowId = rowId;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getOptimauthId() {
        return optimauthId;
    }

    public void setOptimauthId(String optimauthId) {
        this.optimauthId = optimauthId;
    }

    public String getCooperationMode() {
        return cooperationMode;
    }

    public void setCooperationMode(String cooperationMode) {
        this.cooperationMode = cooperationMode;
    }

    public Double getSplitRate() {
        return splitRate;
    }

    public void setSplitRate(Double splitRate) {
        this.splitRate = splitRate;
    }

    public Double getDiscountRate() {
        return discountRate;
    }

    public void setDiscountRate(Double discountRate) {
        this.discountRate = discountRate;
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

    public String getAccreditStartDate() {
        return accreditStartDate;
    }

    public void setAccreditStartDate(String accreditStartDate) {
        this.accreditStartDate = accreditStartDate;
    }

    public String getAccreditEndDate() {
        return accreditEndDate;
    }

    public void setAccreditEndDate(String accreditEndDate) {
        this.accreditEndDate = accreditEndDate;
    }

    public String getIsBuyout() {
        return isBuyout;
    }

    public void setIsBuyout(String isBuyout) {
        this.isBuyout = isBuyout;
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

    public String getIsNewErpId() {
        return isNewErpId;
    }

    public void setIsNewErpId(String isNewErpId) {
        this.isNewErpId = isNewErpId;
    }

    public String getErpCode() {
        return erpCode;
    }

    public void setErpCode(String erpCode) {
        this.erpCode = erpCode;
    }

    public String getErpName() {
        return erpName;
    }

    public void setErpName(String erpName) {
        this.erpName = erpName;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public String getDelFlag() {
        return delFlag;
    }

    @Override
    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag;
    }
}
