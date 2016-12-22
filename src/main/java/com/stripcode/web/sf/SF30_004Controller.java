package com.stripcode.web.sf;

import com.stripcode.mybatis.cs.model.CSSfPipeline;
import com.stripcode.mybatis.sf.model.SFPipelinePausePermination;
import com.stripcode.service.sf.SF30_004Service;
import com.stripcode.web.BaseController;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Metro on 2016/9/26.
 */
@Controller
@RequestMapping("/SF30_004")
public class SF30_004Controller extends BaseController {
    @Autowired
    private SF30_004Service sf30_004Service;

    /**
     * 查询列表
     *
     * @param ppId     客户意向店ppId
     * @param request
     * @param response
     * @return 基本信息列表 CSSfPipeline
     */
    @ResponseBody
    @RequestMapping(value = "/read/baseList", method = RequestMethod.POST)
    public CSSfPipeline selectBasePipeline(String ppId,String customerId ,HttpServletRequest request, HttpServletResponse response) {
        return sf30_004Service.selectBasePipeline(ppId,customerId);
    }

    /**
     * 意向店信息
     *
     * @param ppId 意向店ppId
     * @return Map
     */
    @ResponseBody
    @RequestMapping(value = "/read/selectPipelinePause", method = RequestMethod.POST)
    public Map<String, Object> details(String ppId) {
        Map<String, Object> map = new HashMap<String, Object>();
        if (StringUtils.isNotBlank(ppId)) {
            SFPipelinePausePermination sfPipelinePausePermination = sf30_004Service.selectPipeline(ppId);
            map.put("main", sfPipelinePausePermination);
        }
        return map;
    }

    /**
     * 意向店终止
     *
     * @param ppId 客户意向店ppId
     * @return 终止具体信息
     */
    @ResponseBody
    @RequestMapping(value = "/read/selectPipelineStop", method = RequestMethod.POST)
    public Map<String, Object> selectPipelineStop(String ppId) {
        Map<String, Object> map = new HashMap<String, Object>();
        if (StringUtils.isNotBlank(ppId)) {
            SFPipelinePausePermination sfPipelinePausePermination = sf30_004Service.selectPipelineStop(ppId);
            map.put("main", sfPipelinePausePermination);
        }
        return map;
    }

    @ResponseBody
    @RequestMapping(value = "/PipelineStopUpdate", method = RequestMethod.POST)
    public Map UpdatePipelineStop(SFPipelinePausePermination sfPipelinePausePermination, HttpServletRequest request, HttpServletResponse response) throws Exception {
        return setSuccessModelMap(sf30_004Service.updatePipeline(sfPipelinePausePermination));
    }

    /**
     * 保存修改
     * @param sfPipelinePausePermination 意向店暂停实体
     * @param ppId                       客户意向店PpId
     * @param request                    接收前台参数
     * @param response
     * @return Map
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public Map update(SFPipelinePausePermination sfPipelinePausePermination, String ppId, HttpServletRequest request, HttpServletResponse response) throws Exception {
        return setSuccessModelMap(sf30_004Service.update(sfPipelinePausePermination, ppId));
    }

    /**
     * 意向店恢复
     * @param ppId     意向店暂停实体
     * @param itemType 意向店类型
     * @return 意向店暂停信息
     */
    @ResponseBody
    @RequestMapping(value = "/updateStatusRestorePipeline", method = RequestMethod.POST)
    public Map StatusRestorePipeline(String ppId, String itemType) {
        return setSuccessModelMap(sf30_004Service.updateStatusRestorePipeline(ppId, itemType));
    }
}
