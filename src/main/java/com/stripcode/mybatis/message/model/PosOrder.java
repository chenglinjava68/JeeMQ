package com.stripcode.mybatis.message.model;

import java.io.Serializable;

/**
 * 
 * ��������pos������ϸ
 *
 * @version: 1.0
 * @author: Metro
 * @version: 2014��4��18�� ����9:39:31
 */
@SuppressWarnings("serial")
public class PosOrder implements Serializable
{

	/* serialVersionUID: serialVersionUID */
	private static final long serialVersionUID = 1L;
	private String orderId;// ������
	private String storeCode;
	private String bizDate;// ����ʱ��
	private String posNo;// POS����
	private Integer cashierId;// ����Աid
	private String cashierName;// ����Ա����
	private Integer waiterId;// ����Աid
	private String waiterName;// ����Ա����
	private String fromTime;// ���׿�ʼʱ��hh:mm
	private String toTime;// ���׽���ʱ��hh:mm
	private Integer guestCount;// ������
	private Integer guestCountFemale;// ���������У�
	private Integer guestCountMale;// ��������Ů��
	private Integer tableId;// ����
	private float shouldAmount;// Ӧ�ս��
	private float cutoffAmount;// Ĩ����
	private float actualAmount;// ʵ�ս��
	private float promoAmount;// ���ͽ��
	private float discountAmount;// �ۿ۽��
	private float exAmount;// ���ս��
	public float changes;// ����
	private Integer serviceType;// ��������1-��ʳ 2-��� 3-����4-רҵ���� @see PosConstant
	private Integer posModel;// posģʽ[]
	private Integer status;// ����״̬[�㵥,�䵥,����] @see OrderStatus
	private Integer preOrderNo;// ��λ˳���
	private Integer orderType;// ��������[���� ����ȡ�� ��Ѻ�� ��ֵ] @see OrderType
	private String lockTime;// ��������״̬
	private String tableClearTime;// ��̨ʱ��
	private String payPosNo;// ����POS����
	private String comments;// �˵�ԭ��
	private Integer memberNo;// ��Ա����
	private Integer entranceType;//������͡�0�ŵ�㵥,1΢�ţ�2�������,��

	private float def1;// �Ź�ȯ�ۿ۽��(û��)
	private String def2;//1 ��ʾˢ�����Ѽ�¼ 2
	private String def3;// ������Ӧ������
	private String def4;
	private String def5;

	private String def6;//�Ƿ񿪷�Ʊ
	private String def7;//����
	private String def8;
	private String def9;
	private String def10;//0��֧�� 1��ȡ�� 2��ȡ��

	private float remain;

	private float point;

	private boolean pointDiscount;// �㿨�ۿ�

	private Integer syncStatus;

	private Integer tableID;

	private Integer deskID;

	public Integer getSyncStatus() {
		return syncStatus;
	}

	public void setSyncStatus(Integer syncStatus) {
		this.syncStatus = syncStatus;
	}
	public Integer getEntranceType() {
		return entranceType;
	}

	public void setEntranceType(Integer entranceType) {
		this.entranceType = entranceType;
	}

	public String getDef6() {
		return def6;
	}

	public void setDef6(String def6) {
		this.def6 = def6;
	}

	public String getDef9() {
		return def9;
	}

	public void setDef9(String def9) {
		this.def9 = def9;
	}

	public String getDef8() {
		return def8;
	}

	public void setDef8(String def8) {
		this.def8 = def8;
	}

	public String getDef7() {
		return def7;
	}

	public void setDef7(String def7) {
		this.def7 = def7;
	}

	public String getDef10() {
		return def10;
	}

	public void setDef10(String def10) {
		this.def10 = def10;
	}

	public boolean isPointDiscount()
	{
		return pointDiscount;
	}
	
	public void setPointDiscount(boolean pointDiscount)
	{
		this.pointDiscount = pointDiscount;
	}
	
	public float getPoint()
	{
		return point;
	}
	
	public void setPoint(float point)
	{
		this.point = point;
	}
	
	public float getRemain()
	{
		return remain;
	}
	
	public void setRemain(float remain)
	{
		this.remain = remain;
	}
	
	public String getOrderId()
	{
		return orderId;
	}
	
	public void setOrderId(String orderId)
	{
		this.orderId = orderId;
	}
	
	public String getStoreCode()
	{
		return storeCode;
	}
	
	public void setStoreCode(String storeCode)
	{
		this.storeCode = storeCode;
	}
	
	public String getBizDate()
	{
		return bizDate;
	}
	
	public void setBizDate(String bizDate)
	{
		this.bizDate = bizDate;
	}
	
	public String getPosNo()
	{
		return posNo;
	}
	
	public void setPosNo(String posNo)
	{
		this.posNo = posNo;
	}
	
	public Integer getCashierId()
	{
		return cashierId;
	}
	
	public void setCashierId(Integer cashierId)
	{
		this.cashierId = cashierId;
	}
	
	public String getCashierName()
	{
		return cashierName;
	}
	
	public void setCashierName(String cashierName)
	{
		this.cashierName = cashierName;
	}
	
	public Integer getWaiterId()
	{
		return waiterId;
	}
	
	public void setWaiterId(Integer waiterId)
	{
		this.waiterId = waiterId;
	}
	
	public String getWaiterName()
	{
		return waiterName;
	}
	
	public void setWaiterName(String waiterName)
	{
		this.waiterName = waiterName;
	}
	
	public String getFromTime()
	{
		return fromTime;
	}
	
	public void setFromTime(String fromTime)
	{
		this.fromTime = fromTime;
	}
	
	public String getToTime()
	{
		return toTime;
	}
	
	public void setToTime(String toTime)
	{
		this.toTime = toTime;
	}
	
	public Integer getGuestCount()
	{
		return guestCount;
	}
	
	public void setGuestCount(Integer guestCount)
	{
		this.guestCount = guestCount;
	}
	
	public Integer getGuestCountFemale()
	{
		return guestCountFemale;
	}
	
	public void setGuestCountFemale(Integer guestCountFemale)
	{
		this.guestCountFemale = guestCountFemale;
	}
	
	public Integer getGuestCountMale()
	{
		return guestCountMale;
	}
	
	public void setGuestCountMale(Integer guestCountMale)
	{
		this.guestCountMale = guestCountMale;
	}
	
	public Integer getTableId()
	{
		return tableId;
	}
	
	public void setTableId(Integer tableId)
	{
		this.tableId = tableId;
	}
	
	public float getShouldAmount()
	{
		return shouldAmount;
	}
	
	public void setShouldAmount(float shouldAmount)
	{
		this.shouldAmount = shouldAmount;
	}
	
	public float getCutoffAmount()
	{
		return cutoffAmount;
	}
	
	public void setCutoffAmount(float cutoffAmount)
	{
		this.cutoffAmount = cutoffAmount;
	}
	
	public float getActualAmount()
	{
		return actualAmount;
	}
	
	public void setActualAmount(float actualAmount)
	{
		this.actualAmount = actualAmount;
	}
	
	public float getPromoAmount()
	{
		return promoAmount;
	}
	
	public void setPromoAmount(float promoAmount)
	{
		this.promoAmount = promoAmount;
	}
	
	public float getDiscountAmount()
	{
		return discountAmount;
	}
	
	public void setDiscountAmount(float discountAmount)
	{
		this.discountAmount = discountAmount;
	}
	
	public float getExAmount()
	{
		return exAmount;
	}
	
	public void setExAmount(float exAmount)
	{
		this.exAmount = exAmount;
	}
	
	public Integer getServiceType()
	{
		return serviceType;
	}
	
	public void setServiceType(Integer serviceType)
	{
		this.serviceType = serviceType;
	}
	
	public Integer getPosModel()
	{
		return posModel;
	}
	
	public void setPosModel(Integer posModel)
	{
		this.posModel = posModel;
	}
	
	public Integer getStatus()
	{
		return status;
	}
	
	public void setStatus(Integer status)
	{
		this.status = status;
	}
	
	public Integer getPreOrderNo()
	{
		return preOrderNo;
	}
	
	public void setPreOrderNo(Integer preOrderNo)
	{
		this.preOrderNo = preOrderNo;
	}
	
	public Integer getOrderType()
	{
		return orderType;
	}
	
	public void setOrderType(Integer orderType)
	{
		this.orderType = orderType;
	}
	
	public String getLockTime()
	{
		return lockTime;
	}
	
	public void setLockTime(String lockTime)
	{
		this.lockTime = lockTime;
	}
	
	public String getTableClearTime()
	{
		return tableClearTime;
	}
	
	public void setTableClearTime(String tableClearTime)
	{
		this.tableClearTime = tableClearTime;
	}
	
	public String getPayPosNo()
	{
		return payPosNo;
	}
	
	public void setPayPosNo(String payPosNo)
	{
		this.payPosNo = payPosNo;
	}
	
	public String getComments()
	{
		return comments;
	}
	
	public void setComments(String comments)
	{
		this.comments = comments;
	}
	
	public float getDef1()
	{
		return def1;
	}
	
	public void setDef1(float def1)
	{
		this.def1 = def1;
	}
	
	public String getDef2()
	{
		return def2;
	}
	
	public void setDef2(String def2)
	{
		this.def2 = def2;
	}
	
	public String getDef3()
	{
		return def3;
	}
	
	public void setDef3(String def3)
	{
		this.def3 = def3;
	}
	
	public String getDef4()
	{
		return def4;
	}
	
	public void setDef4(String def4)
	{
		this.def4 = def4;
	}
	
	public String getDef5()
	{
		return def5;
	}
	
	public void setDef5(String def5)
	{
		this.def5 = def5;
	}
	
	public Integer getMemberNo()
	{
		return memberNo;
	}
	
	public void setMemberNo(Integer memberNo)
	{
		this.memberNo = memberNo;
	}
	
	public float getChanges()
	{
		return changes;
	}
	
	public void setChanges(float changes)
	{
		this.changes = changes;
	}

	public Integer getTableID() {
		return tableID;
	}

	public void setTableID(Integer tableID) {
		this.tableID = tableID;
	}

	public Integer getDeskID() {
		return deskID;
	}

	public void setDeskID(Integer deskID) {
		this.deskID = deskID;
	}

	/*@Override
	public String toString()
	{
		return "PosOrder [orderId=" + orderId + ", storeCode=" + storeCode + ", bizDate=" + bizDate + ", posNo=" + posNo + ", cashierId=" + cashierId + ", cashierName=" + cashierName + ", waiterId=" + waiterId + ", waiterName=" + waiterName + ", fromTime=" + fromTime
				+ ", toTime=" + toTime + ", guestCount=" + guestCount + ", guestCountFemale=" + guestCountFemale + ", guestCountMale=" + guestCountMale + ", tableId=" + tableId + ", shouldAmount=" + shouldAmount + ", cutoffAmount=" + cutoffAmount + ", actualAmount="
				+ actualAmount + ", promoAmount=" + promoAmount + ", discountAmount=" + discountAmount + ", exAmount=" + exAmount + ", changes=" + changes + ", serviceType=" + serviceType + ", posModel=" + posModel + ", status=" + status + ", preOrderNo=" + preOrderNo
				+ ", orderType=" + orderType + ", lockTime=" + lockTime + ", tableClearTime=" + tableClearTime + ", payPosNo=" + payPosNo + ", comments=" + comments + ", memberNo=" + memberNo + ", def1=" + def1 + ", def2=" + def2 + ", def3=" + def3 + ", def4=" + def4 + ", def5="
				+ def5 + "]";
	}*/

	@Override
	public String toString() {
		return "PosOrder{" +
				"orderId='" + orderId + '\'' +
				", storeCode='" + storeCode + '\'' +
				", bizDate='" + bizDate + '\'' +
				", posNo='" + posNo + '\'' +
				", cashierId=" + cashierId +
				", cashierName='" + cashierName + '\'' +
				", waiterId=" + waiterId +
				", waiterName='" + waiterName + '\'' +
				", fromTime='" + fromTime + '\'' +
				", toTime='" + toTime + '\'' +
				", guestCount=" + guestCount +
				", guestCountFemale=" + guestCountFemale +
				", guestCountMale=" + guestCountMale +
				", tableId=" + tableId +
				", shouldAmount=" + shouldAmount +
				", cutoffAmount=" + cutoffAmount +
				", actualAmount=" + actualAmount +
				", promoAmount=" + promoAmount +
				", discountAmount=" + discountAmount +
				", exAmount=" + exAmount +
				", changes=" + changes +
				", serviceType=" + serviceType +
				", posModel=" + posModel +
				", status=" + status +
				", preOrderNo=" + preOrderNo +
				", orderType=" + orderType +
				", lockTime='" + lockTime + '\'' +
				", tableClearTime='" + tableClearTime + '\'' +
				", payPosNo='" + payPosNo + '\'' +
				", comments='" + comments + '\'' +
				", memberNo=" + memberNo +
				", entranceType=" + entranceType +
				", def1=" + def1 +
				", def2='" + def2 + '\'' +
				", def3='" + def3 + '\'' +
				", def4='" + def4 + '\'' +
				", def5='" + def5 + '\'' +
				", def6='" + def6 + '\'' +
				", def7='" + def7 + '\'' +
				", def8='" + def8 + '\'' +
				", def9='" + def9 + '\'' +
				", def10='" + def10 + '\'' +
				", remain=" + remain +
				", point=" + point +
				", pointDiscount=" + pointDiscount +
				", syncStatus=" + syncStatus +
				", tableID=" + tableID +
				", deskID=" + deskID +
				'}';
	}
}
