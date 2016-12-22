package com.stripcode.mybatis.cs.dao;

import com.stripcode.mybatis.cs.model.CSContractApply;
import com.stripcode.mybatis.cs.model.CSContractAttachment;
import com.stripcode.mybatis.cs.model.CSNewMarketAuz;

import java.util.List;

/**
 * @author Metro
 */
public interface CSContractinfoMapper {
    CSNewMarketAuz selectErpAndCustomerInfo(String optimauthId);
    List<CSContractAttachment> selectAll(String optimauthId);
    CSContractApply isExistContract(String optimauthId);
    Integer insertContractInfo(CSContractApply model);
    Integer insertContractAttachment(CSContractAttachment model);

    Integer updateContractInfo(CSContractApply model);
    Integer updateContractAttachment(CSContractAttachment model);
}
