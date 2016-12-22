package com.stripcode.service.sf;

import com.stripcode.core.util.UUIDUtils;
import com.stripcode.mybatis.cs.model.TCsTaskCompletion;
import com.stripcode.mybatis.sf.dao.SFRentalProposalDirectStoreMapper;
import com.stripcode.mybatis.sf.model.SFRentalDetail;
import com.stripcode.mybatis.sf.model.SFRentalProposalDirectStore;
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
@CacheConfig(cacheNames = "sfRenStore")
public class SF30_020Service extends BaseService {
    @Autowired
    private SFRentalProposalDirectStoreMapper sfRentalProposalDirectStoreMapper;
    @Autowired
    private TCsTaskCompletionService tCsTaskCompletionService;
    //租金年份信息
    public List<SFRentalDetail> selectRentalDetailAll(String ppId){
       return sfRentalProposalDirectStoreMapper.selectRentalDetailAll(ppId);
    }
    //查询租金信息
    public SFRentalProposalDirectStore selectRenStoreAll(String ppId){
        SFRentalProposalDirectStore sfRentalProposalDirectStore = sfRentalProposalDirectStoreMapper.selectRenStoreAll(ppId);
        if(sfRentalProposalDirectStore == null){
            sfRentalProposalDirectStore = new SFRentalProposalDirectStore();
            sfRentalProposalDirectStore.setSfRentalDetailList(this.selectRentalDetailAll(ppId));
        }else{
            sfRentalProposalDirectStore.setSfRentalDetailList(this.selectRentalDetailAll(ppId));
        }
        return  sfRentalProposalDirectStore;
    }
    //保存
    @Transactional
    public Map update(SFRentalProposalDirectStore  sFRentalProposalDirectStore,TCsTaskCompletion csTaskCompletion){
        Map modelMap = new HashMap();
        //定义是否成功 用于判断
        boolean result = true;
        //定义后台返回数据
        String message = "保存成功";
        Integer IsExist = 0;
        int count = -1;
        IsExist = sfRentalProposalDirectStoreMapper.isExistsRenStore(sFRentalProposalDirectStore.getPpId(),sFRentalProposalDirectStore.getRowId());
        if(IsExist==0){
            if(StringUtils.isBlank(sFRentalProposalDirectStore.getRowId())){
                sFRentalProposalDirectStore.setRowId(UUIDUtils.generateKey());
                count = sfRentalProposalDirectStoreMapper.insertRenStore(sFRentalProposalDirectStore);
            }
        }else{
            count = sfRentalProposalDirectStoreMapper.updateRenStore(sFRentalProposalDirectStore);
        }
            sfRentalProposalDirectStoreMapper.deleteRentalDetail(sFRentalProposalDirectStore.getRowId());
        for(SFRentalDetail sfRentalDetail :sFRentalProposalDirectStore.getSfRentalDetailList()){
            IsExist = sfRentalProposalDirectStoreMapper.isExistsRentalDetail(sfRentalDetail.getRowId(),sFRentalProposalDirectStore.getRowId());
            if(IsExist==0){
                    sfRentalDetail.setRowId(UUIDUtils.generateKey());
                    sfRentalDetail.setRentId(sFRentalProposalDirectStore.getRowId());
                    count = sfRentalProposalDirectStoreMapper.insertRentalDetail(sfRentalDetail);
            }/*else if(IsExist>0){
                sfRentalDetail.setRentId(sFRentalProposalDirectStore.getRowId());
                count = sfRentalProposalDirectStoreMapper.updateRentalDetail(sfRentalDetail);
            }*/
        }
        /*
         sfRentalDetail.setRentId(sFRentalProposalDirectStore.getRowId());
                sfRentalProposalDirectStoreMapper.deleteRentalDetail(sfRentalDetail.getRentId());
         */
        if(count!=1 ){
            result = false;
            message = "保存失败!";
        }
        csTaskCompletion.setRowId(UUIDUtils.generateKey());
        csTaskCompletion.setCreateTime(null);
        csTaskCompletion.setOptimauthId(sFRentalProposalDirectStore.getPpId());
        tCsTaskCompletionService.upateStatusToFinished(csTaskCompletion);
        tCsTaskCompletionService.updatePipelineType(csTaskCompletion.getTaskId(),sFRentalProposalDirectStore.getPpId());
        modelMap.put("result", result);
        modelMap.put("rowId", sFRentalProposalDirectStore.getRowId());
        modelMap.put("message", message);
        return modelMap;
    }
}
