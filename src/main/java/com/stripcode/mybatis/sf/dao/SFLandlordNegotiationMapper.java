package com.stripcode.mybatis.sf.dao;

import com.stripcode.mybatis.sf.model.SFLandlordNegotiation;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author Metro
 */
public interface SFLandlordNegotiationMapper {
    /**
     * 查询所以业主谈判记录
     * @param ppId
     * @return list
     */
    List<SFLandlordNegotiation> queryNegotiation(String ppId);

    /**
     * 查询详细业主谈判记录
     * @param ppId
     * @param rowId
     * @return SFLandlordNegotiation
     */
    SFLandlordNegotiation queryNegotiationInfo(@Param("ppId") String ppId,@Param("rowId")String rowId);

    /**
     * 新增业主谈判记录
     * @param model
     * @return Integer
     */
    Integer insertNegotiation(SFLandlordNegotiation model);

    /**
     * 修改业主谈判记录
     * @param model
     * @return Integer
     */
    Integer updateNegotiation(SFLandlordNegotiation model);
}
