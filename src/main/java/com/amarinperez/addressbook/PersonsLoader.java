package com.amarinperez.addressbook;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.commons.io.IOUtils;

public class PersonsLoader {

	List<String> lines;

	public PersonsLoader(String location) {
		InputStream locationInputStream = this.getClass().getResourceAsStream(location);

		if (locationInputStream == null) {
			failToLoadFileBecauseOf(null);
		}

		try {
			lines = IOUtils.readLines(locationInputStream);
		}
		catch (IOException e) {
			failToLoadFileBecauseOf(e);
		}
	}

	private void failToLoadFileBecauseOf(Exception e) {
		throw new IllegalArgumentException("Cannot open data file.", e);
	}

	public Persons getPersons() {
		return new Persons(lines);
	}

}
