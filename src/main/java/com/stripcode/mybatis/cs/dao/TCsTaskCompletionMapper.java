package com.stripcode.mybatis.cs.dao;

import com.stripcode.mybatis.cs.model.TCsTaskCompletion;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface TCsTaskCompletionMapper {

    int deleteByPrimaryKey(Integer autoNo);

    int insert(TCsTaskCompletion record);

    TCsTaskCompletion selectByPrimaryKey(Integer autoNo);

    List<TCsTaskCompletion> selectAll();

    int updateByPrimaryKey(TCsTaskCompletion record);

    int selectSuccessCountByTaskIds(Map<String, Object> params);

    Integer updateCompletion(TCsTaskCompletion model);

    int selectMustCountByTaskIds(Map<String, Object> params);

    int isExists(TCsTaskCompletion tCsTaskCompletion);

    Integer updateOptimauthType(@Param("macroCode") String macroCode,@Param("rowId") String rowId);

    Integer updatePipelineType(@Param("macroCode") String macroCode,@Param("ppId") String ppId);

    Integer selectMacroNoByMacroCode(@Param("macroCode") String macroCode,@Param("rowId")String rowId);

    Integer selectMacroNoByMacroCodeToPipeline(@Param("macroCode") String macroCode,@Param("ppId")String ppId);

}