package com.stripcode.mybatis.sf.dao;
import com.stripcode.mybatis.sf.model.SFRentalProposalAttachment;
import com.stripcode.mybatis.sf.model.SFRentalProposalCopartnerStore;
import com.stripcode.mybatis.sf.model.TSfEstInvestmentNonLaborCost;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by Metro on 2016/11/15
 */
public interface SFRentalProposalCopartnerStoreMapper {
    //查询合伙租金提案
    SFRentalProposalCopartnerStore  selectCopartnerStore(String ppId);
    //插入
    Integer insertCopartnerStore(SFRentalProposalCopartnerStore sfRentalProposalCopartnerStore);
    //修改
    Integer updateCopartnerStore(SFRentalProposalCopartnerStore sfRentalProposalCopartnerStore);
    //是否存在
    Integer isExistsCopartnerStore(@Param("rowId")String rowId,@Param("ppId")String ppId);
    //查询合伙租金提案
    List<SFRentalProposalAttachment> selectProposalAttachment(String ppId);

    TSfEstInvestmentNonLaborCost selectProposalForInvestment(String ppId);
}
