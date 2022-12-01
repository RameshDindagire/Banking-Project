package com.banking.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.banking.pojo.bank;

public class BankDao 
{
	// To Communicate with Database we use at-least 3 Interface of JDBC API.
	Connection con = null;  // It connection between Java Application and Database.
	Statement stmt = null;  // it Used to Execute SQL Statement on database.
	PreparedStatement ps = null;
	/*
	 	PreparedStatement is Child interface of Statement interface.
	 	It used perform dynamic SQL Queries on database
	 */
	
	ResultSet rs = null;   // It used to store the data of database retrieve by SQL Query. 
	
	
	
	/*
	  		As you All to Connect with database initial 3 step are commons
	  		so don't write steps again and again wo that's why we create a seprated method 
	  		for that.
	 */
	
	public Connection getCon()
	{
		try
		{
			//JDBC step-2 Register the JDBC Driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			// JDBC Step-3 Establish the Connection with Database.
			
			String URL="jdbc:mysql://localhost:3306/bank";
			String user="root";
			String password="";
			Connection con = DriverManager.getConnection(URL,user,password);
			
			return con;
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null; // if Connections is not establish then it returns Null.
	}
	
	
	
	// We create this method to add book in database.
	public void addbank(bank userdetail)
	{
		// Write the logic to add book detail in database.
		con = getCon();
		// here we execute Dynamic SQL Query 
		try
		{
			ps  = con.prepareStatement("insert into userdetail(uname,uemail) values (?,?)");
			// here ? are the placeholder for the Book name and price respectively.
			//
			
			// Now we set the ? with thier values .
			ps.setString(1,userdetail.getuname());
			ps.setString(2,userdetail.getuemail());
			
			int row = ps.executeUpdate();
			
			System.out.println(row+" Inserted...");
			
			
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		
		
	}
	
	public List<bank> getAllBooks()
	{
		List<bank> booklist = new ArrayList<bank>();
		
		// here you have to create a logic to get book details from 
		// database.
		try 
		{
			con = getCon();
			stmt = con.createStatement();
			rs = stmt.executeQuery("select * From userdetail");
			
			// Now we add rs data into booklist in book object from.
			
			while(rs.next()) // check that rs have any row or not
			{
				// if there is row in row then we create a object of that row 
				bank userdetail = new bank(rs.getInt(1), rs.getString(2), rs.getString(3));
				// here we add that object into booklist
				booklist.add(userdetail);		
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return booklist;
	}
	public  boolean updateBank(int id,bank userdetail)
	{
		con = getCon();
		try 
		{
			ps = con.prepareStatement("update userdetail set uname=?,uemail=? where id=?");
			ps.setString(1, userdetail.getuname());
			ps.setString(2,userdetail.getuemail());
			ps.setInt(3, id);
			
			int row = ps.executeUpdate();
			
			if(row>0)
			{
				return true;
			}
			ps.close();
			con.close();
		} 
		catch (SQLException e) 
		{	
			e.printStackTrace();
		}
		return false; // by default returns false.
	}
	
	public  boolean updateBank(int id,String uname)
	{
		con = getCon();
		try 
		{
			ps = con.prepareStatement("update userdetail set uname=? where id=?");
			ps.setString(1, uname);
			ps.setInt(2, id);
			
			int row = ps.executeUpdate();
			
			if(row>0)
			{
				return true;
			}
			ps.close();
			con.close();
		} 
		catch (SQLException e) 
		{	
			e.printStackTrace();
		}
		return false; // by default returns false.
	}
	
	public boolean deleteBank(int id)
	{
		con = getCon();
		try 
		{
			ps = con.prepareStatement("delete from userdetail where id=?");
			
			ps.setInt(1, id); // here we set the value to the ? of query.
			
			int row = ps.executeUpdate();
			
			if(row>0)
			{
				return true;
			}
			con.close();
			ps.close();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return false;
	}// end delete method.
	
	public bank getBankById(int id)
	{
		try 
		{
			con = getCon();   // establish the connection and return its object
	 		stmt = con.createStatement();
			
			rs = stmt.executeQuery("select * From userdetail where id="+id);
			
			while(rs.next())
			{
				bank Bank = new bank(rs.getInt(1),rs.getString(2),rs.getString(3));				
				return Bank;
			}
			rs.close();
			stmt.close();
			con.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return null;
	}
	
	
	public static void main(String[] args) 
	{/*
		bank b1 = new bank("prany", "@email@hy");
		
		BankDao bookdao = new BankDao();
		bookdao.addbank(b1);
		
		List<bank> blist = bookdao.getAllBooks(); 
		//System.out.println(blist);   // to print all book on one line only.
		
		for(bank b:blist) 
		{
			System.out.println(b);
		}
		
		// Testing Connection method.
		Connection con =  bookdao.getCon();
		System.out.println(con!=null);
		//
		BankDao.deletebank(9);
		List<bank> blist = BankDao.getAllBooks(); 
		for(bank b:blist) 
		{
			System.out.println(b);
		}*/
		
	}
}
