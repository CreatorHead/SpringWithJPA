package com.dev.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.dev.beans.Person;

@Repository
public class JPAImpl implements PersonDAO{
	
	@PersistenceUnit
	private EntityManagerFactory emf;
	
	@Override
	public boolean addPerson(Person person) {
		boolean state = false;
		try {
			EntityManager em = emf.createEntityManager();
			em.getTransaction().begin();
			em.persist(person);
			em.getTransaction().commit();
			state = true;
		}catch(Exception e) {
			e.printStackTrace();
			state = false;
		}
		return state;
	}

	@Override
	public Person searchByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

}
