package com.stripcode.mybatis.sf.dao;

import com.stripcode.mybatis.sf.model.SFContractApplyAttachment;

import java.util.List;

/**
 * @author Metro
 */
public interface SFContractApplyAttachmentMapper {
    List<SFContractApplyAttachment> queryContractApplyAttachment(String applyId);

    Integer insertContractApplyAttachment(SFContractApplyAttachment model);

    Integer updateContractApplyAttachment(SFContractApplyAttachment model);
}
