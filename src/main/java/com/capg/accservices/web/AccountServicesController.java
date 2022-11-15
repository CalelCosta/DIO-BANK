package com.capg.accservices.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.*;

import com.capg.accservices.model.Account;
import com.capg.accservices.service.AccountService;

@RestController

@ComponentScan("com.capg.accservices")

@EnableAutoConfiguration
public class AccountServicesController {

	private final AccountService accountService;

	public AccountServicesController(AccountService accountService) {
		this.accountService = accountService;
	}
    
	@CrossOrigin
	@GetMapping(value="/accservices/{customerId}/accounts")
    public List<Account> getAccounts(@PathVariable  int customerId) {
		return accountService.getCustomerAccounts(customerId);
    }
	
	@CrossOrigin
	@GetMapping(value="/accservices/{accountNo}/account")
    public Account getAccountById(@PathVariable  int accountNo) {
		return accountService.getAccountDetailsById(accountNo);
    }
	
	@CrossOrigin
	@PostMapping(value="/accservices/{accountNo}/{amount}/accountdeposit")
    public String depositeAmount(@PathVariable  int accountNo, @PathVariable  int amount) {
		accountService.depositeAmount(accountNo, amount);
		return "Sucess";
    }
	
	@CrossOrigin
	@PostMapping(value="/accservices/{accountNo}/{amount}/accountwithdraw")
    public String withdrawAmount(@PathVariable  int accountNo, @PathVariable  int amount) {
		accountService.withdrawAmount(accountNo, amount);
		return "Sucess";
    }
	
}