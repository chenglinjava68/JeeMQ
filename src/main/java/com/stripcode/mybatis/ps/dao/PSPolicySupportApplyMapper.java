package com.stripcode.mybatis.ps.dao;

import com.stripcode.mybatis.ps.model.PSPolicySupportApply;
import com.stripcode.mybatis.user.model.RscSysUser;

/**
 * Created by zhouchao on 2016/12/9.
 */
public interface PSPolicySupportApplyMapper {
//查询政策支持执行里的执行信息
    PSPolicySupportApply selectCheckId(String CheckId);

    RscSysUser loadUser(String userId);
    Integer insertApply(String originator);
    Integer updateApply(String originator);

}
