package com.stripcode.mybatis.sf.dao;

import com.stripcode.mybatis.cs.model.CSSfPipeline;
import com.stripcode.mybatis.sf.model.SFApplyPipelineCode;

/**
 * Created by Metro on 2016/10/17.
 */
public interface SFApplyPipelineCodeMapper {
    /**
     * 添加店铺Id
     */
    Integer insertPipelineCode(SFApplyPipelineCode sfApplyPipelineCode);
    /**
     * 修改店铺Id
     */
    Integer updatePipelineCode(SFApplyPipelineCode sfApplyPipelineCode);
    /**
     * 店铺Id 是否存在
     */
    Integer isExistsPipelineCode(String ppId);
    /**
     * 查询erpCode 和店铺Id
     */
    SFApplyPipelineCode selectApplyPipelineCode(String ppId);

    void updateProcessInstanceId(CSSfPipeline csSfPipeline);
}
