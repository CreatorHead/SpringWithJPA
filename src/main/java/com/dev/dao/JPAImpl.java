package com.dev.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.dev.beans.Person;

@Repository
public class JPAImpl implements PersonDAO{
	
	@PersistenceUnit
	private EntityManagerFactory emf;
	
	@Override
	public boolean addPerson(Person person) {
		boolean state = false;
		EntityManager em = null;
		try {
			em = emf.createEntityManager();
			em.getTransaction().begin();
			em.persist(person);
			em.getTransaction().commit();
			state = true;
		}catch(Exception e) {
			e.printStackTrace();
			state = false;
		}finally {
			if(em != null) {
				em.close();
			}
		}
		return state;
	}

	@Override
	public List<Person> searchByName(String name) {
		EntityManager em = emf.createEntityManager();
		String names[] = null;
		if(name.contains(" ")) {
			names = name.split(" ");
		}else {
			names = new String[2];
			names[0] = name;
			names[1] = name;
		}
		String jpql = "SELECT p FROM Person p WHERE p.firstName=:fname OR p.lastName=:lname";
		TypedQuery<Person> query = em
				.createQuery(jpql,Person.class);
		query.setParameter("fname", names[0]);
		query.setParameter("lname", names[1]);
		
		List<Person> list = query.getResultList();
		return list;
	}

}
