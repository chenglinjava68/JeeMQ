package com.stripcode.mybatis.leave.dao;

import com.stripcode.mybatis.leave.model.LeaveApply;

public interface LeaveApplyMapper {
	int insert(LeaveApply apply);
	LeaveApply get(int id);
	int update(LeaveApply app);
	/**
	 * 更新流程实例ID
	 * @param leave
	 * @return
	 */
	public int updateProcessInstanceId(LeaveApply leave);
}
