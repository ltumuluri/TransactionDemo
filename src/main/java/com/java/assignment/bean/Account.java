package com.java.assignment.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import io.swagger.annotations.ApiModelProperty;

@Entity
public class Account {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	@ApiModelProperty(required = true)
	private String customerId;
	@ApiModelProperty(required = true)
	private Long balance;
	
	
	public Account() {
		super();
	}


	public Account(Integer id, String customerId, Long balance) {
		super();
		this.id = id;
		this.customerId = customerId;
		this.balance = balance;
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getCustomerId() {
		return customerId;
	}


	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}


	public Long getBalance() {
		return balance;
	}


	public void setBalance(Long balance) {
		this.balance = balance;
	}
	
	
	
	
}
