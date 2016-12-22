package com.stripcode.web.cs;

import com.stripcode.core.dto.cs.CreateOrModifyCsTaskCompletionDto;
import com.stripcode.core.util.WebUtil;
import com.stripcode.mybatis.cs.model.CSErpInfo;
import com.stripcode.mybatis.cs.model.CSMarketOptimauth;
import com.stripcode.service.cs.CS20_014Service;
import com.stripcode.web.BaseController;
import org.apache.commons.collections.map.HashedMap;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Metro on 2016/8/24.
 */
@Controller
@RequestMapping("/MarketErpInfo")
public class CS20_014Controller extends BaseController{
    @Autowired
    private CS20_014Service cs20_014Service;
    /*
    添加客户Erp
     */
    @ResponseBody
    @RequestMapping(value = "/update",method = RequestMethod.POST)
    public Map update(HttpServletRequest request, HttpServletResponse response,CreateOrModifyCsTaskCompletionDto dto)throws Exception{
        Map<String,Object> params = WebUtil.getParameterMap(request);
        String optimauthId = params.get("rowId").toString();
        dto.setOptimauthId(optimauthId);
        return  setSuccessModelMap(cs20_014Service.update(params,getCurrUser(),dto.toModel()));
    }
     /*
    查询erp
     */
    @ResponseBody
    @RequestMapping(value = "/selectStore",method = RequestMethod.POST)
    public List<CSErpInfo> selectStore(String customerId,String rowId)throws Exception{
        return  cs20_014Service.selectStore(customerId, rowId);
    }
    @ResponseBody
    @RequestMapping(value = "/selectErp",method = RequestMethod.POST)
    public Map<String,Object> selectErp(String rowId)throws Exception{
        Map<String,Object> map = new HashedMap();
        if(StringUtils.isNotBlank(rowId)){
            CSMarketOptimauth csMarketOptimauth= cs20_014Service.selectErp(rowId);
            map.put("main",csMarketOptimauth);
        }
        return map;
    }
    @ResponseBody
    @RequestMapping(value = "isExistsByIdNumber",method = RequestMethod.POST)
    public Map<String ,Object> isExistsByIdNumber(String erpCode,String rowId){
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("valid",cs20_014Service.IsExistErpCode(erpCode, rowId));
        return map;
    }
}
