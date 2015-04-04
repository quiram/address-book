package com.amarinperez.addressbook;


/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		PersonsLoader personsLoader = new PersonsLoader("/AddressBook");
		Persons persons = personsLoader.getPersons();
		
		printLine("GUMTREE CODING CHALLENGE");
		printLine();
		printLine("1. How many males are in the address book?");
		printLine(persons.getMaleCount());
		
		printLine();
		printLine("2. Who is the oldest person in the address book?");
		printLine(persons.getOldestPerson().getName());
		
		printLine();
		printLine("3. How many days older is Bill than Paul?");
		printLine(persons.getAgeDifferenceBetween("Bill", "Paul"));
		
		printLine();
		printLine();
		printLine("That will be all :-)");
	}
	
	private static void printLine()
	{
		printLine("");
	}
	
	private static void printLine(long l)
	{
		printLine(Long.toString(l));
	}

	private static void printLine(String line)
	{
		System.out.println(line);
	}
}
