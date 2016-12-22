package com.stripcode.core.util;

import org.apache.commons.lang3.StringUtils;

import java.util.Map;

/**
 * Created by Metro on 2016/10/9.
 */
public class PageSortUtil {

    /**
     *  合并排序sortBy sord两个参数
     * @param param 分页参数
     * @return
     */
    public static void unoinSortBySord(Map<String,Object> param) {
        if(param!=null) {
            String strOrderBy = "";
            Object orderByObj = param.get("orderBy");
            Object sordObj = param.get("sord");
            if (sordObj != null && !StringUtils.isBlank(sordObj.toString())) {
                if (orderByObj != null && !StringUtils.isBlank(orderByObj.toString())) {
                    strOrderBy = orderByObj.toString() + " " + sordObj.toString();
                    param.put("orderBy", strOrderBy);
                }
            }
        }
    }
}
