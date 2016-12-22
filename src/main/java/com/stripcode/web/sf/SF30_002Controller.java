package com.stripcode.web.sf;

import com.github.pagehelper.PageInfo;
import com.stripcode.core.util.WebUtil;
import com.stripcode.mybatis.common.JQGridObject;
import com.stripcode.mybatis.cs.model.CSCustomerInfo;
import com.stripcode.mybatis.cs.model.CSSfPipeline;
import com.stripcode.service.cs.CS20_006Service;
import com.stripcode.service.sf.SF30_002Service;
import com.stripcode.service.user.TCodeMacroDefineService;
import com.stripcode.web.BaseController;
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
import java.util.Map;

/**
 * Created by Metro on 2016/9/12.
 */
@Controller
@RequestMapping("/SF30_002")
public class SF30_002Controller extends BaseController{
    @Autowired
    private CS20_006Service cS20_006Service;
    @Autowired
    private TCodeMacroDefineService tCodeMacroDefineService;
    @Autowired
    private SF30_002Service sf30002Service;
    /*
    * 查询列表
    * */
    @ResponseBody
    @RequestMapping(value="/read/list",method = RequestMethod.POST)
    public JQGridObject list(HttpServletRequest request, HttpServletResponse response){
        Map<String, Object> params = WebUtil.getParameterMap(request);
        PageInfo<CSSfPipeline> list = sf30002Service.queryForPage(params);
        return  new JQGridObject(list);
    }
    /*
    * 加载搜索下拉框
    * */
    @ResponseBody
    @RequestMapping(value="/read/selectLoad",method = RequestMethod.POST)
    public Map<String,Object> selectLoad (String parentId,String ppId,String customerId,HttpServletRequest request, HttpServletResponse response){
        Map<String,Object> map = new HashMap<String,Object>();
        if(StringUtils.isNotBlank(ppId)){
            CSSfPipeline csSfPipeline = sf30002Service.queryById(ppId);
            map.put("ErpList", sf30002Service.selectErpName(csSfPipeline.getCustomerId()));//查询erp市场名称
            map.put("main",csSfPipeline);
        }


       /* map.put("CustomerList",sf30002Service.selectErpCustomerAll());//查询客户名称*/
       map.put("developerList",sf30002Service.selectAllUser());//查询开发人员
        map.put("CustomerList",cS20_006Service.selectCustomerName());//查询客户名称

        map.put("loadProvince",sf30002Service.selectCpMarket(parentId));//查询省份
        map.put("codeList", tCodeMacroDefineService.selectSFPipelineStore());//查询列表
        return  map;
    }
    /*
    * 根据客户id带出客户性质，erp市场
    * */
    @ResponseBody
    @RequestMapping(value="/read/selectLoad1",method = RequestMethod.POST)
    public Map<String,Object> selectLoad1 (String customerId,HttpServletRequest request, HttpServletResponse response){
        Map<String,Object> map = new HashMap<String,Object>();
        if(StringUtils.isNotBlank(customerId)){
            CSCustomerInfo csCustomerInfo = sf30002Service.customerById(customerId);
            map.put("main",csCustomerInfo);
        }
        map.put("ErpList", sf30002Service.selectErpName(customerId));//查询erp市场名称
        return  map;
    }
    @ResponseBody
    @RequestMapping(value="/read/selectBrand",method = RequestMethod.POST)
    public Map<String,Object> selectBrand (String erpCode,HttpServletRequest request, HttpServletResponse response){
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("main", sf30002Service.selectBrand(erpCode));//查询品牌
        return  map;
    }
    /*
    * 编辑
    * */
    @ResponseBody
    @RequestMapping(value = "/update",method = RequestMethod.POST)
    public Map update(CSSfPipeline csSfPipeline , HttpServletResponse response)throws Exception{
        return setSuccessModelMap(sf30002Service.update(csSfPipeline));
    }

    @RequestMapping(value = "/exportUser")
    public String exportUser(@RequestParam Map<String,Object> params, HttpServletRequest request, HttpServletResponse response){

        sf30002Service.exportUser(params,request,response);
        return null;
    }
}
