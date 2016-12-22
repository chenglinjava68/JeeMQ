package com.stripcode.mybatis.cs.dao;

import com.stripcode.mybatis.cs.model.CSContractAttachment;
import com.stripcode.mybatis.cs.model.CSRenewalContractinfo;

import java.util.List;

/**
 * @author Metro
 */
public interface CSRenewalContractinfoMapper {
    /**
     * 查询续约合同信息
     * @param optimauthId
     * @return
     */
    CSRenewalContractinfo queryContractInfo(String optimauthId);

    /**
     * 新增续约合同信息
     * @param model
     * @return Integer
     */
    Integer insertContractInfo(CSRenewalContractinfo model);

    /**
     * 修改续约合同信息
     * @param model
     * @return
     */
    Integer updateContractInfo(CSRenewalContractinfo model);

    List<CSContractAttachment> selectAttachment(String optimauthId);
}
