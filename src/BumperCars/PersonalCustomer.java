package BumperCars;

import java.util.List;

public class PersonalCustomer extends Customer {

	public PersonalCustomer(String customerCode, String customerName, String contactCode, Address address) {
		super(customerCode, customerName, contactCode, address);
		// TODO Auto-generated constructor stub
	}
	
	public double getTaxes() {
		return .08; 
	}
	
	public double getProcessingFee() {
		return 0.0; 
	}
	
	public String getCustomerType() {
		return "Personal Customer"; 
	}
	
	} 

