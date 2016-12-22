/**
 * 
 */
package com.stripcode.service.user.impl;

import com.stripcode.mybatis.user.model.RscSysRoleusermap;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author Metro
 */

public interface RscSysRoleusermapService {
    public int deleteByPositionId(String positionid);
	public int batchInsert(List<RscSysRoleusermap> rscSysRoleusermaps);
	public List<RscSysRoleusermap> query(Map<String,Object> params);
	public ArrayList<RscSysRoleusermap> queryRole(Map<String,Object> params);
}
