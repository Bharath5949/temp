package BumperCars;

public class Repair extends Product {
	
	private double partsCost; 
	private double hourlyRate;
	private int hoursWorked; 
	private double taxRate; 
	private double fees; 
	private double discounts; 

	public Repair(String productCode, String productLabel, double partsCost, double hourlyRate) {
		super(productCode, productLabel);
		this.partsCost = partsCost; 
		this.hourlyRate = hourlyRate; 
	}
	
	public Repair(Repair r, int hoursWorked, double taxRate, double fees, double discounts) {
		this(r.getProductCode(), r.getProductLabel(), r.getPartsCost(), r.getHourlyRate());	
		this.hoursWorked = hoursWorked; 
		this.taxRate = taxRate; 
		this.fees = fees; 
		this.discounts = discounts;
	}
	
	public double getDiscoutns() {
		return discounts; 
	}

	public double getFees() {
		return fees;
	}
	
	public double getTaxRate() {
		return taxRate; 
	}
	/**
	 * @return the partsCost
	 */
	public double getPartsCost() {
		return partsCost;
	}

	/**
	 * @return the hourlyRate
	 */
	public double getHourlyRate() {
		return hourlyRate;
	}
	
	public double getTotal() {
		return this.hourlyRate * this.hoursWorked + this.partsCost;
	}
	public double getTotalTax() {
		return this.getTotal() * this.taxRate; 
	}
	public double getSubtotal() {
		return this.getTotalTax() + this.getTotal() - this.getDiscountAmount(); 
	}
	public double getDiscountAmount() {
		return this.discounts * this.getTotal(); 
	}

	public String toString(){
		return "\n" + this.getProductCode() + " " + this.getProductLabel() + " (" +  this.hoursWorked + " hours of labor @ $" + this.hourlyRate
				+ "/hour) \n" + this.getTotal() + "\t" + this.getDiscountAmount() + "\t" + this.getTotalTax() + "\t" + this.getSubtotal()
				+ "\n (+ $" + this.partsCost + " for parts)";
	}
}
