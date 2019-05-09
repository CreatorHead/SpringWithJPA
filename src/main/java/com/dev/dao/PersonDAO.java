package com.dev.dao;

import java.util.List;

import com.dev.beans.Person;


public interface PersonDAO {
	public boolean addPerson(Person person);
	public List<Person> searchByName(String name);
}
