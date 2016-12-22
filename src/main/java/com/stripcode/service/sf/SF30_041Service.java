package com.stripcode.service.sf;

import com.stripcode.core.util.UUIDUtils;
import com.stripcode.mybatis.cs.model.CSSfPipeline;
import com.stripcode.mybatis.cs.model.TCsTaskCompletion;
import com.stripcode.mybatis.sf.dao.SFBudGetMapper;
import com.stripcode.mybatis.sf.dao.SFFinalAccountsMapper;
import com.stripcode.mybatis.sf.model.*;
import com.stripcode.service.BaseService;
import com.stripcode.service.cs.TCsTaskCompletionService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Metro on 2016/11/10.
 */
@Service
@CacheConfig(cacheNames = "FinalAccounts")
public class SF30_041Service extends BaseService {
    @Autowired
    private SFFinalAccountsMapper sfFinalAccountsMapper;
    @Autowired
    private SFBudGetMapper sfBudGetMapper;
    @Autowired
    private TCsTaskCompletionService tCsTaskCompletionService;
    //查询工程决算列表
    public List<SFFinalAccountsCost> selectAccountsCostList(String ppId){
       return sfFinalAccountsMapper.selectAccountsCostList(ppId);
    }

    public List<SFBudGetConsUnit> selectBudgetConsUnit(String ppId){
        return  sfFinalAccountsMapper.selectBudgetConsUnit(ppId);
    }
    //查询预算信息
    public SFFinalAccounts selectFinalAccounts(String ppId){
        SFFinalAccounts sfFinalAccounts = sfFinalAccountsMapper.selectFinalAccounts(ppId);
        CSSfPipeline  csSfPipeline = sfBudGetMapper.selectPipeline(ppId);
        if(sfFinalAccounts == null){
            sfFinalAccounts = new SFFinalAccounts();
            sfFinalAccounts.setFinalAccountsCostList(this.selectAccountsCostList(ppId));
            sfFinalAccounts.setBudGetConsUnitList(this.selectBudgetConsUnit(ppId));
            if(csSfPipeline==null){
                CSSfPipeline  csSfPipeline1 = new CSSfPipeline();
                sfFinalAccounts.setCsSfPipeline(csSfPipeline1);
            }else{
                sfFinalAccounts.setCsSfPipeline(csSfPipeline);
            }
        }else{
            sfFinalAccounts.setFinalAccountsCostList(this.selectAccountsCostList(ppId));
            sfFinalAccounts.setBudGetConsUnitList(this.selectBudgetConsUnit(ppId));
            sfFinalAccounts.setCsSfPipeline(csSfPipeline);
        }
        return  sfFinalAccounts;
    }
    //保存
    @Transactional
    public Map update(SFFinalAccounts  sfFinalAccounts,TCsTaskCompletion csTaskCompletion){
        Map modelMap = new HashMap();
        //定义是否成功 用于判断
        boolean result = true;
        //定义后台返回数据
        String message = "保存成功";
        Integer IsExist = 0;
        int count = -1;
        IsExist = sfFinalAccountsMapper.isExistsFinalAccounts(sfFinalAccounts.getRowId(),sfFinalAccounts.getPpId());
        if(IsExist==0){
            if(StringUtils.isBlank(sfFinalAccounts.getRowId())){
                sfFinalAccounts.setRowId(UUIDUtils.generateKey());
                count = sfFinalAccountsMapper.insertFinalAccounts(sfFinalAccounts);
            }
        }else{
            count = sfFinalAccountsMapper.updateFinalAccounts(sfFinalAccounts);
        }
        for(SFFinalAccountsCost sFFinalAccountsCost :sfFinalAccounts.getFinalAccountsCostList()){
            IsExist = sfFinalAccountsMapper.isExistsAccountsCost(sfFinalAccounts.getRowId(), sFFinalAccountsCost.getItemCode());
            if(IsExist==0){
                if(StringUtils.isBlank(sFFinalAccountsCost.getRowId())) {
                    sFFinalAccountsCost.setRowId(UUIDUtils.generateKey());
                    sFFinalAccountsCost.setBudgetId(sfFinalAccounts.getRowId());
                    count = sfFinalAccountsMapper.insertAccountsCost(sFFinalAccountsCost);
                }
            }else{
                sFFinalAccountsCost.setBudgetId(sfFinalAccounts.getRowId());
                count = sfFinalAccountsMapper.updateAccountsCost(sFFinalAccountsCost);
            }
        }
        if(count!=1 ){
            result = false;
            message = "保存失败!";
        }
        csTaskCompletion.setRowId(UUIDUtils.generateKey());
        csTaskCompletion.setCreateTime(null);
        csTaskCompletion.setOptimauthId(sfFinalAccounts.getPpId());
        tCsTaskCompletionService.upateStatusToFinished(csTaskCompletion);
        tCsTaskCompletionService.updatePipelineType(csTaskCompletion.getTaskId(),sfFinalAccounts.getPpId());
        modelMap.put("result", result);
        modelMap.put("rowId", sfFinalAccounts.getRowId());
        modelMap.put("message", message);
        return modelMap;
    }
}
