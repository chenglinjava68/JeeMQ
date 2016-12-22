package com.stripcode.mybatis.sf.dao;

import com.stripcode.mybatis.sf.model.SFStorePhotoAttachment;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by Metro on 2016/10/20.
 */
public interface SFStorePhotoAttachementMapper {
    /**
     * 查询店铺照片
     * @param ppId 意向店ID
     * @return
     */
    List<SFStorePhotoAttachment> selectPhotoAttachement(String ppId);

    /**
     * 添加店铺照片信息
     * @param sfStorePhotoAttachment
     * @return
     */
    Integer insertPhotoAttachement(SFStorePhotoAttachment sfStorePhotoAttachment);

    /**
     * 修改店铺照片信息
     * @param sfStorePhotoAttachment
     * @return
     */
    Integer updatePhotoAttachement(SFStorePhotoAttachment sfStorePhotoAttachment);

    /**
     * 查询是否存在
     * @param ppId
     * @param templateId
     * @return
     */
    Integer isExistsPhotoAttachement(@Param("ppId")String ppId,@Param("templateId")String templateId);

}
