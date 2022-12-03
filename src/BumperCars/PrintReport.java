package BumperCars;

import java.io.FileNotFoundException;
import java.util.List;

public class PrintReport {
	
	public static String printReport() throws FileNotFoundException {
		
		 List<Person> persons = ParseFiles.parsePersonsFile(); 
		 List<Customer> customers = ParseFiles.parseCustomersFile();
		 List<Product> products = ParseFiles.parseProductsFile();
		 List<Invoice> invoices = ParseFiles.parseInvoiceFile();  
		 double discounts; 
		 double fees; 
		 double taxes;  
		 
		 for(int i = 0; i < invoices.size(); i++) {
		 StringBuilder sb = new StringBuilder(); 
		 //sb.append(invoices.get(i).getInvoiceCode()); 
		 //sb.append("\n" + ((Invoice) invoices.get(i)).getCustomerCode());
		 //sb.append(((Invoice) invoices.get(i)).getProducts().toString());
		 sb.append(invoices.get(i).toString()); 
		 
		 System.out.println(sb);
		 }
			return null;
	}
}

