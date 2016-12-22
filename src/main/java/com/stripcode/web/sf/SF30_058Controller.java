package com.stripcode.web.sf;

import com.stripcode.core.util.WebUtil;
import com.stripcode.mybatis.cs.model.CSBusinessFlan;
import com.stripcode.mybatis.cs.model.CSSfPipeline;
import com.stripcode.mybatis.cs.model.TCsTaskCompletion;
import com.stripcode.mybatis.sf.model.SFReport;
import com.stripcode.mybatis.sf.model.SFTradezoneInfo;
import com.stripcode.service.sf.SF30_058Service;
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
 * Created by Metro on 2016/10/13.
 */
@Controller
@RequestMapping("/SF30_058")
public class SF30_058Controller extends BaseController{
    @Autowired
    private SF30_058Service sf30_058Service;
    @ResponseBody
    @RequestMapping(value = "/selectApprovalAll",method = RequestMethod.POST)
    public Map<String,Object> selectSFById(String customerId,String ppId,String erpCode, HttpServletRequest request, HttpServletRequest response){
        Map<String,Object> map=new HashMap<String, Object>();
            CSSfPipeline csSfPipeline = sf30_058Service.selectApprovalAll(customerId, ppId, erpCode);
            map.put("AccessoryList",sf30_058Service.selectAccessoryList());
            map.put("main",csSfPipeline);
        return map;
    }

    /**
     * 查询店铺市场增长率
     * @param ppId
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/selectMarketByppId",method = RequestMethod.POST)
    public List<CSBusinessFlan> selectMarketById(String ppId){
        return  sf30_058Service.selectMarketById(ppId);
    }

    @ResponseBody
    @RequestMapping(value = "/update",method = RequestMethod.POST)
    public Map update(TCsTaskCompletion csTaskCompletion,HttpServletRequest request,HttpServletResponse response)throws Exception{
        Map<String,Object> map = WebUtil.getParameterMap(request);
        return setSuccessModelMap(sf30_058Service.update(map,csTaskCompletion));
    }

    @ResponseBody
    @RequestMapping(value = "/updatePPT",method = RequestMethod.POST)
    public Map updatePPT(SFReport sfReport, TCsTaskCompletion tCsTaskCompletion,HttpServletRequest request,HttpServletResponse response){
        return sf30_058Service.updatePPT(sfReport,tCsTaskCompletion);
    }

    @ResponseBody
    @RequestMapping(value = "/selectSFReport",method = RequestMethod.POST)
    public Map selectSFReport(String ppId){
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("list",sf30_058Service.selectSFReport(ppId));
        return map;
    }
    /**
     * 查询直营ppt所需数据
     * @param ppId
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/selectPipeline",method = RequestMethod.POST)
    public Map<String,Object> selectPipeline(String ppId,String customerId){
        Map<String,Object> map=new HashMap<String, Object>();
        map.put("main",sf30_058Service.selectPipeline(ppId,customerId));
        return map;
    }

    /**
     * 查询ppt意向店风格形象
     * @param ppId
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/selectCSSfPipelineStoreImage",method = RequestMethod.POST)
    public Map<String,Object> selectCSSfPipelineStoreImage(String ppId){
        Map<String,Object> map=new HashMap<String, Object>();
        map.put("main",sf30_058Service.selectCSSfPipelineStoreImage(ppId));
        return map;
    }
    /**
     * 查询ppt周边租金情况
     * @param ppId
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/selectRentInfoByppId",method = RequestMethod.POST)
    public Map<String,Object> selectRentInfoByppId(String ppId){
        Map<String,Object> map=new HashMap<String, Object>();
        map.put("main",sf30_058Service.selectRentInfoByppId(ppId));
        return map;
    }

    /**
     * 查询ppt各楼层面积信息
     * @param ppId
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/selectFloorInfo",method = RequestMethod.POST)
    public Map<String,Object> selectFloorInfo(String ppId){
        Map<String,Object> map=new HashMap<String, Object>();
        map.put("main",sf30_058Service.selectFloorInfo(ppId));
        return map;
    }

    /**
     * 查询ppt各年租金信息
     * @param ppId
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/selectRentalDetail",method = RequestMethod.POST)
    public Map<String,Object> selectRentalDetail(String ppId){
        Map<String,Object> map=new HashMap<String, Object>();
        map.put("main",sf30_058Service.selectRentalDetail(ppId));
        return map;
    }

    /**
     * 查询ppt店铺平面图集合
     * @param ppId
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/selectLandlordLayoutPlanImg",method = RequestMethod.POST)
    public Map<String,Object> selectLandlordLayoutPlanImg(String ppId){
        Map<String,Object> map=new HashMap<String, Object>();
        map.put("main",sf30_058Service.selectLandlordLayoutPlanImg(ppId));
        return map;
    }

    /**
     * 查询ppt物业平面图集合
     * @param ppId
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/selectLandlordLayoutPropertyImg",method = RequestMethod.POST)
    public Map<String,Object> selectLandlordLayoutPropertyImg(String ppId){
        Map<String,Object> map=new HashMap<String, Object>();
        map.put("main",sf30_058Service.selectLandlordLayoutPropertyImg(ppId));
        return map;
    }
    /**
     * 查询ppt商圈图
     * @param ppId
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/selectTradezoneInfo",method = RequestMethod.POST)
    public Map<String,Object> selectTradezoneInfo(String ppId){
        Map<String,Object> map=new HashMap<String, Object>();
        List<SFTradezoneInfo> sfTradezoneInfoList = sf30_058Service.selectTradezoneInfo(ppId);
        map.put("sfTradezoneInfoList",sfTradezoneInfoList);
        return map;
    }
    /**
     * 查询ppt商圈竞品集合
     * @param ppId
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/selectTradezoneCiuInfo",method = RequestMethod.POST)
    public Map<String,Object> selectTradezoneCiuInfo(String ppId){
        Map<String,Object> map=new HashMap<String, Object>();
        map.put("main",sf30_058Service.selectTradezoneCiuInfo(ppId));
        return map;
    }

    /**
     * 查询ppt人流量详细信息
     * @param ppId
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/selectTrafficcountDetail",method = RequestMethod.POST)
    public Map<String,Object> selectTrafficcountDetail(String ppId){
        Map<String,Object> map=new HashMap<String, Object>();
        map.put("main",sf30_058Service.selectTrafficcountDetail(ppId));
        return map;
    }

    /**
     * 查询ppt意向店新址照片集合
     * @param ppId
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/selectPipeinePhotoAttachment",method = RequestMethod.POST)
    public Map<String,Object> selectPipeinePhotoAttachment(String ppId){
        Map<String,Object> map=new HashMap<String, Object>();
        map.put("main",sf30_058Service.selectPipeinePhotoAttachment(ppId));
        return map;
    }
    /**
     * 查询ppt意向店新址周边照片集合
     * @param ppId
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/selectPipeinePhotoAttachmentOther",method = RequestMethod.POST)
    public Map<String,Object> selectPipeinePhotoAttachmentOther(String ppId){
        Map<String,Object> map=new HashMap<String, Object>();
        map.put("main",sf30_058Service.selectPipeinePhotoAttachmentOther(ppId));
        return map;
    }
    /**
     * 查询ppt意向店落位图集合
     * @param ppId
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/selectPipeineLocationImgList",method = RequestMethod.POST)
    public Map<String,Object> selectPipeineLocationImgList(String ppId){
        Map<String,Object> map=new HashMap<String, Object>();
        map.put("main",sf30_058Service.selectPipeineLocationImgList(ppId));
        return map;
    }

    /**
     * 查询ppt商圈现有店数量
     * @param ppId
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/selectSFTradezoneStoreInfo",method = RequestMethod.POST)
    public Map<String,Object> selectSFTradezoneStoreInfo(String ppId){
        Map<String,Object> map=new HashMap<String, Object>();
        map.put("main",sf30_058Service.selectSFTradezoneStoreInfo(ppId));
        return map;
    }

    /**
     * 查询ppt工程概算信息
     * @param ppId
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/selectBudGetEstimationCostInfo",method = RequestMethod.POST)
    public Map<String,Object> selectBudGetEstimationCostInfo(String ppId){
        Map<String,Object> map=new HashMap<String, Object>();
        map.put("main",sf30_058Service.selectBudGetEstimationCostInfo(ppId));
        return map;
    }

    /**
     * 查询ppt商务条款业主信息集合
     * @param ppId
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/selectLandlordinfo",method = RequestMethod.POST)
    public Map<String,Object> selectLandlordinfo(String ppId){
        Map<String,Object> map=new HashMap<String, Object>();
        map.put("main",sf30_058Service.selectLandlordinfo(ppId));
        return map;
    }

    /**
     * 查询意向店风格面积占比
     * @param ppId
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/selectSFStyleAreaPerInfo",method = RequestMethod.POST)
    public Map<String,Object> selectSFStyleAreaPerInfo(String ppId){
        Map<String,Object> map=new HashMap<String, Object>();
        map.put("main",sf30_058Service.selectSFStyleAreaPerInfo(ppId));
        return map;
    }

    /**
     * 查询意向店销售占比
     * @param ppId
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/selectSFStyleSalesPerInfo",method = RequestMethod.POST)
    public Map<String,Object> selectSFStyleSalesPerInfo(String ppId){
        Map<String,Object> map=new HashMap<String, Object>();
        map.put("main",sf30_058Service.selectSFStyleSalesPerInfo(ppId));
        return map;
    }

    /**
     * 查询意向店总资本性支出
     * @param ppId
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/selectEstInvestmentCostTotal",method = RequestMethod.POST)
    public Map<String,Object> selectEstInvestmentCostTotal(String ppId){
        Map<String,Object> map=new HashMap<String, Object>();
        map.put("main",sf30_058Service.selectEstInvestmentCostTotal(ppId));
        return map;
    }
}
