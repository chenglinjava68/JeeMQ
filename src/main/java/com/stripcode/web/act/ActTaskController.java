package com.stripcode.web.act;

import com.stripcode.mybatis.act.Act;
import com.stripcode.service.act.ActTaskService;
import com.stripcode.service.act.ActUtils;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.repository.ProcessDefinition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Metro on 2016/11/29.
 */
@Controller
@RequestMapping(value = "actTackModel")
public class ActTaskController {
    @Autowired
    private ActTaskService actTaskService;
    @Autowired
    RepositoryService rep;
    /**
     * 日志对象
     */
    protected Logger logger = LoggerFactory.getLogger(ActTaskController.class);
    /**
     * 获取流程列表
     * @param category 流程分类
     */
   /* @RequestMapping(value = "/process", method = RequestMethod.GET)
    @ResponseBody
    public ActObject processList(String category, HttpServletRequest request, HttpServletResponse response) {

        Page<ProcessDefinition> page = new Page<ProcessDefinition>(request, response);
        page = actTaskService.processList(page, category);
        return new ActObject(page);

    }*/
    /**
     * 获取流程列表
     * @param category 流程分类
     */
    @RequestMapping(value = "/process", method = RequestMethod.GET)
    @ResponseBody
    public List<ProcessDefinition> processListd(String category) {
        List<ProcessDefinition> page = actTaskService.processListd(category);
        return page;
    }

    /*
    * 获取流程表单
    * */
    @RequestMapping(value = "/form", method = RequestMethod.GET)
    @ResponseBody
    public String form(Act act, HttpServletRequest request){
        // 获取流程XML上的表单KEY
        String formKey = actTaskService.getFormKey(act.getProcDefId(), act.getTaskDefKey());
        // 获取流程实例对象
        if (act.getProcInsId() != null){
            if(actTaskService.getProcIns(act.getProcInsId())!=null){
                act.setProcIns(actTaskService.getProcIns(act.getProcInsId()));
            }else{
                //act.setFinishedProcIns(actTaskService.getFinishedProcIns(act.getProcInsId()));
            }

        }
        return "redirect:" + ActUtils.getFormUrl(formKey, act);
    }


    @RequestMapping(value = "/todo", method = RequestMethod.GET)
    @ResponseBody
    public HashMap todoList(Act act, HttpServletResponse response) throws Exception {
        HashMap map = new HashMap();
        List<Act> list = actTaskService.todoList(act);
        map.put("list", list);
        return map;
    }

    @RequestMapping(value = "/todoact", method = RequestMethod.GET)
    @ResponseBody
    public HashMap todoListd(Act act,String sysuser ,HttpServletResponse response) throws Exception {
        HashMap map = new HashMap();
        List<Act> list = actTaskService.todoListact(act,sysuser);
        map.put("list", list);
        return map;
    }
}
