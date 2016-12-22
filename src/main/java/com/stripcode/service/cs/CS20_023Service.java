package com.stripcode.service.cs;

import com.stripcode.core.util.UUIDUtils;
import com.stripcode.mybatis.cs.dao.CSCustomerInfoMapper;
import com.stripcode.mybatis.cs.dao.CSNewBusinessFlanMapper;
import com.stripcode.mybatis.cs.model.CSBusinessFlan;
import com.stripcode.mybatis.cs.model.CSCustomerInfo;
import com.stripcode.mybatis.cs.model.CSPlanInvestment;
import com.stripcode.mybatis.cs.model.TCsTaskCompletion;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Metro
 */
@Service
@CacheConfig(cacheNames="CS20_023")
public class CS20_023Service {
    @Autowired
    private CSNewBusinessFlanMapper csNewBusinessPlanMapper;

    @Autowired
    private TCsTaskCompletionService tCsTaskCompletionService;

    @Autowired
    private CSCustomerInfoMapper csCustomerInfoMapper;

    public List<CSBusinessFlan> queryBusinessFlanByOptimauthId(String optimauthId){
        List<CSBusinessFlan> list = csNewBusinessPlanMapper.selectBusinessFlanByOptimauthId(optimauthId);
        return list;
    }

    public CSCustomerInfo queryById(String customerId,String optimauthId){
        CSCustomerInfo csCustomerInfo = csCustomerInfoMapper.selectById(customerId);
        CSPlanInvestment csPlanInvestment = csNewBusinessPlanMapper.selectPlanInvestByOptimauthId(optimauthId);
        if (csPlanInvestment!=null){
            csCustomerInfo.setPlanInvestId(csPlanInvestment.getRowId());
            csCustomerInfo.setInvestFunds(csPlanInvestment.getInvestFunds());
            csCustomerInfo.setCostBack(csPlanInvestment.getCostBack());
            csCustomerInfo.setOtherBrand(csPlanInvestment.getOtherBrand());
            csCustomerInfo.setMbMaxAchSales(csPlanInvestment.getMbMaxAchSales());
            csCustomerInfo.setMktVolumeSales(csPlanInvestment.getMktVolumeSales());
            csCustomerInfo.setCustomerFunds(csPlanInvestment.getCustomerFunds());
        }
        return csCustomerInfo;
    }

    @Transactional
    public Map updateBusinessFlan(Map<String,Object> map,TCsTaskCompletion csTaskCompletion){
        Map modelMap = new HashMap();
        Boolean result = true;
        String message = "保存成功!";
        Date date = new Date();
        Integer count = -1;

        //获取map里的数据
        String[] rowId = (String[])map.get("rowId");
        String[] planClass = (String[]) map.get("planClass");
        String[] storeCode = (String[])map.get("storeCode");
        String[] ppId = (String[]) map.get("ppId");
        String[] openDate = (String[])map.get("openDate");
        String[] storeAddress = (String[])map.get("storeAddres");
        String[] channelType = (String[])map.get("channelType");
        System.out.println(channelType);
        String[] operatingArea = (String[])map.get("operatingArea");
        String[] cnSiteName = (String[])map.get("cnSiteName");
        String[] salesY1 = (String[])map.get("salesY1");
        String[] salesY2 = (String[])map.get("salesY2");
        String[] salesY3 = (String[])map.get("salesY3");
        String[] salesY1Incrate = (String[])map.get("salesY1Incrate");
        String[] salesY2Incrate = (String[])map.get("salesY2Incrate");
        String[] salesY3Incrate = (String[])map.get("salesY3Incrate");
        String optimauthId = map.get("optimauthId").toString();
        String taskId = map.get("taskId").toString();

        //获取CSPlanInvestment对象属性
        CSPlanInvestment csPlanInvestment = new CSPlanInvestment();
        Double investFunds = Double.parseDouble(map.get("investFunds").toString());
        Double mbMaxAchSales = Double.parseDouble(map.get("mbMaxAchSales").toString());
        Double mktVolumeSales = Double.parseDouble(map.get("mktVolumeSales").toString());
        Integer costBack = Integer.parseInt(map.get("costBack").toString());
        String otherBrand = map.get("otherBrand").toString();
        String planInvestId = map.get("planInvestId").toString();
        Double customerFunds = Double.parseDouble(map.get("customerFunds").toString());
        csPlanInvestment.setOptimauthId(optimauthId);
        csPlanInvestment.setInvestFunds(investFunds);
        csPlanInvestment.setCostBack(costBack);
        csPlanInvestment.setOtherBrand(otherBrand);
        csPlanInvestment.setMbMaxAchSales(mbMaxAchSales);
        csPlanInvestment.setMktVolumeSales(mktVolumeSales);
        csPlanInvestment.setCustomerFunds(customerFunds);
        if(StringUtils.isBlank(planInvestId)){
            planInvestId = UUIDUtils.generateKey();
            csPlanInvestment.setRowId(planInvestId);
            csNewBusinessPlanMapper.insertPlanInvestment(csPlanInvestment);
        }else{
            csPlanInvestment.setRowId(planInvestId);
            csNewBusinessPlanMapper.updatePlanInvestment(csPlanInvestment);
        }


        /**
         *
         * 循环保存保存数据
         */
        for (int i = 0;i<planClass.length;i++){
            CSBusinessFlan bf = new CSBusinessFlan();
            bf.setRowId(rowId[i]);
            bf.setOptimauthId(optimauthId);
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
            Integer isExist = csNewBusinessPlanMapper.isExists(rowIdStr);
            if(isExist==0){
                if(StringUtils.isEmpty(rowIdStr)){
                    rowIdStr = UUIDUtils.generateKey();
                    bf.setRowId(rowIdStr);
                }
                //把新增的rowId 放到数组  防止删除时误删
                rowId[i] =rowIdStr;
                count = csNewBusinessPlanMapper.insertBusinessFlan(bf);
            }else {
                count = csNewBusinessPlanMapper.updateBusinessFlan(bf);
            }
            //执行删除操作
        }
        csNewBusinessPlanMapper.updateBusinessDelFlag(rowId,optimauthId);

        //任务完成
        if(csTaskCompletion!=null){
            csTaskCompletion.setRowId(UUIDUtils.generateKey());
            csTaskCompletion.setCreateTime(null);
            tCsTaskCompletionService.upateStatusToFinished(csTaskCompletion);
            tCsTaskCompletionService.updateOptimauthType("M0091",optimauthId);
        }
        if (count!=1){
            result = false;
            message = "保存失败!";
        }
        modelMap.put("planInvestId",csPlanInvestment.getRowId());
        modelMap.put("result",result);
        modelMap.put("message",message);
        return modelMap;
    }
}