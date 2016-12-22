package com.stripcode.service.sf;

import com.stripcode.core.util.UUIDUtils;
import com.stripcode.mybatis.cs.model.CSSfPipeline;
import com.stripcode.mybatis.cs.model.TCsTaskCompletion;
import com.stripcode.mybatis.sf.dao.SFBudGetMapper;
import com.stripcode.mybatis.sf.model.*;
import com.stripcode.service.BaseService;
import com.stripcode.service.cs.TCsTaskCompletionService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Metro on 2016/11/10.
 */
@Service
@CacheConfig(cacheNames = "sfBudGet")
public class SF30_040Service extends BaseService {
    @Autowired
    private SFBudGetMapper sfBudGetMapper;
    @Autowired
    private TCsTaskCompletionService tCsTaskCompletionService;
    //查询工程预算列表
    public List<SFBudGetCost> selectBudgetCost(String ppId){
       return sfBudGetMapper.selectBudgetCost(ppId);
    }

    public List<SFBudGetConsUnit> selectBudgetConsUnit(String ppId){
        return  sfBudGetMapper.selectBudgetConsUnit(ppId);
    }
    //查询预算信息
    public SFBudGet selectBudget(String ppId,String rowId){
        SFBudGet sFBudGet = sfBudGetMapper.selectBudget(ppId);
        CSSfPipeline  csSfPipeline = sfBudGetMapper.selectPipeline(ppId);
        if(sFBudGet == null){
                sFBudGet = new SFBudGet();
                sFBudGet.setBudGetCostList(this.selectBudgetCost(ppId));
                sFBudGet.setBudGetConsUnitList(this.selectBudgetConsUnit(ppId));
            if(csSfPipeline==null){
                CSSfPipeline  csSfPipeline1 = new CSSfPipeline();
                sFBudGet.setCsSfPipeline(csSfPipeline1);
            }else{
                sFBudGet.setCsSfPipeline(csSfPipeline);
            }
        }else{
                sFBudGet.setBudGetCostList(this.selectBudgetCost(ppId));
                sFBudGet.setBudGetConsUnitList(this.selectBudgetConsUnit(ppId));
                sFBudGet.setCsSfPipeline(csSfPipeline);
        }
        return  sFBudGet;
    }
    //保存
    @Transactional
    public Map update(SFBudGet  sfBudGet,TCsTaskCompletion csTaskCompletion){
        Map modelMap = new HashMap();
        Map<String,Object> BudGetMap = new HashMap<String,Object>();
        //用于删除施工单位
        ArrayList BudGetRowId = new ArrayList();
        //定义是否成功 用于判断
        boolean result = true;
        //定义后台返回数据
        String message = "保存成功";
        Integer IsExist = 0;
        int count = -1;
        IsExist = sfBudGetMapper.isExistsBudget(sfBudGet.getPpId(),sfBudGet.getRowId());
        if(IsExist==0){
            if(StringUtils.isBlank(sfBudGet.getRowId())){
                sfBudGet.setRowId(UUIDUtils.generateKey());
                count = sfBudGetMapper.insertBudget(sfBudGet);
            }
        }else{
            count = sfBudGetMapper.updateBudget(sfBudGet);
        }
        for(SFBudGetCost sfBudGetCost :sfBudGet.getBudGetCostList()){
            IsExist = sfBudGetMapper.isExistsBudgetCost(sfBudGet.getRowId(), sfBudGetCost.getItemCode());
            if(IsExist==0){
                if(StringUtils.isBlank(sfBudGetCost.getRowId())) {
                    sfBudGetCost.setRowId(UUIDUtils.generateKey());
                    sfBudGetCost.setBudgetId(sfBudGet.getRowId());
                    count = sfBudGetMapper.insertBudgetCost(sfBudGetCost);
                }
            }else{
                sfBudGetCost.setBudgetId(sfBudGet.getRowId());
                count = sfBudGetMapper.updateBudgetCost(sfBudGetCost);
            }
        }
        if(sfBudGet.getBudGetConsUnitList()!=null){
            for(SFBudGetConsUnit sfBudGetConsUnit : sfBudGet.getBudGetConsUnitList()){
                IsExist = sfBudGetMapper.isExistsBudgetConsUnit(sfBudGetConsUnit.getRowId(),sfBudGet.getRowId());
                if(IsExist==0){
                    if(StringUtils.isBlank(sfBudGetConsUnit.getRowId())) {
                        sfBudGetConsUnit.setRowId(UUIDUtils.generateKey());
                        sfBudGetConsUnit.setBudgetId(sfBudGet.getRowId());
                        count = sfBudGetMapper.insertBudgetConsUnit(sfBudGetConsUnit);
                    }
                }else{
                    sfBudGetConsUnit.setBudgetId(sfBudGet.getRowId());
                    count = sfBudGetMapper.updateBudgetConsUnit(sfBudGetConsUnit);
                }
                //将rowId放入到集合中
                BudGetRowId.add(sfBudGetConsUnit.getRowId());
            }
        }
        if(BudGetRowId.size()==0){
            BudGetMap.put("isBudGetNull",0);
        }
        //执行删除操作
        BudGetMap.put("rowId",BudGetRowId);
        BudGetMap.put("budgetId",sfBudGet.getRowId());
        sfBudGetMapper.delBudgetConsUnit(BudGetMap);
        if(count!=1 ){
            result = false;
            message = "保存失败!";
        }
        csTaskCompletion.setRowId(UUIDUtils.generateKey());
        csTaskCompletion.setCreateTime(null);
        csTaskCompletion.setOptimauthId(sfBudGet.getPpId());
        tCsTaskCompletionService.upateStatusToFinished(csTaskCompletion);
        tCsTaskCompletionService.updatePipelineType(csTaskCompletion.getTaskId(),sfBudGet.getPpId());
        modelMap.put("result", result);
        modelMap.put("rowId", sfBudGet.getRowId());
        modelMap.put("message", message);
        return modelMap;
    }
}
