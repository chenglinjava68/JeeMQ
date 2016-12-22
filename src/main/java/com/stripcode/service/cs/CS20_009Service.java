package com.stripcode.service.cs;

import com.stripcode.mybatis.cs.dao.CSAlterDiscountRateMapper;
import com.stripcode.mybatis.cs.model.CSAlterDiscountRate;
import com.stripcode.mybatis.cs.model.CSCustomerErpInfo;
import com.stripcode.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.stereotype.Service;


import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Metro on 2016/8/31.
 */
@Service
@CacheConfig(cacheNames = "csAlterDiscountRate")
public class CS20_009Service extends BaseService{

    @Autowired
    private CSAlterDiscountRateMapper csAlterDiscountRateMapper;
        /*
           通过CustomerId查询
          */
    public CSCustomerErpInfo selectBaseById(String customerId){
        return csAlterDiscountRateMapper.selectBaseById(customerId);
    };
         /*
          保存修改
           */
    public Map update(CSAlterDiscountRate model) throws Exception{
        Map modelMap = new HashMap();
        //定义是否成功 用于判断
        boolean result = true;
        //定义后台返回数据
        String message = "修改成功!";
        int count = -1;
        Date date = new Date();
        model.setUpdateTime(date);
        count = csAlterDiscountRateMapper.update(model);
        if(count!=1){
            result = false;
            message = "修改失败!";
        }
        modelMap.put("result", result);
        modelMap.put("message", message);
        return modelMap;
    }


}
