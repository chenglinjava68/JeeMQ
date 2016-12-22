/**
 * 
 */
package com.stripcode.web;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.stripcode.core.Constants;
import com.stripcode.core.support.HttpCode;
import com.stripcode.core.util.WebUtil;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.jdbc.BadSqlGrammarException;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Metro
 */
@Service
public class BaseController {
	private static final String DATABASE_ERROR = "数据库报错";
	private static final String SERVER_ERROR = "服务器报错";
	protected final Logger logger = LogManager.getLogger(this.getClass());

	/** 获取当前用户Id */
	protected String getCurrUser() {
		return WebUtil.getCurrentUser();
	}

	/** 设置成功响应代码 */
	protected Map setSuccessModelMap(Map modelMap) {
		return setSuccessModelMap(modelMap, null);
	}

	/** 设置成功响应代码 */
	protected Map setSuccessModelMap(Map modelMap, Object data) {
		return setModelMap(modelMap, HttpCode.OK, data);
	}

	/** 设置相应代码 */
	protected Map setModelMap(Map modelMap, HttpCode code) {
		return setModelMap(modelMap, code, null);
	}

	/** 设置相应代码 */
	protected Map setModelMap(Map modelMap, HttpCode code, Object data) {
		if (data != null) {
			modelMap.put("data", data);
		}
		modelMap.put("httpCode", code.value());
		modelMap.put("msg", code.msg());
		return modelMap;
	}

	/** 设置相应代码 */
	protected HashMap setHashMap(HashMap modelMap, HttpCode code, Object data) {
		if (data != null) {
			modelMap.put("data", data);
		}
		modelMap.put("httpCode", code.value());
		modelMap.put("msg", code.msg());
		return modelMap;
	}

	/** 设置相应代码 */
	protected Map setMap(Map modelMap, HttpCode code, Object data) {
		if (data != null) {
			modelMap.put("data", data);
		}
		modelMap.put("httpCode", code.value());
		modelMap.put("msg", code.msg());
		return modelMap;
	}

	/** 异常处理 */
	@ExceptionHandler(RuntimeException.class)
	public void exceptionHandler(HttpServletResponse response, Exception ex) throws Exception {
		logger.error(Constants.Exception_Head, ex);
		Map modelMap = new HashMap();
		if (ex instanceof IllegalArgumentException) {
			if (StringUtils.isNotBlank(ex.getMessage())) {
				modelMap.put("httpCode", HttpCode.BAD_REQUEST.value());
				modelMap.put("msg", ex.getMessage());
			} else {
				setModelMap(modelMap, HttpCode.BAD_REQUEST);
			}
		}
		else if (ex instanceof BadSqlGrammarException) {
			setSuccessModelMap(modelMap,DATABASE_ERROR);
		}
		else if(ex instanceof DataIntegrityViolationException){
			setSuccessModelMap(modelMap,DATABASE_ERROR);
		}
		else {
			if(StringUtils.isNotBlank(ex.getMessage())){
				setSuccessModelMap(modelMap,SERVER_ERROR);
			}
			setModelMap(modelMap, HttpCode.INTERNAL_SERVER_ERROR);
		}
		response.setContentType("application/json;charset=UTF-8");
		byte[] bytes = JSON.toJSONBytes(modelMap, SerializerFeature.DisableCircularReferenceDetect);
		response.getOutputStream().write(bytes);
	}
}
