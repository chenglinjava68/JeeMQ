package com.stripcode.service.am;

import com.stripcode.core.util.UUIDUtils;
import com.stripcode.mybatis.am.dao.AMAuthorizationInfoMapper;
import com.stripcode.mybatis.am.model.AMAuthorizationInfo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Metro on 2016/10/27.
 */
@Service
@CacheConfig(cacheNames = "AM40_012")
public class AM40_012Service {
    @Autowired
    private AMAuthorizationInfoMapper amAuthorizationInfoMapper;

    @Transactional
    public Map update(AMAuthorizationInfo model){
        Map modelMap = new HashMap();
        Integer count = -1;
        Boolean result = true;
        String message = "保存成功!";
        if (StringUtils.isBlank(model.getRowId())){
            model.setRowId(UUIDUtils.generateKey());
            count = amAuthorizationInfoMapper.insertAuthorizationInfo(model);
        }else {
            count = amAuthorizationInfoMapper.updateAuthorizationInfo(model);
        }
        if(count!=1){
            result = false;
            message = "保存失败!";
        }
        modelMap.put("rowId",model.getRowId());
        modelMap.put("result",result);
        modelMap.put("message",message);
        return modelMap;
    }
}
