package com.stripcode.web.sf;

import com.stripcode.core.dto.sf.QueryCSpipeLineDto;
import com.stripcode.mybatis.common.JQGridObject;
import com.stripcode.mybatis.cp.model.CpMarketInfo;
import com.stripcode.mybatis.cs.model.CSSfPipeline;
import com.stripcode.service.sf.SF30_003Service;
import com.stripcode.web.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Metro on 2016/9/12.
 */
@Controller
@RequestMapping("/SF30_003")
public class SF30_003Controller extends BaseController{
    @Autowired
    private SF30_003Service sF30_003Service;
    @RequestMapping("/selectStoreInfo")
    @ResponseBody
    public JQGridObject selectStoreInfo(QueryCSpipeLineDto params){
        return new JQGridObject(sF30_003Service.selectMapListForPage(params));
    }
    @RequestMapping("/getBaseInfo")
    @ResponseBody
    public Map getBaseInfo(CSSfPipeline csSfPipeline){
        Map<String,Object>  map = new HashMap<String,Object>();
        map.put("operationModeList",sF30_003Service.selectOperationModeList());
        map.put("storeImageList",sF30_003Service.selectStoreImageList());
        return map;
    }
    @RequestMapping("/getAreaInfo")
    @ResponseBody
    public List<CpMarketInfo> getAreaInfo(String parentId,String cityName){
        return sF30_003Service.getAreaInfo(parentId,cityName);
    }

}
