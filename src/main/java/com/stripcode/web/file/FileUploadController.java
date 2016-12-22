package com.stripcode.web.file;

import com.stripcode.core.util.DateUtil;
import com.stripcode.core.util.Tools;
import com.stripcode.mybatis.cs.model.TSysCommonattached;
import com.stripcode.service.cs.TSysCommonattachedService;
import com.stripcode.web.BaseController;
import org.apache.commons.lang3.StringUtils;
import org.csource.common.MyException;
import org.csource.common.NameValuePair;
import org.csource.fastdfs.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;


/**
 * 上传文件到文件服务器
 * @author Metro
 * @return
 * @throws IOException
 * @throws IllegalStateException
 */
@Controller
public class FileUploadController extends BaseController {
    protected Logger logger = LoggerFactory.getLogger(FileUploadController.class);
    @Autowired
    private TSysCommonattachedService tSysCommonattachedService;
    @ResponseBody
    @RequestMapping(value = "/fileUpload",method= RequestMethod.POST)
    public HashMap imageUpload(@RequestParam("file") CommonsMultipartFile file,TSysCommonattached  tSysCommonattached, HttpServletRequest request, HttpServletResponse response) throws IOException, MyException{
        HashMap map = new HashMap();
        //初始化连接
        ClientGlobal.init(Tools.getClassPath() + "fdfs_client.conf");
        TrackerClient tracker = new TrackerClient();
        TrackerServer trackerServer = tracker.getConnection();
        StorageServer storageServer = null;
        StorageClient1 client = new StorageClient1(trackerServer, storageServer);
        // 判断文件是否为空,支持断点续传
        if (!file.isEmpty()) {
            byte[] fileBuff = file.getBytes();
            String tempFileName = file.getOriginalFilename();
            String fileExtName = tempFileName.substring(tempFileName.lastIndexOf(".")+1);
            //设置元信息
            NameValuePair[] metaList = new NameValuePair[3];
            metaList[0] = new NameValuePair("fileName", tempFileName);
            metaList[1] = new NameValuePair("fileExtName", fileExtName);
            metaList[2] = new NameValuePair("fileLength", String.valueOf(file.getSize()));
            // 文件上传到fastdfs
            String fileId = client.upload_file1(fileBuff,fileExtName, metaList);
            //将返回fileId保存到业务数据库中
            //项目组自己实现   调用对应的入口service
            tSysCommonattached.setFilePath(fileId);
            tSysCommonattached.setCreateDate(DateUtil.getDate());
            tSysCommonattached.setModifyDate(DateUtil.getDate());
            tSysCommonattached.setFileSize(String.valueOf(fileBuff.length));
            tSysCommonattached.setFileType(fileExtName);
            tSysCommonattached.setDocName(tempFileName);
            map = tSysCommonattachedService.update(tSysCommonattached);
            if(map.get("result") !=null){
                map.put("fileId",fileId);
                map.put("fileName",tempFileName);
                map.put("attachId",tSysCommonattached.getAttachId());
                map.put("versionNo",tSysCommonattached.getVersionNo());
                logger.info(fileId);//调式用
            }
            return map;
        }else {
            map.put("error","上传失败");
        }
        return map;
    }
    @ResponseBody
    @RequestMapping(value = "/fileUploadNew",method= RequestMethod.POST)
    public HashMap uploadFile(@RequestParam("file") CommonsMultipartFile file,TSysCommonattached  tSysCommonattached, HttpServletRequest request, HttpServletResponse response) throws IOException, MyException{
        HashMap map = new HashMap();
        //初始化连接
        ClientGlobal.init(Tools.getClassPath() + "fdfs_client.conf");
        TrackerClient tracker = new TrackerClient();
        TrackerServer trackerServer = tracker.getConnection();
        StorageServer storageServer = null;
        StorageClient1 client = new StorageClient1(trackerServer, storageServer);
        // 判断文件是否为空,支持断点续传
        if (!file.isEmpty()) {
            byte[] fileBuff = file.getBytes();
            String tempFileName = file.getOriginalFilename();
            String fileExtName = tempFileName.substring(tempFileName.lastIndexOf(".")+1);
            //设置元信息
            NameValuePair[] metaList = new NameValuePair[3];
            metaList[0] = new NameValuePair("fileName", tempFileName);
            metaList[1] = new NameValuePair("fileExtName", fileExtName);
            metaList[2] = new NameValuePair("fileLength", String.valueOf(file.getSize()));
            // 文件上传到fastdfs
            String fileId = client.upload_file1(fileBuff,fileExtName, metaList);
            //将返回fileId保存到业务数据库中
            //项目组自己实现   调用对应的入口service
            if(StringUtils.isNotBlank(fileId)){
                tSysCommonattached.setFilePath(fileId);
                tSysCommonattached.setCreateDate(DateUtil.getDate());
                tSysCommonattached.setModifyDate(DateUtil.getDate());
                tSysCommonattached.setFileSize(String.valueOf(fileBuff.length));
                tSysCommonattached.setFileType(fileExtName);
                tSysCommonattached.setDocName(tempFileName);
                tSysCommonattached.setIsTemplete("M0013");
                map = tSysCommonattachedService.updateByVersionNo(tSysCommonattached);
                if(map.get("result") !=null){
                    map.put("fileId",fileId);
                    map.put("fileSize",String.valueOf(fileBuff.length));
                    map.put("fileType",fileExtName);
                    map.put("fileName",tempFileName);
                    map.put("attachId",tSysCommonattached.getAttachId());
                    map.put("versionNo",tSysCommonattached.getVersionNo());
                    map.put("attach",map.get("attach"));
                    logger.info(fileId);//调式用
                }
            }
            return map;
        }else {
            map.put("error","上传失败");
        }
        return map;
    }
    @ResponseBody
    @RequestMapping(value = "/fileUploadw",method= RequestMethod.POST)
    public HashMap imageUploadw(HttpServletRequest request, HttpServletResponse response, String  file) throws IOException, MyException{
        HashMap map = new HashMap();
        map.put("file",file);
        return map;
    }

    @ResponseBody
    @RequestMapping(value = "/upLoadExistFileToServer",method= RequestMethod.POST)
    public HashMap upLoadExistFileToServer(String existFilePath,boolean isDel,TSysCommonattached tSysCommonattached, HttpServletRequest request, HttpServletResponse response) throws IOException, MyException{
        HashMap map = new HashMap();
        //初始化连接
        ClientGlobal.init(Tools.getClassPath() + "fdfs_client.conf");
        TrackerClient tracker = new TrackerClient();
        TrackerServer trackerServer = tracker.getConnection();
        StorageServer storageServer = null;
        StorageClient1 client = new StorageClient1(trackerServer, storageServer);
        // 判断文件是否为空,支持断点续传
        File file = new File(existFilePath);
        if (file.exists()) {
            FileInputStream fileInputStream = new FileInputStream(file);
            byte[] fileBuff=new byte[fileInputStream.available()];
           fileInputStream.read(fileBuff);
            String tempFileName = file.getName();
            String fileExtName = tempFileName.substring(tempFileName.lastIndexOf(".")+1);
            //设置元信息
            NameValuePair[] metaList = new NameValuePair[3];
            metaList[0] = new NameValuePair("fileName", tempFileName);
            metaList[1] = new NameValuePair("fileExtName", fileExtName);
            metaList[2] = new NameValuePair("fileLength", String.valueOf(file.length()));
            // 文件上传到fastdfs
            String fileId = client.upload_file1(fileBuff,fileExtName, metaList);
            //将返回fileId保存到业务数据库中
            //项目组自己实现   调用对应的入口service
            tSysCommonattached.setFilePath(fileId);
            tSysCommonattached.setCreateDate(DateUtil.getDate());
            tSysCommonattached.setModifyDate(DateUtil.getDate());
            tSysCommonattached.setFileSize(String.valueOf(fileBuff.length));
            tSysCommonattached.setFileType(fileExtName);
            tSysCommonattached.setDocName(tempFileName);
            map = tSysCommonattachedService.update(tSysCommonattached);
            if(map.get("result") !=null){
                map.put("fileId",fileId);
                map.put("fileName",tempFileName);
                map.put("attachId",tSysCommonattached.getAttachId());
                map.put("versionNo",tSysCommonattached.getVersionNo());
                logger.info(fileId);//调式用
                if(isDel){
                    if(file.exists()){
                        file.delete();
                    }
                }
            }
            return map;
        }else {
            map.put("error","上传失败");
        }
        return map;
    }
}
