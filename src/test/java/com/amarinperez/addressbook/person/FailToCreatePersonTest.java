package com.amarinperez.addressbook.person;

import static org.hamcrest.core.StringContains.containsString;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.amarinperez.addressbook.AddressBookLineBuilder;
import com.amarinperez.addressbook.Person;

public class FailToCreatePersonTest {

	@Rule
	public ExpectedException onBadString = ExpectedException.none();
	
	private AddressBookLineBuilder builder;

	@Before
	public void setup() {
		builder = new AddressBookLineBuilder();
	}

	@Test
	public void noGender() {
		String line = "lalala";
		failToCreatePersonWith(line, "gender");
	}

	@Test
	public void noDateOfBirth()
	{
		String line = "lalal, male";
		failToCreatePersonWith(line, "date of birth");
	}

	@Test
	public void invalidGender() {
		builder.setGender("loco");
		failToCreatePersonWith(builder.build(), "gender");
	}
	
	@Test
	public void invalidDateOfBirth() {
		builder.setDateOfBirth("not a date");
		failToCreatePersonWith(builder.build(), "date of birth");
	}
	
	private void failToCreatePersonWith(String line, String parameter) {
		onBadString.expect(IllegalArgumentException.class);
		onBadString.expectMessage(containsString(parameter));
		new Person(line);
	}
}
