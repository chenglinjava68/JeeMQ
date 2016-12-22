package com.stripcode.mybatis.sf.dao;

import com.stripcode.mybatis.sf.model.*;

import java.util.List;

/**
 * @author Metro
 */
public interface SFTrafficcountDetailMapper {
    /*
     *  新增人流量测试详细信息
     */
    Integer insertTrafficcountDetail(SFTrafficcountDetail model);

    List<SFTrafficcountDetail> selectTrafficcountDetail(String testId);

}
