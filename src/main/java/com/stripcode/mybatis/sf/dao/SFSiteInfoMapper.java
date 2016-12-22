package com.stripcode.mybatis.sf.dao;

import com.stripcode.core.util.tree.TreeModel;
import com.stripcode.mybatis.sf.model.SFFloorInfo;
import com.stripcode.mybatis.sf.model.SFRentInfo;
import com.stripcode.mybatis.sf.model.SFSiteInfo;
import com.stripcode.mybatis.sf.model.SFStyleAreaPerInfo;
import com.stripcode.mybatis.user.model.TCodeMacroDefine;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @author Metro
 */
public interface SFSiteInfoMapper {
    /*
     *  新增场地信息
     */
    Integer insertSiteInfo(SFSiteInfo model);
    Integer insertRentInfo(SFRentInfo model);
    Integer insertFloorInfo(SFFloorInfo model);
    /*
     * 修改场地信息
     */
    Integer updateSiteInfo(SFSiteInfo model);
    Integer updateRentInfo(SFRentInfo model);
    Integer updateFloorInfo(SFFloorInfo model);

    /*
    *  查询是否已经存在记录
    */
    Integer isExistSiteInfo(String ppId);
    Integer isExistRentInfo(@Param("ppId") String ppId,@Param("rowId")String rowId);
    Integer isExistFloorInfo(@Param("ppId") String ppId,@Param("rowId")String rowId);

    /**
     * 查询详细场地信息
     */

    SFSiteInfo querySiteInfo(String ppId);
    List<SFRentInfo> queryRentInfo(String ppId);
    List<SFFloorInfo> queryFloorInfo(String ppId);

    /**
     * 删除floor
     */
    Integer delFloor(Map<String,Object> map);
    Integer delRent(Map<String,Object> map);

    TCodeMacroDefine loadTableHead(String storeImage);

    List<TreeModel> queryStyleAreaPerInfo(String ppId);

    List<SFStyleAreaPerInfo> queryStyleInfo(@Param("ppId") String ppId,@Param("seriesSex") String seriesSex);

    List<SFFloorInfo> queryFloorInfoDetail(String ppId);

}
