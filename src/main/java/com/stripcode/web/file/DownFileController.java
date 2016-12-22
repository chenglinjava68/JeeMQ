package com.stripcode.web.file;

import com.stripcode.core.util.Tools;
import com.stripcode.core.util.UUIDUtils;
import com.stripcode.web.BaseController;
import org.csource.common.MyException;
import org.csource.fastdfs.ClientGlobal;
import org.csource.fastdfs.StorageClient1;
import org.csource.fastdfs.TrackerClient;
import org.csource.fastdfs.TrackerServer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * 文件下载Controller
 * @author Metro
 * @version 2016-10-11
 */
@Controller
public class DownFileController extends BaseController {
    protected Logger logger = LoggerFactory.getLogger(DownFileController.class);
    /**
     * 文件下载调用
     * @param fieldId
     * @param fileName
     */
    @RequestMapping(value = "downfile")
    public void downloadByApi(String fieldId,String fileName, HttpServletResponse response) throws IOException, MyException {
        //初始化连接
        ClientGlobal.init(Tools.getClassPath() + "fdfs_client.conf");
        logger.info("network_timeout=" + ClientGlobal.g_network_timeout + "ms");
        logger.info("charset=" + ClientGlobal.g_charset);
        TrackerClient tracker = new TrackerClient();
        TrackerServer trackerServer = tracker.getConnection();
        if (trackerServer == null) {
            return;
        }
        StorageClient1 client = new StorageClient1(trackerServer, null);
        //调用下载方法
        byte[] bytes = client.download_file1(fieldId);
        if(bytes == null){
            return;
        }
        logger.info("length:"+bytes.length);
        //设置返回头
        response.setHeader("Content-disposition",
                "attachment; filename="+fileName);
        //文件流输出
        OutputStream os = response.getOutputStream();
        os.write(bytes);
        os.close();
    }

    @RequestMapping(value = "downloadFileToPath")
    @ResponseBody
    public Map<String,String> downloadFileToPath(String attachId,String fieldId,String fileName, HttpServletResponse response) throws Exception {
        Map<String,String> map = new HashMap<String,String>();
        //初始化连接
        Properties properties = new Properties();
        properties.load(DownFileController.class.getResourceAsStream("/fdfs_client.conf"));
        ClientGlobal.init(Tools.getClassPath() + "fdfs_client.conf");
        logger.info("network_timeout=" + ClientGlobal.g_network_timeout + "ms");
        logger.info("charset=" + ClientGlobal.g_charset);
        TrackerClient tracker = new TrackerClient();
        TrackerServer trackerServer = tracker.getConnection();
        if (trackerServer == null) {
            return null;
        }
        StorageClient1 client = new StorageClient1(trackerServer, null);
        //调用下载方法
        byte[] bytes = client.download_file1(fieldId);
        //文件流输出
        String filePath = Tools.getRootPath()+properties.getProperty("model.dir");
        File dir = new File(filePath);
        if(!dir.exists()){
            dir.mkdirs();
        }
        File file  = new File(dir,attachId+fileName.substring(fileName.indexOf(".")));
        if(!file.exists()){
            file.createNewFile();
        }
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        if(bytes == null){
            map.put("httpCode","500");
            map.put("msg","文件内容不能为空，请重新上传文件！");
            return map;
        }
        fileOutputStream.write(bytes);
        fileOutputStream.flush();
        fileOutputStream.close();
        map.put("filePath",file.getPath());
        return map ;
    }
    @RequestMapping("/writeToFile")
    @ResponseBody
    public Map<String,Object> writeToFile(String str1, String str2) throws  Exception{
        Map<String,Object> map = new HashMap<String, Object>();
        String filePath = "C:\\html";
        File dir = new File(filePath);
        if(!dir.exists()){
            dir.mkdirs();
        }
        File file1 = new File(dir,UUIDUtils.generateKey()+".html");
        File file2 = new File(dir,UUIDUtils.generateKey()+".html");
        FileOutputStream fileOutputStream1 = new FileOutputStream(file1);
        FileOutputStream fileOutputStream2 = new FileOutputStream(file2);
        OutputStreamWriter writerStream1 = new OutputStreamWriter(fileOutputStream1,"UTF-8");
        OutputStreamWriter writerStream2 = new OutputStreamWriter(fileOutputStream2,"UTF-8");
        BufferedWriter writer1 = new BufferedWriter(writerStream1);
        BufferedWriter writer2 = new BufferedWriter(writerStream2);
        writer1.write(str1);
        writer2.write(str2);
        writer1.flush();
        writer2.flush();
        writer1.close();
        writer2.close();
        /*fileOutputStream1.write(str1.getBytes());
        fileOutputStream2.write(str2.getBytes());
        fileOutputStream1.flush();
        fileOutputStream2.flush();
        fileOutputStream1.close();
        fileOutputStream2.close();*/
        map.put("path",file1.getPath());
        map.put("path2",file2.getPath());
        return map;
    }
}
