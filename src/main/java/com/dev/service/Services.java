package com.dev.service;

import java.util.List;

import com.dev.beans.Person;

public interface Services {
	public boolean addPerson(Person person);
	public List<Person> searchByName(String name);
}
