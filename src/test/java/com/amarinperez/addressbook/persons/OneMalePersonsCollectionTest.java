package com.amarinperez.addressbook.persons;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.amarinperez.addressbook.Gender;

public class OneMalePersonsCollectionTest extends OnePersonInPersonsCollectionTestBase {
	@Test
	public void oneMaleInList() {
		assertEquals(1, persons.getMaleCount());
	}

	@Override
	protected Gender getGender() {
		return Gender.MALE;
	}
}
