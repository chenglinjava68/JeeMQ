package com.stripcode.mybatis.sf.dao;


import com.stripcode.mybatis.sf.model.SFProgressEst;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by Metro on 2016/9/27.
 */
public interface SFProgressEstMapper {
    //添加进度预估
    Integer insertProgressEst(SFProgressEst sfProgressEst);
    //修改进度预估
    Integer updateProgressEst(SFProgressEst sfProgressEst);
    //查询是否存在
    Integer isExistsProgressEst(@Param("taskCode") String taskCode,@Param("ppId") String ppId);
    //查询加盟
    List<SFProgressEst> selectProgressAll(String ppId);
    //查询直营
    List<SFProgressEst> selectProgressNew(String ppId);
    //查询合伙人
    List<SFProgressEst> selectProgressAdd(String ppIds);

    //修改签约实际日期
    Integer updateProgressEstToSignDate(SFProgressEst model);
}
