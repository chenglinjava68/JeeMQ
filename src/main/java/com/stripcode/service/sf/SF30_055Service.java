package com.stripcode.service.sf;

import com.stripcode.core.util.UUIDUtils;
import com.stripcode.mybatis.cs.model.TCsTaskCompletion;
import com.stripcode.mybatis.sf.dao.SFRentalProposalMapper;
import com.stripcode.mybatis.sf.model.SFRentalProposal;
import com.stripcode.mybatis.sf.model.SFRentalProposalAttachment;
import com.stripcode.service.BaseService;
import com.stripcode.service.cs.TCsTaskCompletionService;
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
@CacheConfig(cacheNames = "sfRentalProposal")
public class SF30_055Service extends BaseService {
    @Autowired
    private SFRentalProposalMapper sfRentalProposalMapper;
    @Autowired
    private TCsTaskCompletionService tCsTaskCompletionService;
    /**
     * 查询提案和客户信息
     * @param ppId 意向店Id
     * @return 租金提案具体信息
     */
    public SFRentalProposal selectProposal(String ppId){
            return sfRentalProposalMapper.selectProposal(ppId);
    }
    /**
     * 查询附件列表
     * @return
     */
    public List<SFRentalProposalAttachment> selectAttachment(String ppId){
        List<SFRentalProposalAttachment> sfRentalProposalAttachmentList =sfRentalProposalMapper.selectAttachment(ppId);
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;
        for (SFRentalProposalAttachment model : sfRentalProposalAttachmentList){
            try {
                if(model.getCreaterTime()!=null){
                    date = format.parse(model.getCreaterTime());
                    model.setCreaterTime(format.format(date));
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return  sfRentalProposalAttachmentList;
    }
    /**
     * 保存
     * @param sfRentalProposalAttachment 附件列表实体
     * @param sfRentalProposal 租金提案实体
     * @return
     */
    public Map save(SFRentalProposalAttachment sfRentalProposalAttachment,SFRentalProposal sfRentalProposal,TCsTaskCompletion csTaskCompletion){
        Map modelMap = new HashMap();
        //定义是否成功 用于判断
        boolean result = true;
        //定义后台返回数据
        String message = "保存成功";
        Integer IsExist = 0;
        int count = -1;

        IsExist = sfRentalProposalMapper.isExistsRentalProposal(sfRentalProposal.getRowId(),sfRentalProposal.getPpId());
        if(IsExist==0){
            sfRentalProposal.setRowId(UUIDUtils.generateKey());
            count =sfRentalProposalMapper.insertRentalProposal(sfRentalProposal);
        }else{
            count = sfRentalProposalMapper.updateRentalProposal(sfRentalProposal);
        }
        IsExist = sfRentalProposalMapper.isExistsAttachment(sfRentalProposal.getRowId(),sfRentalProposalAttachment.getTemplateId());
        if(IsExist==0){
            sfRentalProposalAttachment.setArowId(UUIDUtils.generateKey());
            sfRentalProposalAttachment.setRentId(sfRentalProposal.getRowId());
            count = sfRentalProposalMapper.insertAttachment(sfRentalProposalAttachment);
        }else{
            sfRentalProposalAttachment.setRentId(sfRentalProposal.getRowId());
            count = sfRentalProposalMapper.updateAttachment(sfRentalProposalAttachment);
        }
        if(count!=1 ){
            result = false;
            message = "保存失败!";
        }
        csTaskCompletion.setRowId(UUIDUtils.generateKey());
        csTaskCompletion.setCreateTime(null);
        csTaskCompletion.setOptimauthId(sfRentalProposal.getPpId());
        tCsTaskCompletionService.upateStatusToFinished(csTaskCompletion);
        tCsTaskCompletionService.updatePipelineType(csTaskCompletion.getTaskId(),sfRentalProposal.getPpId());
        modelMap.put("rowId",sfRentalProposal.getRowId());
        modelMap.put("AttachmentRowId",sfRentalProposalAttachment.getArowId());
        modelMap.put("result", result);
        modelMap.put("message", message);
        return modelMap;
    }
}
