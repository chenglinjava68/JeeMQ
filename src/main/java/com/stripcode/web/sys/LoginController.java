package com.stripcode.web.sys;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.stripcode.mybatis.user.model.RscSysUser;
import com.stripcode.service.dictionary.DictionaryService;
import com.stripcode.core.config.Resources;
import com.stripcode.core.support.HttpCode;
import com.stripcode.core.util.Request2ModelUtil;
import com.stripcode.core.util.WebUtil;
import com.stripcode.service.user.RscSysUserService;
import com.stripcode.web.BaseController;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;
/**
 * Created by Metro on 2016/10/25.
 */
@Controller
public class LoginController extends BaseController {
	@Autowired
	private RscSysUserService rscSysUserService;
    private  DictionaryService dictionaryService;

	// 登录
	@ResponseBody
	@RequestMapping(value = "/login",method=RequestMethod.POST)
	public Map<String, Object> login(HttpServletRequest request, HttpServletResponse response, Map modelMap,
					 @RequestParam(value = "account", required = false) String account,
					 @RequestParam(value = "password", required = false) String password) {
		Assert.notNull(account, Resources.getMessage("ACCOUNT_IS_NULL"));
		Assert.notNull(password, Resources.getMessage("PASSWORD_IS_NULL"));
		if (rscSysUserService.login(account, WebUtil.encryptPassword(password))) {
			HashMap hashMap = new HashMap();
			hashMap.put("httpCode",200);
			hashMap.put("msg","登录成功！");
			return hashMap;
		}else{
			HashMap hashMap = new HashMap();
			hashMap.put("httpCode",600);
			hashMap.put("msg",Resources.getMessage("LOGIN_FAIL"));
			return hashMap;
		}
	}
	// 登出
	@ResponseBody
	@RequestMapping("/logout")
	public Map logout(Map modelMap, HttpServletRequest request) {
		SecurityUtils.getSubject().logout();
		return setSuccessModelMap(modelMap);
	}

	// 注册
	@ResponseBody
	@RequestMapping(value = "/regin", method = RequestMethod.POST)
	public Map regin(HttpServletRequest request, HttpServletResponse response, Map modelMap,
			@RequestParam(value = "account", required = false) String account,
			@RequestParam(value = "password", required = false) String password) throws  Exception{
		Assert.notNull(account, Resources.getMessage("ACCOUNT_IS_NULL"));
		Assert.notNull(password, Resources.getMessage("PASSWORD_IS_NULL"));
		RscSysUser sysUser = Request2ModelUtil.covert(RscSysUser.class, request);
		sysUser.setPassword(WebUtil.encryptPassword(password));
		rscSysUserService.update(sysUser);
		if (rscSysUserService.login(account, password)) {
			return setSuccessModelMap(modelMap);
		}
		throw new IllegalArgumentException(Resources.getMessage("LOGIN_FAIL"));
	}

	// 没有登录
	@ResponseBody
	@RequestMapping(value={"","/unauthorized"})
	public Map unauthorized(Map modelMap) {
		SecurityUtils.getSubject().logout();
		return setModelMap(modelMap, HttpCode.UNAUTHORIZED);
	}

	// 没有权限
	@ResponseBody
	@RequestMapping("/forbidden")
	public Map forbidden(Map modelMap) {
		return setModelMap(modelMap, HttpCode.FORBIDDEN);
	}
}
