package com.stripcode.mybatis.message.model;

import java.io.Serializable;

/**
 * 
	 * ��������pos������ϸ
 	 * @version: 1.0
	 * @author: Metro
	 * @version: 2014��4��18�� ����9:38:55
 */
public class PosTransaction implements Serializable
{

	/* serialVersionUID: serialVersionUID */
	private static final long serialVersionUID = 1L;

	private String autoNo;

	public String getAddFlag() {
		return addFlag;
	}

	public void setAddFlag(String addFlag) {
		this.addFlag = addFlag;
	}

	private String addFlag;//�Ӳ˱�ʶ

	private Integer transactionId;// ������ϸID
	private String orderId;// ��������ID
	private String bizTime;// ����ʱ��
	private String itemCode;// ��Ʒ����
	private String itemName;// ��Ʒ����
	/**
	 * �ײ������׼�¼parentIdֵ -2;
	/**
	 * ��Ʒ���׼�¼parentIdֵ-1;
	 */
	private Integer parentId;// �����ײ͵�itemcode
	private String posNo;// ���׷�����pos
	private float quantity;// ����
	private float price;// ��Ʒ�۸�
	private float point;// ����
	private float pointsCount;// �����˻�
	public float amount;// ��Ʒ���۽��
	private Integer itemType;// ��������[���� �ۿ� ��Ʒȡ�� ���� ] @see TransactionItemType
	private Integer discountType;// �Żݷ�ʽ
	private String comments;// ��������
	private Integer operatorId;// ������ID
	private String operatorName;// ����������
	private Integer groupId;//
	private Integer additional;// ������-���ڼ�¼��Ӧ��ȡ����Ʒ�Ľ�������
	private  String selectItem;//��ȡѡ���������ڷǹ̶��ײ�





	/*****************************************/
	public boolean needCashPay = true;

	public boolean needCouponPay = true;

	private Integer syncStatus;

	private String paymentCode;// rsc_itemcode ��def3
	public float tmpQuanitty;
	private int transactionStatus;// ����״̬ 1 ����


	public String getAutoNo() {
		return autoNo;
	}

	public void setAutoNo(String autoNo) {
		this.autoNo = autoNo;
	}

	public String getSelectItem() {return selectItem;}

	public void setSelectItem(String selectItem) {this.selectItem = selectItem;}

	public Integer getSyncStatus() {
		return syncStatus;
	}

	public void setSyncStatus(Integer syncStatus) {
		this.syncStatus = syncStatus;
	}

	public boolean isNeedCashPay() {
		return needCashPay;
	}

	public void setNeedCashPay(boolean needCashPay) {
		this.needCashPay = needCashPay;
	}

	public boolean isNeedCouponPay() {
		return needCouponPay;
	}

	public void setNeedCouponPay(boolean needCouponPay) {
		this.needCouponPay = needCouponPay;
	}

	public float getTmpQuanitty()
	{
		return tmpQuanitty;
	}

	public void setTmpQuanitty(float tmpQuanitty)
	{
		this.tmpQuanitty = tmpQuanitty;
	}
	private int taste;//��ζ

	public int getTaste() {
		return taste;
	}

	public void setTaste(int taste) {
		this.taste = taste;
	}
	
	public float getPointsCount()
	{
		return pointsCount;
	}
	
	public void setPointsCount(float pointsCount)
	{
		this.pointsCount = pointsCount;
	}
	
	public float getPoint()
	{
		return point;
	}
	
	public void setPoint(float point)
	{
		this.point = point;
	}
	
	public int getTransactionStatus()
	{
		return transactionStatus;
	}
	
	public void setTransactionStatus(int transactionStatus)
	{
		this.transactionStatus = transactionStatus;
	}
	
	public String getPaymentCode()
	{
		return paymentCode;
	}
	
	public void setPaymentCode(String paymentCode)
	{
		this.paymentCode = paymentCode;
	}
	
	public Integer getTransactionId()
	{
		return transactionId;
	}
	
	public void setTransactionId(Integer transactionId)
	{
		this.transactionId = transactionId;
	}
	
	public String getOrderId()
	{
		return orderId;
	}
	
	public void setOrderId(String orderId)
	{
		this.orderId = orderId;
	}
	
	public String getBizTime()
	{
		return bizTime;
	}
	
	public void setBizTime(String bizTime)
	{
		this.bizTime = bizTime;
	}
	
	public String getItemCode()
	{
		return itemCode;
	}
	
	public void setItemCode(String itemCode)
	{
		this.itemCode = itemCode;
	}
	
	public String getItemName()
	{
		return itemName;
	}
	
	public void setItemName(String itemName)
	{
		this.itemName = itemName;
	}
	
	public Integer getParentId()
	{
		return parentId;
	}
	
	public void setParentId(Integer parentId)
	{
		this.parentId = parentId;
	}
	
	public String getPosNo()
	{
		return posNo;
	}
	
	public void setPosNo(String posNo)
	{
		this.posNo = posNo;
	}
	
	public float getQuantity()
	{
		return quantity;
	}
	
	public void setQuantity(float quantity)
	{
		this.quantity = quantity;
	}
	
	public float getPrice()
	{
		return price;
	}
	
	public void setPrice(float price)
	{
		this.price = price;
	}
	
	public float getAmount()
	{
		return amount;
	}
	
	public void setAmount(float amount)
	{
		this.amount = amount;
	}
	
	public Integer getItemType()
	{
		return itemType;
	}
	
	public void setItemType(Integer itemType)
	{
		this.itemType = itemType;
	}
	
	public Integer getDiscountType()
	{
		return discountType;
	}
	
	public void setDiscountType(Integer discountType)
	{
		this.discountType = discountType;
	}
	
	public String getComments()
	{
		return comments;
	}
	
	public void setComments(String comments)
	{
		this.comments = comments;
	}
	
	public Integer getOperatorId()
	{
		return operatorId;
	}
	
	public void setOperatorId(Integer operatorId)
	{
		this.operatorId = operatorId;
	}
	
	public String getOperatorName()
	{
		return operatorName;
	}
	
	public void setOperatorName(String operatorName)
	{
		this.operatorName = operatorName;
	}
	
	public Integer getGroupId()
	{
		return groupId;
	}
	
	public void setGroupId(Integer groupId)
	{
		this.groupId = groupId;
	}
	
	public Integer getAdditional()
	{
		return additional;
	}
	
	public void setAdditional(Integer additional)
	{
		this.additional = additional;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + ((orderId == null) ? 0 : orderId.hashCode());
		result = prime * result + ((transactionId == null) ? 0 : transactionId.hashCode());
		return result;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj)
	{
		if(this == obj) return true;
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		PosTransaction other = (PosTransaction) obj;
		if(orderId == null)
		{
			if(other.orderId != null) return false;
		}
		else if(!orderId.equals(other.orderId)) return false;
		if(transactionId == null)
		{
			if(other.transactionId != null) return false;
		}
		else if(!transactionId.equals(other.transactionId)) return false;
		return true;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString()
	{
		return "PosTransaction [transactionId=" + transactionId + ", orderId=" + orderId + ", bizTime=" + bizTime + ", itemCode=" + itemCode + ", itemName=" + itemName + ", parentId=" + parentId + ", posNo=" + posNo + ", quantity=" + quantity + ", price=" + price + ", amount="
				+ amount + ", itemType=" + itemType + ", discountType=" + discountType + ", comments=" + comments + ", operatorId=" + operatorId + ", operatorName=" + operatorName + ", groupId=" + groupId + ", additional=" + additional + "]";
	}
	
}
