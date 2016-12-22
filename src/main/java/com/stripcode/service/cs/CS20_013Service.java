package com.stripcode.service.cs;

import com.stripcode.core.util.DateUtil;
import com.stripcode.core.util.UUIDUtils;
import com.stripcode.mybatis.cs.dao.*;
import com.stripcode.mybatis.cs.model.*;
import com.stripcode.mybatis.sf.dao.SFEstInvestmentMapper;
import com.stripcode.mybatis.sf.model.*;
import com.stripcode.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.stereotype.Service;


import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by Metro on 2016/9/13.
 */
@Service
@CacheConfig(cacheNames = "marketSubApply")
public class CS20_013Service extends BaseService{
    @Autowired
    private CSMarketAOaddMapper csMarketAOaddMapper;
    @Autowired
    private CSCustomerInfoMapper csCustomerInfoMapper;
    @Autowired
    private CSApplyApprovalMapper csApplyApprovalMapper;
    @Autowired
    private TCsTaskCompletionMapper tCsTaskCompletionMapper;
    @Autowired
    private TCsTaskCompletionService tCsTaskCompletionService;
    @Autowired
    private CSSfPipelineMapper csSfPipelineMapper;
    @Autowired
    private CSNewBusinessFlanMapper csNewBusinessFlanMapper;
    @Autowired
    private SFEstInvestmentMapper sfEstInvestmentMapper;
    @Autowired
    private CSReportInfoMapper csReportInfoMapper;
    //查询分成比例列表
    public List<CSMarketDiscountSplit> selectDiscountSplit(String rowId){
        return  csMarketAOaddMapper.selectDiscountSplit(rowId);
    }
    public CSNewMarketAuz selectAll(String customerId,String rowId){
        CSCustomerInfo csCustomerInfo = csCustomerInfoMapper.selectById(customerId);
        CSNewMarketAuz csNewMarketAuz = csApplyApprovalMapper.selectApplyInfoById(customerId,rowId);;
        csNewMarketAuz.setCsCustomerInfo(csCustomerInfo);
        csNewMarketAuz.setDiscountSplitListtSplit(this.selectDiscountSplit(rowId));
        return csNewMarketAuz;
    }

    /**
     * 查询ppt所需数据
     * @param customerId
     * @param rowId
     * @param optimauthId
     * @return
     */
    public CSNewMarketAuz selectAllPPT(String customerId,String rowId,String optimauthId){
        CSCustomerInfo csCustomerInfo = csCustomerInfoMapper.selectById(customerId);
        CSNewMarketAuz csNewMarketAuz = csApplyApprovalMapper.selectApplyInfoById(customerId,rowId);
        CSSfPipeline csSfPipeline = csSfPipelineMapper.selectPipeline(optimauthId);
        SFEstInvestmentResultData sfEstInvestmentResultData = sfEstInvestmentMapper.selectResultData(optimauthId);
        TSfEstInvestmentNonLaborCost tSfEstInvestmentNonLaborCost = csSfPipelineMapper.selectTSfEstInvestmentNonLaborCost(optimauthId);
        TSfEstInvestmentResultDateCopartner tSfEstInvestmentResultDateCopartner = csSfPipelineMapper.selectTSfEstInvestmentResultDateCopartner(optimauthId);
        SFTrafficcount SfTrafficcount = csSfPipelineMapper.selectCopartnerSFTrafficcount(optimauthId);
        if (csSfPipeline.getRentStartDate()!=null && !"".equals(csSfPipeline.getRentStartDate()) && csSfPipeline.getRentEndDate()!=null && !"".equals(csSfPipeline.getRentEndDate())){
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date startDate = sdf.parse(csSfPipeline.getRentStartDate(),new ParsePosition(0));
            Date endDate = sdf.parse(csSfPipeline.getRentEndDate(),new ParsePosition(0));
            String rentalYearTemp = DateUtil.getYearBetween(startDate,endDate);
            csSfPipeline.setRentalYear(rentalYearTemp);
        }

        csNewMarketAuz.setCsSfPipeline(csSfPipeline);
        csNewMarketAuz.setCsCustomerInfo(csCustomerInfo);
        csNewMarketAuz.setSfEstInvestmentResultData(sfEstInvestmentResultData);
        csNewMarketAuz.settSfEstInvestmentNonLaborCost(tSfEstInvestmentNonLaborCost);
        csNewMarketAuz.settSfEstInvestmentResultDateCopartner(tSfEstInvestmentResultDateCopartner);
        csNewMarketAuz.setSfTrafficcount(SfTrafficcount);
        return csNewMarketAuz;
    }

    public Map update(CSPlanInvestment csPlanInvestment, TCsTaskCompletion tCsTaskCompletion) {
        Map modelMap = new HashMap();
        Boolean result = true;
        String message = "保存成功!";
        Integer count = -1;
        String optimauthId = csPlanInvestment.getOptimauthId();
        String taskId = csPlanInvestment.getTaskId();
        Integer isExist = csApplyApprovalMapper.approvalCount(optimauthId);
        Date date = new Date();
        if(isExist==0){
            String rowId= UUIDUtils.generateKey();
            csPlanInvestment.setRowId(rowId);
            csPlanInvestment.setCreateTime(date);
            count = csApplyApprovalMapper.insert(csPlanInvestment);
        }else{
            count = csApplyApprovalMapper.update(csPlanInvestment);
        }
        tCsTaskCompletionService.updateOptimauthType("M0092",optimauthId);
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
     * 更新报批报告ppt
     * @param csReportInfo
     * @param tCsTaskCompletion
     * @return
     */
    public Map updatePPT(CSReportInfo csReportInfo,TCsTaskCompletion tCsTaskCompletion){
        Map modelMap = new HashMap();
        Boolean result = true;
        String message = "保存成功!";
        Integer count = -1;
        String optimauthId = csReportInfo.getOptimauthId();
        Integer isExist = csReportInfoMapper.selectIsExist(optimauthId);
        Date date = new Date();
        if (isExist == 0){
            String rowId = UUIDUtils.generateKey();
            csReportInfo.setRowId(rowId);
            csReportInfo.setCreateTime(date);
            csReportInfo.setUpdateTime(date);
            count = csReportInfoMapper.insert(csReportInfo);
        }else{
            count = csReportInfoMapper.update(csReportInfo);
        }
        tCsTaskCompletionService.updateOptimauthType("M0092",optimauthId);
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
     * 查询意向店风格集合
     * @param optimauthId
     * @return
     */
    public List<CSSfPipeline> selectCSSfPipelineStoreImage(String optimauthId){
        return csSfPipelineMapper.selectCSSfPipelineStoreImage(optimauthId);
    }

    /**
     * 查询市场报批报告ppt
     * @param optimauthId
     * @return
     */
    public CSReportInfo selectCSReportInfo(String optimauthId){
        return csReportInfoMapper.selectCSReportInfo(optimauthId);
    }
    /**
     * 查询意向店各楼层信息
     * @param optimauthId
     * @return
     */
    public List<SFFloorInfo> selectFloorInfo(String optimauthId){
        return csSfPipelineMapper.selectFloorInfo(optimauthId);
    }

    /**
     * 查询市场规划信息
     * @param optimauthId
     * @return
     */
    public List<CSBusinessFlan> selectBusinessFlanList(String optimauthId){
        return csNewBusinessFlanMapper.selectBusinessFlanList(optimauthId);
    }

    /**
     * 查询意向店投资测算
     * @param optimauthId
     * @return
     */
    public List<SFEstInvestmentDetail> selectInvestmentDetail(String optimauthId){
        return sfEstInvestmentMapper.selectInvestmentDetail(optimauthId);
    }

    /**
     * 查询报批所需图片(落位图,房屋租赁协议)
     * @param optimauthId
     * @return
     */
    public Map selectPPTImg(String optimauthId){
        Map map = new HashMap();
        //店铺照片集合
        List<SFPipeinePhotoAttachment> pipelineImgList = csSfPipelineMapper.selectPipelineImg(optimauthId);
        //落位图集合
        List<SFPipeinePhotoAttachment> pipelineLocationImgList = csSfPipelineMapper.selectPipelineLocationImg(optimauthId);
        //加盟房屋租赁协议附件
        List<SFRentalProposalAttachment> rentalImgJMList = csSfPipelineMapper.selectRentalAttachMentImgJM(optimauthId);
        //合伙人房屋租赁协议附件
        List<SFRentalProposalAttachment> rentalImgHHList = csSfPipelineMapper.selectRentalAttachMentImgHH(optimauthId);
        map.put("pipelineImgList",pipelineImgList);
        map.put("pipelineLocationImgList",pipelineLocationImgList);
        map.put("rentalImgJMList",rentalImgJMList);
        map.put("rentalImgHHList",rentalImgHHList);
        return map;
    }

    /**
     * 查询报批店铺政策支持列表
     * @param optimauthId
     * @return
     */
    public List<SFPolicySupportDetail> selectFPolicySupportDetail(String optimauthId){
        return csSfPipelineMapper.selectFPolicySupportDetail(optimauthId);
    }

    /**
     * 查询加盟报批报告商圈图
     * @param optimauthId
     * @return
     */
    public List<SFTradezoneInfo> selectTradezoneInfo(String optimauthId){
        return csSfPipelineMapper.selectTradezoneInfo(optimauthId);
    }

    /**
     * 查询意向店风格面积占比
     * @param optimauthId
     * @return
     */
    public List<SFStyleAreaPerInfo> selectSFStyleAreaPerInfo(String optimauthId){
        return csSfPipelineMapper.selectSFStyleAreaPerInfo(optimauthId);
    }

    /**
     * 查询合伙人ppt人流量详细信息
     * @param optimauthId
     * @return
     */
    public List<SFTrafficcountDetail> selectCopartnerSFTrafficcountDetail(String optimauthId){
        return csSfPipelineMapper.selectCopartnerSFTrafficcountDetail(optimauthId);
    }

    /**
     * 查询合伙人收入分成占比
     * @param optimauthId
     * @return
     */
    public List<SFEstInvestmentIncomeSharing> selectSFEstInvestmentIncomeSharing(String optimauthId){
        return csSfPipelineMapper.selectSFEstInvestmentIncomeSharing(optimauthId);
    }

    /**
     * 查询合伙人收入分成占比小计
     * @param optimauthId
     * @return
     */
    public SFEstInvestmentIncomeSharing selectSFEstInvestmentIncomeSharingTotal(String optimauthId){
        return csSfPipelineMapper.selectSFEstInvestmentIncomeSharingTotal(optimauthId);
    }
}
