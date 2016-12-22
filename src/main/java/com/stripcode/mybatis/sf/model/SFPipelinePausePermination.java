package com.stripcode.mybatis.sf.model;

import com.stripcode.mybatis.common.BaseModel;

/**
 * Created by Metro on 2016/9/26.
 */
public class SFPipelinePausePermination extends BaseModel{
    private String ppId; //意向店Id
    private String itemType; //项目类型(暂停、终止)
    private String reason;//原因
    private String nextPlan;//下一步计划
    public String getPpId() {
        return ppId;
    }

    public void setPpId(String ppId) {
        this.ppId = ppId;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getItemType() {
        return itemType;
    }

    public void setItemType(String itemType) {
        this.itemType = itemType;
    }

    public String getNextPlan() {
        return nextPlan;
    }

    public void setNextPlan(String nextPlan) {
        this.nextPlan = nextPlan;
    }
}
