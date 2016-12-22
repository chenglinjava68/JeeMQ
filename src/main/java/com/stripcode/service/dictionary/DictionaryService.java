package com.stripcode.service.dictionary;

import com.alibaba.druid.util.StringUtils;
import com.stripcode.core.Constants;
import com.stripcode.core.util.RedisNewUtil;
import com.stripcode.mybatis.dictionary.dao.DictionaryMapper;
import com.stripcode.mybatis.dictionary.model.Dictionary;
import com.stripcode.mybatis.dictionary.model.Outline;
import com.stripcode.service.BaseService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class DictionaryService extends BaseService
{
	private static Logger logger = Logger.getLogger(DictionaryService.class);
	
	@Autowired
	private DictionaryMapper dictionaryMapper;

	
	/* 生成Next DictCode*/
	private String getNextDictCode(String parentCode,Set existDictCodes)
	{
		List<Dictionary> dics = dictionaryMapper.getInfoByParentId(parentCode,null);
		if(dics.size() > 0)
		{// 如果已经有子节点.直接使用类型值,以及累加的编码值[4位+4位]
			for(Dictionary dic:dics)
			{
				existDictCodes.add(dic.getDictCode());
			}
			
			Dictionary dic0 = dics.get(0);
			String dictCode = dic0.getDictCode();
			String newDictCode = "jeemq" + (Integer.parseInt(dictCode.substring(5,9)) * 10000 + existDictCodes.size() + 1);
			
			if(existDictCodes.contains(newDictCode))
			{// 如果有冲突,说明dictcode生成不连续了,中间有浪费的dictcode
				for(int i = 0;;i++)
				{
					newDictCode = "jeemq" + (Integer.parseInt(dictCode.substring(5,9)) * 10000 + i);
					if(!existDictCodes.contains(newDictCode))
					{
						break;
					}
				}
			}
			
			if(dictionaryMapper.load(newDictCode) != null){
				existDictCodes.add(newDictCode);
				return getNextDictCode(parentCode,existDictCodes);
			}
			return newDictCode;
		}
		else
		{// 如果是新的类型
			String dicCode = dictionaryMapper.getMaxDictCode();// 取最大编码--递增生成新的编码
			return "jeemq" + (Integer.parseInt(dicCode.substring(5,9)) + 1) + "0001";
		}
	}

	// 保存 or 更新记录

	public void save(Dictionary dic)
	{
		if(dic.getJoinId() == null)
		{
			dic.setJoinId("0");
		}
		Set existDictCodes = new HashSet();
		String newDictCode = getNextDictCode(dic.getJoinId(),existDictCodes);
		dic.setDictCode(newDictCode);
		try
		{
			dictionaryMapper.insert(dic);
			RedisNewUtil.del(dic.getJoinId());
			ArrayList<Dictionary> record = getChildren(dic.getJoinId(), null);
			if(null != record){
				RedisNewUtil.set(dic.getJoinId(), record);
			}
		}
		catch(DuplicateKeyException e)// 主键冲突异常
		{
			save(dic);
		}
	}

	// 判断当前是否重复编码 hsl
	public Dictionary checkIsHaveTypeEnName(String parentCode,String typeEnName)
	{
		return  dictionaryMapper.checkIsHaveTypeEnName(parentCode, typeEnName);
	}
	
	public List<Dictionary> getByParentCode(String parentCode)
	{
		try{
			String key = getCacheKey(parentCode);
			ArrayList<Dictionary> record = (ArrayList<Dictionary>) RedisNewUtil.get(key);
			if(record == null){
				record = getChildren(parentCode, null);
				RedisNewUtil.set(parentCode,record);
			}
			return record;
		}catch (Exception e){
			throw  new RuntimeException(e.getMessage(),e);
		}
	}

	public List<Dictionary> getDataAll(){
		List<Dictionary> list = getDataByAll();
		return  list;
	}
	@Transactional
	public void remove(String dictCode)
	{
		try{
			String key = getCacheKey(dictCode);
			if(StringUtils.isEmpty(key)){
					RedisNewUtil.del(key);
			}
			dictionaryMapper.remove(dictCode);
		}catch (Exception e){
			throw  new RuntimeException(e.getMessage(),e);
		}

	}

	public ArrayList<Dictionary> getByParentCodeAndStatus(String parentCode)
	{
		try{
			String key = getCacheKey(parentCode);
			ArrayList<Dictionary> record = (ArrayList<Dictionary>) RedisNewUtil.get(key);
			if(record == null){
				record = dictionaryMapper.getInfoByParentId(parentCode,1);
				RedisNewUtil.set(parentCode,record);
			}
			return record;
		}catch (Exception e){
			throw  new RuntimeException(e.getMessage(),e);
		}
	}
	public ArrayList<Dictionary> getChildren(String parentCode,Integer status)
	{
		ArrayList<Dictionary> sdts = dictionaryMapper.getInfoByParentId(parentCode,status);
		return sdts;
	}
	public List<Dictionary> getDataByAll()
	{
		List<Dictionary> list = dictionaryMapper.getDataAll();
		return list;
	}

	public Dictionary load(String code)
	{
		return (Dictionary) dictionaryMapper.load(code);
	}

	@Transactional
	public void update(Dictionary obj)
	{
		try{
				dictionaryMapper.update(obj);
				RedisNewUtil.del(obj.getJoinId());
				ArrayList<Dictionary> record = getChildren(obj.getJoinId(), null);
				if(null != record){
					RedisNewUtil.set(obj.getJoinId(), record);
				}
		}catch (Exception e){
			throw  new RuntimeException(e.getMessage(),e);
		}
	}
	
//	@Override
//	public List<Map> getByTypeCode(String typeCode,DataSourceRequest filter)
//	{
//		return dictionaryMapper.getByTypeCode(typeCode, filter);
//	}
	

	public List<Dictionary> listModules(Integer userId, Integer roleId)
	{
		
		return dictionaryMapper.listModules(userId, roleId);
	}

	public List<Outline> listChildren(String parentCode, Integer userId, String typeCode)
	{
		List<Outline> dtos = new ArrayList<Outline>();
		List<Dictionary> children = dictionaryMapper.getLayer(parentCode, userId, typeCode);// 获取子节点
		for(Dictionary sdt:children)
		{
			Outline dto = dicToOutline(sdt);
			dtos.add(dto);
		}
		return dtos;
	}


	public List<Outline> layer(String parentCode, Integer userId, String typeCode)
	{
		List<Outline> result = new ArrayList<Outline>();
		List<Outline> dtos = listChildren(parentCode,userId,typeCode);
		result.addAll(dtos);
		for(Outline sdt : dtos) {
			result.addAll(listChildren(sdt.getCode(),userId, typeCode));// 二级菜单需要获取form的editurl
		}
		return result;
	}

	private Outline dicToOutline(Dictionary sdt)
	{
		Outline outline = new Outline();
		outline.setTitle(sdt.getTypeName());// 标题
		outline.setEditurl(sdt.getDef4());// 编辑地址
		outline.setUrl(sdt.getDef1());// 请求地址
		outline.setParentCode(sdt.getJoinId());// 父亲节点编码
		outline.setCode(sdt.getDictCode());// 编码
		outline.setChecked(sdt.getDef3() == null ? false : true);
		outline.setSortNo(sdt.getSortno());
		outline.setTypeCode(sdt.getTypeCode());
		outline.setTypeId(sdt.getTypeId());
		outline.setVirtual(sdt.getDef5() == null ? 0 : Integer.valueOf(sdt.getDef5()));
		return outline;
	}

	/** 获取缓存键值 */
	private String getCacheKey(Object id) {
		String cacheName = null;
		CacheConfig cacheConfig = getClass().getAnnotation(CacheConfig.class);
		if (cacheConfig == null || cacheConfig.cacheNames() == null || cacheConfig.cacheNames().length < 1) {
			cacheName = getClass().getName();
		} else {
			cacheName = cacheConfig.cacheNames()[0];
		}
		return new StringBuilder(Constants.CACHE_NAMESPACE).append(cacheName).append(":").append(id).toString();
	}
}
