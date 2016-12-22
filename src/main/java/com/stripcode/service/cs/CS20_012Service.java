package com.stripcode.service.cs;

import com.stripcode.core.util.UUIDUtils;
import com.stripcode.mybatis.cs.dao.CSNewBusinessFlanMapper;
import com.stripcode.mybatis.cs.dao.CSStoreSalesLastYearMapper;
import com.stripcode.mybatis.cs.model.*;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * @author Metro
 */
@Service
@CacheConfig(cacheNames="CS20_012")
public class CS20_012Service {
    @Autowired
    private CSStoreSalesLastYearMapper csStoreSalesLastYearMapper;

    @Autowired
    private TCsTaskCompletionService tCsTaskCompletionService;

    @Autowired
    private CSNewBusinessFlanMapper csNewBusinessFlanMapper;


    public List<CSBusinessFlan> queryBusinessFlanByOptimauthId(String optimauthId){
        List<CSBusinessFlan> list = csStoreSalesLastYearMapper.selectBusinessFlanByOptimauthId(optimauthId);
        return list;
    }

    public List<CSStoreSalesLastYear> queryStoreSalesLastYear(String optimauthId){
        return csStoreSalesLastYearMapper.queryStoreSalesLastYear(optimauthId);
    }

    public Map update(Map<String,Object> updateMap,RenewMarketauz model,TCsTaskCompletion tCsTaskCompletion){
        Map<String,Object> map = new HashMap<String, Object>();
        Boolean result = true;
        String message = "保存成功!";
        Integer count = -1;
        String[] rowId = (String[])updateMap.get("rowId");
        String[] planClass = (String[]) updateMap.get("planClass");
        String[] storeCode = (String[])updateMap.get("storeCode");
        String[] ppId = (String[]) updateMap.get("ppId");
        String[] openDate = (String[])updateMap.get("openDate");
        String[] storeAddress = (String[])updateMap.get("storeAddres");
        String[] channelType = (String[])updateMap.get("channelType");
        String[] operatingArea = (String[])updateMap.get("operatingArea");
        String[] cnSiteName = (String[])updateMap.get("cnSiteName");
        String[] salesY1 = (String[])updateMap.get("salesY1");
        String[] salesY2 = (String[])updateMap.get("salesY2");
        String[] salesY3 = (String[])updateMap.get("salesY3");
        String[] salesY1Incrate = (String[])updateMap.get("salesY1Incrate");
        String[] salesY2Incrate = (String[])updateMap.get("salesY2Incrate");
        String[] salesY3Incrate = (String[])updateMap.get("salesY3Incrate");
        String[] optimauthId = (String[]) updateMap.get("optimauthId");
        String optimauthIds = updateMap.get("optimauthIds").toString();
        for (int i = 0;i<planClass.length;i++){
            CSBusinessFlan bf = new CSBusinessFlan();
            bf.setRowId(rowId[i]);
            bf.setOptimauthId(optimauthId[i]);
            bf.setPlanClass(planClass[i]);
            bf.setPpId(ppId[i]);
            bf.setOpenDate(openDate[i]);
            bf.setStoreAddres(storeAddress[i]);
            bf.setStoreCode(storeCode[i]);
            bf.setChannelType(channelType[i]);
            if(StringUtils.isNotBlank(operatingArea[i])){
                bf.setOperatingArea(Double.parseDouble(operatingArea[i]));
            }
            bf.setCnSiteName(cnSiteName[i]);
            if(salesY1[i]!=""){
                bf.setSalesY1(Double.parseDouble(salesY1[i]));
            }
            if(salesY2[i]!=""){
                bf.setSalesY2(Double.parseDouble(salesY2[i]));
            }
            if(salesY3[i]!=""){
                bf.setSalesY3(Double.parseDouble(salesY3[i]));
            }
            if(salesY1Incrate[i]!=""){
                bf.setSalesY1Incrate(Double.parseDouble(salesY1Incrate[i]));
            }
            if(salesY2Incrate[i]!=""){
                bf.setSalesY2Incrate(Double.parseDouble(salesY2Incrate[i]));
            }
            if(salesY3Incrate[i]!=""){
                bf.setSalesY3Incrate(Double.parseDouble(salesY3Incrate[i]));
            }
            String rowIdStr = bf.getRowId();
            Integer isExist = csNewBusinessFlanMapper.isExists(rowIdStr);
            if(isExist==0){
                if(StringUtils.isEmpty(rowIdStr)){
                    rowIdStr = UUIDUtils.generateKey();
                    bf.setRowId(rowIdStr);
                }
                //把新增的rowId 放到数组  防止删除时误删
                rowId[i] =rowIdStr;
                count = csNewBusinessFlanMapper.insertBusinessFlan(bf);
            }else {
                count = csNewBusinessFlanMapper.updateBusinessFlan(bf);
            }
            //执行删除操作
        }
        csNewBusinessFlanMapper.updateBusinessDelFlag(rowId,optimauthId[0]);
        if(model.getStoreSalesList()!=null){
            for (CSStoreSalesLastYear item:model.getStoreSalesList()){
                if(StringUtils.isBlank(item.getRowId())){
                    item.setRowId(UUIDUtils.generateKey());
                    item.setOptimauthId(optimauthId[0]);
                    count = csStoreSalesLastYearMapper.insertStoreSales(item);
                }else {
                    count = csStoreSalesLastYearMapper.updateStoreSales(item);
                }
            }
        }

        if(count==0){
            result = false;
            message= "保存失败!";
        }

        tCsTaskCompletion.setRowId(UUIDUtils.generateKey());
        tCsTaskCompletion.setCreateTime(null);
        tCsTaskCompletion.setOptimauthId(optimauthIds);
        tCsTaskCompletionService.upateStatusToFinished(tCsTaskCompletion);
        map.put("result",result);
        map.put("message",message);
        return map;
    }
}
