package com.stripcode.service.cs;

import com.stripcode.core.util.UUIDUtils;
import com.stripcode.mybatis.cs.dao.CSCustomerInfoMapper;
import com.stripcode.mybatis.cs.dao.CSMarketSurveyMapper;
import com.stripcode.mybatis.cs.dao.TCsTaskCompletionMapper;
import com.stripcode.mybatis.cs.model.CSCustomerInfo;
import com.stripcode.mybatis.cs.model.CSMarketSurvey;
import com.stripcode.mybatis.cs.model.CSSysAttachedTemplate;
import com.stripcode.mybatis.cs.model.TCsTaskCompletion;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by Metro on 2016/9/11.
 */
@Service
@CacheConfig(cacheNames = "CS20_019Service")
public class CS20_019Service {
    @Autowired
    private CSMarketSurveyMapper csMarketSurveyMapper;
    @Autowired
    private CSCustomerInfoMapper csCustomerInfoMapper;
    @Autowired
    private TCsTaskCompletionMapper tCsTaskCompletionMapper;
    @Autowired
    private TCsTaskCompletionService tCsTaskCompletionService;
    public List<CSSysAttachedTemplate> MarketSurveyList(String optimauthId){
        List<CSSysAttachedTemplate> csSysAttachedTemplateList =csMarketSurveyMapper.MarketSurveyList(optimauthId);
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;
        for (CSSysAttachedTemplate model : csSysAttachedTemplateList){
            try {
                if(model.getCreaterTime()!=null){
                    date = format.parse(model.getCreaterTime());
                    model.setCreaterTime(format.format(date));
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return  csSysAttachedTemplateList;
    }
    public CSCustomerInfo selectCustomer(String customerId){
        return  csCustomerInfoMapper.selectById(customerId);
    }

    @Transactional
    public Map update(String optimauthId,List<CSMarketSurvey> list,String userId,TCsTaskCompletion tCsTaskCompletion){
        Map modelMap = new HashMap();
        Boolean result = true;
        String message = "保存成功!";
        Integer count = -1;
        String [] templateId =null;
      /*  try{
            templateId =  (String []) map.get("templateId");
        }catch(Exception e){
            templateId = new String[1];
            templateId[0] = (String)map.get("templateId");
        }
        String optimauthId=map.get("optimauthId").toString();
        List<CSMarketSurvey> Surveylist = new ArrayList<CSMarketSurvey>();
        for (int i=0;i<templateId.length;i++){
            CSMarketSurvey csMarket = new CSMarketSurvey();
            Date date = new Date();
            csMarket.setUpdateTime(date);
            csMarket.setCreateTime(date);
            csMarket.setCreator(userId);
            csMarket.setUpdater(userId);
            csMarket.setTemplateId(templateId[i]);
            csMarket.setRowId(UUIDUtils.generateKey());
            csMarket.setOptimauthId(optimauthId);
            Surveylist.add(csMarket);
        }*/
        for(CSMarketSurvey csMarket :list){
            Integer isExist = csMarketSurveyMapper.SurveyCount(optimauthId);
            if(isExist==0){
                if(StringUtils.isBlank(csMarket.getRowId())){
                    csMarket.setRowId(UUIDUtils.generateKey());
                    csMarket.setOptimauthId(optimauthId);
                }
                count = csMarketSurveyMapper.insertSurvey(csMarket);
            }else{
                csMarket.setOptimauthId(optimauthId);
                count = csMarketSurveyMapper.updateSurvey(csMarket);
            }
        }
        tCsTaskCompletionService.updateOptimauthType("M0089",optimauthId);
        tCsTaskCompletionService.upateStatusToFinished(tCsTaskCompletion);
        if(count!=1){
            result = false;
            message = "保存失败!";
        }
        modelMap.put("result",result);
        modelMap.put("message",message);
        return modelMap;
    }
}
