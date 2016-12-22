package com.stripcode.core.dto.cs;

import com.stripcode.mybatis.cs.model.CSCustomerErpInfo;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.beans.BeanUtils;

/**
 * Created by Metro on 2016/8/23.
 */
public class CreateOrModifyCustomerErpRate {
    private String customerId;
    @NotEmpty(message = "基本折率不能为空")
    private Double basicDiscountRate; //基本折率
    private String remark; //备注

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public Double getBasicDiscountRate() {
        return basicDiscountRate;
    }

    public void setBasicDiscountRate(Double basicDiscountRate) {
        this.basicDiscountRate = basicDiscountRate;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public CSCustomerErpInfo toModel(){
        CSCustomerErpInfo csCustomerErpInfo = new CSCustomerErpInfo();
        BeanUtils.copyProperties(this ,csCustomerErpInfo);
        return csCustomerErpInfo;
    }
}
