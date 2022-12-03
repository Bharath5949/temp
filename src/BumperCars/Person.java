package BumperCars;

import java.util.List;

/**
 * Author: Maclain Beach This class is the object class of person.
 * 
 */

public class Person implements Comparable<Person> {

	private String code;
	private String firstName;
	private String lastName;
	private List<String> emails;
	private Address address;

	/**
	 * 
	 * @param id
	 * @param firstName
	 * @param lastName
	 * @param address
	 * @param emails    Takes these parameters and constructs and instance of a
	 *                  person.
	 * 
	 */

	public Person(String code, String firstName, String lastName, Address address, List<String> emails) {
		super();
		this.code = code;
		this.firstName = firstName;
		this.lastName = lastName;
		this.emails = emails;
		this.address = address;

	}

	public String getCode() {
		return code;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public List<String> getEmails() {
		return emails;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	/**
	 * 
	 * @param person Once the list of persons is pasted in, it prints the last name,
	 *               first name, and emails of the person.
	 * 
	 */
	public static void printNames(List<Person> persons) {
		for (int i = 0; i < persons.size(); i++) {

			System.out.println(persons.get(i).getLastName() + " " + persons.get(i).getFirstName() + " "
					+ persons.get(i).getEmails());
		}
	}
	public String getAdress() {
		return this.getAddress().getStreet() +  this.getAddress().getCity() + this.getAddress().getState()+ this.getAddress().getCountry() + this.getAddress().getZip();
	}
	

	/**
	 * Using a java provided comparator. This method will look at the last name and
	 * compare it to the other last names and return persons in alphabetical order
	 * by last name.
	 * 
	 */
	@Override
	public int compareTo(Person o) {

		return this.getLastName().compareTo((o).getLastName());
	}
}

