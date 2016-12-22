package com.stripcode.service.cs;

import com.github.pagehelper.StringUtil;
import com.stripcode.core.util.UUIDUtils;
import com.stripcode.mybatis.cs.dao.CSRenewMarketauzMapper;
import com.stripcode.mybatis.cs.model.CSCustomerErpInfo;
import com.stripcode.mybatis.cs.model.CSMarketOptimauth;
import com.stripcode.mybatis.cs.model.RenewMarketauz;
import com.stripcode.mybatis.cs.model.TCsTaskCompletion;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Metro on 2016/8/22.
 */
@Service
@CacheConfig(cacheNames="CS20_007")
public class CS20_007Service {
    @Autowired
    private CSRenewMarketauzMapper csRenewMarketauzMapper;
    @Autowired
    private TCsTaskCompletionService tCsTaskCompletionService;

    public CSCustomerErpInfo queryByReNewInfo(String customerId,String erpCode){
        CSCustomerErpInfo csCustomerErpInfo = csRenewMarketauzMapper.selectByReNewInfo(customerId,erpCode);
        return csCustomerErpInfo;
    }

   public RenewMarketauz selectRenewMarketauzById(String optimauthId){
        return csRenewMarketauzMapper.selectRenewMarketauzById(optimauthId);
   }

    @Transactional
    public Map updateByReNewInfo(RenewMarketauz renewMarketauz,TCsTaskCompletion tCsTaskCompletion){
        Map modelMap = new HashMap();
        int count = -1;
        Integer IsExist = 0;
        //保存或修改是否成功
        boolean result = true;
        //返回到前台的提示信息
        String message = "续约成功!";
        Date date = new Date();
        renewMarketauz.setCreateTime(date);
        renewMarketauz.setUpdateTime(date);
        //优化表实体
        CSMarketOptimauth csMarketOptimauth = new CSMarketOptimauth();
        IsExist = csRenewMarketauzMapper.isExistsOption(renewMarketauz.getRowId());
        if(StringUtils.isBlank(renewMarketauz.getUserId())){
            renewMarketauz.setUserId("03fbc1510de646198aa893c2ddde7cf2");
        }
        if(IsExist==0){
            csMarketOptimauth.setRowId(UUIDUtils.generateKey());
            csMarketOptimauth.setCustomerId(renewMarketauz.getCustomerId());
            csMarketOptimauth.setDirector(renewMarketauz.getUserId());
            csMarketOptimauth.setErpCode(renewMarketauz.getErpCode());
            csMarketOptimauth.setErpName(renewMarketauz.getErpName());
            csMarketOptimauth.setBrand(renewMarketauz.getBrand());
            count = csRenewMarketauzMapper.insertMarketOptimauth(csMarketOptimauth);
            modelMap.put("optimauthId", csMarketOptimauth.getRowId());
        }else {
            count = csRenewMarketauzMapper.updateMarketOptimauth(renewMarketauz);
        }
        IsExist=csRenewMarketauzMapper.isExistsRenewMarketauz(renewMarketauz.getRowId());
        if(IsExist==0){
            if(StringUtils.isBlank(renewMarketauz.getRowId())) {
                renewMarketauz.setRowId(UUIDUtils.generateKey());
                renewMarketauz.setOptimauthId(csMarketOptimauth.getRowId());
                count = csRenewMarketauzMapper.insertByReNewInfo(renewMarketauz);
            }
        }else {
            count = csRenewMarketauzMapper.updateByReNewInfo(renewMarketauz);
        }
        // 入口为非流程图中进入
        if(StringUtil.isEmpty(tCsTaskCompletion.getTaskId())){
            tCsTaskCompletion.setTaskId("M0623");
        }
        if(count!=1){
            result = false;
            message = "续约失败!";
        }
        tCsTaskCompletion.setRowId(UUIDUtils.generateKey());
        tCsTaskCompletion.setCreateTime(null);
        tCsTaskCompletion.setOptimauthId(renewMarketauz.getOptimauthId());
        tCsTaskCompletionService.upateStatusToFinished(tCsTaskCompletion);
        modelMap.put("rowId", renewMarketauz.getRowId());
        modelMap.put("result", result);
        modelMap.put("message", message);
        return modelMap;
    }

}
