package com.amarinperez.addressbook.person;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.amarinperez.addressbook.Person;

public class PersonNameTest extends PersonTestBase {

	@Test
	public void getName()
	{
		builder.setName("Pedro");
		Person person = new Person(builder.build());
		assertEquals("Pedro", person.getName());
	}
	
	@Test
	public void getDifferentName()
	{
		builder.setName("Pedro Picapiedra");
		Person person = new Person(builder.build());
		assertEquals("Pedro Picapiedra", person.getName());
	}
}
