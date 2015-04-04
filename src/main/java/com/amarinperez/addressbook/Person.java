package com.amarinperez.addressbook;

import static java.lang.String.format;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class Person {

	private String line;
	private String[] elements;

	private String name;
	private Gender gender;
	private LocalDate dateOfBirth;

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
			throwIllegalArgumentExcpetion("name", line);
		}

		String[] elements = line.split(",");

		if (elements.length < 2) {
			throwIllegalArgumentExcpetion("gender", line);
		}

		if (elements.length < 3) {
			throwIllegalArgumentExcpetion("date of birth", line);
		}
		return elements;
	}

	private void throwIllegalArgumentExcpetion(String offendingParameter, String line) {
		throw new IllegalArgumentException(format("No valid %s in '%s'.", offendingParameter, line));
	}

	private void setName() {
		name = elements[0];
	}

	private void setGender() {
		try {
			gender = Gender.valueOf(elements[1].trim().toUpperCase());
		}
		catch (IllegalArgumentException e) {
			throwIllegalArgumentExcpetion("gender", line);
		}
	}

	private void setDateOfBirth() {
		DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("MM/dd/yyyy");

		try {
			dateOfBirth = LocalDate.parse(elements[2].trim(), dateFormat);
		}
		catch (DateTimeParseException e) {
			throwIllegalArgumentExcpetion("date of birth", line);
		}
	}
}
