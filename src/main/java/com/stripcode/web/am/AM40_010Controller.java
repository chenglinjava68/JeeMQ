package com.stripcode.web.am;

import com.stripcode.service.am.AM40_010Service;
import org.apache.commons.collections.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

/**
 * Created by Metro on 2016/12/16.
 */
@Controller
@RequestMapping(value = "AM40_010")
public class AM40_010Controller {
    @Autowired
    private AM40_010Service am40_010Service;

    /**
     * 查询店铺租约附件信息表
     * @param storeId
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/selectAMLeaseAttachMent",method = RequestMethod.POST)
    public Map selectAMLeaseAttachMent(String storeId){
        Map<String,Object> map = new HashedMap();
        map.put("main",am40_010Service.selectAMLeaseAttachMent(storeId));
        return map;
    }
}
