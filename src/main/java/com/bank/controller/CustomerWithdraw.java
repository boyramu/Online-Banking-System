package com.bank.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.bank.model.Customer;
import com.bank.servicelayer.CustomerService;

@Controller
public class CustomerWithdraw 
{
	@Autowired
	private CustomerService cs;
 @RequestMapping("Withdraw")
 public ModelAndView withdraw(@RequestParam("accountNumber") int accno,@RequestParam("amount") int amount)
 {
	 ModelAndView mv = new ModelAndView();
	 Customer c=new Customer();
	 c.setAccno(accno);
	 Customer oc=cs.getCustomerAccno(c);
	 if(amount==0 || amount>oc.getBalance())
	 {
		 mv.addObject("result","enter valid amount !");
	 }
	 else if(cs.Deposite(oc, -amount))
	 {
		 mv.addObject("result",amount+" withdraw success");
	 }
	 else
	 {
		 mv.addObject("result","withdra failed");
	 }
	 oc=cs.getCustomerAccno(c);
	 mv.addObject("customer",oc);
	 mv.setViewName("welcome");
	 return mv;
 }
}
