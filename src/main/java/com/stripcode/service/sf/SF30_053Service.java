package com.stripcode.service.sf;

import com.stripcode.core.util.UUIDUtils;
import com.stripcode.mybatis.cs.model.TCsTaskCompletion;
import com.stripcode.mybatis.sf.dao.SFLandlordLayoutMapper;
import com.stripcode.mybatis.sf.model.SFLandlordLayout;
import com.stripcode.service.BaseService;
import com.stripcode.service.cs.TCsTaskCompletionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.stereotype.Service;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Metro on 2016/9/26.
 */
@Service
@CacheConfig(cacheNames = "sfHousePaper")
public class SF30_053Service extends BaseService{
    @Autowired
    private SFLandlordLayoutMapper sfLandlordLayoutMapper;
    @Autowired
    private TCsTaskCompletionService tCsTaskCompletionService;
    //查询
    public List<SFLandlordLayout> selectHousePaperAll(String ppId){
        return  sfLandlordLayoutMapper.selectHousePaperAll(ppId);
    }
    //保存修改
    public Map update(List<SFLandlordLayout> sfLandLord , TCsTaskCompletion csTaskCompletion,String ppId){
        Map modelMap = new HashMap();
        //定义是否成功 用于判断
        boolean result = true;
        //定义后台返回数据
        String message = "保存成功";
        Integer IsExist = 0;
        int count = -1;
        for(SFLandlordLayout sfLandlordLayout :sfLandLord){
            IsExist = sfLandlordLayoutMapper.HousePaperCount(sfLandlordLayout.getPpId(),sfLandlordLayout.getTemplateId());
            if(IsExist == 0){
                count = sfLandlordLayoutMapper.insertHousePaper(sfLandlordLayout);
            }else {
                count = sfLandlordLayoutMapper.updateHousePaper(sfLandlordLayout);
            }
        }
        if(count!=1 ){
            result = false;
            message = "保存失败!";
        }
        csTaskCompletion.setRowId(UUIDUtils.generateKey());
        csTaskCompletion.setCreateTime(null);
        csTaskCompletion.setOptimauthId(ppId);
        tCsTaskCompletionService.upateStatusToFinished(csTaskCompletion);
        tCsTaskCompletionService.updatePipelineType(csTaskCompletion.getTaskId(),ppId);
        modelMap.put("result", result);
        modelMap.put("message", message);
        return modelMap;
    }

}
