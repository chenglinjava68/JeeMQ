package com.stripcode.mybatis.message.dao;


import com.stripcode.mybatis.message.model.PosOrder;
import com.stripcode.mybatis.message.model.PosPayment;
import com.stripcode.mybatis.message.model.PosTransaction;

public interface PosMapper
{
	/**
	 * 方法描述：
	 * @param  item
	 * @param:
	 * @return:
	 * @version: 1.0
	 * @author: belong
	 * @version: 2015年2月4日 下午5:18:20
	 */
	public void insertOrder(PosOrder order);
	public void insertPayment(PosPayment order);
	public void insertTransaction(PosTransaction order);
}
