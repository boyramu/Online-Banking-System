package com.bank.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.bank.model.Customer;
import com.bank.servicelayer.CustomerService;

@Controller
public class CustomerUpadte 
{
  @Autowired
  private CustomerService cs;
  @RequestMapping("/Update")
  public ModelAndView update(@RequestParam("accountNumber") int accno,@RequestParam("fullname") String fullname, 
          @RequestParam("dob") String dob, 
          @RequestParam("email") String email,
          @RequestParam("adharnumber") long adharnumber, 
          @RequestParam("phonenumber") long phonenumber,
          @RequestParam("address") String address, 
          @RequestParam("username") String username,
          @RequestParam("password") String password)
  {
	  ModelAndView mv = new ModelAndView();
	  Customer c = new Customer(accno,fullname,dob, email, adharnumber, phonenumber, address, username, password);
	  if(cs.updateCustomer(c))
	  {
		  mv.addObject("result","updated Successfully");
	  }
	  else
	  {
		  mv.addObject("result","failed to update"); 
	  }
	  c=cs.getCustomerAccno(c);
	  mv.addObject("customer",c);
	  mv.setViewName("welcome");
	  return mv;
  }
}
