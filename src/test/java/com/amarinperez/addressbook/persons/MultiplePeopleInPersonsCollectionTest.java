package com.amarinperez.addressbook.persons;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.amarinperez.addressbook.AddressBookLineBuilder;
import com.amarinperez.addressbook.Persons;

public class MultiplePeopleInPersonsCollectionTest {
	private static final String OLDEST_NAME = "Old";
	private static final String OLDEST_DOB = "01/01/1990";
	private static final String NAME1 = "Guy day later";
	private static final String DOB1 = "02/01/1990";
	private static final String NAME2 = "Guy month later";
	private static final String DOB2 = "01/02/1990";

	private List<String> lines;
	private Persons persons;

	@Before
	public void setup() {
		lines = new ArrayList<String>();

		addLine(OLDEST_NAME, OLDEST_DOB);
		addLine(NAME1, DOB1);
		addLine(NAME2, DOB2);

		persons = new Persons(lines);
	}

	private void addLine(String name, String dateOfBirth) {
		AddressBookLineBuilder builder = new AddressBookLineBuilder();
		builder.setName(name).setDateOfBirth(dateOfBirth);
		lines.add(builder.build());
	}

	@Test
	public void getOldestPerson() {
		assertEquals(OLDEST_NAME, persons.getOldestPerson().getName());
	}

	@Test
	public void getAgeDifference() {
		long ageDifference = persons.getAgeDifferenceBetween(OLDEST_NAME, NAME1);
		assertEquals(1, ageDifference);
	}

	@Test
	public void getInverseAgeDifference() {
		long ageDifference = persons.getAgeDifferenceBetween(NAME1, OLDEST_NAME);
		assertEquals(-1, ageDifference);
	}

	@Test
	public void getAgeDifferenceForOneMonth() {
		long ageDifference = persons.getAgeDifferenceBetween(OLDEST_NAME, NAME2);
		assertEquals(31, ageDifference);
	}
}
