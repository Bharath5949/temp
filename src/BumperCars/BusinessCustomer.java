package BumperCars;

import java.util.List;


public class BusinessCustomer extends Customer{

	public BusinessCustomer(String customerCode, String customerName, String contactCode, Address address) {
		super(customerCode, customerName, contactCode, address);
	}
	
	public double getTaxes() {
		return .0425; 
	}
	
	public double getProcessingFee() {
		return 75.50; 
	}
	
	public String getCustomerType() {
		return "Business Customer"; 
	}

}
