package springrestEx.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import springrestEx.model.Customer;
import springrestEx.service.CustomerService;
import springrestEx.service.CustomerServiceImpl;


@RestController
public class CustomerController {
	
	{System.out.println("controller");}
	
	@Autowired
	private CustomerService customerService;
	
	 
	 
	
     @RequestMapping(value = "/customers/", method = RequestMethod.GET,headers="Accept=application/json")
     public @ResponseBody List<Customer> getListCustomer() {
    	 
    	 List<Customer> customers = customerService.getListCustomer();
    	 
    	 return customers;
     }
     
 
     @RequestMapping(value = "/add/", method = RequestMethod.POST)
     public @ResponseBody Customer add(@RequestBody Customer customer) {
    	
    	 customerService.addOrUpdate(customer);	 
        	  
         return customer;
      }
     
     @RequestMapping(value = "/update/{id}", method = RequestMethod.PUT)
     public @ResponseBody Customer update(@PathVariable("id") int id, @RequestBody Customer customer) {
    	customer.setCustomerId(id);
    	customerService.addOrUpdate(customer);	 
        	  
         return customer;
      }
     
     @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
     public @ResponseBody Customer delete(@PathVariable("id") int id) {
    	Customer customer = customerService.findCustomer(id);
    	customerService.deleteCustomer(id);	 
        	  
         return customer;
      }
     
}

