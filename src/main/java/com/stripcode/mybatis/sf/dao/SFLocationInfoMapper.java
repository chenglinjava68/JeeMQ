package com.stripcode.mybatis.sf.dao;

import com.stripcode.mybatis.sf.model.SFHypermarketFloor;
import com.stripcode.mybatis.sf.model.SFLocationInfo;
import com.stripcode.mybatis.sf.model.SFPipeinePhotoAttachment;

import java.util.List;
import java.util.Map;

/**
 * @author Metro
 */
public interface SFLocationInfoMapper {
    /**
     * 新增位置状况
     * @param model
     * @return Integer
     */
    Integer insertLocationInfo(SFLocationInfo model);

    /**
     * 新增楼层信息
     * @param model
     * @return Integer
     */
    Integer insertHypermarketFloor(SFHypermarketFloor model);

    /**
     * 新增新址照片
     * @param model
     * @return Integer
     */
    Integer insertPhotoAttachment(SFPipeinePhotoAttachment model);

    /**
     * 修改位置状况
     * @param model
     * @return Integer
     */
    Integer updateLocationInfo(SFLocationInfo model);

    /**
     * 修改楼层信息
     * @param model
     * @return Integer
     */
    Integer updateHypermarketFloor(SFHypermarketFloor model);

    /**
     * 修改新址照片
     * @param model
     * @return Integer
     */
    Integer updatePhotoAttachment(SFPipeinePhotoAttachment model);

    /**
     * 查询位置状况信息
     * @param ppId
     * @return SFLocationInfo
     */
    SFLocationInfo queryLocationInfo(String ppId);

    /**
     * 查询楼层信息
     * @param ppId
     * @return list
     */
    List<SFHypermarketFloor> queryHypermarketFloor(String ppId);

    /**
     * 查询新址照片
     * @param ppId
     * @return list
     */
    List<SFPipeinePhotoAttachment> queryPhotoAttachment(String ppId);

    /**
     * 删除楼层
     * @param map
     * @return Integer
     */
    Integer delHypermarketFloor(Map<String,Object> map);

    /**
     * 删除新址照片
     * @param map
     * @return Integer
     */
    Integer delPhotoAttachment(Map<String,Object> map);

}
