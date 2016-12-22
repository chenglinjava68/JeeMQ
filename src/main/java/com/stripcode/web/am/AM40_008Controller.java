package com.stripcode.web.am;

import com.stripcode.service.am.AM40_008Service;
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
@RequestMapping(value = "AM40_008")
public class AM40_008Controller {
    @Autowired
    private AM40_008Service am40_008Service;

    /**
     * 查询店铺租金提案信息表
     * @param storeId
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/selectAMRentalProposalDirectStore",method = RequestMethod.POST)
    public Map selectAMRentalProposalDirectStore(String storeId){
        Map<String,Object> map = new HashedMap();
        map.put("main",am40_008Service.selectAMRentalProposalDirectStore(storeId));
        return map;
    }

    /**
     * 查询店铺租期详细信息集合
     * @param storeId
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/selectAMRentalDetail",method = RequestMethod.POST)
    public Map selectAMRentalDetail(String storeId){
        Map<String,Object> map = new HashedMap();
        map.put("main",am40_008Service.selectAMRentalDetail(storeId));
        return map;
    }
}
