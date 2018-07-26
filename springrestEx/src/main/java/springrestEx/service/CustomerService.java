package springrestEx.service;

import java.util.List;
import springrestEx.model.Customer;


public interface CustomerService {
	
	public List<Customer> getListCustomer();
	
	public void addOrUpdate(Customer customer);
	
	public void deleteCustomer(int id);
	
	public Customer findCustomer(int id);

	
}
