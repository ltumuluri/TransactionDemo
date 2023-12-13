package com.java.assignment.serviceimpl;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.assignment.bean.Account;
import com.java.assignment.bean.Response;
import com.java.assignment.bean.Transaction;
import com.java.assignment.repository.AccountRepository;
import com.java.assignment.repository.TransactionRepository;

@Service
public class transactionServiceImpl{
	
	@Autowired
	private TransactionRepository transactionRepository;

	@Autowired
	private AccountRepository accountRepository;

	public Transaction processMessage(Transaction transaction) {
		return transactionRepository.save(transaction);	
	}
	
	public List<Transaction> processMessages(List<Transaction> transactionList) {
		return (List<Transaction>) transactionRepository.saveAll(transactionList);	
	}

	public Account addAmtToAccount(Account account) {
		Optional<Account> temp =  accountRepository.findById(account.getId());
		
		Account existingAccount = null;
		if(temp.isPresent()) {
			existingAccount = temp.get();
			existingAccount.setBalance(existingAccount.getBalance() + account.getBalance());
			accountRepository.save(existingAccount);
		} else {
			existingAccount = accountRepository.save(account);
		}
		return existingAccount;
	}
	
	@Transactional
	public Account transaction(Transaction transaction) {
		Optional<Account> accountFrom = accountRepository.findById(transaction.getFromAccountId());
		Optional<Account> accountTo = accountRepository.findById(transaction.getToAccountId());
		if(!accountFrom.isPresent() || !accountTo.isPresent()) {
			return null;
		}
		Account accountFromActual = accountFrom.get();
		Account accountToActual = accountTo.get();
		
		if(accountFromActual.getBalance() < transaction.getAmount()) {
			return null;
		}
		
		accountFromActual.setBalance(accountFromActual.getBalance() - transaction.getAmount());
		accountToActual.setBalance(accountToActual.getBalance() + transaction.getAmount());
		accountRepository.save(accountFromActual);
		accountRepository.save(accountToActual);
		return accountToActual;
		
	}

	public List<Account> getAllAccountDetails() {
		return accountRepository.findAll();
	}
	
	
	
//	public List<Response> getRewardPoints(LocalDate startDate, LocalDate endDate) {
//		List<Transaction> transactionList = transactionRepository.findAllByTransactionDateBetween(startDate, endDate);
//		List<Response> responseList = new ArrayList<>();
//		
//		Map<Integer, List<Transaction>> customerTransactionMap = new HashMap<>();
//		transactionList.forEach(transaction -> {
//			if(customerTransactionMap.containsKey(transaction.getCustomerId())){
//				customerTransactionMap.get(transaction.getCustomerId()).add(transaction);
//			}else {
//				List<Transaction> transactions = new ArrayList<>();
//				transactions.add(transaction);
//				customerTransactionMap.put(transaction.getCustomerId(), transactions);
//			}
//		});
//			
//		customerTransactionMap.forEach((id,trans) -> {
//			Map<String, Integer> monthSpent = new HashMap<>();
//			trans.forEach(transaction -> {
//				String month = transaction.getTransactionDate().getMonth().name();
//				int rewards = 0;
//				if(transaction.getAmountSpent() < 50) {
//					rewards = 0;
//				} else if(transaction.getAmountSpent() <=100 && transaction.getAmountSpent() > 50) {
//					rewards = transaction.getAmountSpent() - 50;
//				} else if(transaction.getAmountSpent() > 100) {
//					rewards = ((transaction.getAmountSpent()-50)/50) + (2* transaction.getAmountSpent()-100);
//				}
//				if(monthSpent.containsKey(month)){
//					int total = monthSpent.get(month) + rewards;
//					monthSpent.put(month, total);
//				} else {
//					monthSpent.put(month, rewards);
//				}
//			});
//			
//			monthSpent.forEach((month,points)->{
//				Response response = new Response();
//				response.setId(id);
//				response.setMonth(month);
//				response.setPoints(points);
//				responseList.add(response);
//			});			
//		});
//		return responseList;
//	}

	
}
