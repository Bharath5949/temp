package BumperCars;

public class Towing extends Product {
	
	private double costPerMile;
	private int milesTowed; 
	private double taxRate; 
	private double fees; 
	private double discounts; 

	public Towing(String productCode, String productLabel, double costPerMile) {
		super(productCode, productLabel);
		this.costPerMile = costPerMile;
	}
	
	public Towing(Towing r, int milesTowed, double taxRate, double fees, double discounts) {
		this(r.getProductCode(), r.getProductLabel(), r.getCostPerMile());	
		this.milesTowed = milesTowed; 
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
	 * @return the costPerMile
	 */
	public double getCostPerMile() {
		return costPerMile;
	} 
	
	public double getDiscountAmount() {
		return this.discounts * this.getTotal(); 
	}
	
	public double getTotalTax() {
		return (this.getTotal() - this.getDiscountAmount()) * this.taxRate; 
	}
	
	public double getTotal(){
		return (this.costPerMile * this.milesTowed); 
	}
	
	public double getSubtotal() {
		return this.getTotalTax() + this.getTotal() - this.getDiscountAmount(); 
	}
	
	
	
	public String toString() {
		return  "\n" + this.getProductCode() + " " + this.getProductLabel() + " " + "(" + 
	this.milesTowed + " miles @ $" + this.costPerMile + "/mile"
	+ "\n" + this.getTotal() + "\t" + "-" + this.getDiscountAmount() + "\t" + this.getTotalTax() + "\t" + this.getSubtotal();
	}
}
