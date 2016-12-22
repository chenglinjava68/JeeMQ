package com.stripcode.web.common;


import com.stripcode.core.util.excelUtil.ImportExcel;
import com.stripcode.mybatis.cs.model.TCsTaskCompletion;
import com.stripcode.mybatis.cs.model.TSysCommonattached;
import com.stripcode.service.cs.TSysCommonattachedService;
import com.stripcode.service.sf.SF30_022Service;
import com.stripcode.web.file.FileUploadController;
import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * Created by Metro 2016/10/27.
 */
@Controller
@RequestMapping("/forum")
public class InvestmentController {

    private final org.apache.logging.log4j.Logger logger = LogManager.getLogger();
    @Autowired
    private TSysCommonattachedService tSysCommonattachedService;
    @Resource
    private FileUploadController fileUploadController;
    @Autowired
    private SF30_022Service SF30_022Service;
    @RequestMapping("/caOperWebService")
    public String caOperWebService(String xmlString, String filePath,String type,HttpServletResponse response) throws Exception {
        String result = "NONE";
        Properties properties = new Properties();
        properties.load(InvestmentController.class.getResourceAsStream("/config/investment.properties"));
        String[] webServices = properties.getProperty("ca.webService").split(",");
        // UM-421 赵瑶彬修改开始 2010-05-04
        logger.info("进入CA服务调用。");
        String endpoint = "";
        for (int i = 0; i < webServices.length; i++) {
            try {
                /* 建立请求服务框架实例 */
                Date d1 = new Date();
                org.apache.axis.client.Service service = new org.apache.axis.client.Service();
                /* 调用的web服务的url地址，这里是一个http请求，希望得到的结果是wsdl文档 */

                /* 调用的web服务的url地址，这里是一个http请求，希望得到的结果是wsdl文档 */
                /** *RM-064 CA不能运行，需要重新启动服务器 lee_solar 2010-1-5 start */
                // DMIS-1631 新店CA需要增加远程运算 端菊平 20150901 start
                if ("false".equals(properties.getProperty("ca.callmethod.islocal"))) {
                    // DMIS-1631 新店CA需要增加远程运算 端菊平 20150901 end
                    // 远程调用webservices
                    endpoint = properties.getProperty("ca.webservice.address") + webServices[i] + "/Service.asmx?wsdl";
                } else {
                    endpoint = "http://localhost/" + webServices[i] + "/Service.asmx?wsdl";
                }

                org.apache.axis.client.Call call = (org.apache.axis.client.Call) service.createCall();
                call.setTargetEndpointAddress(new java.net.URL(endpoint));
                call.setSOAPActionURI("http://www.yum.com/caForward");//caForward
                /* 设置需要调用的函数名称 */
                call.setOperationName(new javax.xml.namespace.QName("http://www.yum.com/", "caForward"));
                call.addParameter(new javax.xml.namespace.QName("http://www.yum.com/", "xmlstr"),
                        org.apache.axis.encoding.XMLType.XSD_STRING, javax.xml.rpc.ParameterMode.IN);
                call.setReturnType(org.apache.axis.encoding.XMLType.XSD_STRING);
                call.setTimeout(new Integer(60 * 60 * 1000));
                result = (String) call.invoke(new Object[]{xmlString});
                if (!result.equalsIgnoreCase("NONE")) {
                    Date d2 = new Date();
                    logger.info(" " + endpoint + " 服务调用成功，耗时 " + (d2.getTime() - d1.getTime()) + "毫 秒");
                    File file = new File(filePath);
                    if(file.exists()){
                        file.delete();
                    }
                    break;
                } else {
                    continue;
                }
            } catch (Exception e) {
                e.printStackTrace();
                logger.info(" " + endpoint + " 服务调用异常");
                logger.info(e.getMessage());
                continue;
            }
        }
        logger.info("退出CA服务调用。");
        response.setContentType("text/xml;charset=UTF-8");
        response.getWriter().write(result);
        response.getWriter().flush();
        response.getWriter().close();
        return null;
    }
    @RequestMapping("/xml")
    public String xml(HttpServletRequest request, HttpServletResponse response) throws  Exception{
        request.getRequestDispatcher(request.getParameter("xmlPath")).forward(request,response);
        return null;
    }

    @RequestMapping("/importExcel")
    @ResponseBody
    public Map importExcel(@RequestParam("file") CommonsMultipartFile file, TSysCommonattached tSysCommonattached, TCsTaskCompletion tCsTaskCompletion, String ppId, HttpServletRequest request, HttpServletResponse response) throws  Exception
    {
        HashMap map = new HashMap();
        if(!file.isEmpty()){
            HashMap attachMap = fileUploadController.imageUpload(file,tSysCommonattached,request,response);
            //excel数据入库
            ImportExcel ie = new ImportExcel();
            Map<String, Object> excelMap = null;
            try {
                InputStream is = file.getInputStream();
                excelMap = ie.readExcelContent(is);
                if(excelMap!=null)
                {
                    if((Boolean) excelMap.get("result")){
                        excelMap.put("ppId", ppId);
                        if(attachMap!=null)excelMap.put("attachId",attachMap.get("attachId"));
                        SF30_022Service.insertSFTrafficcount(excelMap,tCsTaskCompletion);
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
