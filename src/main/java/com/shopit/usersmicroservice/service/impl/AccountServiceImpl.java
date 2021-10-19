package com.shopit.usersmicroservice.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.shopit.usersmicroservice.entity.Account;
import com.shopit.usersmicroservice.exception.ResourceNotFoundException;
import com.shopit.usersmicroservice.repository.AccountRepository;
import com.shopit.usersmicroservice.service.AccountService;

@Service
public class AccountServiceImpl implements AccountService{
	
	private AccountRepository accountRepository;
	
	public AccountServiceImpl(AccountRepository accountRepository) {
		super();
		this.accountRepository = accountRepository;
	}

	@Override
	public Account saveAccount(Account account) {
		return accountRepository.save(account);
	}

	@Override
	public List<Account> getAllAccount() {
		return accountRepository.findAll(); 
	}

	@Override
	public Account getAccountByID(long id) {
		Account account = accountRepository.findByAccountId(id);
		if (account != null) {
			return account;
		} else {
			throw new ResourceNotFoundException("Account Not Found");
		}

	}

	@Override
	public Account updateAccount(Account account, long id) {

		Account existingAccount = accountRepository.findByAccountId(id);
		if (existingAccount != null) {
			existingAccount.setAccountId(account.getAccountId());
			existingAccount.setUsername(account.getUsername());
			existingAccount.setPassword(account.getPassword());
			existingAccount.setAccountType(account.getAccountType());
			existingAccount.setCreationDate(account.getCreationDate());
			existingAccount.setLastLogin(account.getLastLogin());
			accountRepository.save(existingAccount);
			return existingAccount;
		} else {
			throw new ResourceNotFoundException("Account Not Found");
		}
	}

	@Override
	public void deleteAccountById(long id) {
		
		Account account = accountRepository.findByAccountId(id);
		if (account != null) {
			accountRepository.deleteById(id);
		} else {
			throw new ResourceNotFoundException("Account Not Found");
		}
		
	}
	
}
