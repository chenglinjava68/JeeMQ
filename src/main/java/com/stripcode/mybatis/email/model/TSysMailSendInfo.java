package com.stripcode.mybatis.email.model;

import java.io.Serializable;
import java.util.Date;

public class TSysMailSendInfo implements Serializable {
    private Integer autoNo;

    private String rowId;

    private String subject;

    private String sendAddress;

    private String[] accepetAddress;

    private String[] ccAddress;

    private String content;

    private String isSuccess;

    private String creator;

    private Date createTime;

    private String updater;

    private Date updateTime;

    private String delFlag;

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

    private static final long serialVersionUID = 1L;

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
        this.rowId = rowId == null ? null : rowId.trim();
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject == null ? null : subject.trim();
    }

    public String getSendAddress() {
        return sendAddress;
    }

    public void setSendAddress(String sendAddress) {
        this.sendAddress = sendAddress == null ? null : sendAddress.trim();
    }

    public String[] getAccepetAddress() {
        return accepetAddress;
    }

    public void setAccepetAddress(String[] accepetAddress) {
        this.accepetAddress = accepetAddress;
    }

    public String[] getCcAddress() {
        return ccAddress;
    }

    public void setCcAddress(String[] ccAddress) {
        this.ccAddress = ccAddress;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public String getIsSuccess() {
        return isSuccess;
    }

    public void setIsSuccess(String isSuccess) {
        this.isSuccess = isSuccess == null ? null : isSuccess.trim();
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator == null ? null : creator.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getUpdater() {
        return updater;
    }

    public void setUpdater(String updater) {
        this.updater = updater == null ? null : updater.trim();
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag == null ? null : delFlag.trim();
    }

    public String getDef1() {
        return def1;
    }

    public void setDef1(String def1) {
        this.def1 = def1 == null ? null : def1.trim();
    }

    public String getDef2() {
        return def2;
    }

    public void setDef2(String def2) {
        this.def2 = def2 == null ? null : def2.trim();
    }

    public String getDef3() {
        return def3;
    }

    public void setDef3(String def3) {
        this.def3 = def3 == null ? null : def3.trim();
    }

    public String getDef4() {
        return def4;
    }

    public void setDef4(String def4) {
        this.def4 = def4 == null ? null : def4.trim();
    }

    public String getDef5() {
        return def5;
    }

    public void setDef5(String def5) {
        this.def5 = def5 == null ? null : def5.trim();
    }

    public String getDef6() {
        return def6;
    }

    public void setDef6(String def6) {
        this.def6 = def6 == null ? null : def6.trim();
    }

    public String getDef7() {
        return def7;
    }

    public void setDef7(String def7) {
        this.def7 = def7 == null ? null : def7.trim();
    }

    public String getDef8() {
        return def8;
    }

    public void setDef8(String def8) {
        this.def8 = def8 == null ? null : def8.trim();
    }

    public String getDef9() {
        return def9;
    }

    public void setDef9(String def9) {
        this.def9 = def9 == null ? null : def9.trim();
    }

    public String getDef10() {
        return def10;
    }

    public void setDef10(String def10) {
        this.def10 = def10 == null ? null : def10.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", autoNo=").append(autoNo);
        sb.append(", rowId=").append(rowId);
        sb.append(", subject=").append(subject);
        sb.append(", sendAddress=").append(sendAddress);
        sb.append(", accepetAddress=").append(accepetAddress);
        sb.append(", ccAddress=").append(ccAddress);
        sb.append(", content=").append(content);
        sb.append(", isSuccess=").append(isSuccess);
        sb.append(", creator=").append(creator);
        sb.append(", createTime=").append(createTime);
        sb.append(", updater=").append(updater);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", delFlag=").append(delFlag);
        sb.append(", def1=").append(def1);
        sb.append(", def2=").append(def2);
        sb.append(", def3=").append(def3);
        sb.append(", def4=").append(def4);
        sb.append(", def5=").append(def5);
        sb.append(", def6=").append(def6);
        sb.append(", def7=").append(def7);
        sb.append(", def8=").append(def8);
        sb.append(", def9=").append(def9);
        sb.append(", def10=").append(def10);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        TSysMailSendInfo other = (TSysMailSendInfo) that;
        return (this.getAutoNo() == null ? other.getAutoNo() == null : this.getAutoNo().equals(other.getAutoNo()))
            && (this.getRowId() == null ? other.getRowId() == null : this.getRowId().equals(other.getRowId()))
            && (this.getSubject() == null ? other.getSubject() == null : this.getSubject().equals(other.getSubject()))
            && (this.getSendAddress() == null ? other.getSendAddress() == null : this.getSendAddress().equals(other.getSendAddress()))
            && (this.getAccepetAddress() == null ? other.getAccepetAddress() == null : this.getAccepetAddress().equals(other.getAccepetAddress()))
            && (this.getCcAddress() == null ? other.getCcAddress() == null : this.getCcAddress().equals(other.getCcAddress()))
            && (this.getContent() == null ? other.getContent() == null : this.getContent().equals(other.getContent()))
            && (this.getIsSuccess() == null ? other.getIsSuccess() == null : this.getIsSuccess().equals(other.getIsSuccess()))
            && (this.getCreator() == null ? other.getCreator() == null : this.getCreator().equals(other.getCreator()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getUpdater() == null ? other.getUpdater() == null : this.getUpdater().equals(other.getUpdater()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()))
            && (this.getDelFlag() == null ? other.getDelFlag() == null : this.getDelFlag().equals(other.getDelFlag()))
            && (this.getDef1() == null ? other.getDef1() == null : this.getDef1().equals(other.getDef1()))
            && (this.getDef2() == null ? other.getDef2() == null : this.getDef2().equals(other.getDef2()))
            && (this.getDef3() == null ? other.getDef3() == null : this.getDef3().equals(other.getDef3()))
            && (this.getDef4() == null ? other.getDef4() == null : this.getDef4().equals(other.getDef4()))
            && (this.getDef5() == null ? other.getDef5() == null : this.getDef5().equals(other.getDef5()))
            && (this.getDef6() == null ? other.getDef6() == null : this.getDef6().equals(other.getDef6()))
            && (this.getDef7() == null ? other.getDef7() == null : this.getDef7().equals(other.getDef7()))
            && (this.getDef8() == null ? other.getDef8() == null : this.getDef8().equals(other.getDef8()))
            && (this.getDef9() == null ? other.getDef9() == null : this.getDef9().equals(other.getDef9()))
            && (this.getDef10() == null ? other.getDef10() == null : this.getDef10().equals(other.getDef10()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getAutoNo() == null) ? 0 : getAutoNo().hashCode());
        result = prime * result + ((getRowId() == null) ? 0 : getRowId().hashCode());
        result = prime * result + ((getSubject() == null) ? 0 : getSubject().hashCode());
        result = prime * result + ((getSendAddress() == null) ? 0 : getSendAddress().hashCode());
        result = prime * result + ((getAccepetAddress() == null) ? 0 : getAccepetAddress().hashCode());
        result = prime * result + ((getCcAddress() == null) ? 0 : getCcAddress().hashCode());
        result = prime * result + ((getContent() == null) ? 0 : getContent().hashCode());
        result = prime * result + ((getIsSuccess() == null) ? 0 : getIsSuccess().hashCode());
        result = prime * result + ((getCreator() == null) ? 0 : getCreator().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getUpdater() == null) ? 0 : getUpdater().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
        result = prime * result + ((getDelFlag() == null) ? 0 : getDelFlag().hashCode());
        result = prime * result + ((getDef1() == null) ? 0 : getDef1().hashCode());
        result = prime * result + ((getDef2() == null) ? 0 : getDef2().hashCode());
        result = prime * result + ((getDef3() == null) ? 0 : getDef3().hashCode());
        result = prime * result + ((getDef4() == null) ? 0 : getDef4().hashCode());
        result = prime * result + ((getDef5() == null) ? 0 : getDef5().hashCode());
        result = prime * result + ((getDef6() == null) ? 0 : getDef6().hashCode());
        result = prime * result + ((getDef7() == null) ? 0 : getDef7().hashCode());
        result = prime * result + ((getDef8() == null) ? 0 : getDef8().hashCode());
        result = prime * result + ((getDef9() == null) ? 0 : getDef9().hashCode());
        result = prime * result + ((getDef10() == null) ? 0 : getDef10().hashCode());
        return result;
    }
}