package com.shopit.usersmicroservice.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shopit.usersmicroservice.entity.Account;
import com.shopit.usersmicroservice.entity.User;

@Repository
public interface AccountRepository extends JpaRepository <Account, Long>{
	Account findByAccountId(long accountId);
}
