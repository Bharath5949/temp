package BumperCars;

import java.util.List;

public class Invoice {
		
		private String invoiceCode;
		private Person owner;
		private Customer customer;
		private List<Product> products;
		
		public Invoice(String invoiceCode, Person owner, Customer customer, List<Product> products) {
			super();
			this.invoiceCode = invoiceCode;
			this.owner = owner;
			this.customer = customer;
			this.products = products;
		}

		/**
		 * @return the invoiceCode
		 */
		public String getInvoiceCode() {
			return invoiceCode;
		}

		/**
		 * @return the ownerCode
		 */
		public Person getOwner() {
			return owner;
		}

		/**
		 * @return the customerCode
		 */
		public Customer getCustomerCode() {
			return customer;
		}

		/**
		 * @return the products
		 */
		public List<Product> getProducts() {
			return products;
		}
		
		public double productsSubtotal() {
			double subtotal = 0.0;   
				for(int i = 0; i < products.size(); i++) {
				 subtotal += products.get(i).getSubtotal(); 
		}
				return subtotal; 
		}
		public double getTotalDiscount() {
			double totalDiscount = 0.0;   
			for(int i = 0; i < products.size(); i++) {
			 totalDiscount += products.get(i).getDiscountAmount(); 
	}
			return totalDiscount; 
	}
		public double getTotalTaxes() {
			
			double totalTaxes = 0.0;   
			for(int i = 0; i < products.size(); i++) {
				totalTaxes += products.get(i).getTotalTax(); 
	}
			return totalTaxes; 
	}
		public double getTotal() {
			double total = 0.0;   
			for(int i = 0; i < products.size(); i++) {
				total += products.get(i).getTotal(); 
	}
			return total; 
	}
		public static String executiveReport() {
			String report = null; 
			report = " Executive Summary Report: " + "\n\n" + "Subtotal\t\tDiscounts\t\tFees\t\tTaxes\t\tTotal";
			
			return report; 
		}
		
		@Override
		public String toString() {
			return " Invoice Details: \n" + "=+".repeat(110)  + " \n Invoice: "  + this.getInvoiceCode() + "\n" + "-".repeat(110) + "\n Owner: " + this.owner.getFirstName() + " "
					+ this.owner.getLastName() + "\n" + this.owner.getEmails() + "\n" + this.owner.getAdress() + "\n" + "Customer: " 
					+ this.customer.getCustomerName() + " (" + this.customer.getCustomerType() + ")\n" + this.customer.getAdress() + "\n Products" 
					+ "Code" + "\t\tDescription" + "\nSubtotal \t\tDiscount\t\tTaxes\t\tTotal" + "\n" + "-".repeat(110) + "\n" + "-".repeat(110) + "\n" + this.products
					+ "\nItem Totals " + this.getTotal() + "\t\t" + this.getTotalDiscount() + "\t\t" + this.getTotalTaxes() + "\t\t" + this.productsSubtotal();
		}
}
