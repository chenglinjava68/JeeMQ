package com.stripcode.service.enums;

import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Metro on 2016/8/5.
 */
public enum WorkStatusEnum{
    BEST(1,"很好"),BETTER(2,"好"),GOOD(3,"良好"),NORMAL(4,"正常"),BAD(5,"差"),WORST(6,"很差");
    private Integer key;
    private String value;

    public Integer getKey() {
        return key;
    }

    public void setKey(Integer key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    private WorkStatusEnum(Integer key,String value){
        this.key = key;
        this.value = value;

    }

    @Override
    public String toString() {
        return "{" +
                "\"key\":" + key +
                ", \"value\":'" + value + '\'' +
                '}';
    }


    public static  List<JSONObject> toJsonArray(){
        List<JSONObject> list = new ArrayList<JSONObject>();
        for (WorkStatusEnum workStatusEnum : WorkStatusEnum.values()){
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("key",workStatusEnum.getKey());
            jsonObject.put("value",workStatusEnum.getValue());
            list.add(jsonObject);
        }
        return list;
    }
}
