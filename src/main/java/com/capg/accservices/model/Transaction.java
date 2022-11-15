package com.capg.accservices.model;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Transaction")
@Getter
@Setter
public class Transaction implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	@Column(name="transaction_id")
	private int transactionId; 
	
	@Column(name="account_no")
	private int accountNo; 
	
	@Column(name="account_balance")
	private double accountBalance;
		
	@Column(name="transaction_type")
	private String transactionType; 
	
	@Column(name="comments")
	private String comments; 
	
	@Column(name="transaction_date")
	private Timestamp transactionDate;

	@Column(name="account_balance_debit")
	private double accountBalanceDebit;
	
    @Column(name="account_balance_credit")
	private double accountBalanceCredit;
	
}
