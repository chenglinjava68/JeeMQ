package com.stripcode.core.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Metro on 2016/9/1.
 * 跨域访问参数设置 Metro
 */
public class AccessControlAllowOriginInterceptor extends BaseInterceptor {
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        response.setContentType("application/json;charset=UTF-8");
        response.setHeader("Access-Control-Allow-Origin","*");
        return nextInterceptor(request, response, handler);
    }
}
