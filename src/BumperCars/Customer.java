package BumperCars;

import java.util.List;

public abstract class Customer {

	private String customerCode;
	private String customerName; 
	private String contactCode; 
	private Address address;
	
	
	public Customer(String customerCode, String customerName, String contactCode,
			Address address) {
		super();
		this.customerCode = customerCode;
		this.customerName = customerName;
		this.contactCode = contactCode;
		this.address = address;
	} 
	
	/**
	 * @return the customerCode
	 */
	public String getCustomerCode() {
		return customerCode;
	}
	/**
	 * @return the customerName
	 */
	public String getCustomerName() {
		return customerName;
	}

	/**
	 * @return the contactCode
	 */
	public String getContactCode() {
		return contactCode;
	}

	/**
	 * @return the address
	 */
	public Address getAddress() {
		return address;
	}
	
	public double getTaxes() {
		return getTaxes(); 
	}
	
	public double getProcessingFee() {
		return getProcessingFee();
	}
	
	public String getAdress() {
		return this.getAddress().getStreet() +  this.getAddress().getCity() + this.getAddress().getState()+ this.getAddress().getCountry() + this.getAddress().getZip();
	}
	public String getCustomerType() {
		return getCustomerType(); 
	}
	
	public static void printNames(List<Customer> customers) {
		for (int i = 0; i < customers.size(); i++) {

			System.out.println(customers.get(i).getCustomerName());
		}
	}
	
}
