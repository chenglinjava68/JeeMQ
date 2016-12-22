package com.stripcode.service.sf;

import com.stripcode.core.util.UUIDUtils;
import com.stripcode.core.util.WebUtil;
import com.stripcode.mybatis.cs.model.TCsTaskCompletion;
import com.stripcode.mybatis.sf.dao.SFApplyPipelineCodeMapper;
import com.stripcode.mybatis.sf.model.SFApplyPipelineCode;
import com.stripcode.mybatis.sys.dao.TSysTaskMapper;
import com.stripcode.mybatis.sys.model.TSysTask;
import com.stripcode.service.BaseService;
import com.stripcode.service.act.ActUtils;
import com.stripcode.service.cs.TCsTaskCompletionService;
import org.activiti.engine.IdentityService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.runtime.ProcessInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Metro on 2016/9/28.
 */
@Service
@CacheConfig(cacheNames = "sfApplyPipelineCode")
public class SF30_059Service extends BaseService {
    @Autowired
    private SFApplyPipelineCodeMapper sfApplyPipelineCodeMapper;
    @Autowired
    private TCsTaskCompletionService tCsTaskCompletionService;
    @Autowired
    private IdentityService identityservice;
    @Autowired
    private RuntimeService runtimeservice;
    @Autowired
    private TSysTaskMapper sysTaskMapper;
    //查询
    public SFApplyPipelineCode selectApplyPipelineCode(String ppId){
        return sfApplyPipelineCodeMapper.selectApplyPipelineCode(ppId);
    }
    //保存
    public Map update(TCsTaskCompletion csTaskCompletion,SFApplyPipelineCode sfApplyPipelineCode, Map<String, Object> variables){
        Map modelMap = new HashMap();
        //定义是否成功 用于判断
        boolean result = true;
        //定义后台返回数据
        String message = "保存成功";
        Integer IsExist = 0;
        int count = -1;
            IsExist = sfApplyPipelineCodeMapper.isExistsPipelineCode(sfApplyPipelineCode.getPpId());
        if(IsExist==0){
            if(sfApplyPipelineCode.getRowId()==null){
                sfApplyPipelineCode.setRowId(UUIDUtils.generateKey());
                count = sfApplyPipelineCodeMapper.insertPipelineCode(sfApplyPipelineCode);
            }
        }else{
            count= sfApplyPipelineCodeMapper.updatePipelineCode(sfApplyPipelineCode);
        }
        if(count!=1 ){
            result = false;
            message = "保存失败!";
        }
        csTaskCompletion.setRowId(UUIDUtils.generateKey());
        csTaskCompletion.setCreateTime(null);
        csTaskCompletion.setOptimauthId(sfApplyPipelineCode.getPpId());
        tCsTaskCompletionService.upateStatusToFinished(csTaskCompletion);
        tCsTaskCompletionService.updatePipelineType(csTaskCompletion.getTaskId(),sfApplyPipelineCode.getPpId());

        String userid= WebUtil.getCurrentUser();
        // 用来设置启动流程的人员ID，引擎会自动把用户ID保存到activiti:initiator中
        identityservice.setAuthenticatedUserId(userid);
        // 启动流程
        TSysTask task = new TSysTask();
        task.setRowId(UUIDUtils.generateKey());
        String businessKey = task.getRowId();
        variables.put("type", "leave");
        variables.put("busId", businessKey);
        //variables.put("title", sfApplyPipelineCode.getRemark());//设置原因，每个业务不一样；
        ProcessInstance processInstance = runtimeservice.startProcessInstanceByKey(ActUtils.PD_PIPLINE[0], businessKey, variables);
        task.setProcessId(processInstance.getId());
        task.setProcessInstance(processInstance);
        task.setTaskType("店铺ID申请");
        task.setBusinessId(sfApplyPipelineCode.getRowId());
        task.setTaskStatus("0");
        task.setApplicant(userid);
        sysTaskMapper.insert(task);//插入任务表

        modelMap.put("rowId",sfApplyPipelineCode.getRowId());
        modelMap.put("result", result);
        modelMap.put("message", message);
        return modelMap;
    }
}
