package com.greatlearning.cmsapp.controller;

import com.greatlearning.cmsapp.entity.Customer;
import com.greatlearning.cmsapp.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/customers")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @RequestMapping("/list")
    public String listStudents(Model theModel) {

        List<Customer> customers = customerService.findAll();
        theModel.addAttribute("customers",customers);
        return "list-customers"; // /WEB-INF/views/list-customers.jsp

    }
    @RequestMapping("/showFormForAdd")
    public String showFormforAdd(Model theModel) {
        Customer theCustomer = new Customer();

        theModel.addAttribute("Customer",theCustomer);

        return "Customer-form";

    }
    @RequestMapping("/showFormForUpdate")
    public String showFormforUpdate(@RequestParam("customerId") int id,Model theModel) {
        Customer theCustomer = customerService.findById(id);

        theModel.addAttribute("Customer",theCustomer);

        return "Customer-form";

    }
    @PostMapping("/save")
    public String saveStudents(@RequestParam("id") int id,
                           @RequestParam("fname") String fname,@RequestParam("lname") String lname,@RequestParam("email") String email) {

        System.out.println(id);

        Customer theCustomer;

        if(id!=0) {
            theCustomer  = customerService.findById(id);
            theCustomer.setFname(fname);
            theCustomer.setLname(lname);
            theCustomer.setEmail(email);

        }
        else
            theCustomer = new Customer(fname,lname,email);
        customerService.save(theCustomer);

        return "redirect:/customers/list";

    }


    @RequestMapping("/delete")
    public String delete(@RequestParam("customerId") int theId) {

        // delete the Student
        customerService.deleteById(theId);

        // redirect to /Students/list
        return "redirect:/customers/list";

    }
}
