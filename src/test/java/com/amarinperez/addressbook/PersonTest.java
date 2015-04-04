package com.amarinperez.addressbook;

import static org.hamcrest.core.StringContains.containsString;
import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class PersonTest {

	@Rule
	public ExpectedException onBadString = ExpectedException.none();
	private AddressBookLineBuilder builder;

	@Before
	public void setup() {
		builder = new AddressBookLineBuilder();
	}

	@Test
	public void testFailToCreateIfNoSecondField() {
		String line = "lalala";
		failToCreatePersonWith(line);
	}

	@Test
	public void testFaileToCreateIfSecondFieldNotGender() {
		builder.setGender("loco");
		failToCreatePersonWith(builder.build());
	}

	@Test
	public void getMaleGender() {
		Person person = createPerson("male");
		assertEquals(Gender.MALE, person.getGender());
	}

	@Test
	public void getFemaleGender() {
		Person person = createPerson("female");
		assertEquals(Gender.FEMALE, person.getGender());
	}

	private Person createPerson(String gender) {
		builder.setGender(gender);
		return new Person(builder.build());
	}

	private void failToCreatePersonWith(String line) {
		onBadString.expect(IllegalArgumentException.class);
		onBadString.expectMessage(containsString("gender"));
		new Person(line);
	}
}
