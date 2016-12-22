package com.stripcode.service.sf;

import com.stripcode.core.util.DataUtil;
import com.stripcode.core.util.UUIDUtils;
import com.stripcode.core.util.excelUtil.ExportExcel;
import com.stripcode.mybatis.cs.model.TCsTaskCompletion;
import com.stripcode.mybatis.sf.dao.SFLandlordNegotiationMapper;
import com.stripcode.mybatis.sf.model.SFLandlordNegotiation;
import com.stripcode.service.cs.TCsTaskCompletionService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Metro
 */
@Service
@CacheConfig(cacheNames = "SF30_009Service")
public class SF30_009Service {
    @Autowired
    private SFLandlordNegotiationMapper sfLandlordNegotiationMapper;

    @Autowired
    private TCsTaskCompletionService tCsTaskCompletionService;

    public List<SFLandlordNegotiation> queryNegotiation(String ppId){
        return sfLandlordNegotiationMapper.queryNegotiation(ppId);
    }

    public SFLandlordNegotiation queryNegotiationInfo(String ppId,String rowId){
        return sfLandlordNegotiationMapper.queryNegotiationInfo(ppId,rowId);
    }

    public Map<String,Object> update(SFLandlordNegotiation model, TCsTaskCompletion tCsTaskCompletion){
        Map<String,Object> map = new HashMap<String,Object>();
        Boolean result = true;
        String message = "保存成功!";
        Integer count = -1;
        if(StringUtils.isBlank(model.getRowId())){
            model.setRowId(UUIDUtils.generateKey());
            count = sfLandlordNegotiationMapper.insertNegotiation(model);
        }else {
            count = sfLandlordNegotiationMapper.updateNegotiation(model);
        }

        if(count==0){
            result = false;
            message = "保存失败!";
        }
        //更新节点状态
        tCsTaskCompletion.setRowId(UUIDUtils.generateKey());
        tCsTaskCompletion.setCreateTime(null);
        tCsTaskCompletion.setOptimauthId(model.getPpId());
        tCsTaskCompletionService.upateStatusToFinished(tCsTaskCompletion);
        tCsTaskCompletionService.updatePipelineType(tCsTaskCompletion.getTaskId(),tCsTaskCompletion.getOptimauthId());
        map.put("rowId",model.getRowId());
        map.put("result",result);
        map.put("message",message);
        return map;
    }

    public void export(String ppId, HttpServletRequest request, HttpServletResponse response) {
        try {
            List<SFLandlordNegotiation> data = sfLandlordNegotiationMapper.queryNegotiation(ppId);
            String fileName = "业主谈判记录"+ DataUtil.getDate("yyyyMMddHHmmss")+".xlsx";
            new ExportExcel("业主谈判记录", SFLandlordNegotiation.class).setDataList(data).write(response, fileName).dispose();
        } catch (Exception e) {

        }
    }
}
