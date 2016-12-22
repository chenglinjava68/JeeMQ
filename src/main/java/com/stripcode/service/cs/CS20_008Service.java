package com.stripcode.service.cs;

import com.github.pagehelper.StringUtil;
import com.stripcode.core.util.UUIDUtils;
import com.stripcode.mybatis.cs.dao.CSAterMarketauzMapper;
import com.stripcode.mybatis.cs.dao.CSErpIDMapper;
import com.stripcode.mybatis.cs.dao.CSRenewMarketauzMapper;
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
 * Created by Metro on 2016/8/22.
 */
@Service
@CacheConfig(cacheNames="CS20_007")
public class CS20_008Service {
    @Autowired
    private CSErpIDMapper csErpIDMapper;
    @Autowired
    private CSRenewMarketauzMapper csRenewMarketauzMapper;
    @Autowired
    private CSAterMarketauzMapper csAterMarketauzMapper;
    @Autowired
    private TCsTaskCompletionService tCsTaskCompletionService;

    public CSAterMarketauz selectMarketauz(String optimauthId,String rowId,String erpCode){
        CSAterMarketauz csAterMarketauz = null;
        csAterMarketauz=csAterMarketauzMapper.selectMarketauz(optimauthId);
        if(csAterMarketauz!=null){
            csAterMarketauz.setCsMarketCustomerDiscountSplitList(this.selectDiscountSplit(optimauthId));
        }else {
            csAterMarketauz = new  CSAterMarketauz();
            csAterMarketauz.setCsMarketCustomerDiscountSplitList(this.selectCustomerSplit(erpCode,rowId));
        }
        return  csAterMarketauz;
    };
    //查询分成比例
    public List<CSMarketCustomerDiscountSplit> selectCustomerSplit(String erpCode,String rowId){
        return  csErpIDMapper.selectCustomerSplit(erpCode,rowId);
    }
    public List<CSMarketCustomerDiscountSplit> selectDiscountSplit(String rowId){
        return  csRenewMarketauzMapper.selectDiscountSplit(rowId);
    }
    public List<CSCustomerErpInfo> selectErpList(String optimauthId){
        return  csAterMarketauzMapper.selectErpList(optimauthId);
    };
    @Transactional
    public Map update(CSAterMarketauz csAterMarketauz,TCsTaskCompletion tCsTaskCompletion){
        Map modelMap = new HashMap();
        int count = -1;
        Integer IsExist = 0;
        //保存或修改是否成功
        boolean result = true;
        //返回到前台的提示信息
        String message = "主体变更成功!";
        //优化表实体
        CSMarketOptimauth csMarketOptimauth = new CSMarketOptimauth();
        IsExist = csAterMarketauzMapper.isExistsAterOptimauth(csAterMarketauz.getRowId());
        if(StringUtils.isBlank(csAterMarketauz.getUserId())){
            csAterMarketauz.setUserId("03fbc1510de646198aa893c2ddde7cf2");
        }
        if(IsExist==0){
            csMarketOptimauth.setRowId(UUIDUtils.generateKey());
            csMarketOptimauth.setCustomerId(csAterMarketauz.getCustomerId());
            csMarketOptimauth.setDirector(csAterMarketauz.getUserId());
            csMarketOptimauth.setErpCode(csAterMarketauz.getErpCode());
            csMarketOptimauth.setErpName(csAterMarketauz.getErpName());
            csMarketOptimauth.setBrand(csAterMarketauz.getBrand());
            count = csAterMarketauzMapper.insertAterOptimauth(csMarketOptimauth);
            modelMap.put("optimauthId", csMarketOptimauth.getRowId());
        }else {
            count = csAterMarketauzMapper.updateAterOptimauth(csAterMarketauz);
        }
        IsExist=csAterMarketauzMapper.isExistAterMarketauz(csAterMarketauz.getRowId());
        if(IsExist==0){
            if(StringUtils.isBlank(csAterMarketauz.getRowId())) {
                csAterMarketauz.setRowId(UUIDUtils.generateKey());
                csAterMarketauz.setOptimauthId(csMarketOptimauth.getRowId());
                count = csAterMarketauzMapper.insertAterMarketauz(csAterMarketauz);
            }
        }else {
            count = csAterMarketauzMapper.updateAterMarketauz(csAterMarketauz);
        }
        // 入口为非流程图中进入
        if(StringUtil.isEmpty(tCsTaskCompletion.getTaskId())){
            tCsTaskCompletion.setTaskId("M0631");
        }
        if(count!=1){
            result = false;
            message = "主体变更失败!";
        }
        tCsTaskCompletion.setRowId(UUIDUtils.generateKey());
        tCsTaskCompletion.setCreateTime(null);
        tCsTaskCompletion.setOptimauthId(csAterMarketauz.getOptimauthId());
        tCsTaskCompletionService.upateStatusToFinished(tCsTaskCompletion);
        modelMap.put("rowId", csAterMarketauz.getRowId());
        modelMap.put("result", result);
        modelMap.put("message", message);
        return modelMap;
    }

}
