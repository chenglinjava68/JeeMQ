package com.stripcode.service.sf;

import com.stripcode.core.util.UUIDUtils;
import com.stripcode.mybatis.am.dao.*;
import com.stripcode.mybatis.am.model.*;
import com.stripcode.mybatis.cs.model.*;
import com.stripcode.mybatis.sf.dao.SFApplyPipelineCodeMapper;
import com.stripcode.mybatis.sf.dao.SFContactInfoMapper;
import com.stripcode.mybatis.sf.dao.SFContractApplyAttachmentMapper;
import com.stripcode.mybatis.sf.dao.SFSigningAttachmentMapper;
import com.stripcode.mybatis.sf.model.*;
import com.stripcode.service.cs.CS20_001Service;
import com.stripcode.service.cs.CS20_017Service;
import com.stripcode.service.cs.TCsTaskCompletionService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Metro
 */
@Service
@CacheConfig(cacheNames = "SF30_070Service")
public class SF30_070Service {

    @Autowired
    private SFContactInfoMapper sfContactInfoMapper;
    @Autowired
    private TCsTaskCompletionService tCsTaskCompletionService;
    @Autowired
    private SF30_002Service sf30_002Service;
    @Autowired
    private CS20_001Service cs20_001Service;
    @Autowired
    private SF30_055Service sf30_055Service;
    @Autowired
    private SF30_054Service sf30_054Service;
    @Autowired
    private CS20_017Service cs20_017Service;
    @Autowired
    private SF30_052Service sf30_052Service;
    @Autowired
    private SF30_008Service sf30_008Service;
    @Autowired
    private AMLandLordInfoMapper amLandLordInfoMapper;
    @Autowired
    private SF30_020Service sf30_020Service;
    @Autowired
    private SF30_075Service sf30_075Service;
    @Autowired
    private AMRentalDetailMapper amRentalDetailMapper;
    @Autowired
    private SF30_051Service sf30_051Service;
    @Autowired
    private AMAttachMentInfoMapper amAttachMentInfoMapper;
    @Autowired
    private SFContractApplyAttachmentMapper sfContractApplyAttachmentMapper;
    @Autowired
    private AMLeaseAttachMentMapper amLeaseAttachMentMapper;
    @Autowired
    private SFSigningAttachmentMapper sfSigningAttachmentMapper;
    @Autowired
    private AMContractAttachMentMapper amContractAttachMentMapper;
    @Autowired
    private AMPolicySupportMapper amPolicySupportMapper;
    @Autowired
    private SF30_053Service sf30_053Service;
    @Autowired
    private SFApplyPipelineCodeMapper sfApplyPipelineCodeMapper;


    public SFContactInfo queryContactInfo(String ppId){
        SFContactInfo model = sfContactInfoMapper.queryContactInfo(ppId);
        CSNewMarketAuz csNewMarketAuz = sfContactInfoMapper.queryErpInfo(ppId);
        if(model!=null){
            model.setCsNewMarketAuz(csNewMarketAuz);
        }else {
            SFContactInfo sfContactInfo = new SFContactInfo();
            sfContactInfo.setCsNewMarketAuz(csNewMarketAuz);
            return sfContactInfo;
        }
        return model;
    }

    @Transactional
    public Map update(SFContactInfo model, TCsTaskCompletion csTaskCompletion){
        Map modelMap = new HashMap();
        Integer count = -1;
        String message = "保存成功!";
        Boolean result = true;

        if(StringUtils.isBlank(model.getRowId())){
            model.setRowId(UUIDUtils.generateKey());
            count = sfContactInfoMapper.insertContactInfo(model);
        }else {
            count = sfContactInfoMapper.updateContactInfo(model);
        }

        /*//保存政策协议附件到店铺附件表
        count = this.saveStoreAttachment(model.getPpId());*/
        //保存店铺基本信息
        count = this.saveStoreInfo(model.getPpId());
        //保存店铺附件集合
        count = this.saveAMAttachMentInfo(model.getPpId());
        //添加店铺租约附件
        count = this.saveAMLeaseAttachMent(model.getPpId());
        //判断性质（加盟、直营、合伙）
        CSSfPipeline csSfPipeline = sf30_002Service.queryById(model.getPpId());
        if ("M0065".equals(csSfPipeline.getOperationMode())){
            //保存业主房产来源
            count = this.saveAMLandLordInfo(model.getPpId());
            //保存业主基本信息
            count = this.saveAMLandLordInfoDetail(model.getPpId());
            //添加店铺租金提案信息
            count = this.saveAMRentalProposalDirectStore(model.getPpId());
            //添加店铺租期详细信息
            count = this.saveAMRentalDetail(model.getPpId());
            //添加店铺合同附件
            count = this.saveAMContractAttachMent(model.getPpId());
        }
        if ("M0066".equals(csSfPipeline.getOperationMode()) || "M0067".equals(csSfPipeline.getOperationMode())){
            //保存加盟/合伙人政策支持集合
            count = this.saveAMPolicySupport(model.getPpId());
        }
        if(count==0){
            result = false;
            message= "保存失败!";
        }
        csTaskCompletion.setRowId(UUIDUtils.generateKey());
        csTaskCompletion.setCreateTime(null);
        csTaskCompletion.setOptimauthId(model.getPpId());
        tCsTaskCompletionService.upateStatusToFinished(csTaskCompletion);
        tCsTaskCompletionService.updatePipelineType(csTaskCompletion.getTaskId(),csTaskCompletion.getOptimauthId());
        modelMap.put("rowId",model.getRowId());
        modelMap.put("result",result);
        modelMap.put("message",message);
        return modelMap;
    }

 /*   //保存店铺附件
    public Integer saveStoreAttachment(String ppId){
        Integer count = -1;
        List<SFPolicySupportAgreementAttachment> sfPolicyAttachments = sfContactInfoMapper.queryPolicyAttachment(ppId);
        if(sfPolicyAttachments.size()!=0){
            for (SFPolicySupportAgreementAttachment item:sfPolicyAttachments){
                AMContractAttachMent model = new AMContractAttachMent();
                model.setStoreId(item.getPpId());
                model.setAttachId(item.getAttachId());
                model.setStatus(item.getStatus());
                count = sfContactInfoMapper.saveAmAttachMentInfo(model);
            }
        }
        return count;
    }*/

    //保存店铺基本信息
    public Integer saveStoreInfo(String ppId){
        Integer count = -1;
        CSSfPipeline csSfPipeline = sf30_002Service.queryById(ppId);
        CSCustomerInfo csCustomerInfo =cs20_001Service.queryById(csSfPipeline.getCustomerId());
        CSNewMarketAuz csNewMarketAuz = sfContactInfoMapper.queryErpInfo(ppId);
        SFSiteInfo sfSiteInfo = sf30_052Service.querySiteInfo(ppId);
        SFApplyPipelineCode storeCode = sfApplyPipelineCodeMapper.selectApplyPipelineCode(ppId);

        AMStoreInfo model = new AMStoreInfo();

        model.setStoreId(csSfPipeline.getPpId());
        model.setStoreCode(storeCode.getPpCode());
        model.setPpId(csSfPipeline.getPpId());
        model.setCnsiteName(csSfPipeline.getCnSiteName());
        model.setBrand(csSfPipeline.getBrand());
        model.setOperationMode(csSfPipeline.getOperationMode());
        model.setChannelType(csSfPipeline.getChannelType());
        model.setStoreImage(csSfPipeline.getStoreImage());
        model.setStoreProperty(csSfPipeline.getStoreProperty());
        model.setProvince(csSfPipeline.getProvince());
        model.setCity(csSfPipeline.getCity());
        model.setDistrict(csSfPipeline.getDistrict());
        model.setStreet(csSfPipeline.getStreet());
        model.setAddress(csSfPipeline.getAddressCn());
        model.setCustomerId(csSfPipeline.getCustomerId());
        /*model.setRepId(csSfPipeline.getDeveloper);店拓人员*/

        model.setCustormerProperty(csCustomerInfo.getCustomerProperty());
        model.setPostCode(csCustomerInfo.getPostCode());
        model.setTel(csCustomerInfo.getTel());
        model.setStatus("营运中");

        model.setCoopMode(csNewMarketAuz.getCooperationMode());
        model.setJoinedSignDate(csNewMarketAuz.getActualSignDate());

        model.setOperateArea(sfSiteInfo.getOperatingArea());
        //加盟
        if("M0066".equals(csSfPipeline.getOperationMode())){
            List<SFProgressEst> sfProgressEstListNew = sf30_054Service.selectProgressNew(ppId);
            SFRentalProposal sfRentalProposal = sf30_055Service.selectProposal(ppId);
            for (SFProgressEst item:sfProgressEstListNew){
                if("M0162".equals(item.getTaskCode())){
                    model.setSignDate(item.getActualDate());
                }
                if("M0161".equals(item.getTaskCode())){
                    model.setApprovalDate(item.getActualDate());
                }
                if("M0165".equals(item.getTaskCode())){
                    model.setOpenDate(item.getActualDate());
                }
            }
            model.setContractStartDate(sfRentalProposal.getRentStartDate());
            model.setContractEndDate(sfRentalProposal.getRentEndDate());
            count = sfContactInfoMapper.insertStore(model);
        }
        //直营
        if("M0065".equals(csSfPipeline.getOperationMode())){
            List<SFProgressEst> sfProgressEstListAll = sf30_054Service.selectProgressAll(ppId);
            SFRentalProposalDirectStore sFRentalProposalDirectStore =sf30_020Service.selectRenStoreAll(ppId);
            for (SFProgressEst item:sfProgressEstListAll){
                if("M0328".equals(item.getTaskCode())){
                    model.setSignDate(item.getActualDate());
                }
                if("M0327".equals(item.getTaskCode())){
                    model.setApprovalDate(item.getActualDate());
                }
                if("M0331".equals(item.getTaskCode())){
                    model.setOpenDate(item.getActualDate());
                }
            }
            model.setContractStartDate(sFRentalProposalDirectStore.getRentStartDate());
            model.setContractEndDate(sFRentalProposalDirectStore.getRentEndDate());
            count = sfContactInfoMapper.insertStore(model);
        }
        //合伙
        if("M0067".equals(csSfPipeline.getOperationMode())){
            List<SFProgressEst> sfProgressEstListAdd = sf30_054Service.selectProgressAdd(ppId);
            SFRentalProposalCopartnerStore SFRentalProposalCopartnerStore = sf30_075Service.selectProposal(ppId);
            for (SFProgressEst item:sfProgressEstListAdd){
                if("M0514".equals(item.getTaskCode())){
                    model.setSignDate(item.getActualDate());
                }
                if("M0513".equals(item.getTaskCode())){
                    model.setApprovalDate(item.getActualDate());
                }
                if("M0516".equals(item.getTaskCode())){
                    model.setOpenDate(item.getActualDate());
                }
            }
            model.setContractStartDate(SFRentalProposalCopartnerStore.getRentStartDate());
            model.setContractEndDate(SFRentalProposalCopartnerStore.getRentEndDate());
            count = sfContactInfoMapper.insertStore(model);
        }
        return count;
    }

    //保存店铺业主信息房产来源
    public Integer saveAMLandLordInfo(String ppId){
        Integer count = -1;
        SFEstateSource sfEstateSource = sf30_008Service.queryEstateSource(ppId);
        AMLandLordInfo model = new AMLandLordInfo();
        model.setStoreId(sfEstateSource.getPpId());
        model.setProperty("新店缺失字段");
        model.setIsFromRep(sfEstateSource.getIsFromRep());
        model.setRep(sfEstateSource.getRep());
        model.setIsFromBroker(sfEstateSource.getIsFromBroker());
        model.setBroker(sfEstateSource.getBroker());
        model.setIsFromAlliance(sfEstateSource.getIsFromAlliance());
        model.setAlliance(sfEstateSource.getAlliance());
        count = amLandLordInfoMapper.insertAMLandLordInfo(model);
        return count;
    }

    //保存店铺业主信息集合
    public Integer saveAMLandLordInfoDetail(String ppId){
        Integer count = -1;
        SFEstateSource sfEstateSource = sf30_008Service.queryEstateSource(ppId);
        AMLandLordInfoDetail model = new AMLandLordInfoDetail();
        List<SFLandlordinfo> SFLandlordinfoList = sfEstateSource.getLandlordinfoList();
        if (SFLandlordinfoList.size()!=0){
            for (SFLandlordinfo item: SFLandlordinfoList) {
                model.setStoreId(sfEstateSource.getPpId());
                model.setLandLord(item.getLandlord());
                model.setContacter(item.getContacter());
                model.setPosition(item.getPosition());
                model.setTel(item.getTel());
                model.setRentType(item.getRentType());
                model.setOwner(item.getOwner());
                model.setAddress(item.getAddress());

                count = amLandLordInfoMapper.insertAMLandLordInfoDetail(model);
            }
        }
        return count;
    }

    //保存店铺租金提案信息
    public Integer saveAMRentalProposalDirectStore(String ppId){
        Integer count = -1;
        SFRentalProposalDirectStore sFRentalProposalDirectStore =sf30_020Service.selectRenStoreAll(ppId);
        AMRentalProposalDirectStore model = new AMRentalProposalDirectStore();
        model.setRowId(sFRentalProposalDirectStore.getRowId());
        model.setStoreId(sFRentalProposalDirectStore.getPpId());
        model.setBerthNo(sFRentalProposalDirectStore.getBerthNo());
        model.setRoomRate(sFRentalProposalDirectStore.getRoomRate());
        model.setRentMode(sFRentalProposalDirectStore.getRentMode());
        model.setSigningMode(sFRentalProposalDirectStore.getSigningMode());
        model.setRentMth(sFRentalProposalDirectStore.getRentMth());
        model.setPropertyFeeMth(sFRentalProposalDirectStore.getPropertyFeeMth());
        model.setDeliveryDate(sFRentalProposalDirectStore.getDeliveryDate());
        model.setRentType(sFRentalProposalDirectStore.getRentType());
        model.setRentPayType(sFRentalProposalDirectStore.getRentPayType());
        model.setRentStartDate(sFRentalProposalDirectStore.getRentStartDate());
        model.setRentEndDate(sFRentalProposalDirectStore.getRentEndDate());
        model.setFreeStartDate(sFRentalProposalDirectStore.getFreeStartDate());
        model.setFreeEndDate(sFRentalProposalDirectStore.getFreeEndDate());
        model.setIsSublet(sFRentalProposalDirectStore.getIsSublet());
        model.setSubletEndDate(sFRentalProposalDirectStore.getSubletEndDate());
        model.setRenovationPropertyFee(sFRentalProposalDirectStore.getRenovationPropertyFee());
        model.setOperationFreeStartDae(sFRentalProposalDirectStore.getOperationFreeStartDate());
        model.setOperationFreeEndDae(sFRentalProposalDirectStore.getOperationFreeEndDate());
        model.setDeliveryConditions(sFRentalProposalDirectStore.getDeliveryConditions());
        model.setLeaseBond(sFRentalProposalDirectStore.getLeaseBond());
        model.setSubletSale(sFRentalProposalDirectStore.getSubletSale());
        model.setSplitBrand(sFRentalProposalDirectStore.getSplitBrand());
        model.setSplitArea(sFRentalProposalDirectStore.getSplitArea());
        model.setSplitStartDate(sFRentalProposalDirectStore.getSplitStartDate());
        model.setEndSales(sFRentalProposalDirectStore.getEndSales());
        model.setLeaseTerm(sFRentalProposalDirectStore.getLeaseTerm());
        model.setRentalPropertyFee(sFRentalProposalDirectStore.getRentalPropertyFee());
        model.setDefaultClausePenalty(sFRentalProposalDirectStore.getDefaultClausePenalty());
        model.setSpecialTermsConditions(sFRentalProposalDirectStore.getSpecialTermsConditions());

        count = amRentalDetailMapper.insertAMRentalProposalDirectStore(model);
        return count;
    }

    //添加店铺租期详细信息
    public Integer saveAMRentalDetail(String ppId){
        Integer count = -1;
        List<SFRentalDetail> SFRentalDetailList = sf30_020Service.selectRenStoreAll(ppId).getSfRentalDetailList();
        AMRentalDetail model = new AMRentalDetail();
        if (SFRentalDetailList.size()!=0){
            for (SFRentalDetail item: SFRentalDetailList) {
                model.setRowId(item.getRowId());
                model.setRentId(item.getRentId());
                model.setRentTime(item.getRentTime());
                model.setRental(item.getRental());
                model.setRate(item.getRate());
                model.setBaseRental(item.getBaseRental());
                model.setTransferFee(item.getTransferFee());
                model.setPropertyFee(item.getPropertyFee());
                model.setTaxation(item.getTaxation());
                model.setSubletFee(item.getSubletFee());

                count = amRentalDetailMapper.insertAMRentalDetail(model);
            }
        }
        return count;
    }

    //保存店铺附件集合
    public Integer saveAMAttachMentInfo(String ppId){
        Integer count = -1;
        List<SFPipeinePhotoAttachment> SFPipeinePhotoAttachmentList = sf30_051Service.queryPhotoAttachment(ppId);
        AMAttachMentInfo model = new AMAttachMentInfo();
        if(SFPipeinePhotoAttachmentList.size()!=0){
            for (SFPipeinePhotoAttachment item:SFPipeinePhotoAttachmentList) {
                model.setStoreId(item.getPpId());
                model.setTemplateId(item.getTemplateId());
                model.setAttachId(item.getAttachId());

                count = amAttachMentInfoMapper.insertAMAttachMentInfo(model);
            }
        }
        return count;
    }

    //添加店铺租约附件信息集合
    public Integer saveAMLeaseAttachMent(String ppId){
        Integer count = -1;
        List<SFLandlordLayout> sfLandlordLayout = sf30_053Service.selectHousePaperAll(ppId);
        AMLeaseAttachMent model = new AMLeaseAttachMent();
        if(sfLandlordLayout.size()!=0){
            for (SFLandlordLayout item:sfLandlordLayout) {
                model.setStoreId(item.getPpId());
                model.setTemplateId(item.getTemplateId());
                model.setAttachId(item.getAttachId());
                model.setIsExist(item.getIsExist());
                model.setIsGet(item.getIsGet());
                model.setReason(item.getReason());
                model.setIsSupply(item.getIsSupply());
                model.setSupplyDate(item.getSupplyDate());
                model.setRemark(item.getRemark());

                count = amLeaseAttachMentMapper.insertAMLeaseAttachMent(model);
            }
        }
        return count;
    }

    //添加店铺合同附件
    public Integer saveAMContractAttachMent(String ppId){
        Integer count = -1;
        List<SFSigningAttachment> signingAttachmentList = sfSigningAttachmentMapper.querySigningAttachment(ppId);
        AMContractAttachMent model = new AMContractAttachMent();
        if(signingAttachmentList.size()!=0){
            for (SFSigningAttachment item:signingAttachmentList) {
                model.setStoreId(item.getPpId());
                model.setAttachId(item.getAttachId());
                model.setTemplateId(item.getTemplateId());
                count = amContractAttachMentMapper.insertAMContractAttachMent(model);
            }
        }
        return count;
    }

    //添加店铺政策支持集合
    public Integer saveAMPolicySupport(String ppId){
        Integer count = -1;
        List<SFPolicySupportDetail> SFPolicySupportDetailList = amPolicySupportMapper.selectSFPolicySupportDetail(ppId);
        AMPolicySupport model = new AMPolicySupport();
        if(SFPolicySupportDetailList.size()!=0){
            for (SFPolicySupportDetail item:SFPolicySupportDetailList) {
                model.setStoreId(item.getPpId());
                model.setSupportItem(item.getSupportItem());
                model.setSupportMode(item.getSupportMode());
                model.setPrice(item.getPrice());
                model.setMoney(item.getMoney());
                count = amPolicySupportMapper.insertAMPolicySupport(model);
            }
        }
        return count;
    }
}
