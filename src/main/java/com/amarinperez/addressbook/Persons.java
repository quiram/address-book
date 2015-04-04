package com.amarinperez.addressbook;

import static java.lang.String.format;

import java.time.Period;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;

public class Persons {
	private Collection<Person> persons;

	public Persons(Collection<String> lines) {
		persons = new ArrayList<Person>();

		for (String line : lines) {
			persons.add(new Person(line));
		}
	}

	public int getCount() {
		return persons.size();
	}

	public long getMaleCount() {
		return persons.stream().filter(p -> p.getGender() == Gender.MALE).count();
	}

	public Person getOldestPerson() {
		return persons.stream().min(Comparator.comparing(p -> p.getDateOfBirth())).orElse(null);
	}

	public Person getPersonByName(String name) {
		return persons.stream().filter(p -> p.getName().startsWith(name)).findFirst().orElse(null);
	}

	public Period getAgeDifferenceBetween(String name1, String name2) {
		Person person1 = getPersonByName(name1);
		
		if(person1 == null){
			throwExceptionUponNameNotFound(name1);
		}
		
		Person person2 = getPersonByName(name2);
		
		if(person2 == null) {
			throwExceptionUponNameNotFound(name2);
		}
		
		return person1.getDateOfBirth().until(person2.getDateOfBirth());
	}

	private void throwExceptionUponNameNotFound(String name) {
		throw new IllegalArgumentException(format("Person with name '%s' not found.", name));
	}
}
