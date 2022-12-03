package BumperCars;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class ParseFiles {

	public static List<Customer> parseCustomersFile() throws FileNotFoundException {

		// Creating my list of persons.
		List<Customer> customers = new ArrayList<Customer>();

		// Opens up the file.
		File f = new File("data/Customers");
		try (Scanner s = new Scanner(f)) {

			// Skips the first line.
			s.nextLine();
			while (s.hasNext()) {

				String line = s.nextLine();
				// Checks if the line is empty.
				if (!line.trim().isEmpty()) {

					Customer p = null;
					Address a = null;
					// Splits the line by semicolon or comma.
					String tokens[] = line.split("(,|;)");

					// Sets the data to each thing.

					String customerCode = tokens[0];
					String customerType = tokens[1];
					String customerName = tokens[2];
					String contactCode = tokens[3];
					String street = tokens[4];
					String city = tokens[5];
					String state = tokens[6];
					String zip = tokens[7];
					String country = tokens[8];

					a = new Address(street, city, state, zip, country);
					// Creates address object.
					if (customerType.equalsIgnoreCase("B")) {
						p = new BusinessCustomer(customerCode, customerName, contactCode, a);
						customers.add(p);
					} else {
						p = new PersonalCustomer(customerCode, customerName, contactCode, a);
						customers.add(p);
					}
				}

			}
		}
		return customers;
	}

	public static List<Person> parsePersonsFile() throws FileNotFoundException {

		// Creating my list of persons.
		List<Person> persons = new ArrayList<Person>();

		// Opens up the file.
		File f = new File("data/Persons");
		try (Scanner s = new Scanner(f)) {

			// Skips the first line.
			s.nextLine();
			while (s.hasNext()) {

				String line = s.nextLine();
				// Checks if the line is empty.
				if (!line.trim().isEmpty()) {

					Person p = null;
					Address a = null;
					// Splits the line by semicolon or comma.
					String tokens[] = line.split("(,|;)");
					int numEmails = 0;

					/**
					 * There are 8 instances of data that get parsed before the emails, so number of
					 * emails equals the length of the token string minus 8.
					 */

					numEmails = tokens.length - 8;

					// Sets the data to each thing.

					String code = tokens[0];
					String lastName = tokens[1];
					String firstName = tokens[2];
					String street = tokens[3];
					String city = tokens[4];
					String state = tokens[5];
					String zip = tokens[6];
					String country = tokens[7];

					List<String> emails = new ArrayList<>();
					// Creates a list named emails.
					for (int i = 1; i <= numEmails; i++) {

						String email = tokens[i + 7];
						// Each token past token i should be a email.

						emails.add(email);
						// Adds the email to the list.
					}

					a = new Address(street, city, state, zip, country);
					// Creates address object.
					p = new Person(code, firstName, lastName, a, emails);
					// Creates Person object with emails and address.
					persons.add(p);
				}

			}
		}
		return persons;

	}

	public static ArrayList<Product> parseProductsFile() throws FileNotFoundException {

		ArrayList<Product> products = new ArrayList<>();
		Scanner s;
		try {
			s = new Scanner(new File("data/Products"));
		} catch (FileNotFoundException e) {
			System.err.println("Error: Persons.dat file not found.");
			e.printStackTrace();
			return null;
		}
		s.nextLine(); // First line is # of records, which I don't care about for this.

		while (s.hasNextLine()) {

			String[] tokens = s.nextLine().split(",|;");

			String productCode = tokens[0];
			String productType = tokens[1];
			String productLabel = tokens[2];

			if (productType.equalsIgnoreCase("R")) {
				Rental product = new Rental(productCode, productLabel, Double.parseDouble(tokens[3]),
						Double.parseDouble(tokens[4]), Double.parseDouble(tokens[5]));
				products.add(product);
			} else if (productType.equalsIgnoreCase("T")) {
				Towing product = new Towing(productCode, productLabel, Double.parseDouble(tokens[3]));
				products.add(product);

			} else if (productType.equalsIgnoreCase("F")) {
				Repair product = new Repair(productCode, productLabel, Double.parseDouble(tokens[3]),
						Double.parseDouble(tokens[4]));
				products.add(product);
			} else if (productType.equalsIgnoreCase("C")) {
				Concession product = new Concession(productCode, productLabel, Double.parseDouble(tokens[3]));
				products.add(product);
			}

		}

		return products;
	}

	public static ArrayList<Invoice> parseInvoiceFile() throws FileNotFoundException {

		ArrayList<Invoice> invoices = new ArrayList<>();
		List<Product> products = parseProductsFile();
		List<Customer> customers = parseCustomersFile();
		List<Person> persons = parsePersonsFile();

		// Opens up the file.
		File f = new File("data/Invoices");

		try (Scanner s = new Scanner(f)) {

			// Skips the first line.
			s.nextLine();
			while (s.hasNext()) {
				int daysRented = 0;
				int hoursWorked = 0;
				int milesTowed = 0;
				int quantity = 0;
				double taxRate = 0.0; 
				double fees = 0.0; 
				double discountRate = 0.0; 
				double towingDiscountRate = 0.0;
				double concessionDiscount = 0.0; 
				List<Product> invoiceProducts = new ArrayList<Product>();

				String line = s.nextLine();
				// Checks if the line is empty.
				if (!line.trim().isEmpty()) {

					Invoice p = null;
					// Splits the line by semicolon or comma.
					String tokens[] = line.split("(;|,)");
					int numProducts = 0;

					/**
					 * There are 8 instances of data that get parsed before the emails, so number of
					 * emails equals the length of the token string minus 8.
					 */

					// Sets the data to each thing.
					Person a = null;
					Customer c = null;
					String invoiceCode = tokens[0];
					String ownerCode = tokens[1];
					String customerCode = tokens[2];
					for (int n = 0; n < persons.size(); n++) {

						if (ownerCode.equals(persons.get(n).getCode())) {
							a = new Person(persons.get(n).getCode(), persons.get(n).getFirstName(),
									persons.get(n).getLastName(), persons.get(n).getAddress(),
									persons.get(n).getEmails());
						}
					}
					
					for (int m = 0; m < customers.size(); m++) {
						if (customerCode.equals(customers.get(m).getCustomerCode())
								&& customers.get(m) instanceof PersonalCustomer) {

							c = new PersonalCustomer(customers.get(m).getCustomerCode(),
									customers.get(m).getCustomerName(), customers.get(m).getContactCode(),
									customers.get(m).getAddress());
							if(persons.get(m).getEmails().size() >= 2) {
								discountRate = .05; 
							}
							taxRate = 0.08; 
							fees = 0.0; 

						} else if (customerCode.equals(customers.get(m).getCustomerCode())) {
							c = new BusinessCustomer(customers.get(m).getCustomerCode(),
									customers.get(m).getCustomerName(), customers.get(m).getContactCode(),
									customers.get(m).getAddress());
							taxRate = 0.0425; 
							fees = 75.5; 
							}
						

					}
					
					// Creates a list named emails.
					for (int i = 3; i < tokens.length; i++) {
						String productToken[] = tokens[i].split(":");
						for (int j = 0; j < products.size(); j++) {
							if (productToken[0].equals(products.get(j).getProductCode())) {

								if (products.get(j) instanceof Repair) {
									hoursWorked = Integer.parseInt(productToken[1]);
									Repair repair = new Repair((Repair) products.get(j), hoursWorked, taxRate, fees, discountRate);
									invoiceProducts.add(repair);
									towingDiscountRate = 1.0; 

								} else if (products.get(j) instanceof Towing) {
									
									
									milesTowed = Integer.parseInt(productToken[1]);
									if(milesTowed < 10) {
										towingDiscountRate = 0.0; 
									}
									Towing towing = new Towing((Towing) products.get(j), milesTowed, taxRate, fees, towingDiscountRate);
									invoiceProducts.add(towing);

								} else if (products.get(j) instanceof Concession) {
									quantity = Integer.parseInt(productToken[1]);
									Repair repair = null;
									if (productToken.length == 3) {
										for (int n = 0; n < productToken.length; n++) {
											if (products.get(n) instanceof Repair) {
												repair = (Repair) products.get(n);
												concessionDiscount = .10; 
												break;
											}
										}
									}
									Concession concession = new Concession((Concession) products.get(j), quantity,
											repair , taxRate, fees, concessionDiscount);
									invoiceProducts.add(concession);

								} else {
									
									daysRented = Integer.parseInt(productToken[1]);
									Rental rental = new Rental((Rental) products.get(j), daysRented, taxRate, fees, discountRate);
									rental.setDaysRented(daysRented);
									invoiceProducts.add(rental);
								}
								break;
							}
						}
					}
					p = new Invoice(invoiceCode, a, c, invoiceProducts);
					// Creates Person object with emails and address.
					invoices.add(p);
				}
			}
		}
		return invoices;
	}
}
