package com.stripcode.mybatis.sf.dao;

import com.stripcode.mybatis.sf.model.SFAcceptance;
import com.stripcode.mybatis.sf.model.SFAcceptanceAttachment;

import java.util.List;

/**
 * Created by Metro on 2016/10/21.
 */
public interface SFAcceptanceMapper {
    /**
     * 查询竣工验收信息
     * @param ppId
     * @return SFAcceptance
     */
    SFAcceptance queryAcceptance(String ppId);

    /**
     * 查询竣工验收附件
     * @param acceptanceId
     * @return list
     */
    List<SFAcceptanceAttachment> queryAcceptanceAttachment(String acceptanceId);

    /**
     * 新增竣工验收信息
     * @param model
     * @return Integer
     */
    Integer insertAcceptance(SFAcceptance model);

    /**
     * 修改竣工验收信息
     * @param model
     * @return Integer
     */
    Integer updateAcceptance(SFAcceptance model);

    /**
     * 新增竣工验收附件
     * @param model
     * @return Integer
     */
    Integer insertAcceptanceAttachment(SFAcceptanceAttachment model);

    /**
     * 修改竣工验收附件
     * @param model
     * @return Integer
     */
    Integer updateAcceptanceAttachment(SFAcceptanceAttachment model);
}
