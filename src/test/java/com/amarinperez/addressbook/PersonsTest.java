package com.amarinperez.addressbook;

import static org.junit.Assert.assertEquals;

import java.util.LinkedList;
import java.util.List;

import org.junit.Test;

public class PersonsTest {

	@Test
	public void zeroCountOnEmptyPersons() {
		Persons persons = getEmptyPersonsCollection();
		assertEquals(0, persons.getCount());
	}

	@Test
	public void oneCountOnOnePerson() {
		Persons persons = getPersonsCollectionWithOneOf(Gender.MALE);
		assertEquals(1, persons.getCount());
	}

	@Test
	public void getMaleCountWithOneMale() {
		Persons persons = getPersonsCollectionWithOneOf(Gender.MALE);
		assertEquals(1, persons.getMaleCount());
	}

	@Test
	public void getMaleCountWithOneFemale() {
		Persons persons = getPersonsCollectionWithOneOf(Gender.FEMALE);
		assertEquals(0, persons.getMaleCount());
	}

	private Persons getEmptyPersonsCollection() {
		List<String> lines = new LinkedList<String>();
		Persons persons = new Persons(lines);
		return persons;
	}

	private Persons getPersonsCollectionWithOneOf(Gender gender){
		List<String> lines = new LinkedList<String>();
	
		AddressBookLineBuilder builder = new AddressBookLineBuilder();
		builder.setGender(gender);
		lines.add(builder.build());
		
		Persons persons = new Persons(lines);
		return persons;
	}
}
