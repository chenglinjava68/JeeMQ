package com.stripcode.service.cs;

import com.stripcode.core.util.UUIDUtils;
import com.stripcode.mybatis.cs.dao.TSysCommonattachedMapper;
import com.stripcode.mybatis.cs.model.TSysCommonattached;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;

/**
 * Created by Metro on 2016/10/13.
 */
@Service
public class TSysCommonattachedService {
    @Autowired
    private TSysCommonattachedMapper tSysCommonattachedMapper;
    public HashMap update(TSysCommonattached record){
        HashMap modelMap = new HashMap();
        int count = -1;
        if(StringUtils.isBlank(record.getAttachId())){
            record.setAttachId(UUIDUtils.generateKey());
        }
        if (!isExists(record)) {
            count = tSysCommonattachedMapper.insert(record);
            modelMap.put("result", true);
            modelMap.put("message", "保存成功！");
            return modelMap;
        }
        count = tSysCommonattachedMapper.updateByPrimaryKey(record);
        modelMap.put("result", true);
        modelMap.put("message", "保存成功！");
        return modelMap;
    }
    public HashMap updateByVersionNo(TSysCommonattached record){
        HashMap modelMap = new HashMap();
        if(StringUtils.isBlank(record.getVersionNo())){
            record.setVersionNo(UUIDUtils.generateKey());
            tSysCommonattachedMapper.insert(record);
        }else{
            tSysCommonattachedMapper.updateByPrimaryKeyNew(record);
        }
        modelMap.put("result", true);
        modelMap.put("message", "保存成功！");
        return modelMap;
    }

    private boolean isExists(TSysCommonattached record) {
        if(tSysCommonattachedMapper.isExists(record) > 0 ){
            return true;
        }
        return false;
    }
    private boolean isExistsNew(TSysCommonattached record) {
        if(tSysCommonattachedMapper.isExistsNew(record) > 0 ){
            return true;
        }
        return false;
    }

    public HashMap updateNew(TSysCommonattached record) {
        HashMap modelMap = new HashMap();
        int count = -1;
        if(StringUtils.isBlank(record.getAttachId())){
            record.setAttachId(UUIDUtils.generateKey());
        }
        if(StringUtils.isBlank(record.getVersionNo())){
            record.setVersionNo(UUIDUtils.generateKey());
        }
        if (!isExistsNew(record)) {
            count = tSysCommonattachedMapper.insert(record);
            modelMap.put("result", true);
            modelMap.put("message", "保存成功！");
            return modelMap;
        }
        count = tSysCommonattachedMapper.updateByPrimaryKeyNew(record);
        modelMap.put("result", true);
        modelMap.put("message", "保存成功！");
        return modelMap;
    }
}
