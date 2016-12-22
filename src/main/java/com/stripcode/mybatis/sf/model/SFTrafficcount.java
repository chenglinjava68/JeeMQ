package com.stripcode.mybatis.sf.model;

import com.stripcode.mybatis.common.BaseModel;

/**
 * @author Metro
 */
public class SFTrafficcount extends BaseModel {
    private String rowId;
    private String ppId;
    private int pedestrianD1;
    private int pedestrianD2;
    private int pedestrianD3;
    private double annualSalesEst;
    private int pedestrianWeek;
    private double entryRate;
    private double turnoverRate;
    private double guestAvg;
    private double weekSales;
    private double monthPct;
    private String pedestrianD1Af;
    private String pedestrianD2Af;
    private String pedestrianD3Af;
    private String annualSalesEstAf;
    private int pedestrianWeekAf;
    private double entryRateAf;
    private double turnoverRateAf;
    private String guestAvgAf;
    private String weekSalesAf;
    private double monthPctAf;
    private String attachId;
    private String userName;
    private String fileName;
    private String filePath;
    private String testSite;
    private String startDate;
    private String endDate;
    private String timeSlot;
    private String useStatus;

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getTimeSlot() {
        return timeSlot;
    }

    public void setTimeSlot(String timeSlot) {
        this.timeSlot = timeSlot;
    }

    public String getTestSite() {
        return testSite;
    }

    public void setTestSite(String testSite) {
        this.testSite = testSite;
    }

    public String getUseStatus() {
        return useStatus;
    }

    public void setUseStatus(String useStatus) {
        this.useStatus = useStatus;
    }

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

    public String getAttachId() {
        return attachId;
    }

    public void setAttachId(String attachId) {
        this.attachId = attachId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
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

    public int getPedestrianD1() {
        return pedestrianD1;
    }

    public void setPedestrianD1(int pedestrianD1) {
        this.pedestrianD1 = pedestrianD1;
    }

    public int getPedestrianD2() {
        return pedestrianD2;
    }

    public void setPedestrianD2(int pedestrianD2) {
        this.pedestrianD2 = pedestrianD2;
    }

    public int getPedestrianD3() {
        return pedestrianD3;
    }

    public void setPedestrianD3(int pedestrianD3) {
        this.pedestrianD3 = pedestrianD3;
    }

    public double getAnnualSalesEst() {
        return annualSalesEst;
    }

    public void setAnnualSalesEst(double annualSalesEst) {
        this.annualSalesEst = annualSalesEst;
    }

    public int getPedestrianWeek() {
        return pedestrianWeek;
    }

    public void setPedestrianWeek(int pedestrianWeek) {
        this.pedestrianWeek = pedestrianWeek;
    }

    public double getEntryRate() {
        return entryRate;
    }

    public void setEntryRate(double entryRate) {
        this.entryRate = entryRate;
    }

    public double getTurnoverRate() {
        return turnoverRate;
    }

    public void setTurnoverRate(double turnoverRate) {
        this.turnoverRate = turnoverRate;
    }

    public double getGuestAvg() {
        return guestAvg;
    }

    public void setGuestAvg(double guestAvg) {
        this.guestAvg = guestAvg;
    }

    public double getWeekSales() {
        return weekSales;
    }

    public void setWeekSales(double weekSales) {
        this.weekSales = weekSales;
    }

    public double getMonthPct() {
        return monthPct;
    }

    public void setMonthPct(double monthPct) {
        this.monthPct = monthPct;
    }

    public String getPedestrianD1Af() {
        return pedestrianD1Af;
    }

    public void setPedestrianD1Af(String pedestrianD1Af) {
        this.pedestrianD1Af = pedestrianD1Af;
    }

    public String getPedestrianD2Af() {
        return pedestrianD2Af;
    }

    public void setPedestrianD2Af(String pedestrianD2Af) {
        this.pedestrianD2Af = pedestrianD2Af;
    }

    public String getPedestrianD3Af() {
        return pedestrianD3Af;
    }

    public void setPedestrianD3Af(String pedestrianD3Af) {
        this.pedestrianD3Af = pedestrianD3Af;
    }

    public String getAnnualSalesEstAf() {
        return annualSalesEstAf;
    }

    public void setAnnualSalesEstAf(String annualSalesEstAf) {
        this.annualSalesEstAf = annualSalesEstAf;
    }

    public int getPedestrianWeekAf() {
        return pedestrianWeekAf;
    }

    public void setPedestrianWeekAf(int pedestrianWeekAf) {
        this.pedestrianWeekAf = pedestrianWeekAf;
    }

    public double getEntryRateAf() {
        return entryRateAf;
    }

    public void setEntryRateAf(double entryRateAf) {
        this.entryRateAf = entryRateAf;
    }

    public String getGuestAvgAf() {
        return guestAvgAf;
    }

    public void setGuestAvgAf(String guestAvgAf) {
        this.guestAvgAf = guestAvgAf;
    }

    public String getWeekSalesAf() {
        return weekSalesAf;
    }

    public void setWeekSalesAf(String weekSalesAf) {
        this.weekSalesAf = weekSalesAf;
    }

    public double getTurnoverRateAf() {
        return turnoverRateAf;
    }

    public void setTurnoverRateAf(double turnoverRateAf) {
        this.turnoverRateAf = turnoverRateAf;
    }

    public double getMonthPctAf() {
        return monthPctAf;
    }

    public void setMonthPctAf(double monthPctAf) {
        this.monthPctAf = monthPctAf;
    }

}
