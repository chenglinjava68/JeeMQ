/**
 * 
 */
package com.stripcode.service.user.impl;

import com.stripcode.mybatis.cs.model.CSCSustomerOfficeMap;
import com.stripcode.mybatis.user.model.TSysUserDataRight;


import java.util.List;
import java.util.Map;

/**
 * @author Metro
 */
public interface TSysUserDataRightService {

	public int deleteByPositionId(String positionId);
	public void save(TSysUserDataRight tSysUserDataRight);
	public Map save(List<TSysUserDataRight> userRights,String positionId);

	public void batchSave(List<TSysUserDataRight> tSysUserDataRights);
	public List<TSysUserDataRight> selectByPositionId(TSysUserDataRight  tSysUserDataRight);

	public List<Map<String,Object>> selectCustomer(CSCSustomerOfficeMap cscSustomerOfficeMap);
}
