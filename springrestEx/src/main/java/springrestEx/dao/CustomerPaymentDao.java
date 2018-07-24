package springrestEx.dao;

import java.util.List;

import springrestEx.model.Customer;

public interface CustomerPaymentDao {
	
	
	public List<Customer> getListCustomer();
	 
	
    public void addOrUpdate(Customer customer);
		
	public void deleteCustomer(int id);
	
	public Customer findCustomer(int id);

}
