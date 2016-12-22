package com.stripcode.mybatis.cs.dao;

import com.github.pagehelper.Page;
import com.stripcode.mybatis.cs.model.*;

import java.util.List;
import java.util.Map;

/**
 * Created by Metro on 2016/8/22.
 */
public interface CSMarketOptimauthMapper {

    Page<CSMarketOptimauth>  selectForPage(Map<String,Object> map);
    List<CSMarketOptimauth> selectForExport(Map<String,Object> map);
    CSMarketOptimauth queryOptimauth(String optimauthId);
}
