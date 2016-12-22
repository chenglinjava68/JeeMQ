package com.stripcode.web.sf;

import com.stripcode.mybatis.cs.model.TCsTaskCompletion;
import com.stripcode.mybatis.sf.model.SFLandlordInterest;
import com.stripcode.service.sf.SF30_016Service;
import com.stripcode.service.user.TCodeMacroDefineService;
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
 * Created by Metro on 2016/11/17.
 */
@Controller
@RequestMapping("/SF30_016")
public class SF30_016Controller extends BaseController{
    @Autowired
    private SF30_016Service sf30_016Service;
    @Autowired
    private TCodeMacroDefineService tCodeMacroDefineService;
    @ResponseBody
    @RequestMapping(value="/read/selectLoad",method = RequestMethod.POST)
    public Map<String,Object> selectLoad (String ppId){
        Map<String,Object> map = new HashMap<String,Object>();
        if(StringUtils.isNotBlank(ppId)){
            SFLandlordInterest sfLandlordInterest = sf30_016Service.selectLoad(ppId);
            map.put("main",sfLandlordInterest);
        }
        map.put("codeList", tCodeMacroDefineService.selectSFLandlordInterest());//查询列表下拉框
        return  map;
    }
    @ResponseBody
    @RequestMapping(value = "/update",method = RequestMethod.POST)
    public Map update(SFLandlordInterest sfLandlordInterest,TCsTaskCompletion csTaskCompletion, HttpServletRequest request, HttpServletResponse response)throws Exception{
        return setSuccessModelMap(sf30_016Service.update(sfLandlordInterest,csTaskCompletion));
    }
}
