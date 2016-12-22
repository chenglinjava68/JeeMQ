/**
 * 
 */
package com.stripcode.service.user;

import com.stripcode.mybatis.cs.dao.CSCustomerInfoMapper;
import com.stripcode.mybatis.cs.model.CSCSustomerOfficeMap;
import com.stripcode.mybatis.user.dao.TSysUserDataRightMapper;
import com.stripcode.mybatis.user.model.TSysUserDataRight;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Metro
 */
@Service
public class TSysUserDataRightService {
	@Autowired
	private TSysUserDataRightMapper tSysUserDataRightMapper;
	@Autowired
	private CSCustomerInfoMapper csCustomerMapper;

	@Transactional
	public int deleteByPositionId(String positionId) {
		return tSysUserDataRightMapper.deleteByPositionId(positionId);
	}
	public void save(TSysUserDataRight tSysUserDataRight){
		tSysUserDataRightMapper.insert(tSysUserDataRight);

	}
	@Transactional
	public Map save(List<TSysUserDataRight> userRights,String positionId) throws  Exception{
		if(StringUtils.isBlank(positionId)){
			throw new Exception("岗位ID不能为空");
		}
		Map modelMap = new HashMap();
		deleteByPositionId(positionId);
		if(userRights == null ){
			modelMap.put("result",true);
			modelMap.put("message","保存成功！");
			return modelMap;
		}
		batchSave(userRights);
		modelMap.put("result",true);
		modelMap.put("message","保存成功！");
		return modelMap;
	}


	public void batchSave(List<TSysUserDataRight> tSysUserDataRights){
		for(TSysUserDataRight tSysUserDataRight : tSysUserDataRights){
			if(StringUtils.isBlank(tSysUserDataRight.getBrand()) && StringUtils.isBlank(tSysUserDataRight.getBranchCompanyId()) && StringUtils.isBlank(tSysUserDataRight.getCustomerId())){
				continue;
			}
			tSysUserDataRight.setRowId(null);
			tSysUserDataRight.setCreateTime(null);
			tSysUserDataRightMapper.insert(tSysUserDataRight);
		}
	}
	public List<TSysUserDataRight> selectByPositionId(TSysUserDataRight  tSysUserDataRight){
		return tSysUserDataRightMapper.selectByPositionId(tSysUserDataRight);
	}

	public List<Map<String,Object>> selectCustomer(CSCSustomerOfficeMap cscSustomerOfficeMap) {
		return csCustomerMapper.selectByOfficeId(cscSustomerOfficeMap);
	}
}
