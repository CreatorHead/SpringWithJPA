package com.dev.dao;

import com.dev.beans.Person;

public interface PersonDAO {
	public boolean addPerson(Person person);
	public Person searchByName(String name);
}
