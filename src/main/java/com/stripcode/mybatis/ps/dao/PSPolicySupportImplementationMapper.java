package com.stripcode.mybatis.ps.dao;

import com.github.pagehelper.Page;
import com.stripcode.mybatis.ps.model.PSPolicySupportImplementation;
import com.stripcode.mybatis.ps.model.PSPolicySupportImplementationModel;
import com.stripcode.mybatis.sf.model.SFPolicySupportAssessment;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * Created by Metro on 2016/12/9.
 */
public interface PSPolicySupportImplementationMapper {
    //带分页的查询数据
    Page<PSPolicySupportImplementation> queryForPage(Map<String,Object> object);
    //政策支持执行审核详细信息查询
    Page<PSPolicySupportImplementationModel> queryForPage1(Map<String,Object> object);
    //查询政策支持执行申请列表
    List<SFPolicySupportAssessment> selectList(SFPolicySupportAssessment sfPolicySupportAssessment);
    //批量保存政策支持
    Integer insertSupport(PSPolicySupportImplementation psPolicySupportImplementation);
    //政策支持修改
    Integer updateSupport(PSPolicySupportImplementation psPolicySupportImplementation);
    PSPolicySupportImplementation selectCheckId(String CheckId);
    Integer selectRowId(String rowId);
    Integer insertCheckId(PSPolicySupportImplementation psPolicySupportImplementation);
    Integer updateCheckId(PSPolicySupportImplementation psPolicySupportImplementation);

    //根据rowId查询详细信息
    List<PSPolicySupportImplementation> queryAll(String checkId);
    //查询是否存在
    Integer selectImplementation(@Param("rowId") String rowId,@Param("checkId") String checkId);
    Integer insertImplementation(PSPolicySupportImplementation psPolicySupportImplementation);
    Integer updateImplementation(PSPolicySupportImplementation psPolicySupportImplementation);



    Integer insertPSPolicySupportImplementationModel(PSPolicySupportImplementationModel model);
}
