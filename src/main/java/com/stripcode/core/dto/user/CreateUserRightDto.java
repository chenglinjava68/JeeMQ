package com.stripcode.core.dto.user;

import com.stripcode.mybatis.user.model.TSysUserDataRight;

import java.util.List;

/**
 * Created by Metro on 2016/9/26.
 */
public class CreateUserRightDto {
    public String getPositionId() {
        return positionId;
    }

    public void setPositionId(String positionId) {
        this.positionId = positionId;
    }

    private String positionId;
    public List<TSysUserDataRight> getUserRights() {
        return userRights;
    }

    public void setUserRights(List<TSysUserDataRight> userRights) {
        this.userRights = userRights;
    }

    private List<TSysUserDataRight> userRights;
}
