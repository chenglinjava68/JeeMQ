package com.stripcode.mybatis.sf.dao;

import com.stripcode.mybatis.sf.model.SFDesignApply;
import com.stripcode.mybatis.sf.model.SFDesignApplyAttachment;
import com.stripcode.mybatis.sf.model.SFDesignApplyDetail;
import com.stripcode.mybatis.sf.model.SFFloorInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by Metro on 2016/10/18.
 */
public interface SFDesignApplyMapper {
    /**
     * 查询楼层信息
     * @param ppId 意向店PPID
     * @return
     */
    List<SFFloorInfo> selectFloor(String ppId);

    /**
     * 查询图纸列表
     * @param ppId 意向店PPID
     * @return
     */
    List<SFDesignApplyAttachment> selectApplyAttachment(String ppId);

    /**
     * 添加模板附件
     * @param sfDesignApplyAttachment
     * @return
     */
    Integer insertApplyAttachment(SFDesignApplyAttachment sfDesignApplyAttachment);

    /**
     * 修改附件模板
     * @param sfDesignApplyAttachment
     * @return
     */
    Integer updateApplyAttachment(SFDesignApplyAttachment sfDesignApplyAttachment);

    /**
     *
     * @param designId
     * @param templateId
     * @return
     */
    Integer isExistsApplyAttachment(@Param("designId") String designId,@Param("templateId") String templateId);
    /**
     * 功能需求
     * @param ppId 意向店PPID
     * @return
     */
    List<SFDesignApplyDetail> selectApplyDetail(@Param("ppId")String ppId);

    /**
     * 添加功能需求
     * @param sfDesignApplyDetail
     * @return
     */
    Integer insertApplyDetail(SFDesignApplyDetail sfDesignApplyDetail);

    /**
     * 修改功能需求
     * @param sfDesignApplyDetail
     * @return
     */
    Integer updateApplyDetail(SFDesignApplyDetail sfDesignApplyDetail);

    /**
     * 查询是否存在
     * @param designId
     * @return
     */
    Integer isExistsApplyDetail(@Param("designId")String designId,@Param("item") String item);

    /**
     * 其他需求
     * @param ppId 意向店PPID
     * @return
     */
    SFDesignApply selectDesignApply(String ppId);

    /**
     * 修改设计信息
     * @param sfDesignApply
     * @return
     */
    Integer updateDesignApply(SFDesignApply sfDesignApply);

    /**
     * 添加
     * @param sfDesignApply
     * @return
     */
    Integer insertDesignApply(SFDesignApply sfDesignApply);

    /**
     *
     * @param rowId  设计Id
     * @param ppId   意向店Id
     * @return
     */
    Integer isExistsDesignApply(@Param("rowId") String rowId,@Param("ppId") String ppId);

}
