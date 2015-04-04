package com.amarinperez.addressbook.persons;

import static org.hamcrest.Matchers.containsString;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.amarinperez.addressbook.Persons;

public class EmptyPersonsCollectionTest {

	@Rule
	public ExpectedException onBadInput = ExpectedException.none();

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

	@Test
	public void failToCompareDays() {
		onBadInput.expect(IllegalArgumentException.class);
		onBadInput.expectMessage(containsString("not found"));
		onBadInput.expectMessage(containsString("John"));
		
		persons.getAgeDifferenceBetween("John", "Paul");
	}
}
