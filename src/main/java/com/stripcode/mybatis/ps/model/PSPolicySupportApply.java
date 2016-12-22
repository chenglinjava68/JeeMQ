package com.stripcode.mybatis.ps.model;

import com.stripcode.mybatis.common.BaseModel;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Metro on 2016/12/9.
 */
public class PSPolicySupportApply extends BaseModel implements Serializable{
    private String checkId;//考核单号
    private String originator;//发起人
    private String creator;//创建者
    private Date createTime;//创建时间
    private String updater;//更新者
    private Date updateTime;//更新时间

    public String getCheckId() {
        return checkId;
    }

    public void setCheckId(String checkId) {
        this.checkId = checkId;
    }

    public String getOriginator() {
        return originator;
    }

    public void setOriginator(String originator) {
        this.originator = originator;
    }

    @Override
    public String getCreator() {
        return creator;
    }

    @Override
    public void setCreator(String creator) {
        this.creator = creator;
    }

    @Override
    public Date getCreateTime() {
        return createTime;
    }

    @Override
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public Date getUpdateTime() {
        return updateTime;
    }

    @Override
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String getUpdater() {
        return updater;
    }

    @Override
    public void setUpdater(String updater) {
        this.updater = updater;
    }
}
