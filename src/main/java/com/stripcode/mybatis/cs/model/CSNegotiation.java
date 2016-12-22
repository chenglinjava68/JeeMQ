package com.stripcode.mybatis.cs.model;

import com.stripcode.core.util.excelUtil.annotation.ExcelField;
import com.stripcode.mybatis.common.BaseModel;

import java.io.Serializable;

/**
 * @author Metro
 */
public class CSNegotiation extends BaseModel implements Serializable {
    private Integer recordId;
    private String customerId;
    private String corporation;
    private String dateTime;
    private String location;
    private String topic;
    private String landlord;
    private String mbParticipant;
    private String commType;
    private String content;
    private String conlusion;
    private String beforeTime;

    public Integer getRecordId() {
        return recordId;
    }

    public void setRecordId(Integer recordId) {
        this.recordId = recordId;
    }

    public String getBeforeTime() {
//        try {
//            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd H-m-s");
//            Date date = new Date();
//            Date datetime = format.parse(dateTime);
//            if(date.getYear() == datetime.getYear()|| date.getMonth()-datetime.getMonth()<12){
//                if(date.getMonth()==datetime.getMonth()){
//                    if(date.getDay()==datetime.getDay()){
//                        if(date.getHours()==datetime.getHours()){
//                            return beforeTime = String.valueOf(date.getMinutes()-datetime.getMinutes())+"分钟前";
//                        }
//                        return beforeTime = String.valueOf(date.getMinutes()-datetime.getMinutes())+"小时前";
//                    }
//                    return beforeTime = String.valueOf(date.getMinutes()-datetime.getMinutes())+"天前";
//                }
//                return beforeTime = String.valueOf(date.getMinutes()-datetime.getMinutes())+"月前";
//            }else {
//                return beforeTime = String.valueOf(date.)
//            }
//            beforeTime = String.valueOf((date.getTime() - datetime.getTime())/(24*60*60*1000));
//        }catch (ParseException e){
//            e.printStackTrace();
//        }
        return beforeTime;
    }

    public void setBeforeTime(String beforeTime) {
        this.beforeTime = beforeTime;
    }

    public String getCorporation() {
        return corporation;
    }

    public void setCorporation(String corporation) {
        this.corporation = corporation;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    @ExcelField(title="谈判时间", align=1, sort=2)
    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    @ExcelField(title="谈判地点", align=1, sort=7)
    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @ExcelField(title="谈判主题", align=1, sort=1)
    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    @ExcelField(title="业主方参与人", align=1, sort=3)
    public String getLandlord() {
        return landlord;
    }

    public void setLandlord(String landlord) {
        this.landlord = landlord;
    }

    @ExcelField(title="本公司参与人", align=1, sort=4)
    public String getMbParticipant() {
        return mbParticipant;
    }

    public void setMbParticipant(String mbParticipant) {
        this.mbParticipant = mbParticipant;
    }

    @ExcelField(title="谈判方式", align=1, sort=5)
    public String getCommType() {
        return commType;
    }

    public void setCommType(String commType) {
        this.commType = commType;
    }

    @ExcelField(title="谈判内容", align=1, sort=6)
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getConlusion() {
        return conlusion;
    }

    public void setConlusion(String conlusion) {
        this.conlusion = conlusion;
    }
}
