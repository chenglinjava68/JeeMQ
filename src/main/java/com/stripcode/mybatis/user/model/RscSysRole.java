
package com.stripcode.mybatis.user.model;

import com.stripcode.core.util.excelUtil.annotation.ExcelField;
import com.stripcode.mybatis.common.BaseModel;

import java.io.Serializable;
import java.util.List;

public class RscSysRole extends BaseModel implements Serializable {
    private String roleId;

    private Integer rolecode;

    private String roleName;

    @ExcelField(title="状态", align=1, sort=3)
    public String getStatusName() {
        return statusName;
    }

    public void setStatusName(String statusName) {
        this.statusName = statusName;
    }

    private String statusName;

    private String comments;

    private Integer iseffective;

    private Integer userange;

    private Integer isinternal;

    private Integer sortno;

    private String roletype;

    List<RscSysRoleusermap> rscSysRoleusermaps;
    public void setRscSysRoleusermaps( List<RscSysRoleusermap> rscSysRoleusermaps){
        this.rscSysRoleusermaps = rscSysRoleusermaps;
    }
    public  List<RscSysRoleusermap> getRscSysRoleusermaps(){
        return rscSysRoleusermaps;
    }

    private static final long serialVersionUID = 1L;

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    @ExcelField(title="角色编码", align=1, sort=1)
    public Integer getRolecode() {
        return rolecode;
    }

    public void setRolecode(Integer rolecode) {
        this.rolecode = rolecode;
    }

    @ExcelField(title="角色名称", align=1, sort=2)
    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName == null ? null : roleName.trim();
    }

    @ExcelField(title="备注", align=1, sort=4)
    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments == null ? null : comments.trim();
    }

    public Integer getIseffective() {
        return iseffective;
    }

    public void setIseffective(Integer iseffective) {
        this.iseffective = iseffective;
    }

    public Integer getUserange() {
        return userange;
    }

    public void setUserange(Integer userange) {
        this.userange = userange;
    }

    public Integer getIsinternal() {
        return isinternal;
    }

    public void setIsinternal(Integer isinternal) {
        this.isinternal = isinternal;
    }

    public Integer getSortno() {
        return sortno;
    }

    public void setSortno(Integer sortno) {
        this.sortno = sortno;
    }

    public String getRoletype() {
        return roletype;
    }

    public void setRoletype(String roletype) {
        this.roletype = roletype == null ? null : roletype.trim();
    }
}