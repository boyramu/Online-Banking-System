package com.bank.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.bank.model.Customer;
import com.bank.servicelayer.CustomerService;

@Controller
public class CustomerLogin {

    @Autowired
    private CustomerService cs;

    @RequestMapping("/login")
    public ModelAndView validCustomer(@RequestParam("username") String username,
                                      @RequestParam("password") String password) {
        Customer c = new Customer();
        c.setUsername(username);
        c.setPassword(password);

        ModelAndView mv = new ModelAndView();

        Customer loggedInCustomer = cs.customerLogin(c);

        if (loggedInCustomer != null) {
            mv.addObject("customer", loggedInCustomer); // Pass the customer object to the view
            mv.addObject("result", "Login successful");
            mv.setViewName("welcome"); // Redirect to welcome page if login is successful
        } else {
            mv.addObject("result", "Invalid username or password");
            mv.setViewName("signin"); // Redirect back to login page if login fails
        }

        return mv;
    }
}
