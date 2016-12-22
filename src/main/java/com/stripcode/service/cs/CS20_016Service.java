package com.stripcode.service.cs;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.stripcode.mybatis.cs.dao.CSCustomerPPMapper;
import com.stripcode.mybatis.cs.model.CSSfPipeline;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * Created by Metro on 2016/8/31.
 */
@Service
@CacheConfig(cacheNames = "csCustomerPP")
public class CS20_016Service {
    @Autowired
    private CSCustomerPPMapper csCustomerPPMapper;
    //店铺列表
    public PageInfo<CSSfPipeline> queryForPage(Map<String ,Object> params){
        PageHelper.startPage(params);
        return  new PageInfo<CSSfPipeline>(csCustomerPPMapper.queryForPage(params));
    }

}
