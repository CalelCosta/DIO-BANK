package com.capg.accservices.service.impl;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.List;

import org.springframework.stereotype.Service;

import com.capg.accservices.dao.AccountDao;
import com.capg.accservices.dao.TransactionDao;
import com.capg.accservices.model.Account;
import com.capg.accservices.model.Transaction;
import com.capg.accservices.service.AccountService;

@Service
public class AccountServiceImpl implements AccountService{

	private AccountDao accountDao;

	public AccountServiceImpl(AccountDao accountDao) {
		this.accountDao = accountDao;
	}

	private TransactionDao transactionDao;

	public AccountServiceImpl(TransactionDao transactionDao) {
		this.transactionDao = transactionDao;
	}
    
	public List<Account> getCustomerAccounts(int customerId)
	{
		List<Account> accountList= accountDao.findByCustomerId(customerId);
		int size=accountList.size();
		return accountList;
	
	}
	
	@Override
	public Account getAccountDetailsById(int accountNo) {
		return accountDao.findByAccountNo(accountNo);
	}

	@Override
	public void depositeAmount(int accountNo, double amount) {
		  Account account = accountDao.findByAccountNo(accountNo);
		  Transaction transaction =new Transaction();
		  double newBalance = account.getAccountBalance() + amount;
		  account.setAccountBalance(newBalance);
		  accountDao.save(account);
		  transaction.setAccountBalance(account.getAccountBalance());
		  transaction.setAccountNo(accountNo);
		  transaction.setComments("credit transaction");
		  Calendar calendar = Calendar.getInstance();
		  transaction.setTransactionDate(new Timestamp (calendar.getTime().getTime()));
		  transaction.setTransactionType("Credit");
		  transaction.setAccountBalanceCredit(amount);
		  transactionDao.save(transaction);
	}

	@Override
	public void withdrawAmount(int accountNo, double amount) {
		Account account = accountDao.findByAccountNo(accountNo);
		Transaction transaction =new Transaction();
		  if (amount > account.getAccountBalance()) {
          }else {
		         double newBalance = account.getAccountBalance() - amount;
			     account.setAccountBalance(newBalance);
			     accountDao.save(account);
			     transaction.setAccountBalance(account.getAccountBalance());
				 transaction.setAccountNo(accountNo);
				 transaction.setComments("debit transaction");
				 Calendar calendar = Calendar.getInstance();
				 transaction.setTransactionDate(new Timestamp (calendar.getTime().getTime()));
				 transaction.setTransactionType("Debit");
				 transaction.setAccountBalanceDebit(amount);
				 transactionDao.save(transaction);

          }
	}
}
