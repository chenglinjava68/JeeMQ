package com.stripcode.web.dictionary;

import com.stripcode.core.config.Resources;
import com.stripcode.core.support.HttpCode;
import com.stripcode.mybatis.dictionary.model.Dictionary;
import com.stripcode.mybatis.dictionary.model.Outline;
import com.stripcode.service.dictionary.DictionaryService;
import com.stripcode.web.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.util.Assert;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 
 * 字典表的TypeID定义规则： System模块的TypeID 100-199 Account模块的TypeID 200-299 POS模块的TypeID
 * 300-399 Member模块的TypeID 400-499 Store模块TypeID 500-599 Employee模块TypeID
 * 600-699 库存模块TypeID 700-799 现金模块 TypeID 800-899 营销模块 TypeID 900-999
 * 
 */

@Controller
public class DictionaryController extends BaseController
{
	@Autowired
	private DictionaryService dictionaryService;

	/**
	 * 方法描述：获取数据字典目录
	 * @param:
	 * @return:
	 * @version: 1.0
	 * @author: belong
	 * @version: 2014年9月2日 下午8:48:49
	 */
	@RequestMapping(value = "/layer", method = RequestMethod.GET)
	@ResponseBody
	public HashMap layer(HttpServletRequest request, HttpServletResponse response, String parentCode, Integer userId, String typeCode)
	{
		//定义接口可以被跨域访问
		response.setContentType("application/json;charset=UTF-8");
		response.setHeader("Access-Control-Allow-Origin","*");
		HashMap result = new HashMap();
		try {
			List<Outline> dataTypeList = dictionaryService.layer(parentCode, userId, typeCode);
			return getOutlineHashMap(result, dataTypeList);
		}
		catch (Exception e) {
			throw new IllegalArgumentException(Resources.getMessage("LOGIN_FAIL"), e);
		}

	}


	/**
	 * 
	 * 方法描述：查询字典表记录列表
	 * 
	 * @param: int typeId
	 * @return: ResultInfo json
	 * @version: 1.0
	 * @author: yangzm
	 * @version: 2014年4月9日 上午11:44:25
	 */

	@RequestMapping(value = "/getDataTypeByTypeID", method = RequestMethod.GET)
	@ResponseBody
	public HashMap getDataTypeByTypeID(HttpServletRequest request, HttpServletResponse response, String  parentCode)
	{
		//定义接口可以被跨域访问
		response.setContentType("application/json;charset=UTF-8");
		response.setHeader("Access-Control-Allow-Origin","*");
		HashMap result = new HashMap();
		try {
				List<Dictionary> dataTypeList = dictionaryService.getByParentCode(parentCode);
			    return getHashMap(result, dataTypeList);
		}
		catch (Exception e) {
			throw new IllegalArgumentException(Resources.getMessage("LOGIN_FAIL"), e);
		}

	}


	/**
	 *
	 * 方法描述：查询字典表记录列表
	 *
	 * @param: int typeId  and  status
	 * @return: ResultInfo json
	 * @version: 1.0
	 * @author: hsl
	 * @version: 2016年3月27日 下午16:44:25
	 */
	@RequestMapping(value = "/getDataTypeByTypeIDByStatus", method = RequestMethod.GET)
	@ResponseBody
	public HashMap getDataTypeByTypeIDByStatus(HttpServletRequest request, HttpServletResponse response,  String parentCode)
	{
		response.setContentType("application/json;charset=UTF-8");
		response.setHeader("Access-Control-Allow-Origin","*");
		HashMap result = new HashMap();
		try {
			List<Dictionary> dataTypeList = dictionaryService.getByParentCodeAndStatus(parentCode);
			return getHashMap(result, dataTypeList);
		}
		catch (Exception e) {
			throw new IllegalArgumentException(Resources.getMessage("LOGIN_FAIL"), e);
		}
	}

	/**
	 * 
	 * 方法描述：查询一条字典表记录
	 * 
	 * @param: int typeId,String dictCode
	 * @return: ResultInfo json
	 * @version: 1.0
	 * @author: yangzm
	 * @version: 2014年4月9日 上午11:44:25
	 */
	@RequestMapping(value="/getDataTypeByDictCode",method= RequestMethod.GET )
	@ResponseBody
	public Map getDataTypeByDictCode(HttpServletRequest request, HttpServletResponse response, String dictCode)
	{
		response.setContentType("application/json;charset=UTF-8");
		response.setHeader("Access-Control-Allow-Origin","*");
		Map result = new HashMap();
		try {
			Dictionary dataType = dictionaryService.load(dictCode);
			return getMap(result, dataType);
		}
		catch (Exception e) {
			throw new IllegalArgumentException(Resources.getMessage("LOGIN_FAIL"), e);
		}
	}



	 /**
	 *
	 * 方法描述：查看一条字典表记录是否已经存在
	 *
	 * @param: int typeId,String dictCode
	 * @return: ResultInfo json
	 * @version: 1.0
	 * @author: hsl
	 * @version: 2014年4月9日 上午11:44:25
	 */
	@RequestMapping("/checkIsHaveTypeEnName")
	@ResponseBody
	public Map checkIsHaveTypeEnName(String parentCode,String typeEnName)
	{
		Assert.notNull(parentCode, Resources.getMessage("ACCOUNT_IS_NULL"));
		Assert.notNull(typeEnName, Resources.getMessage("ACCOUNT_IS_NULL"));
		Dictionary dataType = dictionaryService.checkIsHaveTypeEnName(parentCode, typeEnName);
		if(null != dataType){
			Map result  = new HashMap();
			result.put("result", dataType);
			return result;
		}
		throw new IllegalArgumentException(Resources.getMessage("LOGIN_FAIL"));
	}
	
	@Deprecated
	@RequestMapping(value="/saveDataType", method= RequestMethod.POST )
	@ResponseBody
	public Map saveDataType(HttpServletRequest request, HttpServletResponse response, Dictionary item, String parentCode, String domain)
	{
		//Assert.notNull(parentCode, Resources.getMessage("ACCOUNT_IS_NULL"));
		//Assert.notNull(domain, Resources.getMessage("ACCOUNT_IS_NULL"));
		//Assert.notNull(item, Resources.getMessage("ACCOUNT_IS_NULL"));
		response.setContentType("application/json;charset=UTF-8");
		response.setHeader("Access-Control-Allow-Origin","*");
		item.setJoinId(parentCode);
		item.setTypeCode(domain);
		if(StringUtils.isEmpty(item.getDictCode()))
		{
			dictionaryService.save(item);
		}
		else
		{
			dictionaryService.update(item);
		}
		return getDataTypeByDictCode(request, response, item.getDictCode());
	}


	
	@Deprecated
	@RequestMapping("/deleteDataType")
	@ResponseBody
	public HashMap delete(HttpServletRequest request, HttpServletResponse response, String parentCode,String dictCode)
	{
		//Assert.notNull(parentCode, Resources.getMessage("ACCOUNT_IS_NULL"));
		//Assert.notNull(dictCode, Resources.getMessage("ACCOUNT_IS_NULL"));
		response.setContentType("application/json;charset=UTF-8");
		response.setHeader("Access-Control-Allow-Origin","*");
		dictionaryService.remove(dictCode);
		HashMap result = new HashMap();
		try {
			List<Dictionary> dataTypeList = dictionaryService.getByParentCode(parentCode);
			return  this.getHashMap(result, dataTypeList);
		}
		catch (Exception e) {
			throw new IllegalArgumentException(Resources.getMessage("LOGIN_FAIL"), e);
		}
	}

	/**
	 *
	 * 方法描述：HashMap返回值
	 *
	 * @param: HashMap result, List<Dictionary> dataTypeList
	 * @return: HashMap
	 * @version: 1.0
	 * @author: jian.qiu
	 */
	private HashMap getHashMap(HashMap result, List<Dictionary> dataTypeList) {
		if(null != dataTypeList && dataTypeList.size() > 0){
			return setHashMap(result, HttpCode.OK, dataTypeList);
		} else{
			return setHashMap(result, HttpCode.NO_RECORD, null);
		}
	}

	/**
	 *
	 * 方法描述：Map返回值
	 *
	 * @param:  Map result, Dictionary dataType
	 * @return:  Map
	 * @version: 1.0
	 * @author: jian.qiu
	 */
	private Map getMap(Map result,  Dictionary dataType) {
		if(null != dataType){
			return setMap(result, HttpCode.OK, dataType);
		} else{
			return setMap(result, HttpCode.NO_RECORD, null);
		}
	}

	/**
	 *
	 * 方法描述：HashMap返回值
	 *
	 * @param: HashMap result, List<Dictionary> dataTypeList
	 * @return: HashMap
	 * @version: 1.0
	 * @author: jian.qiu
	 */
	private HashMap getOutlineHashMap(HashMap result, List<Outline> dataTypeList) {
		if(null != dataTypeList && dataTypeList.size() > 0){
			return setHashMap(result, HttpCode.OK, dataTypeList);
		} else{
			return setHashMap(result, HttpCode.NO_RECORD, null);
		}
	}
}
