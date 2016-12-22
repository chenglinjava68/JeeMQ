package com.stripcode.mybatis.sf.dao;

import com.stripcode.mybatis.sf.model.SFTradezoneCiuInfo;
import com.stripcode.mybatis.sf.model.SFTradezoneInfo;
import com.stripcode.mybatis.sf.model.SFTradezoneStoreInfo;

import java.util.List;
import java.util.Map;

/**
 * @author Metro
 */
public interface SFTradezoneInfoMapper {
    SFTradezoneInfo queryTaInfo(String ppId);

    Integer insertTaInfo(SFTradezoneInfo model);

    Integer updateTaInfo(SFTradezoneInfo model);

    List<SFTradezoneCiuInfo> queryTradezoneCiuInfoAll(String tradezoneId);

    List<SFTradezoneStoreInfo> queryTradezoneStoreInfoAll(String tradezoneId);

    Integer insertTradezoneCiuInfo(SFTradezoneCiuInfo model);

    Integer updateTradezoneCiuInfo(SFTradezoneCiuInfo model);

    Integer insertTradezoneStoreInfo(SFTradezoneStoreInfo model);

    Integer updateTradezoneStoreInfo(SFTradezoneStoreInfo model);

    Integer deleteStore(Map<String,Object> map);

    Integer deleteCiu(Map<String,Object> map);
}
