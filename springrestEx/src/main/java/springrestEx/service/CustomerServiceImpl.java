package springrestEx.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import springrestEx.dao.CustomerPaymentDao;
import springrestEx.dao.CustomerPaymentDaoImpl;
import springrestEx.exceptionHandler.CustomerNotFoundException;
import springrestEx.model.Customer;
import springrestEx.service.CustomerService;

@Service("customerService")
@Transactional
public class CustomerServiceImpl implements CustomerService {

	
	CustomerPaymentDao customerPaymentDao;
	
	
	@Autowired
	public void setCustomerPaymentDao(CustomerPaymentDao customerPaymentDao) {
		this.customerPaymentDao = customerPaymentDao;
	}

	public List<Customer> getListCustomer() {
		
		return customerPaymentDao.getListCustomer();
	}
	
	
    public void addOrUpdate(Customer customer) {
		
		customerPaymentDao.addOrUpdate(customer);
		
	}

	public void deleteCustomer(int id) {
		
		customerPaymentDao.deleteCustomer(id);
	}

	public Customer findCustomer(int id) {
		
		return customerPaymentDao.findCustomer(id);
	}

	
	
	

}
