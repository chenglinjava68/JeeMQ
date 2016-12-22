package com.stripcode.service.sf;

import com.stripcode.core.dto.common.CreateOrModifySFEstInvestmentDto;
import com.stripcode.core.util.UUIDUtils;
import com.stripcode.mybatis.cs.model.TCsTaskCompletion;
import com.stripcode.mybatis.sf.dao.*;
import com.stripcode.mybatis.sf.model.*;
import com.stripcode.mybatis.user.dao.TCodeMacroDefineMapper;
import com.stripcode.mybatis.user.model.TCodeMacroDefine;
import com.stripcode.service.BaseService;
import com.stripcode.service.cs.TCsTaskCompletionService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Metro on 2016/11/08.
 */
@Service
@CacheConfig(cacheNames = "sfStorePhotoAttachement")
public class SF30_022Service extends BaseService {
    @Autowired
    private SFEstInvestmentDetailDiretStoreMapper investmentDetailDiretStoreMapper;
    @Autowired
    private SFEstInvestmentPayrollForecastMapper investmentPayrollForecastMapper;
    @Autowired
    private SFEstInvestmentSalesYearMapper investmentSalesYearMapper;
    @Autowired
    private SFEstInvestmentRoiMapper investmentRoiMapper;
    @Autowired
    private SFTrafficcountDetailMapper trafficcountDetailMapper;
    @Autowired
    private SFTrafficcountMapper trafficcountMapper;
    @Autowired
    private SFBudGetEstimationCostMapper budGetEstimationCostMapper;
    @Autowired
    private SFEstInvestmentCostMapper investmentCostMapper;
    @Autowired
    private TCsTaskCompletionService tCsTaskCompletionService;

    @Autowired
    private SFEstInvestmentMapper sfEstInvestmentMapper;
    @Autowired
    private SFEstInvestmentIncomeSharingMapper sfEstInvestmentIncomeSharingMapper;

    @Autowired
    private TCodeMacroDefineMapper tCodeMacroDefineMapper;
    @Autowired
    private SfEstInvestmentOtherCostRateDiretStoreMapper sfEstInvestmentOtherCostRateDiretStoreMapper;
    @Autowired
    private SFRentalProposalDirectStoreMapper sfRentalProposalDirectStoreMapper;

    //保存修改
    @Transactional
    public Map update(CreateOrModifySFEstInvestmentDto dto) {
        Map modelMap = new HashMap();
        SFEstInvestmentDetailDiretStore investmentDetailDiretStore = dto.getInvestmentDetailDiretStore();
        List<SFEstInvestmentPayrollForecast> list = dto.getList();
        List<SFEstInvestmentSalesYear> salesYearsList = dto.getSalesYearsList();
        SFEstInvestmentRoi investmentRoi = dto.getInvestmentRoi();
        List<SFEstInvestmentCost> costList = dto.getCostList();
        SFEstInvestment investment = dto.getInvestment();
        TCsTaskCompletion tCsTaskCompletion = dto.gettCsTaskCompletion();
        SfEstInvestmentOtherCostRateDiretStore investmentOtherCostRateDiretStore = dto.getInvestmentOtherCostRateDiretStore();
        List<SFEstInvestmentIncomeSharing> investmentIncomeSharings = dto.getInvestmentIncomeSharings();
        //定义是否成功 用于判断
        boolean result = true;
        //定义后台返回数据
        String message = "保存成功";
        //判断新增还是修改
        int count = -1;
        if (investmentRoi != null) {
            investment.setCalbackYear(investmentRoi.getPaybackPeriodY5());
            investment.setIrr(investmentRoi.getRateOfReturnY5());
            investment.setUc(investmentRoi.getNetPresentValueY5());
        }
        if (StringUtils.isBlank(investment.getRowId())) {
            investment.setRowId(UUIDUtils.generateKey());
            count = sfEstInvestmentMapper.insertEstInvestment(investment);
            if (count != 1) result = false;
        } else {
            count = sfEstInvestmentMapper.updateEstInvestment(investment);
            if (count != 1) result = false;
        }
        if (investmentDetailDiretStore != null) {
            if (investment != null) {
                investmentDetailDiretStore.setInvestmentId(investment.getRowId());
            }
            if (StringUtils.isBlank(investmentDetailDiretStore.getRowId())) {
                //随机rowId
                investmentDetailDiretStore.setRowId(UUIDUtils.generateKey());
                //执行新增操作
                count = investmentDetailDiretStoreMapper.insertEstInvestmentDetailDiretStore(investmentDetailDiretStore);
                if (count != 1) result = false;
            } else {
                //执行修改操作
                count = investmentDetailDiretStoreMapper.updateEstInvestmentDetailDiretStore(investmentDetailDiretStore);
                if (count != 1) result = false;
            }
        }
        if (list != null && list.size() != 0) {
            for (SFEstInvestmentPayrollForecast investmentPayrollForecast : list) {
                if (investment != null) {
                    investmentPayrollForecast.setInvestmentId(investment.getRowId());
                }
                if (StringUtils.isBlank(investmentPayrollForecast.getRowId())) {
                    //随机rowId
                    investmentPayrollForecast.setRowId(UUIDUtils.generateKey());
                    //执行新增操作
                    count = investmentPayrollForecastMapper.insertEstInvestmentPayrollForecast(investmentPayrollForecast);
                    if (count != 1) result = false;
                } else {
                    //执行修改操作
                    count = investmentPayrollForecastMapper.updateEstInvestmentPayrollForecast(investmentPayrollForecast);
                    if (count != 1) result = false;
                }
            }
        }
        if (investmentIncomeSharings != null && investmentIncomeSharings.size() != 0) {
            for (SFEstInvestmentIncomeSharing investmentIncomeSharing : investmentIncomeSharings) {
                if (investment != null) {
                    investmentIncomeSharing.setInvestmentId(investment.getRowId());
                }
                if (StringUtils.isBlank(investmentIncomeSharing.getRowId())) {
                    //随机rowId
                    investmentIncomeSharing.setRowId(UUIDUtils.generateKey());
                    //执行新增操作
                    count = sfEstInvestmentIncomeSharingMapper.insert(investmentIncomeSharing);
                    if (count != 1) result = false;
                } else {
                    //执行修改操作
                    count = sfEstInvestmentIncomeSharingMapper.updateByPrimaryKey(investmentIncomeSharing);
                    if (count != 1) result = false;
                }
            }
        }

        if (salesYearsList != null && salesYearsList.size() != 0) {
            for (SFEstInvestmentSalesYear investmentSalesYear : salesYearsList) {
                if (investment != null) {
                    investmentSalesYear.setInvestmentId(investment.getRowId());
                }
                if (StringUtils.isBlank(investmentSalesYear.getRowId())) {
                    //随机rowId
                    investmentSalesYear.setRowId(UUIDUtils.generateKey());
                    //执行新增操作
                    count = investmentSalesYearMapper.insertEstInvestmentSalesYearMapper(investmentSalesYear);
                    if (count != 1) result = false;
                } else {
                    //执行修改操作
                    count = investmentSalesYearMapper.updateEstInvestmentSalesYearMapper(investmentSalesYear);
                    if (count != 1) result = false;
                }
            }
        }

        //前端新增时从T_SF_PROJECT_ESTIMATION表取成本测算保存到T_SF_EST_INVESTMENT_COST表
        if (costList != null && costList.size() != 0) {
            for (SFEstInvestmentCost investmentCost : costList) {
                if (investment != null) {
                    investmentCost.setInvestmentId(investment.getRowId());
                }
                if (StringUtils.isBlank(investmentCost.getRowId())) {
                    //随机rowId
                    investmentCost.setRowId(UUIDUtils.generateKey());
                    //执行成本测算新增
                    count = investmentCostMapper.insertEstInvestmentCost(investmentCost);
                    if (count != 1) result = false;
                } else {
                    //执行成本测算修改
                    count = investmentCostMapper.updateEstInvestmentCost(investmentCost);
                    if (count != 1) result = false;
                }
            }
        }
        //其他费率
        if (investmentOtherCostRateDiretStore != null) {
            if (investment != null) {
                investmentOtherCostRateDiretStore.setInvestmentId(investment.getRowId());
            }
            if (StringUtils.isBlank(investmentOtherCostRateDiretStore.getRowId())) {
                //随机rowId
                investmentOtherCostRateDiretStore.setRowId(UUIDUtils.generateKey());
                //执行新增操作
                count = sfEstInvestmentOtherCostRateDiretStoreMapper.insert(investmentOtherCostRateDiretStore);
                if (count != 1) result = false;
            } else {
                //执行修改操作
                count = sfEstInvestmentOtherCostRateDiretStoreMapper.updateByPrimaryKey(investmentOtherCostRateDiretStore);
                if (count != 1) result = false;
            }
        }
        //测算 投资回报测算
        if (investmentRoi != null) {
            if (investment != null) {
                investmentRoi.setInvestmentId(investment.getRowId());
            }
            if (StringUtils.isBlank(investmentRoi.getRowId())) {
                //随机rowId
                investmentRoi.setRowId(UUIDUtils.generateKey());
                //执行新增操作
                count = investmentRoiMapper.insertEstInvestmentRoiMapper(investmentRoi);
                if (count != 1) result = false;
            } else {
                //执行修改操作
                count = investmentRoiMapper.updateEstInvestmentRoiMapper(investmentRoi);
                if (count != 1) result = false;
            }
        }

        if (investment != null) {
            modelMap.put("rowId", dto.getInvestment().getRowId());
            modelMap.put("attachId", dto.getInvestment().getAttachId());
        }
        tCsTaskCompletionService.upateStatusToFinished(tCsTaskCompletion);
        modelMap.put("result", true);
        modelMap.put("message", "保存成功！");
        return modelMap;
    }
    //保存修改
    @Transactional
    public Map delete(String rowId) {
        Map modelMap = new HashMap();
        //定义后台返回数据
        investmentDetailDiretStoreMapper.deleteByInvestmentId(rowId);
        investmentPayrollForecastMapper.deleteByInvestmentId(rowId);
        sfEstInvestmentIncomeSharingMapper.deleteByInvestmentId(rowId);
        investmentSalesYearMapper.deleteByInvestmentId(rowId);
        investmentCostMapper.deleteByInvestmentId(rowId);
        sfEstInvestmentOtherCostRateDiretStoreMapper.deleteByInvestmentId(rowId);
        investmentRoiMapper.deleteByInvestmentId(rowId);
        sfEstInvestmentMapper.deleteById(rowId);
        modelMap.put("result", true);
        modelMap.put("message", "保存成功！");
        return modelMap;
    }

    @Transactional
    public CreateOrModifySFEstInvestmentDto selectInvestmentInfo(String investmentId, String ppId) {
        CreateOrModifySFEstInvestmentDto dto = new CreateOrModifySFEstInvestmentDto();
        List<TCodeMacroDefine> yesNoList = tCodeMacroDefineMapper.queryYesNoList();
        dto.setYesNoList(yesNoList);
        List<TCodeMacroDefine> rateList = tCodeMacroDefineMapper.queryStoreTaxRateList();
        dto.setRateList(rateList);
        if (StringUtils.isNotBlank(investmentId)) {
            //人力成本 基本信息
            SFEstInvestmentDetailDiretStore investmentDetailDiretStore = investmentDetailDiretStoreMapper.selectEstInvestmentDetailDiretStore(investmentId);
            dto.setInvestmentDetailDiretStore(investmentDetailDiretStore);
            //人力成本 薪资预测
            List<SFEstInvestmentPayrollForecast> list = investmentPayrollForecastMapper.selectEstInvestmentPayrollForecast(investmentId);
            dto.setList(list);

            //测算 投资回报测算
            SFEstInvestmentRoi investmentRoi = investmentRoiMapper.selectEstInvestmentRoiMapper(investmentId);
            dto.setInvestmentRoi(investmentRoi);

            //非人力成本 合同期内分年业绩
            List<SFEstInvestmentSalesYear> salesYearsList = investmentSalesYearMapper.selectEstInvestmentSalesYearMapper(investmentId);
            dto.setSalesYearsList(salesYearsList);
            //成本测算investmentId无值时从T_SF_PROJECT_ESTIMATION表取值
            Map<String, String> map = new HashMap<String, String>();
            map.put("investmentId", investmentId);
            map.put("itemCodes", "M0416");
            //成本测算 装修成本
            List<SFBudGetEstimationCost> list0 = investmentCostMapper.selectEstInvestmentCost(map);
            dto.setList0(list0);
            map.put("itemCodes", "M0417");
            //成本测算 辅料成本
            List<SFBudGetEstimationCost> list1 = investmentCostMapper.selectEstInvestmentCost(map);
            dto.setList1(list1);
            map.put("itemCodes", "M0418");
            //成本测算 固定资产折旧
            List<SFBudGetEstimationCost> list2 = investmentCostMapper.selectEstInvestmentCost(map);
            dto.setList2(list2);
            //意向店类型品牌及销售预付
            List<SFEstInvestmentIncomeSharing> investmentIncomeSharings = sfEstInvestmentIncomeSharingMapper.selectByInvestmentIdForDirect(investmentId);
            dto.setInvestmentIncomeSharings(investmentIncomeSharings);
            //其他费率
            SfEstInvestmentOtherCostRateDiretStore investmentOtherCostRateDiretStore = sfEstInvestmentOtherCostRateDiretStoreMapper.selectByInvestmentId(investmentId);
            dto.setInvestmentOtherCostRateDiretStore(investmentOtherCostRateDiretStore);
        } else {
            SFEstInvestmentDetailDiretStore investmentDetailDiretStore = sfRentalProposalDirectStoreMapper.selectForDirect(ppId);
            dto.setInvestmentDetailDiretStore(investmentDetailDiretStore);
            List<SFEstInvestmentSalesYear> salesYearsList = investmentSalesYearMapper.selectRentalDetailMapper(ppId);
            dto.setSalesYearsList(salesYearsList);

            //成本测算investmentId无值时从T_SF_PROJECT_ESTIMATION表取值
            Map<String, String> map = new HashMap<String, String>();
            map.put("ppId", ppId);
            map.put("itemCodes", "M0416");
            //成本测算 装修成本
            List<SFBudGetEstimationCost> list0 = budGetEstimationCostMapper.SelectEstimationForInvest(map);
            dto.setList0(list0);
            map.put("itemCodes", "M0417");
            //成本测算 辅料成本
            List<SFBudGetEstimationCost> list1 = budGetEstimationCostMapper.SelectEstimationForInvest(map);
            dto.setList1(list1);
            map.put("itemCodes", "M0418");
            //成本测算 固定资产折旧
            List<SFBudGetEstimationCost> list2 = budGetEstimationCostMapper.SelectEstimationForInvest(map);
            dto.setList2(list2);
            //意向店类型品牌及销售预付
            List<SFEstInvestmentIncomeSharing> investmentIncomeSharings = sfEstInvestmentIncomeSharingMapper.selectByPPIdForDirect(ppId);
            dto.setInvestmentIncomeSharings(investmentIncomeSharings);
        }
        return dto;
    }

    @Transactional
    public void insertSFTrafficcount(Map<String, Object> map, TCsTaskCompletion tCsTaskCompletion) {
        List<SFTrafficcountDetail> list = (List) map.get("list");
        SFTrafficcount trafficcount = (SFTrafficcount) map.get("trafficcount");
        String ppId = (String) map.get("ppId");
        trafficcount.setRowId(UUIDUtils.generateKey());
        trafficcount.setPpId(ppId);
        trafficcount.setAttachId((String) map.get("attachId"));
        trafficcountMapper.insertTrafficcount(trafficcount);
        if (list != null && list.size() > 0) {
            for (SFTrafficcountDetail trafficcountDetail : list) {
                trafficcountDetail.setTestId(trafficcount.getRowId());
        tCsTaskCompletion.setRowId(UUIDUtils.generateKey());
        tCsTaskCompletion.setCreateTime(null);
        tCsTaskCompletion.setOptimauthId(ppId);
        tCsTaskCompletionService.upateStatusToFinished(tCsTaskCompletion);
        tCsTaskCompletionService.updatePipelineType(tCsTaskCompletion.getTaskId(), ppId);
        //执行新增操作
        trafficcountDetailMapper.insertTrafficcountDetail(trafficcountDetail);
    }
}
    }

    @Transactional
    public HashMap<String,Object> selectSFTrafficcount(String ppId) {
        HashMap<String, Object> map = new HashMap<String, Object>();
        List<SFTrafficcount> traffList = trafficcountMapper.selectTrafficcount(ppId);
        List<SFTrafficcountDetail> traffDetailList = new ArrayList<SFTrafficcountDetail>();
        if(traffList.size() > 0){
            traffDetailList = trafficcountDetailMapper.selectTrafficcountDetail(traffList.get(0).getRowId());

        }
        map.put("traffList", traffList);
        map.put("traffDetailList", traffDetailList);
        return map;
    }

    @Transactional
    public List<SFTrafficcountDetail> selectSFTrafficcountDetail(String testId) {
        List<SFTrafficcountDetail> traffDetailList =
                trafficcountDetailMapper.selectTrafficcountDetail(testId);
        return traffDetailList;
    }

    @Transactional
    public Map updateSFTrafficcount(String rowId, String ppId) {
        Map<String, Object> map = new HashMap<String, Object>();
        Map<String, String> traffMap = new HashMap<String, String>();
        Boolean result = true;
        String message = "状态更新成功!";
        Integer count = -1;
        traffMap.put("ppId", ppId);
        traffMap.put("useStatus", "M0044");
        count = trafficcountMapper.updateTrafficcount(traffMap);
        traffMap.put("useStatus", "M0043");
        traffMap.put("rowId", rowId);
        count = trafficcountMapper.updateTrafficcount(traffMap);
        if (count == 0) {
            result = false;
            message = "状态更新失败!";
        }
        map.put("result", result);
        map.put("message", message);
        return map;
    }
}
