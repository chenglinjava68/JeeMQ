package com.stripcode.mybatis.sf.dao;

import com.stripcode.mybatis.sf.model.SFPolicySupportAssessment;
import com.stripcode.mybatis.sf.model.SFPolicySupportDetail;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * Created by Metro on 2016/10/24.
 */
public interface SFPolicySupportAssessmentMapper {
    /**
     * 政策考核里面的支持项查询
     * @return
     */
    List<SFPolicySupportDetail> selectInfo(String ppId);
    int insert(SFPolicySupportAssessment rowId);
    int update(SFPolicySupportAssessment rowId);
    Integer insertPolicy(SFPolicySupportAssessment model);
    Integer updatePolicy(SFPolicySupportAssessment model);
    Integer isExistPolicy(@Param("ppId") String ppId, @Param("rowId")String rowId);
    List<SFPolicySupportAssessment> selectAllList(String ppId);
    Integer insertPolicySupportAssessment(SFPolicySupportAssessment model);
    Integer updatePolicySupportAssessment(SFPolicySupportAssessment model);
    Integer deleteByPolicySupportAssessment(Map<String,Object> map);
    Integer deleteByPolicy1(Map<String,Object> map);


}
