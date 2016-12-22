package com.stripcode.web.am;

import com.stripcode.service.am.AM40_006Service;
import com.stripcode.web.BaseController;
import org.apache.commons.collections.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

/**
 * Created by Metro on 2016/12/09.
 */
@Controller
@RequestMapping(value = "AM40_006")
public class AM40_006Controller extends BaseController {
    @Autowired
    private AM40_006Service am40_006Service;

    /**
     * 查询店铺业主信息房产来源
     * @param storeId
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/selectAMLandLordInfo",method = RequestMethod.POST)
    public Map selectAMLandLordInfo(String storeId){
        Map<String,Object> map = new HashedMap();
        map.put("main",am40_006Service.selectAMLandLordInfo(storeId));
        return map;
    }

    /**
     * 查询店铺业主信息集合
     * @param storeId
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/selectAMLandLordInfoDetail",method = RequestMethod.POST)
    public Map selectAMLandLordInfoDetail(String storeId){
        Map<String,Object> map = new HashedMap();
        map.put("main",am40_006Service.selectAMLandLordInfoDetail(storeId));
        return map;
    }

}
