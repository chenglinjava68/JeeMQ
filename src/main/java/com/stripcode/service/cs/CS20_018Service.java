package com.stripcode.service.cs;

import com.stripcode.core.util.UUIDUtils;
import com.stripcode.mybatis.cp.model.CpMarketInfo;
import com.stripcode.mybatis.cs.dao.*;
import com.stripcode.mybatis.cs.model.*;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.*;

/**
 * @author Metro
 */
@Service
@CacheConfig(cacheNames = "CS20_018Service")
public class CS20_018Service {
    @Autowired
    private TCsTaskCompletionService tCsTaskCompletionService;

    @Autowired
    private CSAuthorizationMapper csAuthorizationMapper;

    @Autowired
    private CSContractSigningMapper csContractSigningMapper;

    @Autowired
    private CS20_006Service cs20_006Service;

    @Transactional
    public Map insertCustomerErpInfo(String optimauthId,String customerId,TCsTaskCompletion csTaskCompletion){
        Map modelMap = new HashMap();
        Boolean result = true;
        String message = "授权完成!";
        Integer count = -1;
        CSNewMarketAuz csNewMarketAuz = csAuthorizationMapper.authorInfoById(customerId,optimauthId);
        String newMarketAuzRowId = csNewMarketAuz.getRowId();
        Integer isCustomerErpInfo = csAuthorizationMapper.isExistCustomerErpInfo(csNewMarketAuz.getRowId());
        String isExistRowId = csAuthorizationMapper.queryCustomerErpInfoExist(customerId,csNewMarketAuz.getErpCode());
        CSContractSigning contractSigning = csContractSigningMapper.signingByOptimauthId(optimauthId);
        List<CSMarketDiscountSplit> discountSplitList = csAuthorizationMapper.selectDiscountSplit(csNewMarketAuz.getRowId());
        CSCustomerErpInfo csCustomerErpInfo = new CSCustomerErpInfo();
        if(StringUtils.isNotBlank(isExistRowId)){
            csNewMarketAuz.setRowId(isExistRowId);
        }else {
            if(isCustomerErpInfo==0){
                csCustomerErpInfo.setRowId(csNewMarketAuz.getRowId());
                csCustomerErpInfo.setCustomerId(customerId);
                csCustomerErpInfo.setErpCode(csNewMarketAuz.getErpCode());
                csCustomerErpInfo.setErpName(csNewMarketAuz.getErpName());
                csCustomerErpInfo.setBrand(csNewMarketAuz.getBrand());
                csCustomerErpInfo.setCooperationMode(csNewMarketAuz.getCooperationMode());
                csCustomerErpInfo.setBasicDiscountRate(csNewMarketAuz.getDiscountRate());
                csCustomerErpInfo.setAccreditStartDate(csNewMarketAuz.getAccreditStartDate());
                csCustomerErpInfo.setAccreditEndDate(csNewMarketAuz.getAccreditEndDate());
                csCustomerErpInfo.setSplitRate(csNewMarketAuz.getSplitRate());
                csCustomerErpInfo.setDeposit(csNewMarketAuz.getDeposit());
                csCustomerErpInfo.setPledge(csNewMarketAuz.getPledge());
                csCustomerErpInfo.setGoodsPledge(csNewMarketAuz.getGoodsPledge());
                csCustomerErpInfo.setInitialFee(csNewMarketAuz.getInitialFee());
                csCustomerErpInfo.setIsBuyout(csNewMarketAuz.getIsBuyout());
                csCustomerErpInfo.setMarketLev(csNewMarketAuz.getMarketLev());
                csCustomerErpInfo.setUserId(csNewMarketAuz.getUserId());
                csCustomerErpInfo.setRemark(csNewMarketAuz.getRemark());
                csCustomerErpInfo.setSignDate(contractSigning.getActualSignDate());
                csCustomerErpInfo.setDiscountRateMode(csNewMarketAuz.getDiscountRateMode());
                count = csAuthorizationMapper.insertCustomerErpInfo(csCustomerErpInfo);
            }else {
                count = csAuthorizationMapper.updateCustomerErpInfo(csCustomerErpInfo);
            }
        }

        List<CSMarketInfo> MarketInfos = csAuthorizationMapper.marketInfo(newMarketAuzRowId);
        if(MarketInfos.size()!=0){
            for (CSMarketInfo item:MarketInfos){
                item.setRowId(UUIDUtils.generateKey());
                item.setAuthorizationId(csNewMarketAuz.getRowId());
                item.setAccreditStartDate(csNewMarketAuz.getAccreditStartDate());
                item.setAccreditEndDate(csNewMarketAuz.getAccreditEndDate());
                count = csAuthorizationMapper.insertMarketInfo(item);
            }
        }
        List<CSContractSigning> csContractSignings = csContractSigningMapper.signingByTemplateId(optimauthId);
        CSContractSigning csContractSigning = csContractSigningMapper.signingByOptimauthId(optimauthId);
        String contractRowId = UUIDUtils.generateKey();
        for (CSContractSigning item:csContractSignings) {
            CSMarketContract model = new CSMarketContract();
            model.setRowId(contractRowId);
            model.setAttachId(item.getAttachId());
            model.setContractName(item.getContractName());
            model.setAuthorizationId(csNewMarketAuz.getRowId());
            model.setSignDate(csContractSigning.getActualSignDate());
            count =  csAuthorizationMapper.insetMarketContract(model);
        }

        if(discountSplitList.size()!=0){
            for (CSMarketDiscountSplit item :discountSplitList ){
                CSMarketCustomerDiscountSplit model = new CSMarketCustomerDiscountSplit();
                model.setRowId(UUIDUtils.generateKey());
                model.setAuthorizationId(csNewMarketAuz.getRowId());
                model.setDiscountRate(item.getDiscountRate());
                model.setSplitRate(item.getSplitRate());
                model.setStyle(item.getStyle());
                count = csAuthorizationMapper.insertCustomerDiscountSplit(model);
            }
        }
        if(count!=1){
            result = false;
            message = "授权失败!";
        }else{
            tCsTaskCompletionService.updateOptimauthType("M0096",optimauthId);
            tCsTaskCompletionService.upateStatusToFinished(csTaskCompletion);
        }

        //任务完成
        modelMap.put("result",result);
        modelMap.put("message",message);
        return modelMap;
    }

    public List<CpMarketInfo> selectListMarket(String rowId){
        return csAuthorizationMapper.selectListMarket(rowId);
    }
}
