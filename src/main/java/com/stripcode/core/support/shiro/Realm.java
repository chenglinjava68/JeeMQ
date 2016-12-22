package com.stripcode.core.support.shiro;

import com.stripcode.core.Constants;
import com.stripcode.core.util.RedisNewUtil;
import com.stripcode.core.util.WebUtil;
import com.stripcode.mybatis.generator.model.SysSession;
import com.stripcode.mybatis.user.model.RscSysPosition;
import com.stripcode.mybatis.user.model.RscSysRoleusermap;
import com.stripcode.mybatis.user.model.RscSysUser;
import com.stripcode.service.user.RscSysPositionService;
import com.stripcode.service.user.RscSysRoleusermapService;
import com.stripcode.service.user.RscSysUserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Realm extends AuthorizingRealm {
/*	@Autowired
	private SysSessionService sessionService;*/
	@Autowired
    private RscSysUserService rscSysUserService;

	@Autowired
	private RscSysPositionService rscSysPositionService;
	@Autowired
	RscSysRoleusermapService rscSysRoleusermapService;
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		return null;
	}

	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authcToken)
			throws AuthenticationException {
		UsernamePasswordToken token = (UsernamePasswordToken) authcToken;
		Map<String, Object> params = new HashMap<String, Object>();
		// params.put("countSql", 0);
		// params.put("usable", 1);
		// params.put("pageNum",1);
		// params.put("pageSize",1);
		StringBuilder sb = new StringBuilder(100);
		sb.append(token.getPassword());
		params.put("password", sb.toString());
		params.put("loginName",token.getUsername());
		List<RscSysUser> userList = rscSysUserService.queryByConditions(params);
		if (userList != null && userList.size()>0) {
			RscSysUser user = userList.get(0);
			/*用户信息存入缓存*/
			String key = getCacheKey(user.getUserId());
			RscSysUser record = (RscSysUser) RedisNewUtil.get(key);
			if (record == null){
				RedisNewUtil.set(key,user);//将用户信息存入redis，用户信息如有变动需要更新redis
			}
			WebUtil webUtil = new WebUtil();
			/*岗位、角色信息存入redis*/
			RscSysPosition position = rscSysPositionService.queryUserId(user.getUserId());//获取岗位信息
			if (null != position){
				/*岗位信息存入缓存*/
				String keyposition = webUtil.getCachePositionKey(user.getUserId());//获取岗位信息的key
				RscSysPosition recordPosition = (RscSysPosition) RedisNewUtil.get(keyposition);
				if (recordPosition == null){
					RedisNewUtil.set(keyposition,position);//将岗位信息存入redis  ，岗位信息如有变动需要更新redis
				}
				/*角色信息存入缓存*/
				Map<String,Object> paramsrole = new HashMap<String,Object>();
				paramsrole.put("positionId",position.getPositionid());
				ArrayList<RscSysRoleusermap> listRole = rscSysRoleusermapService.queryRole(paramsrole);
				if (null != listRole && listRole.size() > 0){
					String keyposrole = webUtil.getCacheRoleKey(user.getUserId());//获取角色信息的key
					ArrayList<RscSysRoleusermap> listValue = (ArrayList<RscSysRoleusermap>)RedisNewUtil.get(keyposrole);
					if (listValue == null){
						RedisNewUtil.set(keyposrole,listRole);//将角色信息存入redis,角色信息如有变动需要更新redis
					}
				}
			}
			WebUtil.saveCurrentUser(user.getUserId());
			saveSession(user.getLoginName());
			AuthenticationInfo authcInfo = new SimpleAuthenticationInfo(user.getLoginName(), user.getPassword(),
					user.getUserName());
			return authcInfo;
		} else {
			return null;
		}
	}

	/** 保存session */
	private void saveSession(String account) {
		SysSession record = new SysSession();
		record.setAccount(account);
		Subject currentUser = SecurityUtils.getSubject();
		Session session = currentUser.getSession();
		record.setSessionId(session.getId().toString());
		record.setIp(session.getHost());
		record.setStartTime(session.getStartTimestamp());
//		sessionService.update(record);
	}
	/** 获取缓存键值 */
	public String getCacheKey(Object id) {
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
