package com.stripcode.mybatis.sf.dao;

import com.stripcode.mybatis.sf.model.SFEstateSource;
import com.stripcode.mybatis.sf.model.SFLandlordinfo;

import java.util.List;
import java.util.Map;

/**
 * @author Metro
 */
public interface SFLandlordInfoMapper {
    /**
     * 新增业主信息
     * @param model
     * @return Integer
     */
    Integer insertLandLord(SFLandlordinfo model);

    /**
     * 修改业主信息
     * @param model
     * @return Integer
     */
    Integer updateLandLord(SFLandlordinfo model);

    /**
     * 新增房产来源信息
     * @param model
     * @return Integer
     */
    Integer insertEstateSource(SFEstateSource model);

    /**
     * 修改房产来源信息
     * @param model
     * @return
     */
    Integer updateEstateSource(SFEstateSource model);

    /**
     * 查询所有业主信息
     * @param estateId
     * @return List
     */
    List<SFLandlordinfo> selectLandLordInfo(String estateId);

    /**
     * 查询房产来源信息
     * @param ppId
     * @return SFEstateSource
     */
    SFEstateSource selectEstateSourceInfo(String ppId);

    Integer deleteLandlordInfo(Map<String,Object> map);
}
