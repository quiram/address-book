package com.amarinperez.addressbook.person;

import static org.hamcrest.Matchers.isA;
import static org.hamcrest.core.StringContains.containsString;

import java.time.format.DateTimeParseException;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.amarinperez.addressbook.AddressBookLineBuilder;
import com.amarinperez.addressbook.Person;

public class FailToCreatePersonTest extends PersonTestBase {

	private static final String DATE_OF_BIRTH_FIELD = "date of birth";
	private static final String GENDER_FIELD = "gender";
	private static final String NAME_FIELD = "name";
	
	@Rule
	public ExpectedException onBadString = ExpectedException.none();

	@Before
	public void setup() {
		builder = new AddressBookLineBuilder();
	}

	@Test
	public void noName() {
		failToCreatePersonWith("", NAME_FIELD);
	}

	@Test
	public void allSpace() {
		failToCreatePersonWith("   ", NAME_FIELD);
	}

	@Test
	public void noGender() {
		failToCreatePersonWith("lalala", GENDER_FIELD);
	}

	@Test
	public void noDateOfBirth() {
		failToCreatePersonWith("lalal, male", DATE_OF_BIRTH_FIELD);
	}

	@Test
	public void invalidGender() {
		builder.setGender("loco");
		failToCreatePersonWith(builder.build(), GENDER_FIELD);
	}

	@Test
	public void invalidDateOfBirth() {
		builder.setDateOfBirth("not a date");
		onBadString.expectCause(isA(DateTimeParseException.class));
		
		failToCreatePersonWith(builder.build(), DATE_OF_BIRTH_FIELD);
	}

	private void failToCreatePersonWith(String line, String parameter) {
		onBadString.expect(IllegalArgumentException.class);
		onBadString.expectMessage(containsString(parameter));
		new Person(line);
	}
}
