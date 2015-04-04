package com.amarinperez.addressbook.persons;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.amarinperez.addressbook.Gender;
import com.amarinperez.addressbook.Persons;

public class OneFemalePersonsCollectionTest extends OnePersonInPersonsCollectionTestBase {
	@Test
	public void getMaleCountWithOneFemale() {
		Persons persons = getPersonsCollectionWithOneOf(Gender.FEMALE);
		assertEquals(0, persons.getMaleCount());
	}
}
