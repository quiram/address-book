package com.amarinperez.addressbook;

import static org.hamcrest.core.StringContains.containsString;

import static org.junit.Assert.*;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class PersonTest {

	@Rule
	public ExpectedException onBadString = ExpectedException.none();

	@Test
	public void testFailToCreateIfNoSecondField() {
		String line = "lalala";
		failToCreatePerson(line);
	}

	@Test
	public void testFaileToCreateIfSecondFieldNotGender()
	{
		String line = "name, loco";
		failToCreatePerson(line);
	}
	
	private void failToCreatePerson(String line) {
		onBadString.expect(IllegalArgumentException.class);
		onBadString.expectMessage(containsString("gender"));
		new Person(line);
	}
	
	@Test
	public void testCreateIfGoodMaleInput() {
		createPerson("male");
	}

	@Test
	public void testCreateIfGoodFemaleInput()
	{
		createPerson("female");
	}

	@Test
	public void getMaleGender()
	{
		Person person = createPerson("male");
		assertEquals(Gender.MALE, person.getGender());
	}
	
	@Test
	public void getFemaleGender()
	{
		Person person = createPerson("female");
		assertEquals(Gender.FEMALE, person.getGender());
	}

	private Person createPerson(String gender) {
		return new Person("name, " + gender);
	}
	
	
}
