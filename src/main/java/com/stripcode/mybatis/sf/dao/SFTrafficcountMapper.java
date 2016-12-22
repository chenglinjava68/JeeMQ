package com.stripcode.mybatis.sf.dao;

import com.stripcode.mybatis.sf.model.*;

import java.util.List;
import java.util.Map;

/**
 * @author Metro
 */
public interface SFTrafficcountMapper {
    /*
     *  新增人流量测试信息
     */
    Integer insertTrafficcount(SFTrafficcount model);

    List<SFTrafficcount> selectTrafficcount(String ppId);

    Integer updateTrafficcount(Map<String,String> traffMap);

}
