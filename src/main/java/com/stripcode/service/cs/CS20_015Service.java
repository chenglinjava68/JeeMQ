package com.stripcode.service.cs;

import com.stripcode.core.util.UUIDUtils;
import com.stripcode.mybatis.cs.dao.CSContractinfoMapper;
import com.stripcode.mybatis.cs.dao.CSCustomerInfoMapper;
import com.stripcode.mybatis.cs.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Metro
 */
@Service
@CacheConfig(cacheNames = "CS20_015Service")
public class CS20_015Service {
    @Autowired
    private CSContractinfoMapper csContractinfoMapper;

    @Autowired
    private CSCustomerInfoMapper csCustomerInfoMapper;

    @Autowired
    private TCsTaskCompletionService csTaskCompletionService;

    public CSNewMarketAuz queryErpAndCustomerInfo(String optimauthId){
        CSNewMarketAuz csNewMarketAuz = csContractinfoMapper.selectErpAndCustomerInfo(optimauthId);
        CSCustomerInfo model = csCustomerInfoMapper.selectById(csNewMarketAuz.getCustomerId());
        if(model!=null){
            csNewMarketAuz.setCsCustomerInfo(model);
        }
        return csNewMarketAuz;
    }

    public List<CSContractAttachment> query(String optimauthId){
        List<CSContractAttachment> list = csContractinfoMapper.selectAll(optimauthId);
        return list;
    }

    @Transactional
    public Map insertContractInfo(String optimauthId, TCsTaskCompletion csTaskCompletion){
        Map modelMap = new HashMap();
        Boolean result = true;
        String message = "生成成功!";
        Integer count =-1;
        CSContractApply isContractApply = csContractinfoMapper.isExistContract(optimauthId);
        CSContractAttachment csContractAttachment = new CSContractAttachment();
        if(isContractApply == null){
            CSContractApply model = new CSContractApply();
            String applyId = UUIDUtils.generateKey();
            String rowId = UUIDUtils.generateKey();
            model.setOptimauthId(optimauthId);
            model.setRowId(rowId);
            count = csContractinfoMapper.insertContractInfo(model);
            csContractAttachment.setRowId(rowId);
            csContractAttachment.setContractName("MB特许经营合同（含附件）");
            csContractAttachment.setAttachId("1c928d80e30647c9a1e23d9f6b78e67e");
            csContractAttachment.setTemplateId("1");
            csContractAttachment.setApplyId(applyId);

            count = csContractinfoMapper.insertContractAttachment(csContractAttachment);
            if(count!=1){
                result = false;
                message = "生成失败!";
            }
        }else{
            csContractAttachment.setRowId(isContractApply.getRowId());
            count = csContractinfoMapper.updateContractInfo(isContractApply);
            count = csContractinfoMapper.updateContractAttachment(csContractAttachment);
        }
        csTaskCompletionService.upateStatusToFinished(csTaskCompletion);
        csTaskCompletionService.updateOptimauthType("M0094",optimauthId);
        modelMap.put("result",result);
        modelMap.put("message",message);
        return modelMap;
    }
}
