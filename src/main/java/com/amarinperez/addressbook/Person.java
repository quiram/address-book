package com.amarinperez.addressbook;

import static java.lang.String.format;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoField;

public class Person {

	private String line;
	private String[] elements;

	private String name;
	private Gender gender;
	private LocalDate dateOfBirth;

	private static final String EXPECTED_DATE_FORMAT = "dd/MM/";

	public Person(String line) {
		this.line = line;
		elements = splitLine();

		setName();
		setGender();
		setDateOfBirth();
	}

	public String getName() {
		return name;
	}

	public Gender getGender() {
		return gender;
	}

	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	private String[] splitLine() {
		if (line.trim().equals("")) {
			throwIllegalArgumentExcpetion("name");
		}

		String[] elements = line.split(",");

		if (elements.length < 2) {
			throwIllegalArgumentExcpetion("gender");
		}

		if (elements.length < 3) {
			throwIllegalArgumentExcpetion("date of birth");
		}
		return elements;
	}

	private void throwIllegalArgumentExcpetion(String offendingParameter) {
		throwIllegalArgumentExcpetion(offendingParameter, null);
	}
	
	private void throwIllegalArgumentExcpetion(String offendingParameter, Exception e) {
		throw new IllegalArgumentException(format("No valid %s in '%s'.", offendingParameter, line), e);
	}

	private void setName() {
		name = elements[0];
	}

	private void setGender() {
		try {
			gender = Gender.valueOf(elements[1].trim().toUpperCase());
		}
		catch (IllegalArgumentException e) {
			throwIllegalArgumentExcpetion("gender");
		}
	}

	private void setDateOfBirth() {
		DateTimeFormatterBuilder builder = new DateTimeFormatterBuilder();
		builder.appendPattern(EXPECTED_DATE_FORMAT);
		builder.appendValueReduced(ChronoField.YEAR, 2, 4, 1900);
		
		DateTimeFormatter dateFormat = builder.toFormatter();

		try {
			dateOfBirth = LocalDate.parse(elements[2].trim(), dateFormat);
		}
		catch (DateTimeParseException e) {
			throwIllegalArgumentExcpetion("date of birth", e);
		}
	}
}
