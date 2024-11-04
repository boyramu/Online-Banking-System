package com.bank.CustomerDAO;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.bank.model.Customer;

public class CustomerData implements RowMapper<Customer>{

	@Override
	public Customer mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		Customer cr=new Customer(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),
				rs.getLong(6),rs.getLong(7),rs.getString(8),rs.getString(9),rs.getString(10),rs.getFloat(11));
		return cr;
	}

}
