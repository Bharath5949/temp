package BumperCars;

import java.util.List;

public abstract class Product {
	
	private String productCode; 
	private String productLabel;
	
	public Product(String productCode, String productLabel) {
		super();
		this.productCode = productCode;
		this.productLabel = productLabel;
	} 
	/**
	 * @return the productCode
	 */
	public String getProductCode() {
		return productCode;
	}
	/**
	 * @return the productLabel
	 */
	public String getProductLabel() {
		return productLabel;
	}
	public double getTotal() {
		return getTotal();
	}
	public double getDiscountAmount() {
		return getDiscountAmount();
	}
	public double getTaxRate() {
		return getTaxRate();
	}
	
	public double getTotalTax() {
		return this.getTotalTax();
	}
	
	public double getSubtotal() {
		return getSubtotal(); 
	}
	public static void printNames(List<Product> product) {
		for (int i = 0; i < product.size(); i++) {

			System.out.println(product.get(i).getProductLabel() + " " + product.get(i).getProductCode());
		}
	}
}