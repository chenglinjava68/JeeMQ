package com.stripcode.service.act;

import com.stripcode.core.dto.common.ProcessDefCache;
import com.stripcode.core.util.Page;
import com.stripcode.core.util.WebUtil;
import com.stripcode.mybatis.act.Act;
import org.activiti.engine.FormService;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.repository.ProcessDefinitionQuery;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.activiti.engine.task.TaskQuery;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Metro on 2016/12/5.
 */
@Service
@Transactional(readOnly = true)
public class ActTaskService {

    @Autowired
    private RepositoryService repositoryService;
    @Autowired
    private FormService formService;
    @Autowired
    private RuntimeService runtimeService;
    @Autowired
    private TaskService taskService;
    /**
     * 日志对象
     */
    protected Logger logger = LoggerFactory.getLogger(ActTaskService.class);
    /**
     * 获取流程列表
     * @param category 流程分类
     */
    public Page<ProcessDefinition> processList(Page<ProcessDefinition> page, String category) {
		/*
		 * 保存两个对象，一个是ProcessDefinition（流程定义），一个是Deployment（流程部署）
		 */
        ProcessDefinitionQuery processDefinitionQuery = repositoryService.createProcessDefinitionQuery()
                .latestVersion().active().orderByProcessDefinitionKey().asc();

        if (StringUtils.isNotEmpty(category)){
            processDefinitionQuery.processDefinitionCategory(category);
        }

        page.setCount(processDefinitionQuery.count());

        List<ProcessDefinition> processDefinitionList = processDefinitionQuery.listPage(page.getFirstResult(), page.getMaxResults());
        page.setList(processDefinitionList);
        /*for (ProcessDefinition processDefinition : processDefinitionList) {
            String deploymentId = processDefinition.getDeploymentId();
            Deployment deployment = repositoryService.createDeploymentQuery().deploymentId(deploymentId).singleResult();
            page.getList().add(new Object[]{processDefinition,deployment});
        }*/
        return page;
    }


    /**
     * 获取流程列表
     * @param category 流程分类
     */
    public List<ProcessDefinition> processListd(String category) {
		/*
		 * 保存两个对象，一个是ProcessDefinition（流程定义），一个是Deployment（流程部署）
		 */
        ProcessDefinitionQuery processDefinitionQuery = repositoryService.createProcessDefinitionQuery()
                .latestVersion().active().orderByProcessDefinitionKey().asc();

        if (StringUtils.isNotEmpty(category)){
            processDefinitionQuery.processDefinitionCategory(category);
        }

        //page.setCount(processDefinitionQuery.count());

        List<ProcessDefinition> processDefinitionList = processDefinitionQuery.list();

        return processDefinitionList;
    }
    /**
     * 获取流程表单（首先获取任务节点表单KEY，如果没有则取流程开始节点表单KEY）
     * @return
     */
    public String getFormKey(String procDefId, String taskDefKey){
        String formKey = "";
        if (StringUtils.isNotBlank(procDefId)){
            if (StringUtils.isNotBlank(taskDefKey)){
                try{
                    formKey = formService.getTaskFormKey(procDefId, taskDefKey);
                }catch (Exception e) {
                    formKey = "";
                }
            }
            if (StringUtils.isBlank(formKey)){
                formKey = formService.getStartFormKey(procDefId);
            }
            if (StringUtils.isBlank(formKey)){
                formKey = "/404";
            }
        }
        logger.debug("getFormKey: {}", formKey);
        return formKey;
    }

    /**
     * 获取流程实例对象
     * @param procInsId
     * @return
     */
    @Transactional(readOnly = false)
    public ProcessInstance getProcIns(String procInsId) {
        return runtimeService.createProcessInstanceQuery().processInstanceId(procInsId).singleResult();
    }



    /**
     * 获取待办列表
     * @param
     * @return
     */
    public List<Act> todoList(Act act){
        //String userId = UserUtils.getUser().getLoginName();//ObjectUtils.toString(UserUtils.getUser().getId());
        String userId= WebUtil.getCurrentUser();
        List<Act> result = new ArrayList<Act>();

        // =============== 已经签收的任务  ===============
        TaskQuery todoTaskQuery = taskService.createTaskQuery().taskAssignee(userId).active()
                .includeProcessVariables().orderByTaskCreateTime().desc();

        // 设置查询条件
        if (StringUtils.isNotBlank(act.getProcDefKey())){
            todoTaskQuery.processDefinitionKey(act.getProcDefKey());
        }
        if (act.getBeginDate() != null){
            todoTaskQuery.taskCreatedAfter(act.getBeginDate());
        }
        if (act.getEndDate() != null){
            todoTaskQuery.taskCreatedBefore(act.getEndDate());
        }

        // 查询列表
        List<Task> todoList = todoTaskQuery.list();
        for (Task task : todoList) {
            Act e = new Act();
            e.setTask(task);
            e.setVars(task.getProcessVariables());
//			e.setTaskVars(task.getTaskLocalVariables());
//			System.out.println(task.getId()+"  =  "+task.getProcessVariables() + "  ========== " + task.getTaskLocalVariables());
            e.setProcDef(ProcessDefCache.get(task.getProcessDefinitionId()));
//			e.setProcIns(runtimeService.createProcessInstanceQuery().processInstanceId(task.getProcessInstanceId()).singleResult());
//			e.setProcExecUrl(ActUtils.getProcExeUrl(task.getProcessDefinitionId()));
            e.setStatus("todo");
            result.add(e);
        }

        // =============== 等待签收的任务  ===============
        TaskQuery toClaimQuery = taskService.createTaskQuery().taskCandidateUser(userId)
                .includeProcessVariables().active().orderByTaskCreateTime().desc();

        // 设置查询条件
        if (StringUtils.isNotBlank(act.getProcDefKey())){
            toClaimQuery.processDefinitionKey(act.getProcDefKey());
        }
        if (act.getBeginDate() != null){
            toClaimQuery.taskCreatedAfter(act.getBeginDate());
        }
        if (act.getEndDate() != null){
            toClaimQuery.taskCreatedBefore(act.getEndDate());
        }

        // 查询列表
        List<Task> toClaimList = toClaimQuery.list();
        for (Task task : toClaimList) {
            Act e = new Act();
            e.setTask(task);
            e.setVars(task.getProcessVariables());
//			e.setTaskVars(task.getTaskLocalVariables());
//			System.out.println(task.getId()+"  =  "+task.getProcessVariables() + "  ========== " + task.getTaskLocalVariables());
            e.setProcDef(ProcessDefCache.get(task.getProcessDefinitionId()));
//			e.setProcIns(runtimeService.createProcessInstanceQuery().processInstanceId(task.getProcessInstanceId()).singleResult());
//			e.setProcExecUrl(ActUtils.getProcExeUrl(task.getProcessDefinitionId()));
            e.setStatus("claim");
            result.add(e);
        }
        return result;
    }


    public List<Act> todoListact(Act act,String sysuser){
        String userId = sysuser;//ObjectUtils.toString(UserUtils.getUser().getId());

        List<Act> result = new ArrayList<Act>();

        // =============== 已经签收的任务  ===============
        TaskQuery todoTaskQuery = taskService.createTaskQuery().taskAssignee(userId).active()
                .includeProcessVariables().orderByTaskCreateTime().desc();

        // 设置查询条件
        if (StringUtils.isNotBlank(act.getProcDefKey())){
            todoTaskQuery.processDefinitionKey(act.getProcDefKey());
        }
        if (act.getBeginDate() != null){
            todoTaskQuery.taskCreatedAfter(act.getBeginDate());
        }
        if (act.getEndDate() != null){
            todoTaskQuery.taskCreatedBefore(act.getEndDate());
        }

        // 查询列表
        List<Task> todoList = todoTaskQuery.list();
       // List<Task> tasksd = taskService.createTaskQuery().taskCandidateOrAssigned("thinkgem").listPage(1, 10);
        for (Task task : todoList) {
            Act e = new Act();
            e.setTask(task);
            e.setVars(task.getProcessVariables());
//			e.setTaskVars(task.getTaskLocalVariables());
//			System.out.println(task.getId()+"  =  "+task.getProcessVariables() + "  ========== " + task.getTaskLocalVariables());
            String defid = task.getProcessDefinitionId();
            e.setProcDef(ProcessDefCache.get(task.getProcessDefinitionId()));
//			e.setProcIns(runtimeService.createProcessInstanceQuery().processInstanceId(task.getProcessInstanceId()).singleResult());
//			e.setProcExecUrl(ActUtils.getProcExeUrl(task.getProcessDefinitionId()));
            e.setStatus("todo");
            result.add(e);
        }

        // =============== 等待签收的任务  ===============
        TaskQuery toClaimQuery = taskService.createTaskQuery().taskCandidateUser(userId)
                .includeProcessVariables().active().orderByTaskCreateTime().desc();

        // 设置查询条件
        if (StringUtils.isNotBlank(act.getProcDefKey())){
            toClaimQuery.processDefinitionKey(act.getProcDefKey());
        }
        if (act.getBeginDate() != null){
            toClaimQuery.taskCreatedAfter(act.getBeginDate());
        }
        if (act.getEndDate() != null){
            toClaimQuery.taskCreatedBefore(act.getEndDate());
        }

        // 查询列表
        List<Task> toClaimList = toClaimQuery.list();
        for (Task task : toClaimList) {
            Act e = new Act();
            e.setTask(task);
            e.setVars(task.getProcessVariables());
//			e.setTaskVars(task.getTaskLocalVariables());
//			System.out.println(task.getId()+"  =  "+task.getProcessVariables() + "  ========== " + task.getTaskLocalVariables());
            e.setProcDef(ProcessDefCache.get(task.getProcessDefinitionId()));
//			e.setProcIns(runtimeService.createProcessInstanceQuery().processInstanceId(task.getProcessInstanceId()).singleResult());
//			e.setProcExecUrl(ActUtils.getProcExeUrl(task.getProcessDefinitionId()));
            e.setStatus("claim");
            result.add(e);
        }
        return result;
    }


}
