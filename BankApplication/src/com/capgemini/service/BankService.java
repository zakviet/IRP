package com.capgemini.service;

import com.capgemini.exception.InsufficientBalanceException;
import com.capgemini.exception.InvalidAccountNumberException;
import com.capgemini.exception.InvalidCustomerException;
import com.capgemini.model.Account;
import com.capgemini.model.Customer;

public interface BankService {
	
	public String createAccount(int accountNumber,int amount, Customer customer) throws InvalidAccountNumberException, InsufficientBalanceException;
	public Account searchAccount(int accountNumber) throws InvalidAccountNumberException;
	public int withdrawAmount(int accountNumber,int amount) throws InvalidAccountNumberException, InsufficientBalanceException, InvalidCustomerException;
	public Customer createCustomer(String name) throws InvalidCustomerException;
	public int depositAmount(int accountNumber,int amount) throws InvalidAccountNumberException;
	public int showBalance(int accountNumber) throws InvalidAccountNumberException;
}
