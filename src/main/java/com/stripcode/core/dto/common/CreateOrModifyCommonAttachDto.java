package com.stripcode.core.dto.common;

import com.stripcode.mybatis.cs.model.TSysCommonattached;

import java.util.List;

/**
 * Created by Metro on 2016/11/17.
 */
public class CreateOrModifyCommonAttachDto {
   private String attachId;
    public List<TSysCommonattached> getAttachs() {
        return attachs;
    }

    public void setAttachs(List<TSysCommonattached> attachs) {
        this.attachs = attachs;
    }

    public String getAttachId() {
        return attachId;
    }

    public void setAttachId(String attachId) {
        this.attachId = attachId;
    }

    private List<TSysCommonattached> attachs;
}
