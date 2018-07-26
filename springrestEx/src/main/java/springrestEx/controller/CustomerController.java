package springrestEx.controller;

import java.util.List;

import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import springrestEx.exceptionHandler.CustomerNotFoundException;
import springrestEx.exceptionHandler.CustomerNotSavedException;
import springrestEx.model.Customer;
import springrestEx.service.CustomerService;


@RestController
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	
	 
     @RequestMapping(value = "/customers/", method = RequestMethod.GET,headers="Accept=application/json")
     public @ResponseBody List<Customer> getListCustomer() {
    	 
    	 List<Customer> customers = customerService.getListCustomer();
    	 
    	 return customers;
     }
     
 
     
     @RequestMapping(value = "/add/", method = RequestMethod.POST)
     public @ResponseBody Customer add(@RequestBody Customer customer) {
    	try {
    	 customerService.addOrUpdate(customer);	 
    	 }catch(CustomerNotSavedException ex) {
    	     throw new CustomerNotSavedException(ex.toString());
    	}    
        
    	return customer;
      }
     
     
     @RequestMapping(value = "/customer/{id}", method = RequestMethod.GET)
     public @ResponseBody Customer getCustomer(@PathVariable("id") int id) throws Exception {
    	 
    	 Customer customer;
    	 try {
    		 customer =customerService.findCustomer(id);
    	   }catch(CustomerNotFoundException ex) {
    	     throw new CustomerNotFoundException(ex.toString());
    	   }    
    	 return customer;
      }
     
     
     
     @RequestMapping(value = "/update/{id}", method = RequestMethod.PUT)
     public @ResponseBody Customer update(@PathVariable("id") int id, @RequestBody Customer customer) throws Exception {
    	
    	 try {
    		 
    	      customer.setCustomerId(id);
    	      customerService.addOrUpdate(customer);	
    	     
    	 }catch(CustomerNotSavedException ex) {
   	          throw new CustomerNotSavedException(ex.toString()); 
    	 }
       return customer;
      }
     
     
     @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
     public @ResponseBody Customer delete(@PathVariable("id") int id) throws Exception {
    	 
    	Customer customer;
    	try{
    		customer = customerService.findCustomer(id);
    		customerService.deleteCustomer(id);	
    	 }catch(CustomerNotFoundException ex) {
   	        throw new CustomerNotFoundException(ex.toString());
   	   }    
       return customer;
     }
     
}

