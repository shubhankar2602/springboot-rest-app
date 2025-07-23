package com.oracle.model;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Component
@Scope(scopeName = "prototype")
@Entity
@Table(name = "myAccount")
public class Account {
	@Id
	@Column(name = "acc_id")
	private int accountId;
	private double balance;

	public Account() {
		super();
		System.out.println("Account created");
	}

	@Override
	public String toString() {
		return "Account [accountId=" + accountId + ", balance=" + balance + "]";
	}

	public int getAccountId() {
		return accountId;
	}

	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

}
