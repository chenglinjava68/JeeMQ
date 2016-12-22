package com.stripcode.mybatis.message.model;

import java.io.Serializable;

/**
	 * ��������֧����¼
 	 * @version: 1.0
	 * @author: Metro
	 * @version: 2014��9��26�� ����11:28:28
 */
public class PosPayment implements Serializable
{
	/* serialVersionUID: serialVersionUID */
	private static final long serialVersionUID = 1L;

	private String autoNo;

	public String orderId;
	private int index;
	public Integer paymentType;// ֧����ʽ[�Ź���,�ֽ�ȯ,���п�,��ҵ��,��Ա��] @see PaymentType
	public String paymentCode;// ֧������
	public String paymentName;// ֧������
	public float amount;// ���ѽ��
	public float count;// �ο�����
	public Integer memberNo;// ��Ա��
	public float exAmount;// ���ս��
	public float actualAmount;// ʵ�ʽ��
	public float price;// ���μ۸�

	private String availableRules;// ��Ӧ�ۿ۱���
	private Integer syncStatus;

	public String getAutoNo() {
		return autoNo;
	}

	public void setAutoNo(String autoNo) {
		this.autoNo = autoNo;
	}

	public Integer getSyncStatus() {
		return syncStatus;
	}

	public void setSyncStatus(Integer syncStatus) {
		this.syncStatus = syncStatus;
	}
	public int getIndex()
	{
		return index;
	}
	
	public void setIndex(int index)
	{
		this.index = index;
	}
	
	/**
	 * @return price : return the property price.
	*/
	public float getPrice()
	{
		return price;
	}
	
	public String getAvailableRules()
	{
		return availableRules;
	}
	
	public void setAvailableRules(String availableRules)
	{
		this.availableRules = availableRules;
	}
	
	/**
	 * @param price : set the property price.
	 */
	public void setPrice(float price)
	{
		this.price = price;
	}
	
	/**
	 * @return actualAmount : return the property actualAmount.
	*/
	public float getActualAmount()
	{
		return actualAmount;
	}
	
	/**
	 * @param actualAmount : set the property actualAmount.
	 */
	public void setActualAmount(float actualAmount)
	{
		this.actualAmount = actualAmount;
	}
	
	public String getOrderId()
	{
		return orderId;
	}
	
	public void setOrderId(String orderId)
	{
		this.orderId = orderId;
	}
	
	public Integer getPaymentType()
	{
		return paymentType;
	}
	
	public void setPaymentType(Integer paymentType)
	{
		this.paymentType = paymentType;
	}
	
	public String getPaymentCode()
	{
		return paymentCode;
	}
	
	public void setPaymentCode(String paymentCode)
	{
		this.paymentCode = paymentCode;
	}
	
	public String getPaymentName()
	{
		return paymentName;
	}
	
	public void setPaymentName(String paymentName)
	{
		this.paymentName = paymentName;
	}
	
	public float getAmount()
	{
		return amount;
	}
	
	public void setAmount(float amount)
	{
		this.amount = amount;
	}
	
	public float getCount()
	{
		return count;
	}
	
	public void setCount(float count)
	{
		this.count = count;
	}
	
	/**
	 * @return cardNo : return the property cardNo.
	*/
	public Integer getMemberNo()
	{
		return memberNo;
	}
	
	/**
	 * @param cardNo : set the property cardNo.
	 */
	public void setMemberNo(Integer memberNo)
	{
		this.memberNo = memberNo;
	}
	
	public float getExAmount()
	{
		return exAmount;
	}
	
	public void setExAmount(float exAmount)
	{
		this.exAmount = exAmount;
	}
	
	@Override
	public String toString()
	{
		return "PosPayment [orderId=" + orderId + ", paymentType=" + paymentType + ", paymentCode=" + paymentCode + ", paymentName=" + paymentName + ", amount=" + amount + ", count=" + count + ", memberNo=" + memberNo + ", exAmount=" + exAmount + ", actualAmount=" + actualAmount
				+ ", price=" + price + "]";
	}
	
}
