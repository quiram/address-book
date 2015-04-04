package com.amarinperez.addressbook;

import static com.amarinperez.addressbook.AddressBookLineBuilder.*;
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
		assertEquals(getLineForGender(DEFAULT_GENDER), builder.build());
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
	public void caseOfGenderIsPreserved()
	{
		builder.setGender("MALE");
		assertEquals(getLineForGender("MALE"), builder.build());
	}
	
	@Test
	public void setDateOfBirth()
	{
		builder.setDateOfBirth("08/09/1982");
		assertEquals(getLineForDateOfBirth("08/09/1982"), builder.build());
	}
	
	@Test
	public void setName()
	{
		String name = "Manolo";
		builder.setName(name);
		assertEquals(getLineForName(name), builder.build());
	}

	private String getLineForName(String name) {
		return String.join(SEPARATOR, name, DEFAULT_GENDER, DEFAULT_DATE_OF_BIRTH);
	}

	private String getLineForGender(String gender) {
		return String.join(SEPARATOR, DEFAULT_NAME, gender, DEFAULT_DATE_OF_BIRTH);
	}
	
	private String getLineForDateOfBirth(String dateOfBirth)
	{
		return String.join(SEPARATOR, DEFAULT_NAME, DEFAULT_GENDER, dateOfBirth);
	}
	
}
