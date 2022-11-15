package com.capg.accservices.model;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Configuration
@Component

@Entity
@Getter
@Setter
@Table(name = "Account")

public class Account {

		@Id
	
	@Column(name="account_no")

	private int accountNo;
	
	@Column(name="customer_id")
	private int customerId;

	public boolean isAccountStatus() {
		return accountStatus;
	}

	@NotNull
	@Column(name="ifsc_code")
	private String ifscCode;
	  @NotNull
		@Column(name="account_type")

	private  String accountType;
	  @NotNull
		@Column(name="account_balance")

	  private double accountBalance;
		@Column(name="account_creation_date")

	  private Date accountCreationDate;
	  @NotNull

		@Column(name="account_status  	")
	private boolean accountStatus;
	
}
