package com.stripcode.service.ps;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.stripcode.core.util.PageSortUtil;
import com.stripcode.mybatis.ps.dao.PSPolicySupportMapper;
import com.stripcode.mybatis.ps.model.PSPolicySupport;
import com.stripcode.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * Created by Metro on 2016/10/11.
 */
@Service
@CacheConfig(cacheNames = "psPolicy")
public class PS70_008Service extends BaseService{
    @Autowired
    private PSPolicySupportMapper psPolicySupportMapper;
    /*
    * 列表带分页的查询条件
    * */
    public PageInfo<PSPolicySupport> psPolicyQueryForPage(Map<String ,Object> params){
        //合并orderBy Sord
        PageSortUtil.unoinSortBySord(params);
        PageHelper.startPage(params);
        return new PageInfo<PSPolicySupport>(psPolicySupportMapper.psPolicyQueryForPage(params));
    }
}
