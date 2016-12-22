package com.stripcode.service.sf;

import com.stripcode.core.util.UUIDUtils;
import com.stripcode.mybatis.cs.model.CSSfPipeline;
import com.stripcode.mybatis.cs.model.TCsTaskCompletion;
import com.stripcode.mybatis.sf.dao.*;
import com.stripcode.mybatis.sf.model.*;
import com.stripcode.service.cs.TCsTaskCompletionService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Metro
 */
@Service
@CacheConfig(cacheNames = "SF30_032Service")
public class SF30_032Service {
    @Autowired
    private SFSfPipelineMapper sfSfPipelineMapper;
    @Autowired
    private SFProgressEstMapper sfProgressEstMapper;
    @Autowired
    private SFLandlordInfoMapper sfLandlordInfoMapper;
    @Autowired
    private SFRentalProposalDirectStoreMapper sfRentalProposalDirectStoreMapper;
    @Autowired
    private SFSiteInfoMapper sfSiteInfoMapper;

    @Autowired
    private SFSigningAttachmentMapper sfSigningAttachmentMapper;

    @Autowired
    private TCsTaskCompletionService tCsTaskCompletionService;

    @Autowired
    private SF30_059Service sf30_059Service;

    public SFProgressEst queryInfo(String ppId){
        String floor = "";
        Integer index = 1;
        SFProgressEst model = new SFProgressEst();
        CSSfPipeline csSfPipeline = sfSfPipelineMapper.queryStoreInfo(ppId);
        List<SFProgressEst> progressEstList = sfProgressEstMapper.selectProgressAll(ppId);
        SFRentalProposalDirectStore directStore = sfRentalProposalDirectStoreMapper.selectRenStoreAll(ppId);
        SFEstateSource sfEstateSource = sfLandlordInfoMapper.selectEstateSourceInfo(ppId);
        List<SFFloorInfo> sfFloorInfoList  = sfSiteInfoMapper.queryFloorInfoDetail(ppId);
        List<SFSigningAttachment> signingAttachmentList = sfSigningAttachmentMapper.querySigningAttachment(ppId);
        SFApplyPipelineCode applyPipelineCode = sf30_059Service.selectApplyPipelineCode(ppId);


        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        try {
            for (SFSigningAttachment item:signingAttachmentList) {
                if(StringUtils.isNotBlank(item.getCreaterTime())){
                    item.setCreaterTime(format.format(format.parse(item.getCreaterTime())));
                }
            }
        }catch (Exception e){

        }
        model.setSigningAttachmentList(signingAttachmentList);
        model.setRegion(csSfPipeline.getRegion());
        model.setMarket(csSfPipeline.getErpName());
        model.setProvince(csSfPipeline.getProvince());
        model.setCity(csSfPipeline.getCity());
        model.setCnSitename(csSfPipeline.getCnSiteName());
        model.setEnSitename(csSfPipeline.getEnSiteName());
        model.setAddressCn(csSfPipeline.getAddressCn());
        model.setAddressDetail(csSfPipeline.getAddressDetail());
        model.setPpCode(applyPipelineCode.getPpCode());
        for (SFProgressEst item:progressEstList){
            if("M0328".equals(item.getTaskCode())){
                model.setSignDate(item.getActualDate());
            }
            if("M0330".equals(item.getTaskCode())){
                model.setConsSurveyReportDate(item.getActualDate());
            }
            if("M0331".equals(item.getTaskCode())){
                model.setOpenDate(item.getActualDate());
            }
        }

        model.setOwnerDate(directStore.getDeliveryDate());
        model.setRep(sfEstateSource.getRep());

        if(sfFloorInfoList!=null){
            for (SFFloorInfo item:sfFloorInfoList){
                if(StringUtils.isBlank(item.getFloor())){
                    continue;
                }
                floor+=item.getFloor();
                if(sfFloorInfoList.size()!=index){
                    floor+=",";
                }
                index++;
            }
        }
        model.setFloor(floor);
        return model;
    }

    public Map<String,Object> update(SFProgressEst model, TCsTaskCompletion csTaskCompletion){
        Map<String,Object> map = new HashMap<String,Object>();
        Boolean result = true;
        String message = "保存成功!";
        Integer count = -1;

        count = sfProgressEstMapper.updateProgressEstToSignDate(model);

        for (SFSigningAttachment item:model.getSigningAttachmentList()){
            if(StringUtils.isNotBlank(item.getAttachId())){
                if(StringUtils.isBlank(item.getRowId())){
                    item.setRowId(UUIDUtils.generateKey());
                    count = sfSigningAttachmentMapper.insertSigningAttachment(item);
                }else {
                    count = sfSigningAttachmentMapper.updateSigningAttachment(item);
                }
            }
        }
        if(count==0){
            result = false;
            message="保存失败!";
        }
        csTaskCompletion.setRowId(UUIDUtils.generateKey());
        csTaskCompletion.setCreateTime(null);
        csTaskCompletion.setOptimauthId(model.getPpId());
        tCsTaskCompletionService.upateStatusToFinished(csTaskCompletion);
        tCsTaskCompletionService.updatePipelineType(csTaskCompletion.getTaskId(),csTaskCompletion.getOptimauthId());
        map.put("result",result);
        map.put("message",message);
        return map;
    }
}
