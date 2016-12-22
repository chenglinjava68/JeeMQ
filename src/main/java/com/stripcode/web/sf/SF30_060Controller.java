package com.stripcode.web.sf;

import com.stripcode.core.dto.sf.CreateLayoutDto;
import com.stripcode.core.util.WebUtil;
import com.stripcode.mybatis.cs.model.CSCustomerInfo;
import com.stripcode.mybatis.cs.model.TCsTaskCompletion;
import com.stripcode.mybatis.sf.model.*;
import com.stripcode.mybatis.user.model.RscSysUser;
import com.stripcode.service.cs.CS20_001Service;
import com.stripcode.service.sf.SF30_053Service;
import com.stripcode.service.sf.SF30_058Service;
import com.stripcode.service.sf.SF30_060Service;
import com.stripcode.service.user.RscSysUserService;
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
import java.util.List;
import java.util.Map;

/**
 * Created by Metro on 2016/10/17.
 */
@Controller
@RequestMapping("/SF30_060")
public class SF30_060Controller extends BaseController{
    @Autowired
    private SF30_060Service sf30_060Service;
    @Autowired
    private SF30_053Service sf30_053Service;
    @Autowired
    private SF30_058Service sf30_058Service;
    @Autowired
    private TCodeMacroDefineService tCodeMacroDefineService;
    @Autowired
    private RscSysUserService rscSysUserService;
    @Autowired
    private CS20_001Service cs20_001Service;
    /**
     * @param ppId 客户意向店ppId
     * @return 返回店铺Id
     */
    @ResponseBody
    @RequestMapping(value="/read/selectPipeline",method = RequestMethod.POST)
    public Map<String,Object> selectApplyPipeline(String ppId){
        Map<String,Object> map = new HashMap<String, Object>();
        SFDesignApply sfDesignApply1 = null;
        if(StringUtils.isNotBlank(ppId)) {
            sfDesignApply1 = sf30_060Service.selectDesignApply(ppId);
            map.put("main",sfDesignApply1);
        }
        return map;
    }
     @ResponseBody
    @RequestMapping(value="/read/selectPipelineCode",method = RequestMethod.POST)
    public Map<String,Object> selectApplyPipelineCode(String ppId,String customerId){
        Map<String,Object> map = new HashMap<String, Object>();
         List<SFFloorInfo> listFloor= sf30_060Service.selectFloor(ppId);
         List<SFDesignApplyAttachment> listDesignApplyAttachment = sf30_060Service.selectApplyAttachment(ppId);
        /* List<SFDesignApplyDetail> listDesignApplyDetail = sf30_060Service.selectApplyDetail(ppId);*/
         SFDesignApply sfDesignApply1 = null;
         if(StringUtils.isNotBlank(ppId)) {
             sfDesignApply1 = sf30_060Service.selectDesignApply(ppId);
             RscSysUser rscSysUser =  rscSysUserService.queryById(WebUtil.getCurrentUser());
             List<SFDesignApplyDetail> detailList = sf30_060Service.selectApplyDetail(ppId);
             CSCustomerInfo csCustomerInfo = cs20_001Service.queryById(customerId);
             if(sfDesignApply1==null){
                 sfDesignApply1 = new SFDesignApply();
                 sfDesignApply1.setRscSysUser(rscSysUser);
                 sfDesignApply1.setCsCustomerInfo(csCustomerInfo);
             }
             sfDesignApply1.setCsCustomerInfo(csCustomerInfo);
             sfDesignApply1.setRscSysUser(rscSysUser);
             map.put("main",sfDesignApply1);
         }
         map.put("listFloor",listFloor);
        /* map.put("listDesignApplyAttachment",listDesignApplyAttachment);*/
         /*map.put("listDesignApplyDetail",listDesignApplyDetail);*/
         map.put("AccessoryList",sf30_058Service.selectAccessoryList());
         List<SFLandlordLayout> sfLandlordLayout = sf30_053Service.selectHousePaperAll(ppId);
         map.put("sfLandList",sfLandlordLayout);
         map.put("codeList", tCodeMacroDefineService.selectForDesign());
        return map;
    }

    /**
     * 保存修改
      * @param request
     * @param response
     * @return ModelMap 返回前台具体信息和修改信息
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping(value = "/update",method = RequestMethod.POST)
    public Map update(TCsTaskCompletion csTaskCompletion, SFDesignApply sfDesignApply,CreateLayoutDto dto, HttpServletRequest request, HttpServletResponse response)throws Exception{
        return setSuccessModelMap(sf30_060Service.update(dto.getSfLandLord(),sfDesignApply,csTaskCompletion));
    }
}
