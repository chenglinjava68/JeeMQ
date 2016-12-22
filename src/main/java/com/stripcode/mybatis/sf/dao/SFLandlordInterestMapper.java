package com.stripcode.mybatis.sf.dao;

import com.stripcode.mybatis.sf.model.SFLandlordInterest;
import org.apache.ibatis.annotations.Param;

/**
 * Created by Metro on 2016/11/17.
 */
public interface SFLandlordInterestMapper {
    //查询ppId
    SFLandlordInterest selectLoad(String ppId);
    //保存
    Integer insert(SFLandlordInterest sfLandlordInterest);
    Integer update(SFLandlordInterest sfLandlordInterest);
    //是否存在
    Integer isExistsSFLandlordInterest(@Param("ppId") String ppId, @Param("rowId") String rowId);
}
