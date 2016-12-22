package com.stripcode.web.cs;

import com.stripcode.core.dto.cs.CreateOrModifyCsTaskCompletionDto;
import com.stripcode.core.util.WebUtil;
import com.stripcode.mybatis.common.JQGridObject;
import com.stripcode.mybatis.cp.model.CpMarketInfo;
import com.stripcode.mybatis.cs.model.CSErpMarketMap;
import com.stripcode.mybatis.cs.model.CSNewMarketAuz;
import com.stripcode.service.cp.CP10_001Service;
import com.stripcode.service.cs.CS20_001Service;
import com.stripcode.service.cs.CS20_006Service;
import com.stripcode.service.user.RscSysUserService;
import com.stripcode.service.user.TCodeMacroDefineService;
import com.stripcode.web.BaseController;
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
 * Created by Metro on 2016/8/22.
 */
@Controller
@RequestMapping("/Cs20_006")
public class CS20_006Controller extends BaseController{

    @Autowired
    private CS20_006Service CS20_006Service;

    @Autowired
    private CP10_001Service cp10_001Service;
    @Autowired
    private CS20_001Service cs20_001Service;

    @Autowired
    private TCodeMacroDefineService tCodeMacroDefineService;
    @Autowired
    private RscSysUserService rscSysUserService;
    // 添加 市场的列表
    @ResponseBody
    @RequestMapping(value = "/read/list",method = RequestMethod.POST)
    public JQGridObject list(HttpServletRequest request,HttpServletResponse response) {
        Map<String, Object> params = WebUtil.getParameterMap(request);
        return new JQGridObject(CS20_006Service.queryForPage(params));
    }
    //加载简单搜索的下拉框
    @ResponseBody
    @RequestMapping(value = "/read/loadSelect",method = RequestMethod.POST)
    public Map<String,Object> loadSelect(String marketId, HttpServletResponse response) {
        Map<String,Object> map = new HashMap<String, Object>();
        map.put("codeList",cp10_001Service.selectCpMarket(marketId));
        map.put("selectList", tCodeMacroDefineService.selectForMarket());
        return map;
    }
   //查询客户下拉框的值
   /* @ResponseBody
    @RequestMapping(value = "/read/SelectCustomerName",method = RequestMethod.POST)
    public Map<String,Object> selectCustomerName(HttpServletRequest request,HttpServletResponse response){
        Map<String,Object> map = new HashMap<String, Object>();
        map.put("codeList",CS20_006Service.selectCustomerName());
        return  map;
    }*/
    //查询客户信息和授权信息
    @ResponseBody
    @RequestMapping(value = "/read/listInfo",method = RequestMethod.POST)
      public Map<String,Object> details(String customerId,String rowId,HttpServletRequest request,HttpServletResponse response){
        Map<String,Object> map = new HashMap<String, Object>();
        //用于返回到前台页面的 marketId
        String marketId = null;
        if(StringUtils.isNotBlank(customerId)) {
            List<CSErpMarketMap> list = CS20_006Service.selectMarketIds(rowId);
            StringBuffer str = new StringBuffer();
            for (CSErpMarketMap csErpMarketMap : list){
                str = str.append(csErpMarketMap.getMarketId()).append(",");
            }
            marketId = str.toString();
           // CSCustomerInfo csCustomerInfo =cs20_001Service.queryById(customerId);
            CSNewMarketAuz csNewMarketAuz = CS20_006Service.selectAllBaseInfoById(customerId,rowId);
           // map.put("csCustomerInfo",csCustomerInfo);
            map.put("erpCoedList",CS20_006Service.selectErpCodeList(customerId));
            map.put("main", csNewMarketAuz);
            map.put("marketIds",marketId);
        }else{
            CSNewMarketAuz csNewMarketAuz = CS20_006Service.selectAllBaseInfoById(customerId,rowId);
            map.put("main", csNewMarketAuz);
        }
        //查询客户下拉框的值
        map.put("CustomerList",CS20_006Service.selectCustomerName());
        map.put("erpList",CS20_006Service.selectErpCodeList(customerId));
        map.put("userList",rscSysUserService.query());
        map.put("codeList", tCodeMacroDefineService.selectForMarketAOadd());
        return  map;
    }

    //查询新增基本信息 市场列表
    @ResponseBody
    @RequestMapping(value = "/read/listMarket",method = RequestMethod.POST)
    public List<CpMarketInfo> selectMarketList(String marketIds,String rowId,HttpServletRequest request,HttpServletResponse response){
            return CS20_006Service.selectMarketList(marketIds, rowId);
    }
    @ResponseBody
    @RequestMapping(value = "/read/selectErpCode",method = RequestMethod.POST)
    public CSNewMarketAuz selectErpCode(String customerId,String erpCode,HttpServletRequest request,HttpServletResponse response){
        return  CS20_006Service.selectErpCode(customerId,erpCode);
    }
    //保存
    @ResponseBody
    @RequestMapping(value = "/update",method = RequestMethod.POST)
    public Map update(CSNewMarketAuz csNewMarketAuz,CreateOrModifyCsTaskCompletionDto dto,HttpServletRequest request, HttpServletResponse response)throws Exception{
        String userId = getCurrUser();
        String optimauthId = csNewMarketAuz.getRowId();
        dto.setOptimauthId(optimauthId);
        Map<String,Object> map = WebUtil.getParameterMap(request);
        return setSuccessModelMap(CS20_006Service.update(map, csNewMarketAuz, userId, dto.toModel()));
    }
    //导出客户市场添加列表
    @RequestMapping(value = "/exportMarketInfo")
    public String exportRole(Map<String,Object> params,HttpServletRequest request,HttpServletResponse response){
        CS20_006Service.exportMarketInfo(params,request,response);
        return null;
    }

}
