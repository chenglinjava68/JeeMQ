package com.stripcode.web.sf;

import com.stripcode.mybatis.cs.model.TCsTaskCompletion;
import com.stripcode.mybatis.sf.model.SFRentalProposalAttachment;
import com.stripcode.mybatis.sf.model.SFRentalProposalCopartnerStore;
import com.stripcode.service.cs.CS20_001Service;
import com.stripcode.service.sf.SF30_075Service;
import com.stripcode.service.user.TCodeMacroDefineService;
import com.stripcode.web.BaseController;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Metro on 2016/11/15.
 */
@Controller
@RequestMapping("/SF30_075")
public class SF30_075Controller extends BaseController{
    @Autowired
    private SF30_075Service sf30_075Service;
    @Autowired
    private CS20_001Service cs20_001Service;

    @Autowired
    private TCodeMacroDefineService tCodeMacroDefineService;

    /**
     * 查询租金和客户信息
     * @param ppId 意向店ppId
     * @param customerId 客户Id
     * @return 客户信息和租金提案具体信息
     */
    @ResponseBody
    @RequestMapping(value="/read/selectSFRentalProposal",method = RequestMethod.POST)
    public Map<String,Object> details(String ppId,String customerId){
        Map<String,Object> map = new HashMap<String, Object>();
        if(StringUtils.isNotBlank(ppId)){
            SFRentalProposalCopartnerStore SFRentalProposalCopartnerStore = sf30_075Service.selectProposal(ppId);
            map.put("main",SFRentalProposalCopartnerStore);
            map.put("codeList",tCodeMacroDefineService.selectForRenStore());
        }
        return map;
    }
    /**
     * 查询租金列表
     * @return Map集合，前台展示附件具体信息
     */
    @ResponseBody
    @RequestMapping(value="/read/selectAttachment",method = RequestMethod.POST)
    public Map<String,Object> selectAttachment(String ppId){
        Map<String,Object> map = new HashMap<String, Object>();
        List<SFRentalProposalAttachment> sfRentalProposalAttachmentList =sf30_075Service.selectAttachment(ppId);
        map.put("main",sfRentalProposalAttachmentList);
        return map ;
    }

    /**
     * 保存修改
     * @param sfRentalProposalCopartnerStore 租金提案实体
     * @param sfRentalProposalAttachment 附件实体
     * @return Map 用于前台展示具体信息
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping(value = "/update",method = RequestMethod.POST)
    public Map update(TCsTaskCompletion csTaskCompletion,SFRentalProposalCopartnerStore sfRentalProposalCopartnerStore,SFRentalProposalAttachment sfRentalProposalAttachment)throws Exception{
        return setSuccessModelMap(sf30_075Service.save(sfRentalProposalAttachment,sfRentalProposalCopartnerStore,csTaskCompletion));
    }
}
