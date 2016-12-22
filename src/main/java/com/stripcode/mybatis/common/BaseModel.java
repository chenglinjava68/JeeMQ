package com.stripcode.mybatis.common;

import com.stripcode.core.util.DateUtil;
import com.stripcode.core.util.WebUtil;
import org.activiti.engine.runtime.ProcessInstance;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Metro on 2016/8/18.
 */
public class BaseModel implements Serializable {
    private String creator;
    private String updater;
    private Date createTime;
    private Date updateTime;
    private String delFlag = "M0015";
    private String status = "M0043";
    private String def1;
    private String def2;
    private String def3;
    private String def4;
    private String def5;
    private String def6;
    private String def7;
    private String def8;
    private String def9;
    private String def10;
    private Integer autoNo;
    private String rowId;
    // 运行中的流程实例
    private ProcessInstance processInstance;
    private String process_instance_id;

    public String getProcess_instance_id() {
        return process_instance_id;
    }
    public void setProcess_instance_id(String process_instance_id) {
        this.process_instance_id = process_instance_id;
    }

    public ProcessInstance getProcessInstance() {
        return processInstance;
    }

    public void setProcessInstance(ProcessInstance processInstance) {
        this.processInstance = processInstance;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    public String getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag;
    }

    public String getDef1() {
        return def1;
    }

    public void setDef1(String def1) {
        this.def1 = def1;
    }

    public String getDef2() {
        return def2;
    }

    public void setDef2(String def2) {
        this.def2 = def2;
    }

    public String getDef3() {
        return def3;
    }

    public void setDef3(String def3) {
        this.def3 = def3;
    }

    public String getDef4() {
        return def4;
    }

    public void setDef4(String def4) {
        this.def4 = def4;
    }

    public String getDef5() {
        return def5;
    }

    public void setDef5(String def5) {
        this.def5 = def5;
    }

    public String getDef6() {
        return def6;
    }

    public void setDef6(String def6) {
        this.def6 = def6;
    }

    public String getDef7() {
        return def7;
    }

    public void setDef7(String def7) {
        this.def7 = def7;
    }

    public String getDef8() {
        return def8;
    }

    public void setDef8(String def8) {
        this.def8 = def8;
    }

    public String getDef9() {
        return def9;
    }

    public void setDef9(String def9) {
        this.def9 = def9;
    }

    public String getDef10() {
        return def10;
    }

    public void setDef10(String def10) {
        this.def10 = def10;
    }

    public Date getUpdateTime() {
        return DateUtil.stringToDate(DateUtil.getDateTime());
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Date getCreateTime() {
        return this.createTime;
    }

    public String getCreator() {
        return WebUtil.getCurrentUser();
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public String getUpdater() {
        return WebUtil.getCurrentUser();
    }

    public Integer getAutoNo() {
        return autoNo;
    }

    public void setAutoNo(Integer autoNo) {
        this.autoNo = autoNo;
    }

    public String getRowId() {
        return rowId;
    }

    public void setRowId(String rowId) {
      /*  if (StringUtils.isBlank(rowId)) {
            rowId = UUIDUtils.generateKey();
        }*/
        this.rowId = rowId == null ? null : rowId.trim();
    }

    public void setUpdater(String updater) {
        this.updater = updater;
    }

    public void setCreateTime(Date createTime) {
        createTime = DateUtil.stringToDate(DateUtil.getDateTime());
        this.createTime = createTime;
    }


    /**
     * 是否是新记录（默认：false），调用setIsNewRecord()设置新记录，使用自定义ID。
     * 设置为true后强制执行插入语句，ID不会自动生成，需从手动传入。
     */
    protected boolean isNewRecord = false;
    /**
     * 插入之前执行方法，需要手动调用
     */
//    public void preInsert(){
//        // 不限制ID为UUID，调用setIsNewRecord()使用自定义ID
//        if (!this.isNewRecord){
//            setAutoNo(IdGen.uuid());
//        }
//    }
}
