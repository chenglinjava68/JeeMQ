package com.stripcode.service.sf;

import com.stripcode.core.util.UUIDUtils;
import com.stripcode.mybatis.cp.model.CpMarketInfo;
import com.stripcode.mybatis.cs.dao.CSCustomerInfoMapper;
import com.stripcode.mybatis.cs.model.*;
import com.stripcode.mybatis.sf.dao.SFReportMapper;
import com.stripcode.mybatis.sf.dao.SFSfApprovalMapper;
import com.stripcode.mybatis.sf.dao.SFSfPipelineMapper;
import com.stripcode.mybatis.sf.model.*;
import com.stripcode.service.BaseService;
import com.stripcode.service.cs.TCsTaskCompletionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.stereotype.Service;


import java.util.*;

/**
 * Created by Metro on 2016/9/28.
 */
@Service
@CacheConfig(cacheNames = "sfApproval")
public class SF30_058Service extends BaseService {
    @Autowired
    private SFSfApprovalMapper sfSfApprovalMapper;
    @Autowired
    private CSCustomerInfoMapper csCustomerInfoMapper;
    @Autowired
    private TCsTaskCompletionService tCsTaskCompletionService;
    @Autowired
    private SFSfPipelineMapper sfSfPipelineMapper;
    @Autowired
    private SFReportMapper sfReportMapper;
    //查询政策支持
    public List<SFPolicySupportDetail> selectSupportDetail(String ppId){
        return  sfSfApprovalMapper.selectSupportDetail(ppId);
    }
    public List<CpMarketInfo> selectMarketInfo(String customerId,String erpCode,String ppId){
        return  sfSfApprovalMapper.marketList(customerId,erpCode,ppId);
    }

    /**
     * 店铺市场增长率
     * @return
     */
    public List<CSBusinessFlan> selectMarketById (String ppId){
        return  sfSfApprovalMapper.selectMarketById(ppId);
    }
    //查询
    public CSSfPipeline selectApprovalAll(String customerId,String ppId,String erpCode){
        CSCustomerInfo csCustomerInfo = csCustomerInfoMapper.selectById(customerId);
        CSSfPipeline csSfPipeline =null;
        if(csCustomerInfo!=null){
            csSfPipeline =sfSfApprovalMapper.selectApprovalAll(customerId,ppId);
            csSfPipeline.setCsCustomerInfo(csCustomerInfo);
            csSfPipeline.setSupportDetailList(this.selectSupportDetail(ppId));
            csSfPipeline.setMarketInfoList(this.selectMarketInfo(customerId,erpCode,ppId));
        }
        return csSfPipeline;
    }
    /**
     * 报批ppTT 附件列表
     */
    public List<CSMarketSurvey> selectAccessoryList(){
        return  sfSfApprovalMapper.selectAccessoryList();
    }
    public Map update(Map<String,Object> map,TCsTaskCompletion csTaskCompletion){
        Map modelMap = new HashMap();
        //定义是否成功 用于判断
        boolean result = true;
        //定义后台返回数据
        String message = "保存成功";
        Integer IsExist = 0;
        int count = -1;
        /*if(count!=1 ){
            result = false;
            message = "保存失败!";
        }*/
        String ppId=map.get("ppId").toString();
        csTaskCompletion.setRowId(UUIDUtils.generateKey());
        csTaskCompletion.setCreateTime(null);
        csTaskCompletion.setOptimauthId(ppId);
        tCsTaskCompletionService.upateStatusToFinished(csTaskCompletion);
        tCsTaskCompletionService.updatePipelineType(csTaskCompletion.getTaskId(),ppId);
        modelMap.put("result", result);
        modelMap.put("message", message);
        return modelMap;
    }

    /**
     * 保存和更新直营店ppt附件
     * @param sfReport
     * @param tCsTaskCompletion
     * @return
     */
    public Map updatePPT(SFReport sfReport,TCsTaskCompletion tCsTaskCompletion){
        Map modelMap = new HashMap();
        Boolean result = true;
        String message = "保存成功!";
        Integer count = -1;
        int num = 1;
        String ppId = sfReport.getPpId();
        Integer isExist =sfReportMapper.selectIsExist(ppId);
        Date date = new Date();
        if (isExist == 0 || isExist == 1){
            String rowId = UUIDUtils.generateKey();
            sfReport.setRowId(rowId);
            sfReport.setCreateTime(date);
            sfReport.setUpdateTime(date);
            count = sfReportMapper.insert(sfReport);
        }else{
            List<SFReport> sfReportRowIdList = sfReportMapper.selectSFReportRowId(ppId);
            if (sfReport.getNum().equals("1")){
                sfReport.setRowId(sfReportRowIdList.get(0).getRowId());
            }else{
                sfReport.setRowId(sfReportRowIdList.get(1).getRowId());
            }
            count = sfReportMapper.update(sfReport);
        }
        tCsTaskCompletion.setRowId(UUIDUtils.generateKey());
        tCsTaskCompletion.setCreateTime(null);
        tCsTaskCompletion.setOptimauthId(ppId);
        tCsTaskCompletionService.upateStatusToFinished(tCsTaskCompletion);
        if(count!=1){
            result = false;
            message = "保存失败!";
        }
        modelMap.put("result",result);
        modelMap.put("message",message);
        return modelMap;
    }

    /**
     * 查询直营店ppt附件下载列表
     * @param ppId
     * @return
     */
    public List<SFReport> selectSFReport(String ppId){
        return sfReportMapper.selectSFReport(ppId);
    }
    /**
     * 查询直营ppt所需数据
     * @param ppId
     * @return
     */
    public CSSfPipeline selectPipeline(String ppId,String customerId){
        CSSfPipeline csSfPipeline = sfSfPipelineMapper.selectPipeline(ppId);
        CSCustomerInfo csCustomerInfo = csCustomerInfoMapper.selectById(customerId);
        SFTrafficcount sfTrafficcount = sfSfPipelineMapper.selectSFTrafficcount(ppId);
        SFEstInvestmentRoi sfEstInvestmentRoi = sfSfPipelineMapper.selectEstInvestmentRoi(ppId);
        csSfPipeline.setSfEstInvestmentRoi(sfEstInvestmentRoi);
        csSfPipeline.setCsCustomerInfo(csCustomerInfo);
        csSfPipeline.setSfTrafficcount(sfTrafficcount);
        return csSfPipeline;
    }

    /**
     * 查询ppt意向店店铺形象
     * @param ppId
     * @return
     */
    public List<CSSfPipeline> selectCSSfPipelineStoreImage(String ppId){
        return sfSfPipelineMapper.selectCSSfPipelineStoreImage(ppId);
    }
    /**
     * 查询ppt周边租金情况
     * @param ppId
     * @return
     */
    public List<SFRentInfo> selectRentInfoByppId(String ppId){
        return sfSfPipelineMapper.selectRentInfoByppId(ppId);
    }

    /**
     * 查询ppt各楼层数据
     * @param ppId
     * @return
     */
    public List<SFFloorInfo> selectFloorInfo(String ppId){
        return sfSfPipelineMapper.selectFloorInfo(ppId);
    }

    /**
     * 查询ppt各年租金信息
     * @param ppId
     * @return
     */
    public List<SFRentalDetail> selectRentalDetail(String ppId){
        return sfSfPipelineMapper.selectRentalDetail(ppId);
    }

    /**
     * 查询ppt店铺平面图集合
     * @param ppId
     * @return
     */
    public List<SFLandlordLayout> selectLandlordLayoutPlanImg(String ppId){
        return sfSfPipelineMapper.selectLandlordLayoutPlanImg(ppId);
    }

    /**
     * 查询ppt物业平面图集合
     * @param ppId
     * @return
     */
    public List<SFLandlordLayout> selectLandlordLayoutPropertyImg(String ppId){
        return sfSfPipelineMapper.selectLandlordLayoutPropertyImg(ppId);
    }

    /**
     * 查询ppt商圈图
     * @param ppId
     * @return
     */
    public List<SFTradezoneInfo> selectTradezoneInfo(String ppId){
        return sfSfPipelineMapper.selectTradezoneInfo(ppId);
    }

    /**
     * 查询ppt商圈竞品集合
     * @param ppId
     * @return
     */
    public List<SFTradezoneCiuInfo> selectTradezoneCiuInfo(String ppId){
        return sfSfPipelineMapper.selectTradezoneCiuInfo(ppId);
    }

    /**
     * 查询ppt人流量详细信息
     * @param ppId
     * @return
     */
    public List<SFTrafficcountDetail> selectTrafficcountDetail(String ppId){
        return sfSfPipelineMapper.selectTrafficcountDetail(ppId);
    }

    /**
     * 查询ppt意向店新址照片集合
     * @param ppId
     * @return
     */
    public List<SFPipeinePhotoAttachment> selectPipeinePhotoAttachment(String ppId){
        return sfSfPipelineMapper.selectPipeinePhotoAttachment(ppId);
    }
    /**
     * 查询ppt意向店新址周边照片集合
     * @param ppId
     * @return
     */
    public List<SFPipeinePhotoAttachment> selectPipeinePhotoAttachmentOther(String ppId){
        return sfSfPipelineMapper.selectPipeinePhotoAttachmentOther(ppId);
    }
    /**
     * 查询ppt意向店落位图集合
     * @param ppId
     * @return
     */
    public List<SFPipeinePhotoAttachment> selectPipeineLocationImgList(String ppId){
        return sfSfPipelineMapper.selectPipeineLocationImgList(ppId);
    }

    /**
     * 查询商圈现有数量
     * @param ppId
     * @return
     */
    public List<SFTradezoneStoreInfo> selectSFTradezoneStoreInfo(String ppId){
        return  sfSfPipelineMapper.selectSFTradezoneStoreInfo(ppId);
    }

    /**
     *查询ppt工程概算信息
     * @param ppId
     * @return
     */
    public List<SFBudGetEstimationCost> selectBudGetEstimationCostInfo(String ppId){
        return sfSfPipelineMapper.selectBudGetEstimationCostInfo(ppId);
    }

    /**
     * 查询ppt商务条款业主信息集合
     * @param ppId
     * @return
     */
    public List<SFLandlordinfo> selectLandlordinfo(String ppId){
        return sfSfPipelineMapper.selectLandlordinfo(ppId);
    }

    /**
     * 查询意向店风格面积占比
     * @param ppId
     * @return
     */
    public List<SFStyleAreaPerInfo> selectSFStyleAreaPerInfo(String ppId){
        return sfSfPipelineMapper.selectSFStyleAreaPerInfo(ppId);
    }

    /**
     * 查询意向店销售占比
     * @param ppId
     * @return
     */
    public List<SFStyleAreaPerInfo> selectSFStyleSalesPerInfo(String ppId){
        return sfSfPipelineMapper.selectSFStyleSalesPerInfo(ppId);
    }

    /**
     * 查询总资本性支出
     * @param ppId
     * @return
     */
    public SFEstInvestmentCost selectEstInvestmentCostTotal(String ppId){
        return sfSfPipelineMapper.selectEstInvestmentCostTotal(ppId);
    }
}
