package com.example.washermicroservice.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="orders")
public class Order {
	
	@Id
	private String orderId;
	
	@NotBlank(message="Usermail cannot be blank")
	@Email
	private String usermail;
	
	
	private String washerName;
	
	@NotBlank(message="Wash Pack cannot be blank")
	private String washPack;
	
	private long mobileNo;
	
	@NotBlank(message="Area Pincode is required. It cannot be blank")
	private String pincode;
	

	private String status;
	
	private Car cars;

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getUsermail() {
		return usermail;
	}

	public void setUsermail(String usermail) {
		this.usermail = usermail;
	}

	public String getWasherName() {
		return washerName;
	}

	public void setWasherName(String washerName) {
		this.washerName = washerName;
	}

	public String getWashPack() {
		return washPack;
	}

	public void setWashPack(String washPack) {
		this.washPack = washPack;
	}

	public long getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(long mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Car getCars() {
		return cars;
	}

	public void setCars(Car cars) {
		this.cars = cars;
	}

	public Order(String orderId, @NotBlank(message = "Usermail cannot be blank") @Email String usermail,
			String washerName, @NotBlank(message = "Wash Pack cannot be blank") String washPack, long mobileNo,
			@NotBlank(message = "Area Pincode is required. It cannot be blank") String pincode, String status,
			Car cars) {
		super();
		this.orderId = orderId;
		this.usermail = usermail;
		this.washerName = washerName;
		this.washPack = washPack;
		this.mobileNo = mobileNo;
		this.pincode = pincode;
		this.status = status;
		this.cars = cars;
	}

	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
