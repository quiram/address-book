package com.amarinperez.addressbook.persons;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.amarinperez.addressbook.Gender;

public class OneFemalePersonsCollectionTest extends OnePersonInPersonsCollectionTestBase {
	@Test
	public void noMalesInList() {
		assertEquals(0, persons.getMaleCount());
	}

	@Override
	protected Gender getGender() {
		return Gender.FEMALE;
	}
}
