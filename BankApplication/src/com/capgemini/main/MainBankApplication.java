package com.capgemini.main;

import com.capgemini.exception.InsufficientBalanceException;
import com.capgemini.exception.InvalidAccountNumberException;
import com.capgemini.exception.InvalidCustomerException;
import com.capgemini.model.Customer;
import com.capgemini.service.BankService;
import com.capgemini.service.BankServiceImple;

public class MainBankApplication {

  
	public static void main(String[] args) {
       
		BankService service = new BankServiceImple();
		Customer customer1;
		Customer customer2;
		try {
			customer1 = service.createCustomer("Zahir");
			customer2 = service.createCustomer("Sanjay");
			
			System.out.println(service.createAccount(5001, 5000, customer1));
			System.out.println(service.createAccount(5002, 15000, customer2));
		} catch (InvalidCustomerException e) {
			System.out.println("Invalid customer ");
		
		}catch (InvalidAccountNumberException e) {
			System.out.println("Invalid account number ");
		}catch (InsufficientBalanceException e) {
			System.out.println("Insufficient balance ");
		}

		
		
		try
		{
			System.out.println("Show Balance AvailableBalance = "+service.showBalance(5001));
			
			System.out.println("Balance = "+service.withdrawAmount(5001, 2000));
			
		}catch(InvalidAccountNumberException i)
		{
			System.out.println("Invalid account number ");
		}
		catch(InsufficientBalanceException ibe){
			System.out.println("insufficient balance");
		}
		catch(InvalidCustomerException ibe){
			System.out.println("invalid customer");
		}

	}




}
