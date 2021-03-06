package com.stripcode.mybatis.generator.model;

import java.io.Serializable;

public class SysCatalog implements Serializable {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_catalog.id_
     *
     * @mbggenerated
     */
    private Integer id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_catalog.cascade_id
     *
     * @mbggenerated
     */
    private String cascadeId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_catalog.root_key
     *
     * @mbggenerated
     */
    private String rootKey;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_catalog.root_name
     *
     * @mbggenerated
     */
    private String rootName;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_catalog.name_
     *
     * @mbggenerated
     */
    private String name;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_catalog.hotkey_
     *
     * @mbggenerated
     */
    private String hotkey;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_catalog.parent_id
     *
     * @mbggenerated
     */
    private String parentId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_catalog.is_leaf_
     *
     * @mbggenerated
     */
    private String isLeaf;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_catalog.is_auto_expand
     *
     * @mbggenerated
     */
    private String isAutoExpand;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_catalog.icon_name
     *
     * @mbggenerated
     */
    private String iconName;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_catalog.sort_no
     *
     * @mbggenerated
     */
    private Integer sortNo;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table sys_catalog
     *
     * @mbggenerated
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_catalog.id_
     *
     * @return the value of sys_catalog.id_
     *
     * @mbggenerated
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_catalog.id_
     *
     * @param id the value for sys_catalog.id_
     *
     * @mbggenerated
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_catalog.cascade_id
     *
     * @return the value of sys_catalog.cascade_id
     *
     * @mbggenerated
     */
    public String getCascadeId() {
        return cascadeId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_catalog.cascade_id
     *
     * @param cascadeId the value for sys_catalog.cascade_id
     *
     * @mbggenerated
     */
    public void setCascadeId(String cascadeId) {
        this.cascadeId = cascadeId == null ? null : cascadeId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_catalog.root_key
     *
     * @return the value of sys_catalog.root_key
     *
     * @mbggenerated
     */
    public String getRootKey() {
        return rootKey;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_catalog.root_key
     *
     * @param rootKey the value for sys_catalog.root_key
     *
     * @mbggenerated
     */
    public void setRootKey(String rootKey) {
        this.rootKey = rootKey == null ? null : rootKey.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_catalog.root_name
     *
     * @return the value of sys_catalog.root_name
     *
     * @mbggenerated
     */
    public String getRootName() {
        return rootName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_catalog.root_name
     *
     * @param rootName the value for sys_catalog.root_name
     *
     * @mbggenerated
     */
    public void setRootName(String rootName) {
        this.rootName = rootName == null ? null : rootName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_catalog.name_
     *
     * @return the value of sys_catalog.name_
     *
     * @mbggenerated
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_catalog.name_
     *
     * @param name the value for sys_catalog.name_
     *
     * @mbggenerated
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_catalog.hotkey_
     *
     * @return the value of sys_catalog.hotkey_
     *
     * @mbggenerated
     */
    public String getHotkey() {
        return hotkey;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_catalog.hotkey_
     *
     * @param hotkey the value for sys_catalog.hotkey_
     *
     * @mbggenerated
     */
    public void setHotkey(String hotkey) {
        this.hotkey = hotkey == null ? null : hotkey.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_catalog.parent_id
     *
     * @return the value of sys_catalog.parent_id
     *
     * @mbggenerated
     */
    public String getParentId() {
        return parentId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_catalog.parent_id
     *
     * @param parentId the value for sys_catalog.parent_id
     *
     * @mbggenerated
     */
    public void setParentId(String parentId) {
        this.parentId = parentId == null ? null : parentId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_catalog.is_leaf_
     *
     * @return the value of sys_catalog.is_leaf_
     *
     * @mbggenerated
     */
    public String getIsLeaf() {
        return isLeaf;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_catalog.is_leaf_
     *
     * @param isLeaf the value for sys_catalog.is_leaf_
     *
     * @mbggenerated
     */
    public void setIsLeaf(String isLeaf) {
        this.isLeaf = isLeaf == null ? null : isLeaf.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_catalog.is_auto_expand
     *
     * @return the value of sys_catalog.is_auto_expand
     *
     * @mbggenerated
     */
    public String getIsAutoExpand() {
        return isAutoExpand;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_catalog.is_auto_expand
     *
     * @param isAutoExpand the value for sys_catalog.is_auto_expand
     *
     * @mbggenerated
     */
    public void setIsAutoExpand(String isAutoExpand) {
        this.isAutoExpand = isAutoExpand == null ? null : isAutoExpand.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_catalog.icon_name
     *
     * @return the value of sys_catalog.icon_name
     *
     * @mbggenerated
     */
    public String getIconName() {
        return iconName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_catalog.icon_name
     *
     * @param iconName the value for sys_catalog.icon_name
     *
     * @mbggenerated
     */
    public void setIconName(String iconName) {
        this.iconName = iconName == null ? null : iconName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_catalog.sort_no
     *
     * @return the value of sys_catalog.sort_no
     *
     * @mbggenerated
     */
    public Integer getSortNo() {
        return sortNo;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_catalog.sort_no
     *
     * @param sortNo the value for sys_catalog.sort_no
     *
     * @mbggenerated
     */
    public void setSortNo(Integer sortNo) {
        this.sortNo = sortNo;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_catalog
     *
     * @mbggenerated
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", cascadeId=").append(cascadeId);
        sb.append(", rootKey=").append(rootKey);
        sb.append(", rootName=").append(rootName);
        sb.append(", name=").append(name);
        sb.append(", hotkey=").append(hotkey);
        sb.append(", parentId=").append(parentId);
        sb.append(", isLeaf=").append(isLeaf);
        sb.append(", isAutoExpand=").append(isAutoExpand);
        sb.append(", iconName=").append(iconName);
        sb.append(", sortNo=").append(sortNo);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_catalog
     *
     * @mbggenerated
     */
    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        SysCatalog other = (SysCatalog) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getCascadeId() == null ? other.getCascadeId() == null : this.getCascadeId().equals(other.getCascadeId()))
            && (this.getRootKey() == null ? other.getRootKey() == null : this.getRootKey().equals(other.getRootKey()))
            && (this.getRootName() == null ? other.getRootName() == null : this.getRootName().equals(other.getRootName()))
            && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
            && (this.getHotkey() == null ? other.getHotkey() == null : this.getHotkey().equals(other.getHotkey()))
            && (this.getParentId() == null ? other.getParentId() == null : this.getParentId().equals(other.getParentId()))
            && (this.getIsLeaf() == null ? other.getIsLeaf() == null : this.getIsLeaf().equals(other.getIsLeaf()))
            && (this.getIsAutoExpand() == null ? other.getIsAutoExpand() == null : this.getIsAutoExpand().equals(other.getIsAutoExpand()))
            && (this.getIconName() == null ? other.getIconName() == null : this.getIconName().equals(other.getIconName()))
            && (this.getSortNo() == null ? other.getSortNo() == null : this.getSortNo().equals(other.getSortNo()));
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_catalog
     *
     * @mbggenerated
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getCascadeId() == null) ? 0 : getCascadeId().hashCode());
        result = prime * result + ((getRootKey() == null) ? 0 : getRootKey().hashCode());
        result = prime * result + ((getRootName() == null) ? 0 : getRootName().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getHotkey() == null) ? 0 : getHotkey().hashCode());
        result = prime * result + ((getParentId() == null) ? 0 : getParentId().hashCode());
        result = prime * result + ((getIsLeaf() == null) ? 0 : getIsLeaf().hashCode());
        result = prime * result + ((getIsAutoExpand() == null) ? 0 : getIsAutoExpand().hashCode());
        result = prime * result + ((getIconName() == null) ? 0 : getIconName().hashCode());
        result = prime * result + ((getSortNo() == null) ? 0 : getSortNo().hashCode());
        return result;
    }
}