package com.stripcode.mybatis.user.dao;

import com.github.pagehelper.Page;
import com.stripcode.core.util.tree.TreeModel;
import com.stripcode.mybatis.user.model.RscSysPosition;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface RscSysPositionMapper {

    int deleteByPrimaryKey(String positionid);

    int insert(RscSysPosition record);

    RscSysPosition selectByPrimaryKey(String positionid);
    RscSysPosition selectUserIdKey(String userId);
    List<RscSysPosition> selectAll();

    List<RscSysPosition> selectForExport();

    int updateByPrimaryKey(RscSysPosition record);

    Integer selectMaxId();


    Page<RscSysPosition> query(Map<String, Object> object);

    Page<RscSysPosition> queryForPage(Map<String, Object> object);

    List<TreeModel> selectForTree(@Param("positionId") String positionId);

    RscSysPosition getUserByid(String id);
}