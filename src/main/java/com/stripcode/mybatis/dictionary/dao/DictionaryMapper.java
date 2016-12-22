package com.stripcode.mybatis.dictionary.dao;


import com.stripcode.mybatis.dictionary.model.Dictionary;
import org.apache.ibatis.annotations.Param;

import java.util.ArrayList;
import java.util.List;

public interface DictionaryMapper
{
	public List<Dictionary> getByTypeId(@Param("typeId") int typeId, @Param("status") Integer status);

	/**
	 * 方法描述：该条记录是否存在
	 * @param:  无
	 * @return:
	 */
	Dictionary isExists(@Param("typeId") Integer typeId, @Param("typeName") String typeName);
	
	public String getMaxDictCode();
	
	public void saveTarget(Dictionary item);
	
	public void insertItem(Dictionary item);
	
	public void deleteItem(Dictionary item);
	
	public ArrayList<Dictionary> getInfoByParentId(@Param("joinId") String joinId, @Param("status") Integer status);

	/**
	 * 方法描述：获取所有字典数据
	 * @param:  无
	 * @return:
	 */
	public List<Dictionary> getDataAll();

	public Dictionary checkIsHaveTypeEnName(@Param("parentCode") String parentCode, @Param("typeEnName") String typeEnName);
	
	/**
	  * 方法描述：
	  * @param: 
	  * @return: 
	  * @version: 1.0
	  * @author: belong
	  * @version: 2015年2月3日 下午12:20:11
	  */
	public List<Dictionary> getByTypeCode(@Param("typeCode") String typeCode);
	
	/**
	  * 方法描述：
	 * @param typeCode TODO
	 * @param userId
	  * @param: 
	  * @return: 
	  * @version: 1.0
	  * @author: belong
	  * @version: 2015年2月4日 下午2:07:02
	  */
	public List<Dictionary> getLayer(@Param("parentCode") String parentCode, @Param("userId") Integer userId, @Param("typeCode") String typeCode);
	
	/**
	  * 方法描述：
	 * @param roleId TODO
	  * @param: 
	  * @return: 
	  * @version: 1.0
	  * @author: belong
	  * @version: 2015年2月4日 下午5:18:20
	  */
	public List<Dictionary> listModules(@Param("userId") Integer userId, @Param("roleId") Integer roleId);

	/**
	 * 方法描述：
	 * @param  dictCode
	 * @param:
	 * @return:
	 * @version: 1.0
	 * @author: belong
	 * @version: 2015年2月4日 下午5:18:20
	*/
	public void remove(@Param("dictCode") String dictCode);
	/**
	 * 方法描述：
	 * @param  dictCode
	 * @param:
	 * @return:
	 * @version: 1.0
	 * @author: belong
	 * @version: 2015年2月4日 下午5:18:20
	 */
	public Dictionary load(@Param("dictCode") String dictCode);

	/**
	 * 方法描述：
	 * @param  item
	 * @param:
	 * @return:
	 * @version: 1.0
	 * @author: belong
	 * @version: 2015年2月4日 下午5:18:20
	 */
	public void update(Dictionary item);
	/**
	 * 方法描述：
	 * @param  item
	 * @param:
	 * @return:
	 * @version: 1.0
	 * @author: belong
	 * @version: 2015年2月4日 下午5:18:20
	 */
	public void insert(Dictionary item);
}
