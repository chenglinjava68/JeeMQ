package com.stripcode.mybatis.sf.dao;

import com.stripcode.mybatis.sf.model.TSfEstInvestmentPayrollForecastCopartner;
import java.util.List;

public interface TSfEstInvestmentPayrollForecastCopartnerMapper {
    int deleteByRowId(String rowId);

    int insertInvestmentPayrollForecastCopartner(TSfEstInvestmentPayrollForecastCopartner record);

    List<TSfEstInvestmentPayrollForecastCopartner> selectInvestmentPayrollForecastCopartner(String investmentId);

    int updateInvestmentPayrollForecastCopartner(TSfEstInvestmentPayrollForecastCopartner record);

    int deleteByInvestmentId(String investmentId);
}