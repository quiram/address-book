package com.amarinperez.addressbook.personsloader;

import static org.hamcrest.Matchers.containsString;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.amarinperez.addressbook.PersonsLoader;

public class LoadFileThatDoesNotExistIT {

	@Rule
	public ExpectedException onUnknownFile = ExpectedException.none();

	@Test
	public void failToOpenInexistentFile() {
		onUnknownFile.expect(IllegalArgumentException.class);
		onUnknownFile.expectMessage(containsString("open"));

		String location = "file-does-not-exist";
		new PersonsLoader(location);
	}
}
