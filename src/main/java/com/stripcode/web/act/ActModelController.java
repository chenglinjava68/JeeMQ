package com.stripcode.web.act;

import com.stripcode.core.util.Page;
import com.stripcode.mybatis.common.JQGridObject;
import com.stripcode.service.act.ActModelService;
import org.activiti.engine.RepositoryService;
import org.csource.common.MyException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;

/**
 * Created by Metro on 2016/11/29.
 */
@Controller
@RequestMapping(value = "actModel")
public class ActModelController {
    @Autowired
    private ActModelService actModelService;
    @Autowired
    RepositoryService rep;
    /**
     * 日志对象
     */
    protected Logger logger = LoggerFactory.getLogger(ActModelController.class);
    /**
     * 创建模型
     */
    @RequestMapping(value = "/createbpm", method = RequestMethod.POST)
    @ResponseBody
    public HashMap create(String name, String key, String description, String category,
                       HttpServletRequest request, HttpServletResponse response) {
        HashMap map = new HashMap();
        try {
            org.activiti.engine.repository.Model modelData = actModelService.create(name, key, description, category);
            map.put("modelId",modelData.getId());
            map.put("code","200");
            //response.sendRedirect("http://127.0.0.1:8084/jeesite/act/process-editor/modeler.jsp?modelId=" + modelData.getId());
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("创建模型失败：", e);
            map.put("code","400");
            map.put("msg","创建模型失败");
        }
        return  map;
    }




    /**
     * 流程模型列表
     */
    @RequestMapping(value = "/getbpmnlist", method = RequestMethod.GET)
    @ResponseBody
    public JQGridObject modelList(String category, HttpServletRequest request, HttpServletResponse response) {
        HashMap map = new HashMap();
        Page<org.activiti.engine.repository.Model> Page = actModelService.modelList(
                new Page<org.activiti.engine.repository.Model>(request, response), category);
        return new JQGridObject(Page);
    }

   /*
   *流程部署
   * */
  /*  @RequestMapping(value = "/deploy")
    @ResponseBody
    public HashMap deploy(String id, RedirectAttributes redirectAttributes) {
        HashMap map = new HashMap();
        String message = actModelService.deploy(id);
        map.put("message", message);
        map.put("code","200");
        return map;
    }*/

    @RequestMapping(value = "/deploy",method = RequestMethod.GET)
    @ResponseBody
    public HashMap deploy(String id, RedirectAttributes redirectAttributes) {
        HashMap map = new HashMap();
        String message = actModelService.deploy(id);
        map.put("message", message);
        map.put("code","200");
        return map;
    }
    //文件上传方式启动流程
    @RequestMapping(value = "uploadworkflow", method = RequestMethod.POST)
    @ResponseBody
    public HashMap fileupload(@RequestParam("uploadfile") CommonsMultipartFile uploadfile, HttpServletRequest request, HttpServletResponse response) throws IOException, MyException {
        HashMap map = new HashMap();
        try{
            MultipartFile file=uploadfile;
            String filename=file.getOriginalFilename();
            InputStream is=file.getInputStream();
            rep.createDeployment().addInputStream(filename, is).deploy();
            map.put("code","200");
        }catch(Exception e){
            e.printStackTrace();
            map.put("code","400");
        }
       return map;
    }

}
