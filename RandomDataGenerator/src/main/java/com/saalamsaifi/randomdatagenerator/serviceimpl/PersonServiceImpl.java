package com.saalamsaifi.randomdatagenerator.serviceimpl;

import static net.andreinc.mockneat.unit.time.LocalDates.localDates;
import static net.andreinc.mockneat.unit.user.Genders.genders;
import static net.andreinc.mockneat.unit.user.Names.names;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.saalamsaifi.randomdatagenerator.dao.PersonDao;
import com.saalamsaifi.randomdatagenerator.model.Gender;
import com.saalamsaifi.randomdatagenerator.model.Person;
import com.saalamsaifi.randomdatagenerator.service.PersonService;

import net.andreinc.mockneat.types.enums.NameType;

@Component
@Transactional
public class PersonServiceImpl implements PersonService {
	private static final String M = "M";

	@Autowired
	private AddressServiceImpl addressServiceImpl;

	@Autowired
	private PersonDao personDao;

	@Override
	public Person randomPerson() {
		Person person = new Person();

		person.setGender(randomGender());
		person.setDateOfBirth(localDates().get().format(DateTimeFormatter.ISO_DATE));
		person.setLastName(names().last().get());

		if (addressServiceImpl != null) {
			person.setAddress(addressServiceImpl.randomAddress());
		}

		if (person.getGender() != null && person.getGender() == Gender.MALE) {
			person.setFirstName(names().type(NameType.FIRST_NAME_MALE).get());
		} else {
			person.setFirstName(names().type(NameType.FIRST_NAME_FEMALE).get());
		}

		return person;
	}

	@Override
	public List<Person> randomPersons(int size) {
		List<Person> persons = new ArrayList<>();

		Person person;
		for (int i = 0; i < size; i++) {
			person = randomPerson();
			persons.add(person);
			create(person);
		}

		return persons;
	}

	private Gender randomGender() {
		return genders().letter().get().equals(M) ? Gender.MALE : Gender.FEMALE;
	}

	@Override
	public void create(Person person) {
		personDao.create(person);
	}
}
