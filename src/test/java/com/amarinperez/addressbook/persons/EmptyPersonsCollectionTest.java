package com.amarinperez.addressbook.persons;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

import com.amarinperez.addressbook.Persons;

public class EmptyPersonsCollectionTest {

	private Persons persons;

	@Before
	public void setup() {
		persons = new Persons(Arrays.asList());
	}

	@Test
	public void zeroCount() {
		assertEquals(0, persons.getCount());
	}

	@Test
	public void noOldestPerson() {
		assertNull(persons.getOldestPerson());
	}

	@Test
	public void noParticularPersonFound() {
		assertNull(persons.getPersonByName("John"));
	}
}
