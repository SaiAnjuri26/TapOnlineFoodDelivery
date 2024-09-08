package com.samfoods.model;

public class Ordertable {
	
	private int oderId;
	private int restuarantId;
	private int userId;
	private String oderDate;
	private double totalAmount;
	private String status;
	private String paymentMode;
	public Ordertable() {
		super();
	}
	public Ordertable(int oderId, int restuarantId, int userId, String oderDate, double totalAmount, String status,
			String paymentMode) {
		super();
		this.oderId = oderId;
		this.restuarantId = restuarantId;
		this.userId = userId;
		this.oderDate = oderDate;
		this.totalAmount = totalAmount;
		this.status = status;
		this.paymentMode = paymentMode;
	}
	public Ordertable( int restuarantId, int userId, String oderDate, double totalAmount, String status,
			String paymentMode) {
		super();
		this.restuarantId = restuarantId;
		this.userId = userId;
		this.oderDate = oderDate;
		this.totalAmount = totalAmount;
		this.status = status;
		this.paymentMode = paymentMode;
	}
	
	
	public int getOderId() {
		return oderId;
	}
	public void setOderId(int oderId) {
		this.oderId = oderId;
	}
	public int getRestuarantId() {
		return restuarantId;
	}
	public void setRestuarantId(int restuarantId) {
		this.restuarantId = restuarantId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getOderDate() {
		return oderDate;
	}
	public void setOderDate(String oderDate) {
		this.oderDate = oderDate;
	}
	public double getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getPaymentMode() {
		return paymentMode;
	}
	public void setPaymentMode(String paymentMode) {
		this.paymentMode = paymentMode;
	}
	@Override
	public String toString() {
		return "ordertable [oderId=" + oderId + ", restuarantId=" + restuarantId + ", userId=" + userId + ", oderDate="
				+ oderDate + ", totalAmount=" + totalAmount + ", status=" + status + ", paymentMode=" + paymentMode
				+ "]";
	}
	
}
