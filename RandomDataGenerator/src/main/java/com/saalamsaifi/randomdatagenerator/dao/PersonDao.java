package com.saalamsaifi.randomdatagenerator.dao;

import com.saalamsaifi.randomdatagenerator.model.Person;

public interface PersonDao {
	void create(Person person);

	void update(Person person);
}
