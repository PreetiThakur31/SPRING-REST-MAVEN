package springrestEx.dao;

import java.util.List;

import javax.sql.DataSource;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import springrestEx.dao.CustomerPaymentDao;
import springrestEx.exceptionHandler.CustomerNotFoundException;
import springrestEx.exceptionHandler.CustomerNotSavedException;
import springrestEx.model.Customer;

@Repository
public class CustomerPaymentDaoImpl implements CustomerPaymentDao {
	
	
	
	@Autowired
    private SessionFactory sessionFactory;
	

	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}


	@SuppressWarnings("unchecked")
	public List<Customer> getListCustomer() {
		Criteria  criteria = getSession().createCriteria(Customer.class);
		return (List<Customer>) criteria.list();
	}



	public void addOrUpdate(Customer customer) {
		try {
		getSession().saveOrUpdate(customer);
		}catch(Exception e) {
			throw new CustomerNotSavedException(e+" Check the datatypes of provided data.");
		}
	}



	public void deleteCustomer(int id) {
		Customer customer = (Customer) getSession().get(Customer.class,id);
		getSession().delete(customer);
		
	}



	public Customer findCustomer(int id) {
		Customer customer = (Customer) getSession().get(Customer.class, id);
		if(customer !=null)
		return customer;
		else
	    throw new CustomerNotFoundException("No data available with this id="+id);
	}

}
