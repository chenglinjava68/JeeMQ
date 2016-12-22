package com.stripcode.service.sf;

import com.stripcode.core.util.UUIDUtils;
import com.stripcode.mybatis.cs.model.TCsTaskCompletion;
import com.stripcode.mybatis.sf.dao.SFRentalProposalCopartnerStoreMapper;
import com.stripcode.mybatis.sf.dao.SFRentalProposalMapper;
import com.stripcode.mybatis.sf.model.SFRentalProposalAttachment;
import com.stripcode.mybatis.sf.model.SFRentalProposalCopartnerStore;
import com.stripcode.service.BaseService;
import com.stripcode.service.cs.TCsTaskCompletionService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Metro on 2016/9/29.
 */
@Service
@CacheConfig(cacheNames = "sfRentalProposalStore")
public class SF30_075Service extends BaseService {
    @Autowired
    private SFRentalProposalMapper sfRentalProposalMapper;
    @Autowired
    private SFRentalProposalCopartnerStoreMapper sfRentalProposalCopartnerStoreMapper;
    @Autowired
    private TCsTaskCompletionService tCsTaskCompletionService;
    /**
     * 查询提案信息
     * @param ppId 意向店Id
     * @return 合伙租金提案具体信息
     */
    public SFRentalProposalCopartnerStore selectProposal(String ppId){
            return sfRentalProposalCopartnerStoreMapper.selectCopartnerStore(ppId);
    }
    /**
     * 查询附件列表
     * @return
     */
    public List<SFRentalProposalAttachment> selectAttachment(String ppId){
        List<SFRentalProposalAttachment> sfRentalProposalAttachmentList= sfRentalProposalCopartnerStoreMapper.selectProposalAttachment(ppId);
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;
        for (SFRentalProposalAttachment model : sfRentalProposalAttachmentList){
            try {
                date = format.parse(model.getCreaterTime());
                model.setCreaterTime(format.format(date));
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return  sfRentalProposalAttachmentList;
    }

    /**
     * 保存
     * @param sfRentalProposalAttachment 附件列表实体
     * @param sfRentalProposalCopartnerStore 租金提案实体
     * @return
     */
    public Map save(SFRentalProposalAttachment sfRentalProposalAttachment,SFRentalProposalCopartnerStore sfRentalProposalCopartnerStore,TCsTaskCompletion csTaskCompletion){
        Map modelMap = new HashMap();
        //定义是否成功 用于判断
        boolean result = true;
        //定义后台返回数据
        String message = "保存成功";
        Integer IsExist = 0;
        int count = -1;
        IsExist = sfRentalProposalCopartnerStoreMapper.isExistsCopartnerStore(sfRentalProposalCopartnerStore.getRowId(),sfRentalProposalCopartnerStore.getPpId());
        if(IsExist==0){
            if(StringUtils.isBlank(sfRentalProposalCopartnerStore.getRowId())){
                sfRentalProposalCopartnerStore.setRowId(UUIDUtils.generateKey());
                count =sfRentalProposalCopartnerStoreMapper.insertCopartnerStore(sfRentalProposalCopartnerStore);
            }
        }else{
            count = sfRentalProposalCopartnerStoreMapper.updateCopartnerStore(sfRentalProposalCopartnerStore);
        }
        IsExist = sfRentalProposalMapper.isExistsAttachment(sfRentalProposalCopartnerStore.getRowId(),sfRentalProposalAttachment.getTemplateId());
        if(IsExist==0){
            sfRentalProposalAttachment.setArowId(UUIDUtils.generateKey());
            sfRentalProposalAttachment.setRentId(sfRentalProposalCopartnerStore.getRowId());
            count = sfRentalProposalMapper.insertAttachment(sfRentalProposalAttachment);
        }else{
            sfRentalProposalAttachment.setRentId(sfRentalProposalCopartnerStore.getRowId());
            count = sfRentalProposalMapper.updateAttachment(sfRentalProposalAttachment);
        }
        if(count!=1 ){
            result = false;
            message = "保存失败!";
        }
        csTaskCompletion.setRowId(UUIDUtils.generateKey());
        csTaskCompletion.setCreateTime(null);
        csTaskCompletion.setOptimauthId(sfRentalProposalCopartnerStore.getPpId());
        tCsTaskCompletionService.upateStatusToFinished(csTaskCompletion);
        tCsTaskCompletionService.updatePipelineType(csTaskCompletion.getTaskId(),sfRentalProposalCopartnerStore.getPpId());
        modelMap.put("rowId",sfRentalProposalCopartnerStore.getRowId());
        modelMap.put("AttachmentRowId",sfRentalProposalAttachment.getArowId());
        modelMap.put("result", result);
        modelMap.put("message", message);
        return modelMap;
    }
}
