package com.stripcode.web.sf;

import com.stripcode.core.dto.cs.CreateOrModifyCsTaskCompletionDto;
import com.stripcode.core.util.tree.GenerateTreeDataUtil;
import com.stripcode.core.util.tree.TreeNode;
import com.stripcode.mybatis.sf.model.SFSiteInfo;
import com.stripcode.mybatis.sf.model.SFStyleAreaPerInfo;
import com.stripcode.mybatis.user.model.TCodeMacroDefine;
import com.stripcode.service.sf.SF30_052Service;
import com.stripcode.service.user.TCodeMacroDefineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Metro
 */
@Controller
@RequestMapping("SF30_052")
public class SF30_052Controller {
    @Autowired
    private SF30_052Service sf30_052Service;

    @Autowired
    private TCodeMacroDefineService tCodeMacroDefineService;

    /**
     * 保存
     * @param sfSiteInfo
     * @return Map
     */
    @ResponseBody
    @RequestMapping(value = "update",method = RequestMethod.POST)
    public Map update(SFSiteInfo sfSiteInfo, CreateOrModifyCsTaskCompletionDto csTaskCompletionDto){
        return sf30_052Service.update(sfSiteInfo,csTaskCompletionDto.toModel());
    }

    /**
     * 查询场地信息
     * @param ppId
     * @return map
     */
    @ResponseBody
    @RequestMapping(value = "querySiteInfo",method = RequestMethod.POST)
    public Map<String,Object> querySiteInfo(String ppId){
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("main",sf30_052Service.querySiteInfo(ppId));
        map.put("codeList",tCodeMacroDefineService.queryForSiteArea());
        return map;
    }

    @ResponseBody
    @RequestMapping(value = "loadTableHead",method = RequestMethod.POST)
    public List<TCodeMacroDefine> loadTableHead(String storeImage){
        return sf30_052Service.loadTableHead(storeImage);
    }

    @ResponseBody
    @RequestMapping(value = "queryStyleAreaPerInfo",method = RequestMethod.POST)
    public List<TreeNode> queryStyleAreaPerInfo(String ppId){
        return GenerateTreeDataUtil.recursionChildren("root",sf30_052Service.queryStyleAreaPerInfo(ppId));
    }

    @ResponseBody
    @RequestMapping(value = "queryStyleInfo",method = RequestMethod.POST)
    public List<SFStyleAreaPerInfo> queryStyleInfo(String ppId,String seriesSex){
        return sf30_052Service.queryStyleInfo(ppId,seriesSex);
    }
}
