package com.amarinperez.addressbook;

import java.util.ArrayList;
import java.util.Collection;

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

	public int getMaleCount() {
		int total = 0;
		for (Person person : persons) {
			if (person.getGender() == Gender.MALE) {
				total++;
			}
		}

		return total;
	}

}
