package com.shopit.usersmicroservice.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shopit.usersmicroservice.entity.Account;
import com.shopit.usersmicroservice.repository.AccountRepository;
import com.shopit.usersmicroservice.service.AccountService;

@RestController
@RequestMapping("/api/account")
public class AccountController {

	private AccountService accountService;
	private AccountRepository accountRepository;

	public AccountController(AccountService accountService) {
		super();
		this.accountService = accountService;
	}
	
	@PostMapping
	public ResponseEntity<Account> createAccount(@RequestBody Account account){
		return new ResponseEntity<Account>(accountService.saveAccount(account), HttpStatus.CREATED); 
	}
	
	@GetMapping ("/all")
	public List<Account> getAllAccount(){
		return accountService.getAllAccount();
	}
	
	@GetMapping ("/get/{id}")
	public ResponseEntity<Account> getAccountById(@PathVariable (value = "id") long accountId){
		return new ResponseEntity<Account>(accountService.getAccountByID(accountId), HttpStatus.OK);
	}
	
	@PutMapping ("/set/{id}")
	// convert json to java object
	public ResponseEntity<Account> updateAccount(@PathVariable (value = "id") long accountId, @RequestBody Account account){
		return new ResponseEntity<Account>(accountService.updateAccount(account, accountId), HttpStatus.OK);
	}
	
	@DeleteMapping ("/delete/{id}")
	// convert json to java object
	public ResponseEntity<String> deleteAccount(@PathVariable (value = "id") long accountId){
		
		accountService.deleteAccountById(accountId);
		return new ResponseEntity<String>("Account Deleted", HttpStatus.OK);
	}

	
}
