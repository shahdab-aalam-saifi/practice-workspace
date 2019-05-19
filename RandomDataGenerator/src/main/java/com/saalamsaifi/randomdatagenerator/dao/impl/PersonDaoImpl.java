package com.saalamsaifi.randomdatagenerator.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.saalamsaifi.randomdatagenerator.dao.PersonDao;
import com.saalamsaifi.randomdatagenerator.model.Person;

@Repository
public class PersonDaoImpl implements PersonDao {
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void create(Person person) {
		entityManager.persist(person);
	}

	@Override
	public void update(Person person) {
		entityManager.merge(person);
	}
}
