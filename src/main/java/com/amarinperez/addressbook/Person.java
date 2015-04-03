package com.amarinperez.addressbook;

public class Person {

	private Gender gender;
	
	public Person(String line) {
		String[] elements = line.split(",");

		if (elements.length < 2) {
			throwIllegalArgumentExcpetion();
		}

		try {
			gender = Gender.valueOf(elements[1].trim().toUpperCase());
		}
		catch (IllegalArgumentException e) {
			throwIllegalArgumentExcpetion();
		}
	}

	private void throwIllegalArgumentExcpetion() {
		throw new IllegalArgumentException("No valid gender.");
	}

	public Gender getGender() {
		return gender;
		
	}
}
