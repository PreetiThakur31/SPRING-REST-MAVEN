package springrestEx.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CUSTOMER_DATA")
public class Customer {
	
	@Id
	@Column (name ="CUSTOMER_ID")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int customerId;
	
	@Column (name ="CUSTOMER_NAME")
	private String customerName;
	
	@Column (name ="ACCOUNT_NO")
	private int accountNo;
	
	@Column (name ="ACCOUNT_BALANCE")
	private int accountBalance;
	
	
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public int getAccountNo() {
		return accountNo;
	}
	public void setAccountNo(int accountNo) {
		this.accountNo = accountNo;
	}
	public int getAccountBalance() {
		return accountBalance;
	}
	public void setAccountBalance(int accountBalance) {
		this.accountBalance = accountBalance;
	}
	
	

}
