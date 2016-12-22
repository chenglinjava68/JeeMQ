package com.stripcode.mybatis.sf.dao;

import com.stripcode.mybatis.sf.model.SFLandlordLayout;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by Metro on 2016/9/26.
 */
public interface SFLandlordLayoutMapper {
    //查询列表数据
    List<SFLandlordLayout> selectHousePaperAll(String ppId);
    //添加
    Integer insertHousePaper(SFLandlordLayout sfLandlordLayout);
    //修改
    Integer updateHousePaper(SFLandlordLayout sfLandlordLayout);
    //查询是否存在
    Integer HousePaperCount(@Param("ppId") String ppId,@Param("templateId") String templateId);
}
