package com.amarinperez.addressbook;


/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		PersonsLoader personsLoader = new PersonsLoader("/AddressBook");
		Persons persons = personsLoader.getPersons();
		
		System.out.println("GUMTREE CODING CHALLENGE");
		System.out.println();
		System.out.println("1. How many males are in the address book?");

		System.out.println(persons.getMaleCount());
	}

}
