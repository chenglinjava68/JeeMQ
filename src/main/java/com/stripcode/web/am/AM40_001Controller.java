package com.stripcode.web.am;

import com.stripcode.core.util.WebUtil;
import com.stripcode.mybatis.am.model.AMAttachMentInfo;
import com.stripcode.mybatis.am.model.AMAuthorizationInfo;
import com.stripcode.mybatis.am.model.AMStoreInfo;
import com.stripcode.mybatis.common.JQGridObject;
import com.stripcode.service.am.AM40_001Service;
import com.stripcode.service.cp.CP10_001Service;
import com.stripcode.service.user.TCodeMacroDefineService;
import com.stripcode.web.BaseController;
import org.apache.commons.collections.map.HashedMap;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Metro on 2016/10/17.
 */
@Controller
@RequestMapping(value = "AM40_001")
public class AM40_001Controller extends BaseController {
    @Autowired
    private AM40_001Service am40_001Service;
    @Autowired
    private CP10_001Service cp10_001Service;
    @Autowired
    private TCodeMacroDefineService tCodeMacroDefineService;

    @ResponseBody
    @RequestMapping(value = "/read/list",method = RequestMethod.POST)
    public JQGridObject list(HttpServletRequest request, HttpServletResponse response){
        Map<String,Object> params = WebUtil.getParameterMap(request);
        return new JQGridObject(am40_001Service.query(params));
    }

    //加载简单搜索的下拉框
    @ResponseBody
    @RequestMapping(value = "/read/loadSelect",method = RequestMethod.POST)
    public Map<String,Object> loadSelect(String marketId, HttpServletResponse response) {
        Map<String,Object> map = new HashMap<String, Object>();
        map.put("codeList",cp10_001Service.selectCpMarket(marketId));
        map.put("selectList", tCodeMacroDefineService.selectSFPipelineStore());
        return map;
    }

    @ResponseBody
    @RequestMapping(value = "/read/queryByStoreId",method = RequestMethod.POST)
    public Map<String,Object> queryByStoreId(String storeId){
        Map<String,Object> map = new HashedMap();
        if (StringUtils.isNotBlank(storeId)){
            AMStoreInfo amStoreInfo = am40_001Service.queryById(storeId);
            map.put("main",amStoreInfo);
        }
        return map;
    }

    /**
     * 查询头部信息
     * @param storeId
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/read/selectForTitle",method = RequestMethod.POST)
    public AMStoreInfo selectForTitle(String storeId){
        AMStoreInfo amStoreInfo =am40_001Service.queryById(storeId);
        return am40_001Service.queryById(storeId);
    }

    /**
     * 导出
     * @param params
     * @param request
     * @param response
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/exportStores")
    public String exportStores(@RequestParam Map<String,Object> params, HttpServletRequest request, HttpServletResponse response){
        am40_001Service.exportStores(params,request,response);
        return null;
    }


    /**
     * 查询店铺附件
     * @param storeId
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/read/selectForAttachMent",method = RequestMethod.POST)
    public List<AMAttachMentInfo> selectForAttachMent(String storeId){
        return am40_001Service.selectForAttachMent(storeId);
    }

    /**
     * 查询店铺授权书附件
     * @param storeId
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/read/selectForAuthorization",method = RequestMethod.POST)
    public List<AMAuthorizationInfo> selectForAuthorization(String storeId){
        return am40_001Service.selectForAuthorization(storeId);
    }

    @ResponseBody
    @RequestMapping(value = "update",method = RequestMethod.POST)
    public Map update(AMStoreInfo model){
        return am40_001Service.update(model);
    }
}
