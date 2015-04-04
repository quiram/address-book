package com.amarinperez.addressbook;

public class AddressBookLineBuilder {

	private String gender = "male";
	private String dateOfBirth = "12/09/1985";

	public String build() {
		return "name, " + gender.toString().toLowerCase() + ", " + dateOfBirth;
	}

	public void setGender(Gender gender) {
		this.gender = gender.toString().toLowerCase();

	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
}
