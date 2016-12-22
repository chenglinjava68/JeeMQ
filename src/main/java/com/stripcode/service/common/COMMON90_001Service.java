package com.stripcode.service.common;

import com.stripcode.core.util.UUIDUtils;
import com.stripcode.mybatis.cs.dao.TSysCommonattachedMapper;
import com.stripcode.mybatis.cs.model.TSysCommonattached;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Metro on 2016/12/14.
 */
@Service
public class COMMON90_001Service {
    @Autowired
    private TSysCommonattachedMapper  tSysCommonattachedMapper;
    public List<TSysCommonattached> queryAttachList(String attachId) {
        return tSysCommonattachedMapper.selectByAttachId(attachId);
    }

    public Map update(List<TSysCommonattached> attachs) {
        Map map = new HashMap<String,Object>();
        if(attachs !=null){
            for(TSysCommonattached   tSysCommonattached : attachs){
                if(StringUtils.isBlank(tSysCommonattached.getVersionNo())){
                    tSysCommonattached.setVersionNo(UUIDUtils.generateKey());
                    tSysCommonattachedMapper.insert(tSysCommonattached);
                }else{
                    tSysCommonattachedMapper.updateByPrimaryKeyNew(tSysCommonattached);
                }
            }
        }
        map.put("result",true);
        map.put("message","保存成功！");
        return map;
    }

    public Map delete(String versionNo) {
        Map map = new HashMap<String,Object>();
        if(StringUtils.isNotBlank(versionNo)){
            tSysCommonattachedMapper.deleteByVersionNo(versionNo);
        }
        map.put("result",true);
        map.put("message","删除成功！");
        return map;
    }
}
