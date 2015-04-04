package com.amarinperez.addressbook.persons;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.amarinperez.addressbook.Gender;
import com.amarinperez.addressbook.Persons;

public class OneMalePersonsCollectionTest extends OnePersonInPersonsCollectionTestBase {
	@Test
	public void getMaleCountWithOneMale() {
		Persons persons = getPersonsCollectionWithOneOf(Gender.MALE);
		assertEquals(1, persons.getMaleCount());
	}

}
