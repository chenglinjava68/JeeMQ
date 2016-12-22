package com.stripcode.mybatis.cs.dao;

import com.stripcode.mybatis.cs.model.CSCustomerPP;
import com.stripcode.mybatis.cs.model.CSPipelineIds;
import com.stripcode.mybatis.cs.model.CSSfPipeline;
import com.stripcode.mybatis.sf.model.*;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * Created by Metro on 2016/8/30.
 */
public interface CSSfPipelineMapper {
    /*
    查询意向店添加列表
     */
    List<CSSfPipeline> selectList(CSPipelineIds csPipelineIds);
    /*
    查询客户意向店
     */
    List<CSSfPipeline> selectPiList(@Param("customerId")String customerId,@Param("rowId")String rowId);
    /*
    意向店批量保存
     */
    Integer insertBatchPipeline(CSCustomerPP cSCustomerPP);
    /*
    意向店修改
     */
    Integer BatchUpdate(CSCustomerPP cSCustomerPP);
    //查询客户是否有意向店
    Integer PipelineCount(@Param("ppId") String ppId,@Param("optimauthId")String optimauthId);
    //删除意向店
    Integer updatePipelineDelFlag(@Param("ppId") String []ppId,@Param("optimauthId")String optimauthId);
    //查询PPId
    List<CSSfPipeline> selectPPid(String rowId);

   // List<CSSfPipeline> selectListPP(@Param("ppid")String [] ppid,@Param("storeImage")String storeImage,@Param("channelType")String channelType,@Param("cnStoreName")String cnStoreName,@Param("city")String city,@Param("district")String district,@Param("province")String province,@Param("street")String street);
    List<CSSfPipeline> selectListPP(Map<String,Object> map);

    //报批申请查询意向店店铺
    CSSfPipeline selectPipeline(@Param("optimauthId") String optimauthId);

    //查询意向店各楼层面积
    List<SFFloorInfo> selectFloorInfo(@Param("optimauthId") String optimauthId);

    //查询店铺所有照片
    List<SFPipeinePhotoAttachment> selectPipelineImg(@Param("optimauthId") String optimauthId);
    //查询店铺所有落位图
    List<SFPipeinePhotoAttachment> selectPipelineLocationImg(@Param("optimauthId") String optimauthId);

    //查询加盟店铺房屋租赁协议
    List<SFRentalProposalAttachment> selectRentalAttachMentImgJM(@Param("optimauthId") String optimauthId);

    //查询意向店政策支持项
    List<SFPolicySupportDetail> selectFPolicySupportDetail(@Param("optimauthId") String optimauthId);

    //查询意向店商圈图片集合
    List<SFTradezoneInfo> selectTradezoneInfo(@Param("optimauthId") String optimauthId);

    //查询意向店风格集合
    List<CSSfPipeline> selectCSSfPipelineStoreImage(@Param("optimauthId") String optimauthId);

     //查询意向店系列面积占比
    List<SFStyleAreaPerInfo> selectSFStyleAreaPerInfo(@Param("optimauthId") String optimauthId);




    //查询合伙人投资测算非人力成本
    TSfEstInvestmentNonLaborCost selectTSfEstInvestmentNonLaborCost(@Param("optimauthId") String optimauthId);
    //查询合伙人投资测算测算结果
    TSfEstInvestmentResultDateCopartner selectTSfEstInvestmentResultDateCopartner(@Param("optimauthId") String optimauthId);
    //查询合伙人人流量详细信息
    List<SFTrafficcountDetail> selectCopartnerSFTrafficcountDetail(@Param("optimauthId") String optimauthId);
    //查询合伙人流量
    SFTrafficcount selectCopartnerSFTrafficcount(@Param("optimauthId") String optimauthId);
    //查询合伙人店铺房屋租赁协议
    List<SFRentalProposalAttachment> selectRentalAttachMentImgHH(@Param("optimauthId") String optimauthId);
    //查询合伙人收入分成占比
    List<SFEstInvestmentIncomeSharing> selectSFEstInvestmentIncomeSharing(@Param("optimauthId") String optimauthId);
    //查询合伙人收入分成占比小计
    SFEstInvestmentIncomeSharing selectSFEstInvestmentIncomeSharingTotal(@Param("optimauthId") String optimauthId);
}
