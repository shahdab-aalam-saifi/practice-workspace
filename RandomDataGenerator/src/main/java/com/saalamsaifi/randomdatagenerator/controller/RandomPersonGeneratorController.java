package com.saalamsaifi.randomdatagenerator.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.saalamsaifi.randomdatagenerator.model.Person;
import com.saalamsaifi.randomdatagenerator.serviceimpl.PersonServiceImpl;

@RestController
public class RandomPersonGeneratorController {
	private static final String CONTENT_TYPE = "content-type";
	private static final String APPLICATION_JSON = "application/json";
	private ObjectWriter writer = null;

	@Autowired
	private PersonServiceImpl personServiceImpl;

	@RequestMapping(value = "/generate", method = RequestMethod.GET)
	public ResponseEntity<String> getRandomPersons(@RequestParam(name = "size") int size) {
		List<Person> persons = personServiceImpl.randomPersons(size);

		if (writer == null) {
			writer = new ObjectMapper().writer();
		}

		try {
			return ResponseEntity.status(HttpStatus.OK).header(CONTENT_TYPE, APPLICATION_JSON)
					.body(writer.writeValueAsString(persons));
		} catch (JsonProcessingException e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
	}
}
