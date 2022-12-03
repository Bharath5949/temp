package BumperCars;

public class Concession extends Product {

	private double unitCost;
	private int quantity; 
	private Repair repair; 
	private double taxRate; 
	private double fees;
	private double discounts; 
	
	public Concession(String productCode, String productLabel, double unitCost) {
		super(productCode, productLabel);
		this.unitCost = unitCost;
	}
	
	public Concession(Concession r, int quantity, double taxRate, double fees) {
		this(r.getProductCode(), r.getProductLabel(), r.getUnitCost()); 
		this.quantity = quantity; 
		this.taxRate = taxRate; 
		this.fees = fees; 
	}
	
	public Concession(Concession r, int quantity, Repair repair, double taxRate, double fees, double discounts) {
		this(r.getProductCode(), r.getProductLabel(), r.getUnitCost()); 
		this.quantity = quantity;
		this.repair = repair;
		this.taxRate = taxRate; 
		this.fees = fees;
		this.discounts = discounts; 
	}
	
	public double getDiscoutns() {
		return discounts; 
	}
	public double getTaxRate() {
		return taxRate; 
	}
	public double getFees() {
		return fees; 
	}
	/**
	 * @return the unitCost
	 */
	public double getUnitCost() {
		return unitCost;
	} 
	public double getTotal() {
		return this.unitCost * this.quantity; 
	}
	public double getDiscountAmount() {
		return this.getTotal() * this.discounts; 
	}
	public double getTotalTax() {
		return (this.getTotal() - this.getDiscountAmount()) * this.taxRate; 
	}
	public double getSubtotal() {
		return this.getTotal() + this.getTotalTax() - this.getDiscountAmount();
	}
	
	@Override
	public String toString() {
		return "\n" + this.getProductCode() + this.getProductLabel() + "(" +this.quantity + " units @ $" + this.unitCost 
				+ "/unit" + ")" + "\n" + this.getTotal() + "\t" +"-" + this.getDiscountAmount() + "\t" + this.getTotalTax() + "\t" + this.getSubtotal() ;
	}

}
