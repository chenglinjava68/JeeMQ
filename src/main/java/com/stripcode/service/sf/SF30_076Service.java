package com.stripcode.service.sf;

import com.stripcode.core.dto.common.CreateOrModifyInvestmentCopartnerDto;
import com.stripcode.core.util.UUIDUtils;
import com.stripcode.mybatis.cs.model.TCsTaskCompletion;
import com.stripcode.mybatis.sf.dao.*;
import com.stripcode.mybatis.sf.model.*;
import com.stripcode.service.BaseService;
import com.stripcode.service.cs.TCsTaskCompletionService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Metro on 2016/11/21.
 */
@Service
@CacheConfig(cacheNames = "sfStorePhotoAttachement")
public class SF30_076Service extends BaseService {
    @Autowired
    private TCsTaskCompletionService tCsTaskCompletionService;

    @Autowired
    private SFEstInvestmentMapper sfEstInvestmentMapper;
    @Autowired
    private TSfEstInvestmentDetailCopartnerStoreMapper investmentDetailCopartnerStoreMapper;
    @Autowired
    private TSfEstInvestmentPayrollForecastCopartnerMapper investmentPayrollForecastCopartnerMapper;
    @Autowired
    private TSfEstInvestmentOtherCostRateMapper investmentOtherCostRateMapper;
    @Autowired
    private TSfEstInvestmentNonLaborCostMapper investmentNonLaborCostMapper;
    @Autowired
    private TSfEstInvestmentResultDateCopartnerMapper investmentResultDateCopartnerMapper;
    @Autowired
    private SFEstInvestmentIncomeSharingMapper sfEstInvestmentIncomeSharingMapper;

    @Autowired
    private SFRentalProposalCopartnerStoreMapper sfRentalProposalCopartnerStoreMapper;
    //获取合伙人投资测算信息
    @Transactional
    public Map saveInvestmentCopartner(CreateOrModifyInvestmentCopartnerDto dto)
    {
        TSfEstInvestmentDetailCopartnerStore investmentDetailCopartnerStore = dto.getInvestmentDetailCopartnerStore();
        List<TSfEstInvestmentPayrollForecastCopartner> investmentPayrollForecastCopartnerList
                = dto.getInvestmentPayrollForecastCopartnerList();
        TSfEstInvestmentNonLaborCost investmentNonLaborCost = dto.getInvestmentNonLaborCost();
        TSfEstInvestmentOtherCostRate investmentOtherCostRate = dto.getInvestmentOtherCostRate();
        TSfEstInvestmentResultDateCopartner investmentResultDateCopartner = dto.getInvestmentResultDateCopartner();
        SFEstInvestment investment = dto.getInvestment();
        TCsTaskCompletion tCsTaskCompletion = dto.gettCsTaskCompletion();
        List<SFEstInvestmentIncomeSharing> investmentIncomeSharings = dto.getInvestmentIncomeSharings();
        Map modelMap = new HashMap<String,String>();
        //定义是否成功 用于判断
        boolean result = true;
        //定义后台返回数据
        String message = "保存成功";
        //判断新增还是修改
        int count = -1;
        if(investmentResultDateCopartner != null){
            investment.setCompanyUc1(investmentResultDateCopartner.getCompanyUcFir());
            investment.setCompanyUc2(investmentResultDateCopartner.getCompanyUcSec());
            investment.setCompanyUc3(investmentResultDateCopartner.getCompanyUcThi());
            investment.setCompanyUc4(investmentResultDateCopartner.getCompanyUcFour());
            investment.setCompanyUc5(investmentResultDateCopartner.getCompanyUcFive());
        }
        if(StringUtils.isBlank(investment.getRowId())){
            investment.setRowId(UUIDUtils.generateKey());
            count = sfEstInvestmentMapper.insertEstInvestment(investment);
            if (count != 1)result = false;
        }else {
            count = sfEstInvestmentMapper.updateEstInvestment(investment);
            if (count != 1)result = false;
        }

        //人力成本 基本信息
        if(investmentDetailCopartnerStore!=null)
        {
            if(investment != null ){
                investmentDetailCopartnerStore.setInvestmentId(investment.getRowId());
            }
            if (StringUtils.isBlank(investmentDetailCopartnerStore.getRowId())) {
                investmentDetailCopartnerStore.setRowId(UUIDUtils.generateKey());
                count = investmentDetailCopartnerStoreMapper.insertInvestmentDetailCopartnerStore(investmentDetailCopartnerStore);
                if (count != 1)result = false;
            } else {
                count = investmentDetailCopartnerStoreMapper.updateInvestmentDetailCopartnerStore(investmentDetailCopartnerStore);
                if (count != 1)result = false;
            }
        }

        //人力成本 薪资预测
        if(investmentPayrollForecastCopartnerList!=null && investmentPayrollForecastCopartnerList.size()!=0)
        {
            for (TSfEstInvestmentPayrollForecastCopartner investmentPayrollForecastCopartner : investmentPayrollForecastCopartnerList)
            {
                if(investment != null ){
                    investmentPayrollForecastCopartner.setInvestmentId(investment.getRowId());
                }
                if (StringUtils.isBlank(investmentPayrollForecastCopartner.getRowId())) {
                    investmentPayrollForecastCopartner.setRowId(UUIDUtils.generateKey());
                    count = investmentPayrollForecastCopartnerMapper.insertInvestmentPayrollForecastCopartner(investmentPayrollForecastCopartner);
                    if (count != 1)result = false;
                } else {
                    count = investmentPayrollForecastCopartnerMapper.updateInvestmentPayrollForecastCopartner(investmentPayrollForecastCopartner);
                    if (count != 1)result = false;
                }
            }
        }

        //非人力成本
        if(investmentNonLaborCost!=null)
        {
            if(investment != null ){
                investmentNonLaborCost.setInvestmentId(investment.getRowId());
            }
            if (StringUtils.isBlank(investmentNonLaborCost.getRowId())) {
                investmentNonLaborCost.setRowId(UUIDUtils.generateKey());
                count = investmentNonLaborCostMapper.insertInvestmentNonLaborCost(investmentNonLaborCost);
                if (count != 1)result = false;
            } else {
                count = investmentNonLaborCostMapper.updateInvestmentNonLaborCost(investmentNonLaborCost);
                if (count != 1)result = false;
            }
        }
        //非人力成本 收入分成
        if(investmentIncomeSharings!=null && investmentIncomeSharings.size()!=0)
        {
            for (SFEstInvestmentIncomeSharing investmentIncomeSharing : investmentIncomeSharings)
            {
                if(investment != null ){
                    investmentIncomeSharing.setInvestmentId(investment.getRowId());
                }
                if (StringUtils.isBlank(investmentIncomeSharing.getRowId())) {
                    investmentIncomeSharing.setRowId(UUIDUtils.generateKey());
                    count = sfEstInvestmentIncomeSharingMapper.insert(investmentIncomeSharing);
                    if (count != 1)result = false;
                } else {
                    count = sfEstInvestmentIncomeSharingMapper.updateByPrimaryKey(investmentIncomeSharing);
                    if (count != 1)result = false;
                }
            }
        }
        //其他成本费率
        if(investmentOtherCostRate!=null)
        {
            if(investment != null ){
                investmentOtherCostRate.setInvestmentId(investment.getRowId());
            }
            if (StringUtils.isBlank(investmentOtherCostRate.getRowId())) {
                investmentOtherCostRate.setRowId(UUIDUtils.generateKey());
                count = investmentOtherCostRateMapper.insertInvestmentOtherCostRate(investmentOtherCostRate);
                if (count != 1)result = false;
            } else {
                count = investmentOtherCostRateMapper.updateInvestmentOtherCostRate(investmentOtherCostRate);
                if (count != 1)result = false;
            }
        }

        //测算
        if(investmentResultDateCopartner!=null)
        {
            if(investment != null ){
                investmentResultDateCopartner.setInvestmentId(investment.getRowId());
            }
            if (StringUtils.isBlank(investmentResultDateCopartner.getRowId())) {
                investmentResultDateCopartner.setRowId(UUIDUtils.generateKey());
                count = investmentResultDateCopartnerMapper.insertInvestmentResultDateCopartner(investmentResultDateCopartner);
                if (count != 1)result = false;
            } else {
                count = investmentResultDateCopartnerMapper.updateInvestmentResultDateCopartner(investmentResultDateCopartner);
                if (count != 1)result = false;
            }
        }

        if(dto.getInvestment() != null){
            modelMap.put("rowId",dto.getInvestment().getRowId());
            modelMap.put("attachId",dto.getInvestment().getAttachId());
        }
        tCsTaskCompletionService.upateStatusToFinished(tCsTaskCompletion);
        modelMap.put("result", true);
        modelMap.put("message", "保存成功！");
        return modelMap;
    }

    public CreateOrModifyInvestmentCopartnerDto selectInvestmentCopartner(String ppId,String investmentId)
    {
        CreateOrModifyInvestmentCopartnerDto dto = new CreateOrModifyInvestmentCopartnerDto();

        //人力成本 基本信息
        TSfEstInvestmentDetailCopartnerStore investmentDetailCopartnerStore = null;
        if(StringUtils.isNotBlank(investmentId)){
            investmentDetailCopartnerStore = investmentDetailCopartnerStoreMapper.selectInvestmentDetailCopartnerStore(investmentId);
        }else{
            investmentDetailCopartnerStore = investmentDetailCopartnerStoreMapper.selectByPPId(ppId);
        }
        dto.setInvestmentDetailCopartnerStore(investmentDetailCopartnerStore);
        //人力成本 薪资预测
        List<TSfEstInvestmentPayrollForecastCopartner> payrollForecastCopartnerList
                = investmentPayrollForecastCopartnerMapper.selectInvestmentPayrollForecastCopartner(investmentId);
        dto.setInvestmentPayrollForecastCopartnerList(payrollForecastCopartnerList);

        //非人力成本

        TSfEstInvestmentNonLaborCost investmentNonLaborCost = null;
        List<SFEstInvestmentIncomeSharing> investmentIncomeSharings = null;
        if(StringUtils.isBlank(investmentId)){
            investmentNonLaborCost = sfRentalProposalCopartnerStoreMapper.selectProposalForInvestment(ppId);
            investmentIncomeSharings = sfEstInvestmentIncomeSharingMapper.selectByPPId(ppId);
        }else{
            investmentNonLaborCost = investmentNonLaborCostMapper.selectInvestmentNonLaborCost(investmentId);
            investmentIncomeSharings = sfEstInvestmentIncomeSharingMapper.selectByInvestmentId(investmentId);
        }
        dto.setInvestmentNonLaborCost(investmentNonLaborCost);
        //收入分成

        dto.setInvestmentIncomeSharings(investmentIncomeSharings);
        //其他成本费率
        TSfEstInvestmentOtherCostRate investmentOtherCostRate = investmentOtherCostRateMapper.selectInvestmentOtherCostRate(investmentId);
        dto.setInvestmentOtherCostRate(investmentOtherCostRate);

        //测算
        TSfEstInvestmentResultDateCopartner investmentResultDateCopartner = investmentResultDateCopartnerMapper.selectInvestmentResultDateCopartner(investmentId);
        dto.setInvestmentResultDateCopartner(investmentResultDateCopartner);
        return dto;
    }

    @Transactional
    public Map delete(String rowId)
    {
        Map modelMap = new HashMap();
        //定义后台返回数据
        investmentDetailCopartnerStoreMapper.deleteByInvestmentId(rowId);
        investmentPayrollForecastCopartnerMapper.deleteByInvestmentId(rowId);
        investmentNonLaborCostMapper.deleteByInvestmentId(rowId);
        sfEstInvestmentIncomeSharingMapper.deleteByInvestmentId(rowId);
        investmentOtherCostRateMapper.deleteByInvestmentId(rowId);
        investmentResultDateCopartnerMapper.deleteByInvestmentId(rowId);
        sfEstInvestmentMapper.deleteById(rowId);
        modelMap.put("result", true);
        modelMap.put("message", "保存成功！");
        return modelMap;
    }


}
