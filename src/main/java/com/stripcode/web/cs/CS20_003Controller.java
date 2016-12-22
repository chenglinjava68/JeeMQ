package com.stripcode.web.cs;

import com.stripcode.core.util.DataUtil;
import com.stripcode.core.util.WebUtil;
import com.stripcode.core.util.excelUtil.ExportExcel;
import com.stripcode.mybatis.common.JQGridObject;
import com.stripcode.mybatis.cs.dao.CSCustomerErpInfoMapper;
import com.stripcode.service.cs.CS20_003Service;
import com.stripcode.service.user.TCodeMacroDefineService;
import com.stripcode.web.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.stripcode.mybatis.cs.model.CSCustomerErpInfo;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.github.pagehelper.PageInfo;

/**
 * Created by Metro on 2016/8/19.
 */
@Controller
@RequestMapping("/CustomerErpInfo")
public class CS20_003Controller extends BaseController{
    @Autowired
    private TCodeMacroDefineService tCodeMacroDefineService;
    @Autowired
    private CS20_003Service cs20003Service;
    @Autowired
    private CSCustomerErpInfoMapper CSCustomerErpInfoMapper;
    // 查询列表
    @ResponseBody
    @RequestMapping(value = "/read/list",method = RequestMethod.POST)
    public JQGridObject List(HttpServletRequest request,HttpServletResponse response){
        Map<String, Object> params = WebUtil.getParameterMap(request);
        PageInfo<CSCustomerErpInfo>  list = cs20003Service.queryForPage(params);
        return  new JQGridObject(list);
    }
    //获取客户市场授权页面 简单搜索下拉框的值
    @ResponseBody
    @RequestMapping(value = "read/details",method = RequestMethod.POST)
    public Map<String,Object> details(HttpServletRequest request,HttpServletResponse response){
        Map<String,Object> map=new HashMap<String, Object>();
        map.put("codeList", tCodeMacroDefineService.selectFroCustomerErp());
        return  map;
    }
    @ResponseBody
    @RequestMapping(value = "/read/MarketDatelist",method = RequestMethod.POST)
    public JQGridObject queryForMarket(HttpServletRequest request,HttpServletResponse response){
        Map<String, Object> params = WebUtil.getParameterMap(request);
        PageInfo<CSCustomerErpInfo>  list = cs20003Service.queryForMarket(params);
        return  new JQGridObject(list);
    }
    /*Excel导出*/
    @RequestMapping(value = "/exportErpExcel")
    public String exportFile(@RequestParam Map<String,Object> params, HttpServletRequest request, HttpServletResponse response) {
        try {
            String fileName = "客户市场授权"+ DataUtil.getDate("yyyyMMddHHmmss")+".xlsx";
            List<CSCustomerErpInfo> data = CSCustomerErpInfoMapper.selectForExportErpInfo(params);
            new ExportExcel("客户市场授权", CSCustomerErpInfo.class).setDataList(data).write(response, fileName).dispose();
            return null;
        } catch (Exception e) {

        }
        return null;
    }

    /*
    判断是否为新老客户
     */
    @ResponseBody
    @RequestMapping(value = "read/isExistErpCode",method = RequestMethod.POST)
    public Map<String,Object> isExistErpCode(String customerId, HttpServletRequest request,HttpServletResponse response){
        Map<String,Object> map = new HashMap<String, Object>();
        Map<String,Object> params = new HashMap<String, Object>();
        params.put("customerId",customerId);
        map = cs20003Service.isExistErpCode(params);
        return  map;
    }
}
