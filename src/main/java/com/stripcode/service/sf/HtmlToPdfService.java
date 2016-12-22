package com.stripcode.service.sf;

import com.alibaba.dubbo.config.annotation.Service;
import com.stripcode.core.util.HtmlToPdfInterceptor;
import org.springframework.cache.annotation.CacheConfig;

import java.io.File;
/**
 * Created by Metro on 2016/10/12.
 */
@Service
@CacheConfig(cacheNames = "HtmlToPdf")
public class HtmlToPdfService{
    /*获取程序在系统中的位置*/
    private static final String toPdfTool = "C:\\wkhtmltopdf.exe";

    public boolean convert(String srcPath,String destPath){
        File file = new File(destPath);
        File parent = file.getParentFile();
        //如果pdf保存路径不存在，则创建路径
        if(!parent.exists()){
            parent.mkdirs();
        }
        StringBuilder cmd = new StringBuilder();
        cmd.append(toPdfTool);
        cmd.append(" ");
        cmd.append("--page-height"+" "+"190.5"+" ");
        cmd.append("--page-width"+" "+"254"+" ");
        cmd.append("--disable-smart-shrinking"+" ");
        cmd.append("--margin-bottom"+" "+"0"+" ");
        cmd.append("--margin-left"+" "+"5"+" ");
        cmd.append("--margin-right"+" "+"0"+" ");
        cmd.append("--margin-top"+" "+"4"+" ");
        cmd.append("\""+srcPath+"\"");
        cmd.append(" ");
        cmd.append("\""+destPath+"\"");

        boolean result = true;
        try{
            Process process;
            process = Runtime.getRuntime().exec(cmd.toString());
            HtmlToPdfInterceptor error = new HtmlToPdfInterceptor(process.getErrorStream());
            HtmlToPdfInterceptor output = new HtmlToPdfInterceptor(process.getInputStream());
            error.start();
            output.start();
            process.waitFor();
        }catch(Exception e){
            result = false;
            e.printStackTrace();
        }
        return result;
    }

    public boolean convertToWord(String srcPath,String destPath){
        File file1 = new File(destPath);
        File parent;
        parent = file1.getParentFile();
        //如果pdf保存路径不存在，则创建路径
        if(!parent.exists()){
            parent.mkdirs();
        }
        StringBuilder cmd = new StringBuilder();
        cmd.append(toPdfTool);
        cmd.append(" ");
        cmd.append("--header-html"+" ");
        cmd.append("header.html"+" ");
        cmd.append("--footer-html"+" ");
        cmd.append("footer.html"+" ");
        cmd.append("--disable-smart-shrinking"+" ");
        cmd.append("-L"+" "+"19"+" "+"-R"+" "+"30"+" "+"-T"+" "+"21"+" "+"-B"+" "+"22"+" ");
        cmd.append("\""+srcPath+"\"");
        cmd.append(" ");
        cmd.append("\""+destPath+"\"");

        boolean result = true;
        Process process;
        try{
            process = Runtime.getRuntime().exec(cmd.toString());
            HtmlToPdfInterceptor error = new HtmlToPdfInterceptor(process.getErrorStream());
            HtmlToPdfInterceptor output = new HtmlToPdfInterceptor(process.getInputStream());
            error.start();
            output.start();
            process.waitFor();
        }catch(Exception e){
            result = false;
            e.printStackTrace();
        }
        return result;
    }

    public boolean convertJM(String srcPath,String destPath){
        File file = new File(destPath);
        File parent = file.getParentFile();
        //如果pdf保存路径不存在，则创建路径
        if(!parent.exists()){
            parent.mkdirs();
        }
        StringBuilder cmd = new StringBuilder();
        cmd.append(toPdfTool);
        cmd.append(" ");
        cmd.append("--disable-smart-shrinking");
        cmd.append(" ");
        cmd.append("\""+srcPath+"\"");
        cmd.append(" ");
        cmd.append("\""+destPath+"\"");

        boolean result = true;
        Process process;
        try{
            process = Runtime.getRuntime().exec(cmd.toString());
            HtmlToPdfInterceptor error = new HtmlToPdfInterceptor(process.getErrorStream());
            HtmlToPdfInterceptor output = new HtmlToPdfInterceptor(process.getInputStream());
            error.start();
            output.start();
            process.waitFor();
        }catch(Exception e){
            result = false;
            e.printStackTrace();
        }
        return result;
    }

    public boolean convertZY(String srcPath,String destPath){
        File file = new File(destPath);
        File parent = file.getParentFile();
        //如果pdf保存路径不存在，则创建路径
        if(!parent.exists()){
            parent.mkdirs();
        }
        StringBuilder cmd = new StringBuilder();
        cmd.append(toPdfTool);
        cmd.append(" ");
        cmd.append("--disable-smart-shrinking");
        cmd.append(" ");
        cmd.append("\""+srcPath+"\"");
        cmd.append(" ");
        cmd.append("\""+destPath+"\"");

        boolean result = true;
        Process process;
        try{
            process = Runtime.getRuntime().exec(cmd.toString());
            HtmlToPdfInterceptor error = new HtmlToPdfInterceptor(process.getErrorStream());
            HtmlToPdfInterceptor output = new HtmlToPdfInterceptor(process.getInputStream());
            error.start();
            output.start();
            process.waitFor();
        }catch(Exception e){
            result = false;
            e.printStackTrace();
        }
        return result;
    }

    public boolean convertZYPPT(String srcPath,String destPath){
        File file = new File(destPath);
        File parent = file.getParentFile();
        //如果pdf保存路径不存在，则创建路径
        if(!parent.exists()){
            parent.mkdirs();
        }
        StringBuilder cmd = new StringBuilder();
        cmd.append(toPdfTool);
        cmd.append(" ");
        cmd.append("--dpi"+" "+"96"+" ");
        cmd.append("--page-height"+" "+"190.5"+" "+"--page-width"+" "+"254"+" ");
        cmd.append("--disable-smart-shrinking"+" "+"-B"+" "+"0"+" "+"-L"+" "+"0"+" "+"-R"+" "+"0"+" "+"-T"+" "+"0");
        cmd.append(" ");
        cmd.append("\""+srcPath+"\"");
        cmd.append(" ");
        cmd.append("\""+destPath+"\"");

        boolean result = true;
        Process process;
        try{
            process = Runtime.getRuntime().exec(cmd.toString());
            HtmlToPdfInterceptor error = new HtmlToPdfInterceptor(process.getErrorStream());
            HtmlToPdfInterceptor output = new HtmlToPdfInterceptor(process.getInputStream());
            error.start();
            output.start();
            process.waitFor();
        }catch(Exception e){
            result = false;
            e.printStackTrace();
        }
        return result;
    }
}
