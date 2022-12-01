package com.banking.dao;

import java.util.List;

import com.banking.pojo.bank;

public interface I_BankingDao 
{
	void addBook(bank book);
	List<bank> getAllBooks();
	boolean deleteBook(int id);
	boolean updateBook(int id,bank book);
	
	
	// Method 
	bank getBook(int id);
	List<bank> getBook(String uname);
}
