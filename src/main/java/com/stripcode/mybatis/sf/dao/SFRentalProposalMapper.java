package com.stripcode.mybatis.sf.dao;

import com.stripcode.mybatis.sf.model.SFRentalProposal;
import com.stripcode.mybatis.sf.model.SFRentalProposalAttachment;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by Metro on 2016/9/28.
 */
public interface SFRentalProposalMapper {
    //添加
    Integer insertRentalProposal(SFRentalProposal sfRentalProposal);
    //修改
    Integer updateRentalProposal(SFRentalProposal sfRentalProposal);
    //查询是否存在
    Integer isExistsRentalProposal(@Param("rowId")String rowId,@Param("ppId")String ppId);
    //查询
    SFRentalProposal selectProposal(@Param("ppId")String ppId);
    //查询租金提案附件
    List<SFRentalProposalAttachment> selectAttachment(String ppId);
    //添加租金附件
    Integer insertAttachment(SFRentalProposalAttachment sfRentalProposalAttachment);
    //查询租金附件是否存在
    Integer isExistsAttachment(@Param("rowId")String rowId,@Param("templateId")String templateId);
    //修改租金附件
    Integer updateAttachment(SFRentalProposalAttachment sfRentalProposalAttachment);

}
