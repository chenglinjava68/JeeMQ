package com.stripcode.core.dto.user;

import com.stripcode.mybatis.common.BaseModel;
import com.stripcode.mybatis.user.model.RscSysRole;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.beans.BeanUtils;

/**
 * Created by Metro on 2016/8/12.
 */
public class CreateOrModifyRoleDto extends BaseModel {

    private static final long serialVersionUID = 1L;
    private String roleId;
    private Integer rolecode;
    @NotEmpty(message = "角色名不能为空！")
    private String roleName;

    private String comments;

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public Integer getRolecode() {
        return rolecode;
    }

    public void setRolecode(Integer rolecode) {
        this.rolecode = rolecode;
    }


    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName == null ? null : roleName.trim();
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments == null ? null : comments.trim();
    }

    public RscSysRole toModel(){
        RscSysRole rscSysRole = new RscSysRole();
        BeanUtils.copyProperties(this,rscSysRole);
        return rscSysRole;
    }
}
