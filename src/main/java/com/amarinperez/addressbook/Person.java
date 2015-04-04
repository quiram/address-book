package com.amarinperez.addressbook;

import static java.lang.String.format;

public class Person {

	private Gender gender;
	
	public Person(String line) {
		String[] elements = line.split(",");

		if (elements.length < 2) {
			throwIllegalArgumentExcpetion(line);
		}

		try {
			gender = Gender.valueOf(elements[1].trim().toUpperCase());
		}
		catch (IllegalArgumentException e) {
			throwIllegalArgumentExcpetion(line);
		}
	}

	private void throwIllegalArgumentExcpetion(String line) {
		throw new IllegalArgumentException(format("No valid gender in '%s'.", line));
	}

	public Gender getGender() {
		return gender;
		
	}
}
