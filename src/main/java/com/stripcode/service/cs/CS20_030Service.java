package com.stripcode.service.cs;

import com.stripcode.core.util.UUIDUtils;
import com.stripcode.mybatis.cs.dao.CSContractinfoMapper;
import com.stripcode.mybatis.cs.dao.CSRenewalContractinfoMapper;
import com.stripcode.mybatis.cs.model.*;
import org.apache.commons.lang3.StringUtils;
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
@CacheConfig(cacheNames = "CS20_030Service")
public class CS20_030Service {
    @Autowired
    private CSRenewalContractinfoMapper csRenewalContractinfoMapper;
    @Autowired
    private CSContractinfoMapper csContractinfoMapper;
    @Autowired
    private TCsTaskCompletionService tCsTaskCompletionService;
    @Autowired
    private CS20_029Service cs20_029Service;

    public CSCustomerErpInfo queryContractInfo(String customerId,String optimauthId){
        CSCustomerErpInfo csCustomerErpInfo = cs20_029Service.queryByReNewInfo(customerId,optimauthId);
        csCustomerErpInfo.setContractinfo(csRenewalContractinfoMapper.queryContractInfo(optimauthId));
        return csCustomerErpInfo;
    }

    @Transactional
    public Map update(CSRenewalContractinfo model, TCsTaskCompletion tCsTaskCompletion){
        Map<String,Object> map = new HashMap<String,Object>();
        Boolean result = true;
        String message = "保存成功!";
        Integer count = -1;

        if(StringUtils.isBlank(model.getRowId())){
            CSContractAttachment csContractAttachment = new CSContractAttachment();
            csContractAttachment.setRowId(UUIDUtils.generateKey());
            csContractAttachment.setContractName("MB特许经营合同（含附件）");
            csContractAttachment.setAttachId("1c928d80e30647c9a1e23d9f6b78e67e");
            csContractAttachment.setTemplateId("1");
            model.setRowId(UUIDUtils.generateKey());
            csContractAttachment.setApplyId(model.getRowId());
            count = csRenewalContractinfoMapper.insertContractInfo(model);
            count = csContractinfoMapper.insertContractAttachment(csContractAttachment);
            map.put("rowId",model.getRowId());
        }else {
            count = csRenewalContractinfoMapper.updateContractInfo(model);
        }

        if(count ==0){
            result = false;
            message = "保存失败!";
        }

        tCsTaskCompletionService.upateStatusToFinished(tCsTaskCompletion);
        map.put("result",result);
        map.put("message",message);
        return map;
    }

    public List<CSContractAttachment> selectAttachment(String optimauthId){
        return csRenewalContractinfoMapper.selectAttachment(optimauthId);
    }
}
