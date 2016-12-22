package com.stripcode.service.sf;

import com.stripcode.core.util.UUIDUtils;
import com.stripcode.mybatis.cs.model.TCsTaskCompletion;
import com.stripcode.mybatis.sf.dao.*;
import com.stripcode.mybatis.sf.model.*;
import com.stripcode.service.cs.TCsTaskCompletionService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Metro
 */
@Service
@CacheConfig(cacheNames = "SF30_018Service")
public class SF30_018Service {

    @Autowired
    private SFConsSurveyReportAerationMapper aerationMapper;

    @Autowired
    private SFConsSurveyReportCoverMapper coverMapper;

    @Autowired
    private SFConsSurveyReportHydropowerMapper hydropowerMapper;

    @Autowired
    private SFConsSurveyReportPropertyMapper propertyMapper;

    @Autowired
    private SFConsSurveyReportOthersMapper othersMapper;

    @Autowired
    private TCsTaskCompletionService tCsTaskCompletionService;

    @Autowired
    private SF30_013Service sf30_013Service;

    public TSfConsSurveyReportCover queryAll(String ppId){

        TSfConsSurveyReportAeration aerationNoNull = new TSfConsSurveyReportAeration();
        TSfConsSurveyReportHydropower hydropowerNoNull = new TSfConsSurveyReportHydropower();
        TSfConsSurveyReportProperty propertyNoNull = new TSfConsSurveyReportProperty();
        TSfConsSurveyReportOthers othersNoNull = new TSfConsSurveyReportOthers();

        TSfConsSurveyReportCover cover = coverMapper.queryCover(ppId);
        SFConsPreSurveyReport report = sf30_013Service.queryReport(ppId);
        TSfConsSurveyReportAeration aeration = aerationMapper.queryAeration(ppId);
        TSfConsSurveyReportHydropower hydropower = hydropowerMapper.queryHydropower(ppId);
        TSfConsSurveyReportProperty property = propertyMapper.queryProperty(ppId);
        TSfConsSurveyReportOthers others = othersMapper.queryOthers(ppId);

        if(cover!=null){
            aeration.setSummerOutdoorTemp(report.getSummerOutdoorTemp());
            aeration.setWinterOutdoorTemp(report.getWinterOutdoorTemp());
            aeration.setAirConditionMode(report.getAirConditionMode());
            aeration.setAirConditionSupply(report.getAirConditionSupply());
            aeration.setFanHeatEffect(report.getFanHeatEffect());
            aeration.setNoiseEffect(report.getNoiseEffect());
            aeration.setIsEnvironmentalPermits(report.getIsEnvironmentalPermits());
            others.setIsDepartmentConfirm(report.getIsDepartmentConfirm());
            others.setIsRadiating(report.getIsRadiating());
            others.setSignVisibilityLeft(report.getSignVisibilityLeft());
            others.setSignVisibilityRight(report.getSignVisibilityRight());
            others.setIndependentIndexSign(report.getIndependentIndexSign());
            others.setIsFireAlarm(report.getIsFireAlarm());
            cover.setDirector(report.getDirector());
            cover.setSurveyDate(report.getSurveyDate());
            cover.setIsCompetitor(report.getIsCompetitor());
            cover.setIsAcceptance(report.getIsAcceptance());;
            cover.setIsHighrisk(report.getIsHighrisk());
            cover.setIsEnvironment(report.getIsEnvironment());
            cover.setIsToliet(report.getIsToliet());
            cover.setIncomeMode(report.getIncomeMode());
            property.setPropertyForm(report.getPropertyForm());
            property.setStructureType(report.getStructureType());
            property.setSiteMeasure(report.getSiteMeasure());
            property.setIsBlueprintCopy(report.getIsBlueprintCopy());
            property.setIsUtilityDrawing(report.getIsUtilityDrawing());
            property.setOuterWall(report.getOuterWall());
            property.setInteriorWall(report.getInteriorWall());
            property.setGround(report.getGround());
            property.setCeiling(report.getCeiling());
            property.setEquipmentDeal(report.getEquipmentDeal());
            property.setBuildingDescription(report.getBuildingDescription());
            property.setIsExternalLighting(report.getIsExternalLighting());
            property.setMaterial(report.getMaterial());
            hydropower.setIsPowerSupply(report.getIsPowerSupply());
            hydropower.setRoomStoreBack(report.getCableLaying());
            hydropower.setIsWaterSupply(report.getIsWaterSupply());
            hydropower.setIsDrainage(report.getIsDrainage());
            cover.setAeration(aeration);
            cover.setHydropower(hydropower);
            cover.setProperty(property);
            cover.setOthers(others);
            return cover;
        }
        TSfConsSurveyReportCover model = new TSfConsSurveyReportCover();
        aerationNoNull.setSummerOutdoorTemp(report.getSummerOutdoorTemp());
        aerationNoNull.setWinterOutdoorTemp(report.getWinterOutdoorTemp());
        aerationNoNull.setAirConditionMode(report.getAirConditionMode());
        aerationNoNull.setAirConditionSupply(report.getAirConditionSupply());
        aerationNoNull.setFanHeatEffect(report.getFanHeatEffect());
        aerationNoNull.setNoiseEffect(report.getNoiseEffect());
        aerationNoNull.setIsEnvironmentalPermits(report.getIsEnvironmentalPermits());
        othersNoNull.setIsDepartmentConfirm(report.getIsDepartmentConfirm());
        othersNoNull.setIsRadiating(report.getIsRadiating());
        othersNoNull.setSignVisibilityLeft(report.getSignVisibilityLeft());
        othersNoNull.setSignVisibilityRight(report.getSignVisibilityRight());
        othersNoNull.setIndependentIndexSign(report.getIndependentIndexSign());
        othersNoNull.setIsFireAlarm(report.getIsFireAlarm());
        model.setDirector(report.getDirector());
        model.setSurveyDate(report.getSurveyDate());
        model.setIsCompetitor(report.getIsCompetitor());
        model.setIsAcceptance(report.getIsAcceptance());;
        model.setIsHighrisk(report.getIsHighrisk());
        model.setIsEnvironment(report.getIsEnvironment());
        model.setIsToliet(report.getIsToliet());
        model.setIncomeMode(report.getIncomeMode());
        propertyNoNull.setPropertyForm(report.getPropertyForm());
        propertyNoNull.setStructureType(report.getStructureType());
        propertyNoNull.setSiteMeasure(report.getSiteMeasure());
        propertyNoNull.setIsBlueprintCopy(report.getIsBlueprintCopy());
        propertyNoNull.setIsUtilityDrawing(report.getIsUtilityDrawing());
        propertyNoNull.setOuterWall(report.getOuterWall());
        propertyNoNull.setInteriorWall(report.getInteriorWall());
        propertyNoNull.setGround(report.getGround());
        propertyNoNull.setCeiling(report.getCeiling());
        propertyNoNull.setEquipmentDeal(report.getEquipmentDeal());
        propertyNoNull.setBuildingDescription(report.getBuildingDescription());
        propertyNoNull.setIsExternalLighting(report.getIsExternalLighting());
        propertyNoNull.setMaterial(report.getMaterial());
        hydropowerNoNull.setIsPowerSupply(report.getIsPowerSupply());
        hydropowerNoNull.setRoomStoreBack(report.getCableLaying());
        hydropowerNoNull.setIsWaterSupply(report.getIsWaterSupply());
        hydropowerNoNull.setIsDrainage(report.getIsDrainage());
        model.setAeration(aeration);
        model.setHydropower(hydropower);
        model.setProperty(property);
        model.setOthers(others);
        return model;
    }

    @Transactional
    public Map<String,Object> update(TSfConsSurveyReportCover cover,TCsTaskCompletion tCsTaskCompletion){
        Map<String,Object> map = new HashMap<String,Object>();
        String message = "保存成功!";
        Boolean result = true;
        Integer count =-1;

        TSfConsSurveyReportAeration aeration = cover.getAeration();
        TSfConsSurveyReportHydropower hydropower = cover.getHydropower();
        TSfConsSurveyReportOthers others = cover.getOthers();
        TSfConsSurveyReportProperty property = cover.getProperty();

        /**
         * 保存营建调查报告-封面信息
         */
        if(StringUtils.isBlank(cover.getRowId())){
            cover.setRowId(UUIDUtils.generateKey());
            count = coverMapper.insertCover(cover);
        }else {
            count = coverMapper.updateCover(cover);
        }

        /**
         * 保存营建调查报告-通风、空调信息
         */
        if(StringUtils.isBlank(aeration.getRowId())){
            aeration.setRowId(UUIDUtils.generateKey());
            aeration.setPpId(cover.getPpId());
            count = aerationMapper.insertAeration(aeration);
        }else {
            count = aerationMapper.updateAeration(aeration);
        }

        /**
         * 保存营建调查报告-供电、供水、排水信息
         */
        if(StringUtils.isBlank(hydropower.getRowId())){
            hydropower.setRowId(UUIDUtils.generateKey());
            hydropower.setPpId(cover.getPpId());
            count = hydropowerMapper.insertHydropower(hydropower);
        }else {
            count = hydropowerMapper.updateHydropower(hydropower);
        }

        /**
         * 保存营建调查报告-其他信息
         */
        if(StringUtils.isBlank(others.getRowId())){
            others.setRowId(UUIDUtils.generateKey());
            others.setPpId(cover.getPpId());
            count = othersMapper.insertOthers(others);
        }else {
            count = othersMapper.updateOthers(others);
        }

        /**
         * 保存营建调查报告-新址物业简述信息
         */
        if(StringUtils.isBlank(property.getRowId())){
            property.setRowId(UUIDUtils.generateKey());
            property.setPpId(cover.getPpId());
            count = propertyMapper.insertProperty(property);
        }else {
            count = propertyMapper.updateProperty(property);
        }

        if(count==0){
            result = false;
            message = "保存失败!";
        }
        tCsTaskCompletion.setRowId(UUIDUtils.generateKey());
        tCsTaskCompletion.setCreateTime(null);
        tCsTaskCompletion.setOptimauthId(cover.getPpId());
        tCsTaskCompletionService.upateStatusToFinished(tCsTaskCompletion);
        tCsTaskCompletionService.updatePipelineType(tCsTaskCompletion.getTaskId(),tCsTaskCompletion.getOptimauthId());
        map.put("result",result);
        map.put("message",message);
        return map;
    }
}
