package com.capgemini.service;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import com.capgemini.exception.InsufficientBalanceException;
import com.capgemini.exception.InvalidAccountNumberException;
import com.capgemini.exception.InvalidCustomerException;
import com.capgemini.model.Account;
import com.capgemini.model.Customer;

public class BankServiceImple implements BankService {

LinkedList<Account> accounts=new LinkedList<>();
List<Customer> customers = new ArrayList<>();

@Override
public Customer createCustomer(String name) throws InvalidCustomerException{
	
	Customer customer = new Customer(name);
	customers.add(customer);
	System.out.println("a customer is created");
	return customer;
}
	
	
public String createAccount(int accountNumber,int amount, Customer customer) throws InvalidAccountNumberException, InsufficientBalanceException
	{
		if(accountNumber == 0){
			throw new InvalidAccountNumberException();
		}
		if(amount < 500){
			throw new InsufficientBalanceException();
		}
	   Account account = new Account(accountNumber,amount, customer);
		
		accounts.add(account);
		
		return "account created successfully";
	}
	
	public Account searchAccount(int accountNumber)throws InvalidAccountNumberException
	{
		
		for(Account account : accounts)
		{
			if(account.getAccountNumber()==accountNumber)
			{
				return account;
			}
		}
		throw new InvalidAccountNumberException();
		
	}
	
	public int withdrawAmount(int accountNumber,int amount) throws InvalidAccountNumberException, InsufficientBalanceException, InvalidCustomerException
	{
		Account account=searchAccount(accountNumber);
		
		if(account.getAccountNumber() != accountNumber){
			throw new InvalidAccountNumberException();
		}
			
		
		if((account.getAmount()-amount)>=0)
		{
			account.setAmount(account.getAmount()-amount);
			return account.getAmount();
		}
		
		throw new InsufficientBalanceException();
	}


	@Override
	public int depositAmount(int accountNumber, int amount) throws InvalidAccountNumberException {

		Account account=searchAccount(accountNumber);
		if(account != null){
			account.setAmount(account.getAmount() + amount);
			return account.getAmount();
		}
		
		throw new InvalidAccountNumberException();
	}


	@Override
	public int showBalance(int accountNumber) throws InvalidAccountNumberException {
		
		Account account=searchAccount(accountNumber);
		if(account != null){
			
			return account.getAmount();
		}
		
		throw new InvalidAccountNumberException();
	}

	

	

	

}
