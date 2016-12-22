package com.stripcode.web.sys;

import com.github.pagehelper.PageInfo;
import com.stripcode.core.util.WebUtil;
import com.stripcode.mybatis.common.JQGridObject;
import com.stripcode.mybatis.sys.model.SYSEstInvestmentModel;
import com.stripcode.service.sys.SYS80_001Service;
import com.stripcode.service.user.TCodeMacroDefineService;
import com.stripcode.web.BaseController;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Metro on 2016/10/25.
 */
@Controller
@RequestMapping("/SYS80_001")
public class SYS80_001Controller extends BaseController{
    private static final  int EXCEL_SHEET_MAX = 5000;
    @Autowired
    private SYS80_001Service sys80_001Service;
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
        PageInfo<SYSEstInvestmentModel> list =sys80_001Service.queryForPage(params);
        return  new JQGridObject(list);
    }
    /*
    * 加载搜索下拉框
    * */
    @ResponseBody
    @RequestMapping(value="/read/selectLoad",method = RequestMethod.POST)
    public Map<String,Object> selectLoad (String rowId,HttpServletRequest request, HttpServletResponse response){
        Map<String,Object> map = new HashMap<String,Object>();
        if(StringUtils.isNotBlank(rowId)){
            SYSEstInvestmentModel sysEstInvestmentModel = sys80_001Service.queryById(rowId);
            map.put("main",sysEstInvestmentModel);
        }else{
            SYSEstInvestmentModel sysEstInvestmentModel =new SYSEstInvestmentModel();
            map.put("main",sysEstInvestmentModel);
        }
        map.put("codeList", tCodeMacroDefineService.selectSYSEstInvestmentModelStore());//查询列表
        return  map;
    }

    /*
    * 编辑
    * */
    @ResponseBody
    @RequestMapping(value = "/update",method = RequestMethod.POST)
    public Map update( SYSEstInvestmentModel sysEstInvestmentModel , HttpServletResponse response)throws Exception{
        return setSuccessModelMap(sys80_001Service.update(sysEstInvestmentModel));
    }

    /**
     * 导出
     * @param params
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value = "/exportUser")
    public String exportUser(@RequestParam Map<String,Object> params, HttpServletRequest request, HttpServletResponse response){

        response.setContentType("application/json;charset=UTF-8");
        response.setHeader("Access-Control-Allow-Origin","*");
        sys80_001Service.exportUser(params,request,response);
        return null;
    }
}
