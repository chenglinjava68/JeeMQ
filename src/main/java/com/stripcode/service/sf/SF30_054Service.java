package com.stripcode.service.sf;

import com.stripcode.core.util.UUIDUtils;
import com.stripcode.mybatis.cs.model.TCsTaskCompletion;
import com.stripcode.mybatis.sf.dao.SFProgressEstMapper;
import com.stripcode.mybatis.sf.model.SFProgressEst;
import com.stripcode.service.BaseService;
import com.stripcode.service.cs.TCsTaskCompletionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Metro on 2016/9/28.
 */
@Service
@CacheConfig(cacheNames = "sfProgressPaper")
public class SF30_054Service extends BaseService {
    @Autowired
    private SFProgressEstMapper sfProgressEstMapper;
    @Autowired
    private TCsTaskCompletionService tCsTaskCompletionService;
    //查询
    public List<SFProgressEst> selectProgressAll(String ppId){
        return sfProgressEstMapper.selectProgressAll(ppId);
    }
    //查询直营
    public List<SFProgressEst> selectProgressNew(String ppId){
        return sfProgressEstMapper.selectProgressNew(ppId);
    }
    //查询合伙人
    public List<SFProgressEst> selectProgressAdd(String ppId){
        return sfProgressEstMapper.selectProgressAdd(ppId);
    }
    //保存
    public Map update(Map<String,Object> map,TCsTaskCompletion csTaskCompletion){
        Map modelMap = new HashMap();
        //定义是否成功 用于判断
        boolean result = true;
        //定义后台返回数据
        String message = "保存成功";
        Integer IsExist = 0;
        int count = -1;
        String [] ppId =null;
        String [] remark =null;
        try{
            ppId =  (String []) map.get("ppId");
        }catch(Exception e){
            ppId = new String[1];
            ppId[0] = (String)map.get("ppId");
        }
        try{
            remark =  (String []) map.get("remark");
        }catch(Exception e){
            remark = new String[1];
            remark[0] = (String)map.get("remark");
        }
        String [] taskCode =  (String []) map.get("taskCode");
        String [] estDate =  (String []) map.get("estDate");
        String [] actualDate =  (String []) map.get("actualDate");
        String [] delay = (String []) map.get("delay");
        if(remark==null||remark.length==0){
            remark = new String[0];
        }
        if(taskCode==null||taskCode.length==0){
            taskCode = new String[0];
        }
        if(estDate==null||estDate.length==0){
            estDate = new String[0];
        }
               if(delay==null||delay.length==0){
            delay = new String[0];
        }

        List<SFProgressEst> list = new ArrayList<SFProgressEst>();
        for(int i=0;i<ppId.length;i++){
            SFProgressEst sfProgressEst = new SFProgressEst();
            sfProgressEst.setRowId(UUIDUtils.generateKey());
            sfProgressEst.setRemark(remark[i]);
            if(!delay[i].equals("")) {
                sfProgressEst.setDelay(Integer.parseInt(delay[i]));
            }
            sfProgressEst.setPpId(ppId[i]);
            sfProgressEst.setActualDate(actualDate[i]);
            sfProgressEst.setEstDate(estDate[i]);
            sfProgressEst.setTaskCode(taskCode[i]);
            list.add(sfProgressEst);
        }
        for(SFProgressEst sfProgressEst :list){
            IsExist = sfProgressEstMapper.isExistsProgressEst(sfProgressEst.getTaskCode(),sfProgressEst.getPpId());
            if(IsExist ==0){
                count = sfProgressEstMapper.insertProgressEst(sfProgressEst);
            }else {
                count = sfProgressEstMapper.updateProgressEst(sfProgressEst);
            }
        }
        if(count!=1 ){
            result = false;
            message = "保存失败!";
        }
        csTaskCompletion.setRowId(UUIDUtils.generateKey());
        csTaskCompletion.setCreateTime(null);
        csTaskCompletion.setOptimauthId(ppId[0]);
        tCsTaskCompletionService.upateStatusToFinished(csTaskCompletion);
        tCsTaskCompletionService.updatePipelineType(csTaskCompletion.getTaskId(),ppId[0]);
        modelMap.put("result", result);
        modelMap.put("message", message);
        return modelMap;
    }
}
