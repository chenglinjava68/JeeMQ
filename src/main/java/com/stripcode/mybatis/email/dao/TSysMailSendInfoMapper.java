package com.stripcode.mybatis.email.dao;

import com.stripcode.mybatis.email.model.TSysMailSendInfo;
import java.util.List;

public interface TSysMailSendInfoMapper {
    int deleteByPrimaryKey(Integer autoNo);

    int insert(TSysMailSendInfo record);

    TSysMailSendInfo selectByPrimaryKey(Integer autoNo);

    List<TSysMailSendInfo> selectAll();

    int updateByPrimaryKey(TSysMailSendInfo record);
}