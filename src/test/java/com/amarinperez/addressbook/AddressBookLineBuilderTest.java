package com.amarinperez.addressbook;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class AddressBookLineBuilderTest {

	private AddressBookLineBuilder builder;

	@Before
	public void setup() {
		builder = new AddressBookLineBuilder();
	}

	@Test
	public void buildFromEmpty() {
		assertEquals(getLineForGender("male"), builder.build());
	}

	@Test
	public void setGenderToFemale() {
		builder.setGender(Gender.FEMALE);
		assertEquals(getLineForGender("female"), builder.build());
	}

	@Test
	public void setGenderAsString() {
		builder.setGender("alien");
		assertEquals(getLineForGender("alien"), builder.build());
	}
	
	@Test
	public void setDateOfBirth()
	{
		builder.setDateOfBirth("08/09/1982");
		assertEquals("name, male, 08/09/1982", builder.build());
	}

	private String getLineForGender(String gender) {
		return "name, " + gender + ", 12/09/1985";
	}
}
