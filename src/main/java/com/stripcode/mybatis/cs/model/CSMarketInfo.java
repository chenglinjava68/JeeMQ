package com.stripcode.mybatis.cs.model;

import com.stripcode.mybatis.common.BaseModel;


public class CSMarketInfo extends BaseModel {
    private String authorizationId;
    private String marketId;
    private String accreditStartDate;
    private String accreditEndDate;

    public String getAccreditStartDate() {
        return accreditStartDate;
    }

    public void setAccreditStartDate(String accreditStartDate) {
        this.accreditStartDate = accreditStartDate;
    }

    public String getAccreditEndDate() {
        return accreditEndDate;
    }

    public void setAccreditEndDate(String accreditEndDate) {
        this.accreditEndDate = accreditEndDate;
    }

    public String getAuthorizationId() {
        return authorizationId;
    }

    public void setAuthorizationId(String authorizationId) {
        this.authorizationId = authorizationId;
    }

    public String getMarketId() {
        return marketId;
    }

    public void setMarketId(String marketId) {
        this.marketId = marketId;
    }
}
