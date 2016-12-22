package com.stripcode.service.sf;

import com.stripcode.mybatis.cs.model.CSSfPipeline;
import com.stripcode.mybatis.sf.dao.SFPipelinePausePerminationMapper;
import com.stripcode.mybatis.sf.model.SFPipelinePausePermination;
import com.stripcode.service.BaseService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Map;


/**
 * Created by Metro on 2016/9/26.
 */
@Service
@CacheConfig(cacheNames = "sfSfpipelinePause")
public class SF30_004Service extends BaseService{
    @Autowired
    private SFPipelinePausePerminationMapper sfPipelinePausePerminationMapper;

    /**
     * 基本信息列表
     * @param ppId
     * @return CSSfPipeline 意向店列表
     */
    public CSSfPipeline selectBasePipeline(String ppId,String customerId){
        return sfPipelinePausePerminationMapper.selectBasePipeline(ppId,customerId);
    }

    /**
     * 意向店暂停信息
     * @param ppId 客户意向店ppId
     * @return
     */
    public SFPipelinePausePermination selectPipeline(String ppId){
        return sfPipelinePausePerminationMapper.selectPipelinePause(ppId);
    }
    /**
     * 查询终止信息
     * @param ppId 客户意向店ppId
     * @return
     */
    public SFPipelinePausePermination selectPipelineStop(String ppId){
        return  sfPipelinePausePerminationMapper.selectPipelineStop(ppId);
    }

    /**
     * 意向店暂停保存修改
     * @param sfPipelinePausePermination 意向店暂停实体
     * @return Map 意向店暂停信息
     */
    @Transactional
    public Map updatePipeline(SFPipelinePausePermination sfPipelinePausePermination){
        Map modelMap = new HashMap();
        //定义是否成功 用于判断
        boolean result = true;
        //定义后台返回数据
        String message = "保存成功";
        Integer IsExist = 0;
        int count = -1;
        IsExist = sfPipelinePausePerminationMapper.isExistsPipelineStopCount(sfPipelinePausePermination.getPpId());
        if(IsExist == 0){
            count = sfPipelinePausePerminationMapper.insertPipelintStop(sfPipelinePausePermination);
        }else{
            count = sfPipelinePausePerminationMapper.updatePipelineStop(sfPipelinePausePermination);
        }
                    sfPipelinePausePerminationMapper.updateStatusPipelineStop(sfPipelinePausePermination);
        if(count!=1 ){
            result = false;
            message = "保存失败!";
        }
        modelMap.put("result", result);
        modelMap.put("message", message);
        return modelMap;
    }

    /**
     * 意向店终止
     * @param sfPipelinePausePermination 意向店暂停实体
     * @param ppId 意向店ppId
     * @return 意向店终止信息
     * @throws Exception
     */
    @Transactional
    public Map update(SFPipelinePausePermination sfPipelinePausePermination ,String ppId) throws Exception{
        Map modelMap = new HashMap();
        //定义是否成功 用于判断
        boolean result = true;
        //定义后台返回数据
        String message = "保存成功";
        Integer IsExist = 0;
        int count = -1;
        if(StringUtils.isNotBlank(ppId)) {
            sfPipelinePausePermination.setPpId(ppId);
        }
        IsExist = sfPipelinePausePerminationMapper.isExistsPipelinePauseCount(ppId);
        if(IsExist == 0){
            count = sfPipelinePausePerminationMapper.insertPipelinePause(sfPipelinePausePermination);
        }else{
            count = sfPipelinePausePerminationMapper.updatePipelinePause(sfPipelinePausePermination);
        }
            sfPipelinePausePerminationMapper.updateStatusPipeline(sfPipelinePausePermination);
        if(count!=1 ){
            result = false;
            message = "保存失败!";
        }
        modelMap.put("result", result);
        modelMap.put("message", message);
        return modelMap;
    }

    //意向店恢复
    @Transactional
    public Map updateStatusRestorePipeline(String ppId,String itemType){
        Map modelMap = new HashMap();
        //定义是否成功 用于判断
        boolean result = true;
        //定义后台返回数据
        String message = "恢复成功";
        int count = -1;
        SFPipelinePausePermination sfPipelinePausePermination = null;
        if(StringUtils.isNotBlank(ppId)){
            sfPipelinePausePermination = new SFPipelinePausePermination();
            sfPipelinePausePermination.setPpId(ppId);
        }
        count = sfPipelinePausePerminationMapper.updateStatusRestorePipeline(sfPipelinePausePermination);
        /*if(itemType.equals("Stop")){
            sfPipelinePausePerminationMapper.updateStop(sfPipelinePausePermination);
        }else*/
        if(itemType.equals("restore")){
            sfPipelinePausePerminationMapper.updateRestore(sfPipelinePausePermination);
        }
        if(count!=1 ){
            result = false;
            message = "恢复失败!";
        }
        modelMap.put("result", result);
        modelMap.put("message", message);
        return modelMap;
    }

}
