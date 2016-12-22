package com.stripcode.mybatis.cs.dao;

import com.stripcode.mybatis.cs.model.CSBusinessFlan;
import com.stripcode.mybatis.cs.model.CSStoreSalesLastYear;

import java.util.List;

/**
 * @author Metro
 */
public interface CSStoreSalesLastYearMapper {
    List<CSBusinessFlan> selectBusinessFlanByOptimauthId(String optimauthId);

    List<CSStoreSalesLastYear> queryStoreSalesLastYear(String optimauthId);

    Integer insertStoreSales(CSStoreSalesLastYear model);

    Integer updateStoreSales(CSStoreSalesLastYear model);
}
