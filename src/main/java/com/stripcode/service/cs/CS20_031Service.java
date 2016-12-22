package com.stripcode.service.cs;

import com.stripcode.core.util.UUIDUtils;
import com.stripcode.mybatis.cs.dao.CSContractSigningMapper;
import com.stripcode.mybatis.cs.model.CSContractSigning;
import com.stripcode.mybatis.cs.model.CSCustomerErpInfo;
import com.stripcode.mybatis.cs.model.CSSigningAttachment;
import com.stripcode.mybatis.cs.model.TCsTaskCompletion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Metro
 */
@Service
@CacheConfig(cacheNames = "CS20_031Service")
public class CS20_031Service {
    @Autowired
    private CSContractSigningMapper csContractSigningMapper;

    @Autowired
    private TCsTaskCompletionService tCsTaskCompletionService;

    @Autowired
    private CS20_030Service cs20_030Service;

    public CSCustomerErpInfo querySignInfo(String customerId, String optimauthId) {
        CSCustomerErpInfo csCustomerErpInfo = cs20_030Service.queryContractInfo(customerId, optimauthId);
        csCustomerErpInfo.setSign(csContractSigningMapper.signingByOptimauthId(optimauthId));
        return csCustomerErpInfo;
    }
    public Map<String,Object> save(CSContractSigning model, TCsTaskCompletion tCsTaskCompletion){
        Map<String,Object> map = new HashMap<String,Object>();
        Boolean result = true;
        String message = "保存成功!";
        Integer count = -1;
        String rowId = model.getRowId();
        CSSigningAttachment csSigningAttachment = new CSSigningAttachment();
        Integer isExist = csContractSigningMapper.isExist(model.getOptimauthId());
        if(isExist==0){
            rowId = UUIDUtils.generateKey();
            model.setRowId(rowId);
            csSigningAttachment.setSigningId(rowId);
            csSigningAttachment.setRowId(rowId);
            csSigningAttachment.setTemplateId("2");
            csSigningAttachment.setAttachId("1c928d80e30647c9a1e23d9f6b78e67e");
            csSigningAttachment.setContractName("MB特许经营合同（含附件）签字");
            count = csContractSigningMapper.insertSigning(model);
            csContractSigningMapper.insertSignContract(csSigningAttachment);
            map.put("rowId",rowId);
        }else {
            csSigningAttachment.setSigningId(rowId);
            count = csContractSigningMapper.updateSigning(model);
            csContractSigningMapper.updateSignContract(csSigningAttachment);
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
}
