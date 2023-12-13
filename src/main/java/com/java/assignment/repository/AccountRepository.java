package com.java.assignment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.java.assignment.bean.Account;


public interface AccountRepository extends JpaRepository<Account, Integer>{
	
}
