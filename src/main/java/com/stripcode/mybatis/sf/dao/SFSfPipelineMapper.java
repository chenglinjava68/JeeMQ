package com.stripcode.mybatis.sf.dao;

import com.github.pagehelper.Page;
import com.stripcode.core.dto.sf.QueryCSpipeLineDto;
import com.stripcode.mybatis.cp.model.CpMarketInfo;
import com.stripcode.mybatis.cs.model.CSCustomerErpInfo;
import com.stripcode.mybatis.cs.model.CSCustomerInfo;
import com.stripcode.mybatis.cs.model.CSNewMarketAuz;
import com.stripcode.mybatis.cs.model.CSSfPipeline;
import com.stripcode.mybatis.sf.model.*;
import com.stripcode.mybatis.user.model.RscSysUser;

import java.util.List;
import java.util.Map;

/**
 * Created by Metro on 2016/9/12.
 */
public interface SFSfPipelineMapper {
    /*
    * 列表带分页的查询数据
    * */
    Page<CSSfPipeline> queryForPage(Map<String,Object> object);
    /*
    *查询ppId
    * */
    CSSfPipeline selectLoad(String ppId);
    /*
    *查询customerId
    * */
    CSSfPipeline selectCustomer(String customerId);
    /*
    *增加
    * */
    int insert(CSSfPipeline model);
    /*
    *编辑
    * */
    int update(CSSfPipeline model);
    /*
    * 新增页面查询下拉框ERP市场名称
    * */
    List<CSCustomerErpInfo> selectErpName(String customerId);

    //查询品牌
    CSNewMarketAuz selectBrand(String erpCode);
    Page<CSSfPipeline> selectMapListForPage(QueryCSpipeLineDto params);

    List<CSCustomerInfo> selectErpCustomerAll();
    List<CpMarketInfo> selectMarketInfo(String marketId);
    //查询下拉框开发人员
    List<RscSysUser> selectAllUser();
    /**
     *
     * 导出
     * @return
     */
    List<CSSfPipeline> selectForExport(Map<String,Object> Object);
    CSCustomerInfo selectById(String customerId);

    /**
     * 查询直营报批ppt所需数据
     * @param ppId
     * @return
     */
    CSSfPipeline selectPipeline(String ppId);

    /**
     *查询ppt周边租金信息
     * @param ppId
     * @return
     */
    List<SFRentInfo> selectRentInfoByppId(String ppId);

    /**
     * 查询ppt各楼层面积信息
     * @param ppId
     * @return
     */
    List<SFFloorInfo> selectFloorInfo(String ppId);

    /**
     * 查询ppt竞品(原年租金信息)
     * @param ppId
     * @return
     */
    List<SFRentalDetail> selectRentalDetail(String ppId);

    /**
     * 查询ppt店铺平面图集合
     * @param ppId
     * @return
     */
    List<SFLandlordLayout> selectLandlordLayoutPlanImg(String ppId);

    /**
     * 查询ppt物业平面图集合
     * @param ppId
     * @return
     */
    List<SFLandlordLayout> selectLandlordLayoutPropertyImg(String ppId);

    /**
     * 查询ppt商圈图
     * @param ppId
     * @return
     */
    List<SFTradezoneInfo> selectTradezoneInfo(String ppId);

    /**
     * 查询ppt人流量详细信息
     * @param ppId
     * @return
     */
    List<SFTrafficcountDetail> selectTrafficcountDetail(String ppId);

    /**
     * 查询ppt人流量信息
     * @param ppId
     * @return
     */
    SFTrafficcount selectSFTrafficcount(String ppId);

    /**
     *查询ppt意向店新址照片
     * @param ppId
     * @return
     */
    List<SFPipeinePhotoAttachment> selectPipeinePhotoAttachment(String ppId);
    /**
     *查询ppt意向店新址周边照片
     * @param ppId
     * @return
     */
    List<SFPipeinePhotoAttachment> selectPipeinePhotoAttachmentOther(String ppId);
    /**
     *查询ppt意向店落位图
     * @param ppId
     * @return
     */
    List<SFPipeinePhotoAttachment> selectPipeineLocationImgList(String ppId);

    /**
     * 查询ppt商圈竞品集合(待用)
     * @param ppId
     * @return
     */
    List<SFTradezoneCiuInfo> selectTradezoneCiuInfo(String ppId);

    /**
     * 查询ppt商圈现有店数量
     * @param ppId
     * @return
     */
    List<SFTradezoneStoreInfo> selectSFTradezoneStoreInfo(String ppId);

    /**
     * 查询ppt工程概算信息
     * @param ppId
     * @return
     */
    List<SFBudGetEstimationCost> selectBudGetEstimationCostInfo(String ppId);

    /**
     * 查询ppt投资回报测算信息
     * @param ppId
     * @return
     */
    SFEstInvestmentRoi selectEstInvestmentRoi(String ppId);

    /**
     * 查询ppt商务条款业主信息集合
     * @param ppId
     * @return
     */
    List<SFLandlordinfo> selectLandlordinfo(String ppId);

    /**
     * 查询ppt意向店店铺形象
     * @param ppId
     * @return
     */
    List<CSSfPipeline> selectCSSfPipelineStoreImage(String ppId);

    /**
     * 查询意向店风格面积占比
     * @param ppId
     * @return
     */
    List<SFStyleAreaPerInfo> selectSFStyleAreaPerInfo(String ppId);

    /**
     * 查询意向店销售占比
     * @param ppId
     * @return
     */
    List<SFStyleAreaPerInfo> selectSFStyleSalesPerInfo(String ppId);

    /**
     * 查询总资本性支出
     * @param ppId
     * @return
     */
    SFEstInvestmentCost selectEstInvestmentCostTotal(String ppId);

    CSSfPipeline queryStoreInfo(String ppId);
}
