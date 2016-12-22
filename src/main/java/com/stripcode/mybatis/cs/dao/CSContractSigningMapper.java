package com.stripcode.mybatis.cs.dao;

import com.stripcode.mybatis.cs.model.CSCertificateOfPayment;
import com.stripcode.mybatis.cs.model.CSContractSigning;
import com.stripcode.mybatis.cs.model.CSSigningAttachment;
import com.stripcode.mybatis.cs.model.TSysAttachedTemplate;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author Metro
 */
public interface CSContractSigningMapper {
    CSContractSigning signingByOptimauthId(String optimauthId);

    Integer insertSigning(CSContractSigning csContractSigning);

    Integer updateSigning(CSContractSigning csContractSigning);

    Integer updateTempleteJoinId(TSysAttachedTemplate tSysAttachedTemplate);

    Integer isExist(String rowId);

    List<CSContractSigning> signingAll(String optimauthId);

    List<CSContractSigning> signingByTemplateId(String optimauthId);

    List<CSCertificateOfPayment> selectAttachedTemplate(String signingId);

    Integer isExistSignPayment(@Param("templateId")String templateId,@Param("signingId")String signingId);

    //查询是否存在签字合同
    Integer isExistSignContract(String signingId);
    //插入签字合同
    Integer insertSignContract(CSSigningAttachment model);

    Integer updateSignContract(CSSigningAttachment model);

    Integer insertSignPayment(CSCertificateOfPayment model);

    Integer updateSignPayment(CSCertificateOfPayment model);

    CSContractSigning queryByNewMarketAuzId(String rowId);

}
