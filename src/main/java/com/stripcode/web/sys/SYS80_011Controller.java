package com.stripcode.web.sys;

import com.github.pagehelper.PageInfo;
import com.stripcode.core.dto.CreateOrModifyApprovalDto;
import com.stripcode.core.util.WebUtil;
import com.stripcode.mybatis.common.JQGridObject;
import com.stripcode.mybatis.sf.model.SFSfApproval;
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
import org.activiti.image.ProcessDiagramGenerator;
import org.activiti.image.impl.DefaultProcessDiagramGenerator;
import org.activiti.spring.SpringProcessEngineConfiguration;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Metro on 2016/12/12.
 */
@Controller
@RequestMapping("/SYS80_011")
public class SYS80_011Controller extends BaseController{
    @Autowired
    private SYS80_011Service sys80_011Service;
    @Autowired
    RuntimeService runservice;
    @Autowired
    HistoryService histiryservice;
    @Autowired
    RepositoryService rep;
    @Autowired
    SpringProcessEngineConfiguration processEngineConfiguration;

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
        PageInfo<SFSfApproval> list =sys80_011Service.queryForPage(params);
        return  new JQGridObject(list);
    }

    /**
     * 查询任务列表按钮
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value = "/selectRadioList")
    @ResponseBody
    public Map selectRadioList(String taskId,HttpServletRequest request, HttpServletResponse response){
        Map map = new HashMap<String,Object>();
        List<SFSfApproval> list= sys80_011Service.queryByTaskId(taskId);
        if(list!=null && list.size()>0)
        {
            map.put("status",list.get(0).getStatus());
            map.put("comments",list.get(0).getComments());
        }
        map.put("radioList",sys80_011Service.selectRadioList());
        return map;
    }


    /*
    * 编辑
    * */
    @ResponseBody
    @RequestMapping(value = "/update",method = RequestMethod.POST)
    public Map update(@Valid CreateOrModifyApprovalDto dto, HttpServletResponse response)throws Exception{
        return setSuccessModelMap(sys80_011Service.update(dto.toModel()));
    }

    @RequestMapping(value = "/traceprocess",method = RequestMethod.GET)
    public void traceprocess(@RequestParam("processId") String processId,HttpServletRequest request, HttpServletResponse response) throws Exception{
        ProcessInstance process=runservice.createProcessInstanceQuery().processInstanceId(processId).singleResult();
        BpmnModel bpmnmodel=rep.getBpmnModel(process.getProcessDefinitionId());
        List<String> activeActivityIds=runservice.getActiveActivityIds(processId);
        DefaultProcessDiagramGenerator gen=new DefaultProcessDiagramGenerator();
        // 获得历史活动记录实体（通过启动时间正序排序，不然有的线可以绘制不出来）
        List<HistoricActivityInstance> historicActivityInstances = histiryservice
                .createHistoricActivityInstanceQuery().executionId(processId)
                .orderByHistoricActivityInstanceStartTime().asc().list();
        // 计算活动线
        List<String> highLightedFlows = sys80_011Service.getHighLightedFlows(
                (ProcessDefinitionEntity) ((RepositoryServiceImpl) rep)
                        .getDeployedProcessDefinition(process.getProcessDefinitionId()),
                historicActivityInstances);

        // InputStream in=gen.generateDiagram(bpmnmodel, "png", activeActivityIds,highLightedFlows,1.0);

        ProcessDiagramGenerator pdg = processEngineConfiguration.getProcessDiagramGenerator();
       /* InputStream inputStream = pdg.generateDiagram(bpmnmodel, "PNG", activeActivityIds, highLightedFlows,
                processEngineConfiguration.getProcessEngineConfiguration().getActivityFontName(),
                processEngineConfiguration.getProcessEngineConfiguration().getLabelFontName(),
                processEngineConfiguration.getProcessEngineConfiguration().getAnnotationFontName(),
                processEngineConfiguration.getProcessEngineConfiguration().getProcessEngineConfiguration().getClassLoader(), 1.0);*/

        InputStream inputStream = pdg.generateDiagram(bpmnmodel, "PNG", activeActivityIds, highLightedFlows,
                processEngineConfiguration.getProcessEngineConfiguration().getActivityFontName(),
                processEngineConfiguration.getProcessEngineConfiguration().getLabelFontName(),
                processEngineConfiguration.getProcessEngineConfiguration().getAnnotationFontName(),
                processEngineConfiguration.getProcessEngineConfiguration().getProcessEngineConfiguration().getClassLoader(), 1.0);

        //InputStream in=gen.generateDiagram(bpmnmodel, "png", activeActivityIds);
        response.setContentType("image/png");
       ServletOutputStream output = response.getOutputStream();
        IOUtils.copy(inputStream, output);;
        output.flush();
        output.close();
        inputStream.close();
    }


   /* @RequestMapping(value = "/traceprocess",method = RequestMethod.GET)
    @ResponseBody
    public void traceprocessd(@RequestParam("executionid") String executionid,HttpServletRequest request, HttpServletResponse response) throws Exception{
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



    *//**
     * 读取带跟踪的图片
     *//*
    @RequestMapping(value = "/trace/photo/{procDefId}/{execId}",method = RequestMethod.GET)
    @ResponseBody
    public void tracePhoto(@PathVariable("procDefId") String procDefId, @PathVariable("execId") String execId, HttpServletResponse response) throws Exception {
        InputStream imageStream = sys80_011Service.tracePhoto(procDefId, execId);

        // 输出资源内容到相应对象
        byte[] b = new byte[1024];
        int len;
        while ((len = imageStream.read(b, 0, 1024)) != -1) {
            response.getOutputStream().write(b, 0, len);
        }
    }*/
}
