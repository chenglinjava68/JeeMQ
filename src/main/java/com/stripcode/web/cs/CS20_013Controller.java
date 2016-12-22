package com.stripcode.web.cs;

import com.github.pagehelper.StringUtil;
import com.stripcode.core.dto.cs.CreateOrModifyCsTaskCompletionDto;
import com.stripcode.mybatis.cs.model.CSPlanInvestment;
import com.stripcode.mybatis.cs.model.CSBusinessFlan;
import com.stripcode.mybatis.cs.model.CSNewMarketAuz;
import com.stripcode.mybatis.cs.model.CSReportInfo;
import com.stripcode.service.cs.CS20_013Service;
import com.stripcode.service.cs.CS20_023Service;
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
 * Created by Metro on 2016/9/13.
 */
@Controller
@RequestMapping("/Cs20_013")
public class CS20_013Controller extends BaseController {
    @Autowired
    private CS20_013Service cs20_013Service;
    @Autowired
    private CS20_023Service cs20_023Service;

    @ResponseBody
    @RequestMapping(value = "/read/selectAll",method = RequestMethod.POST)
    public Map<String,Object> selectAll(String customerId,String rowId,HttpServletRequest request,HttpServletResponse response){
        Map<String,Object> map = new HashMap<String,Object>();
        if(!StringUtil.isEmpty(customerId)) {
            CSNewMarketAuz csNewMarketAuz = cs20_013Service.selectAll(customerId,rowId);
            map.put("main",csNewMarketAuz);
        }
        return  map;
    }

    @ResponseBody
    @RequestMapping(value = "/read/selectAllPPT",method = RequestMethod.POST)
    public Map<String,Object> selectAllPPT(String customerId,String rowId,String optimauthId,HttpServletRequest request,HttpServletResponse response){
        Map<String,Object> map = new HashMap<String,Object>();
        if(!StringUtil.isEmpty(customerId)) {
            CSNewMarketAuz csNewMarketAuz = cs20_013Service.selectAllPPT(customerId,rowId,optimauthId);
            map.put("main",csNewMarketAuz);
        }
        return  map;
    }

    @ResponseBody
    @RequestMapping(value = "/selectBusinessFlanByOptimauthId",method = RequestMethod.POST)
    public List<CSBusinessFlan> selectBusinessFlanByOptimauthId(String optimauthId){
        return cs20_023Service.queryBusinessFlanByOptimauthId(optimauthId);
    }
    @ResponseBody
    @RequestMapping(value = "/update",method = RequestMethod.POST)
    public Map update(CSPlanInvestment csPlanInvestment, HttpServletResponse response,CreateOrModifyCsTaskCompletionDto dto){
       String optimauthId =  csPlanInvestment.getOptimauthId();
        dto.setOptimauthId(optimauthId);
        return  cs20_013Service.update(csPlanInvestment,dto.toModel());
    }
    /**
     * 更新报批报告ppt
     */
    @ResponseBody
    @RequestMapping(value = "/updatePPT",method = RequestMethod.POST)
    public Map updatePPT(CSReportInfo csReportInfo, HttpServletResponse response, CreateOrModifyCsTaskCompletionDto dto){
        String optimauthId =  csReportInfo.getOptimauthId();
        dto.setOptimauthId(optimauthId);
        return  cs20_013Service.updatePPT(csReportInfo,dto.toModel());
    }

    @ResponseBody
    @RequestMapping(value = "/selectCSReportInfo",method = RequestMethod.POST)
    public Map selectCSReportInfo(String optimauthId){
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("CSReportInfo",cs20_013Service.selectCSReportInfo(optimauthId));
        return map;
    }

    /**
     * 查询意向店风格集合
     * @param optimauthId
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/selectCSSfPipelineStoreImage",method = RequestMethod.POST)
    public Map selectCSSfPipelineStoreImage(String optimauthId,HttpServletRequest request,HttpServletResponse response){
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("main",cs20_013Service.selectCSSfPipelineStoreImage(optimauthId));
        return map;
    }

    /**
     * 查询意向店各楼层信息
     * @param optimauthId
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/selectFloorInfo",method = RequestMethod.POST)
    public Map selectFloorInfo(String optimauthId,HttpServletRequest request,HttpServletResponse response){
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("list",cs20_013Service.selectFloorInfo(optimauthId));
        return map;
    }

    /**
     * 查询市场规划信息
     * @param optimauthId
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/selectBusinessFlanList",method = RequestMethod.POST)
    public Map selectBusinessFlanList(String optimauthId,HttpServletRequest request,HttpServletResponse response){
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("list",cs20_013Service.selectBusinessFlanList(optimauthId));
        return map;
    }

    /**
     * 查询意向店投资测算
     * @param optimauthId
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/selectInvestmentDetail",method = RequestMethod.POST)
    public Map selectInvestmentDetail(String optimauthId,HttpServletRequest request,HttpServletResponse response){
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("list",cs20_013Service.selectInvestmentDetail(optimauthId));
        return  map;
    }

    /**
     * 查询报批所需图片(落位图,店铺照片附件,房屋租赁协议)
     * @param optimauthId
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/selectPPTImg",method = RequestMethod.POST)
    public Map selectPPTImg(String optimauthId,HttpServletRequest request,HttpServletResponse response){
        return cs20_013Service.selectPPTImg(optimauthId);
    }

    /**
     * 查询报批店铺政策支持列表
     * @param optimauthId
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/selectFPolicySupportDetail",method = RequestMethod.POST)
    public Map selectFPolicySupportDetail(String optimauthId,HttpServletRequest request,HttpServletResponse response){
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("list",cs20_013Service.selectFPolicySupportDetail(optimauthId));
        return map;
    }

    /**
     * 查询加盟报批报告商圈图
     * @param optimauthId
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/selectTradezoneInfo",method = RequestMethod.POST)
    public Map selectTradezoneInfo(String optimauthId,HttpServletRequest request,HttpServletResponse response){
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("TradezoneInfoList",cs20_013Service.selectTradezoneInfo(optimauthId));
        return map;
    }

    /**
     * 查询意向店风格面积占比
     * @param optimauthId
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/selectSFStyleAreaPerInfo",method = RequestMethod.POST)
    public Map<String,Object> selectSFStyleAreaPerInfo(String optimauthId){
        Map<String,Object> map=new HashMap<String, Object>();
        map.put("main",cs20_013Service.selectSFStyleAreaPerInfo(optimauthId));
        return map;
    }

    /**
     * 查询合伙人ppt人流量详细信息
     * @param optimauthId
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/selectCopartnerSFTrafficcountDetail",method = RequestMethod.POST)
    public Map<String,Object> selectCopartnerSFTrafficcountDetail(String optimauthId){
        Map<String,Object> map=new HashMap<String, Object>();
        map.put("main",cs20_013Service.selectCopartnerSFTrafficcountDetail(optimauthId));
        return map;
    }

    /**
     * 查询合伙人收入分成占比
     * @param optimauthId
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/selectSFEstInvestmentIncomeSharing",method = RequestMethod.POST)
    public Map<String,Object> selectSFEstInvestmentIncomeSharing(String optimauthId){
        Map<String,Object> map=new HashMap<String, Object>();
        map.put("main",cs20_013Service.selectSFEstInvestmentIncomeSharing(optimauthId));
        return map;
    }

    /**
     * 查询合伙人收入分成占比小计
     * @param optimauthId
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/selectSFEstInvestmentIncomeSharingTotal",method = RequestMethod.POST)
    public Map<String,Object> selectSFEstInvestmentIncomeSharingTotal(String optimauthId){
        Map<String,Object> map=new HashMap<String, Object>();
        map.put("main",cs20_013Service.selectSFEstInvestmentIncomeSharingTotal(optimauthId));
        return map;
    }
}
