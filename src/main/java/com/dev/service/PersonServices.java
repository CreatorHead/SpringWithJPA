package com.dev.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.beans.Person;
import com.dev.dao.PersonDAO;

@Service
public class PersonServices implements Services {
	
	@Autowired
	private PersonDAO dao;
	
	public boolean addPerson(Person person) {
		return dao.addPerson(person);
	}
	
	public List<Person> searchByName(String name){
		return dao.searchByName(name);
	}
}
