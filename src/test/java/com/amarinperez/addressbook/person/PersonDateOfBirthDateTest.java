package com.amarinperez.addressbook.person;

import static org.junit.Assert.assertEquals;

import java.time.LocalDate;
import java.time.Month;

import org.junit.Test;

import com.amarinperez.addressbook.Person;

public class PersonDateOfBirthDateTest extends PersonTestBase {
	@Test
	public void getDateOfBirth() {
		Person person = createPerson("12/09/1985");
		LocalDate date = LocalDate.of(1985, Month.DECEMBER, 9);

		assertEquals(date, person.getDateOfBirth());
	}

	@Test
	public void getNonDefaultDateOfBirth() {
		Person person = createPerson("01/20/1970");
		LocalDate date = LocalDate.of(1970, Month.JANUARY, 20);

		assertEquals(date, person.getDateOfBirth());
	}

	private Person createPerson(String dateOfBirth) {
		builder.setDateOfBirth(dateOfBirth);

		return new Person(builder.build());
	}
}
