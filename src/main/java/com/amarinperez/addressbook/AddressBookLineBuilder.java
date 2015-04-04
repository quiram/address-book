package com.amarinperez.addressbook;

public class AddressBookLineBuilder {

	private String gender = "male";

	public String build() {
		return "name, " + gender.toString().toLowerCase();
	}

	public void setGender(Gender gender) {
		this.gender = gender.toString().toLowerCase();

	}

	public void setGender(String gender) {
		this.gender = gender;		
	}
}
