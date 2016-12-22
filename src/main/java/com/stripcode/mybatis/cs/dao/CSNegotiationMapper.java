package com.stripcode.mybatis.cs.dao;

import com.stripcode.mybatis.cs.model.CSNegotiation;

import java.util.List;

/**
 * @author Metro
 */
public interface CSNegotiationMapper {
    List<CSNegotiation> selectAll(String customerId);

    CSNegotiation detailsByRecordId(String recordId);

    Integer insertNegotiation(CSNegotiation model);

    Integer updateNegotiation(CSNegotiation model);

}
