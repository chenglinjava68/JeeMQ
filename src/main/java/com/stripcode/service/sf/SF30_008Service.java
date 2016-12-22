package com.stripcode.service.sf;

import com.stripcode.core.util.UUIDUtils;
import com.stripcode.mybatis.cs.model.TCsTaskCompletion;
import com.stripcode.mybatis.sf.dao.SFLandlordInfoMapper;
import com.stripcode.mybatis.sf.model.SFEstateSource;
import com.stripcode.mybatis.sf.model.SFLandlordinfo;
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
 * @author Metro
 */
@Service
@CacheConfig(cacheNames = "SF30_008Service")
public class SF30_008Service {
    @Autowired
    private SFLandlordInfoMapper sfLandlordInfoMapper;

    @Autowired
    private TCsTaskCompletionService tCsTaskCompletionService;

    /**
     * 查询业主信息
     * @param estateId
     * @return
     */
    public List<SFLandlordinfo> queryLandlordInfo(String estateId){
        return sfLandlordInfoMapper.selectLandLordInfo(estateId);
    }

    /**
     * 查询房产来源
     * @param ppId
     * @return
     */
    public SFEstateSource queryEstateSource(String ppId){
        SFEstateSource sfEstateSource = sfLandlordInfoMapper.selectEstateSourceInfo(ppId);
        if(sfEstateSource!=null){
            sfEstateSource.setLandlordinfoList(this.queryLandlordInfo(sfEstateSource.getRowId()));
            return sfEstateSource;
        }

        SFEstateSource model = new SFEstateSource();
        model.setLandlordinfoList(this.queryLandlordInfo(null));
        return model;
    }

    /**
     * 保存房产来源和业主信息
     * @param sfEstateSource
     * @return Map
     */
    @Transactional
    public Map<String,Object> update(SFEstateSource sfEstateSource, TCsTaskCompletion tCsTaskCompletion){
        Map<String,Object> map = new HashMap<String,Object>();
        Map<String,Object> landMap = new HashMap<String,Object>();
        Boolean result = true;
        String message = "保存成功!";
        Integer count = -1;
        ArrayList landlordRowId = new ArrayList();

        if(StringUtils.isBlank(sfEstateSource.getRowId())){
            sfEstateSource.setRowId(UUIDUtils.generateKey());
            count = sfLandlordInfoMapper.insertEstateSource(sfEstateSource);
        }else {
            count = sfLandlordInfoMapper.updateEstateSource(sfEstateSource);
        }

        if(sfEstateSource.getLandlordinfoList()!=null){
            for (SFLandlordinfo model : sfEstateSource.getLandlordinfoList()){
                model.setEstateId(sfEstateSource.getRowId());
                count = this.saveLandlordInfo(model);
                landlordRowId.add(model.getRowId());
            }
        }

        Integer islandNull = 1;
        if(landlordRowId.size()==0){
            islandNull = 0;
        }
        landMap.put("islandNull",islandNull);
        landMap.put("rowId",landlordRowId);
        landMap.put("estateId",sfEstateSource.getRowId());
        sfLandlordInfoMapper.deleteLandlordInfo(landMap);

        if(count==0){
            result = false;
            message = "保存失败!";
        }
        //更新节点状态
        tCsTaskCompletion.setRowId(UUIDUtils.generateKey());
        tCsTaskCompletion.setCreateTime(null);
        tCsTaskCompletion.setOptimauthId(sfEstateSource.getPpId());
        tCsTaskCompletionService.upateStatusToFinished(tCsTaskCompletion);
        tCsTaskCompletionService.updatePipelineType(tCsTaskCompletion.getTaskId(),tCsTaskCompletion.getOptimauthId());
        map.put("result",result);
        map.put("message",message);

        return map;
    }

    /**
     * 保存业主信息
     * @param model
     * @return Integer
     */
    public Integer saveLandlordInfo(SFLandlordinfo model){
        if(StringUtils.isBlank(model.getRowId())){
            model.setRowId(UUIDUtils.generateKey());
            return sfLandlordInfoMapper.insertLandLord(model);
        }else {
            return sfLandlordInfoMapper.updateLandLord(model);
        }
    }
}
