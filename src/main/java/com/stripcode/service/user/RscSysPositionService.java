/**
 * 
 */
package com.stripcode.service.user;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.stripcode.core.util.DataUtil;
import com.stripcode.core.util.PageSortUtil;
import com.stripcode.core.util.UUIDUtils;
import com.stripcode.core.util.excelUtil.ExportExcel;
import com.stripcode.core.util.tree.TreeModel;
import com.stripcode.mybatis.user.dao.RscSysPositionMapper;
import com.stripcode.mybatis.user.model.RscSysPosition;
import com.stripcode.mybatis.user.model.RscSysRoleusermap;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Metro
 */
@Service
@CacheConfig(cacheNames = "rscSysPosition")
public class RscSysPositionService  {
	@Autowired
    private RscSysPositionMapper rscSysPositionMapper;
	@Autowired
	private RscSysRoleusermapService rscSysRoleusermapService;
	@Autowired
	private RscSysRoleService rscSysRoleService;
	@Autowired
	private RscSysUserService rscSysUserService;
	@Transactional
	public Map update(RscSysPosition record,String[] roleArray) {
		List<RscSysRoleusermap> rscSysRoleusermaps = new ArrayList<RscSysRoleusermap>();
		Map modelMap = new HashMap();
		int count = -1;
		int deleteCount = -1;
		int insertCount = -1;
		if (StringUtils.isBlank(record.getPositionid())) {
			record.setPositionid(UUIDUtils.generateKey());
			count = rscSysPositionMapper.insert(record);
			if (count == 1) {
				addRscSysRoleusermap(rscSysRoleusermaps,record.getPositionid(),roleArray);
				insertCount = rscSysRoleusermapService.batchInsert(rscSysRoleusermaps);
				modelMap.put("result", true);
				modelMap.put("message", "保存成功！");
				modelMap.put("id",record.getPositionid());
				return modelMap;
			}
			modelMap.put("result", false);
			modelMap.put("message", "保存失败！");
			return modelMap;
		}
		count = rscSysPositionMapper.updateByPrimaryKey(record);

		if (count == 1) {
			rscSysRoleusermapService.deleteByPositionId(record.getPositionid());
			addRscSysRoleusermap(rscSysRoleusermaps,record.getPositionid(),roleArray);
			rscSysRoleusermapService.batchInsert(rscSysRoleusermaps);
			modelMap.put("result", true);
			modelMap.put("message", "修改成功！");
			return modelMap;
		}
		modelMap.put("result", false);
		modelMap.put("message", "修改失败！");
		return modelMap;
	}
	private void addRscSysRoleusermap(List<RscSysRoleusermap> rscSysRoleusermaps,String positionid,String[] roleArray){
		if(roleArray == null){
			return;
		}
		for(String role : roleArray){
			RscSysRoleusermap rscSysRoleusermap = new RscSysRoleusermap();
			rscSysRoleusermap.setRoleId(role);
			rscSysRoleusermap.setPositionid(positionid);
			rscSysRoleusermap.setDelFlag("M0015");
			rscSysRoleusermaps.add(rscSysRoleusermap);
		}
	}
	@Transactional
	public Map delete(String id) {
		Map modelMap = new HashMap();
		rscSysRoleusermapService.deleteByPositionId(id);
		int count =  rscSysPositionMapper.deleteByPrimaryKey(id);
		if (count == 1) {
			modelMap.put("result", true);
			modelMap.put("message", "删除成功！");
			return modelMap;
		}
		modelMap.put("result", false);
		modelMap.put("message", "删除失败！");
		return modelMap;
	}

	public  RscSysPosition queryById(String id) {
		return rscSysPositionMapper.selectByPrimaryKey(id);
	}
	public  RscSysPosition queryUserId(String userId) {
		return rscSysPositionMapper.selectUserIdKey(userId);
	}
	public PageInfo<RscSysPosition> query(Map<String, Object> params) {
		PageHelper.startPage(params);
		PageSortUtil.unoinSortBySord(params);
		PageInfo<RscSysPosition> pageInfo  = new PageInfo<RscSysPosition>(rscSysPositionMapper.queryForPage(params));
		for(RscSysPosition rscSysPosition : pageInfo.getList()){
			rscSysPosition.setRoles(rscSysRoleService.queryByPostionId(rscSysPosition.getPositionid()));
		}
		return pageInfo;
	}

	public List<RscSysPosition> select(){
		return rscSysPositionMapper.selectAll();
	}

	public List<TreeModel> selectForTree(@Param("positionId") String positionId){
		return rscSysPositionMapper.selectForTree(positionId);
	}

	public void exportPosition(Map<String,Object> params, HttpServletRequest request, HttpServletResponse response) {

		/*List<ExcelHeader<RscSysPosition>> headers = new ArrayList<ExcelHeader<RscSysPosition>>();
		headers.add(new ExcelHeader<RscSysPosition>("岗位名称", "cnname"));
		headers.add(new ExcelHeader<RscSysPosition>("岗位描述", "comments"));
		headers.add(new ExcelHeader<RscSysPosition>("用户名", "userName"));
		ExcelHeader<RscSysPosition> excelHeader = new ExcelHeader<RscSysPosition>("角色", "roles");
		excelHeader.setExcelFormatter(new ExcelFormatter() {
			@Override
			public Object formatter(Row row, Cell cell, Object value, Integer rowIndex) {
				if(value == null){
					return "";
				}
				List<RscSysRole> roles = (List<RscSysRole>)value;
				List<String> aray = new ArrayList<String>();
				for(RscSysRole rscSysRole : roles){
					aray.add(rscSysRole.getRoleName());
				}
				return aray.toString();
			}
		});
		headers.add(excelHeader);
		RscSysUser creator  = rscSysUserService.queryById(WebUtil.getCurrentUser());
		List<RscSysPosition> data = rscSysPositionMapper.selectForExport();
		for(RscSysPosition rscSysPosition : data){
			rscSysPosition.setRoles(rscSysRoleService.queryByPostionId(rscSysPosition.getPositionid()));
		}
		new ExcelExporter(request,response).export(new ExcelDocument<RscSysPosition>(5000,"全部岗位信息",creator == null ? "" : creator.getUserName(),headers,data));*/

		try {
			String fileName = "岗位管理"+ DataUtil.getDate("yyyyMMddHHmmss")+".xlsx";
			List<RscSysPosition> data = rscSysPositionMapper.selectForExport();
			for(RscSysPosition rscSysPosition : data){
				rscSysPosition.setRoles(rscSysRoleService.queryByPostionId(rscSysPosition.getPositionid()));
			}
			new ExportExcel("岗位管理", RscSysPosition.class).setDataList(data).write(response, fileName).dispose();
		} catch (Exception e) {

		}

	}

	public RscSysPosition getUserByid(String id) {
		RscSysPosition u = rscSysPositionMapper.getUserByid(id);
		return u;
	}
}
