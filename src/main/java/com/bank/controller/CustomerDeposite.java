package com.bank.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.bank.model.Customer;
import com.bank.servicelayer.CustomerService;

@Controller
public class CustomerDeposite {
    @Autowired
    private CustomerService cs;

    @RequestMapping("/Deposit")
    public ModelAndView deposit(@RequestParam("accountNumber") int accno, @RequestParam("amount") int amount) {
        ModelAndView mv = new ModelAndView();
        Customer c = new Customer();
        c.setAccno(accno);
        
        if (amount <= 0) {
            mv.addObject("result", "Deposit amount should be greater than zero.");
        } else {
            if (cs.Deposite(c, amount)) {
                mv.addObject("result", amount + " deposited successfully.");
            } else {
                mv.addObject("result", "Deposit unsuccessful. Please try again.");
            }
        }
        Customer oc=cs.getCustomerAccno(c);
        mv.addObject("customer",oc);
        mv.setViewName("welcome");
        return mv;
    }
}
