package com.stripcode.service.sys;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.stripcode.core.util.PageSortUtil;
import com.stripcode.core.util.UUIDUtils;
import com.stripcode.core.util.WebUtil;
import com.stripcode.mybatis.sf.dao.SFSfApprovalMapper;
import com.stripcode.mybatis.sf.model.SFSfApproval;
import com.stripcode.mybatis.user.dao.RscSysUserMapper;
import com.stripcode.mybatis.user.dao.TCodeMacroDefineMapper;
import com.stripcode.mybatis.user.model.RscSysUser;
import com.stripcode.mybatis.user.model.TCodeMacroDefine;
import com.stripcode.service.BaseService;
import org.activiti.engine.HistoryService;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.history.HistoricActivityInstance;
import org.activiti.engine.impl.persistence.entity.ProcessDefinitionEntity;
import org.activiti.engine.impl.pvm.PvmTransition;
import org.activiti.engine.impl.pvm.process.ActivityImpl;
import org.activiti.spring.ProcessEngineFactoryBean;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Metro on 2016/12/12.
 */
@Service
@CacheConfig(cacheNames = "sFSfApproval")
public class SYS80_011Service extends BaseService{
    @Autowired
    private ProcessEngineFactoryBean processEngine;
    @Autowired
    private HistoryService historyService;
    @Autowired
    private SFSfApprovalMapper sFSfApprovalMapper;
    @Autowired
    private TCodeMacroDefineMapper tCodeMacroDefineMapper;
    @Autowired
    private SFSfApprovalMapper approvalMapper;
    @Autowired
    private RscSysUserMapper rscSysUserMapper;
    @Autowired
    private RuntimeService runtimeService;
    @Autowired
    private RepositoryService repositoryService;
    @Autowired
    private TaskService taskservice;

    public List<TCodeMacroDefine> selectRadioList() {
        return tCodeMacroDefineMapper.selectAgreeRefuleList();
    }

    public List<SFSfApproval> queryByTaskId(String taskId) {
        return sFSfApprovalMapper.queryByTaskId(taskId);
    }

    /**
     * 列表带分页的查询数据
     * @param params
     * @return
     */
    public PageInfo<SFSfApproval> queryForPage(Map<String,Object> params){
        PageSortUtil.unoinSortBySord(params);
        PageHelper.startPage(params);
        String taskId = params.get("taskId")+"";
        return new PageInfo<SFSfApproval>(approvalMapper.queryByTaskId(taskId));
    }

    @Transactional
    public Map update(SFSfApproval sfSfApproval)throws Exception{
        String userid = WebUtil.getCurrentUser();
        RscSysUser rscSysUser= rscSysUserMapper.selectByPrimaryKey(userid);
        Map<String,Object> variables=new HashMap<String,Object>();
        Map modelMap = new HashMap();
        //保存或修改是否成功
        boolean result = true;
        //返回到前台的提示信息
        String message ="保存成功！";
        sfSfApproval.setApprover(rscSysUser.getUserName());
        if (StringUtils.isBlank(sfSfApproval.getRowId())){
            sfSfApproval.setRowId(UUIDUtils.generateKey());
            approvalMapper.insert(sfSfApproval);
        }else{
            approvalMapper.update(sfSfApproval);
        }
        modelMap.put("result", result);
        modelMap.put("message", message);

        /****************************/
        variables.put("deptLeaderPass", true);
        taskservice.complete(sfSfApproval.getOaTaskId(), variables);
        return modelMap;
    }

    public List<String> getHighLightedFlows(
            ProcessDefinitionEntity processDefinitionEntity,
            List<HistoricActivityInstance> historicActivityInstances) {

        List<String> highFlows = new ArrayList<String>();// 用以保存高亮的线flowId
        for (int i = 0; i < historicActivityInstances.size(); i++) {// 对历史流程节点进行遍历
            ActivityImpl activityImpl = processDefinitionEntity
                    .findActivity(historicActivityInstances.get(i)
                            .getActivityId());// 得 到节点定义的详细信息
            List<ActivityImpl> sameStartTimeNodes = new ArrayList<ActivityImpl>();// 用以保存后需开始时间相同的节点
            if ((i + 1) >= historicActivityInstances.size()) {
                break;
            }
            ActivityImpl sameActivityImpl1 = processDefinitionEntity
                    .findActivity(historicActivityInstances.get(i + 1)
                            .getActivityId());// 将后面第一个节点放在时间相同节点的集合里
            sameStartTimeNodes.add(sameActivityImpl1);
            for (int j = i + 1; j < historicActivityInstances.size() - 1; j++) {
                HistoricActivityInstance activityImpl1 = historicActivityInstances
                        .get(j);// 后续第一个节点
                HistoricActivityInstance activityImpl2 = historicActivityInstances
                        .get(j + 1);// 后续第二个节点
                if (activityImpl1.getStartTime().equals(
                        activityImpl2.getStartTime())) {// 如果第一个节点和第二个节点开始时间相同保存
                    ActivityImpl sameActivityImpl2 = processDefinitionEntity
                            .findActivity(activityImpl2.getActivityId());
                    sameStartTimeNodes.add(sameActivityImpl2);
                } else {// 有不相同跳出循环
                    break;
                }
            }
            List<PvmTransition> pvmTransitions = activityImpl
                    .getOutgoingTransitions();// 取出节点的所有出去的线
            for (PvmTransition pvmTransition : pvmTransitions) {// 对所有的线进行遍历
                ActivityImpl pvmActivityImpl = (ActivityImpl) pvmTransition
                        .getDestination();// 如果取出的线的目标节点存在时间相同的节点里，保存该线的id，进行高亮显示
                if (sameStartTimeNodes.contains(pvmActivityImpl)) {
                    highFlows.add(pvmTransition.getId());
                }
            }
        }
        return highFlows;
    }



    /**
     * 读取带跟踪的图片
     * @param executionId	环节ID
     * @return	封装了各种节点信息
     */
    /*public InputStream tracePhoto(String processDefinitionId, String executionId) {
        // ProcessInstance processInstance = runtimeService.createProcessInstanceQuery().processInstanceId(executionId).singleResult();
        BpmnModel bpmnModel = repositoryService.getBpmnModel(processDefinitionId);

        List<String> activeActivityIds = Lists.newArrayList();
        if (runtimeService.createExecutionQuery().executionId(executionId).count() > 0){
            activeActivityIds = runtimeService.getActiveActivityIds(executionId);
        }

        List<String> highLightedFlows  = Lists.newArrayList();
        // 获得历史活动记录实体（通过启动时间正序排序，不然有的线可以绘制不出来）
        List<HistoricActivityInstance> historicActivityInstances = historyService
                .createHistoricActivityInstanceQuery().executionId(executionId)
                .orderByHistoricActivityInstanceStartTime().asc().list();
        // 计算活动线
        highLightedFlows = this.getHighLightedFlows((ProcessDefinitionEntity) ((RepositoryServiceImpl) repositoryService)
                .getDeployedProcessDefinition(processDefinitionId),historicActivityInstances);

        // 不使用spring请使用下面的两行代码
        //	 ProcessEngineImpl defaultProcessEngine = (ProcessEngineImpl)ProcessEngines.getDefaultProcessEngine();
        //	 Context.setProcessEngineConfiguration(defaultProcessEngine.getProcessEngineConfiguration());

        // 使用spring注入引擎请使用下面的这行代码
        Context.setProcessEngineConfiguration(processEngine.getProcessEngineConfiguration());

        DefaultProcessDiagramGenerator processDiagramGeneratornew = new DefaultProcessDiagramGenerator();
        //return processDiagramGeneratornew.generateDiagram(bpmnModel, "png", activeActivityIds);
        return processDiagramGeneratornew.generateDiagram(bpmnModel, "png",
                activeActivityIds, highLightedFlows,
                processEngine.getProcessEngineConfiguration().getActivityFontName(),
                processEngine.getProcessEngineConfiguration().getLabelFontName(),
                processEngine.getProcessEngineConfiguration().getClassLoader(), 1.0);
    }*/
}
