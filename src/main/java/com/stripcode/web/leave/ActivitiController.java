package com.stripcode.web.leave;

import com.google.common.collect.Maps;
import com.stripcode.core.util.WebUtil;
import com.stripcode.mybatis.leave.model.LeaveApply;
import com.stripcode.service.leave.LeaveService;
import org.activiti.engine.runtime.ProcessInstance;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Metro on 2016/11/28.
 */
@Controller
public class ActivitiController {
    private final static Logger LOGGER = LoggerFactory.getLogger(ActivitiController.class);
    @Autowired
    LeaveService leaveservice;
    @RequestMapping(value="/startleave",method= RequestMethod.POST)
    @ResponseBody
    public HashMap start_leave(LeaveApply apply, HttpSession session){
        HashMap map = new HashMap();
        String userid= WebUtil.getCurrentUser();
        Map<String,Object> variables=new HashMap<String, Object>();
        variables.put("applyuserid", userid);
        ProcessInstance ins=leaveservice.startWorkflow(apply, userid, variables);
        LOGGER.debug("--------流程id---------"+ins.getId()+"-------已启动--------");
        System.out.println("流程id"+ins.getId()+"已启动");
        map.put("code","200");
        return map;
    }

    /**
     * 启动请假流程
     * @param leave
     */
    @RequestMapping(value = "saveleave", method = RequestMethod.POST)
    @ResponseBody
    public HashMap save(LeaveApply leave) {
        HashMap map = new HashMap();
        try {
            Map<String, Object> variables = Maps.newHashMap();
            leaveservice.save(leave, variables);
            map.put("msg","请假申请已经提交");
            map.put("code","200");
        } catch (Exception e) {
            LOGGER.info("启动请假流程失败：", e);
            map.put("msg","系统内部错误！");
        }
        return  map;
    }
}
