package ee.learning.controller;

import ee.learning.dao.CustomerDao;
import ee.learning.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Random;

@RestController
public class CustomerController {

    @Autowired
    private CustomerDao customerDao;

    @PostMapping("/customers")
    public String greeting(@RequestParam String name,
                           @RequestParam Integer age) {
        System.out.println("Inserting new customer " + name + " " + age);
        customerDao.insert(new Customer(new Random().nextLong(), name, age));

        return "Done\n";
    }

    @GetMapping("/customers")
    public List<Customer> greeting() {
        System.out.println("Queering all customers");
        return customerDao.findAll();
    }
}
