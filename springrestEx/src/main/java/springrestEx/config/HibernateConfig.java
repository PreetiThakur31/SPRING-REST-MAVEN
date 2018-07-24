package springrestEx.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * /* jdbc.driverClassName=oracle.jdbc.driver.OracleDriver
			jdbc.dialect=org.hibernate.dialect.Oracle10gDialect
			jdbc.databaseurl=jdbc:oracle:thin:@localhost:1521:xe
			jdbc.username=system
			jdbc.password=manager
 */

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@ComponentScan(basePackages ="springrestEx.config" )
public class HibernateConfig {
	
	@Bean
	public LocalSessionFactoryBean sessionFactoryBean() {
		
		LocalSessionFactoryBean sessionFactoryBean = new LocalSessionFactoryBean();
		sessionFactoryBean.setDataSource(dataSource());
		sessionFactoryBean.setPackagesToScan( new String[] {"springrestEx.model"});
		sessionFactoryBean.setHibernateProperties(hibernateProperties());
		return sessionFactoryBean;
	}
	
	@Bean
	public DataSource dataSource() {
		
		DriverManagerDataSource ds = new DriverManagerDataSource();
		ds.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		ds.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
		ds.setUsername("system");
		ds.setPassword("manager");
		
		return ds;
	}
	
	  private Properties hibernateProperties() {
		  
		  Properties properties = new Properties();
		  properties.put("hibernate.dialect", "org.hibernate.dialect.Oracle10gDialect");
		  properties.put("hibernate.show_sql", "true");
		  properties.put("hibernate.format_sql", "false");
		  
		  return properties;
	  }
     
	  
	  @Bean
	  @Autowired
	  public HibernateTransactionManager transactionManager(SessionFactory sf) {
		  
		  HibernateTransactionManager tx = new HibernateTransactionManager();
		  tx.setSessionFactory(sf);
		  
		  return tx;
	  }
	

}
