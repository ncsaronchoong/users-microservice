package com.shopit.usersmicroservice.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.shopit.usersmicroservice.entity.User;
import com.shopit.usersmicroservice.model.UserTO;

@Repository
public interface UserRepository extends JpaRepository <User, Long>{
	User findByUserId(long userId);
	
    @Query(nativeQuery = true,value= " SELECT user_id, name, address, contact_number, date_birth, email FROM USER,  account_id=:accountId")
    UserTO findByAccountId(@Param("accountId") long accountId);
	
}
