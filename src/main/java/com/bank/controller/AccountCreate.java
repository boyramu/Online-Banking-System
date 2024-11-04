package com.bank.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.bank.model.Customer;
import com.bank.servicelayer.CustomerService;

@Controller
public class AccountCreate {

    @Autowired
    private CustomerService cs;

    @PostMapping("/add")
    public ModelAndView signup(@RequestParam("fullname") String fullname, 
                               @RequestParam("gender") String gender,
                               @RequestParam("dob") String dob, 
                               @RequestParam("email") String email,
                               @RequestParam("adharnumber") long adharnumber, 
                               @RequestParam("phonenumber") long phonenumber,
                               @RequestParam("address") String address, 
                               @RequestParam("username") String username,
                               @RequestParam("password") String password) {

        float balance = 0;
        Customer c = new Customer(fullname, gender, dob, email, adharnumber, phonenumber, address, username, password, balance);
        ModelAndView mv = new ModelAndView();

       if (cs.saveCustomer(c)) {
            mv.addObject("result", "Account created Successfully, Now click on login");
            mv.setViewName("signin");
        } else {
            mv.addObject("result", "Failed to create account, try again");
            mv.setViewName("signup");
        }
        return mv;
    }
}
