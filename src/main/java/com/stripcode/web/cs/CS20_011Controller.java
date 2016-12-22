package com.stripcode.web.cs;

import com.github.pagehelper.PageInfo;
import com.stripcode.core.dto.cs.CreateOrModifyCsTaskCompletionDto;
import com.stripcode.core.util.WebUtil;
import com.stripcode.mybatis.common.JQGridObject;
import com.stripcode.mybatis.cs.model.*;
import com.stripcode.service.cs.CS20_011Service;
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
 * Created by Metro on 2016/8/26.
 */
@Controller
@RequestMapping("/csSfPipeline")
public class CS20_011Controller extends BaseController{
    @Autowired
    private CS20_011Service cs20_011Service;
    @ResponseBody
    @RequestMapping(value = "read/selectCPById",method = RequestMethod.POST)
    public Map<String,Object> selectCPById(String customerId,String rowId,HttpServletRequest request,HttpServletResponse response){

        Map<String,Object> map=new HashMap<String, Object>();
        String ppId = null;
        if(StringUtils.isNotBlank(customerId)){
           CSCustomerInfo csCustomerInfo = cs20_011Service.selectCPById(customerId);
            List<CSSfPipeline> list = cs20_011Service.selectPPid(rowId);
            StringBuffer str = new StringBuffer();
            for(CSSfPipeline csSfPipeline :list){
                    str =str.append(csSfPipeline.getPpId()).append(",");
                }
            ppId=str.toString();
            System.out.println(ppId);
            map.put("main", csCustomerInfo);
            map.put("ppId",ppId);
        }
        return map;
    }
    //意向店列表
    @ResponseBody
    @RequestMapping(value = "read/selectList",method = RequestMethod.POST)
    public List<CSSfPipeline> selectList(String pids,String rowId,HttpServletResponse response){
        return  cs20_011Service.selectList(pids, rowId);
    }
    @ResponseBody
    @RequestMapping(value = "read/listPP",method = RequestMethod.POST)
    /*public List<CSSfPipeline> selectListPP(String ppId,String storeImage,String channelType,String cnStoreName,String city,String district,String province,String street,HttpServletRequest request){
        return  cs20_011Service.selectListPP(ppId,storeImage,channelType,cnStoreName,city,district,province,street);
    }*/
    public JQGridObject List(HttpServletRequest request,HttpServletResponse response){
        Map<String, Object> params = WebUtil.getParameterMap(request);
        PageInfo<CSSfPipeline> list=cs20_011Service.queryForPage(params);
        return  new JQGridObject(list);
    }
    //意向店批量保存
    @ResponseBody
    @RequestMapping(value = "read/insertBatchPipeline",method = RequestMethod.POST)
    public Map insertBatchPipeline(HttpServletRequest request,HttpServletResponse response,CreateOrModifyCsTaskCompletionDto dto){
        String userId = getCurrUser();
        Map<String,Object> map = WebUtil.getParameterMap(request);
        String optimauthId = map.get("rowId").toString();
        dto.setOptimauthId(optimauthId);
        return  cs20_011Service.insertBatchPipeline(map,userId,dto.toModel());
    }



}
