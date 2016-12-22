package com.stripcode.core.dto;

import com.stripcode.mybatis.common.BaseModel;
import com.stripcode.mybatis.sf.model.SFSfApproval;
import org.springframework.beans.BeanUtils;

/**
 * Created by Metro on 2016/12/12.
 */
public class CreateOrModifyApprovalDto extends  BaseModel {
    private String taskId;

    public String getOaTaskId() {
        return oaTaskId;
    }

    public void setOaTaskId(String oaTaskId) {
        this.oaTaskId = oaTaskId;
    }

    private String oaTaskId;
    @Override
    public String getRowId() {
        return rowId;
    }

    @Override
    public void setRowId(String rowId) {
        this.rowId = rowId;
    }

    private String rowId;
    private String approver;
    private String comments;

    @Override
    public String getStatus() {
        return status;
    }

    @Override
    public void setStatus(String status) {
        this.status = status;
    }

    private String status;
    private String processId;

    public String getProcessId() {
        return processId;
    }

    public void setProcessId(String processId) {
        this.processId = processId;
    }

    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }

    public String getApprover() {
        return approver;
    }

    public void setApprover(String approver) {
        this.approver = approver;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }
    public SFSfApproval toModel(){
        SFSfApproval sfSfApproval = new SFSfApproval();
        BeanUtils.copyProperties(this,sfSfApproval);
        return sfSfApproval;
    }
}
