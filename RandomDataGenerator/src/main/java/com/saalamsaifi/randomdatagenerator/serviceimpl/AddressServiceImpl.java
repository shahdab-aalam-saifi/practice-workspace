package com.saalamsaifi.randomdatagenerator.serviceimpl;

import static net.andreinc.mockneat.unit.address.Cities.cities;
import static net.andreinc.mockneat.unit.address.Countries.countries;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.saalamsaifi.randomdatagenerator.dao.AddressDao;
import com.saalamsaifi.randomdatagenerator.model.Address;
import com.saalamsaifi.randomdatagenerator.service.AddressService;

@Component
@Transactional
public class AddressServiceImpl implements AddressService {

	@Autowired
	private AddressDao addressDao;

	@Override
	public Address randomAddress() {
		Address address = new Address();

		address.setCountry(randomCountry());
		address.setCity(cities().us().get());
		create(address);
				
		return address;
	}

	private String randomCountry() {
		return countries().names().list(1).get().toArray(new String[1])[0];
	}

	@Override
	public void create(Address address) {
		addressDao.create(address);
	}
}
