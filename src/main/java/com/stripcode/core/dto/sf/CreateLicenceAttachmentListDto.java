package com.stripcode.core.dto.sf;

import com.stripcode.mybatis.sf.model.SFLicenceAttachment;

import java.util.List;

/**
 * Created by Metro on 2016/10/24.
 */
public class CreateLicenceAttachmentListDto {
    private List<SFLicenceAttachment> list;

    public List<SFLicenceAttachment> getList() {
        return list;
    }

    public void setList(List<SFLicenceAttachment> list) {
        this.list = list;
    }
}
