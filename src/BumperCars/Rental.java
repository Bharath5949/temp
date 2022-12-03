package BumperCars;

import java.io.FileNotFoundException;
import java.util.List;

public class Rental extends Product {
	
	private double dailyCost; 
	private double deposit;
	private double cleaningFee; 
	private int daysRented; 
	private double taxRate; 
	private double fees; 
	private double discounts; 

	public Rental(String productCode, String productLabel, double dailyCost, double deposit,
			double cleaningFee) {
		super(productCode, productLabel);
		this.dailyCost = dailyCost;
		this.deposit = deposit;
		this.cleaningFee = cleaningFee;
	}
	
	public Rental(Rental r, int daysRented, double taxRate, double fees, double discounts) {
		this(r.getProductCode(), r.getProductLabel(), r.getDailyCost(), r.getDeposit(), r.getCleaningFee());	
		this.daysRented = daysRented; 
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
		return getTaxRate();
	}

	public int getDaysRented() {
		return daysRented; 
	}
	/**
	 * @return the dailyCost
	 */
	public double getDailyCost() {
		return dailyCost;
	}

	/**
	 * @return the deposit
	 */
	public double getDeposit() {
		return deposit;
	}

	/**
	 * @return the cleaningFee
	 */
	public double getCleaningFee() {
		return cleaningFee;
	}
	public double getDiscountAmount() {
		return this.getTotal() * this.discounts;
	}
		
	public double getTotal() {
		return this.cleaningFee + (this.dailyCost * this.daysRented) - this.deposit;
	}
	public double getSubtotal() {
		return (this.getTotal() * this.taxRate) + this.getTotal() - this.getDiscountAmount(); 
	}
	public double getTotalTax() {
		return this.getTotal() * this.taxRate; 
	}
	/**
	 * @param daysRented the daysRented to set
	 */
	public void setDaysRented(int daysRented) {
		this.daysRented = daysRented;
	}
	
	public String toString() {
		
		return   "\n" + this.getProductCode() + " " + this.getProductLabel() + " (" + this.daysRented + " days @ " + this.dailyCost + ")" + " "
				+ "\n"
				+ "$ " + this.getTotal() + "\t" +  this.getDiscountAmount() + "\t" + this.getTotalTax() + "\t" +this.getSubtotal()  + "\n"
				+ "+ " + this.cleaningFee + " cleaning fee, -" + this.deposit + " deposit refund";
	}
	
	
}
