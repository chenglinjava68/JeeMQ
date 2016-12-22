package com.stripcode.web.sf;

import com.stripcode.core.util.WebUtil;
import com.stripcode.mybatis.cs.model.TCsTaskCompletion;
import com.stripcode.mybatis.sf.model.SFProgressEst;
import com.stripcode.service.sf.SF30_054Service;
import com.stripcode.service.user.TCodeMacroDefineService;
import com.stripcode.web.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Metro on 2016/9/27.
 */
@Controller
@RequestMapping("/SF30_054")
public class SF30_054Controller extends BaseController{
    @Autowired
    private SF30_054Service sf30_054Service;
    @Autowired
    private TCodeMacroDefineService tCodeMacroDefineService;

    /**
     * 查询列表
     * @param ppId 客户意向店ppId
     * @return 返回预估项目列表
     */
     @ResponseBody
    @RequestMapping(value="/read/selectAll",method = RequestMethod.POST)
    public Map<String,Object> details(String ppId,String type){
        Map<String,Object> map = new HashMap<String, Object>();
         if(type.equals("M0065")){
             List<SFProgressEst> sfProgressEstList = sf30_054Service.selectProgressAll(ppId);
             map.put("main",sfProgressEstList);
         }
         if(type.equals("M0066")){
             List<SFProgressEst> sfProgressEstList = sf30_054Service.selectProgressNew(ppId);
             map.put("main",sfProgressEstList);
         }
         if(type.equals("M0067")){
             List<SFProgressEst> sfProgressEstList = sf30_054Service.selectProgressAdd(ppId);
             map.put("main",sfProgressEstList);
         }
        map.put("codeList",tCodeMacroDefineService.selectForProgress());
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
    public Map update(TCsTaskCompletion csTaskCompletion,HttpServletRequest request,HttpServletResponse response)throws Exception{
        Map<String,Object> map = WebUtil.getParameterMap(request);
        return setSuccessModelMap(sf30_054Service.update(map,csTaskCompletion));
    }
}
