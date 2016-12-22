package com.stripcode.mybatis.dictionary.model;


import java.io.Serializable;

public class Dictionary implements Serializable
{
	
	private static final long serialVersionUID = 1L;

	private String dictCode;// 编码
	
	private String typeCode;// 编码
	private String typeName;// 中文名称
	private String typeEnName;// 英文名称
	private String parentName;// 父类型名称
	private String parrentTypeName;
	/**
	 * 评估类型
	 */

	private String joinId;// 父类型编码
	private String comments;// 备注
	private String mnemonicCode;// 助记码
	

	private String  typeId;// 类型ID
	private Integer status;// 是否可用
	private Integer sortno;// 排序号
	private String  def1;// 预留字段
	private String def2;// 预留字段
	private String def3;// 预留字段
	private String def4;// 预留字段
	private String def5;// 预留字段 def5 1-表示是周次
	private String def6;// 预留字段 1,2,3,4,5 表示周一到周5,6,0表示周6,7
	private String def7;// 预留字段 def7-1 表示日期
	private String def8;// 预留字段def8-开始日期 
	private String def9;// 预留字段 def9-结束日期
	private String def10;// 预留字段
	
	public String getDef6()
	{
		return def6;
	}
	
	public void setDef6(String def6)
	{
		this.def6 = def6;
	}
	
	public String getDef7()
	{
		return def7;
	}
	
	public void setDef7(String def7)
	{
		this.def7 = def7;
	}
	
	public String getDef8()
	{
		return def8;
	}
	
	public void setDef8(String def8)
	{
		this.def8 = def8;
	}
	
	public String getDef9()
	{
		return def9;
	}
	
	public void setDef9(String def9)
	{
		this.def9 = def9;
	}
	
	public String getDef10()
	{
		return def10;
	}
	
	public void setDef10(String def10)
	{
		this.def10 = def10;
	}

	public String getParrentTypeName()
	{
		return parrentTypeName;
	}
	
	public void setParrentTypeName(String parrentTypeName)
	{
		this.parrentTypeName = parrentTypeName;
	}
	
	public String getDictCode()
	{
		return dictCode;
	}
	
	public void setDictCode(String dictCode)
	{
		this.dictCode = dictCode;
	}
	
	public String getTypeCode()
	{
		return typeCode;
	}
	
	public void setTypeCode(String typeCode)
	{
		this.typeCode = typeCode;
	}
	
	public String getTypeName()
	{
		return typeName;
	}
	
	public void setTypeName(String typeName)
	{
		this.typeName = typeName;
	}
	
	public String getTypeId()
	{
		return typeId;
	}
	
	public void setTypeId(String typeId)
	{
		this.typeId = typeId;
	}
	
	public String getJoinId()
	{
		return joinId;
	}
	
	public void setJoinId(String joinId)
	{
		this.joinId = joinId;
	}
	
	public String getComments()
	{
		return comments;
	}
	
	public void setComments(String comments)
	{
		this.comments = comments;
	}
	
	public Integer getStatus()
	{
		return status;
	}
	
	public void setStatus(Integer status)
	{
		this.status = status;
	}
	
	public Integer getSortno()
	{
		return sortno;
	}
	
	public void setSortno(Integer sortno)
	{
		this.sortno = sortno;
	}
	
	public String getMnemonicCode()
	{
		return mnemonicCode;
	}
	
	public void setMnemonicCode(String mnemonicCode)
	{
		this.mnemonicCode = mnemonicCode;
	}
	
	public String getTypeEnName()
	{
		return typeEnName;
	}
	
	public void setTypeEnName(String typeEnName)
	{
		this.typeEnName = typeEnName;
	}
	
	public String getParentName()
	{
		return parentName;
	}
	
	public void setParentName(String parentName)
	{
		this.parentName = parentName;
	}

	/**
	 * @return def1 : return the property def1.
	*/
	public String getDef1()
	{
		return def1;
	}
	
	/**
	 * @param def1 : set the property def1.
	 */
	public void setDef1(String def1)
	{
		this.def1 = def1;
	}
	
	/**
	 * @return def2 : return the property def2.
	*/
	public String getDef2()
	{
		return def2;
	}
	
	/**
	 * @param def2 : set the property def2.
	 */
	public void setDef2(String def2)
	{
		this.def2 = def2;
	}
	
	/**
	 * @return def3 : return the property def3.
	*/
	public String getDef3()
	{
		return def3;
	}
	
	/**
	 * @param def3 : set the property def3.
	 */
	public void setDef3(String def3)
	{
		this.def3 = def3;
	}
	
	/**
	 * @return def4 : return the property def4.
	*/
	public String getDef4()
	{
		return def4;
	}
	
	/**
	 * @param def4 : set the property def4.
	 */
	public void setDef4(String def4)
	{
		this.def4 = def4;
	}
	
	/**
	 * @return def5 : return the property def5.
	*/
	public String getDef5()
	{
		return def5;
	}
	
	/**
	 * @param def5 : set the property def5.
	 */
	public void setDef5(String def5)
	{
		this.def5 = def5;
	}
	
}
