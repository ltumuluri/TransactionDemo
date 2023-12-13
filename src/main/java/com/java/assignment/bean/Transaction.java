package com.java.assignment.bean;

import javax.persistence.Id;
import io.swagger.annotations.ApiModelProperty;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;


@Entity
public class Transaction {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	@ApiModelProperty(required = true)
	private Integer fromAccountId;
	@ApiModelProperty(required = true)
	private Integer toAccountId;
	@ApiModelProperty(required = true)
	private Integer amount;
	public Transaction() {
		super();
	}
	public Transaction(Integer id, Integer fromAccountId, Integer toAccountId, Integer amount) {
		super();
		this.id = id;
		this.fromAccountId = fromAccountId;
		this.toAccountId = toAccountId;
		this.amount = amount;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getFromAccountId() {
		return fromAccountId;
	}
	public void setFromAccountId(Integer fromAccountId) {
		this.fromAccountId = fromAccountId;
	}
	public Integer getToAccountId() {
		return toAccountId;
	}
	public void setToAccountId(Integer toAccountId) {
		this.toAccountId = toAccountId;
	}
	public Integer getAmount() {
		return amount;
	}
	public void setAmount(Integer amount) {
		this.amount = amount;
	}
	
	
	
}
