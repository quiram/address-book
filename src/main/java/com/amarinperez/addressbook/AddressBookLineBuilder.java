package com.amarinperez.addressbook;

public class AddressBookLineBuilder {

	public static final String DEFAULT_NAME = "name";
	public static final String DEFAULT_GENDER = "male";
	public static final String DEFAULT_DATE_OF_BIRTH = "12/09/85";
	public static final String SEPARATOR = ", ";

	private String name = DEFAULT_NAME;
	private String gender = DEFAULT_GENDER;
	private String dateOfBirth = DEFAULT_DATE_OF_BIRTH;

	public String build() {
		return String.join(SEPARATOR, name, gender, dateOfBirth);
	}

	public AddressBookLineBuilder setGender(Gender gender) {
		this.gender = gender.toString().toLowerCase();
		return this;
	}

	public AddressBookLineBuilder setGender(String gender) {
		this.gender = gender;
		return this;
	}

	public AddressBookLineBuilder setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
		return this;
	}

	public AddressBookLineBuilder setName(String name) {
		this.name = name;
		return this;
	}
}
