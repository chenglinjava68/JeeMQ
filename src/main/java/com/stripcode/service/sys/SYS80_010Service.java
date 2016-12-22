package com.stripcode.service.sys;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.stripcode.core.util.PageSortUtil;
import com.stripcode.mybatis.sf.dao.SFSfApprovalMapper;
import com.stripcode.mybatis.sys.dao.TSysTaskMapper;
import com.stripcode.mybatis.sys.model.TSysTask;
import com.stripcode.service.BaseService;
import org.activiti.engine.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * Created by Metro on 2016/12/02.
 */
@Service
@CacheConfig(cacheNames = "SYS80_010")
public class SYS80_010Service extends BaseService{
    @Autowired
    private TSysTaskMapper sysTaskMapper;
    @Autowired
    private SFSfApprovalMapper approvalMapper;

    @Autowired
    TaskService taskservice;
    /**
     * 列表带分页的查询数据
     * @param params
     * @return
     */
    public PageInfo<TSysTask> queryForPage(Map<String,Object> params){
        PageSortUtil.unoinSortBySord(params);
        PageHelper.startPage(params);
        return new PageInfo<TSysTask>(sysTaskMapper.queryForPage(params));
    }
}
