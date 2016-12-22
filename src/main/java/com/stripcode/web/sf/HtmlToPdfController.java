package com.stripcode.web.sf;

import com.stripcode.core.util.UUIDUtils;
import com.stripcode.mybatis.cs.model.TSysCommonattached;
import com.stripcode.service.sf.HtmlToPdfService;
import com.stripcode.web.BaseController;
import com.stripcode.web.file.FileUploadController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Metro on 2016/10/12.
 */
@Controller
@RequestMapping("/HtmlToPdf")
public class HtmlToPdfController extends BaseController{
    @Resource
    private FileUploadController fileUploadController;

    BufferedWriter fw = null;

    HtmlToPdfService htmlToPdfService = new HtmlToPdfService();

    @RequestMapping(value = "/convertPPT",method = RequestMethod.GET)
    public void convertPPT(HttpServletRequest request, HttpServletResponse response){
        String path = request.getParameter("path");
        if(path == null || path.equals("")){
            return;
        }

        String pdfPathTemp = this.getClass().getResource("/").getFile().toString();
        String pdfPath = "C:/";
        String pdfName = "NewPage.pdf";

        if (htmlToPdfService.convert(path, pdfPath + "/" + pdfName)){
            try {
                response.sendRedirect(pdfPath + "/" + pdfName);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @RequestMapping(value = "/convertWord",method = RequestMethod.GET)
    public void convertWord(HttpServletRequest request, HttpServletResponse response){
        String path = request.getParameter("path");
        if(path == null || path.equals("")){
            return;
        }

        String pdfPath = "C:/";
        String pdfName = "hetong.pdf";

        if (htmlToPdfService.convertToWord(path, pdfPath + "/" + pdfName)){
            try {
                response.sendRedirect(pdfPath + "/" + pdfName);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @ResponseBody
    @RequestMapping(value = "/convertJM",method = RequestMethod.POST)
    public Map<String,Object> convertJM(String path,TSysCommonattached tSysCommonattached, HttpServletRequest request, HttpServletResponse response)throws  Exception{
        Map<String,Object> map = new HashMap<String,Object>();
        String pdfPath = "C:\\pdf";
        File dir = new File(pdfPath);
        if(!dir.exists()){
            dir.mkdirs();
        }
        String pdfName = UUIDUtils.generateKey()+".pdf";

        String existFilePath = pdfPath + "\\" + pdfName;
        String attachId = "";
        if (htmlToPdfService.convertJM(path, existFilePath)){
            try {
                /*File file = new File(path);
                if(file.exists()){
                    file.delete();
                }*/
                map = fileUploadController.upLoadExistFileToServer(existFilePath,true,tSysCommonattached,request,response);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return map;
    }

    @ResponseBody
    @RequestMapping(value = "/convertZY",method = RequestMethod.POST)
    public Map<String,Object> convertZY(String path,TSysCommonattached tSysCommonattached, HttpServletRequest request, HttpServletResponse response)throws  Exception{
        Map<String,Object> map = new HashMap<String,Object>();
        String pdfPath = "C:\\pdf";
        File dir = new File(pdfPath);
        if(!dir.exists()){
            dir.mkdirs();
        }
        String pdfName = UUIDUtils.generateKey()+".pdf";
        String existFilePath = pdfPath + "\\" + pdfName;
        String attachId = "";
        if (htmlToPdfService.convertZY(path, existFilePath)){
            try {
                map = fileUploadController.upLoadExistFileToServer(existFilePath,true,tSysCommonattached,request,response);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return map;
    }

    @ResponseBody
    @RequestMapping(value = "/convertZYPPT",method = RequestMethod.POST)
    public Map<String,Object> convertZYPPT(String path2,TSysCommonattached tSysCommonattached, HttpServletRequest request, HttpServletResponse response)throws  Exception{
        Map<String,Object> map = new HashMap<String,Object>();
        String pdfPath = "C:\\pdf";
        File dir = new File(pdfPath);
        if(!dir.exists()){
            dir.mkdirs();
        }
        String pdfName = UUIDUtils.generateKey()+".pdf";
        String existFilePath = pdfPath + "\\" + pdfName;
        String attachId = "";
        if (htmlToPdfService.convertZYPPT(path2, existFilePath)){
            try {
                map = fileUploadController.upLoadExistFileToServer(existFilePath,true,tSysCommonattached,request,response);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return map;
    }

}
