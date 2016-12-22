package com.stripcode.service.sf;

import com.stripcode.core.util.UUIDUtils;
import com.stripcode.mybatis.cs.model.TCsTaskCompletion;
import com.stripcode.mybatis.sf.dao.SFTradezoneInfoMapper;
import com.stripcode.mybatis.sf.model.SFTradezoneCiuInfo;
import com.stripcode.mybatis.sf.model.SFTradezoneInfo;
import com.stripcode.mybatis.sf.model.SFTradezoneStoreInfo;
import com.stripcode.service.cs.TCsTaskCompletionService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Metro
 */
@Service
@CacheConfig(cacheNames = "SF30_012Service")
public class SF30_012Service {
    @Autowired
    private SFTradezoneInfoMapper sfTainfoMapper;

    @Autowired
    private TCsTaskCompletionService tCsTaskCompletionService;

    public SFTradezoneInfo queryTaInfo(String ppId){
        SFTradezoneInfo model = sfTainfoMapper.queryTaInfo(ppId);
        if(model!=null){
            model.setTradezoneCiuInfoList(sfTainfoMapper.queryTradezoneCiuInfoAll(model.getRowId()));
            model.setTradezoneStoreInfoList(sfTainfoMapper.queryTradezoneStoreInfoAll(model.getRowId()));
            return model;
        }
        SFTradezoneInfo sfTradezoneInfo = new SFTradezoneInfo();
        sfTradezoneInfo.setTradezoneCiuInfoList(sfTainfoMapper.queryTradezoneCiuInfoAll(null));
        sfTradezoneInfo.setTradezoneStoreInfoList(sfTainfoMapper.queryTradezoneStoreInfoAll(null));
        return sfTradezoneInfo;
    }

    public Map<String,Object> update(SFTradezoneInfo model, TCsTaskCompletion tCsTaskCompletion){
        Map<String,Object> map = new HashMap<String,Object>();
        Map<String,Object> ciuMap = new HashMap<String,Object>();
        Map<String,Object> storeMap = new HashMap<String,Object>();
        ArrayList ciuArray = new ArrayList();
        ArrayList storeArray = new ArrayList();
        Boolean result = true;
        String message = "保存成功!";
        Integer count = -1;

        if(StringUtils.isBlank(model.getRowId())){
            model.setRowId(UUIDUtils.generateKey());
            count = sfTainfoMapper.insertTaInfo(model);
        }else {
            count = sfTainfoMapper.updateTaInfo(model);
        }
        if(model.getTradezoneCiuInfoList()!=null){
            for (SFTradezoneCiuInfo item : model.getTradezoneCiuInfoList()){
                item.setTradezoneId(model.getRowId());
                if(StringUtils.isBlank(item.getRowId())){
                    item.setRowId(UUIDUtils.generateKey());
                    item.setTradezoneId(model.getRowId());
                    count = sfTainfoMapper.insertTradezoneCiuInfo(item);
                }else {
                    count = sfTainfoMapper.updateTradezoneCiuInfo(item);
                }
                ciuArray.add(item.getRowId());
            }
        }

        if(model.getTradezoneStoreInfoList()!=null){
            for (SFTradezoneStoreInfo item: model.getTradezoneStoreInfoList()){
                item.setTradezoneId(model.getRowId());
                if(StringUtils.isBlank(item.getRowId())){
                    item.setRowId(UUIDUtils.generateKey());
                    count = sfTainfoMapper.insertTradezoneStoreInfo(item);
                }else {
                    count = sfTainfoMapper.updateTradezoneStoreInfo(item);
                }
                storeArray.add(item.getRowId());
            }
        }

        Integer isStoreDelete = 1;
        Integer isCiuDelete=1;
        if(storeArray.size()==0){
            isStoreDelete = 0;
        }
        if(ciuArray.size()==0){
            isCiuDelete = 0;
        }
        if(count==0){
            result = false;
            message = "保存失败!";
        }

        storeMap.put("isDelete",isStoreDelete);
        storeMap.put("rowId",storeArray);
        storeMap.put("tradezoneId",model.getRowId());
        sfTainfoMapper.deleteStore(storeMap);

        ciuMap.put("isDelete",isCiuDelete);
        ciuMap.put("rowId",ciuArray);
        ciuMap.put("tradezoneId",model.getRowId());
        sfTainfoMapper.deleteCiu(ciuMap);

        //更新节点状态
        tCsTaskCompletion.setRowId(UUIDUtils.generateKey());
        tCsTaskCompletion.setCreateTime(null);
        tCsTaskCompletion.setOptimauthId(model.getPpId());
        tCsTaskCompletionService.upateStatusToFinished(tCsTaskCompletion);
        tCsTaskCompletionService.updatePipelineType(tCsTaskCompletion.getTaskId(),tCsTaskCompletion.getOptimauthId());
        map.put("rowId",model.getRowId());
        map.put("result",result);
        map.put("message",message);
        return map;
    }
}
