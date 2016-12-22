package com.stripcode.mybatis.sf.model;

import com.stripcode.core.annotation.Divide;
import com.stripcode.core.annotation.Multiply;
import com.stripcode.mybatis.common.BaseModel;

/**
 * @author Metro
 */
public class SFEstInvestmentRoi extends BaseModel {

    private String investmentId;

    private Double salesIncludeTaxY1;

    private Double salesIncludeTaxY3;

    private Double salesIncludeTaxY5;

    private Double taxAdjustmentEftY1;

    private Double taxAdjustmentEftY3;

    private Double taxAdjustmentEftY5;

    private Double grossProfitRadioY1;

    private Double grossProfitRadioY3;

    private Double grossProfitRadioY5;

    private Double costRadioY1;

    private Double costRadioY3;

    private Double costRadioY5;

    private Double taxRentPctY1;

    private Double taxRentPctY3;

    private Double taxRentPctY5;

    private Double checkProfitY1;

    private Double checkProfitY3;

    private Double checkProfitY5;

    private Double productionProfitY1;

    private Double productionProfitY3;

    private Double productionProfitY5;

    private Double cashFlowY1;

    private Double cashFlowY3;

    private Double cashFlowY5;

    private Double rateOfReturnY1;

    private Double rateOfReturnY3;

    private Double rateOfReturnY5;

    private Double paybackPeriodY1;

    private Double paybackPeriodY3;

    private Double paybackPeriodY5;

    private Double netPresentValueY1;

    private Double netPresentValueY3;

    private Double netPresentValueY5;

    private String remark;

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

    private static final long serialVersionUID = 1L;

    public String getInvestmentId() {
        return investmentId;
    }

    public void setInvestmentId(String investmentId) {
        this.investmentId = investmentId;
    }
    @Multiply(10000)
    public Double getSalesIncludeTaxY1() {
        return salesIncludeTaxY1;
    }
    @Divide(10000)
    public void setSalesIncludeTaxY1(Double salesIncludeTaxY1) {
        this.salesIncludeTaxY1 = salesIncludeTaxY1;
    }
    @Multiply(10000)
    public Double getSalesIncludeTaxY3() {
        return salesIncludeTaxY3;
    }
    @Divide(10000)
    public void setSalesIncludeTaxY3(Double salesIncludeTaxY3) {
        this.salesIncludeTaxY3 = salesIncludeTaxY3;
    }
    @Multiply(10000)
    public Double getSalesIncludeTaxY5() {
        return salesIncludeTaxY5;
    }
    @Divide(10000)
    public void setSalesIncludeTaxY5(Double salesIncludeTaxY5) {
        this.salesIncludeTaxY5 = salesIncludeTaxY5;
    }
    @Multiply(10000)
    public Double getTaxAdjustmentEftY1() {
        return taxAdjustmentEftY1;
    }
    @Divide(10000)
    public void setTaxAdjustmentEftY1(Double taxAdjustmentEftY1) {
        this.taxAdjustmentEftY1 = taxAdjustmentEftY1;
    }
    @Multiply(10000)
    public Double getTaxAdjustmentEftY3() {
        return taxAdjustmentEftY3;
    }
    @Divide(10000)
    public void setTaxAdjustmentEftY3(Double taxAdjustmentEftY3) {
        this.taxAdjustmentEftY3 = taxAdjustmentEftY3;
    }
    @Multiply(10000)
    public Double getTaxAdjustmentEftY5() {
        return taxAdjustmentEftY5;
    }
    @Divide(10000)
    public void setTaxAdjustmentEftY5(Double taxAdjustmentEftY5) {
        this.taxAdjustmentEftY5 = taxAdjustmentEftY5;
    }
    
    
    public Double getGrossProfitRadioY1() {
        return grossProfitRadioY1;
    }

    public void setGrossProfitRadioY1(Double grossProfitRadioY1) {
        this.grossProfitRadioY1 = grossProfitRadioY1;
    }
    
    
    public Double getGrossProfitRadioY3() {
        return grossProfitRadioY3;
    }

    public void setGrossProfitRadioY3(Double grossProfitRadioY3) {
        this.grossProfitRadioY3 = grossProfitRadioY3;
    }
    
    
    public Double getGrossProfitRadioY5() {
        return grossProfitRadioY5;
    }

    public void setGrossProfitRadioY5(Double grossProfitRadioY5) {
        this.grossProfitRadioY5 = grossProfitRadioY5;
    }
    
    
    public Double getCostRadioY1() {
        return costRadioY1;
    }

    public void setCostRadioY1(Double costRadioY1) {
        this.costRadioY1 = costRadioY1;
    }
    
    
    public Double getCostRadioY3() {
        return costRadioY3;
    }

    public void setCostRadioY3(Double costRadioY3) {
        this.costRadioY3 = costRadioY3;
    }
    
    
    public Double getCostRadioY5() {
        return costRadioY5;
    }

    public void setCostRadioY5(Double costRadioY5) {
        this.costRadioY5 = costRadioY5;
    }
    
    
    public Double getTaxRentPctY1() {
        return taxRentPctY1;
    }

    public void setTaxRentPctY1(Double taxRentPctY1) {
        this.taxRentPctY1 = taxRentPctY1;
    }
    
    
    public Double getTaxRentPctY3() {
        return taxRentPctY3;
    }

    public void setTaxRentPctY3(Double taxRentPctY3) {
        this.taxRentPctY3 = taxRentPctY3;
    }
    
    
    public Double getTaxRentPctY5() {
        return taxRentPctY5;
    }

    public void setTaxRentPctY5(Double taxRentPctY5) {
        this.taxRentPctY5 = taxRentPctY5;
    }
    @Multiply(10000)
    public Double getCheckProfitY1() {
        return checkProfitY1;
    }
    @Divide(10000)
    public void setCheckProfitY1(Double checkProfitY1) {
        this.checkProfitY1 = checkProfitY1;
    }
    @Multiply(10000)
    public Double getCheckProfitY3() {
        return checkProfitY3;
    }
    @Divide(10000)
    public void setCheckProfitY3(Double checkProfitY3) {
        this.checkProfitY3 = checkProfitY3;
    }
    @Multiply(10000)
    public Double getCheckProfitY5() {
        return checkProfitY5;
    }
    @Divide(10000)
    public void setCheckProfitY5(Double checkProfitY5) {
        this.checkProfitY5 = checkProfitY5;
    }
    @Multiply(10000)
    public Double getProductionProfitY1() {
        return productionProfitY1;
    }
    @Divide(10000)
    public void setProductionProfitY1(Double productionProfitY1) {
        this.productionProfitY1 = productionProfitY1;
    }
    @Multiply(10000)
    public Double getProductionProfitY3() {
        return productionProfitY3;
    }
    @Divide(10000)
    public void setProductionProfitY3(Double productionProfitY3) {
        this.productionProfitY3 = productionProfitY3;
    }
    @Multiply(10000)
    public Double getProductionProfitY5() {
        return productionProfitY5;
    }
    @Divide(10000)
    public void setProductionProfitY5(Double productionProfitY5) {
        this.productionProfitY5 = productionProfitY5;
    }

    public Double getCashFlowY1() {
        return cashFlowY1;
    }

    public void setCashFlowY1(Double cashFlowY1) {
        this.cashFlowY1 = cashFlowY1;
    }

    public Double getCashFlowY3() {
        return cashFlowY3;
    }

    public void setCashFlowY3(Double cashFlowY3) {
        this.cashFlowY3 = cashFlowY3;
    }

    public Double getCashFlowY5() {
        return cashFlowY5;
    }

    public void setCashFlowY5(Double cashFlowY5) {
        this.cashFlowY5 = cashFlowY5;
    }

    public Double getRateOfReturnY1() {
        return rateOfReturnY1;
    }

    public void setRateOfReturnY1(Double rateOfReturnY1) {
        this.rateOfReturnY1 = rateOfReturnY1;
    }

    public Double getRateOfReturnY3() {
        return rateOfReturnY3;
    }

    public void setRateOfReturnY3(Double rateOfReturnY3) {
        this.rateOfReturnY3 = rateOfReturnY3;
    }

    public Double getRateOfReturnY5() {
        return rateOfReturnY5;
    }

    public void setRateOfReturnY5(Double rateOfReturnY5) {
        this.rateOfReturnY5 = rateOfReturnY5;
    }

    public Double getPaybackPeriodY1() {
        return paybackPeriodY1;
    }

    public void setPaybackPeriodY1(Double paybackPeriodY1) {
        this.paybackPeriodY1 = paybackPeriodY1;
    }

    public Double getPaybackPeriodY3() {
        return paybackPeriodY3;
    }

    public void setPaybackPeriodY3(Double paybackPeriodY3) {
        this.paybackPeriodY3 = paybackPeriodY3;
    }

    public Double getPaybackPeriodY5() {
        return paybackPeriodY5;
    }

    public void setPaybackPeriodY5(Double paybackPeriodY5) {
        this.paybackPeriodY5 = paybackPeriodY5;
    }

    public Double getNetPresentValueY1() {
        return netPresentValueY1;
    }

    public void setNetPresentValueY1(Double netPresentValueY1) {
        this.netPresentValueY1 = netPresentValueY1;
    }

    public Double getNetPresentValueY3() {
        return netPresentValueY3;
    }

    public void setNetPresentValueY3(Double netPresentValueY3) {
        this.netPresentValueY3 = netPresentValueY3;
    }

    public Double getNetPresentValueY5() {
        return netPresentValueY5;
    }

    public void setNetPresentValueY5(Double netPresentValueY5) {
        this.netPresentValueY5 = netPresentValueY5;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
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


}
