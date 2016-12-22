package com.stripcode.mybatis.sf.dao;

import com.stripcode.mybatis.sf.model.SFContractApply;

/**
 * @author Metro
 */
public interface SFContractApplyMapper {
    SFContractApply queryContractApply(String ppId);

    Integer insertContractApply(SFContractApply model);

    Integer updateContractApply(SFContractApply model);
}
