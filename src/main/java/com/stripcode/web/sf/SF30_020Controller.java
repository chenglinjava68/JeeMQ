package com.stripcode.web.sf;

import com.stripcode.mybatis.cs.model.TCsTaskCompletion;
import com.stripcode.mybatis.sf.model.SFRentalProposalDirectStore;
import com.stripcode.service.sf.SF30_020Service;
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
 * Created by Metro on 2016/11/10.
 */
@Controller
@RequestMapping("/SF30_020")
public class SF30_020Controller extends BaseController{
    @Autowired
    private SF30_020Service sf30_020Service;
    @Autowired
    private TCodeMacroDefineService tCodeMacroDefineService;
    /**
     * 查询列表
     * @param ppId 客户意向店ppId
     * @return 返回租金信息列表
     */
     @ResponseBody
    @RequestMapping(value="/read/selectAll",method = RequestMethod.POST)
    public Map<String,Object> details(String ppId){
         Map<String,Object> map = new HashMap<String, Object>();
         if(StringUtils.isNotBlank(ppId)) {
             SFRentalProposalDirectStore sFRentalProposalDirectStore =sf30_020Service.selectRenStoreAll(ppId);
             map.put("main",sFRentalProposalDirectStore);
         }
        map.put("codeList",tCodeMacroDefineService.selectForRenStore());
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
    public Map update(SFRentalProposalDirectStore sFRentalProposalDirectStore,TCsTaskCompletion csTaskCompletion,HttpServletRequest request,HttpServletResponse response)throws Exception{
        return setSuccessModelMap(sf30_020Service.update(sFRentalProposalDirectStore,csTaskCompletion));
    }
}
