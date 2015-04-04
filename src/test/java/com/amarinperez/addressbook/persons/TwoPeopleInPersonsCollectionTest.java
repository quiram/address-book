package com.amarinperez.addressbook.persons;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.amarinperez.addressbook.AddressBookLineBuilder;
import com.amarinperez.addressbook.Persons;

public class TwoPeopleInPersonsCollectionTest {
	@Test
	public void getOldestPerson() {
		List<String> lines = new ArrayList<String>();
		AddressBookLineBuilder builder = new AddressBookLineBuilder();

		builder.setName("Young").setDateOfBirth("01/01/2015");
		lines.add(builder.build());

		builder.setName("Old").setDateOfBirth("01/01/1990");
		lines.add(builder.build());

		Persons persons = new Persons(lines);
		assertEquals("Old", persons.getOldestPerson().getName());
	}
}
