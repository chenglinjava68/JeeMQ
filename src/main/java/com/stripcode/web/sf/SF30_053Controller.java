package com.stripcode.web.sf;

import com.stripcode.core.dto.sf.CreateLayoutDto;
import com.stripcode.core.util.WebUtil;
import com.stripcode.mybatis.cs.model.TCsTaskCompletion;
import com.stripcode.mybatis.sf.model.SFLandlordLayout;
import com.stripcode.service.sf.SF30_004Service;
import com.stripcode.service.sf.SF30_053Service;
import com.stripcode.service.user.TCodeMacroDefineService;
import com.stripcode.web.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Metro on 2016/9/27.
 */
@Controller
@RequestMapping("/SF30_053")
public class SF30_053Controller extends BaseController{
    @Autowired
    private SF30_053Service sf30_053Service;
    @Autowired
    private TCodeMacroDefineService tCodeMacroDefineService;
    @Autowired
    private SF30_004Service sf30_004Service;

    /**
     * 查询图纸列表
      * @param ppId  客户意向店ppId
     * @return 返回图纸具体信息
     */
    @ResponseBody
    @RequestMapping(value="/read/selectAll",method = RequestMethod.POST)
    public Map<String,Object> details(String ppId,String customerId){
        Map<String,Object> map = new HashMap<String, Object>();
        List<SFLandlordLayout> sfLandlordLayout = sf30_053Service.selectHousePaperAll(ppId);
        map.put("codeList",tCodeMacroDefineService.selectForHousePaper());
        map.put("main",sfLandlordLayout);
        map.put("baseTable",sf30_004Service.selectBasePipeline(ppId,customerId));
        return map;
    }
    /**
     * 保存修改信息
      * @param dto 集合对象
     * @param request 接收前台的参数
     * @return Map
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping(value = "/update",method = RequestMethod.POST)
    public Map update(String ppId,TCsTaskCompletion csTaskCompletion,CreateLayoutDto dto,HttpServletRequest request)throws Exception{
        Map<String,Object> map = WebUtil.getParameterMap(request);
        return setSuccessModelMap(sf30_053Service.update(dto.getSfLandLord(),csTaskCompletion,ppId));
    }
}
