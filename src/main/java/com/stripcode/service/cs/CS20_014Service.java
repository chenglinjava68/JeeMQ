package com.stripcode.service.cs;

import com.stripcode.mybatis.cs.dao.CSErpInfoMapper;
import com.stripcode.mybatis.cs.dao.TCsTaskCompletionMapper;
import com.stripcode.mybatis.cs.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.stereotype.Service;


import java.util.*;

/**
 * Created by Metro on 2016/8/24.
 */
@Service
@CacheConfig(cacheNames = "CSAddErpBase")
public class CS20_014Service {

    @Autowired
    private CSErpInfoMapper csErpInfoMapper;
    @Autowired
    private TCsTaskCompletionMapper tCsTaskCompletionMapper;
    @Autowired
    private TCsTaskCompletionService tCsTaskCompletionService;
    public Map update (Map<String,Object> params, String userId,TCsTaskCompletion tCsTaskCompletion) throws Exception{
        Map modelMap = new HashMap();
        //定义是否成功 用于判断
        boolean result = true;
        //定义后台返回数据
        String message = "保存成功";
        int count = -1;
        String rowId =  params.get("rowId").toString();
        Date date = new Date();
        //ErpCode
        String erpCode =  params.get("erpCode").toString();
        String [] newStoreCode =null;
        try{
            newStoreCode =  (String []) params.get("newStoreCode");
        }catch(Exception e){
            newStoreCode = new String[1];
            newStoreCode[0] = (String)params.get("newStoreCode");
        }
        String [] ppId =null;
        try{
            ppId =  (String []) params.get("ppId");
        }catch(Exception e){
            ppId = new String[1];
            ppId[0] = (String)params.get("ppId");
        }
        CSNewMarketAuz  csNewMarketAuz = new CSNewMarketAuz();
        csNewMarketAuz.setOptimauthId(rowId);
        csNewMarketAuz.setErpCode(erpCode);
        csNewMarketAuz.setUpdateTime(date);
        csNewMarketAuz.setCreator(userId);
        csNewMarketAuz.setUpdater(userId);
        csNewMarketAuz.setCreateTime(date);
        List<CSCustomerPP> StoreList = new ArrayList<CSCustomerPP>();
        if(newStoreCode==null||newStoreCode.length==0){
            newStoreCode = new String[0];
        }
        for(int i=0;i<newStoreCode.length;i++){
            CSCustomerPP csCustomerPP = new CSCustomerPP();
            csCustomerPP.setNewStoreCode(newStoreCode[i]);
            csCustomerPP.setPpId(ppId[i]);
            csCustomerPP.setCreateTime(date);
            csCustomerPP.setUpdateTime(date);
            csCustomerPP.setUpdater(userId);
            csCustomerPP.setCreator(userId);
            csCustomerPP.setOptimauthId(rowId);
            StoreList.add(csCustomerPP);
        }
                count = csErpInfoMapper.update(csNewMarketAuz);
        for(CSCustomerPP csCustomerPP : StoreList){
                count = csErpInfoMapper.updateStore(csCustomerPP);
            }
        tCsTaskCompletionService.updateOptimauthType("M0093",rowId);
        tCsTaskCompletionService.upateStatusToFinished(tCsTaskCompletion);
        if(count<0 ){
            result = false;
            message = "保存失败!";
        }
            modelMap.put("result", result);
            modelMap.put("message", message);

            return modelMap;

    }
    //查询店铺名称
    public List<CSErpInfo> selectStore(String customerId,String rowId){
        return csErpInfoMapper.selectStore(customerId, rowId);
    }
    //查询erp名称
    public CSMarketOptimauth selectErp(String rowId){
        return  csErpInfoMapper.selectErp(rowId);
    }

    public boolean IsExistErpCode(String erpCode,String rowId){
        Integer isExists1= csErpInfoMapper.IsExistErpCode(erpCode,null);
        Integer isExists= csErpInfoMapper.IsExistErpCode(erpCode,rowId);
        if(isExists1==1&&isExists==1){
                return true;
        }
        if (isExists1 > 0) {
            return false;
        }
        return true;
    }

}
