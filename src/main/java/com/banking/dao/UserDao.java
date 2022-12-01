package com.banking.dao;
/*
 create table user(


 userId int primary key auto_increment,
 userName varchar(100),
 userEmail varchar(30) unique,
 userRole varchar(10),
 userPassword varchar(50));
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.banking.pojo.User;



public class UserDao implements I_User {
	Connection con;
	PreparedStatement ps;
	ResultSet rs;
	String sql_Query;

	private Connection getCon() {
		try {
			// Driver Registration
			Class.forName("com.mysql.cj.jdbc.Driver");
			// Establishing the connection
			String url = "jdbc:mysql://localhost:3306/bank";
			String user = "root";
			String password = "";
			Connection con = DriverManager.getConnection(url, user, password);

			return con; // if connected with database return connection object.
		} catch (Exception e) {
			e.printStackTrace();

		}
		return null; // if not able connect with database return null.
	}

	@Override
	public void register(User user) {
		con = getCon();
		sql_Query = "insert into user(userName,userEmail,userRole,userPassword)values(?,?,?,?)";
		try {
			ps = con.prepareStatement(sql_Query);
			ps.setString(1, user.getUserName());
			ps.setString(2, user.getUserEmail());
			ps.setString(3, user.getUserRole());
			ps.setString(4 , user.getUserPassword());
			int row = ps.executeUpdate();
			System.out.println(row + " inserted");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public User login(String userEmail, String userPassword) {
		con = getCon();
		sql_Query = "select * from user where userEmail=? and userPassword=?";
		try {
			ps = con.prepareStatement(sql_Query);
			ps.setString(1, userEmail);
			ps.setString(2, userPassword);
			rs = ps.executeQuery();
			if (rs.next()) {
				User user = new User(rs.getInt("userId"), rs.getString("userName"), rs.getString("userEmail"),
						rs.getString("userRole"), rs.getString("userPassword"));
				return user;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;

	}

	@Override
	public void updateProfile(int userId, User user) {
		// TODO Auto-generated method stub

	}

	@Override
	public void changePassword(String userEmail, String currentPassword, String newPassword) {
		// TODO Auto-generated method stub

	}

}
