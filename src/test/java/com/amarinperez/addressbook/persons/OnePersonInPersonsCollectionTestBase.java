package com.amarinperez.addressbook.persons;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.LinkedList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.amarinperez.addressbook.AddressBookLineBuilder;
import com.amarinperez.addressbook.Gender;
import com.amarinperez.addressbook.Persons;

abstract public class OnePersonInPersonsCollectionTestBase {

	protected Persons persons;

	@Before
	public void setup() {
		List<String> lines = new LinkedList<String>();
		
		AddressBookLineBuilder builder = new AddressBookLineBuilder();
		builder.setGender(getGender());
		lines.add(builder.build());
		
		persons = new Persons(lines);
	}

	@Test
	public void onePersonInList() {
		assertEquals(1, persons.getCount());
	}
	
	@Test
	public void oldestPerson() {
		assertNotNull(persons.getOldestPerson());
	}

	abstract protected Gender getGender();

	protected Persons getPersonsCollectionWithOneOf() {
		List<String> lines = new LinkedList<String>();
	
		AddressBookLineBuilder builder = new AddressBookLineBuilder();
		builder.setGender(getGender());
		lines.add(builder.build());
		
		Persons persons = new Persons(lines);
		return persons;
	}
}
