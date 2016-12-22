package com.stripcode.mybatis.sf.dao;

import com.stripcode.mybatis.sf.model.SFLicenceAttachment;

import java.util.List;

/**
 * @author Metro
 */
public interface SFLicenceAttachmentMapper {
    List<SFLicenceAttachment> queryAll(String ppId);

    Integer insertLicenceAttachment(SFLicenceAttachment model);

    Integer updateLicenceAttachment(SFLicenceAttachment model);
}
