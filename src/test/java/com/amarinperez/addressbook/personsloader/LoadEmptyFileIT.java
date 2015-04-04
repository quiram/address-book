package com.amarinperez.addressbook.personsloader;

import org.junit.Test;

import com.amarinperez.addressbook.Persons;
import com.amarinperez.addressbook.PersonsLoader;

import static org.junit.Assert.*;

public class LoadEmptyFileIT {

	@Test
	public void totalCountIsZero() {
		String location = "/empty-file";
		PersonsLoader personsLoader = new PersonsLoader(location);
		Persons persons = personsLoader.getPersons();
		assertEquals(0, persons.getCount());
	}
}
