package com.amarinperez.addressbook.person;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.amarinperez.addressbook.AddressBookLineBuilder;
import com.amarinperez.addressbook.Gender;
import com.amarinperez.addressbook.Person;

public class PersonGenderTest {
	private AddressBookLineBuilder builder;

	@Before
	public void setup() {
		builder = new AddressBookLineBuilder();
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
}
