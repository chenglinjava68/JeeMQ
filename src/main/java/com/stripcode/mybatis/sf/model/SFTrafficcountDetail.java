package com.stripcode.mybatis.sf.model;

import com.stripcode.mybatis.common.BaseModel;

/**
 * @author Metro
 */
public class SFTrafficcountDetail extends BaseModel {
    private String testId;
    private String day1;
    private String day2;
    private String day3;
    private String timeInterval;
    private int pedestrianFlow;

    public String getTestId() {
        return testId;
    }

    public void setTestId(String testId) {
        this.testId = testId;
    }

    public String getDay1() {
        return day1;
    }

    public void setDay1(String day1) {
        this.day1 = day1;
    }

    public String getDay2() {
        return day2;
    }

    public void setDay2(String day2) {
        this.day2 = day2;
    }

    public String getDay3() {
        return day3;
    }

    public void setDay3(String day3) {
        this.day3 = day3;
    }

    public String getTimeInterval() {
        return timeInterval;
    }

    public void setTimeInterval(String timeInterval) {
        this.timeInterval = timeInterval;
    }

    public int getPedestrianFlow() {
        return pedestrianFlow;
    }

    public void setPedestrianFlow(int pedestrianFlow) {
        this.pedestrianFlow = pedestrianFlow;
    }
}
