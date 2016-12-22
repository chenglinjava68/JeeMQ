package com.stripcode.mybatis.sf.dao;

import com.stripcode.mybatis.sf.model.SFPolicySupportAgreeAttachment;

import java.util.List;

/**
 * Created by Metro on 2016/10/21.
 */
public interface SFPolicySupportAgreeAttachmentMapper {
    List<SFPolicySupportAgreeAttachment> selectSFPolicyDetail(String ppId);
    List<SFPolicySupportAgreeAttachment> selectSFPolicySupportAgreeAttachment(String ppId);
    List<SFPolicySupportAgreeAttachment> selectSFPolicySupportAttachment(String ppId);
    List<SFPolicySupportAgreeAttachment> selectSFPolicyAttachment(String ppId);
    int update(SFPolicySupportAgreeAttachment templateId);
    int insert(SFPolicySupportAgreeAttachment templateId);
    List<SFPolicySupportAgreeAttachment> selectPpId(String ppId);

}
