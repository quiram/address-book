package com.amarinperez.addressbook.person;

import org.junit.Before;

import com.amarinperez.addressbook.AddressBookLineBuilder;

public class PersonTestBase {

	protected AddressBookLineBuilder builder;

	@Before
	public void setup() {
		builder = new AddressBookLineBuilder();
	}

}
