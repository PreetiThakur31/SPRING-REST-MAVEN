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
		getSession().saveOrUpdate(customer);
		
	}



	public void deleteCustomer(int id) {
		Customer customer = (Customer) getSession().get(Customer.class,id);
		getSession().delete(customer);
		
	}



	public Customer findCustomer(int id) {
		
		return (Customer) getSession().get(Customer.class, id);
	}

}
