package com.stripcode.service.cs;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.stripcode.core.util.PageSortUtil;
import com.stripcode.core.util.UUIDUtils;
import com.stripcode.mybatis.cs.dao.CSCustomerInfoMapper;
import com.stripcode.mybatis.cs.dao.CSSfPipelineMapper;
import com.stripcode.mybatis.cs.dao.TCsTaskCompletionMapper;
import com.stripcode.mybatis.cs.model.*;
import com.stripcode.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.stereotype.Service;


import java.util.*;

/**
 * Created by Metro on 2016/8/26.
 */
@Service
@CacheConfig(cacheNames = "csSfPipeline")
public class CS20_011Service extends BaseService {
    @Autowired
    private CSCustomerInfoMapper csCustomerInfoMapper;
    @Autowired
    private CSSfPipelineMapper csSfPipelineMapper;
    @Autowired
    private TCsTaskCompletionMapper tCsTaskCompletionMapper;
    @Autowired
    private TCsTaskCompletionService tCsTaskCompletionService;

    /*
        查询客户意向店 客户信息
         */
    public CSCustomerInfo selectCPById(String customerId) {
        return csCustomerInfoMapper.selectById(customerId);
    }

    /*
    查询意向店PPId
     */
    public List<CSSfPipeline> selectPPid(String rowId) {
        return csSfPipelineMapper.selectPPid(rowId);
    }

    //意向店列表
    public List<CSSfPipeline> selectList(String pids, String rowId) {
        CSPipelineIds csPipelineIds = new CSPipelineIds();
        String[] pid = pids.split(",");
        csPipelineIds.setPids(pid);
        csPipelineIds.setRowId(rowId);
        return csSfPipelineMapper.selectList(csPipelineIds);
    }
    public PageInfo<CSSfPipeline> queryForPage(Map<String ,Object> params) {
        PageSortUtil.unoinSortBySord(params);
        PageHelper.startPage(params);
        String ppId=params.get("ppId").toString();
        String[] ppid = ppId.split(",");
        params.put("ppid",ppid);
        return new PageInfo<CSSfPipeline>(csSfPipelineMapper.selectListPP(params));
    }

    public List<CSSfPipeline> selectPiList(String customerId, String rowId) {
        return csSfPipelineMapper.selectPiList(customerId, rowId);
    }

    //意向店保存
    public Map insertBatchPipeline(Map<String, Object> map, String userId, TCsTaskCompletion tCsTaskCompletion) {
        Map modelMap = new HashMap();
        //定义是否成功 用于判断
        boolean result = true;
        String[] ppId = null;
        try {
            ppId = (String[]) map.get("ppId");
        } catch (Exception e) {
            ppId = new String[1];
            ppId[0] = (String) map.get("ppId");
        }
        String optimauthId = map.get("rowId").toString();
        int count = -1;
        List<CSCustomerPP> list = new ArrayList<CSCustomerPP>();
       if(ppId==null||ppId.length==0){
            ppId = new String[0];
           count = 1;
        }
        for (int i = 0; i < ppId.length; i++) {
            CSCustomerPP csCustomerPP = new CSCustomerPP();
            csCustomerPP.setPpId(ppId[i]);
            csCustomerPP.setRowId(UUIDUtils.generateKey());
            csCustomerPP.setOptimauthId(optimauthId);
            csCustomerPP.setUpdateTime(new Date());
            csCustomerPP.setCreateTime(new Date());
            csCustomerPP.setUpdater(userId);
            csCustomerPP.setCreator(userId);
            list.add(csCustomerPP);
        }
        //查询客户是否有意向店
        Integer isExist = 0;
        for(CSCustomerPP cSCustomerPP:list){
        isExist = csSfPipelineMapper.PipelineCount(cSCustomerPP.getPpId(),cSCustomerPP.getOptimauthId());
        if (isExist == 0) {
            count = csSfPipelineMapper.insertBatchPipeline(cSCustomerPP);
        } else {
            count = csSfPipelineMapper.BatchUpdate(cSCustomerPP);
        }
        }
        csSfPipelineMapper.updatePipelineDelFlag(ppId,optimauthId);
        tCsTaskCompletionService.updateOptimauthType("M0090",optimauthId);
        tCsTaskCompletionService.upateStatusToFinished(tCsTaskCompletion);
        if (count != 1) {
            modelMap.put("result", false);
            modelMap.put("message", "保存失败!");
            return modelMap;
        }
        modelMap.put("ppId", ppId);
        modelMap.put("result", result);
        modelMap.put("message", "保存成功!");
        return modelMap;

    }

}
