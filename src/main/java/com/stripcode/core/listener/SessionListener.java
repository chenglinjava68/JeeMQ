package com.stripcode.core.listener;

import com.stripcode.core.Constants;
import com.stripcode.core.util.RedisUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * 会话监听器
 * 
 * @author Metro
 * @version $Id: SessionListener.java, v 0.1 2014年3月28日 上午9:06:12 Metro Exp
 */
public class SessionListener implements HttpSessionListener {
	private Logger logger = LogManager.getLogger(SessionListener.class);
//	@Autowired
//	private SysSessionService sessionService;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * javax.servlet.http.HttpSessionListener#sessionCreated(javax.servlet.http
	 * .HttpSessionEvent)
	 */
	public void sessionCreated(HttpSessionEvent event) {
		HttpSession session = event.getSession();
		session.setAttribute(Constants.WEBTHEME, "default");
		logger.info("创建了一个Session连接:[" + session.getId() + "]");
		setAllUserNumber(1);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * javax.servlet.http.HttpSessionListener#sessionDestroyed(javax.servlet
	 * .http.HttpSessionEvent)
	 */
	public void sessionDestroyed(HttpSessionEvent event) {
		HttpSession session = event.getSession();
		logger.info("销毁了一个Session连接:[" + session.getId() + "]");
		session.removeAttribute(Constants.CURRENT_USER);
//		sessionService.deleteBySessionId(session.getId());
		setAllUserNumber(-1);
	}

	private void setAllUserNumber(int n) {
		Long number = getAllUserNumber() + n;
		logger.info("用户数：" + number);
		RedisUtil.set(Constants.ALLUSER_NUMBER, 60 * 60 * 24, number);
	}

	/** 获取在线用户数量 */
	public static Long getAllUserNumber() {
		String v = RedisUtil.get(Constants.ALLUSER_NUMBER);
		if (v != null) {
			return Long.valueOf(v);
		}
		return 0L;
	}
}
