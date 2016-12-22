package com.stripcode.mybatis.sf.dao;

import com.stripcode.mybatis.cs.model.CSSfPipeline;
import com.stripcode.mybatis.sf.model.SFPipelinePausePermination;
import org.apache.ibatis.annotations.Param;

/**
 * Created by Metro on 2016/9/26.
 */
public interface SFPipelinePausePerminationMapper {
    /**
     * 查询基本信息列表
     * @param ppId 客户意向店ID
     * @return 意向店店铺基本信息
     */
    CSSfPipeline selectBasePipeline(@Param("ppId")String ppId,@Param("customerId") String customerId);

    /**
     * 查询暂停信息
     * @param ppId 客户意向店ID
     * @return 意向店暂停信息
     */
    SFPipelinePausePermination selectPipelinePause(String ppId);

    /**
     * 添加暂停信息
     * @param sfPipelinePausePermination
     * @return Integer 添加返回的条数 {1}
     */
    Integer insertPipelinePause(SFPipelinePausePermination sfPipelinePausePermination);

    /**
     * 修改信息
     * @param sfPipelinePausePermination 暂停信息实体
     * @return Integer 修改返回的条数 {1}
     */
    Integer updatePipelinePause(SFPipelinePausePermination sfPipelinePausePermination);

    /**
     * 查询是否存在
     * @param ppId 客户意向店ppId
     * @return Integer 返回0表示没有记录 执行添加 返回1表示有记录 执行修改语句
     */
    Integer isExistsPipelinePauseCount(String ppId);

    //修改状态

    /**
     * 修改意向店状态
     * @param sfPipelinePausePermination 实体
     * @return Integer 如果返回 1表示修改成功
     */
    Integer updateStatusPipeline(SFPipelinePausePermination sfPipelinePausePermination);

    /**
     * 意向店恢复
     * @param sfPipelinePausePermination 实体
     * @return nteger 如果返回 1表示恢复成功
     */
    Integer updateStatusRestorePipeline(SFPipelinePausePermination sfPipelinePausePermination);

    /**
     * 修改暂停信息表的状态
     * @param sfPipelinePausePermination 实体
     * @return
     */
    Integer updateRestore(SFPipelinePausePermination sfPipelinePausePermination);

   /* Integer updateStop(SFPipelinePausePermination sfPipelinePausePermination);*/

    /**
     * 终止
     * 添加
     * @param sfPipelinePausePermination 实体
     * @return
     */
    Integer insertPipelintStop(SFPipelinePausePermination sfPipelinePausePermination);

    /**
     * 修改
     * @param sfPipelinePausePermination 实体
     * @return Integer 1 表示修改成功
     */
    Integer updatePipelineStop(SFPipelinePausePermination sfPipelinePausePermination);

    /**
     * 查询是否存在
     * @param ppId 客户意向店 ppId
     * @return 0表示不存在 执行添加语句，1表示有 执行修改语句
     */
    Integer isExistsPipelineStopCount(String ppId);

    /**
     * 查询终止信息
     * @param ppId 意向店ppId
     * @return
     */
    SFPipelinePausePermination selectPipelineStop(String ppId);


    /**
     * 修改状态
     * @param sfPipelinePausePermination 实体
     * @return
     */
    Integer updateStatusPipelineStop(SFPipelinePausePermination sfPipelinePausePermination);


}
