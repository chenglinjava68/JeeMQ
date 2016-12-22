package com.stripcode.mybatis.cs.dao;

import com.stripcode.mybatis.cs.model.TSysCommonattached;
import java.util.List;
import java.util.Map;

public interface TSysCommonattachedMapper {
    int deleteByPrimaryKey(String versionNo);

    int insert(TSysCommonattached record);

    TSysCommonattached selectByPrimaryKey(String versionNo);

    List<TSysCommonattached> selectAll();

    int updateByPrimaryKey(TSysCommonattached record);

    int isExists(TSysCommonattached record);

    int isExistsNew(TSysCommonattached record);

    Map<String,String> getTemlateFilePath(String attachId);

    List<TSysCommonattached> selectByAttachId(String attachId);

    int updateByPrimaryKeyNew(TSysCommonattached record);

    int deleteByVersionNo(String versionNo);
}