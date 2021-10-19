package com.shopit.usersmicroservice.service;

import java.util.List;

import com.shopit.usersmicroservice.entity.Account;

public interface AccountService {
	Account saveAccount(Account account);
	List<Account> getAllAccount();
	Account getAccountByID(long id);
	Account updateAccount(Account account, long id);
	void deleteAccountById(long id);
}