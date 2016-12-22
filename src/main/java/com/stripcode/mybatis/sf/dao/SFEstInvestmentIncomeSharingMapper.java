package com.stripcode.mybatis.sf.dao;

import com.stripcode.mybatis.sf.model.SFEstInvestmentIncomeSharing;
import java.util.List;

public interface SFEstInvestmentIncomeSharingMapper {
    int deleteByPrimaryKey(Integer rowId);

    int insert(SFEstInvestmentIncomeSharing record);

    SFEstInvestmentIncomeSharing selectByPrimaryKey(String rowId);

    List<SFEstInvestmentIncomeSharing> selectByInvestmentId(String investmentId);

    List<SFEstInvestmentIncomeSharing> selectByInvestmentIdForDirect(String investmentId);

    List<SFEstInvestmentIncomeSharing> selectByPPId(String ppId);

    List<SFEstInvestmentIncomeSharing> selectByPPIdForDirect(String ppId);

    List<SFEstInvestmentIncomeSharing> selectAll();

    int updateByPrimaryKey(SFEstInvestmentIncomeSharing record);

    int deleteByInvestmentId(String investmentId);
}