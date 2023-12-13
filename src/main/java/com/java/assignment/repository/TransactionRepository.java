package com.java.assignment.repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.java.assignment.bean.Transaction;


public interface TransactionRepository extends JpaRepository<Transaction, Integer>{
}
