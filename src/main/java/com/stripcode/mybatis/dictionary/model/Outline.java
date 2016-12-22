package com.stripcode.mybatis.dictionary.model;


import java.io.Serializable;

public class Outline implements Serializable
{
	
	private static final long serialVersionUID = 1L;

	private String title;
	private String editurl;
	private String xtype;

	private String url;
	private String parentCode;// 父亲编码
	private String typeCode;// 类型编码
	private String code;// 编码

	private String childTypeCode;// 子类型编码
	private int virtual;// 是否虚拟节点
	private String alias;// 别名
	private Integer count;// 提示数量

	private boolean checked;

	private String typeId;// 类型ID

	private Integer sortNo;// 排序号

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getEditurl() {
		return editurl;
	}

	public void setEditurl(String editurl) {
		this.editurl = editurl;
	}

	public String getXtype() {
		return xtype;
	}

	public void setXtype(String xtype) {
		this.xtype = xtype;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getParentCode() {
		return parentCode;
	}

	public void setParentCode(String parentCode) {
		this.parentCode = parentCode;
	}

	public String getTypeCode() {
		return typeCode;
	}

	public void setTypeCode(String typeCode) {
		this.typeCode = typeCode;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getChildTypeCode() {
		return childTypeCode;
	}

	public void setChildTypeCode(String childTypeCode) {
		this.childTypeCode = childTypeCode;
	}

	public int getVirtual() {
		return virtual;
	}

	public void setVirtual(int virtual) {
		this.virtual = virtual;
	}

	public String getAlias() {
		return alias;
	}

	public void setAlias(String alias) {
		this.alias = alias;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public boolean isChecked() {
		return checked;
	}

	public void setChecked(boolean checked) {
		this.checked = checked;
	}

	public String getTypeId() {
		return typeId;
	}

	public void setTypeId(String typeId) {
		this.typeId = typeId;
	}

	public Integer getSortNo() {
		return sortNo;
	}

	public void setSortNo(Integer sortNo) {
		this.sortNo = sortNo;
	}
}
