package com.stripcode.service.cs;

import com.stripcode.core.util.UUIDUtils;
import com.stripcode.mybatis.cs.dao.CSContractSigningMapper;
import com.stripcode.mybatis.cs.dao.CSContractinfoMapper;
import com.stripcode.mybatis.cs.dao.CSCustomerInfoMapper;
import com.stripcode.mybatis.cs.model.*;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Metro
 */
@Service
@CacheConfig(cacheNames = "CS20_017Service")
public class CS20_017Service {
    @Autowired
    private CSContractSigningMapper csContractSigningMapper;

    @Autowired
    private CSContractinfoMapper csContractinfoMapper;

    @Autowired
    private CSCustomerInfoMapper csCustomerInfoMapper;
    @Autowired
    private TCsTaskCompletionService tCsTaskCompletionService;
    public CSNewMarketAuz selectByOptimauthId(String optimauthId,String customerId){
        CSNewMarketAuz model = csContractinfoMapper.selectErpAndCustomerInfo(optimauthId);
        CSCustomerInfo csCustomerInfo =csCustomerInfoMapper.selectById(customerId);
        if(csCustomerInfo!=null){
            model.setCsCustomerInfo(csCustomerInfo);
        }
        CSContractSigning csContractSigning = csContractSigningMapper.signingByOptimauthId(optimauthId);
        if(csContractSigning!=null){
            model.setActualSignDate(csContractSigning.getActualSignDate());
            model.setActualAccreditStartDate(csContractSigning.getActualAccreditStartDate());
            model.setActualAccreditEndDate(csContractSigning.getActualAccreditEndDate());
            model.setActualRowId(csContractSigning.getRowId());
        }else{
            model.setActualAccreditStartDate(model.getAccreditStartDate());
            model.setActualAccreditEndDate(model.getAccreditEndDate());
        }
        return model;
    }

    @Transactional
    public Map updateSigning(CSContractSigning model, TCsTaskCompletion tCsTaskCompletion){
        Map modelMap = new HashMap();
        Boolean result = true;
        String message = "保存成功!";
        String rowId = model.getRowId();
        CSSigningAttachment csSigningAttachment = new CSSigningAttachment();
        Integer isExist = csContractSigningMapper.isExist(model.getOptimauthId());
        if(isExist==0){
            rowId = UUIDUtils.generateKey();
            model.setRowId(rowId);
            csSigningAttachment.setSigningId(rowId);
            csSigningAttachment.setRowId(rowId);
            csSigningAttachment.setTemplateId("2");
            csSigningAttachment.setAttachId("1c928d80e30647c9a1e23d9f6b78e67e");
            csSigningAttachment.setContractName("MB特许经营合同（含附件）签字");
            csContractSigningMapper.insertSigning(model);
            csContractSigningMapper.insertSignContract(csSigningAttachment);
        }else {
            csSigningAttachment.setSigningId(rowId);
            csContractSigningMapper.updateSigning(model);
            csContractSigningMapper.updateSignContract(csSigningAttachment);
        }

        Integer isExistSignPayment = -1;
        for (CSCertificateOfPayment item: model.getCsCertificateOfPaymentList()){
            CSCertificateOfPayment csCertificateOfPayment = new CSCertificateOfPayment();
            String paymentRowId = UUIDUtils.generateKey();
            csCertificateOfPayment.setRowId(paymentRowId);
            csCertificateOfPayment.setSigningId(model.getRowId());
            csCertificateOfPayment.setAttachId(item.getAttachId());
            csCertificateOfPayment.setContractName(item.getContractName());
            csCertificateOfPayment.setTemplateId(item.getTemplateId());
            //判断是否已有打款凭证附件
            if(StringUtils.isNotBlank(csCertificateOfPayment.getAttachId())){
                isExistSignPayment = csContractSigningMapper.isExistSignPayment(item.getTemplateId(),model.getRowId());
                if(isExistSignPayment==0){
                    csContractSigningMapper.insertSignPayment(csCertificateOfPayment);
                }else{
                    csContractSigningMapper.updateSignPayment(csCertificateOfPayment);
                }
            }
        }
        tCsTaskCompletionService.updateOptimauthType("M0095",model.getOptimauthId());
        tCsTaskCompletionService.upateStatusToFinished(tCsTaskCompletion);
        modelMap.put("result",result);
        modelMap.put("message",message);
        return modelMap;
    }
    public Map updateTempleteJoinId(TSysAttachedTemplate model) {
        Map modelMap = new HashMap();
        int count = csContractSigningMapper.updateTempleteJoinId(model);
        if(count==0){
            modelMap.put("result",false);
            modelMap.put("message","更新失败！");
            return modelMap;
        }
        modelMap.put("result",true);
        modelMap.put("message","更新成功！");
        return modelMap;
    }
    //查询附件列表
    public List<CSContractSigning> queryAll(String optimauthId){
        return csContractSigningMapper.signingAll(optimauthId);
    }

    //查询打款凭证
    public List<CSCertificateOfPayment> queryAttachedTemplate(String optimauthId){
        CSContractSigning csContractSigning = csContractSigningMapper.signingByOptimauthId(optimauthId);
        if(csContractSigning!=null){
            return csContractSigningMapper.selectAttachedTemplate(csContractSigning.getRowId());
        }
        else {
            return csContractSigningMapper.selectAttachedTemplate(null);
        }

    }

    public CSContractSigning queryByNewMarketAuzId(String rowId){
        return csContractSigningMapper.queryByNewMarketAuzId(rowId);
    }
}
