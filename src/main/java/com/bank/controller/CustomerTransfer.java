package com.bank.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.bank.model.Customer;
import com.bank.servicelayer.CustomerService;

@Controller
public class CustomerTransfer {

    @Autowired
    private CustomerService cs;

    @RequestMapping("/Transfer")
    public ModelAndView transfer(@RequestParam("accountNumber") int accno, @RequestParam("amount") int amount,
                                 @RequestParam("receiverAccno") int receiverAccno) {
        ModelAndView mv = new ModelAndView();

        // Get sender account details
        Customer sender = new Customer();
        sender.setAccno(accno);
        Customer oc = cs.getCustomerAccno(sender);

        // Get receiver account details
        Customer receiver = new Customer();
        receiver.setAccno(receiverAccno);
        Customer orc = cs.getCustomerAccno(receiver);

        // Check if sender and receiver accounts exist and the balance is sufficient
        if (orc == null) {
            mv.addObject("result", "Failed: Invalid receiver account number.");
        } else if (amount <= 0 || amount > oc.getBalance()) {
            mv.addObject("result", "Failed: Insufficient balance or invalid amount.");
        } else {
            // Perform the transfer
            if (cs.Deposite(orc, amount) && cs.Deposite(oc, -amount)) {
                mv.addObject("result", amount + " transferred successfully to " + orc.getFullname());
            } else {
                mv.addObject("result", "Transaction failed.");
            }
        }

        // Refresh sender account details and return view
        oc = cs.getCustomerAccno(sender);
        mv.addObject("customer", oc);
        mv.setViewName("welcome");

        return mv;
    }
}
