package com.stripcode.service.sf;

import com.stripcode.core.util.UUIDUtils;
import com.stripcode.mybatis.cs.model.TCsTaskCompletion;
import com.stripcode.mybatis.sf.dao.SFLandlordInterestMapper;
import com.stripcode.mybatis.sf.model.SFLandlordInterest;
import com.stripcode.service.BaseService;
import com.stripcode.service.cs.TCsTaskCompletionService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Metro on 2016/11/17.
 */
@Service
@CacheConfig(cacheNames = "sfLandlordInterest")
public class SF30_016Service extends BaseService{
    @Autowired
    SFLandlordInterestMapper sfLandlordInterestMapper;
    @Autowired
    private TCsTaskCompletionService tCsTaskCompletionService;
    /**
     * 查询意向书基本信息
     * @param ppId
     * @return
     */
    public SFLandlordInterest selectLoad(String ppId){
        return sfLandlordInterestMapper.selectLoad(ppId);
    }
    public Map update(SFLandlordInterest sfLandlordInterest,TCsTaskCompletion csTaskCompletion)throws Exception{
        Map modelMap = new HashMap();
        int count = -1;
        //保存或修改是否成功
        boolean result = true;
        //返回到前台的提示信息
        String message = "保存成功!";
        Integer IsExist = 0;
        IsExist=sfLandlordInterestMapper.isExistsSFLandlordInterest(sfLandlordInterest.getPpId(),sfLandlordInterest.getRowId());
        if(IsExist==0){
            if(StringUtils.isBlank(sfLandlordInterest.getRowId())){
                sfLandlordInterest.setRowId(UUIDUtils.generateKey());
                count =sfLandlordInterestMapper.insert(sfLandlordInterest);
            }
        }else {
            count =sfLandlordInterestMapper.update(sfLandlordInterest);
        }
        if (count!=1){
            result = false;
            message = "保存失败!";
        }
        csTaskCompletion.setRowId(UUIDUtils.generateKey());
        csTaskCompletion.setCreateTime(null);
        csTaskCompletion.setOptimauthId(sfLandlordInterest.getPpId());
        tCsTaskCompletionService.upateStatusToFinished(csTaskCompletion);
        tCsTaskCompletionService.updatePipelineType(csTaskCompletion.getTaskId(),sfLandlordInterest.getPpId());
        modelMap.put("rowId", sfLandlordInterest.getRowId());
        modelMap.put("result", result);
        modelMap.put("message", message);
        return modelMap;
    }
}
