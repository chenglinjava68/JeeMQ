package com.stripcode.mybatis.sf.dao;

import com.stripcode.mybatis.sf.model.SFStoreHandoverAttachment;

import java.util.List;

/**
 * @author Metro
 */
public interface SFStoreHandoverAttachmentMapper {
    List<SFStoreHandoverAttachment> queryHandoverAttachment(String handoverId);

    Integer insertStoreHandoverAttachment(SFStoreHandoverAttachment model);

    Integer updateStoreHandoverAttachment(SFStoreHandoverAttachment model);
}
