package com.stripcode.mybatis.sf.model;

import com.stripcode.core.util.excelUtil.annotation.ExcelField;
import com.stripcode.mybatis.common.BaseModel;

/**
 * @author Metro
 */
public class SFLandlordNegotiation extends BaseModel {
    private String rowId;
    private String ppId;
    private String topic;
    private String dateTime;
    private String llParticipant;
    private String mbParticipant;
    private String rental;
    private String mgFee;
    private String penalty;
    private String points;
    private String freeRent;
    private String location;
    private String content;
    private String attachId;

    private String fileName;
    private String filePath;


    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public String getRowId() {
        return rowId;
    }

    @Override
    public void setRowId(String rowId) {
        this.rowId = rowId;
    }

    public String getPpId() {
        return ppId;
    }

    public void setPpId(String ppId) {
        this.ppId = ppId;
    }

    @ExcelField(title="谈判主题", align=1, sort=1)
    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    @ExcelField(title="谈判时间", align=1, sort=2)
    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    @ExcelField(title="业主方参与人", align=1, sort=3)
    public String getLlParticipant() {
        return llParticipant;
    }

    public void setLlParticipant(String llParticipant) {
        this.llParticipant = llParticipant;
    }

    @ExcelField(title="本公司参与人", align=1, sort=4)
    public String getMbParticipant() {
        return mbParticipant;
    }

    public void setMbParticipant(String mbParticipant) {
        this.mbParticipant = mbParticipant;
    }

    @ExcelField(title="租金说明", align=1, sort=5)
    public String getRental() {
        return rental;
    }

    public void setRental(String rental) {
        this.rental = rental;
    }

    @ExcelField(title="管理费说明", align=1, sort=6)
    public String getMgFee() {
        return mgFee;
    }

    public void setMgFee(String mgFee) {
        this.mgFee = mgFee;
    }

    @ExcelField(title="违约金说明", align=1, sort=7)
    public String getPenalty() {
        return penalty;
    }

    public void setPenalty(String penalty) {
        this.penalty = penalty;
    }

    @ExcelField(title="扣点说明", align=1, sort=8)
    public String getPoints() {
        return points;
    }

    public void setPoints(String points) {
        this.points = points;
    }

    @ExcelField(title="免租期说明", align=1, sort=9)
    public String getFreeRent() {
        return freeRent;
    }

    public void setFreeRent(String freeRent) {
        this.freeRent = freeRent;
    }

    @ExcelField(title="谈判地点", align=1, sort=10)
    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @ExcelField(title="谈判内容", align=1, sort=11)
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAttachId() {
        return attachId;
    }

    public void setAttachId(String attachId) {
        this.attachId = attachId;
    }
}
