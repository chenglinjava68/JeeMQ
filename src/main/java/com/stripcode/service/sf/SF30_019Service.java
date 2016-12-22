package com.stripcode.service.sf;

import com.stripcode.core.util.UUIDUtils;
import com.stripcode.mybatis.cs.model.TCsTaskCompletion;
import com.stripcode.mybatis.sf.dao.SFBudGetEstimationCostMapper;
import com.stripcode.mybatis.sf.model.SFBudGetEstimation;
import com.stripcode.mybatis.sf.model.SFBudGetEstimationCost;
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
 * Created by Metro on 2016/9/28.
 */
@Service
@CacheConfig(cacheNames = "sfBudGetEstimationCost")
public class SF30_019Service extends BaseService {
    @Autowired
    private SFBudGetEstimationCostMapper sfBudGetEstimationCostMapper;
    @Autowired
    private TCsTaskCompletionService tCsTaskCompletionService;
    //查询成本列表
    public List<SFBudGetEstimationCost> SelectBudGetCost(String ppId){
        return sfBudGetEstimationCostMapper.SelectBudGetCost(ppId);
    }
    //查询启动原因
    public SFBudGetEstimation selectBudGetEstimation(String ppId){
        SFBudGetEstimation  sfBudGetEstimation = sfBudGetEstimationCostMapper.SelectBudGetEstimation(ppId);
        if(sfBudGetEstimation==null){
            sfBudGetEstimation = new SFBudGetEstimation();
            sfBudGetEstimation.setBudGetEstimationCostList(this.SelectBudGetCost(ppId));
        }else{
            sfBudGetEstimation.setBudGetEstimationCostList(this.SelectBudGetCost(ppId));
        }
        return sfBudGetEstimation;
    }
    //保存
    @Transactional
    public Map update(SFBudGetEstimation  sfBudGetEstimation,TCsTaskCompletion csTaskCompletion){
        Map modelMap = new HashMap();
        //定义是否成功 用于判断
        boolean result = true;
        //定义后台返回数据
        String message = "保存成功";
        Integer IsExist = 0;
        int count = -1;
        IsExist = sfBudGetEstimationCostMapper.isExistsBudGetEstimation(sfBudGetEstimation.getPpId());
        if(IsExist==0){
            if(StringUtils.isBlank(sfBudGetEstimation.getRowId())) {
                sfBudGetEstimation.setRowId(UUIDUtils.generateKey());
                count = sfBudGetEstimationCostMapper.insertBudGetEstimation(sfBudGetEstimation);
            }
        }else {
            count = sfBudGetEstimationCostMapper.updateBudGetEstimation(sfBudGetEstimation);
        }
        for(SFBudGetEstimationCost sFBudGetEstimationCost : sfBudGetEstimation.getBudGetEstimationCostList()){
            IsExist = sfBudGetEstimationCostMapper.isExistsBudGetCost(sfBudGetEstimation.getRowId(),sFBudGetEstimationCost.getItemCode());
            if(IsExist==0){
                if(StringUtils.isBlank(sFBudGetEstimationCost.getRowId())) {
                    sFBudGetEstimationCost.setRowId(UUIDUtils.generateKey());
                    sFBudGetEstimationCost.setEstId(sfBudGetEstimation.getRowId());
                    count = sfBudGetEstimationCostMapper.insertBudGetCost(sFBudGetEstimationCost);
                }
            }else{
                sFBudGetEstimationCost.setEstId(sfBudGetEstimation.getRowId());
                count = sfBudGetEstimationCostMapper.updateBudGetCost(sFBudGetEstimationCost);
            }
        }
        if(count!=1 ){
            result = false;
            message = "保存失败!";
        }
        csTaskCompletion.setRowId(UUIDUtils.generateKey());
        csTaskCompletion.setCreateTime(null);
        csTaskCompletion.setOptimauthId(sfBudGetEstimation.getPpId());
        tCsTaskCompletionService.upateStatusToFinished(csTaskCompletion);
        tCsTaskCompletionService.updatePipelineType(csTaskCompletion.getTaskId(),sfBudGetEstimation.getPpId());
        modelMap.put("result", result);
        modelMap.put("rowId", sfBudGetEstimation.getRowId());
        modelMap.put("message", message);
        return modelMap;
    }
}
