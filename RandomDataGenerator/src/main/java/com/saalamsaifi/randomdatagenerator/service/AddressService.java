package com.saalamsaifi.randomdatagenerator.service;

import org.springframework.stereotype.Service;

import com.saalamsaifi.randomdatagenerator.model.Address;

@Service
public interface AddressService {
	/**
	 * @return
	 */
	Address randomAddress();
	
	void create(Address address);
}
