package com.stripcode.web.ps;

import com.github.pagehelper.PageInfo;
import com.stripcode.core.util.WebUtil;
import com.stripcode.core.util.excelUtil.ImportExcel1;
import com.stripcode.mybatis.common.JQGridObject;
import com.stripcode.mybatis.cs.model.TSysCommonattached;
import com.stripcode.mybatis.ps.model.PSPolicySupportImplementation;
import com.stripcode.mybatis.ps.model.PSPolicySupportImplementationModel;
import com.stripcode.service.ps.PS70_007Service;
import com.stripcode.web.BaseController;
import com.stripcode.web.file.FileUploadController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Metro on 2016/12/9.
 */
@Controller
@RequestMapping("/PS70_007")
public class PS70_007Controller extends BaseController{
    @Autowired
    private PS70_007Service ps70_007Service;
    @Resource
    private FileUploadController fileUploadController;
    //列表带分页的查询数据
    @ResponseBody
    @RequestMapping(value="/read/list",method = RequestMethod.POST)
    public JQGridObject list(HttpServletRequest request, HttpServletResponse response){
        Map<String, Object> params = WebUtil.getParameterMap(request);
        PageInfo<PSPolicySupportImplementation> list =ps70_007Service.queryForPage(params);
        return  new JQGridObject(list);
    }
    /**
     * 导出列表数据
     * @param params
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value = "/exportUser")
    public String exportUser( @RequestParam Map<String,Object> params,HttpServletRequest request,HttpServletResponse response){
        ps70_007Service.exportUser(params,request,response);
        return null;
    }
    //政策支持审核详细信息导出
    @RequestMapping(value = "/exportUser1")
    public String exportUser1( @RequestParam Map<String,Object> params,HttpServletRequest request,HttpServletResponse response){
        ps70_007Service.exportUser1(params, request, response);
        return null;
    }
    @ResponseBody
    @RequestMapping(value="/read/queryCheckId",method = RequestMethod.POST)
    public Map<String,Object> queryCheckId (String checkId,HttpServletRequest request, HttpServletResponse response){
        Map<String,Object> map = new HashMap<String,Object>();
            List<PSPolicySupportImplementation> list = ps70_007Service.queryAll(checkId);
        PSPolicySupportImplementationModel model = new PSPolicySupportImplementationModel();
        model.setPsPolicySupportImplementationList(list);
        map.put("main",model);
        return  map;
    }
    @ResponseBody
    @RequestMapping(value = "/update",method = RequestMethod.POST)
    public Map update(PSPolicySupportImplementationModel psPolicySupportImplementation,HttpServletRequest request)throws Exception{
        return ps70_007Service.update(psPolicySupportImplementation);
    }
    // Excel导入功能
    @RequestMapping("/importExcel")
    @ResponseBody
    public Map importExcel(@RequestParam("file") CommonsMultipartFile file,String checkId, TSysCommonattached tSysCommonattached, HttpServletRequest request, HttpServletResponse response) throws  Exception
    {
        HashMap map = new HashMap();
        if(!file.isEmpty()){
            HashMap attachMap = fileUploadController.imageUpload(file,tSysCommonattached,request,response);
            //excel数据入库
            ImportExcel1 ie = new ImportExcel1();
            Map<String, Object> excelMap = null;
            try {
                InputStream is = file.getInputStream();
                excelMap = ie.readExcelContent(is,checkId);
                if(excelMap!=null)
                {
                    if((Boolean) excelMap.get("result")){
                        ps70_007Service.insertPSPolicySupportImplementationModel(excelMap);
                    }else {
                        excelMap.put("message","excel数据不正确!");
                        return excelMap;
                    }
                }
                return excelMap;
            }catch (FileNotFoundException e) {
                logger.info("未找到指定路径的文件!");
                e.printStackTrace();
                map.put("error","excel数据入库失败");
            }catch (IllegalStateException e) {
                e.printStackTrace();
                map.put("error","excel文件解析失败");
            }
        }else {
            map.put("error","上传失败");
        }
        return  map;
    }
}
