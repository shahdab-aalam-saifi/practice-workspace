package com.saalamsaifi.randomdatagenerator.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.saalamsaifi.randomdatagenerator.model.Person;

@Service
public interface PersonService {
	/**
	 * @return
	 */
	Person randomPerson();

	/**
	 * @param size
	 * @return
	 */
	List<Person> randomPersons(int size);
	
	void create(Person person);
}
