package com.bank.model;

public class Customer
{
	private String fullname;
    private String gender;
    private String dob;
    private String email;
    private long adharnumber;
    private long phonenumber;
    private String address;
    private String username;
    private String password;
    private int accno;
    private float balance;
    
    public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public long getAdharnumber() {
		return adharnumber;
	}

	public void setAdharnumber(long adharnumber) {
		this.adharnumber = adharnumber;
	}

	public long getPhonenumber() {
		return phonenumber;
	}

	public void setPhonenumber(int phonenumber) {
		this.phonenumber = phonenumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getAccno() {
		return accno;
	}

	public void setAccno(int accno) {
		this.accno = accno;
	}

	public float getBalance() {
		return balance;
	}

	public void setBalance(float balance) {
		this.balance = balance;
	}

	/**
	 * @param fullname
	 * @param gender
	 * @param dob
	 * @param email
	 * @param adharnumber
	 * @param phonenumber
	 * @param address
	 * @param username
	 * @param password
	 * @param accno
	 * @param balance
	 */
	public Customer(int accno,String fullname, String gender, String dob, String email, long adharnumber, long phonenumber,
			String address, String username, String password,float balance) {
		this.fullname = fullname;
		this.gender = gender;
		this.dob = dob;
		this.email = email;
		this.adharnumber = adharnumber;
		this.phonenumber = phonenumber;
		this.address = address;
		this.username = username;
		this.password = password;
		this.accno = accno;
		this.balance = balance;
	}
	public Customer(String fullname, String gender, String dob, String email, long adharnumber, long phonenumber,
			String address, String username, String password, float balance) {
		this.fullname = fullname;
		this.gender = gender;
		this.dob = dob;
		this.email = email;
		this.adharnumber = adharnumber;
		this.phonenumber = phonenumber;
		this.address = address;
		this.username = username;
		this.password = password;
		this.balance = balance;
	}
	public Customer(int accno,String fullname,  String dob, String email, long adharnumber, long phonenumber,
			String address, String username, String password) {
		this.accno=accno;
		this.fullname = fullname;
		this.dob = dob;
		this.email = email;
		this.adharnumber = adharnumber;
		this.phonenumber = phonenumber;
		this.address = address;
		this.username = username;
		this.password = password;
		
	}
	public Customer()
	{
		
	}
	
}
