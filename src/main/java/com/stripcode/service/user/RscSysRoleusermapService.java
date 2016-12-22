/**
 * 
 */
package com.stripcode.service.user;

import com.stripcode.mybatis.user.dao.RscSysRoleusermapMapper;
import com.stripcode.mybatis.user.model.RscSysRoleusermap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author wangjunfeng
 */
@Service
public class RscSysRoleusermapService {
	@Autowired
	private RscSysRoleusermapMapper rscSysRoleusermapMapper;
	@Transactional
    public int deleteByPositionId(String positionid){
      return rscSysRoleusermapMapper.deleteByPositionId(positionid);
	}
	@Transactional
	public int batchInsert(List<RscSysRoleusermap> rscSysRoleusermaps){
		int count = 0;
		for(RscSysRoleusermap rscSysRoleusermap : rscSysRoleusermaps){
				count += rscSysRoleusermapMapper.insert(rscSysRoleusermap);
		}
		return count;
	}
	public List<RscSysRoleusermap> query(Map<String,Object> params){
		return rscSysRoleusermapMapper.query(params);
	}
	public ArrayList<RscSysRoleusermap> queryRole(Map<String,Object> params){
		return rscSysRoleusermapMapper.queryRole(params);
	}
}
