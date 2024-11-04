package com.bank.CustomerDAO;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.bank.model.Customer;
@Repository
public class CustomerDAO 
{
   @Autowired
   private JdbcTemplate jdbc;
   public int saveCustomer(Customer c)
   {
	   String create_account="insert into customer(fullname,gender,dob,email,adharnumber,phonenumber,address,username,password,balance)"
		   		+ "values(?,?,?,?,?,?,?,?,?,?)";
	   return jdbc.update(create_account,c.getFullname(),c.getGender(),c.getDob(),c.getEmail(),c.getAdharnumber(),
			   c.getPhonenumber(),c.getAddress(),c.getUsername(),c.getPassword(),c.getBalance());
   }
   public List<Customer> getCustomer(Customer c)
   {
	   String sql="select * from customer where username=? and password=?";
	   CustomerData customerData = new CustomerData();
	   return jdbc.query(sql,customerData,c.getUsername(),c.getPassword());
   }
   public int Deposite(Customer c,int amount)
   {
	   String deposite="update customer set balance=balance+? where accno=?";
	   return jdbc.update(deposite,amount,c.getAccno());
   }
   public Customer getCustomerAccno(Customer c) {
       String sql = "select * from customer where accno=?";
       CustomerData customerData = new CustomerData();
       
       try {
           return jdbc.queryForObject(sql, customerData, c.getAccno());
       } catch (EmptyResultDataAccessException e) {
           // Return null if no result is found
           return null;
       }
   }
   public int updateCustomer(Customer c)
   {
	   String sql=" UPDATE customer SET fullname=? , dob=? , email = ? , adharnumber=? , phonenumber =? , address=? , username =? , password =? WHERE accno=? ";
	   return jdbc.update(sql,c.getFullname(),c.getDob(),c.getEmail(),c.getAdharnumber(),c.getPhonenumber()
			   ,c.getAddress(),c.getUsername(),c.getPassword(),c.getAccno());
   }
   //Queries
  /* 
   private static String getCustomer="select * from customer where accno=?";
   private static String getCustomerData="select * from customer where username=? and password=?";
   private static String deposite="update customer set balance=balance+? where accno=?";
   private static String getAllCustomers="select * from customer";
   private static String updateCus=" UPDATE customer SET fullname=? , dob=? , email = ? , adharnumber=? , phonenumber =? , address=? , username =? , password =? WHERE accno=? ;";*/
   
}
