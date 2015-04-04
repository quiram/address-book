package com.amarinperez.addressbook;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class PersonsLoader {

	List<String> lines;

	public PersonsLoader(String location) {
		URL fullPath = this.getClass().getResource(location);

		if (fullPath == null) {
			failToLoadFileBecauseOf(null);
		}

		try {
			lines = Files.readAllLines(Paths.get(fullPath.toURI()));
		}
		catch (IOException | URISyntaxException e) {
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
