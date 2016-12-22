package com.stripcode.core.dto.sf;

import java.util.List;

/**
 * Created by Metro on 2016/12/9.
 */
public class QueryCSpipeLineDto {
    private String pageNum;
    private String pageSize;
    private String operationMode;

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    private String city;
    private List<String> operationModes;
    private List<String> storeImages;

    public String getSearchName() {
        return searchName;
    }

    public String getPageNum() {
        return pageNum;
    }

    public void setPageNum(String pageNum) {
        this.pageNum = pageNum;
    }

    public String getPageSize() {
        return pageSize;
    }

    public void setPageSize(String pageSize) {
        this.pageSize = pageSize;
    }

    public String getOperationMode() {
        return operationMode;
    }

    public void setOperationMode(String operationMode) {
        this.operationMode = operationMode;
    }

    public List<String> getOperationModes() {
        return operationModes;
    }

    public void setOperationModes(List<String> operationModes) {
        this.operationModes = operationModes;
    }

    public List<String> getStoreImages() {
        return storeImages;
    }

    public void setStoreImages(List<String> storeImages) {
        this.storeImages = storeImages;
    }

    public void setSearchName(String searchName) {
        this.searchName = searchName;
    }

    private String searchName;
}
