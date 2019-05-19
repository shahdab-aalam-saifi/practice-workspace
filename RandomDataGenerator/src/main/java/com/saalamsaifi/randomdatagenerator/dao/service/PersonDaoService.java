package com.saalamsaifi.randomdatagenerator.dao.service;

import javax.transaction.Transactional;

import com.saalamsaifi.randomdatagenerator.dao.impl.PersonDaoImpl;
import com.saalamsaifi.randomdatagenerator.model.Person;

@Transactional
public class PersonDaoService {
	private PersonDaoImpl personDao;
	
	public void create(Person person) {
		personDao.create(person);
	}
	
}
