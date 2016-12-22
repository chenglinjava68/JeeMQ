package com.stripcode.web.ps;

import com.github.pagehelper.PageInfo;
import com.stripcode.core.util.WebUtil;
import com.stripcode.mybatis.common.JQGridObject;
import com.stripcode.mybatis.ps.model.PSPolicyItem;
import com.stripcode.service.ps.PS70_001Service;
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
 * Created by Metro on 2016/9/23.
 */
@Controller
@RequestMapping("/PS70_001")
public class PS70_001Controller extends BaseController{
    private static final  int EXCEL_SHEET_MAX = 5000;
    @Autowired
    private PS70_001Service ps70_001Service;
    @Autowired
    private TCodeMacroDefineService tCodeMacroDefineService;
    /**
     * 查询列表数据
     * @param request
     * @param response
     * @return
     */
    @ResponseBody
    @RequestMapping(value="/read/list",method = RequestMethod.POST)
    public JQGridObject list(HttpServletRequest request, HttpServletResponse response){
        Map<String, Object> params = WebUtil.getParameterMap(request);
        PageInfo<PSPolicyItem> list =ps70_001Service.queryForPage(params);
        return  new JQGridObject(list);
    }

    @ResponseBody
    @RequestMapping(value = "isExistsNumber",method = RequestMethod.POST)
    public Map<String ,Object> isExistsNumber(String itemCode,String rowId,String itemType){
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("valid",ps70_001Service.isExistsNumber(itemCode,rowId,itemType));
        return map;
    }
    /**
     * 查询政策信息详细内容
     * @param rowId
     * @param request
     * @param response
     * @return
     */
    @ResponseBody
    @RequestMapping(value="/read/editLoad",method = RequestMethod.POST)
    public Map<String,Object> editLoad (String rowId,HttpServletRequest request, HttpServletResponse response){
        Map<String,Object> map = new HashMap<String,Object>();
        if(StringUtils.isNotBlank(rowId)){
            PSPolicyItem psPolicyItem = ps70_001Service.queryById(rowId);
            map.put("main",psPolicyItem);
            map.put("codeList",tCodeMacroDefineService.queryStatusList());
        }
        return  map;
    }

    /**
     * 编辑保存
     * @param psPolicyItem
     * @param response
     * @return
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping(value = "/update",method = RequestMethod.POST)
    public Map update( PSPolicyItem psPolicyItem ,String itemType ,HttpServletResponse response)throws Exception{
        return setSuccessModelMap(ps70_001Service.update(psPolicyItem,itemType));
    }
    @ResponseBody
    @RequestMapping(value = "/updateResotre",method = RequestMethod.POST)
    public Map updateRestore( String rowId,String itemType ,HttpServletResponse response)throws Exception{
        return setSuccessModelMap(ps70_001Service.updatRestore(rowId,itemType));
    }
    /**
     * 导出列表数据
     * @param params
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value = "/exportUser")
    public String exportUser(@RequestParam String itemType,@RequestParam  Map<String,Object> params, HttpServletRequest request, HttpServletResponse response){


        ps70_001Service.exportUser( itemType,params,request,response);
        return null;
    }
}
