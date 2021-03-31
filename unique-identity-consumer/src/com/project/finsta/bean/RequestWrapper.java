package com.project.finsta.bean;

public class RequestWrapper {
	
	private String userId;
	
	private String amount;
	
	private String type;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "RequestWrapper [userId=" + userId + ", amount=" + amount + ", type=" + type + "]";
	}



}
