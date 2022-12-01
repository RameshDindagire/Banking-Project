package com.banking.dao;

import com.banking.pojo.User;

//HERE USING INTERFACE WE ARE REGISTERING ALL THE METHODS OF USER MODEL
public interface I_User 
{
	public void register(User user); 
	public User login(String userEmail, String userPassword);
	
	//FUTURE METHODS
	public void updateProfile(int userId, User user);
	public void changePassword(String userEmail, String currentPassword, String newPassword);
}
