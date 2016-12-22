package com.stripcode.web.sf;

import com.stripcode.core.util.WebUtil;
import com.stripcode.mybatis.common.JQGridObject;
import com.stripcode.mybatis.cs.model.TCsTaskCompletion;
import com.stripcode.mybatis.cs.model.TSysCommonattached;
import com.stripcode.mybatis.sf.model.SFEstInvestment;
import com.stripcode.service.sf.SF30_057Service;
import com.stripcode.service.user.TCodeMacroDefineService;
import com.stripcode.web.BaseController;
import com.stripcode.web.file.DownFileController;
import com.stripcode.web.file.FileUploadController;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Metro
 */
@Controller
@RequestMapping("/SF30_057")
public class SF30_057Controller extends BaseController{
    @Autowired
    private SF30_057Service sf30_057Service;
    @Resource
    private DownFileController downFileController;
    @Resource
    private FileUploadController fileUploadController;
    @Autowired
    private TCodeMacroDefineService tCodeMacroDefineService;

    @ResponseBody
    @RequestMapping(value = "/queryForPage",method = RequestMethod.POST)
    public JQGridObject queryForPage(HttpServletRequest request){
        Map<String,Object> map = WebUtil.getParameterMap(request);
        return new JQGridObject(sf30_057Service.selectForPage(map));
    }

    @ResponseBody
    @RequestMapping(value = "/loadSelect",method = RequestMethod.POST)
    public Map<String,Object> loadSelect(String operationMode,String brand){
        Map<String,Object> map = new HashMap<String, Object>();
        map.put("mtList",sf30_057Service.loadListSelect(operationMode,brand));
        return map;
    }

    @ResponseBody
    @RequestMapping(value = "/loadTitleAndContent",method = RequestMethod.POST)
    public Map<String,Object> loadTitleAndContent(String modelType,String investmentId){
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("titleList",tCodeMacroDefineService.selectForEstInvestmentDetails(modelType));
        map.put("detailList",sf30_057Service.queryInvestDetail(modelType,investmentId));
        return map;
    }
    @ResponseBody
    @RequestMapping(value = "/update",method = RequestMethod.POST)
    public Map update(SFEstInvestment model, String filePath, TSysCommonattached tSysCommonattached, HttpServletResponse response, HttpServletRequest request) throws  Exception{
        HashMap map = fileUploadController.upLoadExistFileToServer(filePath,true,tSysCommonattached,request,response);
            model.setAttachId((String) map.get("attachId"));
        Map newMap = sf30_057Service.update(model);
        newMap.put("attachId",(String) map.get("attachId"));
        return newMap;
    }

    @ResponseBody
    @RequestMapping(value = "/delete",method = RequestMethod.POST)
    public Map delete(String ppId,String rowId){
        return sf30_057Service.delete(ppId,rowId);
    }

    @ResponseBody
    @RequestMapping(value = "/queryResultData",method = RequestMethod.POST)
    public SFEstInvestment queryResultData(String investmentId){
        SFEstInvestment model = new SFEstInvestment();
        model.setResultData(sf30_057Service.queryResultData(investmentId));
        return model;
    }
    @ResponseBody
    @RequestMapping("/getFilePath")
    public Map<String,String>

    getFilePath(String modelType,String attachId,String brand,HttpServletResponse response) throws  Exception{
        Map<String,String> map =null;
        if(StringUtils.isBlank(attachId)){
            map =sf30_057Service.getFilePath(modelType,brand);
        }else{
            map = sf30_057Service.getTemlateFilePath(attachId);
        }
        if(map !=null){
            String filePath =downFileController.downloadFileToPath(map.get("attachId"),map.get("fieldId"),map.get("fileName"),response).get("filePath");
            if(StringUtils.isNotBlank(filePath)){
                map.put("filePath",filePath);
                return map;
            }
        }
        map = new HashMap<String,String>();
        map.put("filePath","");
        return map;
    }

    @ResponseBody
    @RequestMapping(value = "/updateSubmitStatus",method = RequestMethod.POST)
    public Integer updateSubmitStatus(String rowId,String ppId,TCsTaskCompletion tCsTaskCompletion){
        return sf30_057Service.updateSubmitStatus(rowId,ppId,tCsTaskCompletion);
    }
}
