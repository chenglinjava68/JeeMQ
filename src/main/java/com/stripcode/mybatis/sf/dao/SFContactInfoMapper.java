package com.stripcode.mybatis.sf.dao;

import com.stripcode.mybatis.am.model.AMContractAttachMent;
import com.stripcode.mybatis.am.model.AMStoreInfo;
import com.stripcode.mybatis.cs.model.CSNewMarketAuz;
import com.stripcode.mybatis.sf.model.SFContactInfo;
import com.stripcode.mybatis.sf.model.SFPolicySupportAgreementAttachment;

import java.util.List;

/**
 * @author Metro
 */
public interface SFContactInfoMapper {
    Integer insertContactInfo(SFContactInfo model);

    Integer updateContactInfo(SFContactInfo model);

    SFContactInfo queryContactInfo(String ppId);

    CSNewMarketAuz queryErpInfo(String ppId);

    List<SFPolicySupportAgreementAttachment> queryPolicyAttachment(String ppId);

    Integer saveAmAttachMentInfo(AMContractAttachMent model);

    Integer insertStore(AMStoreInfo model);

}
