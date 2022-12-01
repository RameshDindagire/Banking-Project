package com.banking.pojo;

public class bank 
{
	private int id;
	private String uname;
	private String  uemail;
	
	//To Create Empty book Object
	public bank() {
	}
	// To Create Book with Name and Price only not id
	public bank(String uname, String uemail) {
		super();
		this.uname = uname;
		this.uemail = uemail;
	}
	// To Create Book with all details like ID Name and Price.
	public bank(int id, String uname, String uemail) {
		super();
		this.id = id;
		this.uname = uname;
		this.uemail = uemail;
	}
	//To Access the private variables outside the class we use 
	// Getters and Setters
		
	public int getid() {
		return id;
	}
	public void setid(int id) {
		this.id = id;
	}
	public String getuname() {
		return uname;
	}
	public void setuname(String uname) {
		this.uname = uname;
	}
	public String getuemail() {
		return uemail;
	}
	public void setuemail(String uemail) {
		this.uemail = uemail;
	}
	// To Print object data in String Format we use toString method.
	@Override
	public String toString() {
		return "USER DETAILS [id=" + id + ", uname=" + uname + ", uemail=" + uemail + "]";
	}
	
	public static void main(String[] args) 
	{
		bank b1 = new bank();
		// We create empty book object.
		bank b2 = new bank("ajya","hb@jbjuhb");
		// We create book object with Name and Price 
		bank b3 = new bank(101,"ramesh ","gvghv2@bj");
		// We create book object with All Details like Id, Name, Price 

		System.out.println(b1);
		System.out.println(b2);
		System.out.println(b3);
		
		
	}
}
