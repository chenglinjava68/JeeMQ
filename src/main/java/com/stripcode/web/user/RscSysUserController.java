/**
 * 
 */
package com.stripcode.web.user;

import com.stripcode.core.config.Resources;
import com.stripcode.core.dto.user.CreateOrModifyUserDto;
import com.stripcode.core.util.SecurityUtil;
import com.stripcode.core.util.WebUtil;
import com.stripcode.mybatis.common.JQGridObject;
import com.stripcode.mybatis.user.model.RscSysUser;
import com.stripcode.service.user.RscSysUserService;
import com.stripcode.service.user.TSysBranchOfficeService;
import com.stripcode.service.user.TCodeMacroDefineService;
import com.stripcode.web.BaseController;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Metro
 */
@Controller
@RequestMapping("/user")
public class RscSysUserController extends BaseController {
	private static final  int EXCEL_SHEET_MAX = 5000;
	@Autowired
	private RscSysUserService rscSysUserService;
	@Autowired
	private TCodeMacroDefineService tCodeMacroDefineService;
	@Autowired
	private TSysBranchOfficeService tSysBranchOfficeService;
	// 修改用户信息
	@ResponseBody
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public Map update(@Valid CreateOrModifyUserDto dto,HttpServletResponse  response) throws  Exception{
		//定义接口可以被跨域访问
		response.setContentType("application/json;charset=UTF-8");
		response.setHeader("Access-Control-Allow-Origin","*");
		return setSuccessModelMap(rscSysUserService.update(dto.toModel()));
	}

	//删除用户信息
	@ResponseBody
	@RequestMapping(value = "/delete",method = RequestMethod.POST)
	public Map delete(@RequestParam(value = "userId",required = true) String userId,HttpServletResponse response){
		//定义接口可以被跨域访问
		response.setContentType("application/json;charset=UTF-8");
		response.setHeader("Access-Control-Allow-Origin","*");
		return setSuccessModelMap(rscSysUserService.delete(userId));
	}

	// 修改密码
	@ResponseBody
	@RequestMapping(value = "/update/password", method = RequestMethod.POST)
	public Map updatePassword(HttpServletRequest request, Map modelMap,
			@RequestParam(value = "id", required = true) String id,
			@RequestParam(value = "password", required = true) String password) throws  Exception{
		Assert.notNull(id, Resources.getMessage("USER_ID_IS_NULL"));
		Assert.notNull(password, Resources.getMessage("PASSWORD_IS_NULL"));
		RscSysUser sysUser = rscSysUserService.queryById(id);
		Assert.notNull(sysUser, String.format(Resources.getMessage("USER_IS_NULL"), id));
		sysUser.setPassword(SecurityUtil.encryptSHA(password));
		rscSysUserService.update(sysUser);
		return setSuccessModelMap(modelMap);
	}

	// 查询用户
	@ResponseBody
	@RequestMapping(value = "/read/list",method = RequestMethod.POST)
	public JQGridObject list(Map modelMap, HttpServletRequest request,HttpServletResponse response) {
		//定义接口可以被跨域访问
		response.setContentType("application/json;charset=UTF-8");
		response.setHeader("Access-Control-Allow-Origin","*");
		Map<String, Object> params = WebUtil.getParameterMap(request);
		return new JQGridObject(rscSysUserService.queryForPage(params));
	}
	// 查询所有用户
	@ResponseBody
	@RequestMapping(value = "/read/queryAll",method = RequestMethod.POST)
	public List<RscSysUser> queryAll(HttpServletResponse response) {
		//定义接口可以被跨域访问
		response.setContentType("application/json;charset=UTF-8");
		response.setHeader("Access-Control-Allow-Origin","*");
		return rscSysUserService.query();
	}
	// 获得当前用户
	@ResponseBody
	@RequestMapping(value = "/read/getCurrentUser",method = RequestMethod.POST)
	public String getCurrentUser(HttpServletResponse response) {
		
		//定义接口可以被跨域访问
		response.setContentType("application/json;charset=UTF-8");
		response.setHeader("Access-Control-Allow-Origin","*");
		return getCurrUser();
	}
	// 用户详细信息
	@ResponseBody
	@RequestMapping(value = "/read/detail",method = RequestMethod.POST)
	public Map<String,Object> detail(Map modelMap, HttpServletRequest request,String id,HttpServletResponse response) {
		Map<String,Object> map = new HashMap<String,Object>();
		//定义接口可以被跨域访问
		response.setContentType("application/json;charset=UTF-8");
		response.setHeader("Access-Control-Allow-Origin","*");
		if(StringUtils.isNotBlank(id)){
			RscSysUser sysUser = rscSysUserService.queryById(id);
			sysUser.setPassword(null);
			map.put("main",sysUser);
		}
		map.put("codeList", tCodeMacroDefineService.selectForUser());
		map.put("officeList", tSysBranchOfficeService.selectAll());
		return map;
	}

	//判断登录名是否存在

	@ResponseBody
	@RequestMapping(value = "/isExistsByLoginName",method = RequestMethod.POST)
	public Map<String,Object> isExistsByLoginName(RscSysUser rscSysUser,HttpServletResponse response){
		response.setContentType("application/json;charset=UTF-8");
		response.setHeader("Access-Control-Allow-Origin","*");
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("valid", rscSysUserService.isExistsByLoginName(rscSysUser));
		return map;
	}
	//导出用户列表
	@RequestMapping(value = "/exportUser")
	public String exportUser(Map<String,Object> params,HttpServletRequest request,HttpServletResponse response){
		response.setContentType("application/json;charset=UTF-8");
		response.setHeader("Access-Control-Allow-Origin","*");
		rscSysUserService.exportUser(params,request,response);
		return null;
	}
	@ResponseBody
	@RequestMapping("/isExporting")
	public  Boolean isExporting(HttpServletRequest request){
		return (Boolean) request.getSession().getAttribute("isExporting");
	}

	@ResponseBody
	@RequestMapping(value = "/loadUser",method = RequestMethod.POST)
	public RscSysUser loadUser(){
		return rscSysUserService.loadUser(getCurrUser());
	}
}
