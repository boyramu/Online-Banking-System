package com.bank.servicelayer;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bank.CustomerDAO.CustomerDAO;
import com.bank.model.Customer;

@Service
public class CustomerService {

    @Autowired
    private CustomerDAO dao;

    public boolean saveCustomer(Customer c) {
        return 1 == dao.saveCustomer(c);
    }

    public Customer customerLogin(Customer c) {
        List<Customer> res = dao.getCustomer(c);

        if (res != null) {
        	            for (Customer cr : res) {
                if (cr.getUsername().equals(c.getUsername()) && cr.getPassword().equals(c.getPassword()))
                {
                	
                    return cr; // Return the logged-in customer object
                }
            }
        }

        return null; // Return null if login fails
    }
    public boolean Deposite(Customer c,int amount)
    {
    	return 1==dao.Deposite(c, amount);
    }
    public Customer getCustomerAccno(Customer c)
    {
    	return dao.getCustomerAccno(c);
    }
    public boolean updateCustomer(Customer c)
    {
    	return 1==dao.updateCustomer(c);
    }
}
