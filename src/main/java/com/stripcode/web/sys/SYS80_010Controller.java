package com.stripcode.web.sys;

import com.github.pagehelper.PageInfo;
import com.stripcode.core.util.WebUtil;
import com.stripcode.mybatis.common.JQGridObject;
import com.stripcode.mybatis.sys.model.TSysTask;
import com.stripcode.service.sys.SYS80_010Service;
import com.stripcode.service.sys.SYS80_011Service;
import com.stripcode.web.BaseController;
import org.activiti.bpmn.model.BpmnModel;
import org.activiti.engine.HistoryService;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.history.HistoricActivityInstance;
import org.activiti.engine.impl.RepositoryServiceImpl;
import org.activiti.engine.impl.persistence.entity.ProcessDefinitionEntity;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.image.impl.DefaultProcessDiagramGenerator;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

/**
 * Created by Metro on 2016/12/02.
 */
@Controller
@RequestMapping("/SYS80_010")
public class SYS80_010Controller extends BaseController{
    @Autowired
    private SYS80_010Service sys80_010Service;
    @Autowired
    private SYS80_011Service sys80_011Service;
    @Autowired
    RepositoryService rep;
    @Autowired
    RuntimeService runservice;
    @Autowired
    HistoryService histiryservice;
    /**
     * 查询列表数据
     * @param request
     * @param response
     * @return
     */
    @ResponseBody
    @RequestMapping(value="/read/list",method = RequestMethod.POST)
    public JQGridObject list(HttpServletRequest request, HttpServletResponse response){
        Map<String, Object> params = WebUtil.getParameterMap(request);
        PageInfo<TSysTask> list =sys80_010Service.queryForPage(params);
        return  new JQGridObject(list);
    }


    @RequestMapping(value = "/traceprocess",method = RequestMethod.GET)
    @ResponseBody
    public void traceprocess(@RequestParam("executionid") String executionid,HttpServletRequest request, HttpServletResponse response) throws Exception{
        ProcessInstance process=runservice.createProcessInstanceQuery().processInstanceId(executionid).singleResult();
        BpmnModel bpmnmodel=rep.getBpmnModel(process.getProcessDefinitionId());
        List<String> activeActivityIds=runservice.getActiveActivityIds(executionid);
        DefaultProcessDiagramGenerator gen=new DefaultProcessDiagramGenerator();
        // 获得历史活动记录实体（通过启动时间正序排序，不然有的线可以绘制不出来）
        List<HistoricActivityInstance> historicActivityInstances = histiryservice
                .createHistoricActivityInstanceQuery().executionId(executionid)
                .orderByHistoricActivityInstanceStartTime().asc().list();
        // 计算活动线
        List<String> highLightedFlows = sys80_011Service.getHighLightedFlows(
                (ProcessDefinitionEntity) ((RepositoryServiceImpl) rep)
                        .getDeployedProcessDefinition(process.getProcessDefinitionId()),
                historicActivityInstances);

        InputStream in=gen.generateDiagram(bpmnmodel, "png", activeActivityIds,highLightedFlows,1.0);
        //InputStream in=gen.generateDiagram(bpmnmodel, "png", activeActivityIds);
        ServletOutputStream output = response.getOutputStream();
        IOUtils.copy(in, output);
    }

}
