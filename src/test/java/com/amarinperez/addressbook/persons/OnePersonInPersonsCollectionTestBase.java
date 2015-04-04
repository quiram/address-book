package com.amarinperez.addressbook.persons;

import static org.junit.Assert.assertEquals;

import java.util.LinkedList;
import java.util.List;

import org.junit.Test;

import com.amarinperez.addressbook.AddressBookLineBuilder;
import com.amarinperez.addressbook.Gender;
import com.amarinperez.addressbook.Persons;

public class OnePersonInPersonsCollectionTestBase {

	@Test
	public void oneCountOnOnePerson() {
		Persons persons = getPersonsCollectionWithOneOf(Gender.MALE);
		assertEquals(1, persons.getCount());
	}

	protected Persons getPersonsCollectionWithOneOf(Gender gender) {
		List<String> lines = new LinkedList<String>();
	
		AddressBookLineBuilder builder = new AddressBookLineBuilder();
		builder.setGender(gender);
		lines.add(builder.build());
		
		Persons persons = new Persons(lines);
		return persons;
	}
}
