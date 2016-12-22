package com.stripcode.service.cs;

import com.stripcode.core.util.UUIDUtils;
import com.stripcode.mybatis.cs.dao.*;
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
 * Created by Metro on 2016/12/15.
 */
@Service
@CacheConfig(cacheNames="CS20_032")
public class CS20_032Service {
    @Autowired
    private CSRenewMarketauzMapper csRenewMarketauzMapper;
    @Autowired
    private TCsTaskCompletionService tCsTaskCompletionService;
    @Autowired
    private CSContractinfoMapper csContractinfoMapper;
    @Autowired
    private CSRenewalContractinfoMapper csRenewalContractinfoMapper;
    @Autowired
    private CSContractSigningMapper csContractSigningMapper;
    @Autowired
    private CSAuthorizationMapper csAuthorizationMapper;
    @Transactional
    public Map<String,Object> update(RenewMarketauz model, TCsTaskCompletion tCsTaskCompletion){
        Map<String,Object> map = new HashMap<String,Object>();
        Boolean result = true;
        String message = "续约完成!";
        Integer count = -1;
        RenewMarketauz renewMarketauz = csRenewMarketauzMapper.selectRenewMarketauzById(model.getRowId());
        if(StringUtils.isNotBlank(model.getRowId())) {
            CSCustomerErpInfo csCustomerErpInfo = new CSCustomerErpInfo();
            csCustomerErpInfo.setAccreditEndDate(renewMarketauz.getEndDate());
            csCustomerErpInfo.setErpCode(renewMarketauz.getErpCode());
            csCustomerErpInfo.setCustomerId(renewMarketauz.getCustomerId());
            count = csRenewMarketauzMapper.updateRenewErpCustomer(csCustomerErpInfo);
        }
        CSCustomerErpInfo csCustomerErpInfo=csRenewMarketauzMapper.selectByReNewInfo(renewMarketauz.getCustomerId(),renewMarketauz.getErpCode());
        CSContractSigning csContractSigning = csContractSigningMapper.signingByOptimauthId(model.getRowId());
        List<CSContractAttachment> itemList = csRenewalContractinfoMapper.selectAttachment(model.getRowId());
        for(CSContractAttachment csContractAttachment:itemList){
            CSMarketContract csMarketContract = new CSMarketContract();
            csMarketContract.setRowId(UUIDUtils.generateKey());
            csMarketContract.setAuthorizationId(csCustomerErpInfo.getRowId());
            csMarketContract.setAttachId(csContractAttachment.getAttachId());
            csMarketContract.setContractName(csContractAttachment.getContractName());
            csMarketContract.setSignDate(csContractSigning.getActualSignDate());
            csMarketContract.setContractType("M0059");
            count =  csAuthorizationMapper.insetMarketContract(csMarketContract);
        }
        if(count ==0){
            result = false;
            message = "续约失败!";
        }
        tCsTaskCompletion.setOptimauthId(model.getRowId());
        tCsTaskCompletionService.upateStatusToFinished(tCsTaskCompletion);
        map.put("result",result);
        map.put("message",message);
        return map;
    }
}
