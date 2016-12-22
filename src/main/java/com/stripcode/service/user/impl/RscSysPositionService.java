/**
 * 
 */
package com.stripcode.service.user.impl;

import com.github.pagehelper.PageInfo;
import com.stripcode.core.util.tree.TreeModel;
import com.stripcode.mybatis.user.model.RscSysPosition;
import com.stripcode.mybatis.user.model.RscSysRoleusermap;
import org.apache.ibatis.annotations.Param;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

/**
 * @author Metro
 */

public interface RscSysPositionService  {

	public Map update(RscSysPosition record,String[] roleArray);
	public void addRscSysRoleusermap(List<RscSysRoleusermap> rscSysRoleusermaps,String positionid,String[] roleArray);
	public Map delete(String id);
	public  RscSysPosition queryById(String id);
	public  RscSysPosition queryUserId(String userId);
	public PageInfo<RscSysPosition> query(Map<String, Object> params);
	public List<RscSysPosition> select();
	public List<TreeModel> selectForTree(@Param("positionId") String positionId);
	public void exportPosition(Map<String,Object> params, HttpServletRequest request, HttpServletResponse response);
	public RscSysPosition getUserByid(String id);
}
