package com.devsu.hackerearth.backend.account.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "transactions")
public class Transaction extends Base {

	@Column(nullable = false)
	private Date date;

	@Column(nullable = false)
	private String type;

	@Column(nullable = false)
	private double amount;

	@Column(nullable = false)
	private double balance;

	@Column(name = "account_id")
	private Long accountId;

	public Transaction() {
	}

	public Transaction(Date date, String type, double amount, double balance, Long accountId) {
		this.date = date;
		this.type = type;
		this.amount = amount;
		this.balance = balance;
		this.accountId = accountId;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public Long getAccountId() {
		return accountId;
	}

	public void setAccountId(Long accountId) {
		this.accountId = accountId;
	}

}
