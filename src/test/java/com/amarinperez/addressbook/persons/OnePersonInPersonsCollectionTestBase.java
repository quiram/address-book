package com.amarinperez.addressbook.persons;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.LinkedList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.amarinperez.addressbook.AddressBookLineBuilder;
import com.amarinperez.addressbook.Gender;
import com.amarinperez.addressbook.Person;
import com.amarinperez.addressbook.Persons;

abstract public class OnePersonInPersonsCollectionTestBase {

	protected Persons persons;

	private final String FIRST_NAME = "Lorenzo";
	private final String LAST_NAME = "Fraga";
	private final String FULL_NAME = String.join(" ", FIRST_NAME, LAST_NAME);

	@Before
	public void setup() {
		List<String> lines = new LinkedList<String>();

		AddressBookLineBuilder builder = new AddressBookLineBuilder();
		builder.setGender(getGender()).setName(FULL_NAME);
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

	@Test
	public void findPersonInList() {
		assertNotNull(persons.getPersonByName(FULL_NAME));
	}

	@Test
	public void noResultIfSearchedForNameIsNotInCollection() {
		assertNull(persons.getPersonByName("not in list"));
	}
	
	@Test
	public void canFindPersonOnlyWithBeginningOfName()
	{
		Person person = persons.getPersonByName(FIRST_NAME);
		assertEquals(FULL_NAME, person.getName());
	}

	abstract protected Gender getGender();
}
