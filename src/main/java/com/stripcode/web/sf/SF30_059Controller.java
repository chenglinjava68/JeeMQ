package com.stripcode.web.sf;

import com.google.common.collect.Maps;
import com.stripcode.mybatis.cs.model.TCsTaskCompletion;
import com.stripcode.mybatis.sf.model.SFApplyPipelineCode;
import com.stripcode.service.sf.SF30_059Service;
import com.stripcode.web.BaseController;
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
 * Created by Metro on 2016/10/17.
 */
@Controller
@RequestMapping("/SF30_059")
public class SF30_059Controller extends BaseController{
    @Autowired
    private SF30_059Service sf30_059Service;
    Map<String, Object> variables = Maps.newHashMap();
    /**
     * 查询erpCode和店铺Id
     * @param ppId 客户意向店ppId
     * @return 返回店铺Id
     */
     @ResponseBody
    @RequestMapping(value="/read/selectPipelineCode",method = RequestMethod.POST)
    public Map<String,Object> selectApplyPipelineCode(String ppId){
        Map<String,Object> map = new HashMap<String, Object>();
         SFApplyPipelineCode sFApplyPipelineCode = sf30_059Service.selectApplyPipelineCode(ppId);
        map.put("main",sFApplyPipelineCode);
        return map;
    }

    /**
     * 保存修改
      * @param request
     * @param response
     * @return Map 返回前台具体信息和修改信息
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping(value = "/update",method = RequestMethod.POST)
    public Map update(TCsTaskCompletion csTaskCompletion,SFApplyPipelineCode sfApplyPipelineCode,HttpServletRequest request,HttpServletResponse response)throws Exception{
        return setSuccessModelMap(sf30_059Service.update(csTaskCompletion,sfApplyPipelineCode, variables));
    }
}
