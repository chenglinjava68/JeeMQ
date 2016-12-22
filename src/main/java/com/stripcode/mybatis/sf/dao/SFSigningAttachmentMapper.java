package com.stripcode.mybatis.sf.dao;

import com.stripcode.mybatis.sf.model.SFSigningAttachment;

import java.util.List;

/**
 * @author Metro
 */
public interface SFSigningAttachmentMapper {
    List<SFSigningAttachment> querySigningAttachment(String ppId);

    Integer insertSigningAttachment(SFSigningAttachment model);

    Integer updateSigningAttachment(SFSigningAttachment model);
}
