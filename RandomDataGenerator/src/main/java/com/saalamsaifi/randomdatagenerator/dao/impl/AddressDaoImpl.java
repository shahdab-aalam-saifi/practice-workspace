package com.saalamsaifi.randomdatagenerator.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.saalamsaifi.randomdatagenerator.dao.AddressDao;
import com.saalamsaifi.randomdatagenerator.model.Address;

@Repository
public class AddressDaoImpl implements AddressDao {
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void create(Address address) {
		entityManager.persist(address);
	}

	@Override
	public void update(Address address) {
		entityManager.merge(address);
	}

}
