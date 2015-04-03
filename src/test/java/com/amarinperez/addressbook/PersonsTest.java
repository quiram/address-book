package com.amarinperez.addressbook;

import java.util.LinkedList;
import java.util.List;

import org.junit.Test;

import static org.junit.Assert.*;

public class PersonsTest {

	@Test
	public void zeroCountOnEmptyPersons()
	{
		List<String> lines = new LinkedList<String>();
		
		Persons persons = new Persons(lines);
		assertEquals(0, persons.getCount());
	}
	
	@Test
	public void oneCountOnOnePerson()
	{
		List<String> lines = new LinkedList<String>();
		lines.add("name, male");
		Persons persons = new Persons(lines);
		assertEquals(1, persons.getCount());
	}
	
	@Test
	public void getMaleCountWithOneMale()
	{
		List<String> lines = new LinkedList<String>();
		lines.add("name, male");
		Persons persons = new Persons(lines);
		assertEquals(1, persons.getMaleCount());
	}
	
	@Test
	public void getMaleCountWithOneFemale()
	{
		List<String> lines = new LinkedList<String>();
		lines.add("name, female");
		Persons persons = new Persons(lines);
		assertEquals(0, persons.getMaleCount());
	}
}
