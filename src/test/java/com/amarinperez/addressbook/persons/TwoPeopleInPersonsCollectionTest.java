package com.amarinperez.addressbook.persons;

import static org.junit.Assert.assertEquals;

import java.time.Period;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.amarinperez.addressbook.AddressBookLineBuilder;
import com.amarinperez.addressbook.Persons;

public class TwoPeopleInPersonsCollectionTest {
	private Persons persons;
	
	@Before
	public void setup()
	{
		List<String> lines = new ArrayList<String>();
		AddressBookLineBuilder builder = new AddressBookLineBuilder();

		builder.setName("Young").setDateOfBirth("02/01/1990");
		lines.add(builder.build());

		builder.setName("Old").setDateOfBirth("01/01/1990");
		lines.add(builder.build());

		persons = new Persons(lines);
	}

	@Test
	public void getOldestPerson() {
		assertEquals("Old", persons.getOldestPerson().getName());
	}
	
	@Test
	public void getAgeDifference()
	{
		Period ageDifference = persons.getAgeDifferenceBetween("Old", "Young");
		assertEquals(1, ageDifference.getDays());
	}
	
	@Test
	public void getInverseAgeDifference()
	{
		Period ageDifference = persons.getAgeDifferenceBetween("Young", "Old");
		assertEquals(-1, ageDifference.getDays());
	}
}
